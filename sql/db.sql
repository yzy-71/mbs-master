/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : localhost:3306
 Source Schema         : mbs_db

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 04/03/2024 13:18:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info`  (
  `operator_id` int NOT NULL AUTO_INCREMENT,
  `operator_name` varchar(205) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `operator_pass` varchar(205) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`operator_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES (2, 'admin', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for book_his_info
-- ----------------------------
DROP TABLE IF EXISTS `book_his_info`;
CREATE TABLE `book_his_info`  (
  `hid` int NOT NULL AUTO_INCREMENT,
  `aid` int NULL DEFAULT NULL,
  `bid` varchar(205) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `card` varchar(205) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `book_name` varchar(205) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `admin_name` varchar(205) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(205) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `begin_time` date NULL DEFAULT NULL,
  `end_time` date NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  PRIMARY KEY (`hid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_his_info
-- ----------------------------
INSERT INTO `book_his_info` VALUES (18, 4, '27', '777', 'Java从入门到入土', 'zs', '11111', '2024-03-04', '2024-04-03', 2);
INSERT INTO `book_his_info` VALUES (19, 4, '24', '1213', '三国演义', 'zs', '11111', '2024-03-04', '2024-04-03', 1);
INSERT INTO `book_his_info` VALUES (20, 4, '25', '12124', '操作系统', 'zs', '11111', '2024-03-04', '2024-04-03', 1);

-- ----------------------------
-- Table structure for book_type_info
-- ----------------------------
DROP TABLE IF EXISTS `book_type_info`;
CREATE TABLE `book_type_info`  (
  `tid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE,
  UNIQUE INDEX `book_type_info_pk`(`name` ASC) USING BTREE,
  UNIQUE INDEX `book_type_info_pk_2`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_type_info
-- ----------------------------
INSERT INTO `book_type_info` VALUES (87, '哲学');
INSERT INTO `book_type_info` VALUES (89, '政治');
INSERT INTO `book_type_info` VALUES (69, '文学小说');
INSERT INTO `book_type_info` VALUES (70, '杂志期刊');
INSERT INTO `book_type_info` VALUES (88, '科学');
INSERT INTO `book_type_info` VALUES (86, '编程语言');
INSERT INTO `book_type_info` VALUES (85, '计算机丛书');

-- ----------------------------
-- Table structure for books_info
-- ----------------------------
DROP TABLE IF EXISTS `books_info`;
CREATE TABLE `books_info`  (
  `bid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(205) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `card` varchar(205) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(205) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `num` int NOT NULL,
  `press` varchar(205) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(205) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT 2,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books_info
-- ----------------------------
INSERT INTO `books_info` VALUES (22, '水浒传', '789', '施耐庵', 100, '北京大学出版社', '文学小说', 1);
INSERT INTO `books_info` VALUES (24, '三国演义', '1213', '罗贯中', 1, '清华大学出版社', '文学小说', 1);
INSERT INTO `books_info` VALUES (25, '操作系统', '12124', 'OSLABEL', 1, '机械工业出版社', '计算机丛书', 1);
INSERT INTO `books_info` VALUES (26, '计算机网络', '666', '谢希仁', 1, '机械工业出版社', '计算机丛书', 2);
INSERT INTO `books_info` VALUES (27, 'Java入门', '777', 'Brian Goetz', 1, '人民出版社', '计算机丛书', 2);
INSERT INTO `books_info` VALUES (28, '相对论', '012', '爱因斯坦', 10, '北京大学出版社', '科学', 2);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `aid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT 1,
  `lend_num` int NULL DEFAULT 30 COMMENT '可借阅天数',
  `max_num` int NULL DEFAULT 15 COMMENT '可以借阅数量',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (4, 'zs', '11111', 'e10adc3949ba59abbe56e057f20f883e', '121231@qq.com', '15877666111', 1, 30, 15);
INSERT INTO `user_info` VALUES (5, 'ls', '11', 'e10adc3949ba59abbe56e057f20f883e', '121231@qq.com', '15877666111', 1, 30, 15);
INSERT INTO `user_info` VALUES (7, 'test', '12345', 'e10adc3949ba59abbe56e057f20f883e', '2113@qq.com', '15977666222', 1, 30, 15);
INSERT INTO `user_info` VALUES (8, '123456', '张三', 'e10adc3949ba59abbe56e057f20f883e', 'abc@163.com', '1668889991', 1, 30, 15);

SET FOREIGN_KEY_CHECKS = 1;
