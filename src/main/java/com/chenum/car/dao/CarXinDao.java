package com.chenum.car.dao;

import java.util.Date;
import java.util.List;

import com.chenum.car.po.CarXinPo;

public interface CarXinDao {

	public CarXinPo save(CarXinPo car);

	public void delete(long id);

	public void update(CarXinPo car);

	public CarXinPo get(long id);

	public List<CarXinPo> list(String whereClause);

	public List<Date> listDate();

}