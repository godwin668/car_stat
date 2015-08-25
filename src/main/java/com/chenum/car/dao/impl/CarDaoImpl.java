package com.chenum.car.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.chenum.car.dao.CarDao;
import com.chenum.car.po.CarPo;

@Repository
public class CarDaoImpl extends BaseDaoImpl implements CarDao {

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
	public List<CarPo> list(String whereClause) {
		List<CarPo> list = (List<CarPo>) getHibernateTemplate().find("from " + CarPo.class.getSimpleName() + whereClause + " order by ctime desc");
		return list;
	}
	
	@Override
	public Date getOldestDate() {
		HibernateTemplate template = getHibernateTemplate();
		List<CarPo> list = (List<CarPo>) template.find("from " + CarPo.class.getSimpleName() + " order by ctime");
		if (null != list && !list.isEmpty()) {
			return list.get(0).getCtime();
		} else {
			return new Date();
		}
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