create database favorite;

use favorite;

/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : favarite

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2019-03-08 16:42:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `fid` int(11) NOT NULL auto_increment,
  `flabel` varchar(1000) default NULL,
  `furl` varchar(1000) default NULL,
  `fdesc` varchar(2000) default NULL,
  PRIMARY KEY  (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favorite
-- ----------------------------

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `tid` int(11) NOT NULL auto_increment,
  `tname` varchar(100) default NULL,
  `tcount` int(11) default NULL,
  PRIMARY KEY  (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- Table structure for tf
-- ----------------------------
DROP TABLE IF EXISTS `tf`;
CREATE TABLE `tf` (
  `tid` int(11) NOT NULL default '0',
  `fid` int(11) NOT NULL default '0',
  PRIMARY KEY  (`tid`,`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tf
-- ----------------------------
