-- Additional Insertion
 use furama_resort;
 update employee
 set employee_name = "Lan"
 where employee_id = 2;

 update employee
 set employee_name = "Hoa"
 where employee_id = 3;
 
 update contract
 set employee_id = 1
 where contract_id = 2;
 
  update contract
 set employee_id = 1
 where contract_id = 3;
 
  update contract
 set employee_id = 1
 where contract_id = 4;

-- Task 13
use furama_resort;
select additional_service.additional_service_name , additional_service.additional_service_price, 
additional_service.additional_service_unit , 
count(additional_service.additional_service_id) as number_of_additional_service
from additional_service
join contract_detail 
on additional_service.additional_service_id = contract_detail.additional_service_id
join contract 
on contract_detail.contract_id = contract.contract_id
group by additional_service.additional_service_id
having count(additional_service.additional_service_id) >= all (
select count(additional_service_id) 
from contract_detail
group by additional_service_id
);



-- Task 14
SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
use furama_resort;
select contract.contract_id , service.service_name , additional_service.additional_service_name, 
count(additional_service.additional_service_id) as number_of_usage
from contract
join service
on contract.service_id = service.service_id
join contract_detail
on contract_detail.contract_id = contract.contract_id
join additional_service
on additional_service.additional_service_id = contract_detail.additional_service_id
group by additional_service.additional_service_id
having count(additional_service.additional_service_id) = 1;
 
 
 -- Task 15
 use furama_resort;
 select employee.employee_id, employee.employee_name, qualification.qualification_name, 
 department.department_name, employee.employee_phone_number, 
 employee.employee_address, count(contract.employee_id) as "number_of_contract_made"
 from employee 
 join qualification 
 on employee.qualification_id = qualification.qualification_id
 join department
 on employee.department_id = department.department_id
 join position 
 on employee.position_id = position.position_id
 join contract 
 on contract.employee_id = employee.employee_id
 where year(contract.contract_made_date) between 2018 and 2019 
 group by employee.employee_id
 having count(contract.employee_id) <=3 ;
 
