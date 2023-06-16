-- create database gp;
show databases;
use gp;


-- 자동커밋 설정
set AUTOCOMMIT=true;
-- 자동커밋 설정 확인
show variables like 'autocommit';

-- 테스트용 샘플 테이블(sample1)
create table sample1(item1 varchar(50) primary key, item2 int default 0, item3 datetime default (CURRENT_TIMESTAMP));
insert into sample1 values('parkjihyeon', 90, default);
insert into sample1 values('junjaeyoung', 60, default);
insert into sample1 values('chotaejeoung', 80, default);

select * from sample1;

-- 회원 user1
create table user1 (
id varchar(20) primary key not null,
pw varchar(100) not null,
name varchar(20),
tel varchar(13),
addr varchar(300),
email varchar(200), 
udate timestamp default current_timestamp);

drop table user1;
insert into user1 values('admin', '1234', '관리자', '010123412324', '고양시 일산동구', 'admin@naver.com', default);
select * from user1;
update user1 set pw='hmX1PsFmohg5I0GmRBWK9yCn0PbYZyYKnus5JE0HU3rt4d7ie4jKak9IgW3BWKevVAnmww==' where id='admin';

insert into user1 values('kim', '4j1eubK8S9FXd42tPq5udVKUGC/0rfYRu/x7HlHJBXdkdDnwEbJKdlRx81GtRct7OGnXDw==', '김아무', '01011111111', '고양시 덕양구', 'kim@daum.net', default);

-- 리뷰 review
create table review (
rnum int primary key not null auto_increment,
rtitle varchar(100),
rcontent varchar(500),
rauthor varchar(20),
file1 varchar(100),
rdate timestamp default current_timestamp);

drop table review;
select * from review;
insert into review values(default, '제목1', '내용1', 'admin', 'file.txt', default);

drop table qna;
-- Q&A qna
create table qna (
qnum varchar(10) primary key not null,
qtitle varchar(100),
qcontent varchar(500),
qauthor varchar(20),
qdate timestamp default current_timestamp);

alter table qna add(lev int);
alter table qna add(parno varchar(8));

insert into qna values('1', '제목1', '내용1', 'admin', default, '1', default);
insert into qna values('2', '제목1', '내용1', 'admin', default, '1', default);

select * from qna;

select @rownum:=@rownum+1, A.* from qna a, (select @rownum:=0)r;

-- 공지사항 notice
create table notice (
nnum int primary key not null auto_increment,
ntitle varchar(100),
ncontent varchar(500),
nauthor varchar(20),
file1 varchar(100),
ndate timestamp default current_timestamp );

drop table notice;
select * from notice;
insert into notice values(default,'제목1','내용1','admin','header.jsp',default);
insert into notice values(default,'제목2','내용2','admin','header.jsp',default);

-- 게시판 board
create table board (
bnum varchar(10) primary key not null,
btitle varchar(100),
bcontent varchar(500),
bauthor varchar(20),
bdate date default (current_date),
pic1 varchar(100),
pic2 varchar(100),
pic3 varchar(100),
pic4 varchar(100),
pic5 varchar(100), 
cate varchar(10)
);
select * from board;

-- 카테고리 category
create table category(
cate varchar(10) primary key not null,
catename varchar(100),
categroup varchar(50) );

insert into category values('0101', '관광지', '관광명소');
insert into category values('0102', '문화유적', '관광명소');

insert into category values('0201', '관광호텔', '숙박');
insert into category values('0202', '일반숙박시설', '숙박');
insert into category values('0203', '야영장', '숙박');

insert into category values('0301', '100대맛집', '맛집');
insert into category values('0302', '일반음식점', '맛집');
select * from category;

show tables;
delete from board where bnum='01010001';
select * from board;
insert into board values('01010001', '청평호반', '경기 가평군 설악면 회곡리, 청평면 호명리.고성리 일원',
'admin', default, 'img/m1-1/1.jpg','img/m1-1/1-1.jpg','img/m1-1/1-2.jpg','img/m1-1/1-3.jpg','img/m1-1/1-4.jpg','0101');

insert into board values('01010002', '호명호수', '경기 가평군 청평면 상천리 일원',
'admin', default, 'img/m1-1/3.jpg','img/m1-1/2-1.jpg','img/m1-1/2-2.jpg','img/m1-1/2-3.jpg','img/m1-1/2-4.jpg','0101');

insert into board values('01010003', '용추계곡', '경기 가평군 가평읍 승안리 일원',
'admin', default, 'img/m1-1/3.jpg','img/m1-1/3-1.jpg','img/m1-1/3-2.jpg','img/m1-1/3-3.jpg','img/m1-1/3-4.jpg','0101');

delete from board where bnum='01010003';

commit;
