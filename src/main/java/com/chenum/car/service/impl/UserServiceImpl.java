package com.chenum.car.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenum.car.dao.UserDao;
import com.chenum.car.po.User;
import com.chenum.car.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	public void delete(long id) {
		userDao.delete(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public User get(long id) {
		return userDao.get(id);
	}

	@Override
	public List<User> list(String query) {
		return userDao.list(query);
	}

}