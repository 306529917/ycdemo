/*
Navicat MySQL Data Transfer

Source Server         : localhost-root:a
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : c0-s2-ply-demo

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2019-11-23 17:07:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sn` varchar(50) default NULL,
  `name` varchar(50) default NULL,
  `age` int(11) default NULL,
  `grade` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '宋江', '10', '3');
INSERT INTO `student` VALUES ('2', '林冲', '28', '3');
INSERT INTO `student` VALUES ('3', '鲁达', '26', '3');
INSERT INTO `student` VALUES ('4', '花荣', '22', '3');
