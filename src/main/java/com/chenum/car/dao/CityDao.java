package com.chenum.car.dao;

import java.util.List;

import com.chenum.car.po.CityPo;

public interface CityDao {

	public CityPo save(CityPo city);

	public void delete(long id);

	public void update(CityPo city);

	public CityPo get(long id);
	
	public CityPo getByXinId(String xinId);

	public List<CityPo> list(String query);

}