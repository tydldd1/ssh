/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.utildatabase;

import org.junit.Test;

import com.ru.javaExam.string.StringUtil;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：
 * 创建人：成如
 * 创建时间：2013-10-12 下午2:14:08
 * 修改人：成如
 * 修改时间：2013-10-12 下午2:14:08
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class Example {
	public static void main(String[] args){
		String sql = "INSERT INTO tbuserlogger (logger_id,descr) VALUES (?,?)";
		boolean isInsert = JdbcUtil.insertBatch(sql,200000);
		System.out.println(isInsert);
	}
	
	/*@Test
	public void test1(){
		String sql = "select * from ";
		queryTest();
	}*/
}
