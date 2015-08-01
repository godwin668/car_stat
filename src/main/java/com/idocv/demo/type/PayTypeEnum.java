package com.idocv.demo.type;

public enum PayTypeEnum {
	
	SALE("s"), HALF("h");

	private String value;
	
	private PayTypeEnum(String value) {
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
		System.out.println(PayTypeEnum.HALF.getValue());
	}
}