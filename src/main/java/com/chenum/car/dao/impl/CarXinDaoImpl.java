package com.chenum.car.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chenum.car.dao.CarXinDao;
import com.chenum.car.po.CarXinPo;

@Repository
public class CarXinDaoImpl extends BaseDaoImpl implements CarXinDao {

	private static final DateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public CarXinPo save(CarXinPo car) {
		long id = (long) getHibernateTemplate().save(car);
		car.setId(id);
		return car;
	}

	@Override
	public void delete(long id) {
		CarXinPo car = get(id);
		getHibernateTemplate().delete(car);
		getHibernateTemplate().flush();
	}

	@Override
	public void update(CarXinPo car) {
		getHibernateTemplate().update(car);
		getHibernateTemplate().flush();
	}

	@Override
	public CarXinPo get(long id) {
		List<CarXinPo> list = (List<CarXinPo>) getHibernateTemplate().find("from " + CarXinPo.class.getSimpleName() + " where id=?", id);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<CarXinPo> list(String whereClause) {
		List<CarXinPo> list = (List<CarXinPo>) getHibernateTemplate().find("from " + CarXinPo.class.getSimpleName() + whereClause);
		return list;
	}

	@Override
	public List<Date> listDate() {
		List<CarXinPo> poList = list("");
		List<Date> dateList = new ArrayList<Date>();
		if (null == poList || poList.isEmpty()) {
			return dateList;
		}
		for (CarXinPo po : poList) {
			dateList.add(po.getCtime());
		}
		return dateList;
	}

}