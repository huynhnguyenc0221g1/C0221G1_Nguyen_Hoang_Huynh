-- Task 1
CREATE database if not exists `furama_resort`;
USE `furama_resort`;
-- Table Nhân Viên | Employee Table
create table if not exists position (
`position_id` int not null,
`position_name` varchar(45),
primary key (`position_id`));

INSERT INTO `furama_resort`.`position` (`position_id`, `position_name`) VALUES ('1', 'Receptionist');
INSERT INTO `furama_resort`.`position` (`position_id`, `position_name`) VALUES ('2', 'Server');
INSERT INTO `furama_resort`.`position` (`position_id`, `position_name`) VALUES ('3', 'Expert');
INSERT INTO `furama_resort`.`position` (`position_id`, `position_name`) VALUES ('4', 'Supervisor');
INSERT INTO `furama_resort`.`position` (`position_id`, `position_name`) VALUES ('5', 'Manager');
INSERT INTO `furama_resort`.`position` (`position_id`, `position_name`) VALUES ('6', 'General Manager');



create table if not exists qualification (
`qualification_id` int not null,
`qualification_name` varchar(45),
primary key (`qualification_id`));

INSERT INTO `furama_resort`.`qualification` (`qualification_id`, `qualification_name`) VALUES ('1', 'Intermediate');
INSERT INTO `furama_resort`.`qualification` (`qualification_id`, `qualification_name`) VALUES ('2', 'College');
INSERT INTO `furama_resort`.`qualification` (`qualification_id`, `qualification_name`) VALUES ('3', 'University');
INSERT INTO `furama_resort`.`qualification` (`qualification_id`, `qualification_name`) VALUES ('4', 'Higher Education');



create table if not exists department (
`department_id` int not null,
`department_name` varchar(45),
primary key (`department_id`));

INSERT INTO `furama_resort`.`department` (`department_id`, `department_name`) VALUES ('1', 'Sale - Marketing');
INSERT INTO `furama_resort`.`department` (`department_id`, `department_name`) VALUES ('2', 'Administration');
INSERT INTO `furama_resort`.`department` (`department_id`, `department_name`) VALUES ('3', 'Service');
INSERT INTO `furama_resort`.`department` (`department_id`, `department_name`) VALUES ('4', 'Management');




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

INSERT INTO `furama_resort`.`employee` (`employee_id`, `employee_name`, `position_id`, `qualification_id`, `department_id`, `employee_birthdate`, `employee_id_number`, `employee_salary`, `employee_phone_number`, `employee_email`, `employee_address`) VALUES ('1', 'Tam', '6', '4', '4', '1980-02-11', '201032123', '3000', '0123 232 111', 'tam@furama.com', 'Danang');
INSERT INTO `furama_resort`.`employee` (`employee_id`, `employee_name`, `position_id`, `qualification_id`, `department_id`, `employee_birthdate`, `employee_id_number`, `employee_salary`, `employee_phone_number`, `employee_email`, `employee_address`) VALUES ('2', 'Dung', '5', '4', '4', '1984-04-23', '200995821', '2500', '0934 122 333', 'dung@furama.com', 'Quang Nam');
INSERT INTO `furama_resort`.`employee` (`employee_id`, `employee_name`, `position_id`, `qualification_id`, `department_id`, `employee_birthdate`, `employee_id_number`, `employee_salary`, `employee_phone_number`, `employee_email`, `employee_address`) VALUES ('3', 'Khoa', '3', '3', '2', '1990-11-03', '201184921', '1000', '0122 231 212', 'khoa@furama.com', 'Quang Tri');
INSERT INTO `furama_resort`.`employee` (`employee_id`, `employee_name`, `position_id`, `qualification_id`, `department_id`, `employee_birthdate`, `employee_id_number`, `employee_salary`, `employee_phone_number`, `employee_email`, `employee_address`) VALUES ('4', 'Tuan', '4', '3', '4', '1985-08-21', '200387987', '1000', '0932 298 845', 'tuan@furama.com', 'Ho Chi Minh City');
INSERT INTO `furama_resort`.`employee` (`employee_id`, `employee_name`, `position_id`, `qualification_id`, `department_id`, `employee_birthdate`, `employee_id_number`, `employee_salary`, `employee_phone_number`, `employee_email`, `employee_address`) VALUES ('5', 'Van', '1', '3', '3', '1990-05-16', '201021399', '500', '0912 894 129', 'van@furama.com', 'Danang');
INSERT INTO `furama_resort`.`employee` (`employee_id`, `employee_name`, `position_id`, `qualification_id`, `department_id`, `employee_birthdate`, `employee_id_number`, `employee_salary`, `employee_phone_number`, `employee_email`, `employee_address`) VALUES ('6', 'Chuong', '1', '3', '3', '1988-12-23', '201123334', '500', '0882 832 932', 'chuong@furama.com', 'Hanoi');
INSERT INTO `furama_resort`.`employee` (`employee_id`, `employee_name`, `position_id`, `qualification_id`, `department_id`, `employee_birthdate`, `employee_id_number`, `employee_salary`, `employee_phone_number`, `employee_email`, `employee_address`) VALUES ('7', 'Vinh', '2', '1', '3', '1989-11-22', '203194190', '300', '0912 182 342', 'vinh@furama.com', 'Danang');
INSERT INTO `furama_resort`.`employee` (`employee_id`, `employee_name`, `position_id`, `qualification_id`, `department_id`, `employee_birthdate`, `employee_id_number`, `employee_salary`, `employee_phone_number`, `employee_email`, `employee_address`) VALUES ('8', 'Van', '2', '1', '3', '1984-04-14', '200410939', '300', '0325 892 128', 'van@furama.com', 'Quang Nam');


