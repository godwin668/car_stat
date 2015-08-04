package com.chenum.car.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chenum.car.dao.CarDao;
import com.chenum.car.po.CarPo;
import com.chenum.car.po.CityPo;
import com.chenum.car.util.Crawl58Util;

public class Crawl58Thread extends Thread {
	
	private static final Logger logger = LoggerFactory.getLogger(Crawl58Thread.class);

	private CarDao carDao;
	private CityPo city;

	public Crawl58Thread(CarDao carDao, CityPo city) {
		this.carDao = carDao;
		this.city = city;
	}

	@Override
	public void run() {
		logger.info("[Crawl 58 Task START] " + city.getName());
		CarPo car58 = Crawl58Util.doCrawl(city);
		carDao.save(car58);
		logger.info("[Crawl 58 Task DONE] " + city.getName() + " - " + car58);
	}

}