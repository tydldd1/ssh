/**
 * 文件名：ZipInputStreamExam.java
 *
 * 版本信息：
 * 日期：2013年10月31日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.tools.ant.types.ZipFileSet;
import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：压缩解压文件
 * 创建人：成如
 * 创建时间：2013年10月31日 下午10:25:51
 * 修改人：成如
 * 修改时间：2013年10月31日 下午10:25:51
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class ZipInputStreamExam {

	
	/**
	 * 
	 * compressFiles(压缩多个文件)
	 * @param destPath
	 * @param files
	 * @return void
	 * @throws IOException 
	 */
	public static void compressFiles(String destPath, String... files) throws IOException{
		ZipOutputStream zos = null;
		InputStream is = null;
		byte[] buffer = new byte[1024];//缓冲数组
		try {
			//创建zip流，并使用CRC32设置冗余校验码
			zos = new ZipOutputStream(new CheckedOutputStream(new FileOutputStream(destPath), new CRC32()));
			
			for(String file : files){
				File newFile = new File(file);
				if(!newFile.exists()){
					break;
				}
				//将需要压缩的文件放入zos中
				ZipEntry ze = new ZipEntry(file);
				zos.putNextEntry(ze);
				
				is = new FileInputStream(newFile);
				
				int length = 0;
				while((length = is.read(buffer)) != -1){
					zos.write(buffer, 0, length);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(zos != null){
				zos.close();
			}
			if(is != null){
				is.close();
			}
			
		}
	}
	
	/**
	 * 
	 * uncompress(解压文件)
	 * @param zipFile
	 * @param destDir
	 * @return void
	 */
	public static void uncompress(String zipFileStr, String destDirStr){
		File zipFile = new File(zipFileStr);
		if(!zipFile.exists()){
			return;
		}
		
		File destDir = new File(destDirStr);
		if(!(destDir.exists())){
			destDir.mkdirs();
		}
		
		ZipInputStream zis = null;
		FileOutputStream fos = null;
		byte[] buffer = new byte[1024];
		try {
			zis = new ZipInputStream(new FileInputStream(zipFile));
			fos = new FileOutputStream(destDir);
			int length = 0;
			while((length = zis.read(buffer)) != -1){
				fos.write(buffer, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException{
		String basePath = "G:/test/ru";
		//生成压缩文件
		String DESTPATH = "G:/test/compress.zip";
		String SOURCEPATH1 = "G:/test/music.mp3";
		String SOURCEPATH2 = "G:/test/ru1.java";
		String SOURCEPATH3 = "G:/test/music.zip";
		/*compressFiles(DESTPATH, SOURCEPATH1, SOURCEPATH2, SOURCEPATH3);*/
		
		//解压文件
		uncompress(DESTPATH, basePath);
	}
}
