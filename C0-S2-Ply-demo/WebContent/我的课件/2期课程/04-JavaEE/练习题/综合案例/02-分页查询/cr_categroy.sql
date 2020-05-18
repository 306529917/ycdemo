/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : c0-s2-ply-demo

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2020-05-18 08:36:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cr_categroy
-- ----------------------------
DROP TABLE IF EXISTS `cr_categroy`;
CREATE TABLE `cr_categroy` (
  `id` int(11) NOT NULL,
  `name` varchar(100) default NULL,
  `pid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cr_categroy
-- ----------------------------
INSERT INTO `cr_categroy` VALUES ('21', '古籍整理', null);
INSERT INTO `cr_categroy` VALUES ('22', '学术著作', null);
INSERT INTO `cr_categroy` VALUES ('23', '大众读物', null);
INSERT INTO `cr_categroy` VALUES ('24', '工具书', null);
INSERT INTO `cr_categroy` VALUES ('25', '综合类', null);
INSERT INTO `cr_categroy` VALUES ('26', '教材·学生读物', null);
INSERT INTO `cr_categroy` VALUES ('27', '历史', '21');
INSERT INTO `cr_categroy` VALUES ('28', '文学', '27');
INSERT INTO `cr_categroy` VALUES ('29', '哲学', '28');
INSERT INTO `cr_categroy` VALUES ('30', '语言文字', '29');
INSERT INTO `cr_categroy` VALUES ('31', '类书', '1819');
INSERT INTO `cr_categroy` VALUES ('32', '大型文献', '31');
INSERT INTO `cr_categroy` VALUES ('33', '历史', '22');
INSERT INTO `cr_categroy` VALUES ('34', '文学', '33');
INSERT INTO `cr_categroy` VALUES ('35', '哲学', '34');
INSERT INTO `cr_categroy` VALUES ('36', '综合', '37');
INSERT INTO `cr_categroy` VALUES ('37', '语言文字', '35');
INSERT INTO `cr_categroy` VALUES ('38', '历史', '23');
INSERT INTO `cr_categroy` VALUES ('39', '文学', '38');
INSERT INTO `cr_categroy` VALUES ('40', '哲学', '39');
INSERT INTO `cr_categroy` VALUES ('41', '综合', '40');
INSERT INTO `cr_categroy` VALUES ('42', '传记', '41');
INSERT INTO `cr_categroy` VALUES ('1581', '生活', '42');
INSERT INTO `cr_categroy` VALUES ('1582', '汉语工具书', '24');
INSERT INTO `cr_categroy` VALUES ('1583', '学生工具书', '1582');
INSERT INTO `cr_categroy` VALUES ('1584', '综合类', '1583');
INSERT INTO `cr_categroy` VALUES ('1585', '书目题跋丛刊', '25');
INSERT INTO `cr_categroy` VALUES ('1586', '版本·目录·校勘', '1585');
INSERT INTO `cr_categroy` VALUES ('1587', '钱币系列', '1586');
INSERT INTO `cr_categroy` VALUES ('1588', '期刊·连续出版物', '1856');
INSERT INTO `cr_categroy` VALUES ('1589', '大中专教材', '26');
INSERT INTO `cr_categroy` VALUES ('1590', '诵读中国', '1589');
INSERT INTO `cr_categroy` VALUES ('1591', '二十四史/清史稿系列', '27');
INSERT INTO `cr_categroy` VALUES ('1592', '前四史', '27');
INSERT INTO `cr_categroy` VALUES ('1593', '线装大字珍藏本系列', '27');
INSERT INTO `cr_categroy` VALUES ('1594', '资治通鉴/通典/通志/文献通考', '27');
INSERT INTO `cr_categroy` VALUES ('1595', '断代史', '27');
INSERT INTO `cr_categroy` VALUES ('1596', '中外关系史名著译丛', '27');
INSERT INTO `cr_categroy` VALUES ('1597', '中外交通史籍丛刊', '27');
INSERT INTO `cr_categroy` VALUES ('1598', '中国古代都城资料选刊', '27');
INSERT INTO `cr_categroy` VALUES ('1599', '中国古代地理总志丛刊', '27');
INSERT INTO `cr_categroy` VALUES ('1600', '地理/方志', '27');
INSERT INTO `cr_categroy` VALUES ('1601', '二十四史研究资料丛刊', '27');
INSERT INTO `cr_categroy` VALUES ('1602', '二十四史校订研究丛刊', '27');
INSERT INTO `cr_categroy` VALUES ('1603', '国家清史编纂委员会/文献丛刊', '27');
INSERT INTO `cr_categroy` VALUES ('1604', '中国近代人物文集', '27');
INSERT INTO `cr_categroy` VALUES ('1605', '中国近代史资料丛刊', '27');
INSERT INTO `cr_categroy` VALUES ('1606', '历代史料笔记丛刊', '27');
INSERT INTO `cr_categroy` VALUES ('1607', '中国历史文集丛刊', '27');
INSERT INTO `cr_categroy` VALUES ('1608', '学术笔记丛刊', '27');
INSERT INTO `cr_categroy` VALUES ('1609', '中国史学基本典籍丛刊', '27');
INSERT INTO `cr_categroy` VALUES ('1610', '中华民国史资料丛稿', '27');
INSERT INTO `cr_categroy` VALUES ('1611', '年谱丛刊', '27');
INSERT INTO `cr_categroy` VALUES ('1612', '清代人物传稿', '27');
INSERT INTO `cr_categroy` VALUES ('1613', '中国近代期刊会刊第二辑', '27');
INSERT INTO `cr_categroy` VALUES ('1614', '历史研究资料', '27');
INSERT INTO `cr_categroy` VALUES ('1615', '诗文总集', '28');
INSERT INTO `cr_categroy` VALUES ('1616', '历代文举要', '28');
INSERT INTO `cr_categroy` VALUES ('1617', '诗文别集', '28');
INSERT INTO `cr_categroy` VALUES ('1618', '中国古典文学基本丛书', '28');
INSERT INTO `cr_categroy` VALUES ('1619', '古典文学研究资料汇编', '28');
INSERT INTO `cr_categroy` VALUES ('1620', '中国文学研究典籍丛刊', '28');
INSERT INTO `cr_categroy` VALUES ('1621', '文学研究资料', '28');
INSERT INTO `cr_categroy` VALUES ('1622', '十三经系列', '29');
INSERT INTO `cr_categroy` VALUES ('1623', '新编诸子集成', '29');
INSERT INTO `cr_categroy` VALUES ('1624', '新编诸子集成续编', '29');
INSERT INTO `cr_categroy` VALUES ('1625', '理学丛书', '29');
INSERT INTO `cr_categroy` VALUES ('1626', '四部要籍注疏丛刊', '29');
INSERT INTO `cr_categroy` VALUES ('1627', '易学典籍选刊', '29');
INSERT INTO `cr_categroy` VALUES ('1628', '王夫之著作', '29');
INSERT INTO `cr_categroy` VALUES ('1629', '中国思想史资料丛刊', '29');
INSERT INTO `cr_categroy` VALUES ('1630', '中国佛教典籍选刊', '29');
INSERT INTO `cr_categroy` VALUES ('1631', '佛教经典译注丛书', '29');
INSERT INTO `cr_categroy` VALUES ('1632', '道教典籍选刊', '29');
INSERT INTO `cr_categroy` VALUES ('1633', '哲学研究资料', '29');
INSERT INTO `cr_categroy` VALUES ('1634', '甲骨文/金文', '30');
INSERT INTO `cr_categroy` VALUES ('1635', '简牍/古陶文', '30');
INSERT INTO `cr_categroy` VALUES ('1636', '说文解字系列', '30');
INSERT INTO `cr_categroy` VALUES ('1637', '训诂', '30');
INSERT INTO `cr_categroy` VALUES ('1638', '古代字书辑刊', '30');
INSERT INTO `cr_categroy` VALUES ('1639', '音韵', '30');
INSERT INTO `cr_categroy` VALUES ('1640', '韵学丛书', '30');
INSERT INTO `cr_categroy` VALUES ('1641', '语言文字研究资料', '30');
INSERT INTO `cr_categroy` VALUES ('1642', '甲骨文合集', '32');
INSERT INTO `cr_categroy` VALUES ('1643', '二十世纪出土玺印集成', '32');
INSERT INTO `cr_categroy` VALUES ('1644', '光绪朝硃批奏折', '32');
INSERT INTO `cr_categroy` VALUES ('1645', '清代起居注册/康熙朝', '32');
INSERT INTO `cr_categroy` VALUES ('1646', '中华大藏经', '32');
INSERT INTO `cr_categroy` VALUES ('1647', '印顺法师佛学著作全集', '32');
INSERT INTO `cr_categroy` VALUES ('1648', '清代蒙藏回部典汇', '32');
INSERT INTO `cr_categroy` VALUES ('1649', '清实录', '32');
INSERT INTO `cr_categroy` VALUES ('1650', '敦煌经部文献合集', '32');
INSERT INTO `cr_categroy` VALUES ('1651', '汉藏交融', '32');
INSERT INTO `cr_categroy` VALUES ('1652', '云南丛书', '32');
INSERT INTO `cr_categroy` VALUES ('1653', '绍兴丛书', '32');
INSERT INTO `cr_categroy` VALUES ('1654', '殷周金文系列', '32');
INSERT INTO `cr_categroy` VALUES ('1655', '古逸丛书三编', '32');
INSERT INTO `cr_categroy` VALUES ('1656', '中研院历史语言研究所集刊论文类编', '32');
INSERT INTO `cr_categroy` VALUES ('1657', '中国木版年画集成', '32');
INSERT INTO `cr_categroy` VALUES ('1658', '二十世纪琴学资料珍萃', '32');
INSERT INTO `cr_categroy` VALUES ('1659', '研究著作', '33');
INSERT INTO `cr_categroy` VALUES ('1660', '国家清史编纂委员会研究丛刊', '33');
INSERT INTO `cr_categroy` VALUES ('1661', '中华史学文库', '33');
INSERT INTO `cr_categroy` VALUES ('1662', '名家史论集系列', '33');
INSERT INTO `cr_categroy` VALUES ('1663', '现代史学家文丛', '33');
INSERT INTO `cr_categroy` VALUES ('1664', '王仲荦著作集', '33');
INSERT INTO `cr_categroy` VALUES ('1665', '岑仲勉著作集', '33');
INSERT INTO `cr_categroy` VALUES ('1666', '孟森著作集', '33');
INSERT INTO `cr_categroy` VALUES ('1667', '傅衣凌著作集', '33');
INSERT INTO `cr_categroy` VALUES ('1668', '摹庐丛著', '33');
INSERT INTO `cr_categroy` VALUES ('1669', '法国西域敦煌学名著译丛', '33');
INSERT INTO `cr_categroy` VALUES ('1670', '中国乡村社会研究丛书', '33');
INSERT INTO `cr_categroy` VALUES ('1671', '中外交流历史文丛', '33');
INSERT INTO `cr_categroy` VALUES ('1672', '北大民族史文丛', '33');
INSERT INTO `cr_categroy` VALUES ('1673', '吐鲁番学研究丛书', '33');
INSERT INTO `cr_categroy` VALUES ('1674', '日本学者研究中国史论著选译', '33');
INSERT INTO `cr_categroy` VALUES ('1675', '日本学者中国史研究丛刊', '33');
INSERT INTO `cr_categroy` VALUES ('1676', '中国近代史事论丛', '33');
INSERT INTO `cr_categroy` VALUES ('1677', '新史学', '33');
INSERT INTO `cr_categroy` VALUES ('1678', '人物传记', '33');
INSERT INTO `cr_categroy` VALUES ('1679', '研究著作', '34');
INSERT INTO `cr_categroy` VALUES ('1680', '古本小书丛刊', '34');
INSERT INTO `cr_categroy` VALUES ('1681', '聂石樵中国文学史系列', '34');
INSERT INTO `cr_categroy` VALUES ('1682', '唐才子传校笺', '34');
INSERT INTO `cr_categroy` VALUES ('1683', '中国古典文学史料研究丛书', '34');
INSERT INTO `cr_categroy` VALUES ('1684', '中国文学思想通史', '34');
INSERT INTO `cr_categroy` VALUES ('1685', '比较文学与文化新视野丛书', '34');
INSERT INTO `cr_categroy` VALUES ('1686', '红楼人物百家言', '34');
INSERT INTO `cr_categroy` VALUES ('1687', '华东师范大学中文系学术丛书', '34');
INSERT INTO `cr_categroy` VALUES ('1688', '域外汉籍研究丛书', '34');
INSERT INTO `cr_categroy` VALUES ('1689', '刘永济集', '34');
INSERT INTO `cr_categroy` VALUES ('1690', '黄节作品集', '34');
INSERT INTO `cr_categroy` VALUES ('1691', '孙楷第文集', '34');
INSERT INTO `cr_categroy` VALUES ('1692', '钱南扬文集', '34');
INSERT INTO `cr_categroy` VALUES ('1693', '文艺学语境中的文化认同问题研究丛书', '34');
INSERT INTO `cr_categroy` VALUES ('1694', '研究著作', '35');
INSERT INTO `cr_categroy` VALUES ('1695', '珞珈中国哲学', '35');
INSERT INTO `cr_categroy` VALUES ('1696', '人间佛教研究丛书', '35');
INSERT INTO `cr_categroy` VALUES ('1697', '真如 因名学丛书', '35');
INSERT INTO `cr_categroy` VALUES ('1698', '宗教与中国社会研究论丛', '35');
INSERT INTO `cr_categroy` VALUES ('1699', '研究著作', '37');
INSERT INTO `cr_categroy` VALUES ('1700', '于省吾著作集', '37');
INSERT INTO `cr_categroy` VALUES ('1701', '研究著作', '36');
INSERT INTO `cr_categroy` VALUES ('1702', '中国古典名著译注丛书', '36');
INSERT INTO `cr_categroy` VALUES ('1703', '中华学术精品', '36');
INSERT INTO `cr_categroy` VALUES ('1704', '陈梦家著作集', '36');
INSERT INTO `cr_categroy` VALUES ('1705', '启功作品系列', '36');
INSERT INTO `cr_categroy` VALUES ('1706', '黄侃文集', '36');
INSERT INTO `cr_categroy` VALUES ('1707', '冀野文钞', '36');
INSERT INTO `cr_categroy` VALUES ('1708', '王叔岷著作集', '36');
INSERT INTO `cr_categroy` VALUES ('1709', '余嘉锡著作集', '36');
INSERT INTO `cr_categroy` VALUES ('1710', '孙贻让全集', '36');
INSERT INTO `cr_categroy` VALUES ('1711', '梁方仲文集', '36');
INSERT INTO `cr_categroy` VALUES ('1712', '日本中国学文萃', '36');
INSERT INTO `cr_categroy` VALUES ('1713', '世界汉学论丛', '36');
INSERT INTO `cr_categroy` VALUES ('1714', '世界汉学译著系列', '36');
INSERT INTO `cr_categroy` VALUES ('1715', '南京大学戏剧影视研究丛书', '36');
INSERT INTO `cr_categroy` VALUES ('1716', '中华文史新刊', '36');
INSERT INTO `cr_categroy` VALUES ('1717', '中华学术文库', '36');
INSERT INTO `cr_categroy` VALUES ('1718', '西方的中国形象', '36');
INSERT INTO `cr_categroy` VALUES ('1719', '剑桥学术前沿', '36');
INSERT INTO `cr_categroy` VALUES ('1720', '大中华文库', '36');
INSERT INTO `cr_categroy` VALUES ('1721', '文献传承与文化认同研究丛书', '36');
INSERT INTO `cr_categroy` VALUES ('1722', '中国文化研究所学报', '36');
INSERT INTO `cr_categroy` VALUES ('1723', '浙江大学中国古典文献学研究系列', '36');
INSERT INTO `cr_categroy` VALUES ('1724', '复旦文史专刊', '36');
INSERT INTO `cr_categroy` VALUES ('1725', '全国宣传文化系统“四个一批”人才作品文库', '36');
INSERT INTO `cr_categroy` VALUES ('1726', '正说历史系列', '38');
INSERT INTO `cr_categroy` VALUES ('1727', '大史记书系', '38');
INSERT INTO `cr_categroy` VALUES ('1728', '中国史学名著选', '38');
INSERT INTO `cr_categroy` VALUES ('1729', '古代社会生活系列', '38');
INSERT INTO `cr_categroy` VALUES ('1730', '大家说史系列', '38');
INSERT INTO `cr_categroy` VALUES ('1731', '陶菊隐书系', '38');
INSERT INTO `cr_categroy` VALUES ('1732', '文物中国史', '38');
INSERT INTO `cr_categroy` VALUES ('1733', '古典诗词名家', '39');
INSERT INTO `cr_categroy` VALUES ('1734', '古典诗词坊', '39');
INSERT INTO `cr_categroy` VALUES ('1735', '诗词常识名家谈四种', '39');
INSERT INTO `cr_categroy` VALUES ('1736', '诗词常识名家谈(精装)', '39');
INSERT INTO `cr_categroy` VALUES ('1737', '迦陵说诗', '39');
INSERT INTO `cr_categroy` VALUES ('1738', '名家讲经典', '39');
INSERT INTO `cr_categroy` VALUES ('1739', '跟大师学语文', '39');
INSERT INTO `cr_categroy` VALUES ('1740', '四大名著', '39');
INSERT INTO `cr_categroy` VALUES ('1741', '四大名著 名家点评', '39');
INSERT INTO `cr_categroy` VALUES ('1742', '中华大字经典', '39');
INSERT INTO `cr_categroy` VALUES ('1743', '中华十大畅销古典小说', '39');
INSERT INTO `cr_categroy` VALUES ('1744', '新白话系列', '39');
INSERT INTO `cr_categroy` VALUES ('1745', '璀璨星座', '39');
INSERT INTO `cr_categroy` VALUES ('1746', '怡情书吧', '39');
INSERT INTO `cr_categroy` VALUES ('1747', '吴藕汀作品集', '39');
INSERT INTO `cr_categroy` VALUES ('1748', '经典私塾班', '40');
INSERT INTO `cr_categroy` VALUES ('1749', '儒释道典汇', '40');
INSERT INTO `cr_categroy` VALUES ('1750', '禅的智慧', '40');
INSERT INTO `cr_categroy` VALUES ('1751', '禅学三书', '40');
INSERT INTO `cr_categroy` VALUES ('1752', '<<文史中国>>丛书', '41');
INSERT INTO `cr_categroy` VALUES ('1753', '中华经典普及文库', '41');
INSERT INTO `cr_categroy` VALUES ('1754', '中华经典藏书', '41');
INSERT INTO `cr_categroy` VALUES ('1755', '中华经典随笔', '41');
INSERT INTO `cr_categroy` VALUES ('1756', '中华经典史评', '41');
INSERT INTO `cr_categroy` VALUES ('1757', '传世经典 文白对照', '41');
INSERT INTO `cr_categroy` VALUES ('1758', '跟大师学国学', '41');
INSERT INTO `cr_categroy` VALUES ('1759', '国学入门丛书', '41');
INSERT INTO `cr_categroy` VALUES ('1760', '问吧系列', '41');
INSERT INTO `cr_categroy` VALUES ('1761', '汪荣祖人物书系', '41');
INSERT INTO `cr_categroy` VALUES ('1762', '张中行作品', '41');
INSERT INTO `cr_categroy` VALUES ('1763', '名家讲现代中国', '41');
INSERT INTO `cr_categroy` VALUES ('1764', '皓首学术随笔', '41');
INSERT INTO `cr_categroy` VALUES ('1765', '艺文类聚', '41');
INSERT INTO `cr_categroy` VALUES ('1766', '中华智慧经典', '41');
INSERT INTO `cr_categroy` VALUES ('1767', '金陵考古三种', '41');
INSERT INTO `cr_categroy` VALUES ('1768', '近代日本人中国游记', '41');
INSERT INTO `cr_categroy` VALUES ('1769', '文史知识文库', '41');
INSERT INTO `cr_categroy` VALUES ('1770', '郑逸梅作品集', '41');
INSERT INTO `cr_categroy` VALUES ('1771', '报人时代', '41');
INSERT INTO `cr_categroy` VALUES ('1772', '出古入今', '41');
INSERT INTO `cr_categroy` VALUES ('1773', '书人书事系列', '41');
INSERT INTO `cr_categroy` VALUES ('1774', '文人情侣丛书', '42');
INSERT INTO `cr_categroy` VALUES ('1775', '探险家旅游系列丛书', '1581');
INSERT INTO `cr_categroy` VALUES ('1776', '少儿读物', '1581');
INSERT INTO `cr_categroy` VALUES ('1777', '中国钱币大辞典', '1587');
INSERT INTO `cr_categroy` VALUES ('1778', '中国钱币丛书', '1587');
INSERT INTO `cr_categroy` VALUES ('1779', '河南出土钱币丛书', '1587');
INSERT INTO `cr_categroy` VALUES ('1780', '文史', '1588');
INSERT INTO `cr_categroy` VALUES ('1781', '古文字研究', '1588');
INSERT INTO `cr_categroy` VALUES ('1782', '法国汉学', '1588');
INSERT INTO `cr_categroy` VALUES ('1783', '欧亚学刊', '1588');
INSERT INTO `cr_categroy` VALUES ('1784', '中国典籍与文化论丛', '1588');
INSERT INTO `cr_categroy` VALUES ('1785', '中国社会历史评论', '1588');
INSERT INTO `cr_categroy` VALUES ('1786', '敦煌吐鲁番研究', '1588');
INSERT INTO `cr_categroy` VALUES ('1787', '出土文献研究', '1588');
INSERT INTO `cr_categroy` VALUES ('1788', '中国语言学集刊', '1588');
INSERT INTO `cr_categroy` VALUES ('1789', '学林漫录', '1588');
INSERT INTO `cr_categroy` VALUES ('1790', '华林', '1588');
INSERT INTO `cr_categroy` VALUES ('1791', '中国禅学', '1588');
INSERT INTO `cr_categroy` VALUES ('1792', '其他', '1588');
INSERT INTO `cr_categroy` VALUES ('1819', '综合', '30');
INSERT INTO `cr_categroy` VALUES ('1838', '其他', '1587');
INSERT INTO `cr_categroy` VALUES ('1842', '综合', '1838');
INSERT INTO `cr_categroy` VALUES ('1850', '浙江大学中国古典文献学研究丛书', '36');
INSERT INTO `cr_categroy` VALUES ('1851', '浙江大学汉语史研究丛书', '36');
INSERT INTO `cr_categroy` VALUES ('1852', '南京师范大学汉语言文学专题研究系列', '36');
INSERT INTO `cr_categroy` VALUES ('1853', '华东师范大学中文系学术丛书', '36');
INSERT INTO `cr_categroy` VALUES ('1854', '中华生活经典', '1581');
INSERT INTO `cr_categroy` VALUES ('1856', '综合一', '1842');
INSERT INTO `cr_categroy` VALUES ('2095', '“一本书读懂”系列丛书', '41');
INSERT INTO `cr_categroy` VALUES ('2096', '中国史学的基本问题', '33');
INSERT INTO `cr_categroy` VALUES ('2097', '古典名著 名家点评', '39');
INSERT INTO `cr_categroy` VALUES ('2098', '韦政通文集', '36');
INSERT INTO `cr_categroy` VALUES ('2099', '全汉昇经济史著作集', '36');
INSERT INTO `cr_categroy` VALUES ('2100', '华林博士文库', '36');
INSERT INTO `cr_categroy` VALUES ('2102', '中华国学文库', '28');
INSERT INTO `cr_categroy` VALUES ('2103', '助学读物', '1590');
INSERT INTO `cr_categroy` VALUES ('2104', '中华思想经典', '40');
INSERT INTO `cr_categroy` VALUES ('2105', '佛教十三经', '40');
INSERT INTO `cr_categroy` VALUES ('2106', '迷悟之间', '40');
INSERT INTO `cr_categroy` VALUES ('2107', '李宗侗著作集', '33');
INSERT INTO `cr_categroy` VALUES ('2108', '中华经典精粹解读', '40');
