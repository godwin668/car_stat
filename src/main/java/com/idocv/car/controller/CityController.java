package com.idocv.car.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idocv.car.po.City;
import com.idocv.car.service.CityService;

/**
 * City
 */
@Controller
@RequestMapping("city")
public class CityController {
	
	private static final Logger logger = LoggerFactory.getLogger(CityController.class);
	
	@Resource
	private CityService cityService;

	/**
	 * city list
	 */
	@ResponseBody
	@RequestMapping(value = "list.json")
	public Map<String, String> listJson(Model model) {
		List<City> cityList = cityService.list("");
		Map<String, String> cityMap = new HashMap<String, String>();
		if (CollectionUtils.isEmpty(cityList)) {
			return cityMap;
		}
		for (City city : cityList) {
			cityMap.put(city.getXinId(), city.getName());
		}
		return cityMap;
	}

}