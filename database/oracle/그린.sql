-- 1) professor 예제
create table professor( -- professor라는 이름으로 table을 생성해라
    prono number(4) primary key, -- primary key : 고유하다 (중복이 허용 안됨)
    name varchar2(60) not null,   -- not nul : null 값을 허용하지 않는다. * 오라클에서는 varchar2을 쓴다. char형임.
    id varchar2(15) not null,
    position varchar2(30) not null,
    pay number(3) not null,
    hiredate date not null,     -- date : 날짜 타입
    bonus number(4),             -- not null이 없으면, 입력을 하지 않아도 된다.
    deptno number(3),
    email varchar2(50),
    hpage varchar2(50)
);
-- 대소문자 구분하지 않음
insert into professor
values(1001,'Audie Murphy','Murphy','a full professor',550,to_date('1980-06-23','YYYY-MM-DD'),100,101,'captain@abc.net','http://www.abc.net');
insert into professor
values(1002,'Angela Bassett','Bassett','assistant professor',380,to_date('1987-01-30','YYYY-MM-DD'),60,101,'sweety@abc.net','http://www.abc.net');
insert into professor
values (1003,'Jessica Lange','Lange','instructor',270,to_date('1998-03-22','YYYY-MM-DD'),null,101,'pman@power.com','http://www.power.com');
insert into professor
values (2001,'Winona Ryder','Ryder','instructor',250,to_date('2001-09-01','YYYY-MM-DD'),null,102,'lamb1@hamail.net',null);
insert into professor
values (2002,'Michelle Pfeiffer','Pfeiffer','assistant professor',350,to_date('1985-11-30','YYYY-MM-DD'),80,102,'number1@naver.com','http://num1.naver.com');
insert into professor
values (2003,'Whoopi Goldberg','Goldberg','a full professor',490,to_date('1982-04-29','YYYY-MM-DD'),90,102,'bdragon@naver.com',null);
insert into professor
values (3001,'Emma Thompson','Thompson','a full professor',530,to_date('1981-10-23','YYYY-MM-DD'),110,103,'angel1004@hanmir.com',null);
insert into professor
values (3002,'Julia Roberts','Roberts','assistant professor',330,to_date('1997-07-01','YYYY-MM-DD'),50,103,'naone10@empal.com',null);
insert into professor
values (3003,'Sharon Stone','Stone','instructor',290,to_date('2002-02-24','YYYY-MM-DD'),null,103,'only_u@abc.com',null);
insert into professor
values (4001,'Meryl Streep','Streep','a full professor',570,to_date('1981-10-23','YYYY-MM-DD'),130,201,'chebin@daum.net',null);
insert into professor
values (4002,'Susan Sarandon','Sarandon','assistant professor',330,to_date('2009-08-30','YYYY-MM-DD'),null,201,'gogogo@def.com',null);
insert into professor
values (4003,'Nicole Kidman','Kidman','assistant professor',310,to_date('1999-12-01','YYYY-MM-DD'),50,202,'mypride@hanmail.net',null);
insert into professor
values (4004,'Holly Hunter','Hunter','instructor',260,to_date('2009-01-28','YYYY-MM-DD'),null,202,'ironman@naver.com',null);
insert into professor
values (4005,'Meg Ryan','Ryan','a full professor',500,to_date('1985-09-18','YYYY-MM-DD'),80,203,'standkang@naver.com',null);
insert into professor 
values (4006,'Andie Macdowell','Macdowell','instructor',220,to_date('2010-06-28','YYYY-MM-DD'),null,301,'napeople@jass.com',null);
insert into professor
values (4007,'Jodie Foster','Foster','assistant professor',290,to_date('2001-05-23','YYYY-MM-DD'),30,301,'silver-her@daum.net',null);

commit; 
select * from professor;
desc professor;

select count(position) from professor;  -- 갯수 가져오기
select distinct position from professor;   -- 중복 제거 후 가져오기
select position "직위" from professor;    -- position -> 직위  변경 후 가져오기
-- 문제 2) id를 "아이디"로 position은 "직책" pay는 "임금" hiredate는 "고용일"
-- bonus는 "보너스", deptno는 "부서번호", email은 "이메일", hpage는 "페이지"로 칼럼명 변경 후 출력하세요
select position "직위" from professor;
select id "아이디" from professor;
select pay "임금" from professor;
select hiredate "고용일" from professor;
select bonus "보너스" from professor;
select deptno "부서번호" from professor;
select email "이메일" from professor;
select hpage "페이지" from professor;
 
 
 -- 2) department 예제1
 create table department(
    DEPT_ID varchar2(10) not null,
    dept_name varchar2(25) null,
    dept_tel varchar2(12) null
);

desc department;    -- describe 의 약자. 테이블의 구조를 보여다오

drop table department;

