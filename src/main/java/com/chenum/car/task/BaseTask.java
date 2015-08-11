package com.chenum.car.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTask {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseTask.class);
	
	public static final ExecutorService es = Executors.newFixedThreadPool(10);

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
			Document doc = Jsoup
					.connect(url)
					.userAgent(
							"Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
					.referrer("http://www.baidu.com").get();
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