-- Table Khách Hàng | Customer Table
create table if not exists customer_type (
`customer_type_id` int not null,
`customer_type_name` varchar(45),
primary key (`customer_type_id`));

INSERT INTO `furama_resort`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('1', 'Diamond');
INSERT INTO `furama_resort`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('2', 'Platinum');
INSERT INTO `furama_resort`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('3', 'Gold');
INSERT INTO `furama_resort`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('4', 'Silver');
INSERT INTO `furama_resort`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('5', 'Member');



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

INSERT INTO `furama_resort`.`customer` (`customer_id`, `customer_type_id`, `customer_fullname`, `customer_birthdate`, `customer_id_number`, `customer_phone_number`, `customer_email`, `customer_address`) VALUES ('1', '1', 'Nguyen Trung Quan', '1978-12-13', '201381738', '0934 123 523', 'quan@gmail.com', 'Danang');
INSERT INTO `furama_resort`.`customer` (`customer_id`, `customer_type_id`, `customer_fullname`, `customer_birthdate`, `customer_id_number`, `customer_phone_number`, `customer_email`, `customer_address`) VALUES ('2', '2', 'Pham Phuong Dong', '1990-03-24', '493291923', '0123 832 832', 'dong@gmail.com', 'Quang Tri');
INSERT INTO `furama_resort`.`customer` (`customer_id`, `customer_type_id`, `customer_fullname`, `customer_birthdate`, `customer_id_number`, `customer_phone_number`, `customer_email`, `customer_address`) VALUES ('3', '3', 'Tran Thi Thuy', '1998-08-08', '121030300', '0138 747 429', 'thuy@gmail.com', 'Ha Noi');
INSERT INTO `furama_resort`.`customer` (`customer_id`, `customer_type_id`, `customer_fullname`, `customer_birthdate`, `customer_id_number`, `customer_phone_number`, `customer_email`, `customer_address`) VALUES ('4', '4', 'Phan Nhat Tan', '1994-04-30', '893477121', '0248 234 048', 'tan@gmail.com', 'Quang Ngai');
INSERT INTO `furama_resort`.`customer` (`customer_id`, `customer_type_id`, `customer_fullname`, `customer_birthdate`, `customer_id_number`, `customer_phone_number`, `customer_email`, `customer_address`) VALUES ('5', '5', 'Dang Le Thu', '1965-09-11', '716248172', '9320 382 719', 'thu@gmail.com', 'Quang Tri');
INSERT INTO `furama_resort`.`customer` (`customer_id`, `customer_type_id`, `customer_fullname`, `customer_birthdate`, `customer_id_number`, `customer_phone_number`, `customer_email`, `customer_address`) VALUES ('6', '1', 'Nguyen Thanh Dat', '1980-02-13', '716222172', '0248 234 009', 'dat@gmail.com', 'Ha Noi');
INSERT INTO `furama_resort`.`customer` (`customer_id`, `customer_type_id`, `customer_fullname`, `customer_birthdate`, `customer_id_number`, `customer_phone_number`, `customer_email`) VALUES ('7', '2', 'Pham Thu Hien', '1996-04-27', '213872138', '2039 812 182', 'hien@gmail.com');
UPDATE `furama_resort`.`customer` SET `customer_address` = 'Danang' WHERE (`customer_id` = '7');


