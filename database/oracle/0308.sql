-- 문제 1) 테이블 생성
create table department(
    dept_id VARCHAR2(10) not null,
    dept_name varchar2(25) not null,
    dept_tel varchar(12) null,
    constraint department_pk primary key (dept_id)
);

-- 문제 2) 테이블 구조 출력
desc department;

-- 문제 3) 테이블에 기본키 제약조건 추가
drop table department;

-- 문제 4)테이블 생성 SG_Scores
create table SG_SCORES(
    student_id varchar2(7),
    course_id varchar2(5),
    score number(3),
    grade varchar2(2),
    score_assignment date,
    constraint sg_scores_pk primary key (student_id, course_id)
);

-- 문제 5) student
create table student(
    dept_id varchar2(2),
    year varchar2(1),
    student_id varchar2(7),
    name varchar2(20) not null,
    id_number varchar2(14) not null,
    address varchar2(40)
    constraint student_pk primary key (student_id),
    constraint student_deptid_fk foreign key (dept_id) references department(dept_id)
    );
-- 문제 6) professor
create table professor(
    professor_id varchar2(3) primary key,
    name varchar2(20) not null,
    position varchar2(10) not null,
    dept_id constraint professor_fk references department,
    telephone varchar(12)
    );

-- 문제 7) course
create table course(
    course_id varchar2(5) primary key,
    title varchar(20),
    c_number number(1) not null
    );
select * from user_objects where object_type = 'TABLE';
select * from all_constraints where table_name = 'COURSE';
desc professor;
alter table professor
    drop constraint professor_ck;
alter table professor
    modify (position varchar2(10) null constraint professor_ck 
        check (position in ('교수', '부교수','조교수','초빙교수')));
-- 테이블의 구조 변경시, 기존 테이블의 칼럼이 있으면 수정(modify), 추가시는 add
alter table professor
    add (email varchar2(60), duty varchar2(10), mgr varchar2(3));

-- 문제 7) 지금 추가한 칼럼 삭제하세요
alter table professor drop column email;
desc professor;

create table regions(
    region_id number generated by default as identity
    start with 5 promary key,
    region_name varchar2(50) not null
    );

create table countries(
    country_id char(2) primary key,
    country_name varchar2(40) not null,
    region_id number
    constraint fk_countries_regions foreign key(region_id)
        references regions(region_id)
        on delete cascade
    );
