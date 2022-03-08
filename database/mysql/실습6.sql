 --   뷰란 무엇인가 ? 
 -- 뷰는  일반 사용자 입장에서는 테이블과 동일하게 사용하는 객체 
 -- 뷰는 한번 생성해 놓으면 테이블이라고 생각해도 될 정도로 사용자 입장에서는 테이블과 거의 동일
 -- 뷰의 장점
 -- 보안에 도움이 된다 
 -- 사용자의 중요한 개인정보인 출생년도 , 연락처 , 키 가입일등을 노출하면 안됨 
 -- 아르바이트 생에게 중요 개인 정보를 보게 하면 안됨 
 -- 복잡한 쿼리를 단순화 시켜줄수 있다 
 create database tabledb;
 use tabledb;
 
 CREATE TABLE usertbl -- 회원 테이블
( userID  	CHAR(8) NOT NULL PRIMARY KEY, -- 사용자 아이디(PK)
  name    	VARCHAR(10) NOT NULL, -- 이름
  birthYear   INT NOT NULL,  -- 출생년도
  addr	  	CHAR(2) NOT NULL, -- 지역(경기,서울,경남 식으로 2글자만입력)
  mobile1	CHAR(3), -- 휴대폰의 국번(011, 016, 017, 018, 019, 010 등)
  mobile2	CHAR(8), -- 휴대폰의 나머지 전화번호(하이픈제외)
  height    	SMALLINT,  -- 키
  mDate    	DATE  -- 회원 가입일
);
CREATE TABLE buytbl -- 회원 구매 테이블(Buy Table의 약자)
(  num 		INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
   userID  	CHAR(8) NOT NULL, -- 아이디(FK)
   prodName 	CHAR(6) NOT NULL, --  물품명
   groupName 	CHAR(4)  , -- 분류
   price     	INT  NOT NULL, -- 단가
   amount    	SMALLINT  NOT NULL, -- 수량
   FOREIGN KEY (userID) REFERENCES usertbl(userID)
);
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
create view v_userbuytbl
	AS 
select U.userid as 'user id', U.name as 'USER NAME' ,
        B.prodName as 'product name' , U.addr ,
        concat(U.mobile1, U.mobile2) as 'MOBILE PHONE'
			from usertbl U
				inner join buytbl B
                 ON u.userid =B.userid;

desc v_userbuytbl;
create view v_usertbl
	as 
		select userid, name,addr from usertbl;
select * from v_usertbl;
drop view v_userbuytbl;
create view v_userbuytbl 
	as 
		select U.userid, U.name  ,
				B.prodName , U.addr ,
				concat(U.mobile1, U.mobile2) as '연락처'
					from usertbl U
						inner join buytbl B
						 ON u.userid =B.userid;
select * from v_userbuytbl where name='김범수';
drop view v_userbuytbl;
create view v_userbuytbl 
	as 
		select U.userid '사용자 아이디', U.name '이름'  ,
				B.prodName '제품 이름'   , U.addr ,
				concat(U.mobile1, U.mobile2) as '전화 번호'
					from usertbl U
						inner join buytbl B
						 ON u.userid =B.userid;
select `사용자 아이디`,`전화 번호` from v_userbuytbl; -- backtick 사용 



describe v_userbuytbl; 
create or replace view v_usertbl 
as 
	select userid ,name ,addr ,birthYear from usertbl;
    
update v_usertbl set addr ='제주' where userid ='JKW';
select * from v_usertbl; -- 수정을 하면 table 도 변경됨 
select * from usertbl;

--  create (생성 ) ,alter는 테이블의 구조 변경 
--   update(데이터 수정) 는 테이블의 데이터를 변경 
insert into v_usertbl values('KBM','김병만','충북' ,'20221101');
-- 추가해 보세요 (문제 40) 
desc v_usertbl;
select * from v_usertbl;
select * from usertbl;
desc usertbl;
create view v_sum
	as
		select userid as 'userid',sum(price* amount) as 'total'
			from buytbl group by userid;
select * from v_sum;
select * from information_schema.views 
	where table_Schema ='tabledb' and table_name ='v_sum'; -- mysql 에 information_schema에 있
    
