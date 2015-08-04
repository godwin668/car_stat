package com.chenum.car.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chenum.car.dao.CarDao;
import com.chenum.car.po.CarPo;
import com.chenum.car.po.CityPo;
import com.chenum.car.type.PayXinEnum;
import com.chenum.car.util.CrawlXinUtil;

public class CrawlXinThread extends Thread {
	
	private static final Logger logger = LoggerFactory.getLogger(CrawlXinThread.class);

	private CarDao carDao;
	private CityPo city;
	private PayXinEnum payType;

	public CrawlXinThread(CarDao carDao, CityPo city, PayXinEnum payType) {
		this.carDao = carDao;
		this.city = city;
		this.payType = payType;
	}

	@Override
	public void run() {
		logger.info("[Crawl Xin Task START] " + city.getName() + " - " + payType.getValue());
		CarPo carXin = CrawlXinUtil.doCrawl(city, payType);
		carDao.save(carXin);
		logger.info("[Crawl Xin Task DONE] " + city.getName() + " - " + payType.getValue() + " - " + carXin);
	}

}