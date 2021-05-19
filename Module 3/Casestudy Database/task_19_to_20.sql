-- Task 19
use furama_resort;
update additional_service
set additional_service.additional_service_price = (additional_service.additional_service_price*2)
where additional_service.additional_service_id in
	  (select additional_service.additional_service_id from 
      ( select additional_service.additional_service_id 
	  from additional_service 
	  join contract_detail 
      on contract_detail.additional_service_id =additional_service.additional_service_id
	  join contract
      on contract.contract_id = contract_detail.contract_id
	  where year(contract.contract_made_date)=2019
	  group by additional_service.additional_service_id
	  having count(additional_service.additional_service_id)>10
    ) as add_sv
);

-- Task 20
use furama_resort;
select employee.employee_id,employee.employee_name,employee.employee_email,employee.employee_phone_number,
employee.employee_birthdate,employee.employee_address
from employee
union all
select customer.customer_id,customer.customer_fullname,customer.customer_email,customer.customer_phone_number,
customer.customer_birthdate,customer.customer_address
from customer;