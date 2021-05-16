
-- Task 2
use furama_resort;
select *
from employee
where (length(employee.employee_name)<=15) and (employee.employee_name like 'H%' or employee.employee_name like  'T%' or employee.employee_name like 'K%');

-- Task 3
use furama_resort;
select *
from customer
where (customer.customer_address in ("Danang","Quang Tri")) and (TIMESTAMPDIFF(YEAR, customer.customer_birthdate, CURDATE()) between 18 and 50);

-- Task 4
use furama_resort;
select customer.customer_fullname as "Full Name", count(contract.contract_id) as "Number of contract"
from customer
inner join contract
on customer.customer_id = contract.customer_id
inner join customer_type
on customer_type.customer_type_id = customer.customer_type_id
where customer_type.customer_type_name = "Diamond"
group by customer.customer_id;

-- Task 5
use furama_resort;
select customer.customer_id, customer.customer_fullname, customer_type.customer_type_name, 
contract.contract_id, service.service_name, contract.contract_made_date, contract.contract_end_date, 
(service.service_rent_price + (additional_service.additional_service_price * additional_service.additional_service_unit)) as total_price
from customer
left outer join contract
on customer.customer_id = contract.customer_id
left outer join customer_type
on customer_type.customer_type_id = customer.customer_type_id
left outer join service
on service.service_id = contract.service_id
left outer join contract_detail
on contract_detail.contract_id = contract.contract_id
left outer join additional_service
on additional_service.additional_service_id = contract_detail.additional_service_id
group by customer.customer_id,contract.contract_id,total_price;
