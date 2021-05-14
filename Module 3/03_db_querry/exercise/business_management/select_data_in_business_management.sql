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

-- Thêm dữ liệu Customer
use business_management;
INSERT INTO `business_management`.`customer` (`customer_id`, `customer_name`, `customer_age`) 
VALUES ('1', 'Minh Quan', '10');
INSERT INTO `business_management`.`customer` (`customer_id`, `customer_name`, `customer_age`) 
VALUES ('2', 'Ngoc Oanh', '20');
INSERT INTO `business_management`.`customer` (`customer_id`, `customer_name`, `customer_age`) 
VALUES ('3', 'Hong Ha', '50');

-- Thêm dữ liệu Order
use business_management;
INSERT INTO `business_management`.`order` (`order_id`, `customer_id`, `order_date`) 
VALUES ('1', '1', '2006/03/21');
INSERT INTO `business_management`.`order` (`order_id`, `customer_id`, `order_date`) 
VALUES ('2', '2', '2006/03/23');
INSERT INTO `business_management`.`order` (`order_id`, `customer_id`, `order_date`) 
VALUES ('3', '1', '2006/03/16');

-- Thêm dữ liệu Product
use business_management;
INSERT INTO `business_management`.`product` (`product_id`, `product_name`, `product_price`) 
VALUES ('1', 'May Giat', '3');
INSERT INTO `business_management`.`product` (`product_id`, `product_name`, `product_price`) 
VALUES ('2', 'Tu Lanh', '5');
INSERT INTO `business_management`.`product` (`product_id`, `product_name`, `product_price`) 
VALUES ('3', 'Dieu Hoa', '7');
INSERT INTO `business_management`.`product` (`product_id`, `product_name`, `product_price`) 
VALUES ('4', 'Quat', '1');
INSERT INTO `business_management`.`product` (`product_id`, `product_name`, `product_price`) 
VALUES ('5', 'Bep Dien', '2');

-- Thêm dữ liệu Order Detail
use business_management;
INSERT INTO `business_management`.`order_detail` (`order_id`, `product_id`, `order_quantity`) 
VALUES ('1', '1', '3');
INSERT INTO `business_management`.`order_detail` (`order_id`, `product_id`, `order_quantity`) 
VALUES ('1', '3', '7');
INSERT INTO `business_management`.`order_detail` (`order_id`, `product_id`, `order_quantity`) 
VALUES ('1', '4', '2');
INSERT INTO `business_management`.`order_detail` (`order_id`, `product_id`, `order_quantity`) 
VALUES ('2', '1', '1');
INSERT INTO `business_management`.`order_detail` (`order_id`, `product_id`, `order_quantity`) 
VALUES ('3', '1', '8');
INSERT INTO `business_management`.`order_detail` (`order_id`, `product_id`, `order_quantity`) 
VALUES ('2', '5', '4');
INSERT INTO `business_management`.`order_detail` (`order_id`, `product_id`, `order_quantity`) 
VALUES ('2', '3', '3');

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
use business_management;
select order_id,order_date,order_total_price
from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
use business_management;
select customer.customer_name,product.product_name
from customer
inner join `order`
on customer.customer_id = `order`.customer_id
join order_detail 
on `order`.order_id = order_detail.order_id
join product
on product.product_id = order_detail.product_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
use business_management;
select customer.customer_name as WithoutOrder
from customer
left outer join `order`
on customer.customer_id = `order`.customer_id
where `order`.order_id is null;


-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn)
-- Giá bán của từng loại được tính = odQTY*pPrice)
-- Sử dụng lệnh này sau khi research vì lệnh group by ở phần phía dưới dính lỗi #1055
SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

use business_management;
select order_detail.order_id,`order`.order_date,sum(product.product_price * order_detail.order_quantity) as total_price
from order_detail
join `order`
on `order`.order_id = order_detail.order_id
join product
on product.product_id = order_detail.product_id
group by order_detail.order_id;