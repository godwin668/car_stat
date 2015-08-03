package com.idocv.car.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupUtil {

	/**
	 * get remote html
	 * 
	 * @param url
	 * @param dom
	 * @return
	 */
	public static Elements getRemoteDom(String url, String dom) {
		try {
			Document doc = Jsoup.connect(url).get();
			return doc.select(dom);
		} catch (Exception e) {
			e.printStackTrace();
			return new Elements();
		}
	}

}