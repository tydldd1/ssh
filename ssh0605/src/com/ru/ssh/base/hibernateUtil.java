package com.ru.ssh.base;

import org.apache.poi.hssf.record.formula.functions.T;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ru.ssh.hibernate.entity.Person;

/*
 * hibernate数据库操作类
 * @auther nanchengru
 * @lastModify 2013-5-29
 * @remark 必须在spring配置文件中为此类设置sessionFactory属�?,其他的DAO只需要继承这个类即可
 * */
public class hibernateUtil extends HibernateDaoSupport{
	
	//数据库操�?
	public Query createQuery(String hql, Object... values) {
		Query query = getSession().createQuery(hql);
		if(values != null && values.length != 0){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}	
		return query;
	}
	
	/**
	 * 分页操作方法取自SpringSide. 创建Query对象.
	 * 对于�?��first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设�?
	 * 留意可以连续设置,如下�?
	 * 
	 * <pre>
	 * dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 * </pre>
	 * 
	 * 调用方式如下�?
	 * 
	 * <pre>
	 * 
	 *        dao.createQuery(hql)  
	 *        dao.createQuery(hql,arg0);  
	 *        dao.createQuery(hql,arg0,arg1);  
	 *        dao.createQuery(hql,new Object[arg0,arg1,arg2])
	 * </pre>
	 * 
	 * @param values
	 *            可变参数.
	 */
	public Query createQueryByPage(String hql,int currentPage,int pageSize, Object... values) {
		Query query = getSession().createQuery(hql);
		if(values != null && values.length != 0){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query;
	}
	
	//批量插入数据
	public void batckInject(int numbers){
		Session session = this.getSession();
		for(int i = 0; i < numbers; i++){
			Object obj = new Object();
			session.save(obj);
			if(i % 20 == 0){
				session.flush();
				session.clear();
			}
		}
		
	}
}
