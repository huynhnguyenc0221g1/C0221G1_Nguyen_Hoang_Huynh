CREATE DATABASE student_management;
USE student_management;
CREATE TABLE class
(
    class_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(60) NOT NULL,
    start_date DATETIME    NOT NULL,
    status    BIT
);

CREATE TABLE student
(
    student_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(30) NOT NULL,
    address     VARCHAR(50),
    phone       VARCHAR(20),
    status      BIT,
    class_id     INT         NOT NULL,
    FOREIGN KEY (class_id) REFERENCES class (class_id)
);
CREATE TABLE subject
(
    subject_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    subject_name VARCHAR(30) NOT NULL,
    credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( credit >= 1 ),
    status  BIT                  DEFAULT 1
);
CREATE TABLE mark
(
    mark_id    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    subject_id     INT NOT NULL,
    student_id INT NOT NULL,
    mark      FLOAT   DEFAULT 0 CHECK ( mark BETWEEN 0 AND 100),
    exam_times TINYINT DEFAULT 1,
    UNIQUE (subject_id, student_id),
    FOREIGN KEY (subject_id) REFERENCES subject (subject_id),
    FOREIGN KEY (student_id) REFERENCES student (student_id)
);

USE student_management;
INSERT INTO class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO class
VALUES (3, 'B3', current_date, 0);

INSERT INTO student (student_name, address, phone, status, class_id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (student_name, address, status, class_id)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO student (student_name, address, phone, status, class_id)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
INSERT INTO subject
VALUES (5, 'CF', 4, 1);

INSERT INTO mark (subject_id, student_id, mark, exam_times)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
       
INSERT INTO mark (subject_id, student_id, mark, exam_times)
VALUES (1, 3, 8, 1);
-- Hiển thị tất cả sinh viên có tên bắt đầu bằng chữ 'H'
USE student_management;
select *
from student
where student.student_name like "H%";

-- Hiển thị thông tin lớp học bắt đầu từ tháng 12
USE student_management;
select *
from class
where class.start_date >= '2008-12-01 00:00:00';

-- Hiển thị tất cả thông tin môn học có credit từ 3-5
USE student_management;
select *
from subject
where subject.credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2
SET SQL_SAFE_UPDATES = 0;
USE student_management;
update student
set student.class_id = 2
where student.student_name = 'Hung';

select * from student;

-- Hiển thị các thông tin: StudentName, SubName, Mark.
-- Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
USE student_management;
select student.student_name,subject.subject_name,mark.mark
from mark
inner join student
on mark.student_id = student.student_id
inner join subject
on mark.subject_id = subject.subject_id
order by mark desc;