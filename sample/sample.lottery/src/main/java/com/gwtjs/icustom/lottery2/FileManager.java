package com.gwtjs.icustom.lottery2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ϧ����-O
 * @version 2016��7��8�� ����10:38:49
 */
public class FileManager {
	// �����ļ�·��
	private static String path = "D:\\";

	// �ļ�·��+����
	private static String filenameTemp;

	/**
	 * �����ļ�
	 * 
	 * @param fileName
	 *            �ļ�����
	 * @param filecontent
	 *            �ļ�����
	 * @return �Ƿ񴴽��ɹ����ɹ��򷵻�true
	 */
	public static boolean createFile(String fileName, String filecontent) {
		Boolean bool = false;
		filenameTemp = path + fileName + ".txt";// �ļ�·��+����+�ļ�����
		File file = new File(filenameTemp);
		try {
			// ����ļ������ڣ��򴴽��µ��ļ�
			if (!file.exists()) {
				file.createNewFile();
				bool = true;
				// �����ļ��ɹ���д�����ݵ��ļ���
			}
			writeFileContent(filenameTemp, filecontent);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bool;
	}

	/**
	 * ���ļ���д������
	 * 
	 * @param filepath
	 *            �ļ�·��������
	 * @param newstr
	 *            д�������
	 * @return
	 * @throws IOException
	 */
	public static boolean writeFileContent(String filepath, String newstr) throws IOException {
		Boolean bool = false;
		String filein = newstr + "\r\n";// ��д����У�����
		String temp = "";

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		FileOutputStream fos = null;
		PrintWriter pw = null;
		try {
			File file = new File(filepath);// �ļ�·��(�����ļ�����)
			// ���ļ�����������
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();

			// �ļ�ԭ������
			for (int i = 0; (temp = br.readLine()) != null; i++) {
				buffer.append(temp);
				// ������֮��ķָ��� �൱�ڡ�\n��
				buffer = buffer.append(System.getProperty("line.separator"));
			}
			buffer.append(filein);

			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			pw.write(buffer.toString().toCharArray());
			pw.flush();
			bool = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// ��Ҫ���ǹر�
			if (pw != null) {
				pw.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		return bool;
	}

	/**
	 * ɾ���ļ�
	 * 
	 * @param fileName
	 *            �ļ�����
	 * @return
	 */
	public static boolean delFile(String fileName) {
		Boolean bool = false;
		filenameTemp = fileName;
		System.out.println(filenameTemp);
		File file = new File(filenameTemp);
		try {
			if (file.exists()) {
				file.delete();
				bool = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bool;
	}

	/**
	 * ��includeFileName�н�excludeFileName�е�����޳������ɵ�resultFileName��
	 * @param includeFileName
	 * @param excludeFileName
	 * @param resultFileName
	 */
	public static void compareFile(String includeFileName, String excludeFileName, String resultFileName) {
		try
		{
			//����ļ�
			File result = new File(resultFileName);
			if(!result.exists())
			{
				result.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(result);
			PrintWriter pw = new PrintWriter(fos);
			StringBuffer sb = new StringBuffer();
			//�ų�����
			File excludeFile = new File(excludeFileName);
			FileInputStream excludeFileInputStream = new FileInputStream(excludeFile);
			InputStreamReader excludeFileInputStreamReader = new InputStreamReader(excludeFileInputStream);
			BufferedReader excludeFileBR = new BufferedReader(excludeFileInputStreamReader);
			String tempEx="";
			ArrayList<String> excludeList = new ArrayList<String>();
			for(int i = 0;(tempEx = excludeFileBR.readLine()) != null; i++)
			{
				excludeList.add(tempEx);
			}
			excludeFileBR.close();
			//���ų�����
			File includeFile = new File(includeFileName);
			FileInputStream includeFileInputStream = new FileInputStream(includeFile);
			InputStreamReader includeFileInputStreamReader = new InputStreamReader(includeFileInputStream);
			BufferedReader includeFileBR = new BufferedReader(includeFileInputStreamReader);
			String temp="";
			for(int i = 0;(temp = includeFileBR.readLine()) != null; i++)
			{
				if(excludeList.indexOf(temp)>-1)
				{
					continue;
				}
				sb.append(temp+"\r\n");
			}
			pw.write(sb.toString().toCharArray());
			pw.flush();
			pw.close();
			includeFileBR.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		compareFile("D:\\aaa.txt","D:\\bbb.txt","D:\\ccc.txt");
	}
}