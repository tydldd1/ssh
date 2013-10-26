package com.ru.ssh.JSOperate.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ru.ssh.JSOperate.dao.inter.JSOperateDaoInter;
import com.ru.ssh.JSOperate.service.inter.JSOperateServInter;

public class JSOperateServImp implements JSOperateServInter{
	
	private JSOperateDaoInter JSOperateDao;
	
	/**
	 * 
	 * getStuList(通过前台传递字符串组成学生列表)
	 * @param data
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> getStuList(String data){
		
		if(data == null || data.equals("")){
			return null;
		}
		
		List<Map<String, String>> list = getList(data);
		
		return list;
	}
	
	
	public List<Map<String, String>> getList(String data){
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		String[] students = data.split(";");
		
		for(String stu : students){
			Map<String, String> map = new HashMap<String, String>();
			String[] student = stu.split(",");
			map.put("name", student[0]);
			map.put("age", student[1]);
			map.put("major", student[2]);
			list.add(map);
		}
		
		return list;
	}
	
	
	
	

	public JSOperateDaoInter getJSOperateDao() {
		return JSOperateDao;
	}

	public void setJSOperateDao(JSOperateDaoInter jSOperateDao) {
		JSOperateDao = jSOperateDao;
	}
}