-- Table Dịch Vụ | Service Table
create table if not exists rent_option (
`rent_option_id` int not null,
`rent_option_name` varchar(45),
`rent_price` int,
primary key (`rent_option_id`));

INSERT INTO `furama_resort`.`rent_option` (`rent_option_id`, `rent_option_name`, `rent_price`) VALUES ('1', 'Day', '200');
INSERT INTO `furama_resort`.`rent_option` (`rent_option_id`, `rent_option_name`, `rent_price`) VALUES ('2', 'Week', '1200');
INSERT INTO `furama_resort`.`rent_option` (`rent_option_id`, `rent_option_name`, `rent_price`) VALUES ('3', 'Month', '5800');



create table if not exists service_type (
`service_type_id` int not null,
`service_type_name` varchar(45),
primary key (`service_type_id`));

INSERT INTO `furama_resort`.`service_type` (`service_type_id`, `service_type_name`) VALUES ('1', 'Standard');
INSERT INTO `furama_resort`.`service_type` (`service_type_id`, `service_type_name`) VALUES ('2', 'Superior');
INSERT INTO `furama_resort`.`service_type` (`service_type_id`, `service_type_name`) VALUES ('3', 'Deluxe');


create table if not exists service (
`service_id` int not null,
`service_name` varchar(45),
`service_area` int,
`service_number_of_floor` int,
`service_max_inhouse` varchar(45),
`service_rent_price` varchar(45),
`rent_option_id` int,
foreign key (`rent_option_id`) references rent_option (`rent_option_id`),
`service_type_id` int not null,
foreign key (`service_type_id`) references service_type (`service_type_id`),
`service_status` varchar(45),
primary key (`service_id`));

INSERT INTO `furama_resort`.`service` (`service_id`, `service_name`, `service_area`, `service_number_of_floor`, `service_max_inhouse`, `service_rent_price`, `rent_option_id`, `service_type_id`, `service_status`) VALUES ('1', 'Villa', '300', '3', '8', '500', '1', '1', 'Available');
INSERT INTO `furama_resort`.`service` (`service_id`, `service_name`, `service_area`, `service_number_of_floor`, `service_max_inhouse`, `service_rent_price`, `rent_option_id`, `service_type_id`, `service_status`) VALUES ('2', 'Room', '50', '1', '2', '150', '2', '2', 'Available');
INSERT INTO `furama_resort`.`service` (`service_id`, `service_name`, `service_area`, `service_number_of_floor`, `service_max_inhouse`, `service_rent_price`, `rent_option_id`, `service_type_id`, `service_status`) VALUES ('3', 'House', '150', '2', '4', '300', '3', '3', 'Available');



-- Table Hợp đồng | Contract Table
create table if not exists additional_service (
`additional_service_id` int not null,
`additional_service_name` varchar(45),
`additional_service_price` int,
`additional_service_unit` int,
`additional_service_availability_status` varchar(45),
primary key (`additional_service_id`));

