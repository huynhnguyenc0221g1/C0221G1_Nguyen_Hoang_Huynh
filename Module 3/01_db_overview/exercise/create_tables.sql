CREATE database if not EXISTS `student-management`;
CREATE TABLE if not EXISTS `student-management`.`student` (
`id` INT AUTO_INCREMENT,
`name` varchar(45),
`age` int,
`country` varchar(45),
primary key (`id`));
CREATE TABLE if not EXISTS `student-management`.`class` (
`id` INT AUTO_INCREMENT,
`name` varchar(45) null,
primary key (`id`));
CREATE TABLE if not EXISTS `student-management`.`teacher` (
`id` INT AUTO_INCREMENT,
`name` varchar(45) null,
`age` int null,
`country` varchar(45) null,
primary key (`id`));
INSERT INTO `student-management`.`student` (`name`,`age`,`country`)
VALUES
("Huynh",25,"Vietnam"),
("Charles",38,"USA"),
("Trang",23,"Vietnam");
SELECT * FROM `student-management`.`student`;
SELECT DISTINCT `country` FROM `student-management`.`student`;
INSERT INTO `student-management`.`class` (`name`)
VALUES 
("CO221G1"),
("C0321G1"),
("C0421G1");
SELECT * FROM `student-management`.`class`;
INSERT INTO `student-management`.`teacher` (`name`,`age`,`country`)
VALUES
("Tin",30,"Vietnam"),
("John",27,"UK"),
("Alberto",35,"Mexico");
DELETE FROM `student-management`.`teacher` where `id`>2;
SELECT * FROM `student-management`.`teacher`;