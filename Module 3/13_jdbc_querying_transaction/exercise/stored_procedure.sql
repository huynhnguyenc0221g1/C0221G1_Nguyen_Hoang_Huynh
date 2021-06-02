USE `user_management`;

-- Show Users List
DELIMITER $$

CREATE PROCEDURE list_user_procedure()
BEGIN
SELECT * from users;
END$$

DELIMITER ;

-- Update An User  
DELIMITER $$

CREATE PROCEDURE update_user_procedure(p_id int, u_name varchar(50) , u_email varchar(50) , u_country varchar(50))
BEGIN
Update users
set `name` = u_name, email = u_email , country = u_country
where id = p_id;
END$$

DELIMITER ;

-- Delete An User
DELIMITER $$

CREATE PROCEDURE delete_user_procedure(d_id int)
BEGIN
DELETE FROM users
WHERE id = d_id;
END$$

DELIMITER ;