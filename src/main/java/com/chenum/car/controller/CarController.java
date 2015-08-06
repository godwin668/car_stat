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
import com.chenum.car.vo.CarVo;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	@Resource
	private CityService cityService;

	@RequestMapping(value = "chart")
	public String chart() {
		return "car/chart";
	}

	@RequestMapping(value = "58")
	public String page58() {
		return "car/list58";
	}
	
	@RequestMapping(value = "xin")
	public String pageXin() {
		return "car/listXin";
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
	@RequestMapping(value = "{appId}/list.json")
	public List<CarVo> listJson(Model model,
			@PathVariable int appId,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "city", required = false) String cityId,
			@RequestParam(value = "type", required = false) String payType) {
		List<CarVo> cars = carService.list(appId, date, ((null != cityId && cityId.matches("\\d+")) ? Integer.valueOf(cityId) : -1), payType);
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