package com.ru.javaExam.io_18;
	import java.io.BufferedInputStream;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.OutputStream;
	import java.util.Date;
	import java.util.Properties;

	/**
	 * @author �ϳ���
	 * @lastModeify 2013-2-19
	 */
	public class OperProperties {
		
		/**
		 * ͨ��key�õ�value
		 * @param key filePath
		 * @return value
		 */
		public static String readData(String key,String filePath) {
			Properties props = new Properties();
			try {
				InputStream in = new BufferedInputStream(new FileInputStream(filePath));
				props.load(in);
				in.close();
				String value = props.getProperty(key);
				return value;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		
		/**
		 * 
		 * ��properties�ļ�д��value
		 * @param key ��value , filePath
		 * @return null
		 */
		public static void writeData(String key, String value,String filePath) {
			Properties prop = new Properties();
			try {
				File file = new File(filePath);
				if (!file.exists())
					file.createNewFile();
				InputStream fis = new FileInputStream(file);
				prop.load(fis);
				fis.close();//�ر�������
				OutputStream fos = new FileOutputStream(filePath);
				prop.setProperty(key, value);
				prop.store(fos, "Update '" + key + "' value");
				fos.close();
			} catch (IOException e) {
				System.err.println("Visit " + filePath + " for updating "
						+ value + " value error");
			}
		}
	}
