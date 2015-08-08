package com.chenum.car.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
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
	private static final DateFormat dfDateNoHyphen = new SimpleDateFormat("yyyyMMdd");
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Resource
	private CarService carService;

	@Resource
	private CityService cityService;

	@RequestMapping(value = "chart")
	public String chart() {
		return "car/chart";
	}

	@RequestMapping(value = "trend")
	public String eChart() {
		return "car/trend";
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
	 * 
	 * @param model
	 * @param appId
	 * @param date
	 *            date=20150809 or date=,20150809 or date=20150809, or
	 *            date=20150809,20150810
	 * @param cityId
	 * @param payType
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "{appId}/list.json")
	public List<CarVo> listJson(Model model,
			@PathVariable int appId,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "sdate", required = false) String sdate,
			@RequestParam(value = "edate", required = false) String edate,
			@RequestParam(value = "city", required = false) String cityId,
			@RequestParam(value = "type", required = false) String payType) {
		List<String> conditionList = new ArrayList<String>();
		if (null != date && date.matches("\\d+")) {
			try {
				Date startDate = dfDateNoHyphen.parse(date);
				Date endDate = DateUtils.addDays(startDate, 1);
				// append date to query
				conditionList.add("ctime>'" + df.format(startDate) + "' and ctime<'" + df.format(endDate) + "'");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (null != sdate && sdate.matches("\\d+")) {
			try {
				Date startDate = dfDateNoHyphen.parse(sdate);
				conditionList.add("ctime>'" + df.format(startDate) + "'");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (null != edate && edate.matches("\\d+")) {
			try {
				Date endDate = dfDateNoHyphen.parse(edate);
				conditionList.add("ctime<'" + df.format(endDate) + "'");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (null != cityId && cityId.matches("\\d+")) {
			conditionList.add("city_id='" + cityId + "'");
		}
		if ("s".equalsIgnoreCase(payType) || "h".equalsIgnoreCase(payType)) {
			// append payType to query
			conditionList.add("pay_type='" + payType.toLowerCase() + "'");
		}

		List<CarVo> cars = carService.list(appId, conditionList);
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