package com.chenum.car.type;

public enum PayXinEnum {

	SALE("s"), HALF("h");

	private String value;

	private PayXinEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	public static void main(String[] args) {
		System.out.println(PayXinEnum.HALF.getValue());
	}
}