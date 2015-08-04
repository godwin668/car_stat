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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.chenum.car.dao.CarDao;
import com.chenum.car.dao.CityDao;
import com.chenum.car.po.CityPo;

@Component
@EnableScheduling
public class Crawl58Task {
	
	private static final Logger logger = LoggerFactory.getLogger(Crawl58Task.class);

	@Resource
	private CityDao cityDao;

	@Resource
	private CarDao carDao;

	@Value("${task.crawl.58.freq}")
	private int taskCrawl58Freq;

	ExecutorService executorService = Executors.newFixedThreadPool(5);

	// 0 0 22 * * ?
	@Scheduled(cron = "${task.crawl.58.cron}")
	public void run() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.warn("[Crawl Task 58] " + df.format(new Date()));

		// get cities
		List<CityPo> cityList = cityDao.list("");
		if (null == cityList || cityList.isEmpty()) {
			return;
		}

		for (CityPo city : cityList) {
			Crawl58Thread thread = new Crawl58Thread(carDao, city);
			executorService.submit(thread);
		}
	}

}