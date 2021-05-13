CREATE database if not exists `furama_resort`;
USE `furama_resort`;
-- Table Nhân Viên | Employee Table
create table if not exists position (
`position_id` int not null,
`position_name` varchar(45),
primary key (`position_id`));
insert into position
values (1,"duty manager");
select * from position;


create table if not exists qualification (
`qualification_id` int not null,
`qualification_name` varchar(45),
primary key (`qualification_id`));
insert into qualification
values (1,"bachelor degree");
select * from qualification;

create table if not exists department (
`department_id` int not null,
`department_name` varchar(45),
primary key (`department_id`));
insert into department
values (1,"front office");
select * from department;

create table if not exists employee (
`employee_id` int not null,
`employee_name` varchar(45),
`position_id` int not null,
FOREIGN KEY (`position_id`) REFERENCES position (`position_id`),
`qualification_id` int not null,
FOREIGN KEY (`qualification_id`) REFERENCES qualification (`qualification_id`),
`department_id` int not null,
FOREIGN KEY (`department_id`) REFERENCES department (`department_id`),
`employee_birthdate` date,
`employee_id_number` varchar(45),
`employee_salary` varchar(45),
`employee_phone_number` varchar(45),
`employee_email` varchar(45),
`employee_address` varchar(45),
primary key (`employee_id`));
insert into employee
values (1,"Hoang",1,1,1,"1990-10-20","107882","400","0126 123 123","hoang@furama.com","40 Ngo Quyen street");
select * from employee;

-- Table Khách Hàng | Customer Table
create table if not exists customer_type (
`customer_type_id` int not null,
`customer_type_name` varchar(45),
primary key (`customer_type_id`));
insert into customer_type
values (1,"Standard");
select * from customer_type;

create table if not exists customer (
`customer_id` int not null,
`customer_type_id` int not null,
foreign key (`customer_type_id`) references customer_type (`customer_type_id`),
`customer_fullname` varchar(45),
`customer_birthdate` date,
`customer_id_number` varchar(45),
`customer_phone_number` varchar(45),
`customer_email` varchar(45),
`customer_address` varchar(45),
primary key (`customer_id`));
insert into customer
values (1,1,"Nguyen Van A","1984-02-21","2012332","0934 125 741","vana@hotmail.com","57 Nguyen Trung Truc street");
select * from customer;

-- Table Dịch Vụ | Service Table
create table if not exists rent_option (
`rent_option_id` int not null,
`rent_option_name` varchar(45),
`rent_price` int,
primary key (`rent_option_id`));
insert into rent_option
values (1,"Day",500);
select * from rent_option;

create table if not exists service_type (
`service_type_id` int not null,
`service_type_name` varchar(45),
primary key (`service_type_id`));
insert into service_type
values (1,"Standard");
select * from service_type;

create table if not exists service (
`service_id` int not null,
`service_name` varchar(45),
`service_area` int,
`service_number_of_floor` int,
`service_max_inhouse` varchar(45),
`serice_rent_price` varchar(45),
`rent_option_id` int,
foreign key (`rent_option_id`) references rent_option (`rent_option_id`),
`service_type_id` int not null,
foreign key (`service_type_id`) references service_type (`service_type_id`),
`service_status` varchar(45),
primary key (`service_id`));
insert into service
values (1,"Villa",300,2,"8","500",1,1,"available");
select * from service;

-- Table Hợp đồng | Contract Table
create table if not exists additional_service (
`additional_service_id` int not null,
`additional_service_name` varchar(45),
`additional_service_price` int,
`additional_service_unit` int,
`additional_service_availability_status` varchar(45),
primary key (`additional_service_id`));
insert into additional_service
values (1,"Drink",50,1,"available");
select * from additional_service;

create table if not exists contract (
`contract_id` int not null,
`employee_id` int not null,
foreign key (`employee_id`) references employee (`employee_id`),
`customer_id` int not null,
foreign key (`customer_id`) references customer (`customer_id`),
`service_id` int not null,
foreign key (`service_id`) references service (`service_id`),
`contract_made_date` date,
`contract_end_date` date,
`contract_deposit` int,
`contract_total` int,
primary key (`contract_id`));
insert into contract
values (1,1,1,1,"2021-05-13","2021-05-14",250,550);
select * from contract;

create table if not exists contract_detail (
`contract_detail_id` int not null,
`contract_id` int not null,
foreign key (`contract_id`) references contract (`contract_id`),
`additional_service_id` int not null,
foreign key (`additional_service_id`) references additional_service (`additional_service_id`),
`contract_detail_amount` int,
primary key (`contract_id`));
insert into contract_detail
values (1,1,1,1);
select * from contract_detail;