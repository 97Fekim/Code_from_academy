-- �ּ��Դϴ�.
-- ���� : ctrl + Enter
create user green identified by 1234 default tablespace users temporary tablespace temp;
grant resource,create session, create table,connect to green;   -- �����ֱ�
commit;
