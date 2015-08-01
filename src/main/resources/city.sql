/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50615
 Source Host           : localhost
 Source Database       : car_sum

 Target Server Type    : MySQL
 Target Server Version : 50615
 File Encoding         : utf-8

 Date: 08/01/2015 21:58:31 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `listname` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `province` varchar(255) COLLATE utf8_bin NOT NULL,
  `xin_id` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `city`
-- ----------------------------
BEGIN;
INSERT INTO `city` VALUES ('1', 'quanguo', '全国', '全国', '0'), ('2', 'beijing', '北京', '北京', '201'), ('3', 'chengdu', '成都', '四川', '2501'), ('4', 'dalian', '大连', '辽宁', '1708'), ('5', 'foshan', '佛山', '广东', '518'), ('6', 'guangzhou', '广州', '广东', '501'), ('7', 'haerbin', '哈尔滨', '黑龙江', '1101'), ('8', 'hangzhou', '杭州', '浙江', '3001'), ('9', 'hefei', '合肥', '安徽', '101'), ('10', 'jinan', '济南', '山东', '2101'), ('11', 'nanning', '南宁', '广西', '601'), ('12', 'ningbo', '宁波', '浙江', '3002'), ('13', 'qingdao', '青岛', '山东', '2102'), ('14', 'shanghai', '上海', '上海', '2401'), ('15', 'shenzhen', '深圳', '广东', '502'), ('16', 'shenyang', '沈阳', '辽宁', '1701'), ('17', 'shijiazhuang', '石家庄', '河北', '901'), ('18', 'suzhou', '苏州', '江苏', '1502'), ('19', 'taiyuan', '太原', '山西', '2201'), ('20', 'tianjin', '天津', '天津', '2601'), ('21', 'wuhan', '武汉', '湖北', '1201'), ('22', 'xian', '西安', '陕西', '2301'), ('23', 'changchun', '长春', '吉林', '1401'), ('24', 'changsha', '长沙', '湖南', '1301'), ('25', 'zhengzhou', '郑州', '河南', '1001'), ('26', 'chongqing', '重庆', '重庆', '3101');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;