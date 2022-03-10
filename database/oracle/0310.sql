-- 문제 1) course 테이블에서 과목 코드(course_id...
 select course_id, title, c_number, c_number*30000+NVL(course_fees,0) as fee
    from course order by fee asc, course_id desc;
select * from course;

-- 문제 2)
select name from professor where dept_id='컴공';

-- 문제 3)
select title from course where course_fees >= 30000 order by course_fees desc;

-- 문제 4)
select dept_id, year, name from student
    where (dept_id, year) = (('컴공','2'));
    
-- 문제 5) 
select dept_id, year, name from student where (dept_id, year) = (('컴공','2'));

-- 문제 6)
select * from professor;
select professor_id, name, telephone from professor order by mgr;

-- 문제 7)
select name from student where name like '이%';

-- 문제 8)
select name from student where name like '%정%';

-- 문제 9)
select name from student where name not like '김%' and name not like '이%';

-- 문제 10)
select name from professor where dept_id in ('컴공') or dept_id in ('정통');

-- 문제 11)
select name from professor 
    where dept_id not in '컴공' or dept_id not in '정통'
        order by mgr;

-- 문제 12)
select score from sg_scores where score >= 90 and score<= 94 order by score desc;

-- 문제 13)
select score from sg_scores where score<60 or score>100 order by score;

select * from course where course_fees is null order by title;
select rownum, dept_id, dept_name, dept_tel from department;
select rownum, dept_id, dept_name, dept_tel from department where rownum <= 3;
select score, to_char(score, 'S999'), to_char(-score, 'S999'), to_char(score, 'B9999.9'), to_char(score,'0099.99')
    from sg_scores where score >= 98 order by 1 desc;
select course_fees, to_char(course_fees, 'L999G999') "국가별 화폐", to_char(course_fees, 'C999G999') "ISO 화폐" from course
    where course_fees = 20000;
select to_char(10000000, 'L999G999G999') from DUAL;
select count(*) from student;
select stddev(score), variance(score) from sg_scores where course_id = 'L1031'; -- stddev (표준편차), variance (분산)

select dept_id from professor group by dept_id having count(*) = 1;
select dept_id from professor;
-- 문제 16) 위의 코드와 동일한 결과를 출력하세요


-- 문제 17) sg_scores 테이블에서 학번별의 8과목 이상을 취득한 학번의 과목수와 평균을 학번순으로 출력하세요
select student_id, count(*), avg(score) from sg_scores group by student_id having count(*) > 2;

create table scoretbl(
    id number(10) primary key,
    name varchar2(20)
    );
    
create sequence seq_score;
insert into scoretbl values(seq_score.nextval, '홍길동1');
select * from scoretbl;

