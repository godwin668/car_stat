package com.idocv.demo.service;

import java.util.List;

import com.idocv.demo.vo.CarVo;

public interface CarService {

	public void delete(long id);

	public CarVo get(long id);

	public List<CarVo> list(String date, String cityId, String payType);

}
