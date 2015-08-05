package com.chenum.car.type;

public enum AppType {

	WUBA(1, "58二手车"), YOUXIN(2, "优信二手车");
	
	private int id;
	private String name;
	
	private AppType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static AppType getById(int id) {
		AppType[] values = values();
		for (AppType appType : values) {
			if (appType.getId() == id) {
				return appType;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "" + id;
	}

	public static void main(String[] args) {

	}
}