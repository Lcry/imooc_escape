CREATE TABLE `imooc_mysql_escape`.`suitable_data_type` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(32) NOT NULL,
    `gender` ENUM('male', 'female') NOT NULL,
    `grade` ENUM('0', '1', '2') NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入一条正确的数据(枚举值都是自己定义的)
INSERT INTO `imooc_mysql_escape`.`suitable_data_type`(`id`, `name`, `gender`, `grade`) VALUES (1, 'qinyi', 'male', '1');
-- 插入一条错误的数据, 会执行失败
INSERT INTO `imooc_mysql_escape`.`suitable_data_type`(`id`, `name`, `gender`, `grade`) VALUES (2, 'qinyi', 'male', '9');

-- 查看枚举值对应的索引
select name, gender + 0, grade from suitable_data_type;

-- 聚合函数
select sum(gender) from suitable_data_type;
select avg(gender) from suitable_data_type;

-- 枚举对排序的影响
INSERT INTO `imooc_mysql_escape`.`suitable_data_type`(`id`, `name`, `gender`, `grade`) VALUES (7, 'abc', 'female', '0');
select * from suitable_data_type order by gender;
select * from suitable_data_type order by cast(gender as char);
select * from suitable_data_type order by concat(gender);

-- 下面几条语句插入的数据是什么 ? (ENUM 字面量的处理)
INSERT INTO `imooc_mysql_escape`.`suitable_data_type`(`id`, `name`, `gender`, `grade`) VALUES (3, 'qinyi', 'male', 2);
INSERT INTO `imooc_mysql_escape`.`suitable_data_type`(`id`, `name`, `gender`, `grade`) VALUES (4, 'qinyi', 'male', '2');
INSERT INTO `imooc_mysql_escape`.`suitable_data_type`(`id`, `name`, `gender`, `grade`) VALUES (5, 'qinyi', 'male', '3');
INSERT INTO `imooc_mysql_escape`.`suitable_data_type`(`id`, `name`, `gender`, `grade`) VALUES (6, 'qinyi', 'male', '4');


