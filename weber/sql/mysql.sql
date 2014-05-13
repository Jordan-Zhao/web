/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : weber

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2014-05-13 11:03:11
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tb_business`
-- ----------------------------
DROP TABLE IF EXISTS `tb_business`;
CREATE TABLE `tb_business` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `submittime` datetime DEFAULT NULL,
  `ms` varchar(50) DEFAULT NULL,
  `img` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_business
-- ----------------------------
INSERT INTO tb_business VALUES ('1', 'www', 'aa', '2014-05-12 20:47:07', '12', null);
INSERT INTO tb_business VALUES ('2', 'wine', '???', null, '?????????', 'Koala.jpg');
INSERT INTO tb_business VALUES ('3', 'wine', 'wuliangye', null, 'wuliangyewuliangyewuliangye', 'Jellyfish.jpg');

-- ----------------------------
-- Table structure for `tb_category`
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(50) NOT NULL,
  `submittime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO tb_category VALUES ('1', 'wine', '2014-05-12 20:47:29');

-- ----------------------------
-- Table structure for `tb_news`
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `submittime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_news
-- ----------------------------
INSERT INTO tb_news VALUES ('1', 'qqqqqq', 'aaa', 'ss', '2014-05-12 20:47:43');
INSERT INTO tb_news VALUES ('2', 'qqqqqqqq', 'qqqqqqqqqqqq', '??', null);
INSERT INTO tb_news VALUES ('3', 'aaaaaaaaaaavvvvvvvvvv', 'vvvvvvvvvvv', '??', null);

-- ----------------------------
-- Table structure for `tb_usertable`
-- ----------------------------
DROP TABLE IF EXISTS `tb_usertable`;
CREATE TABLE `tb_usertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_usertable
-- ----------------------------
INSERT INTO tb_usertable VALUES ('1', 'admin', '111');
