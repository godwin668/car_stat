package com.chenum.car.type;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public enum XinCheyuanType {
	
	QUANBUCHEYUAN("全部车源", "1"),
	WUSHIGUCHENGNUO("无事故承诺", "2"),
	YUANCHANGZHIBAO("原厂质保", "3"),
	SHANGJIAZHIBAO("商家质保", "4"),
	GERENCHEYUAN("个人车源", "6");
	
	private String id;
	private String name;
	
	private XinCheyuanType(String name, String id) {
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
		return ReflectionToStringBuilder.toString(this);
	}

	public static void main(String[] args) {
		XinCheyuanType[] types = XinCheyuanType.values();
		for (XinCheyuanType type : types) {
			System.out.println(type);
		}
	}
}