package com.idocv.demo.type;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public enum XinCityType {
	
	// http://www.xin.com/beijing/s/o2a10i1v1r0-1/
	
	quanguo("0", "全国", "全国", "quanguo"),
	beijing("201", "北京", "北京", "beijing"),
	chengdu("2501", "四川", "成都", "chengdu"),
	dalian("1708", "辽宁", "大连", "dalian"),
	foshan("518", "广东", "佛山", "foshan"),
	guangzhou("501", "广东", "广州", "guangzhou"),
	haerbin("1101", "黑龙江", "哈尔滨", "haerbin"),
	hangzhou("3001", "浙江", "杭州", "hangzhou"),
	hefei("101", "安徽", "合肥", "hefei"),
	jinan("2101", "山东", "济南", "jinan"),
	nanning("601", "广西", "南宁", "nanning"),
	ningbo("3002", "浙江", "宁波", "ningbo"),
	qingdao("2102", "山东", "青岛", "qingdao"),
	shanghai("2401", "上海", "上海", "shanghai"),
	shenzhen("502", "广东", "深圳", "shenzhen"),
	shenyang("1701", "辽宁", "沈阳", "shenyang"),
	shijiazhuang("901", "河北", "石家庄", "shijiazhuang"),
	suzhou("1502", "江苏", "苏州", "suzhou"),
	taiyuan("2201", "山西", "太原", "taiyuan"),
	tianjin("2601", "天津", "天津", "tianjin"),
	wuhan("1201", "湖北", "武汉", "wuhan"),
	xian("2301", "陕西", "西安", "xian"),
	changchun("1401", "吉林", "长春", "changchun"),
	changsha("1301", "湖南", "长沙", "changsha"),
	zhengzhou("1001", "河南", "郑州", "zhengzhou"),
	chongqing("3101", "重庆", "重庆", "chongqing");
	
	private String id;
	private String province;
	private String name;
	private String list;
	
	private XinCityType(String id, String province, String name, String list) {
		this.id = id;
		this.province = province;
		this.name = name;
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public static void main(String[] args) {
		XinCityType[] types = XinCityType.values();
		for (XinCityType type : types) {
			System.out.println(type);
		}
	}
}