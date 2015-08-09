/**
 * 主入口
 */
$(document).ready(function() {
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
});
