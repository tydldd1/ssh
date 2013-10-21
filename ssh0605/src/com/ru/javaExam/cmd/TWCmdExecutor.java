package com.ru.javaExam.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * .
 * <p>
 * -----------------------------------------------------------------------------
 * <p>
 * 工程名 ： FGapTac
 * <p>
 * 授权 : (C) Copyright topwalk Corporation 2006-2011
 * <p>
 * 公司 : 北京天行网安信息技术有限责任公司
 * <p>
 * -----------------------------------------------------------------------------
 * <p>
 * <font color="#FF0000">注意: 本内容仅限于北京天行网安公司内部使用，禁止转发</font>
 * <p>
 * 
 * @version 1.0
 * @author zhanggang
 * @lastMonify 2011-7-21
 * @since JDK1.6
 */
public class TWCmdExecutor {

	/**
	 * 执行外部命令，没有返回值
	 * 
	 * @param cmd
	 *            外部命令的字符串
	 */
	public static void exeCmd(String cmd) {

		Runtime rt = Runtime.getRuntime();
		String str[] = { "/bin/sh", "-c", cmd };
		Process pcs = null;
		BufferedReader br = null;
		String line = new String();
		StringBuffer buff = new StringBuffer();
		try {
			pcs = rt.exec(str);
			br = new BufferedReader(new InputStreamReader(pcs.getInputStream()));
			while ((line = br.readLine()) != null) {
				buff.append(line).append("\n");
			}
			pcs.waitFor();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("processes was interrupted");
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {
			}
			if (pcs != null) {
				@SuppressWarnings("unused")
				int ret = pcs.exitValue();
			}
		}
		// return buff.toString();

	}

	/**
	 * 执行外部命令，返回是否执行成功
	 * 
	 * @param cmd
	 * @return 返回结果
	 */
	public static int exeCmdIsOK(String cmd) {

		int result = 0;
		try {
			Runtime.getRuntime().exec(cmd);
			result = 1;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		return result;

	}

	/**
	 * 执行外部命令，返回外部命令执行结果
	 * 
	 * @param cmd
	 *            外部命令的字符串
	 * @return 返回外部命令执行结果
	 */

	public static String exeCmdResult(String cmd) {

		String result = "";
		Process proc = null;
		InputStream stderr = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			Runtime rt = Runtime.getRuntime();
			proc = rt.exec(cmd);
			stderr = proc.getInputStream();
			isr = new InputStreamReader(stderr,"GBK");
			br = new BufferedReader(isr);
			String line = null;
			StringBuffer strbuff = new StringBuffer();
			while ((line = br.readLine()) != null) {
				strbuff.append(line).append("\n");
				
			}
			result = strbuff.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
			if (isr != null)
				try {
					isr.close();
				} catch (IOException e) {
				}
			if (stderr != null)
				try {
					stderr.close();
				} catch (IOException e) {
				}
			if (proc != null)
				proc.destroy();
		}
		return result;

	}
	
	/**
	 * 执行外部命令，返回外部命令执行结果
	 * 
	 * @param cmd
	 *            外部命令的字符串
	 * @return 
	 * 			返回外部命令执行结果,返回的字符串结果是按照UTF-8格式编码的。
	 * 			如果返回的结果包含几行，则用"\n"分割。
	 */
	public static String exeCmdResultUTF8(String cmd) {

		String result = "";
		Process proc = null;
		InputStream stderr = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			Runtime rt = Runtime.getRuntime();
			
			proc = rt.exec(cmd);
			stderr = proc.getInputStream();
			isr = new InputStreamReader(stderr,"UTF-8");
			br = new BufferedReader(isr);
			String line = null;
			StringBuffer strbuff = new StringBuffer();
			while ((line = br.readLine()) != null) {
				strbuff.append(line).append("\n");
			}
			result = strbuff.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
			if (isr != null)
				try {
					isr.close();
				} catch (IOException e) {
				}
			if (stderr != null)
				try {
					stderr.close();
				} catch (IOException e) {
				}
			if (proc != null)
				proc.destroy();
		}
		return result;

	}
	
	public static void main(String[] args) {
		String result = TWCmdExecutor.exeCmdResult("sh /topapp/topwalk/cpu.sh");
		System.out.println("sh /topapp/topwalk/cpu.sh========================"+result);
	}

}
