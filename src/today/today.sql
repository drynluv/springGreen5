select database();
show tables;

create table diary (
	idx int not null auto_increment primary key, /* 고유번호 */
	/* name char(2) not null,  	 		아이디 */
	/* pwd varchar(20) not null,  	비밀번호 */
	wDate datetime default now(),  /* */
	weather varchar(30) not null,
	feel    varchar(30),
	content text not null,
	photo   varchar(50)
);
	
alter table diary modify column feel varchar(30);

-- insert into diary values (default,'오늘','1234');
-- insert into diary (weather,content) values ('맑음','내용입니다');

select * from diary;

desc diary;
	
drop table diary;