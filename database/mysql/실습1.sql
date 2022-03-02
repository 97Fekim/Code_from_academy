create table table1(
	name varchar(10)
);
insert into table1 values("Fekim");
select * from table1;
drop table table1;

-- 예제1) 회원 테이블 생성
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



-- 예제2) where 절 (조건문)
-- and, or, between, in
select userid, name from usertbl where birthyear >= 1970 and height >= 182;
select userid, name from usertbl where birthyear >= 1970 or height >= 182;
select name, height from usertbl where height >= 180 or height >= 183;
select name, height from usertbl where height between 180 and 183;
select name, addr from usertbl where addr='경남' or addr='전남' or addr='경북';
select name, addr from usertbl where addr in('경남', '전남', '경북');

-- 문제 1) buytbl에서 amount가 1보다 크거나 같고, 5보다 같거나 작은 데이터의 userid와 prodname을 출력
-- 출력 --> 두가지 버전 (1. between, 2. and)
select userid, prodname from buytbl where amount between 1 and 5;
select userid, prodname from buytbl where amount <= 5 and amount >= 1;
-- 문제 2) buybtl에서 groupname 에서 전자 의류 중의 하나인 것들의 amount 출력
select amount from buytbl where groupname='전자' or groupname='의류';
select amount from buytbl where groupname in ('전자', '의류');

-- like 구문
select * from usertbl;
select name, height from usertbl where name like '김%';	-- 유사하다 라는 뜻

-- 문제 3) mobile1이 1로 끝나는 이름과 키를 다오
select name, height from usertbl where mobile1 like '%1';
select name, height from usertbl where name like '_종신';

-- 문제 4) userid가 'k'로 끝나는 이름과 키를 조회하세요
select name, height from usertbl where userid like'__k';

select name, height from usertbl where height > 177;
select height from usertbl where name='김경호';
select name, height from usertbl
	where height > any (select height from usertbl where (name='김경호' or name='은지원'));
	-- 김경호보다 키가 큰 사람을 선택
    -- quert 안에 query가 있습니다.
    -- 안에 있는 query를 sub query라고 합니다.
	-- all은 만족하는 모든 데이터
    -- any는 하나라도 만족하는 모든 데이터

-- all, any 예제
select count(name), name, height from usertbl
	where height >= any (select height from usertbl where addr = '경남');
select count(name), name, height from usertbl
	where height >= all (select height from usertbl where addr = '경남');
select count(name), name, height from usertbl
	where height < any (select height from usertbl where addr = '경남');
select count(name), name, height from usertbl
	where height < all (select height from usertbl where addr = '경남');
    
select name, mDate from usertbl order by mDate asc;	-- mDate(날짜)로 정렬, 기본값은 오름차순
select name, mDate from usertbl order by mDate desc;-- 내림차순 (descending의 약자)

select name, mDate from usertbl order by name asc;
select name, mDate from usertbl order by name desc;

-- 동일한 키가 있을경우 이름을 기준으로 정렬함
select name, height from usertbl order by height desc, name asc;

-- 중복제거
select distinct addr from usertbl;
select * from usertbl limit 3;

-- 문제 8) buytbl에서 amount의 수량이 많은 우수 고객 3명을 출력함
select userid, price*amount as 'total' from buytbl order by price * amount desc limit 3;
select price * amount from buytbl;

create table newtbl (select * from usertbl);
-- 문제 9) userid name add mobile1을 이용하여 새로운 테이블 생성함
create table newtbl2 (select userid, name, addr, mobile1 from usertbl);

-- 문제 10) 수량과 금액을 곱한 결과가 800 이상인 것만 이용하여 새로운 테이블 생성
create table newtbl3 (select * from buytbl where amount * price >= 800);

select * from newtbl3;
select * from buytbl;

-- group by : userid가 1,1,2,2,3,1,4,1,2,3,2 이렇게 있다고 하면
-- 1,2,3,4에 대해서 따로 가져온다.
select userid, sum(amount) from buytbl group by userid;

-- 문제 11) groupname 별 amount의 총합 구하기
select sum(amount) from buytbl group by groupname;

-- 문제 12) groupname 별 price의 평균 구하기
select avg(price) from buytbl group by groupname;

-- 문제 13) amount 별 prodname 갯수 구하기
select count(prodname) from buytbl group by amount;

-- 보안을 위해서도, columm 명을 바꾼다.
select userid, avg(amount) '평균 구매 개수' from buytbl group by userid;
select name , max(height), min(height) from usertbl group by name;

-- 서브쿼리와 조합
select name, height from usertbl
	where height = (select max(height) from usertbl)
		or height = (select min(height) from usertbl);
-- 가장 큰 키와 가장 작은 키의 회원 이름과 키를 출력하기.
-- 휴대폰이 있는 사용자
select count(mobile1) as '휴대폰이 있는 사용자' from usertbl; -- null은 제외됨
select count(*) as '휴대폰이 있는 사용자' from usertbl;	-- mobile1은 3개의 null 있음

