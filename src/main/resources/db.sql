create database use_shiro;
use use_shiro;
create table dept(
did int primary key auto_increment,
dname varchar(255) not null unique
);
create table emp(
eid int primary key auto_increment,
name varchar(225) not null unique,
age int not null,
dept_id int,
constraint fk_dept_emp foreign key(dept_id) references dept(did)
);

create table admin(
id int primary key auto_increment,
username varchar(50) not null unique,
password varchar(50) not null
);