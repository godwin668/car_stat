package com.idocv.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.idocv.demo.dao.CarDao;
import com.idocv.demo.po.CarSumXin;
import com.idocv.demo.po.City;

@Repository
public class CarDaoImpl extends BaseDaoImpl implements CarDao {

	@Override
	public CarSumXin save(CarSumXin car) {
		long id = (long) getHibernateTemplate().save(car);
		car.setId(id);
		return car;
	}

	@Override
	public void delete(long id) {
		CarSumXin car = get(id);
		getHibernateTemplate().delete(car);
		getHibernateTemplate().flush();
	}

	@Override
	public void update(CarSumXin car) {
		getHibernateTemplate().update(car);
		getHibernateTemplate().flush();
	}

	@Override
	public CarSumXin get(long id) {
		List<CarSumXin> list = (List<CarSumXin>) getHibernateTemplate().find("from " + CarSumXin.class.getSimpleName() + " where id=?", id);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<CarSumXin> list(String query) {
		return (List<CarSumXin>) getHibernateTemplate().find("from " + CarSumXin.class.getSimpleName());
	}

}