-- having 절
select userid as '사용자', sum(price * amount) as '총구매액' from buytbl
	group by userid;
	-- 총 구매액이 1000이상인 사용자에게만 사은품을 증정하고 싶다면 where 문을 생각할 수 있지만
    -- 집계함수는 where절에 들어갈 수 없습니다.

select userid '사용자', sum(price * amount) as '총 구매액' from buytbl
	where sum(price * amount) > 1000 group by userid;
    -- group 함수에서 유효하지 않은 구문, having절을 이용해야함
    
select userid '사용자', sum(price * amount) as '총 구매액' from buytbl
	group by userid
    having sum(price * amount) > 1000
    order by sum(price * amount) desc
    limit 1;
	-- group by 에서 where절에 집계함수를 사용할 수 없고, having을 group by 한 다음에 사용함

create table testtable2(
	id int auto_increment primary key,
	username char(3), 
	age int);

insert into testtable2 values(null, '지민', 25);
insert into testtable2 values(null, '유나', 22);
insert into testtable2 values(null, '유경', 21);
insert into testtable2 (username, age) values('미금', 121);
select * from testtable2;

-- 문제 14) 테이블 생성 testtable3
-- 칼럼명 (정수 green, 문자열 red, id(primary key auto_increment)
-- red는 null값 허용되고 green은 null 허용되지 않음
-- 데이터를 red에 null인 경우와 아닌경우를 섞어서 추가하고
-- red가 null이 아닌 경우의 갯수를 출력하고
create table testtable3(
	green int not null,
    red varchar(5),
    id int primary key auto_increment
);

insert into testtable3 values (1, 'a', 2);
insert into testtable3(green, id) values (10,20);
insert into testtable3 values (100,'b',200);
insert into testtable3(green, id) values (1000,2000);

select count(red) from testtable3;
select count(red) from testtable3 group by green;
select count(red), green from testtable3 group by green;



-- update!! 
select * from usertbl;
update usertbl set name='김개똥' where name = '바비킴';
set sql_safe_updates=0;

-- 문제 17) 키가 170 이상인 사람의 이름을 홍말자로 변경하세요
update usertbl set name='홍말자' where height >= 170;
select * from usertbl;

-- 문제 18) 지금 변경된 데이터를 이전 이름으로 update를 이용하여 수정하세요
update usertbl set name='바비킴' where userid='BBK';
update usertbl set name='은지원' where userid='EJW';
update usertbl set name='조관우' where userid='JKW';
update usertbl set name='김범수' where userid='KBS';
update usertbl set name='김경호' where userid='KKH';
update usertbl set name='이승기' where userid='LSG';
update usertbl set name='성시경' where userid='SSK';
update usertbl set name='윤종신' where userid='YJS';

delete from usertbl where height >= 180;
select * from usertbl;
delete from usertbl where name = '윤종신';

-- 변수 사용
set @myVar1 = 5;
set @myVar2 = 3;
set @myVar3 = 4.25;
set @myVar4 = '가수 이름 ==> ';
select @myVar1;
select @myVar2 + @myVar3;

-- casting 안할 시 2.9xxxx으로 출력
select avg(amount) as '평균 구매 개수' from buytbl;
-- casting 할 시 3으로 출력
select cast(avg(amount) as signed integer) as '평균 구매 개수' from buytbl;

-- signed(부호가 있는), unsigned(부호가 없는, 양의정수)
select cast(5.45 as signed int);
select cast(-5.45 as unsigned int);
select convert(avg(amount), signed int) as '평균 구매 개수' from buytbl;
select cast('2020$12$12' as date);	-- 문자열을 날짜로 변환
select cast('2020/12/12' as date);	-- 뭐가 가운데에 있던 날짜로 변환
select cast('2020%12%12' as date);
select cast('2020@12@12' as date);
create table t (u int);
insert into t values(5);
insert into t values(3);
insert into t values(4);
insert into t values(15);
insert into t values(52);
select avg(u) from t;

select num , concat(cast(price as char(10)), 'X', CAST(amount as char(4)), '=')
	as '단가X수량', price*amount as '구매액' from buytbl;

select concat('그린', '컴퓨터', '입니다');
select '100' + '200';	-- 문자와 문자를 더함, (정수로 변환되어 처리됨)
select concat('100', '200');
select concat(100, '200'); -- 정수와 문자를 연결 (정수가 문자로 변환되어 처리)
select 1 > '2mege';	-- 정수인 2로 변환되어 비교
select 3 > '2MEGA';	-- 정수인 2로 변환되어 비교
select 0 = 'mega2';	-- 문자는 0으로 변환됨
select true;
select if(100>200, '참이다','거짓이다');	-- 첫번째가 참이면 두번째 반환, 첫번째가 거짓이면 세번째 반환
select ifnull(null, '널이군요'), ifnull(100, '널이군요');	-- 값이 없으면 오른쪽 출력, 있으면 값 출력
select 7 = '5aaa';
select case 5
	when 1 then '일'
    when 5 then '오'
    when 10 then '십'
    else 모름
    end as 'case 연습';

set @score = 80;
select case @score
	when 100 then '수'
	when 80 then '우'
    when 60 then '미'
    else '가'
    end as 'case 종료';