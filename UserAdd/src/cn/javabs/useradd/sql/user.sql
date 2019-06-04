create database user;
use user;
create table user(
id int primary key auto_increment,
username varchar(50) not null,
password varchar(50) not null,
sex varchar(10) 
);