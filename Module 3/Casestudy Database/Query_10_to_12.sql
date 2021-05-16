-- Task 10
use furama_resort;
select contract.contract_id, contract.contract_made_date , contract.contract_end_date , 
contract.contract_deposit, count(additional_service.additional_service_id)
from contract 
join contract_detail
on contract.contract_id = contract_detail.contract_id 
join additional_service 
on contract_detail.additional_service_id = additional_service.additional_service_id
group by contract_detail.contract_id;

-- Task 11
use furama_resort;
update customer
set customer_address = "Vinh"
where customer_id = 4;

update customer
set customer_type_id = 1
where customer_id = 4;

select customer.customer_fullname,customer_type.customer_type_name,additional_service.additional_service_id,
additional_service.additional_service_name, additional_service.additional_service_price,
additional_service.additional_service_unit, additional_service.additional_service_availability_status
from customer
join customer_type
on customer.customer_type_id = customer_type.customer_type_id
join contract
on contract.customer_id = customer.customer_id
join contract_detail
on contract_detail.contract_id = contract.contract_id
join additional_service
on contract_detail.additional_service_id = additional_service.additional_service_id
where customer_type.customer_type_name = "Diamond" and (customer.customer_address in ("Vinh","Quang Ngai"));

-- Task 12
use furama_resort;
update contract
set contract_made_date = "2019-11-20"
where contract_id = 3;

update contract
set contract_end_date = "2021-05-12"
where contract_id = 5;

select contract.contract_id, employee.employee_name, customer.customer_fullname, 
customer.customer_phone_number, service.service_name, contract.contract_made_date, 
count(contract_detail.contract_detail_id) as number_of_additional_service, contract.contract_deposit
from customer
join contract 
on customer.customer_id = contract.customer_id
join employee
on contract.employee_id = employee.employee_id
join service 
on contract.service_id = service.service_id
join contract_detail 
on contract.contract_id = contract_detail.contract_id
where (year(contract.contract_made_date) =2019 and month(contract.contract_made_date) in(10,11,12)) 
and contract.service_id not in (
select contract.service_id 
from contract 
where (year(contract.contract_made_date) = 2019) and month(contract.contract_made_date) in (1,2,3,4,5,6)
)
group by contract.contract_id;
