-- 不要使用 NULL 字段
CREATE TABLE `imooc_mysql_escape`.`do_not_use_null` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `one` varchar(10) NOT NULL,
    `two` varchar(20) DEFAULT NULL,
    `three` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_one` (`one`),
    KEY `idx_two` (`two`),
    UNIQUE KEY `idx_three` (`three`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 初始化一些数据
INSERT INTO `imooc_mysql_escape`.`do_not_use_null`(`id`, `one`, `two`, `three`) VALUES (1, '', 'a2', 'a3');
INSERT INTO `imooc_mysql_escape`.`do_not_use_null`(`id`, `one`, `two`, `three`) VALUES (2, 'b1', NULL, 'b3');
INSERT INTO `imooc_mysql_escape`.`do_not_use_null`(`id`, `one`, `two`, `three`) VALUES (3, 'c1', 'c2', NULL);
INSERT INTO `imooc_mysql_escape`.`do_not_use_null`(`id`, `one`, `two`, `three`) VALUES (4, 'd1', 'd2', NULL);
