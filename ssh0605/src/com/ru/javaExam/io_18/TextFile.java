package com.ru.javaExam.io_18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

/**
 * 将文件按照字符串读取，写入内存，进行读写操作
 * @author 南成�?
 * @time 2013-2-9
 * */
public class TextFile {
	String readPath="D:\\测试文件\\b.txt";
	String writePath="E:\\测试文件\\b.txt";
	String text="qqqqqqqqqqqqqqwwwwwwwwwwwwwwwwwwweeeeeeeeeeeeeeeeeerrrrrrrrrrrrrrrrrtttttttttt!";
	/**
	 * 按字符串读文�?
	 * @param String filePath
	 * @return sb
	 * */
	@Test
	public void read() throws IOException{
		StringBuffer sb=new StringBuffer();
		String s="";
		BufferedReader br=null;
		try {
			br=new BufferedReader(new FileReader(new File(readPath)));//字符输入�?
			while((s=br.readLine())!=null&&(s=br.readLine())!=""){
				sb.append(s);
				sb.append("\n");
			}
			System.out.println("sb="+sb);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			br.close();
		}
	//	return sb;
	}
	/**
	 * 将字符串写入文件
	 * @param String text
	 * */
	@Test
	public void write(){
		PrintWriter pw=null;
		try {
			//PrintWriter添加了方便的构�?器，可以方便的进行写入操�?
			pw=new PrintWriter(new File(writePath));
			pw.print(text);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}
}
