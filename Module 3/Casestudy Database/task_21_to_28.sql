-- Task 21
use furama_resort;
UPDATE `furama_resort`.`contract` SET `contract_made_date` = '2019-12-12' WHERE (`contract_id` = '5');
UPDATE `furama_resort`.`employee` SET `employee_address` = 'Hai Chau' WHERE (`employee_id` = '5');

create view employee_view as
select employee.employee_id,employee.employee_name,employee.position_id,
employee.qualification_id,employee.department_id,employee.employee_birthdate,
employee.employee_id_number,employee.employee_salary,employee.employee_phone_number,
employee.employee_email,employee.employee_address
from employee 
join contract  
on contract.employee_id = employee.employee_id
where employee.employee_address = "Hai Chau" and contract.contract_made_date = "2019-12-12";

select * 
from employee_view;

-- Task 22
use furama_resort;
update employee_view 
set employee_address = 'Lien Chieu'
where employee_id in (employee_view.employee_id);

select employee.employee_id, employee.employee_address
from employee;

-- Task 23
use furama_resort;
select *
from customer;

delimiter //
create procedure sp_1(in deleted_id int)
begin
delete from customer 
where customer.customer_id = deleted_id;
end;
// delimiter ;

call sp_1(6);
select *
from customer;

-- Task 24
use furama_resort;
delimiter //
create procedure sp_2(contract_id int, employee_id int, customer_id int,service_id int, contract_made_date date,
				       contract_end_date date,contract_deposit double,contract_total double)
begin
insert into contract 
values(contract_id,employee_id,customer_id,service_id,contract_made_date,contract_end_date,contract_deposit,contract_total);
end;
// delimiter ;

-- Task 25