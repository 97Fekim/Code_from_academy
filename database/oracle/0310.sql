-- ���� 1) course ���̺��� ���� �ڵ�(course_id...
 select course_id, title, c_number, c_number*30000+NVL(course_fees,0) as fee
    from course order by fee asc, course_id desc;
select * from course;

-- ���� 2)
select name from professor where dept_id='�İ�';

-- ���� 3)
select title from course where course_fees >= 30000 order by course_fees desc;

-- ���� 4)
select dept_id, year, name from student
    where (dept_id, year) = (('�İ�','2'));
    
-- ���� 5) 
select dept_id, year, name from student where (dept_id, year) = (('�İ�','2'));

-- ���� 6)
select * from professor;
select professor_id, name, telephone from professor order by mgr;

-- ���� 7)
select name from student where name like '��%';

-- ���� 8)
select name from student where name like '%��%';

-- ���� 9)
select name from student where name not like '��%' and name not like '��%';

-- ���� 10)
select name from professor where dept_id in ('�İ�') or dept_id in ('����');

-- ���� 11)
select name from professor 
    where dept_id not in '�İ�' or dept_id not in '����'
        order by mgr;

-- ���� 12)
select score from sg_scores where score >= 90 and score<= 94 order by score desc;

-- ���� 13)
select score from sg_scores where score<60 or score>100 order by score;

select * from course where course_fees is null order by title;
select rownum, dept_id, dept_name, dept_tel from department;
select rownum, dept_id, dept_name, dept_tel from department where rownum <= 3;
select score, to_char(score, 'S999'), to_char(-score, 'S999'), to_char(score, 'B9999.9'), to_char(score,'0099.99')
    from sg_scores where score >= 98 order by 1 desc;
select course_fees, to_char(course_fees, 'L999G999') "������ ȭ��", to_char(course_fees, 'C999G999') "ISO ȭ��" from course
    where course_fees = 20000;
select to_char(10000000, 'L999G999G999') from DUAL;
select count(*) from student;
select stddev(score), variance(score) from sg_scores where course_id = 'L1031'; -- stddev (ǥ������), variance (�л�)

select dept_id from professor group by dept_id having count(*) = 1;
select dept_id from professor;
-- ���� 16) ���� �ڵ�� ������ ����� ����ϼ���


-- ���� 17) sg_scores ���̺��� �й����� 8���� �̻��� ����� �й��� ������� ����� �й������� ����ϼ���
select student_id, count(*), avg(score) from sg_scores group by student_id having count(*) > 2;

create table scoretbl(
    id number(10) primary key,
    name varchar2(20)
    );
    
create sequence seq_score;
insert into scoretbl values(seq_score.nextval, 'ȫ�浿1');
select * from scoretbl;

