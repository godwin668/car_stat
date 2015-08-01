package com.idocv.demo.dao;

import java.util.List;

import com.idocv.demo.po.CarSumXin;

public interface CarDao {

	public CarSumXin save(CarSumXin car);

	public void delete(long id);

	public void update(CarSumXin car);

	public CarSumXin get(long id);

	public List<CarSumXin> list(String query);

}