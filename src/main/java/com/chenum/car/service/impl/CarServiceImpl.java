package com.chenum.car.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenum.car.dao.CarDao;
import com.chenum.car.dao.CityDao;
import com.chenum.car.po.CarPo;
import com.chenum.car.po.CityPo;
import com.chenum.car.service.CarService;
import com.chenum.car.type.AppType;
import com.chenum.car.vo.CarVo;

@Service
public class CarServiceImpl implements CarService {

	@Resource
	private CarDao carDao;

	@Resource
	private CityDao cityDao;

	private static final DateFormat dfDateNoHyphen = new SimpleDateFormat("yyyyMMdd");
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void delete(long id) {
		carDao.delete(id);
	}

	@Override
	public CarVo get(long id) {
		return convertPo2Vo(carDao.get(id));
	}

	@Override
	public List<CarVo> list(int appId, List<String> conditions) {
		String query = " where 1=1 and (app_id=" + appId + ")";
		if (null != conditions && !conditions.isEmpty()) {
			for (String condition : conditions) {
				query += " and (" + condition + ")";
			}
		}
		return convertPo2Vo(carDao.list(query));
	}

	@Override
	public List<String> listDate() {
		List<Date> dateList = carDao.listDate();
		List<String> strList = new ArrayList<String>();
		if (null == dateList || dateList.isEmpty()) {
			return strList;
		}
		Set<String> set = new TreeSet<String>(Collections.reverseOrder());
		for (Date date : dateList) {
			set.add(dfDateNoHyphen.format(date));
		}
		strList.addAll(set);
		return strList;
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

		List<CityPo> cityList = cityDao.list(null);
		Map<Integer, String> cityNameMap = new HashMap<Integer, String>();
		if (null != cityList && !cityList.isEmpty()) {
			for (CityPo city : cityList) {
				cityNameMap.put(city.getId(), city.getName());
			}
		}

		for (CarPo po : poList) {
			CarVo vo = new CarVo();
			vo.setId(po.getId());
			vo.setAppId(po.getAppId());
			vo.setAppName(AppType.getById(po.getAppId()).getName());
			vo.setCtime(df.format(po.getCtime()));
			vo.setCdate(dfDateNoHyphen.format(po.getCtime()));
			vo.setCityId(po.getCityId());
			int cityXinId = po.getCityId();
			if (null != cityNameMap && !cityNameMap.isEmpty() && cityNameMap.containsKey(cityXinId)) {
				vo.setCityName(cityNameMap.get(cityXinId));
			} else {
				vo.setCityName("未知");
			}
			String payType = po.getPay_type();
			payType = "s".equals(payType) ? "买车" : ("h".equals(payType) ? "付半价"
					: "未知");
			vo.setPay_type(payType);
			vo.setSrcAll(po.getSrcAll());
			vo.setSrcNoAccident(po.getSrcNoAccident());
			vo.setSrcOriginal(po.getSrcOriginal());
			vo.setSrcBySeller(po.getSrcBySeller());
			vo.setSrcPersonal(po.getSrcPersonal());
			vo.setSrcVin(po.getSrcVin());
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