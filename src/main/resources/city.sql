-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.24 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 car.city 结构
DROP TABLE IF EXISTS `city`;
CREATE TABLE IF NOT EXISTS `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `province` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_58` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `list_58` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_xin` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `list_xin` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 正在导出表  car.city 的数据：~26 rows (大约)
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
REPLACE INTO `city` (`id`, `province`, `name`, `id_58`, `list_58`, `id_xin`, `list_xin`) VALUES
	(1, '全国', '全国', '8728', 'quanguo', '0', 'quanguo'),
	(2, '北京', '北京', '1', 'bj', '201', 'beijing'),
	(3, '四川', '成都', '102', 'cd', '2501', 'chengdu'),
	(4, '辽宁', '大连', '147', 'dl', '1708', 'dalian'),
	(5, '广东', '佛山', '222', 'fs', '518', 'foshan'),
	(6, '广东', '广州', '3', 'gz', '501', 'guangzhou'),
	(7, '黑龙江', '哈尔滨', '202', 'hrb', '1101', 'haerbin'),
	(8, '浙江', '杭州', '79', 'hz', '3001', 'hangzhou'),
	(9, '安徽', '合肥', '837', 'hf', '101', 'hefei'),
	(10, '山东', '济南', '265', 'jn', '2101', 'jinan'),
	(11, '广西', '南宁', '845', 'nn', '601', 'nanning'),
	(12, '浙江', '宁波', '135', 'nb', '3002', 'ningbo'),
	(13, '山东', '青岛', '122', 'qd', '2102', 'qingdao'),
	(14, '上海', '上海', '2', 'sh', '2401', 'shanghai'),
	(15, '广东', '深圳', '4', 'sz', '502', 'shenzhen'),
	(16, '辽宁', '沈阳', '188', 'sy', '1701', 'shenyang'),
	(17, '河北', '石家庄', '241', 'sjz', '901', 'shijiazhuang'),
	(18, '江苏', '苏州', '5', 'su', '1502', 'suzhou'),
	(19, '山西', '太原', '740', 'ty', '2201', 'taiyuan'),
	(20, '天津', '天津', '18', 'tj', '2601', 'tianjin'),
	(21, '湖北', '武汉', '158', 'wh', '1201', 'wuhan'),
	(22, '陕西', '西安', '483', 'xa', '2301', 'xian'),
	(23, '吉林', '长春', '319', 'cc', '1401', 'changchun'),
	(24, '湖南', '长沙', '414', 'cs', '1301', 'changsha'),
	(25, '河南', '郑州', '342', 'zz', '1001', 'zhengzhou'),
	(26, '重庆', '重庆', '37', 'cq', '3101', 'chongqing');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
