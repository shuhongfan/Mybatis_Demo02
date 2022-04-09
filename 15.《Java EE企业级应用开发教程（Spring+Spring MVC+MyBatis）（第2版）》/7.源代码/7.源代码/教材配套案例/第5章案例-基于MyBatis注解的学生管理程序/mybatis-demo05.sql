USE mybatis;
# 创建一个名称为c_class的表
CREATE TABLE c_class (
  id int(32) PRIMARY KEY AUTO_INCREMENT,
  classname varchar(40)
 );
# 插入2条数据
INSERT INTO c_class VALUES (1, '一班');
INSERT INTO c_class VALUES (2, '二班');
# 创建一个名称为s_student的表
CREATE TABLE s_student (
  id int(32) PRIMARY KEY AUTO_INCREMENT,
  name varchar(40),
  age int,
  cid int(32) NOT NULL,
  FOREIGN KEY(cid) REFERENCES c_class(id)
 );
# 插入4条数据
INSERT INTO s_student VALUES (1, '张三', 18,1);
INSERT INTO s_student VALUES (2, '李四', 18,2);
INSERT INTO s_student VALUES (3, '王五', 19,2);
INSERT INTO s_student VALUES (4, '赵六', 20,1);
