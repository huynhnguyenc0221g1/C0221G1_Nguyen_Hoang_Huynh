CREATE SCHEMA `student-management`;
CREATE TABLE `student-management`.`student` (
`id` INT NOT NULL,
`name` varchar(45) null,
`age` int null,
`country` varchar(45) null,
primary key (`id`));