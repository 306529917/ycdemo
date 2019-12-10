/*
Navicat MySQL Data Transfer

Source Server         : yc
Source Server Version : 50555
Source Host           : localhost:3306
Source Database       : ggblog

Target Server Type    : MYSQL
Target Server Version : 50555
File Encoding         : 65001

Date: 2019-04-16 21:58:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `category` varchar(50) DEFAULT NULL COMMENT '分类',
  `agree` int(255) DEFAULT NULL COMMENT '点赞数量',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发表时间',
  `status` int(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
