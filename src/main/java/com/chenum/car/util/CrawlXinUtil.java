package com.chenum.car.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.jsoup.select.Elements;

import com.chenum.car.po.CarPo;
import com.chenum.car.po.City;
import com.chenum.car.type.XinCheLingType;
import com.chenum.car.type.XinCheyuanType;
import com.chenum.car.type.XinJiageType;
import com.chenum.car.type.XinLiChengType;
import com.chenum.car.type.XinPayTypeEnum;

public class CrawlXinUtil {
	
	private static final String BASE_URL_XIN = "http://www.xin.com/";
	private static final String DOM_SUM_CAR = ".car-upper span em";
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static CarPo doCrawl(City city, XinPayTypeEnum payType) {
		CarPo data = new CarPo();

		// city
		String cityListname = city.getListname();
		String cityUrl = BASE_URL_XIN + cityListname + "/";

		// sale & half
		String buyUrl = cityUrl + payType.getValue() + "/";

		log(city.getProvince() + "_" + city.getName(), " ----------- ");

		// 车源
		XinCheyuanType[] cheyuanTypes = XinCheyuanType.values();
		for (XinCheyuanType type : cheyuanTypes) {
			String cheyuanUrl = buyUrl + "v" + type.getId() + "/";
			Elements element = JsoupUtil.getRemoteDom(cheyuanUrl,
					DOM_SUM_CAR);
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
		XinCheLingType[] chelingTypes = XinCheLingType.values();
		for (XinCheLingType type : chelingTypes) {
			String chelingUrl = buyUrl + "r" + type.getId() + "/";
			Elements element = JsoupUtil.getRemoteDom(chelingUrl,
					DOM_SUM_CAR);
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
		XinLiChengType[] lichengTypes = XinLiChengType.values();
		for (XinLiChengType type : lichengTypes) {
			String lichengUrl = buyUrl + "k" + type.getId() + "/";
			Elements element = JsoupUtil.getRemoteDom(lichengUrl,
					DOM_SUM_CAR);
			log("里程_" + type.getName() + "_" + lichengUrl,
					element.html());

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
		XinJiageType[] jiageTypes = XinJiageType.values();
		for (XinJiageType type : jiageTypes) {
			String jiageUrl = buyUrl + "k" + type.getId() + "/";
			Elements element = JsoupUtil.getRemoteDom(jiageUrl, DOM_SUM_CAR);
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
		data.setCityId(city.getXinId());
		data.setPay_type(payType.getValue());
		return data;
	}

	public static int getSumFromStr(String sum) {
		if (null != sum && sum.matches("\\d+")) {
			return Integer.valueOf(sum);
		} else {
			return 0;
		}
	}

	public static void log(String title, Object msg) {
		System.out.println("-----------------------");
		title = StringUtils.isBlank(title) ? "[INFO] - " : "[" + title + "] - ";
		System.out.println("[" + df.format(new Date()) + "]" + title + msg);
	}

}