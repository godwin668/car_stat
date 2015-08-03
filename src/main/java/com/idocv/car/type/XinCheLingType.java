package com.idocv.car.type;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public enum XinCheLingType {
	
	// http://www.xin.com/beijing/s/o2a10i1v1r0-1/

	YEAR_0_1("一年内", "0-1"),
	YEAR_1_3("1-3年", "1-3"),
	YEAR_3_5("3-5年", "3-5"),
	YEAR_5_8("5-8年", "5-8"),
	YEAR_8_("8年以上", "8-");
	
	private String id;
	private String name;
	
	private XinCheLingType(String name, String id) {
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
		XinCheLingType[] types = XinCheLingType.values();
		for (XinCheLingType type : types) {
			System.out.println(type);
		}
	}
}