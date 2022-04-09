use mybatis;
create table users(
    uid int primary key auto_increment,
    uname varchar(20) not null,
    uage int not null
);
insert into users(uid,uname,uage) values(null,'张三',20),(null,'李四',18);

CREATE TABLE t_student(
   sid INT PRIMARY KEY AUTO_INCREMENT,
   sname VARCHAR(50),
   sage INT
);
INSERT INTO t_student(sname,sage) VALUES('Lucy',25);
INSERT INTO t_student(sname,sage) VALUES('Lili',20);
INSERT INTO t_student(sname,sage) VALUES('Jim',20);

# 创建一个名称为t_customer的表
CREATE TABLE t_customer (
    id int(32) PRIMARY KEY AUTO_INCREMENT,
    username varchar(50),
    jobs varchar(50),
    phone varchar(16)
);
# 插入3条数据
INSERT INTO t_customer VALUES ('1', 'joy', 'teacher', '13733333333');
INSERT INTO t_customer VALUES ('2', 'jack', 'teacher', '13522222222');
INSERT INTO t_customer VALUES ('3', 'tom', 'worker', '15111111111');
