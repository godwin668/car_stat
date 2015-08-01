package com.idocv.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.idocv.demo.dao.CarDao;
import com.idocv.demo.po.CarXin;
import com.idocv.demo.po.City;

@Repository
public class CarDaoImpl extends BaseDaoImpl implements CarDao {

	@Override
	public CarXin save(CarXin car) {
		long id = (long) getHibernateTemplate().save(car);
		car.setId(id);
		return car;
	}

	@Override
	public void delete(long id) {
		CarXin car = get(id);
		getHibernateTemplate().delete(car);
		getHibernateTemplate().flush();
	}

	@Override
	public void update(CarXin car) {
		getHibernateTemplate().update(car);
		getHibernateTemplate().flush();
	}

	@Override
	public CarXin get(long id) {
		List<CarXin> list = (List<CarXin>) getHibernateTemplate().find("from " + CarXin.class.getSimpleName() + " where id=?", id);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<CarXin> list(String query) {
		return (List<CarXin>) getHibernateTemplate().find("from " + CarXin.class.getSimpleName());
	}

}