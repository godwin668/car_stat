package com.idocv.demo.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.idocv.demo.dao.CarDao;
import com.idocv.demo.dao.CityDao;
import com.idocv.demo.po.City;
import com.idocv.demo.type.PayTypeEnum;

@Component
@EnableScheduling
public class CrawlDataTask {
	
	private static final Logger logger = LoggerFactory.getLogger(CrawlDataTask.class);

	@Resource
	private CityDao cityDao;

	@Resource
	private CarDao carDao;

	ExecutorService executorService = Executors.newFixedThreadPool(10);

	// 0 0 22 * * ?
	@Scheduled(cron = "${task.crawl.xin.cron}")
	public void run() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.warn("[Crawl Dta Task] " + df.format(new Date()));

		// get cities
		List<City> cityList = cityDao.list("");
		if (null == cityList || cityList.isEmpty()) {
			return;
		}

		for (City city : cityList) {
			for (PayTypeEnum payType : PayTypeEnum.values()) {
				CrawlDataThread thread = new CrawlDataThread(carDao, city, payType);
				executorService.submit(thread);
			}
		}
	}

}