create database product_management;
use product_management;

create table product(
	product_id int,
	product_code varchar(45),
	product_name varchar(45),
	product_price float,
	product_amount float,
	product_description varchar(45),
	product_status varchar(45)
);

insert into product
values (1,"001","pizza",100,1,"made in italy","available"),
(2,"002","sausage",50,2,"made in germany","available"),
(3,"003","soft drink",50,2,"coca-cola","available"),
(4,"004","ice cream",20,1,"made in vietnam","available");

explain 
select * 
from product 
where product_code = "002";

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
alter table product
add index idx_product_code(product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
alter table product
add index idx_product_name_and_price(product_name,product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain 
select * 
from product 
where product_name = "soft drink" or product_Price = 100;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view view_product as
select product_code,product_name,product_price,product_status
from product;

-- Tiến hành sửa đổi view 
alter view view_product as
select * 
from product
where product_price >= 50;

select * from view_product;

-- Tiến hành xóa view 
drop view view_product;


-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
create procedure product_show_all()
begin
	select * from product;
 end //
 DELIMITER ; 
 
 call product_show_all();
 
-- Tạo store procedure thêm một sản phẩm mới
 DELIMITER //
 create procedure product_insertion(
	IN id int , 
    `code` varchar(45),
    `name` varchar(45),
    price float,
    amount float,
    `description` varchar (45),
    `status` varchar (45)
 )
 begin
	insert into product
    values(id,`code`,`name`,price,amount,`description`,`status`) ;
end //
DELIMITER ;    

call product_insertion(5,"005","corn",10,2,"made in thailand","not available");

call product_show_all();

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
create procedure product_edit_by_id( 
IN id int,
`code` varchar(45),
`name` varchar(45),
price float,
amount float,
`description` varchar (45),
`status` varchar (45))
begin 
	update product
    set product_code = `code`,
		product_name = `name`,	
	    product_price = price,
        product_amount = amount,
        product_description = `description`,
        product_status = `status`
    where product_id = id;
end //
DELIMITER ;

SET SQL_SAFE_UPDATES = 0;
call product_edit_by_id(5,"007","vietnamese pancake",30,4,"made in vietname","available");

call product_show_all();

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER //
 create procedure product_delete_by_id(IN id int)
 begin 
	delete from product
    where product_id = id ;
    end //
DELIMITER 

call product_delete_by_id(1);

call product_show_all();
