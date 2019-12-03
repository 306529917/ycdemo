/*
Navicat MySQL Data Transfer

Source Server         : fuqian
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : market

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-12-23 15:36:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(10) NOT NULL AUTO_INCREMENT,
  `pname` varchar(20) NOT NULL,
  `pprice` varchar(10) NOT NULL,
  `cost` varchar(5) NOT NULL,
  `inprice` varchar(10) NOT NULL,
  `ptype` varchar(10) NOT NULL,
  `pdesc` varchar(100) NOT NULL,
  `pimg` varchar(10000) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '雀巢咖啡', '10.00', '1', '11.00', '速溶咖啡', '最好的咖啡', 'image/15455448640541.jpg');
INSERT INTO `product` VALUES ('2', '费列罗', '50.00', '1', '51.00', '巧克力&糖果', '浪漫巧克力', 'image/15455449169832.jpg');
INSERT INTO `product` VALUES ('3', '壹品叉子', '10.00', '1', '11.00', '厨具', '好东东，一般人我不告诉他', 'image/15455450014434.jpg');
INSERT INTO `product` VALUES ('4', '卫生纸', '5.00', '3', '8.00', '除尘用具', '好东东，一般人我不告诉他', 'image/15455450423695.jpg');
INSERT INTO `product` VALUES ('5', '枸杞', '10.00', '1', '11.00', '杂粮', '好东东，一般人我不告诉他', 'image/15455450829696.jpg');
INSERT INTO `product` VALUES ('6', '开心果', '10.00', '1', '11.00', '坚果', '好东东，一般人我不告诉他', 'image/15455451138907.jpg');
INSERT INTO `product` VALUES ('7', '拖把', '10.00', '1', '11.00', '除尘用具', '好东东，一般人我不告诉他', 'image/15455451467948.jpg');
INSERT INTO `product` VALUES ('8', '大米', '10.00', '1', '11.00', '大米', '好东东，一般人我不告诉他', 'image/15455451731369.jpg');
INSERT INTO `product` VALUES ('9', '立顿', '10.00', '1', '11.00', '茶包', '好东东，一般人我不告诉他', 'image/154554520756411.jpg');
INSERT INTO `product` VALUES ('10', '熊孩子', '10.00', '1', '11.00', '尿布&湿巾', '好东东，一般人我不告诉他', 'image/154554524415712.jpg');
INSERT INTO `product` VALUES ('11', '脆香米', '10.00', '1', '11.00', '巧克力&糖果', '好东东，一般人我不告诉他', 'image/1545545289895l.jpg');
INSERT INTO `product` VALUES ('13', '可乐', '10.00', '1', '5.00', '奶制饮品', '好东东，一般人我不告诉他', 'image/1545548757299secondarytile.png');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `tel` varchar(12) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `account` varchar(50) DEFAULT NULL,
  `isadmin` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '悟空', '15512341234', '1551234@qq.com', 'a', 'wk', '1');
INSERT INTO `user` VALUES ('2', '悟净', '15512344321', '15512344321@qq.com', 'a', 'wj', '0');
INSERT INTO `user` VALUES ('3', '悟能', '173666666', '954502872@qq.com', 'a', 'wn', '0');
