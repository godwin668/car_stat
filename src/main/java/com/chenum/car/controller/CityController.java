package com.chenum.car.controller;

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

import com.chenum.car.po.CityPo;
import com.chenum.car.service.CityService;

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
		List<CityPo> cityList = cityService.list("");
		Map<String, String> cityMap = new HashMap<String, String>();
		if (CollectionUtils.isEmpty(cityList)) {
			return cityMap;
		}
		for (CityPo city : cityList) {
			cityMap.put(city.getIdXin(), city.getName());
		}
		return cityMap;
	}

}