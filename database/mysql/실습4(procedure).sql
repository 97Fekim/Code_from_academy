delimiter $$
create procedure ifProc()
begin 
	declare var1 int;	-- var1 변수 선언
    set var1 = 100;		-- 변수에 값 대입
    
    if var1 = 100 then 	-- 만약 var1이 100이라면
		select '100입니다';
	else
		select '100이 아닙니다.';
	end if;
end $$
delimiter ;		-- 여기까지 프로시저 생성
call ifproc();	-- 생성된 프로시저 호출
-- ;는 문장이 끝나는데 프로시저 중간에 ;가 있으면 문장이 끝나는 것으로 앎으로
-- 끝나기 전에 ;를 $$로 대체하고 나중에 ;로 복귀함


-- delimiter 예제2
drop procedure if exists ifproc2;
delimiter $$
create procedure ifproc2()
begin
	declare point int;
    declare credit char(1);
    set point = 77;
    
    if point >= 90 then
		set credit = 'A';
	elseif point >= 80 then
		set credit = 'B';
	elseif point >= 70 then
		set credit = 'C';
    elseif point >= 60 then
		set credit = 'D';
	else
		set credit = 'F';
	end if;
    select concat('취득점수 ===> ', point), concat('학점 ===> ', credit);
end $$
delimiter ;
call ifproc2();


-- delimiter 예제3
drop procedure if exists caseproc;
delimiter $$
create procedure caseproc()
begin
	declare point int;
    declare credit char(1);
    set point = 87;
    case
		when point >= 90 then
			set credit = 'A';
		when point >= 80 then
			set credit = 'B';
		when point >= 70 then
			set credit = 'C';
		when point >= 60 then
			set credit = 'D';
		else
			set credit = 'E';
	end case;
    select concat('취득점수 ===> ', point), concat('학점 ===> ', credit);
end $$
delimiter ;
call caseproc;

select u.userid, u.name, sum(price*amount) as '총구매액',
	case
		when (sum(price*amount) >= 1500) then '최우수고객'
		when (sum(price*amount) >= 1000) then '우수고객'
        when (sum(price*amount) >= 1) then '일반고객'
        else '유령고객'
	end as '고객등급'
    from buytbl B
		right outer join usertbl u
			on b.userid = u.userid
	group by u.userid, u.name
    order by sum(price * amount) desc;
    
-- procedure 예제4
drop procedure if exists whileproc;
delimiter $$
create procedure whileproc()
begin
	declare i int;
	declare hap int;
	set i = 1;
	set hap = 0;
	
	while(i <= 100) do
		set hap = hap + i;
		set i = i + 1;
	end while;
	select hap;
end $$
delimiter ;
call whileproc();

-- 3단 출력
create table result(
	res_string char(10)
);
drop procedure if exists whileproc;
delimiter $$
create procedure whileproc()
begin
	declare i int;
	declare res int;
	set i = 1;
	set res = 1;
	
	while(i <= 9) do
		set res = 3 * i;
        insert into result values(concat('3 * ', i, ' = ', res));
		set i = i + 1;
	end while;
end $$
delimiter ;
call whileproc();
select * from result;

-- 문제8) 테이블 생성 usertbl
create table usertbl2(
	userid char(8) not null ,
    name char(10) not null,
    birthday int not null
);

alter table usertbl2
	add constraint pk_usertbl_userid primary key(userid);
    
create table prodtbl(
	prodcode char(3) not null,
    prodid char(4) not null,
    proddate datetime not null,
    prodcur char(10) null
);

alter table prodtbl
	add constraint pk_prodtbl_prodcode_prodid
	primary key (prodcode, prodid);

insert into prodtbl (prodcode, prodid, proddate) values ('a', '1', now());
create table a(
	num int,
    name varchar(10),
    constraint pk_a primary key (num, name)
);

create table b (
	bit int auto_increment primary key,
    num int,
    name varchar(10),
    foreign key(num, name) references a(num, name)
);

-- 문제 9) 데이터를 추가하세요
insert into a values(10, 'from_a');
insert into a values(100, 'from_b');
insert into a values(1000, 'from_c');

insert into b(num, name) values(5, 'from_a');	-- x impossible
insert into b(num, name) values(10, 'from_a');	-- o possible
insert into b(num, name) values(100, 'from_a'); -- x impossible
insert into b(num, name) values(100, 'from_b'); -- o possible

