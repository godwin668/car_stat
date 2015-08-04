package com.chenum.car.type;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public enum PriceType {
	
	PRICE_0_5("5万以下", "0-5", "0_5"),
	PRICE_5_10("5-10万", "5-10", "5_10"),
	PRICE_10_15("10-15万", "10-15", "10_15"),
	PRICE_15_20("15-20万", "15-20", "15_20"),
	PRICE_20_30("20-30万", "20-30", "20_30"),
	PRICE_30_50("30-50万", "30-50", "30_50"),
	PRICE_50_("50万以上", "50-", "50_999999");
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 优信ID
	 */
	private String idXin;
	
	/**
	 * 58ID
	 */
	private String id58;
	
	private PriceType(String name, String idXin, String id58) {
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
		PriceType[] types = PriceType.values();
		for (PriceType type : types) {
			System.out.println(type);
		}
	}
}