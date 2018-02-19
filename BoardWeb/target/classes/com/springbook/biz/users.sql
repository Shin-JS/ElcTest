create table users(
	id varchar2(8) primary key,
	password varchar2(8),
	name varchar2(20),
	role varchar2(5)
);

insert into users values('test','1234','관리자','admin');

select * from users;