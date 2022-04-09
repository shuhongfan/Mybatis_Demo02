USE mybatis;
# 创建一个名称为tb_worker的表
CREATE TABLE  tb_worker( 
     id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(32),
     age INT,
     sex VARCHAR(8),
     worker_id INT UNIQUE     
);
# 插入2条数据
INSERT INTO tb_worker(name,age,sex,worker_id)VALUES('张三',32,'女',1001);
INSERT INTO tb_worker(name,age,sex,worker_id)VALUES('李四',29,'男',1002);
INSERT INTO tb_worker(name,age,sex,worker_id)VALUES('王五',26,'男',1003);
