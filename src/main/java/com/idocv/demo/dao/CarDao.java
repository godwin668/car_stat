package com.idocv.demo.dao;

import java.util.Date;
import java.util.List;

import com.idocv.demo.po.CarPo;

public interface CarDao {

	public CarPo save(CarPo car);

	public void delete(long id);

	public void update(CarPo car);

	public CarPo get(long id);

	public List<CarPo> list(String query);

	public List<Date> listDate();

}