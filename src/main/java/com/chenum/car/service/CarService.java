package com.chenum.car.service;

import java.util.List;

import com.chenum.car.vo.CarVo;

public interface CarService {

	public void delete(long id);

	public CarVo get(long id);

	public List<CarVo> list(int appId, String date, int cityId, String payType);

	public List<String> listDate();
}