/*
 Navicat Premium Data Transfer

 Source Server         : chenum.com
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : chenum.com
 Source Database       : car

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : utf-8

 Date: 08/07/2015 19:52:27 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `car`
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `app_id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `ctime` datetime NOT NULL,
  `pay_type` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `src_all` int(11) DEFAULT NULL,
  `src_by_seller` int(11) DEFAULT NULL,
  `src_personal` int(11) DEFAULT NULL,
  `src_original` int(11) DEFAULT NULL,
  `src_no_accident` int(11) DEFAULT NULL,
  `src_vin` int(11) DEFAULT NULL,
  `age_1` int(11) DEFAULT NULL,
  `age_1_3` int(11) DEFAULT NULL,
  `age_3_5` int(11) DEFAULT NULL,
  `age_5_8` int(11) DEFAULT NULL,
  `age_8` int(11) DEFAULT NULL,
  `milage_1` int(11) DEFAULT NULL,
  `milage_1_3` int(11) DEFAULT NULL,
  `milage_3_6` int(11) DEFAULT NULL,
  `milage_6_10` int(11) DEFAULT NULL,
  `milage_10_20` int(11) DEFAULT NULL,
  `milage_20` int(11) DEFAULT NULL,
  `price_5` int(11) DEFAULT NULL,
  `price_5_10` int(11) DEFAULT NULL,
  `price_10_15` int(11) DEFAULT NULL,
  `price_15_20` int(11) DEFAULT NULL,
  `price_20_30` int(11) DEFAULT NULL,
  `price_30_50` int(11) DEFAULT NULL,
  `price_50` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;
