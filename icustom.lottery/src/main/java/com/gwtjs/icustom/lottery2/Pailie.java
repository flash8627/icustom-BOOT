package com.gwtjs.icustom.lottery2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Pailie {

	public static void main(String[] args) throws IOException {
		//arrangementSelect(new String[] { "1", "2", "3", "4" }, 2);
		String fileName = "D:\\aaa.txt";
		FileManager.delFile(fileName);
		
		FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        
        try {
            File file = new File(fileName);//�ļ�·��(�����ļ�����)
            if(!file.exists()){
                file.createNewFile();
            }
            //���ļ�����������
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            
            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            combinationSelect(
    				//��Ҫ���е�����
    				new String[] { "1", "2", "3", "4", "5" ,"6" ,"7" ,"8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33"}, 
    				0, 
    				//ѡ6������Ϊһ��
    				new String[6], 
    				0,pw);
            pw.flush();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            //��Ҫ���ǹر�
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
        
		
		
	}

	/**
	 * ����ѡ�񣨴��б���ѡ��n�����У�
	 * 
	 * @param dataList
	 *            ��ѡ�б�
	 * @param n
	 *            ѡ�����
	 */
	public static void arrangementSelect(String[] dataList, int n) {
		System.out.println(String.format("A(%d, %d) = %d", dataList.length, n, arrangement(dataList.length, n)));
		arrangementSelect(dataList, new String[n], 0);
	}

	/**
	 * ����ѡ��
	 * 
	 * @param dataList
	 *            ��ѡ�б�
	 * @param resultList
	 *            ǰ�棨resultIndex-1���������н��
	 * @param resultIndex
	 *            ѡ����������0��ʼ
	 */
	private static void arrangementSelect(String[] dataList, String[] resultList, int resultIndex) {
		int resultLen = resultList.length;
		if (resultIndex >= resultLen) { // ȫ��ѡ����ʱ��������н��
			System.out.println(Arrays.asList(resultList));
			return;
		}

		// �ݹ�ѡ����һ��
		for (int i = 0; i < dataList.length; i++) {
			// �жϴ�ѡ���Ƿ���������н����
			boolean exists = false;
			for (int j = 0; j < resultIndex; j++) {
				if (dataList[i].equals(resultList[j])) {
					exists = true;
					break;
				}
			}
			if (!exists) { // ���н�������ڸ���ſ�ѡ��
				resultList[resultIndex] = dataList[i];
				arrangementSelect(dataList, resultList, resultIndex + 1);
			}
		}
	}

	/**
	 * ���ѡ��
	 * 
	 * @param dataList
	 *            ��ѡ�б�
	 * @param dataIndex
	 *            ��ѡ��ʼ����
	 * @param resultList
	 *            ǰ�棨resultIndex-1��������Ͻ��
	 * @param resultIndex
	 *            ѡ����������0��ʼ
	 */
	private static void combinationSelect(String[] dataList, int dataIndex, String[] resultList, int resultIndex,PrintWriter pw) {
		int resultLen = resultList.length;
		int resultCount = resultIndex + 1;
		if (resultCount > resultLen) { // ȫ��ѡ����ʱ�������Ͻ��
			//System.out.println(Arrays.asList(resultList).toString());
			//FileManager.createFile("aaa", Arrays.asList(resultList).toString());
			pw.write((Arrays.asList(resultList)+"\r\n").toString().toCharArray());
			return;
		}

		// �ݹ�ѡ����һ��
		for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {
			resultList[resultIndex] = dataList[i];
			combinationSelect(dataList, i + 1, resultList, resultIndex + 1,pw);
		}
	}

	/**
	 * ����׳�������n! = n * (n-1) * ... * 2 * 1
	 * 
	 * @param n
	 * @return
	 */
	public static long factorial(int n) {
		return (n > 1) ? n * factorial(n - 1) : 1;
	}

	/**
	 * ��������������A(n, m) = n!/(n-m)!
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static long arrangement(int n, int m) {
		return (n >= m) ? factorial(n) / factorial(n - m) : 0;
	}

	/**
	 * �������������C(n, m) = n!/((n-m)! * m!)
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static long combination(int n, int m) {
		return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
	}
}
