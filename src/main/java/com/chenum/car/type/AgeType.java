package com.chenum.car.type;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public enum AgeType {
	
	// http://www.xin.com/beijing/s/o2a10i1v1r0-1/

	YEAR_0_1("一年内", "0-1", "pve_5883_2014_9999/"),
	YEAR_1_3("1-3年", "1-3", "pve_5883_2011_2013/"),
	YEAR_3_5("3-5年", "3-5", "pve_5883_2009_2011/"),
	YEAR_5_8("5-8年", "5-8", "pve_5883_2006_2009/"),
	YEAR_8_("8年以上", "8-", "pve_5883_2004_2006/|pve_5883_1900_2004/");
	
	private String name;
	private String idXin;
	private String id58;
	
	private AgeType(String name, String idXin, String id58) {
		this.name = name;
		this.idXin = idXin;
		this.id58 = id58;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdXin() {
		return idXin;
	}

	public void setIdXin(String idXin) {
		this.idXin = idXin;
	}

	public String getId58() {
		return id58;
	}

	public void setId58(String id58) {
		this.id58 = id58;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public static void main(String[] args) {
		AgeType[] types = AgeType.values();
		for (AgeType type : types) {
			System.out.println(type);
		}
	}
}