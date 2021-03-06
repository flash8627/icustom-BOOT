package com.gwtjs.icustom.attachments.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller @RequestMapping("/attachments")
public class FileDownloadController {

	@RequestMapping(value = { "/download", "/downloads" }, method = RequestMethod.GET)
	public String getHomePage(ModelMap model) {
		return "index";
	}

	/*
	 * Download a file from - inside project, located in resources folder. -
	 * outside project, located in File system somewhere.
	 */
	@RequestMapping(value = "/download/{type}", method = RequestMethod.GET)
	public void downloadFile(HttpServletRequest request,HttpServletResponse response, @PathVariable("type") String type) throws IOException {
		
		String filepath = request.getParameter("filepath");
		
		File file = null;
		System.out.println("filetype:" + type);
		System.out.println("filepath:" + filepath);
		
		String path = request.getSession().getServletContext().getRealPath(filepath);
		System.out.println("=========>>>>>>"+path);
		
		if (type.equalsIgnoreCase("internal")) {
			/*
			 * 待扩展ClassLoader classloader =
			 * Thread.currentThread().getContextClassLoader(); String filepath =
			 * classloader.getResource(INTERNAL_FILE).getFile();
			 * System.out.println("filepath:"+filepath); file = new
			 * File(filepath);
			 */
		} else {
			file = new File(filepath);
		}

		if (!file.exists()) {
			String errorMessage = "Sorry. The file you are looking for does not exist";
			System.out.println(errorMessage);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}

		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if (mimeType == null) {
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}

		System.out.println("mimetype : " + mimeType);

		response.setContentType(mimeType);

		/*
		 * "Content-Disposition : inline" will show viewable types [like
		 * images/text/pdf/anything viewable by browser] right on browser while
		 * others(zip e.g) will be directly downloaded [may provide save as
		 * popup, based on your browser setting.]
		 */
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

		/*
		 * "Content-Disposition : attachment" will be directly download, may
		 * provide save as popup, based on your browser setting
		 */
		// response.setHeader("Content-Disposition", String.format("attachment;
		// filename=\"%s\"", file.getName()));

		response.setContentLength((int) file.length());

		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

		// Copy bytes from source to destination(outputstream in this example),
		// closes both streams.
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}

}