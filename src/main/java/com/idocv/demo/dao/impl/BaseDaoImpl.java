package com.idocv.demo.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.idocv.demo.dao.BaseDao;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	@Resource
	public void setFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
		return hibernateTemplate;
	}
	
}