-- 1) professor ����
create table professor( -- professor��� �̸����� table�� �����ض�
    prono number(4) primary key, -- primary key : �����ϴ� (�ߺ��� ��� �ȵ�)
    name varchar2(60) not null,   -- not nul : null ���� ������� �ʴ´�. * ����Ŭ������ varchar2�� ����. char����.
    id varchar2(15) not null,
    position varchar2(30) not null,
    pay number(3) not null,
    hiredate date not null,     -- date : ��¥ Ÿ��
    bonus number(4),             -- not null�� ������, �Է��� ���� �ʾƵ� �ȴ�.
    deptno number(3),
    email varchar2(50),
    hpage varchar2(50)
);
-- ��ҹ��� �������� ����
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

select count(position) from professor;  -- ���� ��������
select distinct position from professor;   -- �ߺ� ���� �� ��������
select position "����" from professor;    -- position -> ����  ���� �� ��������
-- ���� 2) id�� "���̵�"�� position�� "��å" pay�� "�ӱ�" hiredate�� "�����"
-- bonus�� "���ʽ�", deptno�� "�μ���ȣ", email�� "�̸���", hpage�� "������"�� Į���� ���� �� ����ϼ���
select position "����" from professor;
select id "���̵�" from professor;
select pay "�ӱ�" from professor;
select hiredate "�����" from professor;
select bonus "���ʽ�" from professor;
select deptno "�μ���ȣ" from professor;
select email "�̸���" from professor;
select hpage "������" from professor;
 
 
 -- 2) department ����1
 create table department(
    DEPT_ID varchar2(10) not null,
    dept_name varchar2(25) null,
    dept_tel varchar2(12) null
);

desc department;    -- describe �� ����. ���̺��� ������ �����ٿ�

drop table department;

insert into department values('green', '��ǻ�� ���а�', '010');
commit;
select * from department;   
insert into department (dept_id) values('a');   -- Ư�� columm���� �����͸� ����
insert into department (dept_name) values('b'); -- dept_id�� null�̸� �ȵǹǷ�, ���� �߻�
INSERT INTO department (dept_id, dept_name) values('a','b');
drop table department;

-- ����Ŭ�� �����ͺ��̽� ����� commit�� �������� �� ����� �Ѵ�.
-- ��Ÿ�� ���̺� ������ �߸��Ǿ����� �Ʒ��� ������� ����
-- drop table [TABLE_NAME]




-- 3) department ����2
create table department(
    dept_id varchar2(10),
    dept_name varchar2(25),
    dept_tel varchar2(12),
    constraint department_pk primary key (dept_id)
);    
-- ������ ������ dept_id�� ������ key(primary)�� ��������(constraint)�� �����Ͽ� ���̺��� ���� (�������Ǹ�(department_pk))
-- �׷��� dept_id�� �ߺ��ؼ� ������ �ȵ˴ϴ�.
insert into department values('kim', 'seungcheol', '01090374099');
insert into department values('park', 'namhoon', '01090374455');
select * from department;
commit;
    
    


-- 4) student ����
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
-- �θ� ���̺�(department)�� primary key�� �ڽ� ���̺�(student)�� �����ϱ� ���� �ܷ�Ű�� ����� ���ε�,
-- �ܷ�Ű (foreign key)�� ���� �����ϱ� ���� �θ����̺�(department)�� primary key(dept_id)��
-- ����(references)�ϰ� ����
-- �ڽ� ���̺��� �θ� ���̺��� primary key�� �ش��ϴ� dept_id�� ���� ���� �߰��� ���� �߻���
drop table student;
    
insert into student values('kim', '2022', 'id1', 'Fekim', 'number1', 'address1');   -- 1) �� ���� data
insert into student values('park', '2023', 'id2', 'Fekim1', 'number2', 'address12'); -- 2) foreign key�� test�ϱ����� parent�� �������� �ʴ� key�� dept_id�� �־
insert into student values('kim', '2023', 'id2', 'Fekim3', 'number3', 'address13'); -- 3) constraint key�� test�ϱ����� id�� �ߺ����� �����غ�
select * from department;    
select * from student;
    
-- �� ���̺�� ���� ������ ���̺� ���踦 �����ϸ�,
-- * �� ������ �ִµ� �� ���� ������ ������ ���� �ְ�,
-- * �������� �������� ���� (���ɰ�), ���� �����ϸ� ������ΰ���
-- * ������ ���� : delete from [TABLE_NAME] where ��(���ڵ�(��)) 
-- * ������ ���� �� ������� �׳� ���̺� ���� �� �ٽ� ������ �߰�.
-- * Į���� not null�� �������� ������, default�� null�̰�, primary key�� null�� �� ����.

insert into student(student_id, dept_id, name, id_number) 
values('ȫ��', 'b', '�谳��', 'abc');



-- 5) ������ primary, foreign key ����

-- �θ� table
create table ttt(
green number(3) primary key,
red varchar2(30)
);
drop table ttt;

-- �ڽ� table
create table ppp (
green_child varchar2(10),
red_id number(3) primary key,
red varchar2(20),
constraint ppp_pk foreign key (red_id) references ttt(green)
);
drop table ppp;

insert into ppp(red_id,red) values(7, '������');

select * from ttt;
select * from ppp;


-- 6) professor ����2
drop table professor;
create table professor(
    professor_ID varchar2(3) primary key,
    name varchar2(20) not null,
    position varchar(10) not null constraint professor_ck check(position in ('����', '�α���', '������', '�ʺ�����')),
    dept_id constraint professor_fk references department (dept_id)
);
-- check�� ���� �����Դϴ�. ���������� �̸��� professor_ck �̰�
-- �ű⿡ �ԷµǴ� �����ʹ� '����', '�α���', '������', '�ʺ�����' ���� �ϳ��� �߰��Ҽ� �־��
-- �������� : primary key, foreign key, check, not null
-- ���̺��� ��������(alter), ������ alter�� �ְ� update�� �ֽ��ϴ�.
-- alter�� ���̺��� ������ �����ϴ� ���̰� updae�� ������(���ڵ�/��)�� ����
-- �츮�� �ǳ� �ϴ°��� CRUD(Create, Read, Update, Delete)
alter table professor
    add (email varchar2(60),
        duty varchar2(10),
        Mgr varchar2(3)
        );
desc professor;

-- ���� 1) �����͸� �߰��ϼ���
select * from department;
insert into professor values('id1', 'name1', '����', 'kim', 'email1', 'duty1', 'Mg1');
select * from professor;