insert into department values('green', '컴퓨터 공학과', '010');
commit;
select * from department;   
insert into department (dept_id) values('a');   -- 특정 columm에만 데이터를 삽입
insert into department (dept_name) values('b'); -- dept_id는 null이면 안되므로, 에러 발생
INSERT INTO department (dept_id, dept_name) values('a','b');
drop table department;

-- 오라클은 데이터베이스 적용시 commit을 마지막에 꼭 해줘야 한다.
-- 오타로 테이블 생성이 잘못되었으면 아래의 명령으로 삭제
-- drop table [TABLE_NAME]




-- 3) department 예제2
create table department(
    dept_id varchar2(10),
    dept_name varchar2(25),
    dept_tel varchar2(12),
    constraint department_pk primary key (dept_id)
);    
-- 위에서 정의한 dept_id를 고유한 key(primary)로 제약조건(constraint)을 설정하여 테이블을 생성 (제약조건명(department_pk))
-- 그러면 dept_id를 중복해서 넣으면 안됩니다.
insert into department values('kim', 'seungcheol', '01090374099');
insert into department values('park', 'namhoon', '01090374455');
select * from department;
commit;
    
    


-- 4) student 예제
create table student(
    dept_id varchar2(10),
    year varchar2(10),
    student_id varchar2(7),
    name varchar2(20) not null,
    id_number varchar2(14) not null,
    address varchar2(10),
    constraint student_pk primary key (student_id),
    constraint student_dept_id foreign key (dept_id) references department(dept_id)
    );
-- 부모 테이블(department)의 primary key를 자식 테이블(student)와 연결하기 위해 외래키를 사용할 것인데,
-- 외래키 (foreign key)로 서로 연결하기 위해 부모테이블(department)의 primary key(dept_id)를
-- 참조(references)하고 있음
-- 자식 테이블에서 부모 테이블의 primary key에 해당하는 dept_id에 없는 값을 추가시 오류 발생함
drop table student;
    
insert into student values('kim', '2022', 'id1', 'Fekim', 'number1', 'address1');   -- 1) 잘 들어가는 data
insert into student values('park', '2023', 'id2', 'Fekim1', 'number2', 'address12'); -- 2) foreign key를 test하기위해 parent에 존재하지 않는 key를 dept_id에 넣어봄
insert into student values('kim', '2023', 'id2', 'Fekim3', 'number3', 'address13'); -- 3) constraint key를 test하기위해 id를 중복으로 삽입해봄
select * from department;    
select * from student;
    
-- 고객 테이블과 고객이 구매한 테이블 관계를 생각하면,
-- * 고객 정보가 있는데 그 고객이 여러번 구매할 수도 있고,
-- * 구매하지 않을수도 있죠 (유령고객), 자주 구매하면 우수고객인거죠
-- * 데이터 삭제 : delete from [TABLE_NAME] where 절(레코드(행)) 
-- * 삭제는 아직 안 배웠으니 그냥 테이블 삭제 후 다시 데이터 추가.
-- * 칼럼명에 not null을 지정하지 않으면, default가 null이고, primary key는 null일 수 없다.

insert into student(student_id, dept_id, name, id_number) 
values('홍말', 'b', '김개똥', 'abc');



-- 5) 간단한 primary, foreign key 예제

-- 부모 table
create table ttt(
green number(3) primary key,
red varchar2(30)
);
drop table ttt;

-- 자식 table
create table ppp (
green_child varchar2(10),
red_id number(3) primary key,
red varchar2(20),
constraint ppp_pk foreign key (red_id) references ttt(green)
);
drop table ppp;

insert into ppp(red_id,red) values(7, '빨강색');

select * from ttt;
select * from ppp;


-- 6) professor 예제2
drop table professor;
create table professor(
    professor_ID varchar2(3) primary key,
    name varchar2(20) not null,
    position varchar(10) not null constraint professor_ck check(position in ('교수', '부교수', '조교수', '초빙교수')),
    dept_id constraint professor_fk references department (dept_id)
);
-- check도 제약 조건입니다. 제약조건의 이름이 professor_ck 이고
-- 거기에 입력되는 데이터는 '교수', '부교수', '조교수', '초빙교수' 이중 하나만 추가할수 있어요
-- 제약조건 : primary key, foreign key, check, not null
-- 테이블의 구조변경(alter), 변경은 alter가 있고 update가 있습니다.
-- alter는 테이블의 구조를 변경하는 것이고 updae는 데이터(레코드/행)의 수정
-- 우리가 맨날 하는것은 CRUD(Create, Read, Update, Delete)
alter table professor
    add (email varchar2(60),
        duty varchar2(10),
        Mgr varchar2(3)
        );
desc professor;

-- 문제 1) 데이터를 추가하세요
select * from department;
insert into professor values('id1', 'name1', '교수', 'kim', 'email1', 'duty1', 'Mg1');
select * from professor;


