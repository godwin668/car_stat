package com.idocv.demo.service;

import java.util.List;

import com.idocv.demo.po.User;

public interface UserService {

	public User save(User user);

	public void delete(long id);

	public void update(User user);

	public User get(long id);

	public List<User> list(String query);

}
