package com.idocv.car.service;

import java.util.List;

import com.idocv.car.vo.CarVo;

public interface CarService {

	public void delete(long id);

	public CarVo get(long id);

	public List<CarVo> list(String date, String cityId, String payType);

	public List<String> listDate();
}