create table a ( b int );
select * from information_schema.tables 
	where table_Schema ='tabledb' and table_name ='a';
select * from information_schema.views 
	where table_Schema ='tabledb' and table_name ='v_userbuytbl';
create view v_height177
	as 
		select * from usertbl where height >=177;
select * from v_height177;
insert into v_height177 values('KBT','김병만',1977,'경기','010','5555555',158,'2023-01-01');	
-- 이것은 논리적 오류가 있어요  키가 177 이상을 넣고자하는데 158 이 들어갔어요 
alter view v_height177
	as 
    select * from usertbl where height>=177
		with check option;
        -- chckk option으로 논리적 오류가 발생하지 않도록 입력 불가 
insert into v_height177 values('KBT','김병만',1977,'경기','010','5555555',158,'2023-01-01');	
-- view 생성  v_year2000 생성,  2000 이상만 입력되도록 view 설계 
		-- 효준 정현 현재 경철 유민 연진 승우 은성 태성 정국 민기 상욱 성빈 범석
create view v_year2000
	as
		select * from usertbl where birthYear>=2000
        with check option;
insert into v_height177 values('KBb','김병만',1991,'경기','010','5555555',199,'2023-01-01');	
drop procedure if exists userProc1;
delimiter $$
create procedure userproc1(in userName varchar(10))
begin
	select * from usertbl where name =username;
end $$
delimiter ;
call userProc1('조관우');
drop procedure if exists userproc2;
delimiter $$
create procedure userproc2(
	in userBirth int,
	in userHeight int
)
begin
	select * from usertbl
		where birthYear >userBirth and height > userHeight;
end $$
delimiter ;
call userProc2(1970,178);
drop table testtbl;
create table testTbl ( id int auto_increment primary key , txt char(10));
drop procedure if exists userproc3;
delimiter $$
create procedure userProc3(
	in txtValue char(10),
    out outValue int
)
begin
	insert into testTbl values (null, txtValue);
    select max(id) into outValue from testTbl;
end $$
delimiter ;
call userProc3('테스트 값', @myValue); --  여기 호출시  두번째 매개변수는 out으로 62번의 out과 
-- 66번 라인의 into 다음의 outValue와 연결되어 있음 ,select 구문에서 가져온 데이터는  outValue에 저장됨 
select concat('현재 입력된 id값 ==> ' ,@myValue);
-- 마지막 문제 ) 프로시저와 테이블 생성하여 숫자를 입력하면 테이블에 구구단이 저장 되도록 하세요 
	
create table gugutbl (
	id int auto_increment primary key, txt char(200)
	);
    
drop procedure if exists guguproc;
delimiter $$
create procedure guguproc(
	in guguin int,
    out guguout varchar(200)
)
begin
	declare i int;
    declare gugumerge varchar(200);
    set i = 0;
    set gugumerge = '';
    while(i<10) do
		set gugumerge = concat(gugumerge, guguin, '*', i, '=',guguin*i,'\n');
        set i = i+1;
    end while;
		insert into gugutbl values (null, gugumerge);
        select txt into guguout from gugutbl order by id desc limit 1;
end $$
delimiter ;
call guguproc(7,@myval);
select * from gugutbl;
select @myval;


drop procedure if exists caseproc;
delimiter $$
create procedure caseproc(
	in username varchar(10)
)
begin
	declare byear int;
    declare tti char(3);
    select birthyear into byear from usertbl
		where name = username;
	case
		when (byear%12 = 0) then set tti= '원숭이';
        when (byear%12 = 1) then set tti= '닭';
        when (byear%12 = 2) then set tti= '개';
        when (byear%12 = 3) then set tti= '돼지';
        when (byear%12 = 4) then set tti= '쥐';
        when (byear%12 = 5) then set tti= '소';
        when (byear%12 = 6) then set tti= '호랑이';
        when (byear%12 = 7) then set tti= '토끼';
        when (byear%12 = 8) then set tti= '용';
        when (byear%12 = 9) then set tti= '뱀';
        when (byear%12 = 10) then set tti= '말';
        else set tti= '양';
	end case;
    select concat(username, '의 띠 ==> ', tti);
