package com.idocv.demo.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idocv.demo.dao.CarDao;
import com.idocv.demo.po.CarPo;

@Repository
public class CarDaoImpl extends BaseDaoImpl implements CarDao {

	private static final DateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public CarPo save(CarPo car) {
		long id = (long) getHibernateTemplate().save(car);
		car.setId(id);
		return car;
	}

	@Override
	public void delete(long id) {
		CarPo car = get(id);
		getHibernateTemplate().delete(car);
		getHibernateTemplate().flush();
	}

	@Override
	public void update(CarPo car) {
		getHibernateTemplate().update(car);
		getHibernateTemplate().flush();
	}

	@Override
	public CarPo get(long id) {
		List<CarPo> list = (List<CarPo>) getHibernateTemplate().find("from " + CarPo.class.getSimpleName() + " where id=?", id);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<CarPo> list(String query) {
		return (List<CarPo>) getHibernateTemplate().find("from " + CarPo.class.getSimpleName());
	}

	@Override
	public List<Date> listDate() {
		List<CarPo> poList = list("");
		List<Date> dateList = new ArrayList<Date>();
		if (null == poList || poList.isEmpty()) {
			return dateList;
		}
		for (CarPo po : poList) {
			dateList.add(po.getCtime());
		}
		return dateList;
	}

}