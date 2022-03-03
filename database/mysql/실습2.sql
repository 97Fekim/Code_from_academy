select ascii('A'), cast(CHAR(65) as char) '문자';
select format(123456.123456,4); -- 소수점 넷째 자리까지 출력
select bin(31), hex(31), oct(31); -- 2, 16, 8진수로 변환
select insert('abcdefghi', 3,4,'@@@@'), insert('abcdefghi', 3, 2, '@@@@');
-- 기존 문자열의 위치부터 길이 만큼을 지우고 삽입할 문자열을 끼워 넣는다.

select left('abcdefghi', 3), right('abcdefghi',3); -- 왼쪽 또는 오른쪽에서 문자열의 길이 만큼 변환. 
select LCASE('abcdEFGH'), ucase('abcdEFGH'); -- lower case, upper case
-- LPAD(문자열, 길이, 채울 문자열) : 문자열의 왼쪽에 채운다.
-- RPAD(문자열, 길이, 채울 문자열) : 문자열의 오른쪽에 채운다.
-- 문자열을 길이만큼 늘린 후에 빈곳을 채울 문자열로 채운다.
select lpad('이것이', 5,'##'),rpad('이것이','5','##');

-- ltrim, rtrim은 문자열의 왼쪽/오른쪽의 공백을 제거, 중간의 공백은 제거하지 않는다.
select ltrim('    이것이'), rtrim('이것이      ');
select char_length(ltrim('     이것이')), char_length(rtrim('이것이    '));
select trim('   이것이   '), trim(both 'ㅋ' from 'ㅋㅋㅋ재밌어요.ㅋㅋㅋ');

create table green(
migum varchar(100)
);
-- 문제1) 테이블에 데이터를 추가하여 trim을 활용하여 출력하세요
insert into green values('   i am Iron Man   ');
select trim(migum) from green;
select lcase(migum) from green;
select ucase(migum) from green;
select lpad(migum, char_length(migum)+5, 'lolol') from green;

-- 문제2) 테이블에 데이터 추가 후 substring 활용하여 출력
insert into green values('  I am your father   ');
select substring(migum, 2, 5) from green;

-- 문제3) 
select adddate('2024-01-01', interval 31 day), adddate('2025-01-01', interval 1 month);

create table d_day(
	birthday date
);

insert into d_day(birthday) values(19971212);
select adddate(birthday, interval 25 year) from d_day;

alter table d_day
	add column marryday date;

create table temp2 select happyday from d_day where marryday is null;



-- 여기부터 join 예제
create table usertbl(
	userId varchar(8) not null primary key, -- 사용자 아이디(PK // Primary Key)
    name varchar(10) not null, -- 이름
    birthYear int not null, -- 출생년도
    addr char(2) not null, -- 지역(경기, 서울, 경남의 format으로 두글자만 입력)
    mobile1 char(3), -- 휴대폰의 국번(011, 016, 017, 010 등)
    mobile2 char(8), -- 휴대폰의 나머지 전화번호
    height smallint, -- 키(작은 정수)
    mDate date -- 회원가입일
);
create table buytbl( -- 회원 구매 테이블 (foreign key를 userid로 설정하므로써, usertbl에 아이디가 있는 경우에만 이 테이블을 사용할 수 있음)
	num int auto_increment not null primary key,
		-- auto_increment는 자동으로 숫자가 하나씩 증가함
	userId char(8) not null,	-- 아이디(FK/foreign key)
    prodName char(6) not null,	-- 물품명
    groupName char(4),	-- 분류
    price int not null, -- 단가
    amount smallint not null, -- 수량
    foreign key (userid) references usertbl(userid)
);

-- data 삽입
INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기', '011', '4444444', 166, '2009-4-4');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울', NULL  , NULL      , 186, '2013-12-12');
INSERT INTO usertbl VALUES('LJB', '임재범', 1963, '서울', '016', '6666666', 182, '2009-9-9');
INSERT INTO usertbl VALUES('YJS', '윤종신', 1969, '경남', NULL  , NULL      , 170, '2005-5-5');
INSERT INTO usertbl VALUES('EJW', '은지원', 1972, '경북', '011', '8888888', 174, '2014-3-3');
INSERT INTO usertbl VALUES('JKW', '조관우', 1965, '경기', '018', '9999999', 172, '2010-10-10');
INSERT INTO usertbl VALUES('BBK', '바비킴', 1973, '서울', '010', '0000000', 176, '2013-5-5');
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200,  1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '모니터', '전자', 200,  5);
INSERT INTO buytbl VALUES(NULL, 'KBS', '청바지', '의류', 50,   3);
INSERT INTO buytbl VALUES(NULL, 'BBK', '메모리', '전자', 80,  10);
INSERT INTO buytbl VALUES(NULL, 'SSK', '책'    , '서적', 15,   5);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '청바지', '의류', 50,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);

