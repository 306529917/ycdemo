/*
Navicat MySQL Data Transfer

Source Server         : localhost-root:a
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : c0-s2-ply-demo

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2019-11-23 17:12:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `bookid` int(11) NOT NULL auto_increment,
  `bookname` varchar(40) default NULL,
  `bookpress` varchar(40) default NULL,
  `pressdate` date default NULL,
  `bookauthor` varchar(40) default NULL,
  `bookcount` int(11) default NULL,
  `bookimage` varchar(40) default NULL,
  PRIMARY KEY  (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', '计算机组成原理', '川大出版社', '2009-09-24', '张永强', '3', '../资料/images/计算机组成原理.jpg');
INSERT INTO `books` VALUES ('2', '数据库', '清华出版社', '1998-10-30', '周杰伦', '2', '../资料/images/数据库.jpg');
INSERT INTO `books` VALUES ('3', '徐志摩诗集', '永强出版社', '1995-03-04', '徐志摩', '1', '../资料/images/徐志摩诗集.jpg');
INSERT INTO `books` VALUES ('4', '高等数学', '晶晶出版社', '2011-07-04', '周传雄', '3', '../资料/images/高等数学.jpg');
INSERT INTO `books` VALUES ('5', '中国历史', '人民出版社', '2016-06-22', '温家宝', '2', '../资料/images/中国历史.jpg');
INSERT INTO `books` VALUES ('6', '盗梦空间', '神话出版社', '2014-08-28', 'mary', '1', '../资料/images/盗梦空间.jpg');
INSERT INTO `books` VALUES ('7', '西游记', '人民出版社', '2001-12-01', '吴承恩', '17', '../资料/images/西游记.jpg');
INSERT INTO `books` VALUES ('8', '水浒传', '贵州出版社', '1977-04-04', '施耐庵', '5', '../资料/images/水浒传.jpg');
INSERT INTO `books` VALUES ('9', '红楼梦', '上海出版社', '1966-04-11', '曹雪芹', '8', '../资料/images/红楼梦.jpg');
INSERT INTO `books` VALUES ('10', '三国演义', '宇宙无敌出版社', '2001-09-09', '罗贯中', '13', '../资料/images/三国演义.jpg');
INSERT INTO `books` VALUES ('14', 'qwe', 'qwe', '2019-11-15', 'qwe', '1', 'upload/08.jpg');

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
