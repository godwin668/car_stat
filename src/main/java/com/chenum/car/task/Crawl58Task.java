package com.chenum.car.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.chenum.car.dao.CarDao;
import com.chenum.car.dao.CityDao;
import com.chenum.car.po.CarPo;
import com.chenum.car.po.CityPo;
import com.chenum.car.type.AgeType;
import com.chenum.car.type.MilageType;
import com.chenum.car.type.PriceType;
import com.chenum.car.type.Src58Type;

@Component
@EnableScheduling
public class Crawl58Task {
	
	private static final Logger logger = LoggerFactory.getLogger(Crawl58Task.class);
	
	private static final String BASE_URL_58 = "http://<city>.58.com/ershouche/";
	private static final String DOM_SUM_CAR = ".infocont strong";
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Resource
	private CityDao cityDao;

	@Resource
	private CarDao carDao;

	@Value("${task.crawl.58.freq}")
	private int sleepSeconds;

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
			logger.info("[Crawl 58 Task START] " + city.getName());
			CarPo car58 = doCrawl(sleepSeconds, city);
			carDao.save(car58);
			logger.info("[Crawl 58 Task DONE] " + city.getName() + " - " + car58);
		}
	}
	
	/**
	 * 抓取数据
	 * 
	 * @param city
	 * @return
	 */
	public static CarPo doCrawl(int sleepSeconds, CityPo city) {
		CarPo data = new CarPo();

		// city
		String cityListname = city.getList58();
		String basicUrl = BASE_URL_58.replaceFirst("<city>", cityListname);

		log(city.getProvince() + "_" + city.getName(), " ----------- ");

		// 车源
		Src58Type[] cheyuanTypes = Src58Type.values();
		for (Src58Type type : cheyuanTypes) {
			if (Src58Type.ALL.equals(type)) {
				String cheyuanUrl = basicUrl;
				Elements element = getRemoteDom(sleepSeconds, cheyuanUrl, DOM_SUM_CAR);
				log("车源_" + type.getName() + "_" + cheyuanUrl, element.html());
				data.setSrcAll(getSumFromStr(element.html()));
			} else if (Src58Type.PERSONAL.equals(type)) {
				String cheyuanUrl = basicUrl + "0/";
				Elements element = getRemoteDom(sleepSeconds, cheyuanUrl, DOM_SUM_CAR);
				log("车源_" + type.getName() + "_" + cheyuanUrl, element.html());
				data.setSrcPersonal(getSumFromStr(element.html()));
			} else if (Src58Type.SELLER.equals(type)) {
				String cheyuanUrl = basicUrl + "1/";
				Elements element = getRemoteDom(sleepSeconds, cheyuanUrl, DOM_SUM_CAR);
				log("车源_" + type.getName() + "_" + cheyuanUrl, element.html());
				data.setSrcBySeller(getSumFromStr(element.html()));
			} else if (Src58Type.VIN.equals(type)) {
				String cheyuanUrl = basicUrl + "?kpjiance=1";
				Elements element = getRemoteDom(sleepSeconds, cheyuanUrl, DOM_SUM_CAR);
				log("车源_" + type.getName() + "_" + cheyuanUrl, element.html());
				data.setSrcVin(getSumFromStr(element.html()));
			}
		}

		// 车龄
		AgeType[] chelingTypes = AgeType.values();
		for (AgeType type : chelingTypes) {
			if (AgeType.YEAR_0_1.equals(type)) {
				String chelingUrl = basicUrl + type.getId58();
				Elements element = getRemoteDom(sleepSeconds, chelingUrl, DOM_SUM_CAR);
				log("车龄_" + type.getName() + "_" + chelingUrl, element.html());
				data.setAge_1(getSumFromStr(element.html()));
			} else if (AgeType.YEAR_1_3.equals(type)) {
				String chelingUrl = basicUrl + type.getId58();
				Elements element = getRemoteDom(sleepSeconds, chelingUrl, DOM_SUM_CAR);
				log("车龄_" + type.getName() + "_" + chelingUrl, element.html());
				data.setAge_1_3(getSumFromStr(element.html()));
			} else if (AgeType.YEAR_3_5.equals(type)) {
				String chelingUrl = basicUrl + type.getId58();
				Elements element = getRemoteDom(sleepSeconds, chelingUrl, DOM_SUM_CAR);
				log("车龄_" + type.getName() + "_" + chelingUrl, element.html());
				data.setAge_3_5(getSumFromStr(element.html()));
			} else if (AgeType.YEAR_5_8.equals(type)) {
				String chelingUrl = basicUrl + type.getId58();
				Elements element = getRemoteDom(sleepSeconds, chelingUrl, DOM_SUM_CAR);
				log("车龄_" + type.getName() + "_" + chelingUrl, element.html());
				data.setAge_5_8(getSumFromStr(element.html()));
			} else if (AgeType.YEAR_8_.equals(type)) {
				String[] year8Split = type.getId58().split("\\|");
				int year8Sum = 0;
				for (int i = 0; i < year8Split.length; i++) {
					String chelingUrl = basicUrl + year8Split[i];
					Elements element = getRemoteDom(sleepSeconds, chelingUrl, DOM_SUM_CAR);
					year8Sum += getSumFromStr(element.html());
				}
				log("车龄_" + type.getName() + "_" + type.getId58(), year8Sum);
				data.setAge_8(year8Sum);
			}
		}
		
		// 里程
		// Demo URL: http://bj.58.com/ershouche/?sort=rundistance&rundistance=3_4
		MilageType[] lichengTypes = MilageType.values();
		for (MilageType type : lichengTypes) {
			String lichengUrl = basicUrl + "?sort=rundistance&rundistance=" + type.getId58();
			Elements element = getRemoteDom(sleepSeconds, lichengUrl, DOM_SUM_CAR);
			log("里程_" + type.getName() + "_" + lichengUrl, element.html());

			// set result
			if (MilageType.KM_0_1.equals(type)) {
				data.setMilage_1(getSumFromStr(element.html()));
			} else if (MilageType.KM_1_3.equals(type)) {
				data.setMilage_1_3(getSumFromStr(element.html()));
			} else if (MilageType.KM_3_6.equals(type)) {
				data.setMilage_3_6(getSumFromStr(element.html()));
			} else if (MilageType.KM_6_10.equals(type)) {
				data.setMilage_6_10(getSumFromStr(element.html()));
			} else if (MilageType.KM_10_20.equals(type)) {
				data.setMilage_10_20(getSumFromStr(element.html()));
			} else if (MilageType.KM_20_.equals(type)) {
				data.setMilage_20(getSumFromStr(element.html()));
			}
		}

		// 价格
		PriceType[] jiageTypes = PriceType.values();
		for (PriceType type : jiageTypes) {
			String jiageUrl = basicUrl + "?minprice=" + type.getId58();
			Elements element = getRemoteDom(sleepSeconds, jiageUrl, DOM_SUM_CAR);
			log("价格_" + type.getName() + "_" + jiageUrl, element.html());

			// set result
			if (PriceType.PRICE_0_5.equals(type)) {
				data.setPrice_5(getSumFromStr(element.html()));
			} else if (PriceType.PRICE_5_10.equals(type)) {
				data.setPrice_5_10(getSumFromStr(element.html()));
			} else if (PriceType.PRICE_10_15.equals(type)) {
				data.setPrice_10_15(getSumFromStr(element.html()));
			} else if (PriceType.PRICE_15_20.equals(type)) {
				data.setPrice_15_20(getSumFromStr(element.html()));
			} else if (PriceType.PRICE_20_30.equals(type)) {
				data.setPrice_20_30(getSumFromStr(element.html()));
			} else if (PriceType.PRICE_30_50.equals(type)) {
				data.setPrice_30_50(getSumFromStr(element.html()));
			} else if (PriceType.PRICE_50_.equals(type)) {
				data.setPrice_50(getSumFromStr(element.html()));
			}
		}

		data.setCtime(new Date());
		data.setCityId(city.getId());
		return data;
	}

	public static int getSumFromStr(String sum) {
		if (null != sum && sum.matches("\\d+")) {
			return Integer.valueOf(sum);
		} else {
			return 0;
		}
	}

	/**
	 * get remote html
	 * 
	 * @param url
	 * @param dom
	 * @return
	 */
	public static Elements getRemoteDom(int sleepSeconds, String url, String dom) {
		try {
			Thread.sleep(sleepSeconds * 1000);
			Document doc = Jsoup.connect(url).get();
			return doc.select(dom);
		} catch (Exception e) {
			e.printStackTrace();
			return new Elements();
		}
	}

	public static void log(String title, Object msg) {
		System.out.println("-----------------------");
		title = StringUtils.isBlank(title) ? "[INFO] - " : "[" + title + "] - ";
		System.out.println("[" + df.format(new Date()) + "]" + title + msg);
	}
}