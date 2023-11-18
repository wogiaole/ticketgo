/*
 Navicat Premium Data Transfer

 Source Server         : goticket
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : goticket

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 18/11/2023 19:31:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `admin_name`(`admin_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123', NULL, NULL);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(10) NULL DEFAULT NULL,
  `movie_id` bigint(10) NULL DEFAULT NULL,
  `score` decimal(10, 2) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_time` datetime NULL DEFAULT NULL,
  `admin_id` bigint(10) NULL DEFAULT NULL,
  `is_deleted` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `is_deleted`(`is_deleted`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (2, 2, 1, 5.00, 'xxx', '2023-11-10 22:52:09', '2023-11-18 01:25:42', 1, 1);
INSERT INTO `comment` VALUES (3, 2, 3, 4.00, 'lj', '2023-11-10 22:52:37', NULL, NULL, 0);
INSERT INTO `comment` VALUES (4, 2, 3, 4.00, 'lj', '2023-11-10 22:54:27', NULL, NULL, 1);
INSERT INTO `comment` VALUES (5, 2, 3, 1.00, 'nooooooo', '2023-11-10 23:12:11', '2023-11-10 23:12:47', NULL, 1);
INSERT INTO `comment` VALUES (6, NULL, 6, 3.00, 'okkkkkk', '2023-11-10 23:13:47', NULL, NULL, 0);
INSERT INTO `comment` VALUES (7, 5, 6, 3.00, 'okkkkkk', '2023-11-10 23:14:28', '2023-11-10 23:15:45', 1, 1);
INSERT INTO `comment` VALUES (8, 5, 5, 1.00, 'boring', '2023-11-18 01:27:41', NULL, NULL, 0);

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie`  (
  `movie_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `genre` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `duration` int(10) NULL DEFAULT NULL,
  `country` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `director` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `actor` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `pulish_date` date NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `is_released` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`movie_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES (1, 'Inception', 'science', 120, 'American', 'xx', 'alex,jack,tom', 'a movie', '2023-11-06', '2023-11-06 04:35:35', NULL, 1);
INSERT INTO `movie` VALUES (2, 'lol', 'game', 120, 'American', 'riot', 'jack', 'good', '2022-11-20', '2023-11-06 04:37:05', NULL, 1);
INSERT INTO `movie` VALUES (3, 'Trainspotting', 'story', 125, 'England', 'danel', 'evan', '...', '1996-10-01', '2023-11-06 20:38:42', NULL, 1);
INSERT INTO `movie` VALUES (4, 'JoJo Golden Wind', 'story', 125, 'England', 'danel', 'evan', '...', '1996-10-01', '2023-11-06 20:38:42', NULL, 1);
INSERT INTO `movie` VALUES (5, 'Shining Diamond JoJo', 'story', 125, 'England', 'danel', 'evan', '...', '1996-10-01', '2023-11-06 20:38:44', NULL, 1);
INSERT INTO `movie` VALUES (6, 'JoJo Golden Wind', 'game', 100, 'Japan', 'x', 'k', 'hh', '1996-10-01', '2023-11-07 23:07:27', NULL, 1);
INSERT INTO `movie` VALUES (7, 'JoJo Stone Ocean', 'game', 100, 'Japan', 'x', 'k', 'hh', '1996-10-01', '2023-11-07 23:10:04', NULL, 1);
INSERT INTO `movie` VALUES (20, 'Trainspotting', 'story', 125, 'England', 'danel', 'evan', '...', '1996-10-01', '2023-11-18 01:40:48', NULL, 1);
INSERT INTO `movie` VALUES (21, 'Sky', 'story', 125, 'England', 'danel', 'evan', '...', '1996-10-01', '2023-11-18 03:05:07', NULL, 1);
INSERT INTO `movie` VALUES (22, 'key', 'love', 125, 'England', 'danel', 'evan', '...', '1996-10-01', '2023-11-18 04:04:32', NULL, 1);

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat`  (
  `seat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `showing_id` bigint(10) NULL DEFAULT NULL,
  `row_index` int(10) NULL DEFAULT NULL,
  `col_index` int(10) NULL DEFAULT NULL,
  `status` int(10) NULL DEFAULT NULL COMMENT '1:available 2：booked 3:sold',
  PRIMARY KEY (`seat_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 501 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES (1, 1, 1, 1, 1);
INSERT INTO `seat` VALUES (2, 1, 1, 2, 1);
INSERT INTO `seat` VALUES (3, 1, 1, 3, 1);
INSERT INTO `seat` VALUES (4, 1, 1, 4, 1);
INSERT INTO `seat` VALUES (5, 1, 1, 5, 1);
INSERT INTO `seat` VALUES (6, 1, 1, 6, 1);
INSERT INTO `seat` VALUES (7, 1, 1, 7, 1);
INSERT INTO `seat` VALUES (8, 1, 1, 8, 1);
INSERT INTO `seat` VALUES (9, 1, 1, 9, 1);
INSERT INTO `seat` VALUES (10, 1, 1, 10, 1);
INSERT INTO `seat` VALUES (11, 1, 2, 1, 1);
INSERT INTO `seat` VALUES (12, 1, 2, 2, 1);
INSERT INTO `seat` VALUES (13, 1, 2, 3, 1);
INSERT INTO `seat` VALUES (14, 1, 2, 4, 1);
INSERT INTO `seat` VALUES (15, 1, 2, 5, 1);
INSERT INTO `seat` VALUES (16, 1, 2, 6, 1);
INSERT INTO `seat` VALUES (17, 1, 2, 7, 1);
INSERT INTO `seat` VALUES (18, 1, 2, 8, 1);
INSERT INTO `seat` VALUES (19, 1, 2, 9, 1);
INSERT INTO `seat` VALUES (20, 1, 2, 10, 1);
INSERT INTO `seat` VALUES (21, 1, 3, 1, 1);
INSERT INTO `seat` VALUES (22, 1, 3, 2, 1);
INSERT INTO `seat` VALUES (23, 1, 3, 3, 1);
INSERT INTO `seat` VALUES (24, 1, 3, 4, 1);
INSERT INTO `seat` VALUES (25, 1, 3, 5, 1);
INSERT INTO `seat` VALUES (26, 1, 3, 6, 1);
INSERT INTO `seat` VALUES (27, 1, 3, 7, 1);
INSERT INTO `seat` VALUES (28, 1, 3, 8, 1);
INSERT INTO `seat` VALUES (29, 1, 3, 9, 1);
INSERT INTO `seat` VALUES (30, 1, 3, 10, 1);
INSERT INTO `seat` VALUES (31, 1, 4, 1, 1);
INSERT INTO `seat` VALUES (32, 1, 4, 2, 1);
INSERT INTO `seat` VALUES (33, 1, 4, 3, 1);
INSERT INTO `seat` VALUES (34, 1, 4, 4, 1);
INSERT INTO `seat` VALUES (35, 1, 4, 5, 1);
INSERT INTO `seat` VALUES (36, 1, 4, 6, 1);
INSERT INTO `seat` VALUES (37, 1, 4, 7, 1);
INSERT INTO `seat` VALUES (38, 1, 4, 8, 1);
INSERT INTO `seat` VALUES (39, 1, 4, 9, 1);
INSERT INTO `seat` VALUES (40, 1, 4, 10, 1);
INSERT INTO `seat` VALUES (41, 1, 5, 1, 2);
INSERT INTO `seat` VALUES (42, 1, 5, 2, 1);
INSERT INTO `seat` VALUES (43, 1, 5, 3, 1);
INSERT INTO `seat` VALUES (44, 1, 5, 4, 1);
INSERT INTO `seat` VALUES (45, 1, 5, 5, 1);
INSERT INTO `seat` VALUES (46, 1, 5, 6, 1);
INSERT INTO `seat` VALUES (47, 1, 5, 7, 1);
INSERT INTO `seat` VALUES (48, 1, 5, 8, 1);
INSERT INTO `seat` VALUES (49, 1, 5, 9, 1);
INSERT INTO `seat` VALUES (50, 1, 5, 10, 3);
INSERT INTO `seat` VALUES (51, 1, 6, 1, 1);
INSERT INTO `seat` VALUES (52, 1, 6, 2, 1);
INSERT INTO `seat` VALUES (53, 1, 6, 3, 1);
INSERT INTO `seat` VALUES (54, 1, 6, 4, 1);
INSERT INTO `seat` VALUES (55, 1, 6, 5, 1);
INSERT INTO `seat` VALUES (56, 1, 6, 6, 1);
INSERT INTO `seat` VALUES (57, 1, 6, 7, 1);
INSERT INTO `seat` VALUES (58, 1, 6, 8, 1);
INSERT INTO `seat` VALUES (59, 1, 6, 9, 1);
INSERT INTO `seat` VALUES (60, 1, 6, 10, 1);
INSERT INTO `seat` VALUES (61, 1, 7, 1, 1);
INSERT INTO `seat` VALUES (62, 1, 7, 2, 1);
INSERT INTO `seat` VALUES (63, 1, 7, 3, 1);
INSERT INTO `seat` VALUES (64, 1, 7, 4, 1);
INSERT INTO `seat` VALUES (65, 1, 7, 5, 1);
INSERT INTO `seat` VALUES (66, 1, 7, 6, 1);
INSERT INTO `seat` VALUES (67, 1, 7, 7, 1);
INSERT INTO `seat` VALUES (68, 1, 7, 8, 1);
INSERT INTO `seat` VALUES (69, 1, 7, 9, 1);
INSERT INTO `seat` VALUES (70, 1, 7, 10, 1);
INSERT INTO `seat` VALUES (71, 1, 8, 1, 1);
INSERT INTO `seat` VALUES (72, 1, 8, 2, 1);
INSERT INTO `seat` VALUES (73, 1, 8, 3, 1);
INSERT INTO `seat` VALUES (74, 1, 8, 4, 1);
INSERT INTO `seat` VALUES (75, 1, 8, 5, 1);
INSERT INTO `seat` VALUES (76, 1, 8, 6, 1);
INSERT INTO `seat` VALUES (77, 1, 8, 7, 1);
INSERT INTO `seat` VALUES (78, 1, 8, 8, 1);
INSERT INTO `seat` VALUES (79, 1, 8, 9, 1);
INSERT INTO `seat` VALUES (80, 1, 8, 10, 2);
INSERT INTO `seat` VALUES (81, 1, 9, 1, 1);
INSERT INTO `seat` VALUES (82, 1, 9, 2, 1);
INSERT INTO `seat` VALUES (83, 1, 9, 3, 1);
INSERT INTO `seat` VALUES (84, 1, 9, 4, 1);
INSERT INTO `seat` VALUES (85, 1, 9, 5, 1);
INSERT INTO `seat` VALUES (86, 1, 9, 6, 1);
INSERT INTO `seat` VALUES (87, 1, 9, 7, 1);
INSERT INTO `seat` VALUES (88, 1, 9, 8, 1);
INSERT INTO `seat` VALUES (89, 1, 9, 9, 1);
INSERT INTO `seat` VALUES (90, 1, 9, 10, 2);
INSERT INTO `seat` VALUES (91, 1, 10, 1, 1);
INSERT INTO `seat` VALUES (92, 1, 10, 2, 1);
INSERT INTO `seat` VALUES (93, 1, 10, 3, 1);
INSERT INTO `seat` VALUES (94, 1, 10, 4, 1);
INSERT INTO `seat` VALUES (95, 1, 10, 5, 1);
INSERT INTO `seat` VALUES (96, 1, 10, 6, 1);
INSERT INTO `seat` VALUES (97, 1, 10, 7, 1);
INSERT INTO `seat` VALUES (98, 1, 10, 8, 1);
INSERT INTO `seat` VALUES (99, 1, 10, 9, 1);
INSERT INTO `seat` VALUES (100, 1, 10, 10, 1);
INSERT INTO `seat` VALUES (101, 2, 1, 1, 1);
INSERT INTO `seat` VALUES (102, 2, 1, 2, 1);
INSERT INTO `seat` VALUES (103, 2, 1, 3, 1);
INSERT INTO `seat` VALUES (104, 2, 1, 4, 1);
INSERT INTO `seat` VALUES (105, 2, 1, 5, 1);
INSERT INTO `seat` VALUES (106, 2, 1, 6, 1);
INSERT INTO `seat` VALUES (107, 2, 1, 7, 1);
INSERT INTO `seat` VALUES (108, 2, 1, 8, 1);
INSERT INTO `seat` VALUES (109, 2, 1, 9, 1);
INSERT INTO `seat` VALUES (110, 2, 1, 10, 1);
INSERT INTO `seat` VALUES (111, 2, 2, 1, 1);
INSERT INTO `seat` VALUES (112, 2, 2, 2, 1);
INSERT INTO `seat` VALUES (113, 2, 2, 3, 1);
INSERT INTO `seat` VALUES (114, 2, 2, 4, 1);
INSERT INTO `seat` VALUES (115, 2, 2, 5, 1);
INSERT INTO `seat` VALUES (116, 2, 2, 6, 1);
INSERT INTO `seat` VALUES (117, 2, 2, 7, 1);
INSERT INTO `seat` VALUES (118, 2, 2, 8, 1);
INSERT INTO `seat` VALUES (119, 2, 2, 9, 1);
INSERT INTO `seat` VALUES (120, 2, 2, 10, 1);
INSERT INTO `seat` VALUES (121, 2, 3, 1, 1);
INSERT INTO `seat` VALUES (122, 2, 3, 2, 1);
INSERT INTO `seat` VALUES (123, 2, 3, 3, 1);
INSERT INTO `seat` VALUES (124, 2, 3, 4, 1);
INSERT INTO `seat` VALUES (125, 2, 3, 5, 1);
INSERT INTO `seat` VALUES (126, 2, 3, 6, 1);
INSERT INTO `seat` VALUES (127, 2, 3, 7, 1);
INSERT INTO `seat` VALUES (128, 2, 3, 8, 1);
INSERT INTO `seat` VALUES (129, 2, 3, 9, 1);
INSERT INTO `seat` VALUES (130, 2, 3, 10, 1);
INSERT INTO `seat` VALUES (131, 2, 4, 1, 1);
INSERT INTO `seat` VALUES (132, 2, 4, 2, 1);
INSERT INTO `seat` VALUES (133, 2, 4, 3, 1);
INSERT INTO `seat` VALUES (134, 2, 4, 4, 1);
INSERT INTO `seat` VALUES (135, 2, 4, 5, 1);
INSERT INTO `seat` VALUES (136, 2, 4, 6, 1);
INSERT INTO `seat` VALUES (137, 2, 4, 7, 1);
INSERT INTO `seat` VALUES (138, 2, 4, 8, 1);
INSERT INTO `seat` VALUES (139, 2, 4, 9, 1);
INSERT INTO `seat` VALUES (140, 2, 4, 10, 1);
INSERT INTO `seat` VALUES (141, 2, 5, 1, 1);
INSERT INTO `seat` VALUES (142, 2, 5, 2, 1);
INSERT INTO `seat` VALUES (143, 2, 5, 3, 1);
INSERT INTO `seat` VALUES (144, 2, 5, 4, 1);
INSERT INTO `seat` VALUES (145, 2, 5, 5, 1);
INSERT INTO `seat` VALUES (146, 2, 5, 6, 1);
INSERT INTO `seat` VALUES (147, 2, 5, 7, 1);
INSERT INTO `seat` VALUES (148, 2, 5, 8, 1);
INSERT INTO `seat` VALUES (149, 2, 5, 9, 1);
INSERT INTO `seat` VALUES (150, 2, 5, 10, 1);
INSERT INTO `seat` VALUES (151, 2, 6, 1, 1);
INSERT INTO `seat` VALUES (152, 2, 6, 2, 1);
INSERT INTO `seat` VALUES (153, 2, 6, 3, 1);
INSERT INTO `seat` VALUES (154, 2, 6, 4, 1);
INSERT INTO `seat` VALUES (155, 2, 6, 5, 1);
INSERT INTO `seat` VALUES (156, 2, 6, 6, 1);
INSERT INTO `seat` VALUES (157, 2, 6, 7, 1);
INSERT INTO `seat` VALUES (158, 2, 6, 8, 1);
INSERT INTO `seat` VALUES (159, 2, 6, 9, 1);
INSERT INTO `seat` VALUES (160, 2, 6, 10, 1);
INSERT INTO `seat` VALUES (161, 2, 7, 1, 1);
INSERT INTO `seat` VALUES (162, 2, 7, 2, 1);
INSERT INTO `seat` VALUES (163, 2, 7, 3, 1);
INSERT INTO `seat` VALUES (164, 2, 7, 4, 1);
INSERT INTO `seat` VALUES (165, 2, 7, 5, 1);
INSERT INTO `seat` VALUES (166, 2, 7, 6, 1);
INSERT INTO `seat` VALUES (167, 2, 7, 7, 1);
INSERT INTO `seat` VALUES (168, 2, 7, 8, 1);
INSERT INTO `seat` VALUES (169, 2, 7, 9, 1);
INSERT INTO `seat` VALUES (170, 2, 7, 10, 1);
INSERT INTO `seat` VALUES (171, 2, 8, 1, 1);
INSERT INTO `seat` VALUES (172, 2, 8, 2, 1);
INSERT INTO `seat` VALUES (173, 2, 8, 3, 1);
INSERT INTO `seat` VALUES (174, 2, 8, 4, 1);
INSERT INTO `seat` VALUES (175, 2, 8, 5, 1);
INSERT INTO `seat` VALUES (176, 2, 8, 6, 1);
INSERT INTO `seat` VALUES (177, 2, 8, 7, 1);
INSERT INTO `seat` VALUES (178, 2, 8, 8, 1);
INSERT INTO `seat` VALUES (179, 2, 8, 9, 1);
INSERT INTO `seat` VALUES (180, 2, 8, 10, 1);
INSERT INTO `seat` VALUES (181, 2, 9, 1, 1);
INSERT INTO `seat` VALUES (182, 2, 9, 2, 1);
INSERT INTO `seat` VALUES (183, 2, 9, 3, 1);
INSERT INTO `seat` VALUES (184, 2, 9, 4, 1);
INSERT INTO `seat` VALUES (185, 2, 9, 5, 1);
INSERT INTO `seat` VALUES (186, 2, 9, 6, 1);
INSERT INTO `seat` VALUES (187, 2, 9, 7, 1);
INSERT INTO `seat` VALUES (188, 2, 9, 8, 1);
INSERT INTO `seat` VALUES (189, 2, 9, 9, 1);
INSERT INTO `seat` VALUES (190, 2, 9, 10, 1);
INSERT INTO `seat` VALUES (191, 2, 10, 1, 1);
INSERT INTO `seat` VALUES (192, 2, 10, 2, 1);
INSERT INTO `seat` VALUES (193, 2, 10, 3, 1);
INSERT INTO `seat` VALUES (194, 2, 10, 4, 1);
INSERT INTO `seat` VALUES (195, 2, 10, 5, 1);
INSERT INTO `seat` VALUES (196, 2, 10, 6, 1);
INSERT INTO `seat` VALUES (197, 2, 10, 7, 1);
INSERT INTO `seat` VALUES (198, 2, 10, 8, 1);
INSERT INTO `seat` VALUES (199, 2, 10, 9, 1);
INSERT INTO `seat` VALUES (200, 2, 10, 10, 1);
INSERT INTO `seat` VALUES (201, 3, 1, 1, 1);
INSERT INTO `seat` VALUES (202, 3, 1, 2, 1);
INSERT INTO `seat` VALUES (203, 3, 1, 3, 1);
INSERT INTO `seat` VALUES (204, 3, 1, 4, 1);
INSERT INTO `seat` VALUES (205, 3, 1, 5, 1);
INSERT INTO `seat` VALUES (206, 3, 1, 6, 1);
INSERT INTO `seat` VALUES (207, 3, 1, 7, 1);
INSERT INTO `seat` VALUES (208, 3, 1, 8, 1);
INSERT INTO `seat` VALUES (209, 3, 1, 9, 1);
INSERT INTO `seat` VALUES (210, 3, 1, 10, 1);
INSERT INTO `seat` VALUES (211, 3, 2, 1, 1);
INSERT INTO `seat` VALUES (212, 3, 2, 2, 1);
INSERT INTO `seat` VALUES (213, 3, 2, 3, 1);
INSERT INTO `seat` VALUES (214, 3, 2, 4, 1);
INSERT INTO `seat` VALUES (215, 3, 2, 5, 1);
INSERT INTO `seat` VALUES (216, 3, 2, 6, 1);
INSERT INTO `seat` VALUES (217, 3, 2, 7, 1);
INSERT INTO `seat` VALUES (218, 3, 2, 8, 1);
INSERT INTO `seat` VALUES (219, 3, 2, 9, 1);
INSERT INTO `seat` VALUES (220, 3, 2, 10, 1);
INSERT INTO `seat` VALUES (221, 3, 3, 1, 1);
INSERT INTO `seat` VALUES (222, 3, 3, 2, 1);
INSERT INTO `seat` VALUES (223, 3, 3, 3, 1);
INSERT INTO `seat` VALUES (224, 3, 3, 4, 1);
INSERT INTO `seat` VALUES (225, 3, 3, 5, 1);
INSERT INTO `seat` VALUES (226, 3, 3, 6, 1);
INSERT INTO `seat` VALUES (227, 3, 3, 7, 1);
INSERT INTO `seat` VALUES (228, 3, 3, 8, 1);
INSERT INTO `seat` VALUES (229, 3, 3, 9, 1);
INSERT INTO `seat` VALUES (230, 3, 3, 10, 1);
INSERT INTO `seat` VALUES (231, 3, 4, 1, 1);
INSERT INTO `seat` VALUES (232, 3, 4, 2, 1);
INSERT INTO `seat` VALUES (233, 3, 4, 3, 1);
INSERT INTO `seat` VALUES (234, 3, 4, 4, 1);
INSERT INTO `seat` VALUES (235, 3, 4, 5, 1);
INSERT INTO `seat` VALUES (236, 3, 4, 6, 1);
INSERT INTO `seat` VALUES (237, 3, 4, 7, 1);
INSERT INTO `seat` VALUES (238, 3, 4, 8, 1);
INSERT INTO `seat` VALUES (239, 3, 4, 9, 1);
INSERT INTO `seat` VALUES (240, 3, 4, 10, 1);
INSERT INTO `seat` VALUES (241, 3, 5, 1, 1);
INSERT INTO `seat` VALUES (242, 3, 5, 2, 1);
INSERT INTO `seat` VALUES (243, 3, 5, 3, 1);
INSERT INTO `seat` VALUES (244, 3, 5, 4, 1);
INSERT INTO `seat` VALUES (245, 3, 5, 5, 1);
INSERT INTO `seat` VALUES (246, 3, 5, 6, 1);
INSERT INTO `seat` VALUES (247, 3, 5, 7, 1);
INSERT INTO `seat` VALUES (248, 3, 5, 8, 1);
INSERT INTO `seat` VALUES (249, 3, 5, 9, 1);
INSERT INTO `seat` VALUES (250, 3, 5, 10, 1);
INSERT INTO `seat` VALUES (251, 3, 6, 1, 1);
INSERT INTO `seat` VALUES (252, 3, 6, 2, 1);
INSERT INTO `seat` VALUES (253, 3, 6, 3, 1);
INSERT INTO `seat` VALUES (254, 3, 6, 4, 1);
INSERT INTO `seat` VALUES (255, 3, 6, 5, 1);
INSERT INTO `seat` VALUES (256, 3, 6, 6, 1);
INSERT INTO `seat` VALUES (257, 3, 6, 7, 1);
INSERT INTO `seat` VALUES (258, 3, 6, 8, 1);
INSERT INTO `seat` VALUES (259, 3, 6, 9, 1);
INSERT INTO `seat` VALUES (260, 3, 6, 10, 1);
INSERT INTO `seat` VALUES (261, 3, 7, 1, 1);
INSERT INTO `seat` VALUES (262, 3, 7, 2, 1);
INSERT INTO `seat` VALUES (263, 3, 7, 3, 1);
INSERT INTO `seat` VALUES (264, 3, 7, 4, 1);
INSERT INTO `seat` VALUES (265, 3, 7, 5, 1);
INSERT INTO `seat` VALUES (266, 3, 7, 6, 1);
INSERT INTO `seat` VALUES (267, 3, 7, 7, 1);
INSERT INTO `seat` VALUES (268, 3, 7, 8, 1);
INSERT INTO `seat` VALUES (269, 3, 7, 9, 1);
INSERT INTO `seat` VALUES (270, 3, 7, 10, 1);
INSERT INTO `seat` VALUES (271, 3, 8, 1, 1);
INSERT INTO `seat` VALUES (272, 3, 8, 2, 1);
INSERT INTO `seat` VALUES (273, 3, 8, 3, 1);
INSERT INTO `seat` VALUES (274, 3, 8, 4, 1);
INSERT INTO `seat` VALUES (275, 3, 8, 5, 1);
INSERT INTO `seat` VALUES (276, 3, 8, 6, 1);
INSERT INTO `seat` VALUES (277, 3, 8, 7, 1);
INSERT INTO `seat` VALUES (278, 3, 8, 8, 1);
INSERT INTO `seat` VALUES (279, 3, 8, 9, 1);
INSERT INTO `seat` VALUES (280, 3, 8, 10, 1);
INSERT INTO `seat` VALUES (281, 3, 9, 1, 1);
INSERT INTO `seat` VALUES (282, 3, 9, 2, 1);
INSERT INTO `seat` VALUES (283, 3, 9, 3, 1);
INSERT INTO `seat` VALUES (284, 3, 9, 4, 1);
INSERT INTO `seat` VALUES (285, 3, 9, 5, 1);
INSERT INTO `seat` VALUES (286, 3, 9, 6, 1);
INSERT INTO `seat` VALUES (287, 3, 9, 7, 1);
INSERT INTO `seat` VALUES (288, 3, 9, 8, 1);
INSERT INTO `seat` VALUES (289, 3, 9, 9, 1);
INSERT INTO `seat` VALUES (290, 3, 9, 10, 1);
INSERT INTO `seat` VALUES (291, 3, 10, 1, 1);
INSERT INTO `seat` VALUES (292, 3, 10, 2, 1);
INSERT INTO `seat` VALUES (293, 3, 10, 3, 1);
INSERT INTO `seat` VALUES (294, 3, 10, 4, 1);
INSERT INTO `seat` VALUES (295, 3, 10, 5, 1);
INSERT INTO `seat` VALUES (296, 3, 10, 6, 1);
INSERT INTO `seat` VALUES (297, 3, 10, 7, 1);
INSERT INTO `seat` VALUES (298, 3, 10, 8, 1);
INSERT INTO `seat` VALUES (299, 3, 10, 9, 1);
INSERT INTO `seat` VALUES (300, 3, 10, 10, 1);
INSERT INTO `seat` VALUES (301, 4, 1, 1, 1);
INSERT INTO `seat` VALUES (302, 4, 1, 2, 1);
INSERT INTO `seat` VALUES (303, 4, 1, 3, 1);
INSERT INTO `seat` VALUES (304, 4, 1, 4, 1);
INSERT INTO `seat` VALUES (305, 4, 1, 5, 1);
INSERT INTO `seat` VALUES (306, 4, 1, 6, 1);
INSERT INTO `seat` VALUES (307, 4, 1, 7, 1);
INSERT INTO `seat` VALUES (308, 4, 1, 8, 1);
INSERT INTO `seat` VALUES (309, 4, 1, 9, 1);
INSERT INTO `seat` VALUES (310, 4, 1, 10, 1);
INSERT INTO `seat` VALUES (311, 4, 2, 1, 1);
INSERT INTO `seat` VALUES (312, 4, 2, 2, 1);
INSERT INTO `seat` VALUES (313, 4, 2, 3, 1);
INSERT INTO `seat` VALUES (314, 4, 2, 4, 1);
INSERT INTO `seat` VALUES (315, 4, 2, 5, 1);
INSERT INTO `seat` VALUES (316, 4, 2, 6, 1);
INSERT INTO `seat` VALUES (317, 4, 2, 7, 1);
INSERT INTO `seat` VALUES (318, 4, 2, 8, 1);
INSERT INTO `seat` VALUES (319, 4, 2, 9, 1);
INSERT INTO `seat` VALUES (320, 4, 2, 10, 1);
INSERT INTO `seat` VALUES (321, 4, 3, 1, 1);
INSERT INTO `seat` VALUES (322, 4, 3, 2, 1);
INSERT INTO `seat` VALUES (323, 4, 3, 3, 1);
INSERT INTO `seat` VALUES (324, 4, 3, 4, 1);
INSERT INTO `seat` VALUES (325, 4, 3, 5, 1);
INSERT INTO `seat` VALUES (326, 4, 3, 6, 1);
INSERT INTO `seat` VALUES (327, 4, 3, 7, 1);
INSERT INTO `seat` VALUES (328, 4, 3, 8, 1);
INSERT INTO `seat` VALUES (329, 4, 3, 9, 1);
INSERT INTO `seat` VALUES (330, 4, 3, 10, 1);
INSERT INTO `seat` VALUES (331, 4, 4, 1, 1);
INSERT INTO `seat` VALUES (332, 4, 4, 2, 1);
INSERT INTO `seat` VALUES (333, 4, 4, 3, 1);
INSERT INTO `seat` VALUES (334, 4, 4, 4, 1);
INSERT INTO `seat` VALUES (335, 4, 4, 5, 1);
INSERT INTO `seat` VALUES (336, 4, 4, 6, 1);
INSERT INTO `seat` VALUES (337, 4, 4, 7, 1);
INSERT INTO `seat` VALUES (338, 4, 4, 8, 1);
INSERT INTO `seat` VALUES (339, 4, 4, 9, 1);
INSERT INTO `seat` VALUES (340, 4, 4, 10, 1);
INSERT INTO `seat` VALUES (341, 4, 5, 1, 1);
INSERT INTO `seat` VALUES (342, 4, 5, 2, 1);
INSERT INTO `seat` VALUES (343, 4, 5, 3, 1);
INSERT INTO `seat` VALUES (344, 4, 5, 4, 1);
INSERT INTO `seat` VALUES (345, 4, 5, 5, 1);
INSERT INTO `seat` VALUES (346, 4, 5, 6, 1);
INSERT INTO `seat` VALUES (347, 4, 5, 7, 1);
INSERT INTO `seat` VALUES (348, 4, 5, 8, 1);
INSERT INTO `seat` VALUES (349, 4, 5, 9, 1);
INSERT INTO `seat` VALUES (350, 4, 5, 10, 1);
INSERT INTO `seat` VALUES (351, 4, 6, 1, 1);
INSERT INTO `seat` VALUES (352, 4, 6, 2, 1);
INSERT INTO `seat` VALUES (353, 4, 6, 3, 1);
INSERT INTO `seat` VALUES (354, 4, 6, 4, 1);
INSERT INTO `seat` VALUES (355, 4, 6, 5, 1);
INSERT INTO `seat` VALUES (356, 4, 6, 6, 1);
INSERT INTO `seat` VALUES (357, 4, 6, 7, 1);
INSERT INTO `seat` VALUES (358, 4, 6, 8, 1);
INSERT INTO `seat` VALUES (359, 4, 6, 9, 1);
INSERT INTO `seat` VALUES (360, 4, 6, 10, 1);
INSERT INTO `seat` VALUES (361, 4, 7, 1, 1);
INSERT INTO `seat` VALUES (362, 4, 7, 2, 1);
INSERT INTO `seat` VALUES (363, 4, 7, 3, 1);
INSERT INTO `seat` VALUES (364, 4, 7, 4, 1);
INSERT INTO `seat` VALUES (365, 4, 7, 5, 1);
INSERT INTO `seat` VALUES (366, 4, 7, 6, 1);
INSERT INTO `seat` VALUES (367, 4, 7, 7, 1);
INSERT INTO `seat` VALUES (368, 4, 7, 8, 1);
INSERT INTO `seat` VALUES (369, 4, 7, 9, 1);
INSERT INTO `seat` VALUES (370, 4, 7, 10, 1);
INSERT INTO `seat` VALUES (371, 4, 8, 1, 1);
INSERT INTO `seat` VALUES (372, 4, 8, 2, 1);
INSERT INTO `seat` VALUES (373, 4, 8, 3, 1);
INSERT INTO `seat` VALUES (374, 4, 8, 4, 1);
INSERT INTO `seat` VALUES (375, 4, 8, 5, 1);
INSERT INTO `seat` VALUES (376, 4, 8, 6, 1);
INSERT INTO `seat` VALUES (377, 4, 8, 7, 1);
INSERT INTO `seat` VALUES (378, 4, 8, 8, 1);
INSERT INTO `seat` VALUES (379, 4, 8, 9, 1);
INSERT INTO `seat` VALUES (380, 4, 8, 10, 1);
INSERT INTO `seat` VALUES (381, 4, 9, 1, 1);
INSERT INTO `seat` VALUES (382, 4, 9, 2, 1);
INSERT INTO `seat` VALUES (383, 4, 9, 3, 1);
INSERT INTO `seat` VALUES (384, 4, 9, 4, 1);
INSERT INTO `seat` VALUES (385, 4, 9, 5, 1);
INSERT INTO `seat` VALUES (386, 4, 9, 6, 1);
INSERT INTO `seat` VALUES (387, 4, 9, 7, 1);
INSERT INTO `seat` VALUES (388, 4, 9, 8, 1);
INSERT INTO `seat` VALUES (389, 4, 9, 9, 1);
INSERT INTO `seat` VALUES (390, 4, 9, 10, 1);
INSERT INTO `seat` VALUES (391, 4, 10, 1, 1);
INSERT INTO `seat` VALUES (392, 4, 10, 2, 1);
INSERT INTO `seat` VALUES (393, 4, 10, 3, 1);
INSERT INTO `seat` VALUES (394, 4, 10, 4, 1);
INSERT INTO `seat` VALUES (395, 4, 10, 5, 1);
INSERT INTO `seat` VALUES (396, 4, 10, 6, 1);
INSERT INTO `seat` VALUES (397, 4, 10, 7, 1);
INSERT INTO `seat` VALUES (398, 4, 10, 8, 1);
INSERT INTO `seat` VALUES (399, 4, 10, 9, 1);
INSERT INTO `seat` VALUES (400, 4, 10, 10, 1);
INSERT INTO `seat` VALUES (401, 5, 1, 1, 1);
INSERT INTO `seat` VALUES (402, 5, 1, 2, 1);
INSERT INTO `seat` VALUES (403, 5, 1, 3, 1);
INSERT INTO `seat` VALUES (404, 5, 1, 4, 1);
INSERT INTO `seat` VALUES (405, 5, 1, 5, 1);
INSERT INTO `seat` VALUES (406, 5, 1, 6, 1);
INSERT INTO `seat` VALUES (407, 5, 1, 7, 1);
INSERT INTO `seat` VALUES (408, 5, 1, 8, 1);
INSERT INTO `seat` VALUES (409, 5, 1, 9, 1);
INSERT INTO `seat` VALUES (410, 5, 1, 10, 1);
INSERT INTO `seat` VALUES (411, 5, 2, 1, 1);
INSERT INTO `seat` VALUES (412, 5, 2, 2, 1);
INSERT INTO `seat` VALUES (413, 5, 2, 3, 1);
INSERT INTO `seat` VALUES (414, 5, 2, 4, 1);
INSERT INTO `seat` VALUES (415, 5, 2, 5, 1);
INSERT INTO `seat` VALUES (416, 5, 2, 6, 1);
INSERT INTO `seat` VALUES (417, 5, 2, 7, 1);
INSERT INTO `seat` VALUES (418, 5, 2, 8, 1);
INSERT INTO `seat` VALUES (419, 5, 2, 9, 1);
INSERT INTO `seat` VALUES (420, 5, 2, 10, 1);
INSERT INTO `seat` VALUES (421, 5, 3, 1, 1);
INSERT INTO `seat` VALUES (422, 5, 3, 2, 1);
INSERT INTO `seat` VALUES (423, 5, 3, 3, 1);
INSERT INTO `seat` VALUES (424, 5, 3, 4, 1);
INSERT INTO `seat` VALUES (425, 5, 3, 5, 1);
INSERT INTO `seat` VALUES (426, 5, 3, 6, 1);
INSERT INTO `seat` VALUES (427, 5, 3, 7, 1);
INSERT INTO `seat` VALUES (428, 5, 3, 8, 1);
INSERT INTO `seat` VALUES (429, 5, 3, 9, 1);
INSERT INTO `seat` VALUES (430, 5, 3, 10, 1);
INSERT INTO `seat` VALUES (431, 5, 4, 1, 1);
INSERT INTO `seat` VALUES (432, 5, 4, 2, 1);
INSERT INTO `seat` VALUES (433, 5, 4, 3, 1);
INSERT INTO `seat` VALUES (434, 5, 4, 4, 1);
INSERT INTO `seat` VALUES (435, 5, 4, 5, 1);
INSERT INTO `seat` VALUES (436, 5, 4, 6, 1);
INSERT INTO `seat` VALUES (437, 5, 4, 7, 1);
INSERT INTO `seat` VALUES (438, 5, 4, 8, 1);
INSERT INTO `seat` VALUES (439, 5, 4, 9, 1);
INSERT INTO `seat` VALUES (440, 5, 4, 10, 1);
INSERT INTO `seat` VALUES (441, 5, 5, 1, 1);
INSERT INTO `seat` VALUES (442, 5, 5, 2, 1);
INSERT INTO `seat` VALUES (443, 5, 5, 3, 1);
INSERT INTO `seat` VALUES (444, 5, 5, 4, 1);
INSERT INTO `seat` VALUES (445, 5, 5, 5, 1);
INSERT INTO `seat` VALUES (446, 5, 5, 6, 1);
INSERT INTO `seat` VALUES (447, 5, 5, 7, 1);
INSERT INTO `seat` VALUES (448, 5, 5, 8, 1);
INSERT INTO `seat` VALUES (449, 5, 5, 9, 1);
INSERT INTO `seat` VALUES (450, 5, 5, 10, 1);
INSERT INTO `seat` VALUES (451, 5, 6, 1, 1);
INSERT INTO `seat` VALUES (452, 5, 6, 2, 1);
INSERT INTO `seat` VALUES (453, 5, 6, 3, 1);
INSERT INTO `seat` VALUES (454, 5, 6, 4, 1);
INSERT INTO `seat` VALUES (455, 5, 6, 5, 1);
INSERT INTO `seat` VALUES (456, 5, 6, 6, 1);
INSERT INTO `seat` VALUES (457, 5, 6, 7, 1);
INSERT INTO `seat` VALUES (458, 5, 6, 8, 1);
INSERT INTO `seat` VALUES (459, 5, 6, 9, 1);
INSERT INTO `seat` VALUES (460, 5, 6, 10, 1);
INSERT INTO `seat` VALUES (461, 5, 7, 1, 1);
INSERT INTO `seat` VALUES (462, 5, 7, 2, 1);
INSERT INTO `seat` VALUES (463, 5, 7, 3, 1);
INSERT INTO `seat` VALUES (464, 5, 7, 4, 1);
INSERT INTO `seat` VALUES (465, 5, 7, 5, 1);
INSERT INTO `seat` VALUES (466, 5, 7, 6, 1);
INSERT INTO `seat` VALUES (467, 5, 7, 7, 1);
INSERT INTO `seat` VALUES (468, 5, 7, 8, 1);
INSERT INTO `seat` VALUES (469, 5, 7, 9, 1);
INSERT INTO `seat` VALUES (470, 5, 7, 10, 1);
INSERT INTO `seat` VALUES (471, 5, 8, 1, 1);
INSERT INTO `seat` VALUES (472, 5, 8, 2, 1);
INSERT INTO `seat` VALUES (473, 5, 8, 3, 1);
INSERT INTO `seat` VALUES (474, 5, 8, 4, 1);
INSERT INTO `seat` VALUES (475, 5, 8, 5, 1);
INSERT INTO `seat` VALUES (476, 5, 8, 6, 1);
INSERT INTO `seat` VALUES (477, 5, 8, 7, 1);
INSERT INTO `seat` VALUES (478, 5, 8, 8, 1);
INSERT INTO `seat` VALUES (479, 5, 8, 9, 1);
INSERT INTO `seat` VALUES (480, 5, 8, 10, 1);
INSERT INTO `seat` VALUES (481, 5, 9, 1, 1);
INSERT INTO `seat` VALUES (482, 5, 9, 2, 1);
INSERT INTO `seat` VALUES (483, 5, 9, 3, 1);
INSERT INTO `seat` VALUES (484, 5, 9, 4, 1);
INSERT INTO `seat` VALUES (485, 5, 9, 5, 1);
INSERT INTO `seat` VALUES (486, 5, 9, 6, 1);
INSERT INTO `seat` VALUES (487, 5, 9, 7, 1);
INSERT INTO `seat` VALUES (488, 5, 9, 8, 1);
INSERT INTO `seat` VALUES (489, 5, 9, 9, 1);
INSERT INTO `seat` VALUES (490, 5, 9, 10, 1);
INSERT INTO `seat` VALUES (491, 5, 10, 1, 1);
INSERT INTO `seat` VALUES (492, 5, 10, 2, 1);
INSERT INTO `seat` VALUES (493, 5, 10, 3, 1);
INSERT INTO `seat` VALUES (494, 5, 10, 4, 1);
INSERT INTO `seat` VALUES (495, 5, 10, 5, 1);
INSERT INTO `seat` VALUES (496, 5, 10, 6, 1);
INSERT INTO `seat` VALUES (497, 5, 10, 7, 1);
INSERT INTO `seat` VALUES (498, 5, 10, 8, 1);
INSERT INTO `seat` VALUES (499, 5, 10, 9, 1);
INSERT INTO `seat` VALUES (500, 5, 10, 10, 1);

-- ----------------------------
-- Table structure for showing
-- ----------------------------
DROP TABLE IF EXISTS `showing`;
CREATE TABLE `showing`  (
  `showing_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `movie_id` bigint(10) NULL DEFAULT NULL,
  `theather_id` bigint(10) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '场次价格',
  `start_time` datetime NULL DEFAULT NULL COMMENT '场次开始时间',
  `end_time` datetime NULL DEFAULT NULL,
  `is_released` tinyint(1) NULL DEFAULT NULL COMMENT '上架/下架状态',
  PRIMARY KEY (`showing_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of showing
-- ----------------------------
INSERT INTO `showing` VALUES (1, 1, 1, 30.00, '2023-11-06 15:30:00', '2023-11-06 17:30:00', 1);
INSERT INTO `showing` VALUES (2, 2, 1, 30.00, '2023-11-02 15:10:00', '2023-11-02 17:10:00', 1);
INSERT INTO `showing` VALUES (3, 1, 1, 40.00, '2023-11-01 15:10:00', '2023-11-01 17:10:00', 1);
INSERT INTO `showing` VALUES (4, 1, 1, 40.00, '2023-10-01 15:10:00', '2023-10-01 17:10:00', 1);
INSERT INTO `showing` VALUES (5, 1, 1, 40.00, '2023-10-02 15:10:00', '2023-10-02 17:10:00', 1);

-- ----------------------------
-- Table structure for theather
-- ----------------------------
DROP TABLE IF EXISTS `theather`;
CREATE TABLE `theather`  (
  `theather_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `theather_name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `row` int(10) NULL DEFAULT NULL,
  `col` int(10) NULL DEFAULT NULL,
  `is_deleted` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`theather_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of theather
-- ----------------------------
INSERT INTO `theather` VALUES (1, 'start sea', 10, 10, 0);

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket`  (
  `ticket_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(10) NULL DEFAULT NULL,
  `showing_id` bigint(10) NULL DEFAULT NULL,
  `seat_id` bigint(20) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `status` int(10) NOT NULL,
  `create_time` datetime NULL DEFAULT NULL COMMENT '1:unpaid  2:paid  3:completed  4:canceled',
  `pay_time` datetime NULL DEFAULT NULL,
  `validate_admin_id` bigint(10) NULL DEFAULT NULL,
  `validate_time` datetime NULL DEFAULT NULL,
  `cancel_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`ticket_id`, `status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES (1, 4, 1, 50, 12.00, 3, '2023-11-18 00:49:58', '2023-11-18 02:52:02', NULL, '2023-11-18 03:00:38', NULL);
INSERT INTO `ticket` VALUES (2, 2, 1, 41, 24.00, 1, '2023-11-18 00:57:06', NULL, NULL, NULL, NULL);
INSERT INTO `ticket` VALUES (3, 4, 1, 80, 12.00, 2, '2023-11-18 01:57:33', NULL, NULL, NULL, NULL);
INSERT INTO `ticket` VALUES (4, 4, 1, 55, 12.00, 4, '2023-11-18 01:03:16', NULL, NULL, NULL, '2023-11-18 04:13:26');
INSERT INTO `ticket` VALUES (5, 4, 1, 90, 12.00, 1, '2023-11-18 04:14:30', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `type` int(10) NULL DEFAULT 1,
  `birthday` date NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `allow_nofity` tinyint(1) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `is_deleted` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'ani', 1, '2000-11-20', 'alex@gmail.com', '123', 0, '2023-11-18 02:39:52', 0);
INSERT INTO `user` VALUES (2, 'kate', 2, '1987-01-20', 'kate@gmail.com', '123', 0, '2023-11-18 02:40:17', 0);
INSERT INTO `user` VALUES (3, 'ming', 3, '1999-01-20', 'xxxx@gmail', '123456', 0, '2023-11-18 02:40:39', 0);
INSERT INTO `user` VALUES (4, 'alex', 2, '1999-11-18', 'xxxx@gmail', '123', 0, '2023-11-18 02:41:33', 0);

SET FOREIGN_KEY_CHECKS = 1;
