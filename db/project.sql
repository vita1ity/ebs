/*
Navicat MySQL Data Transfer

Source Server         : f
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : project

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-12-27 17:10:10
*/
CREATE DATABASE project;
USE project;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'a4a88c0872bf652bb9ed803ece5fd6e82354838a9bf59ab4babb1dab322154e1', 'Admin', 'admin');
INSERT INTO `user` VALUES ('9', 'f4fbf4100c1016610107c9a2aef52212a0016e8defdc2e978f291353d369b224', 'Corporate', 'corporate');
INSERT INTO `user` VALUES ('11', 'd712fd0707024d055968b3a316f3469b53af73a2f1b475d19141b6f76276b4fc', 'Supplier', 'supplier');
INSERT INTO `user` VALUES ('16', 'fca21f8b0e337f4eab80b998ca9301d3478d00a84250dddc4dba48638b42de0b', 'Employee', 'employee');
