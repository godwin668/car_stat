package com.chenum.car.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.jsoup.select.Elements;

import com.chenum.car.po.CarPo;
import com.chenum.car.po.CityPo;
import com.chenum.car.type.AgeType;
import com.chenum.car.type.PriceType;
import com.chenum.car.type.Src58Type;

public class Crawl58Util {
	
	private static final String BASE_URL_58 = "http://<city>.58.com/ershouche/";
	private static final String DOM_SUM_CAR = "#infolist .filterbar table tr td label span";
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static CarPo doCrawl(CityPo city) {
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
				Elements element = JsoupUtil.getRemoteDom(cheyuanUrl, DOM_SUM_CAR);
				log("车源_" + type.getName() + "_" + cheyuanUrl, element.html());
				data.setSrcAll(getSumFromStr(element.html()));
			} else if (Src58Type.PERSONAL.equals(type)) {
				String cheyuanUrl = basicUrl + "0/";
				Elements element = JsoupUtil.getRemoteDom(cheyuanUrl, DOM_SUM_CAR);
				log("车源_" + type.getName() + "_" + cheyuanUrl, element.html());
				data.setSrcPersonal(getSumFromStr(element.html()));
			} else if (Src58Type.SELLER.equals(type)) {
				String cheyuanUrl = basicUrl + "1/";
				Elements element = JsoupUtil.getRemoteDom(cheyuanUrl, DOM_SUM_CAR);
				log("车源_" + type.getName() + "_" + cheyuanUrl, element.html());
				data.setSrcBySeller(getSumFromStr(element.html()));
			} else if (Src58Type.VIN.equals(type)) {
				String cheyuanUrl = basicUrl + "?kpjiance=1";
				Elements element = JsoupUtil.getRemoteDom(cheyuanUrl, DOM_SUM_CAR);
				log("车源_" + type.getName() + "_" + cheyuanUrl, element.html());
				data.setSrcVin(getSumFromStr(element.html()));
			}
		}

		// 车龄
		AgeType[] chelingTypes = AgeType.values();
		for (AgeType type : chelingTypes) {
			if (AgeType.YEAR_0_1.equals(type)) {
				String chelingUrl = basicUrl + type.getId58();
				Elements element = JsoupUtil.getRemoteDom(chelingUrl, DOM_SUM_CAR);
				log("车龄_" + type.getName() + "_" + chelingUrl, element.html());
				data.setAge_1(getSumFromStr(element.html()));
			} else if (AgeType.YEAR_1_3.equals(type)) {
				String chelingUrl = basicUrl + type.getId58();
				Elements element = JsoupUtil.getRemoteDom(chelingUrl, DOM_SUM_CAR);
				log("车龄_" + type.getName() + "_" + chelingUrl, element.html());
				data.setAge_1_3(getSumFromStr(element.html()));
			} else if (AgeType.YEAR_3_5.equals(type)) {
				String chelingUrl = basicUrl + type.getId58();
				Elements element = JsoupUtil.getRemoteDom(chelingUrl, DOM_SUM_CAR);
				log("车龄_" + type.getName() + "_" + chelingUrl, element.html());
				data.setAge_3_5(getSumFromStr(element.html()));
			} else if (AgeType.YEAR_5_8.equals(type)) {
				String chelingUrl = basicUrl + type.getId58();
				Elements element = JsoupUtil.getRemoteDom(chelingUrl, DOM_SUM_CAR);
				log("车龄_" + type.getName() + "_" + chelingUrl, element.html());
				data.setAge_3_5(getSumFromStr(element.html()));
			} else if (AgeType.YEAR_8_.equals(type)) {
				String[] year8Split = type.getId58().split("|");
				int year8Sum = 0;
				for (int i = 0; i < year8Split.length; i++) {
					String chelingUrl = basicUrl + year8Split[i];
					Elements element = JsoupUtil.getRemoteDom(chelingUrl, DOM_SUM_CAR);
					year8Sum += getSumFromStr(element.html());
				}
				log("车龄_" + type.getName() + "_" + type.getId58(), year8Sum);
				data.setAge_8(year8Sum);
			}
		}

		// 价格
		PriceType[] jiageTypes = PriceType.values();
		for (PriceType type : jiageTypes) {
			String jiageUrl = basicUrl + "?minprice=" + type.getId58();
			Elements element = JsoupUtil.getRemoteDom(jiageUrl, DOM_SUM_CAR);
			log("价格_" + type.getName() + "_" + jiageUrl, element.html());

			// set result
			if (PriceType.PRICE_0_5.equals(type.getName())) {
				data.setPrice_5(getSumFromStr(element.html()));
			} else if (PriceType.PRICE_5_10.equals(type.getName())) {
				data.setPrice_5_10(getSumFromStr(element.html()));
			} else if (PriceType.PRICE_10_15.equals(type.getName())) {
				data.setPrice_10_15(getSumFromStr(element.html()));
			} else if (PriceType.PRICE_15_20.equals(type.getName())) {
				data.setPrice_15_20(getSumFromStr(element.html()));
			} else if (PriceType.PRICE_20_30.equals(type.getName())) {
				data.setPrice_20_30(getSumFromStr(element.html()));
			} else if (PriceType.PRICE_30_50.equals(type.getName())) {
				data.setPrice_30_50(getSumFromStr(element.html()));
			} else if (PriceType.PRICE_50_.equals(type.getName())) {
				data.setPrice_50(getSumFromStr(element.html()));
			}
		}

		data.setCtime(new Date());
		data.setCityId(city.getId58());
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