INSERT INTO `furama_resort`.`additional_service` (`additional_service_id`, `additional_service_name`, `additional_service_price`, `additional_service_unit`, `additional_service_availability_status`) VALUES ('1', 'Drink', '20', '5', 'Available');
INSERT INTO `furama_resort`.`additional_service` (`additional_service_id`, `additional_service_name`, `additional_service_price`, `additional_service_unit`, `additional_service_availability_status`) VALUES ('2', 'Massage', '100', '2', 'Available');
INSERT INTO `furama_resort`.`additional_service` (`additional_service_id`, `additional_service_name`, `additional_service_price`, `additional_service_unit`) VALUES ('3', 'Car', '100', '1');
UPDATE `furama_resort`.`additional_service` SET `additional_service_availability_status` = 'Available' WHERE (`additional_service_id` = '3');



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

INSERT INTO `furama_resort`.`contract` (`contract_id`, `employee_id`, `customer_id`, `service_id`, `contract_made_date`, `contract_end_date`, `contract_deposit`, `contract_total`) VALUES ('1', '5', '1', '1', '2021-05-14', '2021-05-24', '1000', '1200');
INSERT INTO `furama_resort`.`contract` (`contract_id`, `employee_id`, `customer_id`, `service_id`, `contract_made_date`, `contract_end_date`, `contract_deposit`, `contract_total`) VALUES ('2', '6', '2', '2', '2021-05-14', '2021-05-23', '800', '500');
INSERT INTO `furama_resort`.`contract` (`contract_id`, `employee_id`, `customer_id`, `service_id`, `contract_made_date`, `contract_end_date`, `contract_deposit`, `contract_total`) VALUES ('3', '5', '3', '3', '2021-05-14', '2021-05-22', '600', '800');
INSERT INTO `furama_resort`.`contract` (`contract_id`, `employee_id`, `customer_id`, `service_id`, `contract_made_date`, `contract_end_date`, `contract_deposit`, `contract_total`) VALUES ('4', '6', '4', '2', '2021-05-14', '2021-05-21', '400', '500');
INSERT INTO `furama_resort`.`contract` (`contract_id`, `employee_id`, `customer_id`, `service_id`, `contract_made_date`, `contract_end_date`, `contract_deposit`, `contract_total`) VALUES ('5', '5', '5', '1', '2021-05-14', '2021-05-20', '200', '1200');
INSERT INTO `furama_resort`.`contract` (`contract_id`, `employee_id`, `customer_id`, `service_id`, `contract_made_date`, `contract_end_date`, `contract_deposit`, `contract_total`) VALUES ('6', '6', '1', '1', '2020-01-12', '2020-01-15', '200', '600');



create table if not exists contract_detail (
`contract_detail_id` int not null,
`contract_id` int not null,
foreign key (`contract_id`) references contract (`contract_id`),
`additional_service_id` int not null,
foreign key (`additional_service_id`) references additional_service (`additional_service_id`),
`contract_detail_amount` int,
primary key (`contract_id`));

INSERT INTO `furama_resort`.`contract_detail` (`contract_detail_id`, `contract_id`, `additional_service_id`, `contract_detail_amount`) VALUES ('1', '1', '1', '5');
INSERT INTO `furama_resort`.`contract_detail` (`contract_detail_id`, `contract_id`, `additional_service_id`, `contract_detail_amount`) VALUES ('2', '2', '2', '4');
INSERT INTO `furama_resort`.`contract_detail` (`contract_detail_id`, `contract_id`, `additional_service_id`, `contract_detail_amount`) VALUES ('3', '3', '3', '3');
INSERT INTO `furama_resort`.`contract_detail` (`contract_detail_id`, `contract_id`, `additional_service_id`, `contract_detail_amount`) VALUES ('4', '4', '2', '2');
INSERT INTO `furama_resort`.`contract_detail` (`contract_detail_id`, `contract_id`, `additional_service_id`, `contract_detail_amount`) VALUES ('5', '5', '1', '1');
INSERT INTO `furama_resort`.`contract_detail` (`contract_detail_id`, `contract_id`, `additional_service_id`, `contract_detail_amount`) VALUES ('6', '6', '2', '0');


