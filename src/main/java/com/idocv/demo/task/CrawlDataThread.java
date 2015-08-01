package com.idocv.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idocv.demo.dao.CarDao;
import com.idocv.demo.po.CarPo;
import com.idocv.demo.po.City;
import com.idocv.demo.type.PayTypeEnum;
import com.idocv.demo.util.CrawlXinUtil;

public class CrawlDataThread extends Thread {
	
	private static final Logger logger = LoggerFactory.getLogger(CrawlDataThread.class);

	private CarDao carDao;
	private City city;
	private PayTypeEnum payType;

	public CrawlDataThread(CarDao carDao, City city, PayTypeEnum payType) {
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