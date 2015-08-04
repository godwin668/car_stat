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
	private Long id;

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
	 * 优信ID
	 */
	@Column(name = "id_xin", length = 255, nullable = false)
	private String idXin;

	/**
	 * 58ID
	 */
	@Column(name = "id_58", length = 255, nullable = false)
	private String id58;

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

	public CityPo() {
		super();
	}

	public CityPo(Long id, String province, String name, String idXin, String id58, String listXin, String list58) {
		this.id = id;
		this.province = province;
		this.name = name;
		this.idXin = idXin;
		this.id58 = id58;
		this.listXin = listXin;
		this.list58 = list58;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}