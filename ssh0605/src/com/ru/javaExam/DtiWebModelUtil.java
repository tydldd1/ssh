package com.topwalk.dti.web.coreReflex.core;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;

/**
 * 类加载器工具类。
 * @project dtiweb
 * @version 1.0
 * @author 王博
 * @createDate 下午2:05:23
 * @company 北京天行网安信息技术有限责任公司
 * @authorization (C) Copyright TopWalk Corporation 2006-2012<br/>
 *                <B>本内容仅限于北京天行网安信息技术有限责任公司内部使用，禁止转发</B>
 * @since JDK 1.6
 **/
public class DtiWebModelUtil {
	private static Class<URLClassLoader> clazz;
	private static final Logger log = Logger.getLogger(DtiWebModelUtil.class);

	/**
	 * 动态加载jar文件。
	 * @param jarPath jar文件的路径。
	 * 如：/topapp/dtiweb/dtijar/XXXXXXX.jar
	 */
	public static void loadJar(String jarPath) {
		URLClassLoader urlLoader = (URLClassLoader) Thread.currentThread().getContextClassLoader();
		clazz = URLClassLoader.class;
		try {
			// 调用URLClassLoader的私有方法：addURL，来动态加载jar文件。
			Method method = clazz.getDeclaredMethod("addURL", new Class[] { URL.class });
			method.setAccessible(true);
			jarPath = "file:///"+jarPath;
			System.out.println(jarPath + " == [jarPath]");
			method.invoke(urlLoader, new URL(jarPath));
			log.debug("系统成功动态加载jar类库："+jarPath);
		} catch (Exception e) {
			log.error("加载DTI构件化jar包失败！", e);
		}
	}
}
