package com.idocv.demo.service;

import java.util.List;

import com.idocv.demo.po.City;

public interface CityService {

	public List<City> list(String query);

}