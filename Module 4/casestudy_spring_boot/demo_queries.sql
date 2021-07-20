use spring_boot_furama


INSERT INTO `spring_boot_furama`.`position` (`position_id`, `position_name`) VALUES ('1', 'Receptionist')

INSERT INTO `spring_boot_furama`.`position` (`position_id`, `position_name`) VALUES ('2', 'Server')

INSERT INTO `spring_boot_furama`.`position` (`position_id`, `position_name`) VALUES ('3', 'Manager')

INSERT INTO `spring_boot_furama`.`position` (`position_id`, `position_name`) VALUES ('4', 'Security')

INSERT INTO `spring_boot_furama`.`education` (`education_id`, `education_name`) VALUES ('1', 'High School')

INSERT INTO `spring_boot_furama`.`education` (`education_id`, `education_name`) VALUES ('2', 'University')

INSERT INTO `spring_boot_furama`.`education` (`education_id`, `education_name`) VALUES ('3', 'Higher Education')

INSERT INTO `spring_boot_furama`.`rent_type` (`rent_type_id`, `rent_type_cost`, `rent_type_name`) VALUES ('1', '5000', 'Day')

INSERT INTO `spring_boot_furama`.`rent_type` (`rent_type_id`, `rent_type_cost`, `rent_type_name`) VALUES ('2', '30000', 'Week')

INSERT INTO `spring_boot_furama`.`rent_type` (`rent_type_id`, `rent_type_cost`, `rent_type_name`) VALUES ('3', '140000', 'Month')

INSERT INTO `spring_boot_furama`.`attach_service` (`attach_service_id`, `cost`, `name`, `status`, `unit`) VALUES ('1', '1000', 'Car', 'Available', '1')

INSERT INTO `spring_boot_furama`.`attach_service` (`attach_service_id`, `cost`, `name`, `status`, `unit`) VALUES ('2', '500', 'Drink', 'Available', '4')

INSERT INTO `spring_boot_furama`.`attach_service` (`attach_service_id`, `cost`, `name`, `status`, `unit`) VALUES ('3', '1500', 'Spa', 'Available', '2')

INSERT INTO `spring_boot_furama`.`service_type` (`service_type_id`, `service_type_name`) VALUES ('1', 'Villa')

INSERT INTO `spring_boot_furama`.`service_type` (`service_type_id`, `service_type_name`) VALUES ('2', 'Room')

INSERT INTO `spring_boot_furama`.`service_type` (`service_type_id`, `service_type_name`) VALUES ('3', 'House')

INSERT INTO `spring_boot_furama`.`division` (`division_id`, `division_name`) VALUES ('1', 'Front Office')

INSERT INTO `spring_boot_furama`.`division` (`division_id`, `division_name`) VALUES ('2', 'F&B')

INSERT INTO `spring_boot_furama`.`division` (`division_id`, `division_name`) VALUES ('3', 'Management')

INSERT INTO `spring_boot_furama`.`division` (`division_id`, `division_name`) VALUES ('4', 'Security')



INSERT INTO `spring_boot_furama`.`position` (`position_id`, `position_name`) VALUES ('1', 'Receptionist')

insert into app_user(user_id,user_name,encryted_password,enabled)    values(2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),                   (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1)

insert into app_role (ROLE_ID, ROLE_NAME) values (1, 'ROLE_ADMIN')

insert into app_role (ROLE_ID, ROLE_NAME) values (2, 'ROLE_USER')

insert into user_role (ID, USER_ID, ROLE_ID) values (1, 1, 1)

insert into user_role (ID, USER_ID, ROLE_ID) values (2, 1, 2)

insert into user_role (ID, USER_ID, ROLE_ID) values (3, 2, 2)

SELECT * FROM spring_boot_furama.user_role LIMIT 0, 1000

SELECT * FROM spring_boot_furama.app_user LIMIT 0, 1000

use spring_boot_furama;
INSERT INTO `spring_boot_furama`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('1', 'Standard');
INSERT INTO `spring_boot_furama`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('2', 'Gold');
INSERT INTO `spring_boot_furama`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('3', 'Diamond');
