package com.chenum.car.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTask {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseTask.class);
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
	public static Elements getRemoteDom(String url, String dom) {
		return getRemoteDom(0, url, dom);
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