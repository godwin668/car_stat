package com.idocv.demo.po;

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
public class City implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8532647848157372803L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "xin_id", length = 255, nullable = false)
	private String xinId;

	@Column(name = "province", length = 255, nullable = false)
	private String province;

	@Column(name = "name", length = 255, nullable = false)
	private String name;

	@Column(name = "listname", length = 255, nullable = false)
	private String listname;

	public City() {
		super();
	}

	public City(String xinId, String province, String name, String listname) {
		this.xinId = xinId;
		this.province = province;
		this.name = name;
		this.listname = listname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getXinId() {
		return xinId;
	}

	public void setXinId(String xinId) {
		this.xinId = xinId;
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

	public String getListname() {
		return listname;
	}

	public void setListname(String listname) {
		this.listname = listname;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}