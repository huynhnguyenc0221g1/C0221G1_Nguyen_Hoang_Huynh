create database business_management;
use business_management;

create table customer (
`customer_id` int not null primary key,
`customer_name` varchar(45),
`customer_age` int);

create table `order` (
`order_id` int not null primary key,
`customer_id` int not null,
foreign key (`customer_id`) references customer(`customer_id`),
`order_date` date,
`order_total_price` varchar(45));

create table product (
`product_id` int not null primary key,
`product_name` varchar(45),
`product_price` varchar(45));

create table order_detail (
`order_id` int not null,
`product_id` int not null,
primary key (`order_id`,`product_id`),
foreign key (`order_id`) references `order`(`order_id`),
foreign key (`product_id`) references product(`product_id`),
`order_quantity` int);

