package com.idocv.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idocv.demo.service.CarService;
import com.idocv.demo.vo.CarVo;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("car")
public class CarController {
	
	private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	private static final ObjectMapper om = new ObjectMapper();
	
	@Resource
	private CarService carService;

	@RequestMapping(value = "")
	public String page() {
		return "car/list";
	}
	
	/**
	 * Delete car
	 */
	@ResponseBody
	@RequestMapping(value = "delete/{id}")
	public Map<String, Object> delete(Model model, @PathVariable int id) {
		carService.delete(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "success");
		return map;
	}

	/**
	 * get car sum
	 */
	@ResponseBody
	@RequestMapping(value = "get/{id}")
	public CarVo get(Model model, @PathVariable int id) {
		CarVo car = carService.get(id);
		return car;
	}

	/**
	 * list car sum list
	 */
	@ResponseBody
	@RequestMapping(value = "list.json")
	public List<CarVo> listJson(Model model,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "cityId", required = false) String cityId,
			@RequestParam(value = "payType", required = false) String payType) {
		List<CarVo> cars = carService.list(date, cityId, payType);
		return cars;
	}

}