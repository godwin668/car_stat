package com.chenum.car.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chenum.car.dao.CarDao;
import com.chenum.car.po.CarPo;
import com.chenum.car.po.CityPo;
import com.chenum.car.type.XinPayTypeEnum;
import com.chenum.car.util.CrawlXinUtil;

public class XinCrawlDataThread extends Thread {
	
	private static final Logger logger = LoggerFactory.getLogger(XinCrawlDataThread.class);

	private CarDao carDao;
	private CityPo city;
	private XinPayTypeEnum payType;

	public XinCrawlDataThread(CarDao carDao, CityPo city, XinPayTypeEnum payType) {
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