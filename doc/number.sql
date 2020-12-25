/*
Navicat MySQL Data Transfer

Source Server         : MySQL_Localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : number

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2020-12-25 15:50:22
*/


CREATE DATABASE IF NOT EXISTS `number` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE `number`;


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for number
-- ----------------------------
DROP TABLE IF EXISTS `number`;
CREATE TABLE `number` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `center_id` int(11) DEFAULT NULL COMMENT '中心编号 1 黑龙江中二院，2 深圳宝安医院，3 北京西苑医院',
  `center` varchar(32) DEFAULT NULL,
  `brinell_id` int(11) DEFAULT NULL COMMENT '布氏分期 1 痉挛期，2 恢复期',
  `brinell_periods` varchar(32) DEFAULT NULL,
  `case_num` varchar(32) DEFAULT NULL,
  `random_num` int(11) DEFAULT NULL,
  `interfere_group` varchar(32) DEFAULT NULL COMMENT '干预分组',
  `case_name` varchar(32) DEFAULT NULL,
  `case_id_card` varchar(32) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=376 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of number
-- ----------------------------
INSERT INTO `number` VALUES ('1', '1', '黑龙江中医大二院', '1', '痉挛期', '001', '4714', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('2', '1', '黑龙江中医大二院', '1', '痉挛期', '002', '7966', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('3', '1', '黑龙江中医大二院', '1', '痉挛期', '003', '2878', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('4', '1', '黑龙江中医大二院', '1', '痉挛期', '004', '3247', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('5', '1', '黑龙江中医大二院', '1', '痉挛期', '005', '6927', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('6', '1', '黑龙江中医大二院', '1', '痉挛期', '006', '4436', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('7', '1', '黑龙江中医大二院', '1', '痉挛期', '007', '4200', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('8', '1', '黑龙江中医大二院', '1', '痉挛期', '008', '2591', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('9', '1', '黑龙江中医大二院', '1', '痉挛期', '009', '1708', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('10', '1', '黑龙江中医大二院', '1', '痉挛期', '010', '5595', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('11', '1', '黑龙江中医大二院', '1', '痉挛期', '011', '1870', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('12', '1', '黑龙江中医大二院', '1', '痉挛期', '012', '7471', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('13', '1', '黑龙江中医大二院', '1', '痉挛期', '013', '7031', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('14', '1', '黑龙江中医大二院', '1', '痉挛期', '014', '7730', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('15', '1', '黑龙江中医大二院', '1', '痉挛期', '015', '7219', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('16', '1', '黑龙江中医大二院', '1', '痉挛期', '016', '5942', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('17', '1', '黑龙江中医大二院', '1', '痉挛期', '017', '3620', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('18', '1', '黑龙江中医大二院', '1', '痉挛期', '018', '1585', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('19', '1', '黑龙江中医大二院', '1', '痉挛期', '019', '3490', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('20', '1', '黑龙江中医大二院', '1', '痉挛期', '020', '6229', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('21', '1', '黑龙江中医大二院', '1', '痉挛期', '021', '2556', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('22', '1', '黑龙江中医大二院', '1', '痉挛期', '022', '2773', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('23', '1', '黑龙江中医大二院', '1', '痉挛期', '023', '4844', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('24', '1', '黑龙江中医大二院', '1', '痉挛期', '024', '3785', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('25', '1', '黑龙江中医大二院', '1', '痉挛期', '025', '8363', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('26', '1', '黑龙江中医大二院', '1', '痉挛期', '026', '3368', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('27', '1', '黑龙江中医大二院', '1', '痉挛期', '027', '2413', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('28', '1', '黑龙江中医大二院', '1', '痉挛期', '028', '8082', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('29', '1', '黑龙江中医大二院', '1', '痉挛期', '029', '8943', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('30', '1', '黑龙江中医大二院', '1', '痉挛期', '030', '8366', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('31', '1', '黑龙江中医大二院', '1', '痉挛期', '031', '3602', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('32', '1', '黑龙江中医大二院', '1', '痉挛期', '032', '9329', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('33', '1', '黑龙江中医大二院', '1', '痉挛期', '033', '3341', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('34', '1', '黑龙江中医大二院', '1', '痉挛期', '034', '8986', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('35', '1', '黑龙江中医大二院', '1', '痉挛期', '035', '2263', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('36', '1', '黑龙江中医大二院', '1', '痉挛期', '036', '6093', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('37', '1', '黑龙江中医大二院', '1', '痉挛期', '037', '5511', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('38', '1', '黑龙江中医大二院', '1', '痉挛期', '038', '5483', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('39', '1', '黑龙江中医大二院', '1', '痉挛期', '039', '5925', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('40', '1', '黑龙江中医大二院', '1', '痉挛期', '040', '8223', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('41', '1', '黑龙江中医大二院', '1', '痉挛期', '041', '4185', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('42', '1', '黑龙江中医大二院', '1', '痉挛期', '042', '2299', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('43', '1', '黑龙江中医大二院', '1', '痉挛期', '043', '1880', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('44', '1', '黑龙江中医大二院', '1', '痉挛期', '044', '9026', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('45', '1', '黑龙江中医大二院', '1', '痉挛期', '045', '6951', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('46', '1', '黑龙江中医大二院', '1', '痉挛期', '046', '4477', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('47', '1', '黑龙江中医大二院', '1', '痉挛期', '047', '5448', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('48', '1', '黑龙江中医大二院', '1', '痉挛期', '048', '4259', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('49', '1', '黑龙江中医大二院', '1', '痉挛期', '049', '2647', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('50', '1', '黑龙江中医大二院', '1', '痉挛期', '050', '7183', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('51', '1', '黑龙江中医大二院', '1', '痉挛期', '051', '2047', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('52', '1', '黑龙江中医大二院', '1', '痉挛期', '052', '5494', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('53', '1', '黑龙江中医大二院', '1', '痉挛期', '053', '2054', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('54', '1', '黑龙江中医大二院', '1', '痉挛期', '054', '3862', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('55', '1', '黑龙江中医大二院', '1', '痉挛期', '055', '6102', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('56', '1', '黑龙江中医大二院', '1', '痉挛期', '056', '4245', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('57', '1', '黑龙江中医大二院', '1', '痉挛期', '057', '4949', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('58', '1', '黑龙江中医大二院', '1', '痉挛期', '058', '8015', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('59', '1', '黑龙江中医大二院', '1', '痉挛期', '059', '8039', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('60', '1', '黑龙江中医大二院', '1', '痉挛期', '060', '4793', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('61', '1', '黑龙江中医大二院', '1', '痉挛期', '061', '6172', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('62', '1', '黑龙江中医大二院', '1', '痉挛期', '062', '4931', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('63', '1', '黑龙江中医大二院', '1', '痉挛期', '063', '2162', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('64', '1', '黑龙江中医大二院', '1', '痉挛期', '064', '8226', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('65', '1', '黑龙江中医大二院', '1', '痉挛期', '065', '9295', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('66', '1', '黑龙江中医大二院', '1', '痉挛期', '066', '7334', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('67', '1', '黑龙江中医大二院', '1', '痉挛期', '067', '1552', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('68', '1', '黑龙江中医大二院', '1', '痉挛期', '068', '3593', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('69', '1', '黑龙江中医大二院', '1', '痉挛期', '069', '4785', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('70', '1', '黑龙江中医大二院', '1', '痉挛期', '070', '6880', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('71', '1', '黑龙江中医大二院', '1', '痉挛期', '071', '7008', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('72', '1', '黑龙江中医大二院', '1', '痉挛期', '072', '7084', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('73', '1', '黑龙江中医大二院', '1', '痉挛期', '073', '8878', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('74', '1', '黑龙江中医大二院', '1', '痉挛期', '074', '6977', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('75', '1', '黑龙江中医大二院', '1', '痉挛期', '075', '5601', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('76', '1', '黑龙江中医大二院', '1', '痉挛期', '076', '3928', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('77', '1', '黑龙江中医大二院', '1', '痉挛期', '077', '2170', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('78', '1', '黑龙江中医大二院', '1', '痉挛期', '078', '7069', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('79', '1', '黑龙江中医大二院', '1', '痉挛期', '079', '1677', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('80', '1', '黑龙江中医大二院', '1', '痉挛期', '080', '4595', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('81', '1', '黑龙江中医大二院', '1', '痉挛期', '081', '8896', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('82', '1', '黑龙江中医大二院', '1', '痉挛期', '082', '2005', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('83', '1', '黑龙江中医大二院', '1', '痉挛期', '083', '8948', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('84', '1', '黑龙江中医大二院', '1', '痉挛期', '084', '3786', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('85', '1', '黑龙江中医大二院', '1', '痉挛期', '085', '3756', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('86', '1', '黑龙江中医大二院', '1', '痉挛期', '086', '7450', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('87', '1', '黑龙江中医大二院', '1', '痉挛期', '087', '5430', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('88', '1', '黑龙江中医大二院', '1', '痉挛期', '088', '1847', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('89', '1', '黑龙江中医大二院', '1', '痉挛期', '089', '8033', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('90', '1', '黑龙江中医大二院', '1', '痉挛期', '090', '8912', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('91', '1', '黑龙江中医大二院', '1', '痉挛期', '091', '2622', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('92', '1', '黑龙江中医大二院', '1', '痉挛期', '092', '2267', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('93', '1', '黑龙江中医大二院', '1', '痉挛期', '093', '2618', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('94', '1', '黑龙江中医大二院', '2', '恢复期', '001', '5114', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('95', '1', '黑龙江中医大二院', '2', '恢复期', '002', '8686', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('96', '1', '黑龙江中医大二院', '2', '恢复期', '003', '2136', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('97', '1', '黑龙江中医大二院', '2', '恢复期', '004', '1466', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('98', '1', '黑龙江中医大二院', '2', '恢复期', '005', '2340', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('99', '1', '黑龙江中医大二院', '2', '恢复期', '006', '6882', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('100', '1', '黑龙江中医大二院', '2', '恢复期', '007', '4302', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('101', '1', '黑龙江中医大二院', '2', '恢复期', '008', '8718', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('102', '1', '黑龙江中医大二院', '2', '恢复期', '009', '2959', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('103', '1', '黑龙江中医大二院', '2', '恢复期', '010', '6993', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('104', '1', '黑龙江中医大二院', '2', '恢复期', '011', '2666', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('105', '1', '黑龙江中医大二院', '2', '恢复期', '012', '3342', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('106', '1', '黑龙江中医大二院', '2', '恢复期', '013', '6577', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('107', '1', '黑龙江中医大二院', '2', '恢复期', '014', '2508', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('108', '1', '黑龙江中医大二院', '2', '恢复期', '015', '1625', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('109', '1', '黑龙江中医大二院', '2', '恢复期', '016', '7128', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('110', '1', '黑龙江中医大二院', '2', '恢复期', '017', '6225', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('111', '1', '黑龙江中医大二院', '2', '恢复期', '018', '8760', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('112', '1', '黑龙江中医大二院', '2', '恢复期', '019', '5013', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('113', '1', '黑龙江中医大二院', '2', '恢复期', '020', '3508', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('114', '1', '黑龙江中医大二院', '2', '恢复期', '021', '7062', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('115', '1', '黑龙江中医大二院', '2', '恢复期', '022', '2375', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('116', '1', '黑龙江中医大二院', '2', '恢复期', '023', '2723', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('117', '1', '黑龙江中医大二院', '2', '恢复期', '024', '1675', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('118', '1', '黑龙江中医大二院', '2', '恢复期', '025', '4307', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('119', '1', '黑龙江中医大二院', '2', '恢复期', '026', '4699', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('120', '1', '黑龙江中医大二院', '2', '恢复期', '027', '9330', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('121', '1', '黑龙江中医大二院', '2', '恢复期', '028', '9012', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('122', '1', '黑龙江中医大二院', '2', '恢复期', '029', '2217', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('123', '1', '黑龙江中医大二院', '2', '恢复期', '030', '2462', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('124', '1', '黑龙江中医大二院', '2', '恢复期', '031', '7114', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('125', '1', '黑龙江中医大二院', '2', '恢复期', '032', '2124', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('126', '1', '黑龙江中医大二院', '2', '恢复期', '033', '6409', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('127', '1', '黑龙江中医大二院', '2', '恢复期', '034', '4277', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('128', '1', '黑龙江中医大二院', '2', '恢复期', '035', '2291', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('129', '1', '黑龙江中医大二院', '2', '恢复期', '036', '4234', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('130', '1', '黑龙江中医大二院', '2', '恢复期', '037', '3765', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('131', '1', '黑龙江中医大二院', '2', '恢复期', '038', '8293', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('132', '1', '黑龙江中医大二院', '2', '恢复期', '039', '2383', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('133', '1', '黑龙江中医大二院', '2', '恢复期', '040', '7557', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('134', '1', '黑龙江中医大二院', '2', '恢复期', '041', '3944', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('135', '1', '黑龙江中医大二院', '2', '恢复期', '042', '7598', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('136', '1', '黑龙江中医大二院', '2', '恢复期', '043', '2066', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('137', '1', '黑龙江中医大二院', '2', '恢复期', '044', '4040', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('138', '1', '黑龙江中医大二院', '2', '恢复期', '045', '2422', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('139', '1', '黑龙江中医大二院', '2', '恢复期', '046', '4672', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('140', '1', '黑龙江中医大二院', '2', '恢复期', '047', '4177', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('141', '1', '黑龙江中医大二院', '2', '恢复期', '048', '5868', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('142', '1', '黑龙江中医大二院', '2', '恢复期', '049', '4482', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('143', '1', '黑龙江中医大二院', '2', '恢复期', '050', '3971', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('144', '1', '黑龙江中医大二院', '2', '恢复期', '051', '1710', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('145', '1', '黑龙江中医大二院', '2', '恢复期', '052', '5829', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('146', '1', '黑龙江中医大二院', '2', '恢复期', '053', '9151', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('147', '1', '黑龙江中医大二院', '2', '恢复期', '054', '7631', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('148', '1', '黑龙江中医大二院', '2', '恢复期', '055', '1411', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('149', '1', '黑龙江中医大二院', '2', '恢复期', '056', '7854', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('150', '1', '黑龙江中医大二院', '2', '恢复期', '057', '3837', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('151', '1', '黑龙江中医大二院', '2', '恢复期', '058', '2408', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('152', '1', '黑龙江中医大二院', '2', '恢复期', '059', '4390', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('153', '1', '黑龙江中医大二院', '2', '恢复期', '060', '7540', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('154', '1', '黑龙江中医大二院', '2', '恢复期', '061', '8234', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('155', '1', '黑龙江中医大二院', '2', '恢复期', '062', '9322', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('156', '1', '黑龙江中医大二院', '2', '恢复期', '063', '3216', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('157', '1', '黑龙江中医大二院', '2', '恢复期', '064', '4118', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('158', '1', '黑龙江中医大二院', '2', '恢复期', '065', '7599', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('159', '1', '黑龙江中医大二院', '2', '恢复期', '066', '9064', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('160', '1', '黑龙江中医大二院', '2', '恢复期', '067', '4845', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('161', '1', '黑龙江中医大二院', '2', '恢复期', '068', '8314', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('162', '1', '黑龙江中医大二院', '2', '恢复期', '069', '6621', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('163', '1', '黑龙江中医大二院', '2', '恢复期', '070', '1981', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('164', '1', '黑龙江中医大二院', '2', '恢复期', '071', '8885', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('165', '1', '黑龙江中医大二院', '2', '恢复期', '072', '5932', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('166', '2', '深圳宝安区人民医院', '1', '痉挛期', '001', '3480', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('167', '2', '深圳宝安区人民医院', '1', '痉挛期', '002', '4673', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('168', '2', '深圳宝安区人民医院', '1', '痉挛期', '003', '5777', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('169', '2', '深圳宝安区人民医院', '1', '痉挛期', '004', '5880', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('170', '2', '深圳宝安区人民医院', '1', '痉挛期', '005', '1567', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('171', '2', '深圳宝安区人民医院', '1', '痉挛期', '006', '9351', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('172', '2', '深圳宝安区人民医院', '1', '痉挛期', '007', '6988', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('173', '2', '深圳宝安区人民医院', '1', '痉挛期', '008', '1688', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('174', '2', '深圳宝安区人民医院', '1', '痉挛期', '009', '2341', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('175', '2', '深圳宝安区人民医院', '1', '痉挛期', '010', '1519', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('176', '2', '深圳宝安区人民医院', '1', '痉挛期', '011', '5681', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('177', '2', '深圳宝安区人民医院', '1', '痉挛期', '012', '5647', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('178', '2', '深圳宝安区人民医院', '1', '痉挛期', '013', '2865', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('179', '2', '深圳宝安区人民医院', '1', '痉挛期', '014', '8620', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('180', '2', '深圳宝安区人民医院', '1', '痉挛期', '015', '2978', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('181', '2', '深圳宝安区人民医院', '1', '痉挛期', '016', '6535', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('182', '2', '深圳宝安区人民医院', '1', '痉挛期', '017', '5173', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('183', '2', '深圳宝安区人民医院', '1', '痉挛期', '018', '1952', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('184', '2', '深圳宝安区人民医院', '1', '痉挛期', '019', '4006', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('185', '2', '深圳宝安区人民医院', '1', '痉挛期', '020', '2344', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('186', '2', '深圳宝安区人民医院', '1', '痉挛期', '021', '2023', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('187', '2', '深圳宝安区人民医院', '1', '痉挛期', '022', '5779', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('188', '2', '深圳宝安区人民医院', '1', '痉挛期', '023', '7817', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('189', '2', '深圳宝安区人民医院', '1', '痉挛期', '024', '5336', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('190', '2', '深圳宝安区人民医院', '1', '痉挛期', '025', '8154', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('191', '2', '深圳宝安区人民医院', '1', '痉挛期', '026', '3829', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('192', '2', '深圳宝安区人民医院', '1', '痉挛期', '027', '8574', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('193', '2', '深圳宝安区人民医院', '1', '痉挛期', '028', '7276', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('194', '2', '深圳宝安区人民医院', '1', '痉挛期', '029', '3308', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('195', '2', '深圳宝安区人民医院', '1', '痉挛期', '030', '3135', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('196', '2', '深圳宝安区人民医院', '1', '痉挛期', '031', '5702', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('197', '2', '深圳宝安区人民医院', '1', '痉挛期', '032', '3754', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('198', '2', '深圳宝安区人民医院', '1', '痉挛期', '033', '4036', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('199', '2', '深圳宝安区人民医院', '1', '痉挛期', '034', '5482', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('200', '2', '深圳宝安区人民医院', '1', '痉挛期', '035', '3433', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('201', '2', '深圳宝安区人民医院', '1', '痉挛期', '036', '3467', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('202', '2', '深圳宝安区人民医院', '1', '痉挛期', '037', '3121', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('203', '2', '深圳宝安区人民医院', '1', '痉挛期', '038', '4403', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('204', '2', '深圳宝安区人民医院', '1', '痉挛期', '039', '6254', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('205', '2', '深圳宝安区人民医院', '1', '痉挛期', '040', '1391', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('206', '2', '深圳宝安区人民医院', '1', '痉挛期', '041', '4516', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('207', '2', '深圳宝安区人民医院', '1', '痉挛期', '042', '6503', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('208', '2', '深圳宝安区人民医院', '1', '痉挛期', '043', '6374', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('209', '2', '深圳宝安区人民医院', '1', '痉挛期', '044', '5618', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('210', '2', '深圳宝安区人民医院', '1', '痉挛期', '045', '9002', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('211', '2', '深圳宝安区人民医院', '1', '痉挛期', '046', '1486', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('212', '2', '深圳宝安区人民医院', '1', '痉挛期', '047', '2600', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('213', '2', '深圳宝安区人民医院', '1', '痉挛期', '048', '6934', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('214', '2', '深圳宝安区人民医院', '1', '痉挛期', '049', '7970', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('215', '2', '深圳宝安区人民医院', '1', '痉挛期', '050', '9240', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('216', '2', '深圳宝安区人民医院', '1', '痉挛期', '051', '1550', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('217', '2', '深圳宝安区人民医院', '1', '痉挛期', '052', '7299', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('218', '2', '深圳宝安区人民医院', '1', '痉挛期', '053', '5294', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('219', '2', '深圳宝安区人民医院', '1', '痉挛期', '054', '3015', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('220', '2', '深圳宝安区人民医院', '1', '痉挛期', '055', '4627', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('221', '2', '深圳宝安区人民医院', '1', '痉挛期', '056', '3579', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('222', '2', '深圳宝安区人民医院', '1', '痉挛期', '057', '5134', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('223', '2', '深圳宝安区人民医院', '1', '痉挛期', '058', '4801', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('224', '2', '深圳宝安区人民医院', '1', '痉挛期', '059', '4218', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('225', '2', '深圳宝安区人民医院', '1', '痉挛期', '060', '5987', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('226', '2', '深圳宝安区人民医院', '2', '恢复期', '001', '8592', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('227', '2', '深圳宝安区人民医院', '2', '恢复期', '002', '8584', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('228', '2', '深圳宝安区人民医院', '2', '恢复期', '003', '7213', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('229', '2', '深圳宝安区人民医院', '2', '恢复期', '004', '6602', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('230', '2', '深圳宝安区人民医院', '2', '恢复期', '005', '6111', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('231', '2', '深圳宝安区人民医院', '2', '恢复期', '006', '2575', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('232', '2', '深圳宝安区人民医院', '2', '恢复期', '007', '2030', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('233', '2', '深圳宝安区人民医院', '2', '恢复期', '008', '6606', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('234', '2', '深圳宝安区人民医院', '2', '恢复期', '009', '5188', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('235', '2', '深圳宝安区人民医院', '2', '恢复期', '010', '1874', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('236', '2', '深圳宝安区人民医院', '2', '恢复期', '011', '1719', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('237', '2', '深圳宝安区人民医院', '2', '恢复期', '012', '9190', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('238', '2', '深圳宝安区人民医院', '2', '恢复期', '013', '2309', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('239', '2', '深圳宝安区人民医院', '2', '恢复期', '014', '8647', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('240', '2', '深圳宝安区人民医院', '2', '恢复期', '015', '6082', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('241', '2', '深圳宝安区人民医院', '2', '恢复期', '016', '8552', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('242', '2', '深圳宝安区人民医院', '2', '恢复期', '017', '8746', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('243', '2', '深圳宝安区人民医院', '2', '恢复期', '018', '2407', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('244', '2', '深圳宝安区人民医院', '2', '恢复期', '019', '6013', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('245', '2', '深圳宝安区人民医院', '2', '恢复期', '020', '5268', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('246', '2', '深圳宝安区人民医院', '2', '恢复期', '021', '1452', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('247', '2', '深圳宝安区人民医院', '2', '恢复期', '022', '5955', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('248', '2', '深圳宝安区人民医院', '2', '恢复期', '023', '4742', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('249', '2', '深圳宝安区人民医院', '2', '恢复期', '024', '3975', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('250', '2', '深圳宝安区人民医院', '2', '恢复期', '025', '8817', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('251', '2', '深圳宝安区人民医院', '2', '恢复期', '026', '8578', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('252', '2', '深圳宝安区人民医院', '2', '恢复期', '027', '7627', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('253', '2', '深圳宝安区人民医院', '2', '恢复期', '028', '6701', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('254', '2', '深圳宝安区人民医院', '2', '恢复期', '029', '2763', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('255', '2', '深圳宝安区人民医院', '2', '恢复期', '030', '3041', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('256', '2', '深圳宝安区人民医院', '2', '恢复期', '031', '4474', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('257', '2', '深圳宝安区人民医院', '2', '恢复期', '032', '8471', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('258', '2', '深圳宝安区人民医院', '2', '恢复期', '033', '3909', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('259', '2', '深圳宝安区人民医院', '2', '恢复期', '034', '4979', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('260', '2', '深圳宝安区人民医院', '2', '恢复期', '035', '5813', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('261', '2', '深圳宝安区人民医院', '2', '恢复期', '036', '7722', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('262', '2', '深圳宝安区人民医院', '2', '恢复期', '037', '3281', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('263', '2', '深圳宝安区人民医院', '2', '恢复期', '038', '8436', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('264', '2', '深圳宝安区人民医院', '2', '恢复期', '039', '9074', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('265', '2', '深圳宝安区人民医院', '2', '恢复期', '040', '8056', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('266', '2', '深圳宝安区人民医院', '2', '恢复期', '041', '4156', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('267', '2', '深圳宝安区人民医院', '2', '恢复期', '042', '5695', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('268', '2', '深圳宝安区人民医院', '2', '恢复期', '043', '6288', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('269', '2', '深圳宝安区人民医院', '2', '恢复期', '044', '2549', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('270', '2', '深圳宝安区人民医院', '2', '恢复期', '045', '1683', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('271', '3', '北京西苑医院', '1', '痉挛期', '001', '9119', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('272', '3', '北京西苑医院', '1', '痉挛期', '002', '7528', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('273', '3', '北京西苑医院', '1', '痉挛期', '003', '6464', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('274', '3', '北京西苑医院', '1', '痉挛期', '004', '3853', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('275', '3', '北京西苑医院', '1', '痉挛期', '005', '2002', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('276', '3', '北京西苑医院', '1', '痉挛期', '006', '7417', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('277', '3', '北京西苑医院', '1', '痉挛期', '007', '7704', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('278', '3', '北京西苑医院', '1', '痉挛期', '008', '7467', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('279', '3', '北京西苑医院', '1', '痉挛期', '009', '8308', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('280', '3', '北京西苑医院', '1', '痉挛期', '010', '3157', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('281', '3', '北京西苑医院', '1', '痉挛期', '011', '9238', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('282', '3', '北京西苑医院', '1', '痉挛期', '012', '9336', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('283', '3', '北京西苑医院', '1', '痉挛期', '013', '5820', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('284', '3', '北京西苑医院', '1', '痉挛期', '014', '8245', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('285', '3', '北京西苑医院', '1', '痉挛期', '015', '4323', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('286', '3', '北京西苑医院', '1', '痉挛期', '016', '1962', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('287', '3', '北京西苑医院', '1', '痉挛期', '017', '6353', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('288', '3', '北京西苑医院', '1', '痉挛期', '018', '9245', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('289', '3', '北京西苑医院', '1', '痉挛期', '019', '8808', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('290', '3', '北京西苑医院', '1', '痉挛期', '020', '4179', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('291', '3', '北京西苑医院', '1', '痉挛期', '021', '3097', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('292', '3', '北京西苑医院', '1', '痉挛期', '022', '6784', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('293', '3', '北京西苑医院', '1', '痉挛期', '023', '1778', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('294', '3', '北京西苑医院', '1', '痉挛期', '024', '3586', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('295', '3', '北京西苑医院', '1', '痉挛期', '025', '8415', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('296', '3', '北京西苑医院', '1', '痉挛期', '026', '3982', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('297', '3', '北京西苑医院', '1', '痉挛期', '027', '5718', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('298', '3', '北京西苑医院', '1', '痉挛期', '028', '4571', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('299', '3', '北京西苑医院', '1', '痉挛期', '029', '7762', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('300', '3', '北京西苑医院', '1', '痉挛期', '030', '4051', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('301', '3', '北京西苑医院', '1', '痉挛期', '031', '1609', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('302', '3', '北京西苑医院', '1', '痉挛期', '032', '3600', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('303', '3', '北京西苑医院', '1', '痉挛期', '033', '1387', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('304', '3', '北京西苑医院', '1', '痉挛期', '034', '5000', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('305', '3', '北京西苑医院', '1', '痉挛期', '035', '6990', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('306', '3', '北京西苑医院', '1', '痉挛期', '036', '7247', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('307', '3', '北京西苑医院', '1', '痉挛期', '037', '2391', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('308', '3', '北京西苑医院', '1', '痉挛期', '038', '6375', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('309', '3', '北京西苑医院', '1', '痉挛期', '039', '2832', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('310', '3', '北京西苑医院', '1', '痉挛期', '040', '7201', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('311', '3', '北京西苑医院', '1', '痉挛期', '041', '7120', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('312', '3', '北京西苑医院', '1', '痉挛期', '042', '1890', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('313', '3', '北京西苑医院', '1', '痉挛期', '043', '5589', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('314', '3', '北京西苑医院', '1', '痉挛期', '044', '7155', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('315', '3', '北京西苑医院', '1', '痉挛期', '045', '6452', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('316', '3', '北京西苑医院', '1', '痉挛期', '046', '1555', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('317', '3', '北京西苑医院', '1', '痉挛期', '047', '3698', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('318', '3', '北京西苑医院', '1', '痉挛期', '048', '2824', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('319', '3', '北京西苑医院', '1', '痉挛期', '049', '7244', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('320', '3', '北京西苑医院', '1', '痉挛期', '050', '8114', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('321', '3', '北京西苑医院', '1', '痉挛期', '051', '2063', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('322', '3', '北京西苑医院', '1', '痉挛期', '052', '8646', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('323', '3', '北京西苑医院', '1', '痉挛期', '053', '4050', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('324', '3', '北京西苑医院', '1', '痉挛期', '054', '1906', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('325', '3', '北京西苑医院', '1', '痉挛期', '055', '5158', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('326', '3', '北京西苑医院', '1', '痉挛期', '056', '7580', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('327', '3', '北京西苑医院', '1', '痉挛期', '057', '3803', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('328', '3', '北京西苑医院', '1', '痉挛期', '058', '4828', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('329', '3', '北京西苑医院', '1', '痉挛期', '059', '3185', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('330', '3', '北京西苑医院', '1', '痉挛期', '060', '1629', '牵伸训练', null, null, null);
INSERT INTO `number` VALUES ('331', '3', '北京西苑医院', '2', '恢复期', '001', '6088', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('332', '3', '北京西苑医院', '2', '恢复期', '002', '1827', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('333', '3', '北京西苑医院', '2', '恢复期', '003', '9181', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('334', '3', '北京西苑医院', '2', '恢复期', '004', '4136', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('335', '3', '北京西苑医院', '2', '恢复期', '005', '5530', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('336', '3', '北京西苑医院', '2', '恢复期', '006', '3802', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('337', '3', '北京西苑医院', '2', '恢复期', '007', '5330', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('338', '3', '北京西苑医院', '2', '恢复期', '008', '5386', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('339', '3', '北京西苑医院', '2', '恢复期', '009', '7410', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('340', '3', '北京西苑医院', '2', '恢复期', '010', '1950', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('341', '3', '北京西苑医院', '2', '恢复期', '011', '8493', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('342', '3', '北京西苑医院', '2', '恢复期', '012', '6918', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('343', '3', '北京西苑医院', '2', '恢复期', '013', '8146', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('344', '3', '北京西苑医院', '2', '恢复期', '014', '6091', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('345', '3', '北京西苑医院', '2', '恢复期', '015', '8780', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('346', '3', '北京西苑医院', '2', '恢复期', '016', '4751', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('347', '3', '北京西苑医院', '2', '恢复期', '017', '7505', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('348', '3', '北京西苑医院', '2', '恢复期', '018', '3068', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('349', '3', '北京西苑医院', '2', '恢复期', '019', '2768', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('350', '3', '北京西苑医院', '2', '恢复期', '020', '9189', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('351', '3', '北京西苑医院', '2', '恢复期', '021', '4066', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('352', '3', '北京西苑医院', '2', '恢复期', '022', '9305', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('353', '3', '北京西苑医院', '2', '恢复期', '023', '5160', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('354', '3', '北京西苑医院', '2', '恢复期', '024', '3732', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('355', '3', '北京西苑医院', '2', '恢复期', '025', '2390', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('356', '3', '北京西苑医院', '2', '恢复期', '026', '5204', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('357', '3', '北京西苑医院', '2', '恢复期', '027', '3794', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('358', '3', '北京西苑医院', '2', '恢复期', '028', '6108', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('359', '3', '北京西苑医院', '2', '恢复期', '029', '7178', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('360', '3', '北京西苑医院', '2', '恢复期', '030', '8478', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('361', '3', '北京西苑医院', '2', '恢复期', '031', '4134', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('362', '3', '北京西苑医院', '2', '恢复期', '032', '2875', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('363', '3', '北京西苑医院', '2', '恢复期', '033', '2680', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('364', '3', '北京西苑医院', '2', '恢复期', '034', '7976', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('365', '3', '北京西苑医院', '2', '恢复期', '035', '9313', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('366', '3', '北京西苑医院', '2', '恢复期', '036', '1848', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('367', '3', '北京西苑医院', '2', '恢复期', '037', '4782', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('368', '3', '北京西苑医院', '2', '恢复期', '038', '8341', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('369', '3', '北京西苑医院', '2', '恢复期', '039', '7180', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('370', '3', '北京西苑医院', '2', '恢复期', '040', '2990', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('371', '3', '北京西苑医院', '2', '恢复期', '041', '8171', '太极拳2', null, null, null);
INSERT INTO `number` VALUES ('372', '3', '北京西苑医院', '2', '恢复期', '042', '2284', '运动学习', null, null, null);
INSERT INTO `number` VALUES ('373', '3', '北京西苑医院', '2', '恢复期', '043', '6753', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('374', '3', '北京西苑医院', '2', '恢复期', '044', '5414', '太极拳1', null, null, null);
INSERT INTO `number` VALUES ('375', '3', '北京西苑医院', '2', '恢复期', '045', '9340', '太极拳2', null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `center_id` int(11) DEFAULT NULL,
  `center` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', '1', '黑龙江中医大二院');
INSERT INTO `user` VALUES ('2', 'shenzhen', '123456', '2', '深圳宝安区人民医院');
INSERT INTO `user` VALUES ('3', 'beijing', '123456', '3', '北京西苑医院');
