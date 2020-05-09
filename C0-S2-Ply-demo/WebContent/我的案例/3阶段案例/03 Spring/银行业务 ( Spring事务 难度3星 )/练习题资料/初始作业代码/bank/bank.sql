/*
Navicat MySQL Data Transfer

Source Server         : MySQL-demo
Source Server Version : 50724
Source Host           : 39.108.186.38:3306
Source Database       : demo-bank

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-10-15 10:36:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `accountid` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(32) DEFAULT NULL,
  `balance` decimal(10,4) DEFAULT NULL,
  PRIMARY KEY (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------

-- ----------------------------
-- Table structure for oprecord
-- ----------------------------
DROP TABLE IF EXISTS `oprecord`;
CREATE TABLE `oprecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountid` int(11) DEFAULT NULL,
  `opmoney` decimal(10,4) DEFAULT NULL,
  `charge` decimal(10,4) DEFAULT NULL,
  `optime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_oprecord_accountid` (`accountid`),
  CONSTRAINT `oprecord_ibfk_1` FOREIGN KEY (`accountid`) REFERENCES `account` (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oprecord
-- ----------------------------
