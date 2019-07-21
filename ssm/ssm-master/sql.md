/*
Navicat MySQL Data Transfer

Source Server         : ssmfuwuqi
Source Server Version : 50527
Source Host           : 47.98.51.132:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-07-20 22:27:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appraise_info
-- ----------------------------
DROP TABLE IF EXISTS `appraise_info`;
CREATE TABLE `appraise_info` (
  `ID` int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ORDER_ID` int(5) NOT NULL COMMENT '编号，和订单表的订单编号关联',
  `USER_NAME` varchar(20) NOT NULL COMMENT '用户姓名',
  `USER_MOBILE` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `START_ORDER_TIME` datetime DEFAULT NULL COMMENT '下单时间',
  `APPRAISE_TIME` datetime DEFAULT NULL COMMENT '评价时间',
  `APPRAISE_CONTENT` varchar(500) DEFAULT NULL COMMENT '评级内容',
  `APPRAISE_IMG` varchar(1000) DEFAULT NULL COMMENT '图片',
  `GRADE` double(5,2) DEFAULT NULL COMMENT '评分',
  `Enable_SHOW` int(1) DEFAULT '0' COMMENT '是否展示 1是0否',
  `APPRAISE_REPLY` int(1) DEFAULT '0' COMMENT '是否回复 1是0否',
  `REPLY_CONTENT` varchar(500) DEFAULT NULL COMMENT '回复内容',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '新增时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='订单评价信息表';

-- ----------------------------
-- Table structure for commission_set
-- ----------------------------
DROP TABLE IF EXISTS `commission_set`;
CREATE TABLE `commission_set` (
  `ID` int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `MIN_PRICE` double(10,2) DEFAULT NULL COMMENT '最小订单金额',
  `MAX_PRICE` double(10,2) DEFAULT NULL COMMENT '最大订单金额',
  `COM_PER` varchar(10) DEFAULT NULL COMMENT '佣金比例',
  `ENABLE` int(1) DEFAULT '0' COMMENT '是否启用 1是 0否',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '新增时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='佣金设置表';

-- ----------------------------
-- Table structure for distributor_info
-- ----------------------------
DROP TABLE IF EXISTS `distributor_info`;
CREATE TABLE `distributor_info` (
  `ID` int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `DIS_ID` int(5) NOT NULL COMMENT '人员编号',
  `DIS_NAME` varchar(20) DEFAULT NULL COMMENT '商户姓名',
  `DIS_ MOBILE` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `DIS_ ADDR` varchar(100) DEFAULT NULL COMMENT '联系地址',
  `ORDER_NUM` int(5) DEFAULT NULL COMMENT '订单数量',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '新增时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `REFERRER` varchar(20) DEFAULT NULL COMMENT '推荐人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分销商信息表';

-- ----------------------------
-- Table structure for employee_info
-- ----------------------------
DROP TABLE IF EXISTS `employee_info`;
CREATE TABLE `employee_info` (
  `ID` int(5) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `EMP_ID` int(5) NOT NULL COMMENT '员工编码',
  `JOB_TITLE` varchar(20) DEFAULT NULL COMMENT '职位名称',
  `EMP_SEX` int(1) DEFAULT NULL COMMENT '员工性别 1男 2女 0 未知',
  `EMP_IDCARD` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `EMP_MOBILE` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `EMP_ADDR` varchar(50) DEFAULT NULL COMMENT '联系地址',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '新增时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工信息表';

-- ----------------------------
-- Table structure for item_classify
-- ----------------------------
DROP TABLE IF EXISTS `item_classify`;
CREATE TABLE `item_classify` (
  `ID` int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `CLASSIFY_ID` int(5) NOT NULL COMMENT '类目编号',
  `CLASSIFY_NAME` varchar(20) DEFAULT NULL COMMENT '类目名称',
  `CLASSIFY_IMG` varchar(1000) DEFAULT NULL COMMENT '展示图片',
  `ENABLE` int(1) NOT NULL DEFAULT '0' COMMENT '是否启用 1是 0否',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='项目分类表';

-- ----------------------------
-- Table structure for item_info
-- ----------------------------
DROP TABLE IF EXISTS `item_info`;
CREATE TABLE `item_info` (
  `ID` int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ITEM_ID` int(5) NOT NULL COMMENT '项目编号',
  `ITEM_NAME` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `CLASSIFY_ID` int(5) NOT NULL COMMENT '所属类目ID',
  `CLASSIFY_NAME` varchar(20) DEFAULT NULL COMMENT '所属类目名称',
  `ITEM_PRICE` double(10,2) DEFAULT NULL COMMENT '项目价格',
  `GOODS_TEXTURE` varchar(10) DEFAULT NULL COMMENT '材质',
  `SEASON` int(1) DEFAULT NULL COMMENT '季节1春秋 2 夏 3 冬',
  `WASH_METHOD` varchar(20) DEFAULT NULL COMMENT '洗涤方式',
  `ITEM_IMG` varchar(1000) DEFAULT NULL COMMENT '展示图片',
  `JOIN_ACTIVITIES` int(1) NOT NULL DEFAULT '0' COMMENT '参加活动 0 不参加 1参加',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='项目信息表';

-- ----------------------------
-- Table structure for message_template
-- ----------------------------
DROP TABLE IF EXISTS `message_template`;
CREATE TABLE `message_template` (
  `ID` int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `MESSAGE_CONTENT` varchar(100) DEFAULT NULL COMMENT '消息内容',
  `ENABLE` int(1) DEFAULT '0' COMMENT '是否启用 1是 0否',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息模板表';

-- ----------------------------
-- Table structure for module_func
-- ----------------------------
DROP TABLE IF EXISTS `module_func`;
CREATE TABLE `module_func` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `MODULE_ID` int(5) NOT NULL COMMENT '模块id',
  `MODULE_NAME` varchar(20) DEFAULT NULL COMMENT '模块名称',
  `PARENT_ID` int(5) DEFAULT NULL COMMENT '父级目录ID',
  `ISBUTTON` int(1) DEFAULT NULL COMMENT '是否按钮 1是0否',
  `FUNCID` int(5) DEFAULT NULL COMMENT '菜单调入id(给前端用)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单配置表 ';

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `ID` int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ORDER_ID` int(5) NOT NULL COMMENT '订单编号;和订单信息表的订单编号关联',
  `GOODS_ID` int(5) NOT NULL COMMENT '商品编号',
  `GOODS_NAME` varchar(20) NOT NULL COMMENT '商品名称',
  `GOODS_PRICE` double(20,2) DEFAULT NULL COMMENT '商品单价',
  `GOODS_NUM` int(5) DEFAULT NULL COMMENT '商品数量',
  `TOTAL_PRICE` double(10,2) DEFAULT NULL COMMENT '合计价格',
  `GOODS_TEXTURE` varchar(20) DEFAULT NULL COMMENT '商品材质',
  `GOODS_TYPE` varchar(5) DEFAULT NULL COMMENT '商品类别',
  `WASH_METHOD` varchar(10) DEFAULT NULL COMMENT '洗涤方式',
  `GOODS_STATE` int(1) DEFAULT NULL COMMENT '商品状态：1.待清洗；2洗涤中；3晾干/烘干中；4整理中；5，清洗完毕',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `ID` int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ORDER_ID` int(5) NOT NULL COMMENT '订单编号',
  `ORDER_STATE` int(1) NOT NULL COMMENT '订单状态  1待付款；2待取货；3带分拣；4清洗中；5待收货；6待评价；7已完成',
  `GOODS_NUM` int(5) DEFAULT NULL COMMENT '商品数量',
  `ORDER_MONERY` double(20,2) DEFAULT NULL COMMENT '订单金额',
  `START_ORDER_TIME` datetime DEFAULT NULL COMMENT '下单时间',
  `PAY_WAY` varchar(10) DEFAULT NULL COMMENT '支付方式',
  `USER_ID` int(5) NOT NULL COMMENT '用户编码；和用户信息表的用户编码关联',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `USER_ADDR` varchar(100) DEFAULT NULL COMMENT '常用地址',
  `TAKE_PERSON_ID` int(5) DEFAULT NULL COMMENT '取件人编码',
  `TAKE_PERSON_NAME` varchar(20) DEFAULT NULL COMMENT '取件人姓名',
  `TAKE_TIME` datetime DEFAULT NULL COMMENT '取件时间',
  `SORT_TIME` datetime DEFAULT NULL COMMENT '分拣时间',
  `CLEAN_TIME` datetime DEFAULT NULL COMMENT '清洗时间',
  `DELIVERY_TIME` datetime DEFAULT NULL COMMENT '送货时间',
  `GET_GOODS_TIME` datetime DEFAULT NULL COMMENT '收货时间',
  `COMMISSION` varchar(20) DEFAULT NULL COMMENT '佣金',
  `REMARKS` varchar(100) DEFAULT NULL COMMENT '订单备注',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `ID` int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ROLE_ID` int(5) NOT NULL COMMENT 'ROLE_ID',
  `ROLE_NAME` varchar(20) NOT NULL COMMENT '角色名称',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建日期',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `REMARKS` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色维护表';

-- ----------------------------
-- Table structure for shopcart_info
-- ----------------------------
DROP TABLE IF EXISTS `shopcart_info`;
CREATE TABLE `shopcart_info` (
  `ID` int(5) NOT NULL COMMENT '主键id',
  `USER_ID` int(5) DEFAULT NULL COMMENT '用户id',
  `ITEM_ID` int(5) DEFAULT NULL COMMENT '项目编号。和项目表关联',
  `NUM` int(5) DEFAULT NULL COMMENT '数量',
  `STATE` int(1) DEFAULT '0' COMMENT '购物车商品状态 0 未支付 1已支付',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '新增时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车信息表';

-- ----------------------------
-- Table structure for system_info
-- ----------------------------
DROP TABLE IF EXISTS `system_info`;
CREATE TABLE `system_info` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `SYS_ID` int(5) DEFAULT NULL COMMENT '系统用户编号',
  `SYS_USER_NAME` varchar(20) DEFAULT NULL COMMENT '用户名称',
  `SYS_USER_PASSWORD` varchar(255) DEFAULT '123456' COMMENT '密码',
  `ROLE_ID` int(5) DEFAULT NULL COMMENT '角色编码 关联角色表',
  `SYS_NAME` varchar(20) DEFAULT NULL COMMENT '账号名称',
  `SYS_USER_MOBILE` varchar(20) DEFAULT NULL COMMENT '用户手机号',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '注册时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `REMARKS` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户维护表';

-- ----------------------------
-- Table structure for user_addr
-- ----------------------------
DROP TABLE IF EXISTS `user_addr`;
CREATE TABLE `user_addr` (
  `ID` int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USER_ID` int(5) NOT NULL COMMENT '用户编码,关联用户表',
  `PROVINCE_CODE` varchar(10) DEFAULT NULL COMMENT '省级编码',
  `CITY_CODE` varchar(10) DEFAULT NULL COMMENT '市级编码',
  `AREA_CODE` varchar(10) DEFAULT NULL COMMENT '区域编码',
  `STREET_ADDR` varchar(20) DEFAULT NULL COMMENT '街道信息',
  `DETAIL_ADDR` varchar(50) DEFAULT NULL COMMENT '详细地址',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '注册时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户地址表';

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(5) NOT NULL COMMENT '用户编码',
  `USER_NAME` varchar(20) NOT NULL COMMENT '用户昵称',
  `WECAHT_ID` varchar(20) DEFAULT NULL COMMENT '微信id',
  `USER_SEX` int(1) DEFAULT NULL COMMENT '用户性别 1男 2女 0 未知',
  `USER_ MOBILE` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `USER_AREA` varchar(20) DEFAULT NULL COMMENT '地区（登入时获取）',
  `USER_ADDR` varchar(100) DEFAULT NULL COMMENT '常用地址',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '新增时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `USER_ACCOUNT` varchar(20) DEFAULT '0' COMMENT '账户余额',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account_change
-- ----------------------------
DROP TABLE IF EXISTS `account_change`;
CREATE TABLE `account_change` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(30) DEFAULT NULL COMMENT '用户姓名',
  `recharge_money` double DEFAULT NULL COMMENT '充值金额',
  `expense_money` double DEFAULT NULL COMMENT '消费金额',
  `given_money` double DEFAULT NULL COMMENT '赠送金额',
  `rest_money` double DEFAULT NULL COMMENT '账户余额',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户资金变动表';


ALTER TABLE `appraise_info`
MODIFY COLUMN `USER_NAME`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '用户姓名' AFTER `ORDER_ID`,
ADD COLUMN `USER_ID`  int NOT NULL COMMENT '用户ID' AFTER `ORDER_ID`;


ALTER TABLE `user_info`
MODIFY COLUMN `ID`  int NOT NULL AUTO_INCREMENT FIRST ,
MODIFY COLUMN `USER_ID`  int NOT NULL COMMENT '用户编码' AFTER `ID`,
MODIFY COLUMN `USER_ACCOUNT`  double(20,0) NULL DEFAULT 0 COMMENT '账户余额' AFTER `UPDATE_TIME`;

ALTER TABLE `user_info`
MODIFY COLUMN `ID`  int(10) NOT NULL AUTO_INCREMENT FIRST ,
MODIFY COLUMN `USER_ID`  int(10) NOT NULL COMMENT '用户编码' AFTER `ID`,
MODIFY COLUMN `USER_ACCOUNT`  double(20,0) NULL DEFAULT 0 COMMENT '账户余额' AFTER `UPDATE_TIME`;