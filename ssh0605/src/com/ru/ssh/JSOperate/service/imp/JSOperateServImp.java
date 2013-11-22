package com.ru.ssh.JSOperate.service.imp;

import com.ru.ssh.JSOperate.dao.inter.JSOperateDaoInter;
import com.ru.ssh.JSOperate.entity.QueryBean;
import com.ru.ssh.JSOperate.entity.Student;
import com.ru.ssh.JSOperate.service.inter.JSOperateServInter;
import com.ru.ssh.base.page.PageBean;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import java.text.SimpleDateFormat;
import java.util.*;

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

    /**
     * 日志分页列表
     * @return
     */
    public PageBean getDagaLogList(QueryBean queryBean, PageBean pageBean){
        log.debug("service -----begin");
        //查询列表
        String sql = "select taskname,status,level,desr,data from datalog";
        StringBuilder sb = new StringBuilder();
        sb.append(sql + " where ");
        if(queryBean == null){//跳转页面之前没有查询条件
            queryBean = new QueryBean();
            SimpleDateFormat sdfBegin = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
            SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
            queryBean.setBeginTime(sdfBegin.format(new Date()));
            queryBean.setEndTime(sdfEnd.format(new Date()));
            sb.append("data between '" + queryBean.getBeginTime() + "'");
            sb.append(" and '" + queryBean.getEndTime() + "'");
        }else{//在页面访问时，有查询对象
            if (!queryBean.getTaskName().equals("all")){
                sb.append("taskname = '" + queryBean.getTaskName() + "' and ");
            }else{
                sb.append("taskname <> '" + queryBean.getTaskName() + "' and ");
            }
            if (!queryBean.getStatus().equals("all")){
                sb.append("status = '" + queryBean.getStatus() + "' and ");
            }else{
                sb.append("status <> '" + queryBean.getStatus() + "' and ");
            }
            if (!queryBean.getLevel().equals("all")){
                sb.append("level = '" + queryBean.getLevel() + "'");
            }else {
                sb.append("level <> '" + queryBean.getLevel() + "'");
            }
            /*sb.append("data between '" + queryBean.getBeginTime() + "'");
            sb.append(" and '" + queryBean.getEndTime() + "'");*/
        }
        log.debug("sql = " + sb.toString());
        List<Object[]> datalogList = null;
        try {
            datalogList = JSOperateDao.datalogList(sb.toString(), pageBean);
        } catch (Exception e) {
            log.error("查询日志分页列表失败！", e);
        }
        //得到总条数
        String sqlCount = "select count(*) from datalog";
        int totalcount = 0;
        try {
            totalcount = JSOperateDao.getDatalogCount(sqlCount);
        } catch (Exception e) {
            log.error("查询总条数失败！", e);
        }
        log.debug("totalcount = " + totalcount);
        //初始化pagebean（添加列表，判断上一页下一页）
        pageBean.initPage(totalcount, pageBean.getCurrentPage(), datalogList);

        return pageBean;
    }

    public List<Object> getTaskName(){
        List<Object> taskNameList = null;
        try {
            taskNameList = JSOperateDao.getTaskName();
        } catch (Exception e) {
            log.error("获取任务名列表失败!", e);
        }
        return taskNameList;
    }
	
	

	public JSOperateDaoInter getJSOperateDao() {
		return JSOperateDao;
	}

	public void setJSOperateDao(JSOperateDaoInter jSOperateDao) {
		JSOperateDao = jSOperateDao;
	}
}
