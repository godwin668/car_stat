package com.chenum.car.type;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public enum MilageXinType {
	
	// "http://www.xin.com/{city}/{s}/o2a10i1v1k{licheng}/";

	KM_0_1("1万公里内", "0-1"),
	KM_1_3("1-3万公里", "1-3"),
	KM_3_6("3-6万公里", "3-6"),
	KM_6_10("6-10万公里", "6-10"),
	KM_10_20("10-20万公里", "10-20"),
	KM_20_("20万公里以上", "20-");
	
	private String id;
	private String name;
	
	private MilageXinType(String name, String id) {
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
		MilageXinType[] types = MilageXinType.values();
		for (MilageXinType type : types) {
			System.out.println(type);
		}
	}
}