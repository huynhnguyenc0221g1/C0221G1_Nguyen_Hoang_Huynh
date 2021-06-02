CREATE DATABASE `user_management`;
USE `user_management`;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

create table permision(

id int(11) primary key,

name varchar(50)

);

create table user_permision(
user_id int(11),
permision_id int(11)
);

insert into Permision(id, name) values(1, 'add');

insert into Permision(id, name) values(2, 'edit');

insert into Permision(id, name) values(3, 'delete');

insert into Permision(id, name) values(4, 'view');

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

