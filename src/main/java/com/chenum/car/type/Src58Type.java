package com.chenum.car.type;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public enum Src58Type {
	
	ALL("全部车源", "-1"), PERSONAL("个人车源", "0"), SELLER("商家车源", "1"), VIN(
			"VIN码检测", "2");
	
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
		System.out.println(Src58Type.ALL.equals(Src58Type.PERSONAL));
		System.out.println(Src58Type.ALL == Src58Type.PERSONAL);
	}
}