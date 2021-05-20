create database internship;
use internship;

create table faculty(
faculty_id int not null primary key,
faculty_name varchar(30) not null,
phone varchar(10));

create table instructor(
instructor_id int not null primary key,
instructor_name varchar(30),
salary double,
faculty_id int not null,
foreign key (faculty_id) references faculty(faculty_id)
);

create table student(
student_id int not null primary key,
student_name varchar(40) not null,
faculty_id int  not null,
foreign key (faculty_id) references faculty(faculty_id),
date_of_birth date,
place_of_birth varchar(30)
);

create table project(
project_id int not null primary key,
project_name varchar(40) not null,
expense double,
place_of_intern varchar(30)
);

create table instructor_student(
student_id int not null,
foreign key (student_id) references student(student_id),
project_id int not null,
foreign key (project_id) references project(project_id),
instructor_id int not null,
foreign key (instructor_id) references instructor(instructor_id),
grade float,
primary key (student_id,project_id,instructor_id)
);

INSERT INTO `internship`.`faculty` (`faculty_id`, `faculty_name`, `phone`) VALUES ('1', 'Cong Nghe Sinh Hoc', '0123123145');
INSERT INTO `internship`.`faculty` (`faculty_id`, `faculty_name`, `phone`) VALUES ('2', 'Toan', '7482982042');
INSERT INTO `internship`.`faculty` (`faculty_id`, `faculty_name`, `phone`) VALUES ('3', 'Dia Ly', '7482612622');
INSERT INTO `internship`.`faculty` (`faculty_id`, `faculty_name`, `phone`) VALUES ('4', 'QLTN', '5362712584');

INSERT INTO `internship`.`student` (`student_id`, `student_name`, `faculty_id`, `date_of_birth`, `place_of_birth`) VALUES ('1', 'Dong', '1', '2001-01-21', 'Daklak');
INSERT INTO `internship`.`student` (`student_id`, `student_name`, `faculty_id`, `date_of_birth`, `place_of_birth`) VALUES ('2', 'Nam', '2', '1997-12-30', 'Danang');
INSERT INTO `internship`.`student` (`student_id`, `student_name`, `faculty_id`, `date_of_birth`, `place_of_birth`) VALUES ('3', 'Trang', '3', '1998-03-21', 'Hue');
INSERT INTO `internship`.`student` (`student_id`, `student_name`, `faculty_id`, `date_of_birth`, `place_of_birth`) VALUES ('4', 'Huynh', '4', '1996-07-11', 'Danang');


INSERT INTO `internship`.`instructor` (`instructor_id`, `instructor_name`, `salary`, `faculty_id`) VALUES ('1', 'Trung', '20000000', '1');
INSERT INTO `internship`.`instructor` (`instructor_id`, `instructor_name`, `salary`, `faculty_id`) VALUES ('2', 'Tien', '15000000', '2');
INSERT INTO `internship`.`instructor` (`instructor_id`, `instructor_name`, `salary`, `faculty_id`) VALUES ('3', 'Linh', '10000000', '3');
INSERT INTO `internship`.`instructor` (`instructor_id`, `instructor_name`, `salary`, `faculty_id`) VALUES ('4', 'Hai', '12000000', '4');
INSERT INTO `internship`.`instructor` (`instructor_id`, `instructor_name`, `salary`, `faculty_id`) VALUES ('5', 'Le Van Son', '10000000', '1');
INSERT INTO `internship`.`instructor` (`instructor_id`, `instructor_name`, `salary`, `faculty_id`) VALUES ('6', 'Tran Son', '8000000', '3');


INSERT INTO `internship`.`project` (`project_id`, `project_name`, `expense`, `place_of_intern`) VALUES ('1', 'Tai Nguyen', '4000000', 'Quang Nam');
INSERT INTO `internship`.`project` (`project_id`, `project_name`, `expense`, `place_of_intern`) VALUES ('2', 'Moi Truong', '4000000', 'Quang Ngai');
INSERT INTO `internship`.`project` (`project_id`, `project_name`, `expense`, `place_of_intern`) VALUES ('3', 'Hinh hoc ', '2500000', 'Ha Noi');
INSERT INTO `internship`.`project` (`project_id`, `project_name`, `expense`, `place_of_intern`) VALUES ('4', 'Dia Chat', '6000000', 'Phu Yen');


INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('1', '1', '1', '8');
INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('2', '2', '2', '7.5');
INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('3', '4', '5', '5.5');
INSERT INTO `internship`.`instructor_student` (`student_id`, `project_id`, `instructor_id`, `grade`) VALUES ('4', '3', '6', '9.5');
