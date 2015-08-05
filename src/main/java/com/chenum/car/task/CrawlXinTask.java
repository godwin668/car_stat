package com.chenum.car.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.chenum.car.dao.CarDao;
import com.chenum.car.dao.CityDao;
import com.chenum.car.po.CarPo;
import com.chenum.car.po.CityPo;
import com.chenum.car.type.AgeType;
import com.chenum.car.type.MilageType;
import com.chenum.car.type.PayXinEnum;
import com.chenum.car.type.PriceType;
import com.chenum.car.type.SrcXinType;
import com.chenum.car.util.CrawlXinUtil;

@Component
@EnableScheduling
public class CrawlXinTask extends BaseTask {
	
	private static final Logger logger = LoggerFactory.getLogger(CrawlXinTask.class);
	
	private static final String BASE_URL_XIN = "http://www.xin.com/";
	private static final String DOM_SUM_CAR = ".car-upper span em";

	@Resource
	private CityDao cityDao;

	@Resource
	private CarDao carDao;

	// 0 0 22 * * ?
	@Scheduled(cron = "${task.crawl.xin.cron}")
	public void run() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.warn("[Crawl Task XIN] " + df.format(new Date()));

		// get cities
		List<CityPo> cityList = cityDao.list("");
		if (null == cityList || cityList.isEmpty()) {
			return;
		}

		for (CityPo city : cityList) {
			for (PayXinEnum payType : PayXinEnum.values()) {
				logger.info("[Crawl Xin Task START] " + city.getName() + " - " + payType.getValue());
				CarPo carXin = CrawlXinUtil.doCrawl(city, payType);
				carDao.save(carXin);
				logger.info("[Crawl Xin Task DONE] " + city.getName() + " - " + payType.getValue() + " - " + carXin);
			}
		}
	}
	
	public static CarPo doCrawl(CityPo city, PayXinEnum payType) {
		CarPo data = new CarPo();

		// city
		String cityListname = city.getListXin();
		String cityUrl = BASE_URL_XIN + cityListname + "/";

		// sale & half
		String buyUrl = cityUrl + payType.getValue() + "/";

		log(city.getProvince() + "_" + city.getName(), " ----------- ");

		// 车源
		SrcXinType[] cheyuanTypes = SrcXinType.values();
		for (SrcXinType type : cheyuanTypes) {
			String cheyuanUrl = buyUrl + "v" + type.getId() + "/";
			Elements element = getRemoteDom(cheyuanUrl, DOM_SUM_CAR);
			log("车源_" + type.getName() + "_" + cheyuanUrl,
					element.html());

			// set result
			if ("全部车源".equalsIgnoreCase(type.getName())) {
				data.setSrcAll(getSumFromStr(element.html()));
			} else if ("无事故承诺".equalsIgnoreCase(type.getName())) {
				data.setSrcNoAccident(getSumFromStr(element.html()));
			} else if ("原厂质保".equalsIgnoreCase(type.getName())) {
				data.setSrcOriginal(getSumFromStr(element.html()));
			} else if ("商家质保".equalsIgnoreCase(type.getName())) {
				data.setSrcBySeller(getSumFromStr(element.html()));
			} else if ("个人车源".equalsIgnoreCase(type.getName())) {
				data.setSrcPersonal(getSumFromStr(element.html()));
			}
		}

		// 车龄
		AgeType[] chelingTypes = AgeType.values();
		for (AgeType type : chelingTypes) {
			String chelingUrl = buyUrl + "r" + type.getIdXin() + "/";
			Elements element = getRemoteDom(chelingUrl, DOM_SUM_CAR);
			log("车龄_" + type.getName() + "_" + chelingUrl,
					element.html());

			// set result
			if ("一年内".equalsIgnoreCase(type.getName())) {
				data.setAge_1(getSumFromStr(element.html()));
			} else if ("1-3年".equalsIgnoreCase(type.getName())) {
				data.setAge_1_3(getSumFromStr(element.html()));
			} else if ("3-5年".equalsIgnoreCase(type.getName())) {
				data.setAge_3_5(getSumFromStr(element.html()));
			} else if ("5-8年".equalsIgnoreCase(type.getName())) {
				data.setAge_3_5(getSumFromStr(element.html()));
			} else if ("8年以上".equalsIgnoreCase(type.getName())) {
				data.setAge_8(getSumFromStr(element.html()));
			}
		}

		// 里程
		MilageType[] lichengTypes = MilageType.values();
		for (MilageType type : lichengTypes) {
			String lichengUrl = buyUrl + "k" + type.getIdXin() + "/";
			Elements element = getRemoteDom(lichengUrl, DOM_SUM_CAR);
			log("里程_" + type.getName() + "_" + lichengUrl, element.html());

			// set result
			if ("1万公里内".equalsIgnoreCase(type.getName())) {
				data.setMilage_1(getSumFromStr(element.html()));
			} else if ("1-3万公里".equalsIgnoreCase(type.getName())) {
				data.setMilage_1_3(getSumFromStr(element.html()));
			} else if ("3-6万公里".equalsIgnoreCase(type.getName())) {
				data.setMilage_3_6(getSumFromStr(element.html()));
			} else if ("6-10万公里".equalsIgnoreCase(type.getName())) {
				data.setMilage_6_10(getSumFromStr(element.html()));
			} else if ("10-20万公里".equalsIgnoreCase(type.getName())) {
				data.setMilage_10_20(getSumFromStr(element.html()));
			} else if ("20万公里以上".equalsIgnoreCase(type.getName())) {
				data.setMilage_20(getSumFromStr(element.html()));
			}
		}

		// 价格
		PriceType[] jiageTypes = PriceType.values();
		for (PriceType type : jiageTypes) {
			String jiageUrl = buyUrl + "k" + type.getIdXin() + "/";
			Elements element = getRemoteDom(jiageUrl, DOM_SUM_CAR);
			log("价格_" + type.getName() + "_" + jiageUrl, element.html());

			// set result
			if ("5万以下".equalsIgnoreCase(type.getName())) {
				data.setPrice_5(getSumFromStr(element.html()));
			} else if ("5-10万".equalsIgnoreCase(type.getName())) {
				data.setPrice_5_10(getSumFromStr(element.html()));
			} else if ("10-15万".equalsIgnoreCase(type.getName())) {
				data.setPrice_10_15(getSumFromStr(element.html()));
			} else if ("15-20万".equalsIgnoreCase(type.getName())) {
				data.setPrice_15_20(getSumFromStr(element.html()));
			} else if ("20-30万".equalsIgnoreCase(type.getName())) {
				data.setPrice_20_30(getSumFromStr(element.html()));
			} else if ("30-50万".equalsIgnoreCase(type.getName())) {
				data.setPrice_30_50(getSumFromStr(element.html()));
			} else if ("50万以上".equalsIgnoreCase(type.getName())) {
				data.setPrice_50(getSumFromStr(element.html()));
			}
		}

		data.setCtime(new Date());
		data.setCityId(city.getId());
		data.setPay_type(payType.getValue());
		return data;
	}
}