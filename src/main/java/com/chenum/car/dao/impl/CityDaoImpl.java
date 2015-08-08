package com.chenum.car.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chenum.car.dao.CityDao;
import com.chenum.car.po.CityPo;

@Repository
public class CityDaoImpl extends BaseDaoImpl implements CityDao {

	@Override
	public CityPo save(CityPo city) {
		getHibernateTemplate().save(city);
		// getHibernateTemplate().flush();
		return city;
	}

	@Override
	public void delete(int id) {
		CityPo city = get(id);
		getHibernateTemplate().delete(city);
		getHibernateTemplate().flush();
	}

	@Override
	public void update(CityPo city) {
		getHibernateTemplate().update(city);
		getHibernateTemplate().flush();
	}

	@Override
	public CityPo get(int id) {
		List<CityPo> list = (List<CityPo>) getHibernateTemplate().find("from " + CityPo.class.getSimpleName() + " where id=?", id);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<CityPo> list(List<String> conditions) {
		String query = " where 1=1";
		if (null != conditions && !conditions.isEmpty()) {
			for (String condition : conditions) {
				query += " and (" + condition + ")";
			}
		}
		return (List<CityPo>) getHibernateTemplate().find("from " + CityPo.class.getSimpleName() + query);
	}

}