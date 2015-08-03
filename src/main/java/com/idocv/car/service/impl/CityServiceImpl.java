package com.idocv.car.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idocv.car.dao.CityDao;
import com.idocv.car.po.City;
import com.idocv.car.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Resource
	private CityDao cityDao;

	@Override
	public List<City> list(String query) {
		return cityDao.list("");
	}

}