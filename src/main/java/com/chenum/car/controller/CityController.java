package com.chenum.car.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<CityPo> listJson(Model model,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "province", required = false) String province,
			@RequestParam(value = "name", required = false) String name) {
		List<String> conditionList = new ArrayList<String>();
		if (null != id && id.matches("\\d+")) {
			conditionList.add("id=" + id);
		}
		if (null != province) {
			conditionList.add("province='" + StringEscapeUtils.escapeSql(province) + "'");
		}
		if (null != name) {
			conditionList.add("name='" + StringEscapeUtils.escapeSql(name) + "'");
		}
		List<CityPo> cityList = cityService.list(conditionList);
		return cityList;
	}

}