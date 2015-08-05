package com.chenum.car.type;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public enum MilageType {
	
	// "http://www.xin.com/{city}/{s}/o2a10i1v1k{licheng}/";

	KM_0_1("1万公里内", "0-1", "0_1"),
	KM_1_3("1-3万公里", "1-3", "1_3"),
	KM_3_6("3-6万公里", "3-6", "3_6"),
	KM_6_10("6-10万公里", "6-10", "6_10"),
	KM_10_20("10-20万公里", "10-20", "10_20"),
	KM_20_("20万公里以上", "20-", "20_999999");
	
	private String name;
	private String idXin;
	private String id58;
	
	private MilageType(String name, String idXin, String id58) {
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
		return ReflectionToStringBuilder.reflectionToString(this);
	}

	public static void main(String[] args) {
		MilageType[] types = MilageType.values();
		for (MilageType type : types) {
			System.out.println(type);
		}
	}
}