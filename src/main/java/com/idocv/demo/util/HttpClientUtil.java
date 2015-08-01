package com.idocv.demo.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;


public class HttpClientUtil {
	public static String post(String url, Map<String, String> paramMap) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url);

			// params
			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			if (null != paramMap && !paramMap.isEmpty()) {
				for (Entry<String, String> entry : paramMap.entrySet()) {
					urlParameters.add(new BasicNameValuePair(entry.getKey(),
							entry.getValue()));
				}
			}
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}