-- join 예제1
select * from buytbl inner join usertbl
	on buytbl.userid = usertbl.userid;

-- join 예제2
create table f(
	userid int,
    name varchar(10)
);
create table g(
	userid int,
    address varchar(15)
);
insert into f values(1,'홍길동');
insert into f values(2,'홍말자');
insert into f values(4,'김개똥');
insert into f values(5,'그린');
insert into f values(7,'컴퓨터');

insert into g values(1,'수원');
insert into g values(3,'부산');
insert into g values(6,'대구');
insert into g values(7,'전주');
insert into g values(11,'제주도');

select * from f
	inner join g
		on f.userid = g.userid;
        
select * from f
	left join g
		on f.userid = g.userid;

select * from f
	right join g
		on f.userid = g.userid;
        
-- 테이블 2개를 생성하여
-- 반 칼럼명 기준으로 테이블 조인하세요
create table naver(
	name char(5),
    pay int,
    class char(7)
);
create table kakao(
	name char(5),
    pay int,
    class char(7)
);

drop table naver;
drop table kakao;

insert into naver values('김승철', 6000, '주니어');
insert into naver values('김동철', 8000, '미드레벨');
insert into naver values('김경철', 9000, '시니어');
insert into naver values('김진철', 9500, '시니어');

insert into kakao values('서승철', 5000, '주니어');
insert into kakao values('서동철', 7000, '미드레벨');
insert into kakao values('서경철', 7000, '미드레벨');
insert into kakao values('서진철', 8500, '미드레벨');

select * from naver;
select * from kakao;

select * from naver 
	inner join kakao
		on naver.class = kakao.class;

select * from naver 
	left join kakao
		on naver.class = kakao.class;
        
select * from naver 
	right join kakao
		on naver.class = kakao.class;
        
create table migum_school(	-- sql은 대소문자 구분이 없기때문에 snake case로 이름을 붙인다.
	ban int,
    name char(20),
    score int
);
create table bundang_school(
	ban int,
    address char(50),
    phone char(20),
    grade varchar(10)
);
insert into migum_school values(1, 'a', 30);
insert into migum_school values(2, 'b', 60);
insert into migum_school values(5, 'c', 80);
insert into migum_school values(7, 'd', 38);
insert into migum_school values(10, 'f', 39);

insert into bundang_school values(2, 'add1', '010', '수');
insert into bundang_school values(7, 'add2', '011', '우');
insert into bundang_school values(12, 'add3', '017', '미');
insert into bundang_school values(14, 'add4', '018', '양');
insert into bundang_school values(17, 'add5', '019', '가');

-- B와 M 으로 바꿈으로써 간결하게 코드 리팩토링
select B.ban, address, phone from migum_school M
	right join bundang_school B
		on M.ban = B.ban;

-- from 뒤에 테이블을 객체처럼 선언해놓고, 멤버를 가져오는것 처럼 접근해서 select
select b.groupname, b.price, b.userid, m.mdate from buytbl b, usertbl m;

select usertbl.userid as 'usertbl의 userid' , name, prodname, addr, mobile1+mobile2 as '연락처'
	from buytbl
		inner join usertbl
			on buytbl.userid = usertbl.userid
				order by num;
                
select u.userid, u.name, u.addr from usertbl u
	where exists (
		select * from buytbl B
			where U.userid = b.userid);
	
select distinct u.userid, u.name, u.addr
	from usertbl u
		inner join buytbl b
			on u.userid = b.userid
				order by u.userid;