use mybatis;
create table users(
    uid int primary key auto_increment,
    uname varchar(20) not null,
    uage int not null
);
insert into users(uid,uname,uage) values(null,'张三',20),(null,'李四',18);

