package com.idocv.car.dao;

import java.util.List;

import com.idocv.car.po.User;

public interface UserDao {

	public User save(User user);

	public void delete(long id);

	public void update(User user);

	public User get(long id);

	public List<User> list(String query);

}