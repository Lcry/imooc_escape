CREATE TABLE `imooc_mysql_escape`.`lock_error_use_in_transaction` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(32) NOT NULL,
    `age` int(11) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `imooc_mysql_escape`.`lock_error_use_in_transaction`(`id`, `name`, `age`) VALUES (1, 'imooc', 10);
INSERT INTO `imooc_mysql_escape`.`lock_error_use_in_transaction`(`id`, `name`, `age`) VALUES (2, 'qinyi', 19);
