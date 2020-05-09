/*
Navicat MySQL Data Transfer

Source Server         : localhost-root:a
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : cars

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2020-01-03 20:04:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for options
-- ----------------------------
DROP TABLE IF EXISTS `options`;
CREATE TABLE `options` (
  `opid` int(11) NOT NULL auto_increment,
  `vid` varchar(200) default NULL,
  `opname` varchar(200) default NULL COMMENT '选项名称',
  `views` int(11) default NULL COMMENT '票数',
  `usid` int(11) default NULL COMMENT '投票用户的id',
  PRIMARY KEY  (`opid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of options
-- ----------------------------

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `usid` int(11) NOT NULL auto_increment,
  `uname` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  PRIMARY KEY  (`usid`),
  UNIQUE KEY `uname` (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------

-- ----------------------------
-- Table structure for vote
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `id` int(200) NOT NULL auto_increment,
  `vname` varchar(200) NOT NULL COMMENT '投票主题',
  `vtype` varchar(100) NOT NULL COMMENT '投票类型',
  `startDate` date default NULL COMMENT '投票开始时间',
  `endDate` date default NULL COMMENT '投票结束时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `vname` (`vname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote
-- ----------------------------
