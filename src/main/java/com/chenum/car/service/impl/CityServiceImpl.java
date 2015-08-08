package com.chenum.car.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenum.car.dao.CityDao;
import com.chenum.car.po.CityPo;
import com.chenum.car.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Resource
	private CityDao cityDao;

	@Override
	public List<CityPo> list(List<String> conditions) {
		return cityDao.list(conditions);
	}

}