use mybatis;
create table employee(
    id int primary key auto_increment,
    name varchar(20) not null,
    age int not null,
    position varchar(20)
);
insert into employee(id,name,age,position) values(null,'张三',20,'员工  	'),(null,'李四',18, '员工'),(null,'王五',35,'经理');
