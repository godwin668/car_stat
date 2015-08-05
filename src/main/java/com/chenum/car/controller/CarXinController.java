package com.chenum.car.controller;

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

import com.chenum.car.service.CarService;
import com.chenum.car.service.CityService;
import com.chenum.car.vo.CarXinVo;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("car")
public class CarXinController {
	
	private static final Logger logger = LoggerFactory.getLogger(CarXinController.class);
	private static final ObjectMapper om = new ObjectMapper();
	
	@Resource
	private CarService carService;

	@Resource
	private CityService cityService;

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
	public CarXinVo get(Model model, @PathVariable int id) {
		CarXinVo car = carService.get(id);
		return car;
	}

	/**
	 * list car sum list
	 */
	@ResponseBody
	@RequestMapping(value = "list.json")
	public List<CarXinVo> listJson(Model model,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "city", required = false) String cityId,
			@RequestParam(value = "type", required = false) String payType) {
		List<CarXinVo> cars = carService.list(date, ((null != cityId && cityId.matches("\\d+")) ? Integer.valueOf(cityId) : -1), payType);
		return cars;
	}

	/**
	 * date list
	 */
	@ResponseBody
	@RequestMapping(value = "dateList.json")
	public List<String> dateListJson(Model model) {
		List<String> dateList = carService.listDate();
		return dateList;
	}

}