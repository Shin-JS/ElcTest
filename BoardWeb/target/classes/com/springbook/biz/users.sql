create table users(
	id varchar2(8) primary key,
	password varchar2(8),
	name varchar2(20),
	role varchar2(5)
);

insert into users values('test','1234','관리자','admin');

select * from users;

select * from board;

select * from board3;

create table board3(
	seq number(5) primary key,
	title varchar2(200),
	writer varchar2(20),
	content varchar2(2000),
	regdate date default sysdate,
	cnt number(5)
);