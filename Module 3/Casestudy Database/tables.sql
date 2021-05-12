CREATE database if not exists `furama_resort`;
-- Table Nhân Viên | Employee Table
create table if not exists `furama_resort`.`position` (
`position_id` int not null,
`position_name` varchar(45),
primary key (`position_id`));

create table if not exists `furama_resort`.`qualification` (
`qualification_id` int not null,
`qualification_name` varchar(45),
primary key (`qualification_id`));

create table if not exists `furama_resort`.`department` (
`department_id` int not null,
`department_name` varchar(45),
primary key (`department_id`));

create table if not exists `furama_resort`.`employee` (
`employee_id` int not null,
`employee_name` varchar(45),
`position_id` int not null,
FOREIGN KEY (`position_id`) REFERENCES `furama_resort`.`position`(`position_id`),
`qualification_id` int not null,
FOREIGN KEY (`qualification_id`) REFERENCES `furama_resort`.`qualification`(`qualification_id`),
`department_id` int not null,
FOREIGN KEY (`department_id`) REFERENCES `furama_resort`.`department`(`department_id`),
`employee_birthdate` date,
`employee_id_number` varchar(45),
`employee_salary` varchar(45),
`employee_phone_number` varchar(45),
`employee_email` varchar(45),
`employee_address` varchar(45),
primary key (`employee_id`));

-- Table Khách Hàng | Customer Table
create table if not exists `furama_resort`.`customer_type` (
`customer_type_id` int not null,
`customer_type_name` varchar(45),
primary key (`customer_type_id`));

create table if not exists `furama_resort`.`customer` (
`customer_id` int not null,
`customer_type_id` int not null,
foreign key (`customer_type_id`) references `furama_resort`.`customer_type`(`customer_type_id`),
`customer_fullname` varchar(45),
`customer_birthdate` date,
`customer_id_number` varchar(45),
`customer_phone_number` varchar(45),
`customer_email` varchar(45),
`customer_address` varchar(45),
primary key (`customer_id`));

-- Table Dịch Vụ | Service Table
create table if not exists `furama_resort`.`rent_option` (
`rent_option_id` int not null,
`rent_option_name` varchar(45),
`rent_price` int,
primary key (`rent_option_id`));

create table if not exists `furama_resort`.`service_type` (
`service_type_id` int not null,
`service_type_name` varchar(45),
primary key (`service_type_id`));

create table if not exists `furama_resort`.`service` (
`service_id` int not null,
`service_name` varchar(45),
`service_area` int,
`service_number_of_floor` int,
`service_max_inhouse` varchar(45),
`serice_rent_price` varchar(45),
`rent_option_id` int,
foreign key (`rent_option_id`) references `furama_resort`.`rent_option`(`rent_option_id`),
`service_type_id` int not null,
foreign key (`service_type_id`) references `furama_resort`.`service_type`(`service_type_id`),
`service_status` varchar(45),
primary key (`service_id`));

-- Table Hợp đồng | Contract Table
create table if not exists `furama_resort`.`additional_service` (
`additional_service_id` int not null,
`additional_service_name` varchar(45),
`additional_service_price` int,
`additional_service_unit` int,
`additional_service_availability_status` varchar(45),
primary key (`additional_service_id`));

create table if not exists `furama_resort`.`contract` (
`contract_id` int not null,
`employee_id` int not null,
foreign key (`employee_id`) references `furama_resort`.`employee`(`employee_id`),
`customer_id` int not null,
foreign key (`customer_id`) references `furama_resort`.`customer`(`customer_id`),
`service_id` int not null,
foreign key (`service_id`) references `furama_resort`.`service`(`service_id`),
`contract_made_date` date,
`contract_end_date` date,
`contract_deposit` int,
`contract_total` int,
primary key (`contract_id`));

create table if not exists `furama_resort`.`contract_detail` (
`contract_detail_id` int not null,
`contract_id` int not null,
foreign key (`contract_id`) references `furama_resort`.`contract`(`contract_id`),
`additional_service_id` int not null,
foreign key (`additional_service_id`) references `furama_resort`.`additional_service`(`additional_service_id`),
`service_id` int not null,
`contract_detail_amount` int,
primary key (`contract_id`));
