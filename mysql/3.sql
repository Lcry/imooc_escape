-- 第一类
CREATE TABLE `imooc_mysql_escape`.`correct_use_index` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(32) NOT NULL,
    `age` int(11) NOT NULL,
    `phone`  varchar(64) NOT NULL,
    `email`  varchar(128) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_phone` (`phone`),
    KEY `idx_name_phone_email` (`name`, `phone`, `email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 查看表的索引
show index from correct_use_index;

-- 字符串类型查询没有使用引号(手机号码)
explain select * from correct_use_index where phone = 17012345678;
explain select * from correct_use_index where phone = '17012345678';

-- where 条件左边的字段参与了函数或者数学运算
explain select * from correct_use_index where concat(name, '-qinyi') = 'imooc-qinyi';
explain select * from correct_use_index where name = 'imooc';
-- 其他的例子
explain select * from correct_use_index where age - 10 > 0;

-- 联合索引的前缀使用问题(虽然优化器会重排 where 顺序, 但是, 查询条件最好还是按照定义的联合索引的顺序, 而不是每次顺序都不一样, 这样也会让查询缓存失效, 因为查询语句不一样了)
drop index idx_phone ON correct_use_index;
explain select * from correct_use_index where name = 'qinyi' and phone = '10086' and email = 'qinyi@imooc.com';
explain select * from correct_use_index where phone = '10086' and email = 'qinyi@imooc.com';

-- 第二类
CREATE TABLE `imooc_mysql_escape`.`correct_use_index_2` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `career` varchar(32) NOT NULL,
    `first_name`  varchar(16) NOT NULL,
    `last_name`  varchar(16) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `imooc_mysql_escape`.`correct_use_index_2`(`id`, `career`, `first_name`, `last_name`) VALUES (1, 'engineer', 'qinyi', 'abcdefg');
INSERT INTO `imooc_mysql_escape`.`correct_use_index_2`(`id`, `career`, `first_name`, `last_name`) VALUES (2, 'engineer', 'qinyi', 'abxyzbdf');
INSERT INTO `imooc_mysql_escape`.`correct_use_index_2`(`id`, `career`, `first_name`, `last_name`) VALUES (3, 'engineer', 'qinyi', 'aerefgdgfd');
INSERT INTO `imooc_mysql_escape`.`correct_use_index_2`(`id`, `career`, `first_name`, `last_name`) VALUES (4, 'engineer', 'qinyi', 'abpoijhyg');
INSERT INTO `imooc_mysql_escape`.`correct_use_index_2`(`id`, `career`, `first_name`, `last_name`) VALUES (5, 'engineer', 'qinyi', 'acqasdwqer');

-- 索引选择性(没有必要为索引选择性较低的列创建索引)
select count(distinct(career))/count(*) from correct_use_index_2;

-- 想要通过 name 去查询记录, 可以考虑创建 first_name 索引, 或 first_name、last_name 联合索引 --> 看一看索引选择性
select * from correct_use_index_2 where first_name = '' and last_name = '';

select count(distinct(first_name))/count(*) from correct_use_index_2;

-- first_name, last_name 创建联合索引占据的空间会过大, 需要考虑兼顾长度和选择性
select count(distinct(concat(first_name, last_name)))/count(*) from correct_use_index_2;
select count(distinct(concat(first_name, left(last_name, 1))))/count(*) from correct_use_index_2;
select count(distinct(concat(first_name, left(last_name, 2))))/count(*) from correct_use_index_2;
select count(distinct(concat(first_name, left(last_name, 3))))/count(*) from correct_use_index_2;

ALTER TABLE correct_use_index_2 ADD INDEX `idx_first_last_name_3` (first_name, last_name(3));
show index from correct_use_index_2;
