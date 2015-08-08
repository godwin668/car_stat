package com.chenum.car.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "city")
public class CityPo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8532647848157372803L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/**
	 * 省
	 */
	@Column(name = "province", length = 255, nullable = false)
	private String province;

	/**
	 * 城市名称
	 */
	@Column(name = "name", length = 255, nullable = false)
	private String name;

	/**
	 * 列表名称 - 优信
	 */
	@Column(name = "list_xin", length = 255, nullable = false)
	private String listXin;

	/**
	 * 列表名称 - 58
	 */
	@Column(name = "list_58", length = 255, nullable = false)
	private String list58;

	/**
	 * 经度
	 */
	@Column(name = "longitude", length = 20)
	private float longitude;

	/**
	 * 纬度
	 */
	@Column(name = "latitude", length = 20)
	private float latitude;

	public CityPo() {
		super();
	}

	public CityPo(int id, String province, String name, String listXin, String list58) {
		this.id = id;
		this.province = province;
		this.name = name;
		this.listXin = listXin;
		this.list58 = list58;
	}
	
	public CityPo(int id, String province, String name, String listXin, String list58, float longitude, float latitude) {
		this.id = id;
		this.province = province;
		this.name = name;
		this.listXin = listXin;
		this.list58 = list58;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getListXin() {
		return listXin;
	}

	public void setListXin(String listXin) {
		this.listXin = listXin;
	}

	public String getList58() {
		return list58;
	}

	public void setList58(String list58) {
		this.list58 = list58;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}