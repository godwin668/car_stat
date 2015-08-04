package com.chenum.car.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class CarXinVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	/**
	 * 创建时间
	 */
	private String ctime;

	/**
	 * Xin 城市ID
	 */
	private String cityId;

	/**
	 * 城市名称
	 */
	private String cityName;

	/**
	 * 买车：s，付一半：h
	 */
	private String pay_type;

	/**
	 * 全部车源
	 */
	private int srcAll;

	/**
	 * 无事故承诺
	 */
	private int srcNoAccident;

	/**
	 * 原厂质保
	 */
	private int srcOriginal;

	/**
	 * 商家质保
	 */
	private int srcBySeller;

	/**
	 * 个人车源
	 */
	private int srcPersonal;

	/**
	 * 车龄_一年内
	 */
	private int age_1;

	/**
	 * 车龄_1-3年
	 */
	private int age_1_3;

	/**
	 * 车龄_3-5年
	 */
	private int age_3_5;

	/**
	 * 车龄_5-8年
	 */
	private int age_5_8;

	/**
	 * 车龄_8年以上
	 */
	private int age_8;

	/**
	 * 里程_1万公里内
	 */
	private int milage_1;

	/**
	 * 里程_1-3万公里
	 */
	private int milage_1_3;

	/**
	 * 里程_3-6万公里
	 */
	private int milage_3_6;

	/**
	 * 里程_6-10万公里
	 */
	private int milage_6_10;

	/**
	 * 里程_10-20万公里
	 */
	private int milage_10_20;

	/**
	 * 里程_20万公里以上
	 */
	private int milage_20;

	/**
	 * 价格_5万以下
	 */
	private int price_5;

	/**
	 * 价格_5-10万
	 */
	private int price_5_10;

	/**
	 * 价格_10-15万
	 */
	private int price_10_15;

	/**
	 * 价格_15-20万
	 */
	private int price_15_20;

	/**
	 * 价格_20-30万
	 */
	private int price_20_30;

	/**
	 * 价格_30-50万
	 */
	private int price_30_50;

	/**
	 * 价格_50万以上
	 */
	private int price_50;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public int getSrcAll() {
		return srcAll;
	}

	public void setSrcAll(int srcAll) {
		this.srcAll = srcAll;
	}

	public int getSrcNoAccident() {
		return srcNoAccident;
	}

	public void setSrcNoAccident(int srcNoAccident) {
		this.srcNoAccident = srcNoAccident;
	}

	public int getSrcOriginal() {
		return srcOriginal;
	}

	public void setSrcOriginal(int srcOriginal) {
		this.srcOriginal = srcOriginal;
	}

	public int getSrcBySeller() {
		return srcBySeller;
	}

	public void setSrcBySeller(int srcBySeller) {
		this.srcBySeller = srcBySeller;
	}

	public int getSrcPersonal() {
		return srcPersonal;
	}

	public void setSrcPersonal(int srcPersonal) {
		this.srcPersonal = srcPersonal;
	}

	public int getAge_1() {
		return age_1;
	}

	public void setAge_1(int age_1) {
		this.age_1 = age_1;
	}

	public int getAge_1_3() {
		return age_1_3;
	}

	public void setAge_1_3(int age_1_3) {
		this.age_1_3 = age_1_3;
	}

	public int getAge_3_5() {
		return age_3_5;
	}

	public void setAge_3_5(int age_3_5) {
		this.age_3_5 = age_3_5;
	}

	public int getAge_5_8() {
		return age_5_8;
	}

	public void setAge_5_8(int age_5_8) {
		this.age_5_8 = age_5_8;
	}

	public int getAge_8() {
		return age_8;
	}

	public void setAge_8(int age_8) {
		this.age_8 = age_8;
	}

	public int getMilage_1() {
		return milage_1;
	}

	public void setMilage_1(int milage_1) {
		this.milage_1 = milage_1;
	}

	public int getMilage_1_3() {
		return milage_1_3;
	}

	public void setMilage_1_3(int milage_1_3) {
		this.milage_1_3 = milage_1_3;
	}

	public int getMilage_3_6() {
		return milage_3_6;
	}

	public void setMilage_3_6(int milage_3_6) {
		this.milage_3_6 = milage_3_6;
	}

	public int getMilage_6_10() {
		return milage_6_10;
	}

	public void setMilage_6_10(int milage_6_10) {
		this.milage_6_10 = milage_6_10;
	}

	public int getMilage_10_20() {
		return milage_10_20;
	}

	public void setMilage_10_20(int milage_10_20) {
		this.milage_10_20 = milage_10_20;
	}

	public int getMilage_20() {
		return milage_20;
	}

	public void setMilage_20(int milage_20) {
		this.milage_20 = milage_20;
	}

	public int getPrice_5() {
		return price_5;
	}

	public void setPrice_5(int price_5) {
		this.price_5 = price_5;
	}

	public int getPrice_5_10() {
		return price_5_10;
	}

	public void setPrice_5_10(int price_5_10) {
		this.price_5_10 = price_5_10;
	}

	public int getPrice_10_15() {
		return price_10_15;
	}

	public void setPrice_10_15(int price_10_15) {
		this.price_10_15 = price_10_15;
	}

	public int getPrice_15_20() {
		return price_15_20;
	}

	public void setPrice_15_20(int price_15_20) {
		this.price_15_20 = price_15_20;
	}

	public int getPrice_20_30() {
		return price_20_30;
	}

	public void setPrice_20_30(int price_20_30) {
		this.price_20_30 = price_20_30;
	}

	public int getPrice_30_50() {
		return price_30_50;
	}

	public void setPrice_30_50(int price_30_50) {
		this.price_30_50 = price_30_50;
	}

	public int getPrice_50() {
		return price_50;
	}

	public void setPrice_50(int price_50) {
		this.price_50 = price_50;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}