/**
 * 初始化全局变量
 */
// yesterday
var yesterday = new Date().setDate(new Date().getDate() - 1);
var yesterdayStr = $.format.date(yesterday, "yyyyMMdd");

//城市经纬度Map
var cityCoordMap = {};
// geoData example: { "鄂尔多斯" : [ 109.781327, 39.608266 ], "齐齐哈尔" : [ 123.97, 47.33 ] }
$.ajax({
	type : "GET",
	url : '/city/list.json',
	async : false,
	dataType : "json"
}).done(function(data, status) {
	if ('success' === status) {
		for (var i = 0; i < data.length; i++) {
			var coordArr = [];
			coordArr.push(data[i]['longitude']);
			coordArr.push(data[i]['latitude']);
			cityCoordMap[data[i]['name']] = coordArr;
		}
	}
});

// 路径配置
require.config({
	paths : {
		echarts : 'http://echarts.baidu.com/build/dist'
	}
});

/**
 * 主入口
 */
$(document).ready(function() {
	init58();
	initXin();
	initTrend();
});

/**
 * 初始化58地图
 */
function init58() {
	// 车源数组
	var carSumArr = [];
	// 最大值（全国除外）
	var maxCount = 0;
	// 最小值（全国除外）
	var minCount = 999999999;
	// Top 5 城市
	var top5CityArr = [];

	// car data
	// example: [ { name : "成都", value : 9 }, { name : "三门峡", value : 12 } ]
	$.ajax({
		type : "GET",
		url : '/car/1/list.json?date=' + yesterdayStr,
		async : false,
		dataType : "json"
	}).done(
			function(data, status) {
				if ('success' === status) {
					for (var i = 0; i < data.length; i++) {
						var cityCarSum = {};
						cityCarSum['name'] = data[i]['cityName'];
						cityCarSum['value'] = data[i]['srcAll'];
						carSumArr.push(cityCarSum);

						if (maxCount < data[i]['srcAll']
								&& data[i]['cityName'] != '全国') {
							maxCount = data[i]['srcAll'];
						} else if (minCount > data[i]['srcAll']
								&& data[i]['cityName'] != '全国') {
							minCount = data[i]['srcAll'];
						}
					}
				}
			});

	// top 5
	carSumArr = carSumArr.sort(function(a, b) {
		return parseFloat(b.value) - parseFloat(a.value);
	});
	top5CityArr = carSumArr.slice(1, 6);

	/**
	 * 使用
	 */
	require([ 'echarts', 'echarts/chart/map' // 使用柱状图就加载bar模块，按需加载
	], function(ec) {
		// 基于准备好的dom，初始化echarts图表
		var myChart = ec.init(document.getElementById('chart-container-58'));

		var option = {
			title : {
				text : '58二手车车源数据分布图',
				subtext : '数据来源：58二手车',
				sublink : 'http://bj.58.com/ershouche',
				x : 'center'
			},
			tooltip : {
				trigger : 'item'
			},
			legend : {
				orient : 'vertical', x : 'left', data : [ '全国：' + carSumArr[0]['value'] ] 
			},
			dataRange : {
				min : minCount, // GODWIN 车源数据最小值
				max : maxCount, // GODWIN 车源数据最大值
				calculable : true,
				color : [ 'maroon', 'purple', 'red', 'orange', 'yellow',
						'lightgreen' ]
			},
			toolbox : {
				show : true,
				orient : 'vertical',
				x : 'right',
				y : 'center',
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			series : [ {
				name : '58二手车',
				type : 'map',
				mapType : 'china',
				hoverable : false,
				roam : true,
				data : [],
				markPoint : {
					symbolSize : 5, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize
					// * 2
					itemStyle : {
						normal : {
							borderColor : '#87cefa',
							borderWidth : 1, // 标注边线线宽，单位px，默认为1
							label : {
								show : false
							}
						},
						emphasis : {
							borderColor : '#1e90ff',
							borderWidth : 5,
							label : {
								show : false
							}
						}
					},
					data : carSumArr
				// GODWIN 当前城市车源数量
				},
				geoCoord : cityCoordMap
			// GODWIN 城市经纬度
			}, {
				name : 'Top5',
				type : 'map',
				mapType : 'china',
				data : [],
				markPoint : {
					symbol : 'emptyCircle',
					symbolSize : function(v) {
						return 10 + v / maxCount
					},
					effect : {
						show : true,
						shadowBlur : 0
					},
					itemStyle : {
						normal : {
							label : {
								show : false
							}
						}
					},
					data : top5CityArr
				// GODWIN top 5 city
				}
			} ]
		};

		// 为echarts对象加载数据
		myChart.setOption(option);
	});
}

/**
 * 初始化优信地图
 */
function initXin() {
	// 车源数组
	var carSumArr = [];
	// 最大值（全国除外）
	var maxCount = 0;
	// 最小值（全国除外）
	var minCount = 999999999;
	// Top 5 城市
	var top5CityArr = [];

	// car data
	// example: [ { name : "成都", value : 9 }, { name : "三门峡", value : 12 } ]
	$.ajax({
		type : "GET",
		url : '/car/2/list.json?date=' + yesterdayStr,
		async : false,
		dataType : "json"
	}).done(
			function(data, status) {
				if ('success' === status) {
					for (var i = 0; i < data.length; i++) {
						var cityCarSum = {};
						cityCarSum['name'] = data[i]['cityName'];
						cityCarSum['value'] = data[i]['srcAll'];
						carSumArr.push(cityCarSum);

						if (maxCount < data[i]['srcAll']
								&& data[i]['cityName'] != '全国') {
							maxCount = data[i]['srcAll'];
						} else if (minCount > data[i]['srcAll']
								&& data[i]['cityName'] != '全国') {
							minCount = data[i]['srcAll'];
						}
					}
				}
			});

	// top 5
	carSumArr = carSumArr.sort(function(a, b) {
		return parseFloat(b.value) - parseFloat(a.value);
	});
	top5CityArr = carSumArr.slice(1, 6);

	/**
	 * 使用
	 */
	require([ 'echarts', 'echarts/chart/map' // 使用柱状图就加载bar模块，按需加载
	], function(ec) {
		// 基于准备好的dom，初始化echarts图表
		var myChart = ec.init(document.getElementById('chart-container-xin'));

		var option = {
			title : {
				text : '优信二手车车源数据分布图',
				subtext : '数据来源：优信二手车',
				sublink : 'http://www.xin.com/',
				x : 'center'
			},
			tooltip : {
				trigger : 'item'
			},
			legend : {
				orient : 'vertical', x : 'left', data : [ '全国：' + carSumArr[0]['value'] ] 
			},
			dataRange : {
				min : minCount, // GODWIN 车源数据最小值
				max : maxCount, // GODWIN 车源数据最大值
				calculable : true,
				color : [ 'maroon', 'purple', 'red', 'orange', 'yellow',
						'lightgreen' ]
			},
			toolbox : {
				show : true,
				orient : 'vertical',
				x : 'right',
				y : 'center',
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			series : [ {
				name : '优信二手车',
				type : 'map',
				mapType : 'china',
				hoverable : false,
				roam : true,
				data : [],
				markPoint : {
					symbolSize : 5, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize
					// * 2
					itemStyle : {
						normal : {
							borderColor : '#87cefa',
							borderWidth : 1, // 标注边线线宽，单位px，默认为1
							label : {
								show : false
							}
						},
						emphasis : {
							borderColor : '#1e90ff',
							borderWidth : 5,
							label : {
								show : false
							}
						}
					},
					data : carSumArr
				// GODWIN 当前城市车源数量
				},
				geoCoord : cityCoordMap
			// GODWIN 城市经纬度
			}, {
				name : 'Top5',
				type : 'map',
				mapType : 'china',
				data : [],
				markPoint : {
					symbol : 'emptyCircle',
					symbolSize : function(v) {
						return 10 + v / maxCount
					},
					effect : {
						show : true,
						shadowBlur : 0
					},
					itemStyle : {
						normal : {
							label : {
								show : false
							}
						}
					},
					data : top5CityArr
				// GODWIN top 5 city
				}
			} ]
		};

		// 为echarts对象加载数据
		myChart.setOption(option);
	});
}

function initTrend() {
	// x轴日期数组，e.g. [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
	var dateArr = [];
	var now = new Date();
	for (var i = 1; i <= 10; i++) {
		var nDaysBefore = now.setDate(now.getDate() - 1);
		var nDaysBeforeStr = $.format.date(nDaysBefore, "yyyyMMdd");
		dateArr.unshift(nDaysBeforeStr);
	}
	var sdate = dateArr[0];

	var carSumArr = [];
	$.ajax({
		type : "GET",
		url : '/car/1/list.json?city=0&sdate=' + sdate,
		async : false,
		dataType : "json"
	}).done(
			function(data, status) {
				if ('success' === status) {
					for (var i = 0; i < data.length; i++) {
						var cityCarSum = {};
						cityCarSum['name'] = data[i]['cityName'];
						cityCarSum['value'] = data[i]['srcAll'];
						cityCarSum['ctime'] = data[i]['ctime'];
						cityCarSum['cdate'] = data[i]['cdate'];
						cityCarSum['appId'] = data[i]['appId'];
						cityCarSum['pay_type'] = data[i]['pay_type'];
						carSumArr.push(cityCarSum);
					}
				}
			});
	$.ajax({
		type : "GET",
		url : '/car/2/list.json?city=0&sdate=' + sdate,
		async : false,
		dataType : "json"
	}).done(
			function(data, status) {
				if ('success' === status) {
					for (var i = 0; i < data.length; i++) {
						var cityCarSum = {};
						cityCarSum['name'] = data[i]['cityName'];
						cityCarSum['value'] = data[i]['srcAll'];
						cityCarSum['ctime'] = data[i]['ctime'];
						cityCarSum['cdate'] = data[i]['cdate'];
						cityCarSum['appId'] = data[i]['appId'];
						cityCarSum['pay_type'] = data[i]['pay_type'];
						carSumArr.push(cityCarSum);
					}
				}
			});
	carSumArr = carSumArr.sort(function(a,b){return b.cdate - a.cdate});
	
	// 58全国最近10天数据，e.g. [ 10, 12, 21, 54, 260, 830, 710 ]
	var quanguo58 = [ ];
	// 优信全国最近10天数据，e.g. [ 10, 12, 21, 54, 260, 830, 710 ]
	var quanguoXin = [ ];
	for (var i = 0; i < carSumArr.length; i++) {
		var carSum = carSumArr[i];
		if (carSum.appId == 1) {
			quanguo58.unshift(carSum.value);
		} else if (carSum.appId == 2 && carSum.pay_type == '买车') {
			quanguoXin.unshift(carSum.value);
		}
	}
	if (10 > quanguo58.length) {
		for (var i = 10 - quanguo58.length; i > 0; i--) {
			quanguo58.unshift(0);
			quanguoXin.unshift(0);
		}
	}

	// 路径配置
	require.config({
		paths : {
			echarts : 'http://echarts.baidu.com/build/dist'
		}
	});

	/**
	 * 使用
	 */
	require([ 'echarts', 'echarts/chart/line', // 使用柱状图就加载bar模块，按需加载
	'echarts', 'echarts/chart/bar', // 使用柱状图就加载bar模块，按需加载
	], function(ec) {
		// 基于准备好的dom，初始化echarts图表
		var myChart = ec.init(document
				.getElementById('chart-container-trend'));

		var option = {
			title : {
				text : '全国二手车趋势对比分析',
				subtext : '58 vs 优信'
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '58', '优信' ]
			},
			toolbox : {
				show : true,
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar', 'stack', 'tiled' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				boundaryGap : false,
				data : dateArr
			// GODWIN X轴
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '58',
				type : 'line',
				smooth : true,
				itemStyle : {
					normal : {
						areaStyle : {
							type : 'default'
						}
					}
				},
				data : quanguo58
			// 58全国数据
			}, {
				name : '优信',
				type : 'line',
				smooth : true,
				itemStyle : {
					normal : {
						areaStyle : {
							type : 'default'
						}
					}
				},
				data : quanguoXin
			// 优信全国数据
			} ]
		};

		// 为echarts对象加载数据
		myChart.setOption(option);
	});
}