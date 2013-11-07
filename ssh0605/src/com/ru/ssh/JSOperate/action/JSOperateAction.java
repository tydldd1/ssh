package com.ru.ssh.JSOperate.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ru.javaExam.utilofxml.OperateXmlDocument;
import com.ru.ssh.JSOperate.dao.inter.JSOperateDaoInter;
import com.ru.ssh.JSOperate.entity.Student;
import com.ru.ssh.JSOperate.service.inter.JSOperateServInter;

public class JSOperateAction {
	
	Logger log = Logger.getLogger(JSOperateAction.class);
	//接口
	private JSOperateServInter JSOperateService;
	
	//变量
	private String dataStr;
	private String message;
	private List<Map<String, String>> list;
	private List<Student> stuList;
	
	/**
	 * 
	 * saveStudentData(1通过xml保存学生信息)
	 * @return
	 * @return String
	 */
	public String saveStudentData(){
		String rootElement = "students";
		String savePath = "G:/test/students.xml";
		List<Map<String, String>> list = JSOperateService.getStuList(dataStr);
		
		try {
			OperateXmlDocument.createXmlFile(rootElement, list, savePath);
			message = "success";
		} catch (IOException e) {
			message = "fail";
			errorHandle(e, "保存学生信息出错");
		}
		
		log.debug("********************ssh  " + message);
		return "saveSucess";
	}
	
	/**
	 * 
	 * getStuMessage(1通过xml获取学生信息)
	 * @return
	 * @return String
	 */
	public String getStuMessage(){
		String xmlPath = "G:/test/students.xml";
		try {
			list = OperateXmlDocument.analysisXmlFile(xmlPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "stuMessage";
	}
	
	
	/**
	 * 
	 * saveStuDataIndatabase(2通过数据库保存学生信息)
	 * @return
	 * @return String
	 */
	public String saveStuDataIndatabase(){
		List<Map<String, String>> list = JSOperateService.getStuList(dataStr);
		
		boolean bl = JSOperateService.saveStuData(list);
		if(bl == true){
			message = "success";
		}else{
			message = "fail";
		}
		
		return "saveSucess";
	}
	
	/**
	 * 
	 * getStuDataByDatabase(2通过数据库获取学生信息)
	 * @return
	 * @return List<Student>
	 */
	public String getStuDataByDatabase(){
		
		stuList = JSOperateService.getStuDataByDatabase();
		
		return "stuMessage";
	}
	
	
	/**
	 * 
	 * errorHandle(错误处理)
	 * @param e
	 * @param msg
	 * @return void
	 */
	public void errorHandle(Exception e, String msg){
		log.info(msg + ">>>>>> 错误信息：" + e.toString());
		e.printStackTrace();
	}
	
	

	public String getDataStr() {
		return dataStr;
	}

	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}

	public JSOperateServInter getJSOperateService() {
		return JSOperateService;
	}

	public void setJSOperateService(JSOperateServInter jSOperateService) {
		JSOperateService = jSOperateService;
	}

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public List<Map<String, String>> getList() {
		return list;
	}


	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
	
}
