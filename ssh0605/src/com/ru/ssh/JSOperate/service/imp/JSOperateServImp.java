package com.ru.ssh.JSOperate.service.imp;

import com.ru.ssh.JSOperate.dao.inter.JSOperateDaoInter;
import com.ru.ssh.JSOperate.entity.Student;
import com.ru.ssh.JSOperate.service.inter.JSOperateServInter;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSOperateServImp implements JSOperateServInter{
	
	Logger log = Logger.getLogger(JSOperateServImp.class);
	//接口
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
	
	
	private List<Map<String, String>> getList(String data){
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
	
	/**
	 * 
	 * saveStuData(2通过数据库保存学生信息)
	 * @param list
	 * @return
	 * @return boolean
	 */
	public boolean saveStuData(List<Map<String, String>> list){
		
		List<String> blList = new ArrayList<String>();
		
		try {
			for(Map<String, String> map : list){
				String name = map.get("name");
				String age = map.get("age");
				String major = map.get("major");
				
				boolean bl = JSOperateDao.saveStuData(name, age, major);
				if(bl == true){
					blList.add("true");
				}else{
					blList.add("false");
				}
			}
		} catch (HibernateException e) {
			errorHandle(e,"通过数据库保存学生信息出错");
		}
		
		if(blList.contains("false")){
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * getStuDataByDatabase(2通过数据库获取学生信息)
	 * @return
	 * @return List<Student>
	 */
	public List<Student> getStuDataByDatabase(){
		
		List<Student> list = null;
		try {
			 list = JSOperateDao.getStuDataByDatabase();
		} catch (Exception e) {
			errorHandle(e, "通过数据库获取学生信息失败");
		}
		
		return list;
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

    public List<Object[]> getUser(String message){
        List<Object[]> list = JSOperateDao.getUser(message);
        return list;
    }
	
	
	
	

	public JSOperateDaoInter getJSOperateDao() {
		return JSOperateDao;
	}

	public void setJSOperateDao(JSOperateDaoInter jSOperateDao) {
		JSOperateDao = jSOperateDao;
	}
}
