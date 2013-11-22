package com.ru.ssh.JSOperate.dao.inter;

import java.util.List;

import org.hibernate.HibernateException;

import com.ru.ssh.JSOperate.entity.Student;

public interface JSOperateDaoInter {
	
	public boolean saveStuData(String name, String age, String major) throws HibernateException;
	public List<Student> getStuDataByDatabase() throws HibernateException;
    public List<Object[]> getUser() throws HibernateException;

}