end $$
delimiter ;
call caseproc('이승기');

use tabledb;
drop function if exists getAgeFunc;
delimiter $$
create function getagefunc(byear int) returns int
begin
	declare age int;
    set age = year(curdate()) - byear;
    return age;
end $$
delimiter ;

select getagefunc(1979);
SET GLOBAL log_bin_trust_function_creators = 1;
select curdate(), now();
select userid, name, getagefunc(birthyear) as '만 나이' from usertbl;

drop function if exists userfunc;
delimiter $$
	create function userfunc(value1 int, value2 int)
		returns int
	begin return value1 + value2;        
end $$
delimiter ;

select userfunc(100,200);

-- /* 커서 */
-- mysql은 stored procedure 내부에 cursor를 사용할 수 있음
-- 커서는 일반 프로그래밍 언어에서의 파일 처리와 방법이 비슷하기 때문에 행을 집합을 다루기에 편리한 기능
-- 자바에서 JDBC(JAVA Database Connection)
-- 1) 파일을 연다(open), 그러면 파일 포인터는 파일의 제일 시작점을 가리키게 된다.
-- 2) 처음 데이터를 읽는다. 그러면 이승기의 데이터가 읽히고, 파일포인터는 다음 레코드인 '김범수'로 이동함
-- 3) 파일의 끝(End of File)까지 반복
		-- 3-1) 읽은 데이터 처리
        -- 3-2) 현재의 파일 포인터가 가리키는 데이터를 읽는다, 파일포인터는 자동으로 다음으로 이동함.
-- 4) 파일을 닫는다.
-- cursor 열기, cursor에서 데이터 가져오기(fetch), 데이터 처리, cursor 닫기

drop procedure if exists cursorProc;
delimiter $$
create procedure cursorproc()
begin
	declare userHeight int;		-- 고객의 키
    declare cnt int default 0; 	-- 고객의 인원수 (= 읽은 행의 수)
    declare totalHeight int default 0;	-- 키의 합계
    declare endOfRow boolean default false;	-- 행의 끝부분(기본을 false)
    declare userCursor cursor for 
		select height from usertbl;
	declare continue handler
		for not found set endOfRow = true;
    open userCursor;
    
    cursor_loop:loop
		fetch userCursor into userHeight;
    
		if endOfRow then
			leave cursor_loop;
		end if;
		
		set cnt = cnt + 1;
		set totalHeight = totalHeight + userHeight;
	end loop cursor_loop;
    
    select concat('고객 키의 평균 ==> ', (totalHeight/cnt));
    close userCursor;	-- 커서 닫기
end $$
delimiter ;

set sql_safe_updates=0;
delete from usertbl where height is null;
call cursorproc();
-- ResultSet(java에서 JDBC에서 select를 하면 resultset에 가져온 데이터가 들어가 있음)
-- 에 데이터를 데이터베이스에서 준다.

select * from usertbl;
set sql_safe_updates=0;
delete from usertbl where height is null;
alter table usertbl add grade varchar(5);
drop procedure if exists gradeproc;
delimiter $$
create procedure gradeproc()
begin
	declare id varchar(10);	-- 사용자 아이디를 저장할 변수
    declare hap bigint;		-- 총 구매액을 저장할 변수
	declare usergrade char(5);
	declare endofrow boolean default false;
    
    declare usercursor cursor for 		-- 커서 선언
		select u.userid, sum(price*amount)
			from buytbl b
				right outer join usertbl u
					on b.userid = u.userid
						group by u.userid, u.name having total is null;
                        
	declare continue handler for
		not found set endOfRow = true;
	open userCursor;
    grade_loop:loop
		fetch userCursor into id, hap;	-- 첫 행값을 대입
        if endofrow then
			leave grade_loop;
		end if;
        case
			when (hap>=1500) then set usergrade = '최우수고객';
            when (hap>=1000) then set usergrade = '우수고객';
            when (hap>=1) then set usergrade = '일반고객';
            else set usergrade = '유령고객';
		end case;
		update usertbl set grade = usergrade where userid = id;
    end loop grade_loop;
    close usercursor;
