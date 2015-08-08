package com.chenum.car.dao;

import java.util.List;

import com.chenum.car.po.CityPo;

public interface CityDao {

	public CityPo save(CityPo city);

	public void delete(int id);

	public void update(CityPo city);

	public CityPo get(int id);
	
	public List<CityPo> list(List<String> conditions);

}