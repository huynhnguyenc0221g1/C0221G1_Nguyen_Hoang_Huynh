CREATE DATABASE `user_management`;
USE `user_management`;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(`name`, email, country) 
values('Trung','trung@codegym.vn','Vietnam');

insert into users(`name`, email, country) 
values('David','david@friends.net','USA');

insert into users(`name`, email, country) 
values('Hugh','hugh@grant.co.uk','UK');

SELECT * FROM users
WHERE country = "Vietnam";

SELECT * FROM users
ORDER BY `name` ASC;

