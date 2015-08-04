package com.chenum.car.dao;

import java.util.List;

import com.chenum.car.po.City;

public interface CityDao {

	public City save(City city);

	public void delete(long id);

	public void update(City city);

	public City get(long id);
	
	public City getByXinId(String xinId);

	public List<City> list(String query);

}