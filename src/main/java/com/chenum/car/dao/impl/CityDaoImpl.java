package com.chenum.car.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
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
	public void delete(long id) {
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
	public CityPo get(long id) {
		List<CityPo> list = (List<CityPo>) getHibernateTemplate().find("from " + CityPo.class.getSimpleName() + " where id=?", id);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public CityPo getByXinId(String xinId) {
		List<CityPo> list = (List<CityPo>) getHibernateTemplate().find("from " + CityPo.class.getSimpleName() + " where xin_id=?", xinId);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<CityPo> list(String query) {
		return (List<CityPo>) getHibernateTemplate().find("from " + CityPo.class.getSimpleName() + (StringUtils.isBlank(query) ? "" : " where " + query));
	}

}