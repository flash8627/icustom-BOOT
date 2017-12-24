package com.gwtjs.icustom.kindeditor.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gwtjs.icustom.kindeditor.entity.UploadFile;
import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

@Controller
@RequestMapping("/kindeditor")
public class KindEditorController {

	private static final ICustomLogger log = ICustomLoggerFactory.getLogger(KindEditorController.class);
	
	private String fileMaxSize = "1000000M";

	/**
	 * 文件上传功能
	 */
	@ResponseBody
	@RequestMapping(value = "/fileUpload")
	public Map<String, Object> fileUpload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, FileUploadException {
		// 这里的路径可以是绝对路径，也可以获取项目下的目录，这里使用的是绝对路径;
		// String savePath = request.getServletContext().getRealPath("/")+"yourPath/" ;
		String savePath = "target" + "/";
		// 这里的路径需要符合下面另一个RequestMapping方法
		String saveUrl = request.getContextPath() + "/kindeditor/";
		// 定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

		// 最大文件大小
		//long maxSize = 1000000;

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (!ServletFileUpload.isMultipartContent(request)) {
			return getError("请选择文件。");
		}
		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		if (!extMap.containsKey(dirName)) {
			return getError("目录名不正确。");
		}
		// 创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		// 这里需要后台springmvc-servlet.xml配置multipartResolver
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		multipartRequest.setCharacterEncoding("UTF-8");
		MultipartFile qqfile = multipartRequest.getFiles("imgFile").get(0);
		String oldName = qqfile.getOriginalFilename();
		String ext = qqfile.getOriginalFilename().substring(oldName.lastIndexOf(".") + 1);
		if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(ext)) {

			return getError("<font size='3'>非常抱歉，目前上传附件格式类型只允许为：<br/>" + extMap.get(dirName) + "，你选择的文件【" + oldName
					+ "】不符合要求，无法上传！</font>");
		}
		String fileSizeNumber = fileMaxSize.substring(0, fileMaxSize.indexOf("M"));
		if (qqfile.getSize() > Long.valueOf(fileSizeNumber) * 1000 * 1000) {
			return getError("<font size='3'>您选择的文件【" + oldName + "】大小超过" + fileMaxSize + "限制，无法上传！</font>");
		}

