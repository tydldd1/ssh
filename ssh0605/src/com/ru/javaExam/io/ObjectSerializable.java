/**
 * 文件名：ObjectSerializable.java
 *
 * 版本信息：
 * 日期：2013年11月5日
 * Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import com.ru.ssh.JSOperate.entity.Student;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：对象序列化（将内存中对象以二进制流方式存储在硬盘或在网络传输）
 * 创建人：成如
 * 创建时间：2013年11月5日 下午10:06:44
 * 修改人：成如
 * 修改时间：2013年11月5日 下午10:06:44
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class ObjectSerializable {

	/**
	 * 
	 * ObjectOutputStream1()
	 * @return void
	 * @throws IOException 
	 */
	public static void ObjectOutputStream1() throws IOException{
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("student-seria.java"));
			
			Student stu = new Student();
			stu.setAge(24);
			stu.setName("ruge");
			
			//将stu输出到文件
			oos.writeObject(stu);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(oos != null){
				oos.close();
			}
		}
	}
}
