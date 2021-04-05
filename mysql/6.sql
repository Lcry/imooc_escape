-- auth_user
CREATE TABLE IF NOT EXISTS `imooc_mysql_escape`.`auth_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键 id',
  `create_user_id` varchar(64) NOT NULL DEFAULT '' COMMENT '创建当前 user 的 user',
  `user_id` varchar(64) NOT NULL DEFAULT '' COMMENT '用户 id',
  `login_username` varchar(64) NOT NULL DEFAULT '' COMMENT '登录用户名',
  `username` varchar(64) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `email` varchar(128) NOT NULL DEFAULT '' COMMENT '邮箱',
  `telephone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号码',
  `password` varchar(128) NOT NULL DEFAULT '' COMMENT '密码',
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色 id',
  `extra` varchar(512) NOT NULL DEFAULT '{}' COMMENT '额外信息',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
