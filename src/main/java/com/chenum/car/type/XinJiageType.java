package com.chenum.car.type;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public enum XinJiageType {
	
	PRICE_0_5("5万以下", "0-5"),
	PRICE_5_10("5-10万", "5-10"),
	PRICE_10_15("10-15万", "10-15"),
	PRICE_15_20("15-20万", "15-20"),
	PRICE_20_30("20-30万", "20-30"),
	PRICE_30_50("30-50万", "30-50"),
	PRICE_50_("50万以上", "50-");
	
	private String id;
	private String name;
	
	private XinJiageType(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this);
	}

	public static void main(String[] args) {
		XinJiageType[] types = XinJiageType.values();
		for (XinJiageType type : types) {
			System.out.println(type);
		}
	}
}