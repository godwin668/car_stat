package com.idocv.demo.dao;

import java.util.List;

import com.idocv.demo.po.CarXin;

public interface CarDao {

	public CarXin save(CarXin car);

	public void delete(long id);

	public void update(CarXin car);

	public CarXin get(long id);

	public List<CarXin> list(String query);

}