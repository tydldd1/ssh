/**
 * 版本信息：Copyright ru Corporation 2013 
 * 版权所有
 *
 */
package com.ru.javaExam.thread;

import org.junit.Test;

/**
 * 
 * 项目名称：ssh0605
 * 类描述：继承Thread线程实例
 * 创建人：成如
 * 创建时间：2013-8-30 下午2:25:17
 * 修改人：成如
 * 修改时间：2013-8-30 下午2:25:17
 * 修改备注：
 * @since jdk1.7
 * @version 1.0
 */
public class ThreadTest extends Thread{

	public void test(){
		Thread th = new Thread();
	}
	
	/* (方法重写)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++){
			System.out.println(getName() + "---" + i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		
		//1.启动第一个线程
		ThreadTest tt1 = new ThreadTest();
		
		for(int i = 0; i < 100; i++){
			
			System.out.println("main---" + Thread.currentThread().getName());
			if(i == 20){
				//1.启动第一个线程
				tt1.setName("线程1");
				tt1.start();
				//2、启动第二个线程
				ThreadTest tt2 = new ThreadTest();
				tt2.setName("线程2");
				tt2.start();
				tt2.join();//调用tt2的join方法的main线程等待，知道tt2执行完成才执行。但tt1和tt2可以交互执行。
			}
			
		}
	}
}
