package com.idocv.car.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idocv.car.dao.CarDao;
import com.idocv.car.po.CarPo;
import com.idocv.car.po.City;
import com.idocv.car.type.XinPayTypeEnum;
import com.idocv.car.util.CrawlXinUtil;

public class XinCrawlDataThread extends Thread {
	
	private static final Logger logger = LoggerFactory.getLogger(XinCrawlDataThread.class);

	private CarDao carDao;
	private City city;
	private XinPayTypeEnum payType;

	public XinCrawlDataThread(CarDao carDao, City city, XinPayTypeEnum payType) {
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