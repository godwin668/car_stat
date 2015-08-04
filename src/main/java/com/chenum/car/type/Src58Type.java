package com.chenum.car.type;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public enum Src58Type {
	
	QUANBUCHEYUAN("全部车源", "-1"),
	GERENCHEYUAN("个人车源", "0"),
	SHANGJIAZHIBAO("商家车源", "1"),
	VINJIANCE("VIN码检测", "2");
	
	private String id;
	private String name;
	
	private Src58Type(String name, String id) {
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
		Src58Type[] types = Src58Type.values();
		for (Src58Type type : types) {
			System.out.println(type);
		}
	}
}