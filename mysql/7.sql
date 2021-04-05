-- 用户信息表
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_name` varchar(128) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(128) NOT NULL DEFAULT '' COMMENT '密码',
  `email` varchar(128) NOT NULL DEFAULT '' COMMENT '电子邮箱',
  `phone` varchar(128) NOT NULL DEFAULT '' COMMENT '手机号码',
  `gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别',
  `age` tinyint(4) NOT NULL DEFAULT '0' COMMENT '年龄',
  `id_card` varchar(128) NOT NULL DEFAULT '' COMMENT '身份证号码',
  `intro` varchar(1024) NOT NULL DEFAULT '' COMMENT '个人信息',
  `user_company` varchar(50) NOT NULL DEFAULT '' COMMENT '用户公司',
  `user_department` varchar(45) NOT NULL DEFAULT '' COMMENT '用户部门',
  `user_duty` varchar(100) NOT NULL DEFAULT '' COMMENT '用户具体职责',
  `user_industry` varchar(100) NOT NULL DEFAULT '' COMMENT '用户所处行业',
  `user_status` int(10) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-------- 切分成两张表
-- 用户基本信息表
CREATE TABLE `user_base` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_name` varchar(128) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(128) NOT NULL DEFAULT '' COMMENT '密码',
  `email` varchar(128) NOT NULL DEFAULT '' COMMENT '电子邮箱',
  `phone` varchar(128) NOT NULL DEFAULT '' COMMENT '手机号码',
  `gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别',
  `age` tinyint(4) NOT NULL DEFAULT '0' COMMENT '年龄',
  `user_status` int(10) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';
 
-- 用户附加信息表
CREATE TABLE `user_extra` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `id_card` varchar(128) NOT NULL DEFAULT '' COMMENT '身份证号码',
  `intro` varchar(1024) NOT NULL DEFAULT '' COMMENT '个人信息',
  `user_company` varchar(50) NOT NULL DEFAULT '' COMMENT '用户公司',
  `user_department` varchar(45) NOT NULL DEFAULT '' COMMENT '用户部门',
  `user_industry` varchar(100) NOT NULL DEFAULT '' COMMENT '用户所处行业',
  `user_duty` varchar(100) NOT NULL DEFAULT '' COMMENT '用户具体职责',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户附加信息表';


