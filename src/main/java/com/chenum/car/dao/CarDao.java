package com.chenum.car.dao;

import java.util.Date;
import java.util.List;

import com.chenum.car.po.CarPo;

public interface CarDao {

	public CarPo save(CarPo car);

	public void delete(long id);

	public void update(CarPo car);

	public CarPo get(long id);

	public List<CarPo> list(String whereClause);

	public List<Date> listDate();

}