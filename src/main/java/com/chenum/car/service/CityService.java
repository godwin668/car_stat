package com.chenum.car.service;

import java.util.List;

import com.chenum.car.po.CityPo;

public interface CityService {

	public List<CityPo> list(List<String> condition);

}