-- Task 6
use furama_resort;
update contract
set contract_made_date = "2019-1-12"
where contract_id = 3;

select service.service_id, service.service_name, service.service_area, service.service_rent_price, 
service_type.service_type_name, contract.contract_made_date, contract.contract_id
from service 
join service_type
on service.service_type_id = service_type.service_type_id
join contract 
on service.service_id = contract.service_id 
where contract.service_id not in (
select contract.service_id
from contract
where(year(contract.contract_made_date) = 2019) and (month(contract.contract_made_date) in (1,2,3))
);

-- Task 7
use furama_resort;
update contract
set contract_made_date = "2018-3-14"
where contract_id = 1;

select service.service_id , service.service_name , service.service_area, service.service_max_inhouse,
service.service_rent_price, service_type.service_type_name
from service 
join service_type 
on service.service_type_id = service_type.service_type_id
join contract 
on service.service_id = contract.service_id
where (year(contract.contract_made_date) = 2018) 
and contract.service_id not in (select contract.service_id from contract where year(contract.contract_made_date) =2019);

-- Task 8
use furama_resort;
-- Method 1
select customer_fullname 
from customer  
group by customer_fullname;

-- Method 2
select distinct customer_fullname 
from customer;

-- Method 3 
select customer_fullname 
from customer 
union
select customer_fullname 
from customer;

-- Task 9
update contract
set contract_made_date = "2019-02-25"
where contract_id = 2;

use furama_resort;
select month(contract.contract_made_date) as "Month", 
sum(service.service_rent_price + (additional_service.additional_service_price * additional_service.additional_service_unit)) as "Total Gross"
from customer
join customer_type 
on customer.customer_type_id = customer_type.customer_type_id
join contract 
on customer.customer_id = contract.customer_id
join service
on contract.service_id = service.service_id
join contract_detail
on contract.contract_id = contract_detail.contract_id
join additional_service 
on contract_detail.additional_service_id = additional_service.additional_service_id
where year(contract.contract_made_date) = 2019
group by month(contract.contract_made_date);