create table c (
	num int primary key
);
create table d(
	id int primary key,
    num int,
    user varchar(10),
    constraint foreign key (num) references c(num)
);
-- c 테이블에 5개 데이터추가, d에는 7개 이상 추가
insert into c values(1);	
insert into c values(2);
insert into c values(3);
insert into c values(4);
insert into c values(5);

insert into d values(1,1,'aaa');
insert into d values(2,2,'bbb');
insert into d values(3,3,'ccc');
insert into d values(4,4,'ddd');
insert into d values(5,5,'eee');	-- first parameter must be disticted
insert into d values(6,5,'fff');	-- second parameter must be in range(1 ~ 5)
insert into d values(7,5,'ggg');	-- second parameter must be in range(1 ~ 5)

-- 문제9
create table usertbl3(
	userid char(8) not null primary key,
    name char(10) not null,
    birthday int not null
    );
-- 문제10
create table buytbl3(
	num int auto_increment not null primary key,
    userid char(8) not null,
    prodname char(6) not null,
    constraint foreign key (userid) references usertbl3(userid)
	);
    
-- 문제11
alter table buytbl3
	add constraint fk_usertbl_buytbl
	foreign key (userid) references usertbl3(userid);

create table usertbl4(
	userid char(8) not null primary key,
    name varchar(10) not null,
    birthyear int not null,
    email char(30) null unique);
    
create table usertbl5(
	userid char(8) not null primary key,
    name varchar(10) not null,
    birthyear int check(birthyear >= 1900 and birthyear <= 2023),
    mobile char(3) null,
    constraint ck_name check(name is not null));

-- 문제 12) 데이터 추가
insert into usertbl4 values ('id1', 'aaa', 2020, 'naver');
insert into usertbl4 values ('id2', 'bbb', 2021, 'kakao');
insert into usertbl4 values ('id3', 'ccc', 2022, 'google');
insert into usertbl4 values ('id4', 'ddd', 2023, 'amazon');

insert into usertbl5 values('id1', 'aaa', 1950, 010);
insert into usertbl5 values('id2', 'aaa', 1950, 010);
insert into usertbl5 values('id3', 'aaa', 1950, 010);
insert into usertbl5 values('id4', 'aaa', 1950, 010);

-- 문제 13) 테이불 구조 변경, 제약 조건 삭제(drop)
ALTER TABLE usertbl5 drop constraint ck_name; 
desc usertbl5;

select * from usertbl4;
select * from usertbl5;

-- 문제 13) 테이블 생성
-- check 제약 조건 2개 칼럼 설정
-- 키가 160이상이고 180 미만인 check 제약 조건
-- 몸무게가 50이상인 check 제약 조건을 가진 테이블 생성후
-- 데이터 추가시 오류 및 정상 테스트하세요

create table temptbl(
	hei int check (hei >= 160 and hei < 180),
    wei int check (wei >= 50)
);

insert into temptbl values(150, 60);	-- impossible
insert into temptbl values(170, 60);	-- possible
insert into temptbl values(170, 50);	-- possible
insert into temptbl values(150, 80);	-- impossible

create table machine(
	name char(10),
    engine char(10),
	mission char(10),
    frame char(10),
    volt_number int,
    oil_limit int,
    constraint pk_machine primary key (mission, frame)
);

create table car(
	name char(10),
    frame char(10),
	mission char(10),
	engine char(10),
    tire char(10),
    oil_limit int,
    foreign key(mission, frame) references machine(mission, frame)
);

insert into machine values('자동차','독일','영국','독일',1500,100);
insert into machine values('비행기','영국','독일','독일',3000,1000);
insert into machine values('기차','미국','미국','독일',1500,2000);
insert into machine values('오토바이','한국','한국','독일',300,30);
insert into machine values('크레인','일본','일본','독일',1000,200);
select * from machine;

insert into car values('제네시스','독일','독일','독일',4,100);
insert into car values('소나타','독일','한국','독일',4,100);
insert into car values('아반테','독일','미국','독일',4,100);
insert into car values('모닝','독일','미국','독일',4,100);
insert into car values('그랜져','독일','독일','독일',4,100);
select * from car;

select concat(car.name," 기종의 기름 적재량은 ", car.oil_limit," 입니다") as description from car
	inner join machine
		on machine.mission = car.mission;

select c.name from car c where exists(select * from machine);
     
        
        
        