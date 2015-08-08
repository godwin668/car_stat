package test.po;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Test {
	public static void main(String[] args) {
		String[] cityArr = new String[] { "全国", "北京", "上海", "广州", "深圳", "苏州",
				"天津", "重庆", "杭州", "无锡", "成都", "青岛", "宁波", "大连", "武汉", "南京",
				"沈阳", "哈尔滨", "佛山", "烟台", "石家庄", "济南", "唐山", "泉州", "福州", "长春",
				"温州", "郑州", "绍兴", "潍坊", "大庆", "淄博", "南通", "台州", "东莞", "长沙",
				"保定", "济宁", "常州", "徐州", "西安", "嘉兴", "临沂", "威海", "鞍山", "金华",
				"昆明", "洛阳", "邯郸", "南阳", "厦门", "盐城", "东营", "江门", "扬州", "镇江",
				"沧州", "南昌", "茂名", "泰安", "泰州", "吉林", "漳州", "惠州", "德州", "太原",
				"邢台", "中山", "廊坊", "三河", "汕头", "湛江", "包头", "呼和浩特", "岳阳", "湖州",
				"合肥", "南宁", "宜昌", "常德", "聊城", "襄阳", "肇庆", "珠海", "衡阳", "揭阳",
				"滨州", "兰州", "枣庄", "淮安", "乌鲁木齐", "衡水", "平顶山", "新乡", "商丘", "桂林",
				"绵阳", "驻马店", "秦皇岛", "株洲", "安阳", "黄石", "贵阳", "十堰", "鄂尔多斯", "辽阳",
				"马鞍山", "玉溪", "盘锦", "克拉玛依", "宝鸡", "芜湖", "湘潭", "三明", "连云港", "西宁",
				"海口", "银川", "九江", "萍乡", "阳江", "荆门", "黄冈", "邵阳", "松原", "淮南",
				"阜阳", "六安", "亳州", "钦州", "玉林", "濮阳", "宿迁", "锦州", "景德镇", "赣州",
				"吉安", "攀枝花", "泸州", "德阳", "南充", "宜宾", "广安", "曲靖", "红河", "乌海",
				"固原", "三亚", "莆田", "辽源", "安康", "汉中", "日照", "延吉", "鹰潭", "乐山",
				"安庆", "焦作", "张家口", "晋城", "宿州", "丹东", "蚌埠", "荆州", "牡丹江", "菏泽",
				"宣城", "运城", "临汾", "宜春", "抚顺", "渭南", "本溪", "齐齐哈尔", "营口", "白城",
				"内江", "榆林", "赤峰", "绥化", "铁岭", "自贡", "龙岩", "承德", "贵港", "佳木斯",
				"衢州", "资阳", "长治", "大同", "柳州", "平凉", "鸡西", "清远", "锡林浩特", "金昌",
				"咸阳", "安顺", "遵义", "丽水", "宁德", "舟山", "昌吉", "天水", "信阳", "阳泉",
				"晋中", "延安", "鹤岗", "三门峡", "淮北", "凯里", "梅州", "娄底", "伊宁", "库尔勒",
				"石河子", "随州", "潜江", "鄂州", "西昌", "广元", "双鸭山", "朔州", "济源", "中卫",
				"吴忠", "石嘴山", "兴安盟", "乌兰察布", "通辽", "葫芦岛", "阜新", "朝阳", "新余",
				"上饶", "抚州", "通化", "四平", "白山", "益阳", "滁州", "铜陵", "南平", "白银",
				"定西", "酒泉", "铜仁", "兴义", "武威", "张掖", "潮州", "庆阳", "云浮", "都匀",
				"六盘水", "北海", "防城港", "毕节" };
		try {
			String cityCoorStr = FileUtils.readFileToString(new File("/Users/Godwin/city_coor.txt"));
			List<String> cityCoorList = FileUtils.readLines(new File("/Users/Godwin/city_coor.txt"));
			for (String city : cityArr) {
				int matchCount = 0;
				for (String cityCoor : cityCoorList) {
					if (cityCoor.contains("北纬") && cityCoor.contains("东经") && cityCoor.startsWith(city)) {
						matchCount++;
						// System.out.println("[" + city + "] - " + cityCoor);
						String latitude = cityCoor.replaceFirst(city + ".*?北纬(\\S+).*?东经(\\S+)", "$1");
						String longitude = cityCoor.replaceFirst(city + ".*?北纬(\\S+).*?东经(\\S+)", "$2");
						System.out.println(city + "\t" + latitude + "\t" + longitude);
					}
				}
				if (matchCount > 1) {
					System.err.println("Match more than one city: " + city);
					System.exit(0);
				} else if (matchCount < 1) {
					System.err.println("[" + city + "] NOT match.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}