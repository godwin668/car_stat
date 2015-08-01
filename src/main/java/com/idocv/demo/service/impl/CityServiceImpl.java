package com.idocv.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idocv.demo.dao.CityDao;
import com.idocv.demo.po.City;
import com.idocv.demo.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Resource
	private CityDao cityDao;

	@Override
	public List<City> list(String query) {
		return cityDao.list("");
	}

}