		String fileName = null;
		UploadFile uploadFile = null;
		String size = this.calculateFileSize(qqfile.getSize());
		try {
			String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			fileName = this.upload(qqfile, savePath);
			uploadFile = new UploadFile();
			uploadFile.setName(oldName);
			uploadFile.setPath(savePath + fileName);
			uploadFile.setSize(size);
			uploadFile.setCreateTime(createTime);
			uploadFile.setExt(ext);
			//service.save(uploadFile);
			Map<String, Object> succMap = new HashMap<String, Object>();
			succMap.put("error", 0);
			succMap.put("url", saveUrl + fileName);
			return succMap;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return getError("<font size='3'>您选择的文件【" + oldName + "】上传失败！原因是：" + e.getMessage() + "</font>");
		}
	}

	private Map<String, Object> getError(String message) {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("error", 1);
		msg.put("message", message);
		return msg;
	}

	/**
	 * 图片/文件空间管理功能
	 */
	@ResponseBody
	@RequestMapping(value = "/fileManage")
	public Object fileManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 根目录路径，可以指定绝对路径，比如 /var/www/
		String rootPath = "target/";
		// 根目录URL，可以指定绝对路径，比如 http://www.yoursite.com/
		String rootUrl = request.getContextPath() + "/kindeditor/";
		// 图片扩展名
		String[] fileTypes = new String[] { "gif", "jpg", "jpeg", "png", "bmp" };

		String dirName = request.getParameter("dir");
		if (dirName != null) {
			if (!Arrays.<String>asList(new String[] { "image", "flash", "media", "file" }).contains(dirName)) {
				return "Invalid Directory name.";
			}
			rootPath += dirName + "/";
			rootUrl += dirName + "/";
			File saveDirFile = new File(rootPath);
			if (!saveDirFile.exists()) {
				saveDirFile.mkdirs();
			}
		}
		// 根据path参数，设置各路径和URL
		String path = request.getParameter("path") != null ? request.getParameter("path") : "";
		String currentPath = rootPath + path;
		String currentUrl = rootUrl + path;
		String currentDirPath = path;
		String moveupDirPath = "";
		if (!"".equals(path)) {
			String str = currentDirPath.substring(0, currentDirPath.length() - 1);
			moveupDirPath = str.lastIndexOf("/") >= 0 ? str.substring(0, str.lastIndexOf("/") + 1) : "";
		}

		// 排序形式，name or size or type
		String order = request.getParameter("order") != null ? request.getParameter("order").toLowerCase() : "name";

		// 不允许使用..移动到上一级目录
		if (path.indexOf("..") >= 0) {
			return "Access is not allowed.";
		}
		// 最后一个字符不是/
		if (!"".equals(path) && !path.endsWith("/")) {
			return "Parameter is not valid.";
		}
		// 目录不存在或不是目录
		File currentPathFile = new File(currentPath);
		if (!currentPathFile.isDirectory()) {
			return "Directory does not exist.";
		}

		// 遍历目录取的文件信息
		List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();
		if (currentPathFile.listFiles() != null) {
			for (File file : currentPathFile.listFiles()) {
				Hashtable<String, Object> hash = new Hashtable<String, Object>();
				String fileName = file.getName();
				if (file.isDirectory()) {
					hash.put("is_dir", true);
					hash.put("has_file", (file.listFiles() != null));
					hash.put("filesize", 0L);
					hash.put("is_photo", false);
					hash.put("filetype", "");
				} else if (file.isFile()) {
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					hash.put("is_dir", false);
					hash.put("has_file", false);
					hash.put("filesize", file.length());
					hash.put("is_photo", Arrays.<String>asList(fileTypes).contains(fileExt));
					hash.put("filetype", fileExt);
				}
				hash.put("filename", fileName);
				hash.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
				fileList.add(hash);
			}
		}

		if ("size".equals(order)) {
			Collections.sort(fileList, new SizeComparator());
		} else if ("type".equals(order)) {
			Collections.sort(fileList, new TypeComparator());
		} else {
			Collections.sort(fileList, new NameComparator());
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("moveup_dir_path", moveupDirPath);
		result.put("current_dir_path", currentDirPath);
		result.put("current_url", currentUrl);
		result.put("total_count", fileList.size());
		result.put("file_list", fileList);

		return result;
	}

	private class NameComparator implements Comparator<Map<String, Object>> {
		public int compare(Map<String, Object> hashA, Map<String, Object> hashB) {
			if (((Boolean) hashA.get("is_dir")) && !((Boolean) hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean) hashA.get("is_dir")) && ((Boolean) hashB.get("is_dir"))) {
				return 1;
			} else {
				return ((String) hashA.get("filename")).compareTo((String) hashB.get("filename"));
			}
		}
	}

	private class SizeComparator implements Comparator<Map<String, Object>> {
		public int compare(Map<String, Object> hashA, Map<String, Object> hashB) {
			if (((Boolean) hashA.get("is_dir")) && !((Boolean) hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean) hashA.get("is_dir")) && ((Boolean) hashB.get("is_dir"))) {
				return 1;
			} else {
				if (((Long) hashA.get("filesize")) > ((Long) hashB.get("filesize"))) {
					return 1;
				} else if (((Long) hashA.get("filesize")) < ((Long) hashB.get("filesize"))) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}

	private class TypeComparator implements Comparator<Map<String, Object>> {
		public int compare(Map<String, Object> hashA, Map<String, Object> hashB) {
			if (((Boolean) hashA.get("is_dir")) && !((Boolean) hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean) hashA.get("is_dir")) && ((Boolean) hashB.get("is_dir"))) {
				return 1;
			} else {
				return ((String) hashA.get("filetype")).compareTo((String) hashB.get("filetype"));
			}
		}
	}
	
	/**
	 * 处理文件上传
	 *
	 * @param file
	 * @param absPath
	 *            存放文件的目录的绝对路径
	 * @return
	 */
	public String upload(MultipartFile file, String absPath) {
		long fileTimeStamp = new Date().getTime() + new Random().nextInt(100000);
		String fileName = fileTimeStamp + "-" + file.getOriginalFilename();
		try {
			File targetFile = new File(absPath, fileName);
			FileUtils.writeByteArrayToFile(targetFile, file.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}

	public String calculateFileSize(long size) {
		// 字节数少于1024，直接以B为单位
		if (size < 1024) {
			return String.valueOf(size) + "B";
		} else {
			size = size / 1024;
		}
		// 字节数除于1024之后，少于1024，则可直接以KB作为单位
		if (size < 1024) {
			return String.valueOf(size) + "KB";
		} else {
			size = size / 1024;
		}
		if (size < 1024) {
			// 以MB为单位的话，保留最后1位小数
			size = size * 100;
			return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "MB";
		} else {
			// 以GB为单位
			size = size * 100 / 1024;
			return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "GB";
		}

	}

	/**
	 * 删除文件
	 * 
	 * @param fileAbsSavePath
	 *            要删除的图片的绝对保存路径
	 */
	public static void deleteFile(String fileAbsSavePath) {
		File file = new File(fileAbsSavePath);
		if (file.exists())
			file.delete();
	}

	/**
	 * 根据文件名获取ContentType
	 * 
	 * @param suffix
	 *            文件名后缀
	 * @return ContentType
	 */
	public static String getContentType(String suffix) {

		/*fileName.substring(fileName.lastIndexOf(".") + 1);if (!StringUtils.isEmpty(suffix)) {
			// uploadProps是properties对象获取配置文件里的文件名后缀对应的ContentType，
			// contentType.proerties文件在本文末尾
			Object contentType = uploadProps.get(suffix);
			if (contentType != null)
				return contentType.toString();
		}*/
		return "text/html";
	}

	@RequestMapping(value = "/{fileType}/{uploadDate}/{fileName}.{suffix}")
	public void attached(HttpServletRequest request, HttpServletResponse response, @PathVariable String fileType,
			@PathVariable String uploadDate, @PathVariable String suffix, @PathVariable String fileName) {

		// 根据suffix设置响应ContentType
		response.setContentType("text/html");

		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File("target/" + fileType + "/" + uploadDate + "/" + fileName + "." + suffix);
			is = new FileInputStream(file);
			byte[] buffer = new byte[is.available()];
			is.read(buffer);

			os = new BufferedOutputStream(response.getOutputStream());
			os.write(buffer);
			os.flush();
		} catch (Exception e) {
			// 判断suffix
			// 图片请求可以在此显示一个默认图片
			// file显示文件已损坏等错误提示...
			log.error("读取文件失败", e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error("读取文件失败", e);
				}

				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						log.error("读取文件失败", e);
					}
				}
			}
		}

	}

	/**
	 * 图片空间删除功能
	 */
	@ResponseBody
	@RequestMapping("deleteImg")
	public Map<String,Object> deleteImg(String url) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("res", 0);
		if (!StringUtils.isEmpty(url)) {

			String absPath = "target" + url.replace("/kindeditor", "");
			/*UploadFileUtil.deleteFile(absPath);
			service.deleteByPath(absPath);*/
			map.put("res", 1);
			map.put("path", absPath);
		}
		return map;
	}

}