end $$
delimiter ;
call gradeproc();
select grade from usertbl;

-- 트리거
create database if not exists testdb;
use testdb;
create table if not exists testtbl(id int, txt varchar(10));
insert into testtbl values(1,'레드벨벳');
insert into testtbl values(2,'잇지');
insert into testtbl values(3,'블랙핑크');

drop trigger if exists testTrg;
delimiter $$
create trigger testTrg	-- 트리거 이름
	after delete -- 삭제 후에 작동하도록 지정
	on testtbl	 -- 트리거를 부착할 테이블
    for each row -- 각 행마다 적용시킴
begin
	set @msg = '가수 이름이 삭제됨';	-- 트리거 실행시 작동되는 코드들
end $$
delimiter ;
set @msg = '';
insert into testtbl values(4,'마마무');
select @msg;
update testtbl set txt = '블핑' where id = 3;
select @msg;
delete from testtbl where id = 4;
select @msg;

drop trigger if exists updateTrig;
delimiter $$
create trigger updateTrig	-- 트리거 이름
	after update -- 삭제 후에 작동하도록 지정
	on testtbl	 -- 트리거를 부착할 테이블
    for each row -- 각 행마다 적용시킴
begin
	set @msg = '가수 이름이 변경됨';	-- 트리거 실행시 작동되는 코드들
end $$
delimiter ;
set @msg = '';
insert into testtbl values(4,'마마무');
select @msg;
update testtbl set txt = '블핑' where id = 3;
select @msg;

use testdb;
create table backup_usertbl(
	userid char(8) not null,
    name varchar(10) not null,
    birthyear int not null,
    addr char(2) not null,
    mobile1 char(3),
    mobile2 char(8),
    height smallint,
    mDate date,
    modtype char(2),
    moddate date,
    moduser varchar(256)
);

 
delimiter $$
create trigger backupusertbl_updatetrg
	after update
	on usertbl
    for each row
begin
	insert into backup_usertbl values(old.userid, old.name, old.birthyear
    , old.addr, old.mobile1, old.mobile2, old.height, old.mDate , '수정',
    curdate(), current_user());
end $$
delimiter ;
update usertbl set addr='ad' where userid = 'JKW';
select * from backup_usertbl;
select * from usertbl;

delimiter $$
create trigger backupusertbl_deletetrg
	after delete
	on usertbl
    for each row
begin
	insert into backup_usertbl values(old.userid, old.name, old.birthyear
    , old.addr, old.mobile1, old.mobile2, old.height, old.mDate , '삭제',
    curdate(), current_user());
end $$
delimiter ;

delete from usertbl where userid='JKW';
select * from backup_usertbl;
drop table backup_usertbl;

create database greendb;
use greendb;
create table ordertbl(
	orderno int auto_increment primary key,
    userid varchar(5),
    prodname varchar(5),
    orderamount int
    );
create table prodtbl(
	prodname varchar(5),
    account int
    );
create table delivertbl(
	deliverno int auto_increment primary key,
    prodname varchar(5),
    account int unique
    );
insert into prodtbl values('사과', 100);
insert into prodtbl values('배', 100);
insert into prodtbl values('귤', 100);

-- 물품 테이블에서 개수를 감소시키는 트리거
drop trigger if exists ordertrg;
delimiter $$
create trigger ordertrg
	after insert
    on ordertbl
    for each row
begin
	update prodtbl set account = account - new.orderamount
		where prodname = new.prodname;
end $$
delimiter ;
-- 배송 테이블에서 새 배송 건을 입력하는 트리거
drop trigger if exists prodtrg;
delimiter $$
create trigger prodtrg
	after update
    on prodtbl
	for each row
begin
	declare orderamount int;
    set orderamount = old.account - new.account;
    insert into delivertbl(prodname, account) values (new.prodname, orderamount);
end $$
delimiter ;
insert into ordertbl values (null, 'JOHN', '배', 5);
select * from ordertbl;
select * from prodtbl;
select * from delivertbl;
show triggers from greendb;
