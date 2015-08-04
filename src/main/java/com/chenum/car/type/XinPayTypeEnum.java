package com.chenum.car.type;

public enum XinPayTypeEnum {
	
	SALE("s"), HALF("h");

	private String value;
	
	private XinPayTypeEnum(String value) {
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
		System.out.println(XinPayTypeEnum.HALF.getValue());
	}
}