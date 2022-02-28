-- 주석입니다.
-- 실행 : ctrl + Enter
create user green identified by 1234 default tablespace users temporary tablespace temp;
grant resource,create session, create table,connect to green;   -- 권한주기
commit;
