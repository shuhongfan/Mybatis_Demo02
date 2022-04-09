USE mybatis;
CREATE TABLE t_student(
   sid INT PRIMARY KEY AUTO_INCREMENT,
   sname VARCHAR(50),
   sage INT
);
INSERT INTO t_student(sname,sage) VALUES('Lucy',25);
INSERT INTO t_student(sname,sage) VALUES('Lili',20);
INSERT INTO t_student(sname,sage) VALUES('Jim',20);


