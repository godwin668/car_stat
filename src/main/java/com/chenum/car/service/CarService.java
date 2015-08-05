package com.chenum.car.service;

import java.util.List;

import com.chenum.car.vo.CarXinVo;

public interface CarService {

	public void delete(long id);

	public CarXinVo get(long id);

	public List<CarXinVo> list(String date, int cityId, String payType);

	public List<String> listDate();
}