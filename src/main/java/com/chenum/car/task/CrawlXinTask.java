package com.chenum.car.task;

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

import com.chenum.car.dao.CarDao;
import com.chenum.car.dao.CityDao;
import com.chenum.car.po.CityPo;
import com.chenum.car.type.PayXinEnum;

@Component
@EnableScheduling
public class CrawlXinTask {
	
	private static final Logger logger = LoggerFactory.getLogger(CrawlXinTask.class);

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
		List<CityPo> cityList = cityDao.list("");
		if (null == cityList || cityList.isEmpty()) {
			return;
		}

		for (CityPo city : cityList) {
			for (PayXinEnum payType : PayXinEnum.values()) {
				CrawlXinThread thread = new CrawlXinThread(carDao, city, payType);
				executorService.submit(thread);
			}
		}
	}

}