package com.idocv.demo.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import com.idocv.demo.dao.CarDao;
import com.idocv.demo.dao.CityDao;
import com.idocv.demo.po.CarPo;
import com.idocv.demo.po.City;
import com.idocv.demo.service.CarService;
import com.idocv.demo.vo.CarVo;

@Service
public class CarServiceImpl implements CarService {

	@Resource
	private CarDao carDao;

	@Resource
	private CityDao cityDao;

	private static final DateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat df = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	@Override
	public void delete(long id) {
		carDao.delete(id);
	}

	@Override
	public CarVo get(long id) {
		return convertPo2Vo(carDao.get(id));
	}

	@Override
	public List<CarVo> list(String date, String cityId, String payType) {
		List<String> conditions = new ArrayList<String>();
		if (null != date && date.matches("\\d{4}-\\d{2}-\\d{2}")) {
			try {
				Date startDate = dfDate.parse(date);
				Date endDate = DateUtils.addDays(startDate, 1);
				// append date to query
				conditions.add("ctime>" + startDate + " and ctime<" + endDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (null != cityId && cityId.matches("\\d+")) {
			City city = cityDao.getByXinId(cityId);
			if (null != city) {
				// append city to query
				conditions.add("city_id='" + city.getXinId() + "'");
			}
		}

		if ("s".equalsIgnoreCase(payType) || "h".equalsIgnoreCase(payType)) {
			// append payType to query
			conditions.add("pay_type='" + payType.toLowerCase() + "'");
		}
		
		String query = "";
		if (!conditions.isEmpty()) {
			for (int i = 0; i < conditions.size(); i++) {
				if (i == 0) {
					query += " where 1=1 ";
				}
				query += " and (" + conditions.get(i) + ")";
			}
		}
		
		return convertPo2Vo(carDao.list(query));
	}

	public CarVo convertPo2Vo(CarPo po) {
		List<CarPo> poList = new ArrayList<CarPo>();
		poList.add(po);
		return convertPo2Vo(poList).get(0);
	}

	public List<CarVo> convertPo2Vo(List<CarPo> poList) {
		List<CarVo> voList = new ArrayList<CarVo>();
		if (null == poList || poList.isEmpty()) {
			return voList;
		}

		List<City> cityList = cityDao.list("");
		Map<String, String> cityNameMap = new HashMap<String, String>();
		if (null != cityList && !cityList.isEmpty()) {
			for (City city : cityList) {
				cityNameMap.put(city.getXinId(), city.getName());
			}
		}

		for (CarPo po : poList) {
			CarVo vo = new CarVo();
			vo.setId(po.getId());
			vo.setCtime(df.format(po.getCtime()));
			vo.setCityId(po.getCityId());
			String cityXinId = po.getCityId();
			if (null != cityNameMap && !cityNameMap.isEmpty() && cityNameMap.containsKey(cityXinId)) {
				vo.setCityName(cityNameMap.get(cityXinId));
			} else {
				vo.setCityName("未知");
			}
			String payType = po.getPay_type();
			payType = "s".equals(payType) ? "买车" : ("h".equals(payType) ? "付半价" : "未知");
			vo.setPay_type(payType);
			vo.setSrcAll(po.getSrcAll());
			vo.setSrcNoAccident(po.getSrcNoAccident());
			vo.setSrcOriginal(po.getSrcOriginal());
			vo.setSrcBySeller(po.getSrcBySeller());
			vo.setSrcPersonal(po.getSrcPersonal());
			vo.setAge_1(po.getAge_1());
			vo.setAge_1_3(po.getAge_1_3());
			vo.setAge_3_5(po.getAge_3_5());
			vo.setAge_5_8(po.getAge_5_8());
			vo.setAge_8(po.getAge_8());
			vo.setMilage_1(po.getMilage_1());
			vo.setMilage_1_3(po.getMilage_1_3());
			vo.setMilage_3_6(po.getMilage_3_6());
			vo.setMilage_6_10(po.getMilage_6_10());
			vo.setMilage_10_20(po.getMilage_10_20());
			vo.setMilage_20(po.getMilage_20());
			vo.setPrice_5(po.getPrice_5());
			vo.setPrice_5_10(po.getPrice_5_10());
			vo.setPrice_10_15(po.getPrice_10_15());
			vo.setPrice_15_20(po.getPrice_15_20());
			vo.setPrice_20_30(po.getPrice_20_30());
			vo.setPrice_30_50(po.getPrice_30_50());
			vo.setPrice_50(po.getPrice_50());
			voList.add(vo);
		}
		return voList;
	}
}