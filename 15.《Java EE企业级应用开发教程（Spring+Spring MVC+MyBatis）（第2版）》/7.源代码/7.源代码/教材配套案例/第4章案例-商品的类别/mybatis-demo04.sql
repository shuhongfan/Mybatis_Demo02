USE mybatis;
# 创建一个名称为category的表
CREATE TABLE category (
  id int(32) PRIMARY KEY AUTO_INCREMENT,
  typename varchar(40)
 );
# 插入2条数据
INSERT INTO category VALUES (1, '黑色家电');
INSERT INTO category VALUES (2, '白色家电');
# 创建一个名称为product的表
CREATE TABLE product (
  id int(32) PRIMARY KEY AUTO_INCREMENT,
  goodsname varchar(40),
  price DOUBLE,
  category_id int(32) NOT NULL,
  FOREIGN KEY(category_id) REFERENCES category(id)
 );
# 插入4条数据
INSERT INTO product VALUES (1, '电视机', 5000,1);
INSERT INTO product VALUES (2, '冰箱', 4000,2);
INSERT INTO product VALUES (3, '空调', 5000,2);
INSERT INTO product VALUES (4, '洗衣机', 2000,2);

