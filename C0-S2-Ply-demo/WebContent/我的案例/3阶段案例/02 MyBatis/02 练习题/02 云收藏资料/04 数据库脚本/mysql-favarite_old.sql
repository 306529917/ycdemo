create database favorite;

use favorite;

/*
Navicat MySQL Data Transfer

Source Server         : yc
Source Server Version : 50555
Source Host           : localhost:3306
Source Database       : favorite

Target Server Type    : MYSQL
Target Server Version : 50555
File Encoding         : 65001

Date: 2019-03-16 16:08:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_label` varchar(1000) DEFAULT NULL,
  `f_url` varchar(1000) DEFAULT NULL,
  `f_tags` varchar(255) DEFAULT NULL,
  `f_desc` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favorite
-- ----------------------------
INSERT INTO `favorite` VALUES ('1', '百度', 'www.baidu.com', '搜索，新闻', '好网站，我的最爱');
INSERT INTO `favorite` VALUES ('2', '网易', 'www.163.com', '门户，新闻，娱乐，体育', '好网站');
INSERT INTO `favorite` VALUES ('3', '京东', 'www.jingdong.com', '剁手，购物，门户', '');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(100) DEFAULT NULL,
  `t_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('1', '搜索', '1');
INSERT INTO `tag` VALUES ('2', '新闻', '2');
INSERT INTO `tag` VALUES ('3', '门户', '2');
INSERT INTO `tag` VALUES ('4', '娱乐', '1');
INSERT INTO `tag` VALUES ('5', '体育', '1');
INSERT INTO `tag` VALUES ('6', '剁手', '1');
INSERT INTO `tag` VALUES ('7', '购物', '1');
