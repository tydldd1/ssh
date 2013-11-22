package com.ru.ssh.JSOperate.dao.imp;

import java.util.List;

import org.hibernate.HibernateException;

import com.ru.ssh.JSOperate.dao.inter.JSOperateDaoInter;
import com.ru.ssh.JSOperate.entity.Student;
import com.ru.ssh.base.hibernateUtil;

public class JSOperateDaoImp extends hibernateUtil implements JSOperateDaoInter{
	
	/**
	 * 
	 * saveStuData(2通过数据库保存学生信息)
	 * @param param
	 * @return
	 * @return boolean
	 */
	public boolean saveStuData(String name, String age, String major) throws HibernateException{
		String sql = "insert into student(name,age,major) values (?,?,?)";
		boolean bl = super.saveUpOrDelSqlOper(sql, name,age,major);
		
		if(bl == true){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * getStuDataByDatabase(2通过数据库获取学生信息)
	 * @return
	 * @throws HibernateException
	 * @return List<Student>
	 */
	public List<Student> getStuDataByDatabase() throws HibernateException{
		String sql = "select id, name , age , major from student";
		
		List<Student> list = super.createSqlQueryListT(sql, Student.class);
		
		return list;
	}

    public List<Object[]> getUser() throws HibernateException{
        String sql = "select * from user where name = ''";
        List<Object[]> list = super.createSqlQueryList(sql);
        return list;
    }
}
