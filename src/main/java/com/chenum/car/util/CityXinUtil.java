package com.chenum.car.util;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CityXinUtil {

	private static final String BASE_URL_XIN = "http://www.xin.com/beijing";
	private static final String DOM_CITY = ".fixed-head .select-city dd .cityMore";

	public static void main(String[] args) {
		Elements elements = JsoupUtil.getRemoteDom(BASE_URL_XIN, DOM_CITY);
		System.out.println(elements.html());

		System.out.println("--------");
		int count = 0;
		for (Element ele : elements) {
			Elements rowElements = ele.select("span");
			String province = rowElements.get(0).childNode(1).toString();
			Elements cityAllHtml = rowElements.get(1).getElementsByTag("a");
			for (Element eleCity : cityAllHtml) {
				String cityListName = eleCity.attr("data-ename");
				String cityName = eleCity.html();
				// System.out.println("[" + province + "]" + " - " + cityName + " - " + cityListName);
				System.out.println(cityName);
				count++;
			}
		}
		System.out.println("city count: " + count);
	}

}