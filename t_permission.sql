/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : projecttemp

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2017-07-26 17:37:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `res_code` varchar(7) NOT NULL COMMENT '权限编号【以001开头的七尾数】',
  `res_mame` varchar(64) NOT NULL COMMENT '权限名称【系统名_模块名(had)_页面(had)_按钮(had)】',
  `res_content` varchar(255) DEFAULT NULL COMMENT '权限内容【如果是目录，则是目录的attributes】',
  `res_status` char(1) NOT NULL DEFAULT '0' COMMENT '权限状态【0-正常 1-删除】',
  `res_type` char(1) NOT NULL COMMENT '权限级别【0-系统,1-模块,2-视图,3-按钮】',
  `res_parent` varchar(7) DEFAULT NULL COMMENT '父权限编号【以001开头的七尾数】',
  `create_user` varchar(50) DEFAULT NULL COMMENT '资料创建人员编号',
  `create_date` datetime DEFAULT NULL COMMENT '资料创建时间【YYYY-MM-DD HH:MM:SS】',
  `update_user` varchar(50) DEFAULT NULL COMMENT '最近修改人员编号',
  `update_date` datetime DEFAULT NULL COMMENT '最近修改时间【YYYY-MM-DD HH:MM:SS】',
  `res_description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `res_sequence` int(2) unsigned NOT NULL COMMENT '权限序号',
  `res_state` char(1) DEFAULT '' COMMENT '是否打开目录【easyui的目录树：0-open,1-close】',
  PRIMARY KEY (`res_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('0010001', 'testAdm', null, '0', '0', null, '0020001', '2017-07-24 15:13:10', null, null, '测试管理台', '0', '0');
INSERT INTO `t_permission` VALUES ('0010002', 'testAdm_userManage', null, '0', '1', '0010001', '0020001', '2017-07-24 15:15:10', null, null, '用户管理模块', '0', '1');
INSERT INTO `t_permission` VALUES ('0010003', 'testAdm_userManage_userManagePage', '{\"url\":\"/projectPermission/pageChange/userManagePage.do\"}', '0', '2', '0010002', '0020001', '2017-07-24 15:16:59', null, null, '用户管理', '0', '1');
INSERT INTO `t_permission` VALUES ('0010004', 'testAdm_userManage_userManagePage_queryUser', null, '0', '3', '0010003', '0020001', '2017-07-24 15:20:09', null, null, '查询用户信息', '0', '');
INSERT INTO `t_permission` VALUES ('0010005', 'testAdm_userManage_userManagePage_addUser', null, '0', '3', '0010003', '0020001', '2017-07-24 15:21:38', null, null, '添加用户信息', '0', '');
