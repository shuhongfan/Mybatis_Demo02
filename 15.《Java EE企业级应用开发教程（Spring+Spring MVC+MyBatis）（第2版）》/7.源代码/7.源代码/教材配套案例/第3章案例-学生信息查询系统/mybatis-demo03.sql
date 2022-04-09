# 使用mybatis数据库
USE mybatis;
# 创建一个名称为dm_student的表
CREATE TABLE dm_student(
    id int(32) PRIMARY KEY AUTO_INCREMENT,
    name varchar(50),
    major varchar(50),
    sno varchar(16)
);
# 插入7条数据
INSERT INTO dm_student VALUES ('1', '张三', '数学', '10001');
INSERT INTO dm_student VALUES ('2', '李四', '英语', '10002');
INSERT INTO dm_student VALUES ('3', '王五', '计算机', '10003');
INSERT INTO dm_student VALUES ('4', '王刚', '化学', '10004');
INSERT INTO dm_student VALUES ('5', '李华', '物理', '10005');
INSERT INTO dm_student VALUES ('6', '李雷', '中文', '10006');
INSERT INTO dm_student VALUES ('7', '张飞', '英语', '10007');

