-- Task 16
use furama_resort;
SET FOREIGN_KEY_CHECKS=0;
delete from employee
where employee.employee_id not in (
select contract.employee_id
from contract
where year(contract_made_date) between 2017 and 2019
);

-- Task 17
UPDATE `furama_resort`.`service` SET `service_rent_price` = '5000000' WHERE (`service_id` = '1');
UPDATE `furama_resort`.`service` SET `service_rent_price` = '1500000' WHERE (`service_id` = '2');
UPDATE `furama_resort`.`service` SET `service_rent_price` = '3000000' WHERE (`service_id` = '3');
UPDATE `furama_resort`.`additional_service` SET `additional_service_price` = '200000' WHERE (`additional_service_id` = '1');
UPDATE `furama_resort`.`additional_service` SET `additional_service_price` = '1000000' WHERE (`additional_service_id` = '2');
UPDATE `furama_resort`.`contract` SET `service_id` = '1' WHERE (`contract_id` = '2');

use furama_resort;
select * 
from customer;


update customer
set customer_type_id = 1
where customer_type_id = 2 and customer.customer_id in (
select customer_id					
from contract
join service 
on contract.service_id = service.service_id
join contract_detail 
on contract.contract_id = contract_detail.contract_id
join additional_service 
on contract_detail.additional_service_id = additional_service.additional_service_id
where year(contract_made_date) = 2019
group by contract.customer_id
having sum(service.service_rent_price + additional_service.additional_service_price * contract_detail.contract_detail_amount) > 10000000
);

select * 
from customer;

-- Task 18
use furama_resort;
delete 
from customer 
where customer.customer_id in (
	  select contract.customer_id
      from contract 
	  where year(contract.contract_made_date)<2016)
;
