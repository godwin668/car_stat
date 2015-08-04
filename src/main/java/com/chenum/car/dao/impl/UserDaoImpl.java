package com.chenum.car.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chenum.car.dao.UserDao;
import com.chenum.car.po.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public User save(User user) {
//		String name = user.getName();
//		int age = user.getAge();
//		int result = jdbcTemplate.update("insert into user(name, age) values(?, ?)", name, age);
//		System.out.println("create user result: " + result);
		long id = (long) getHibernateTemplate().save(user);
		user.setId(id);
		return user;
	}

	@Override
	public void delete(long id) {
		User user = get(id);
		getHibernateTemplate().delete(user);
		getHibernateTemplate().flush();
	}

	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);
		getHibernateTemplate().flush();
	}

	@Override
	public User get(long id) {
		List<User> list = (List<User>) getHibernateTemplate().find("from " + User.class.getSimpleName() + " where id=?", id);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<User> list(String query) {
		return (List<User>) getHibernateTemplate().find("from " + User.class.getSimpleName());
	}

}