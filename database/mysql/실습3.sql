select u.userid, name, prodname, addr, mobile1+mobile2 as '연락처'
	from buytbl b
		inner join usertbl u
			on b.userid = u.userid
				order by num;
		
select u.userid, u.name, u.addr from usertbl u
	where exists(
		select * from buytbl b);
        
-- 문제1) 테이블 생성, 테이블 명 stdtbl
create table stdtbl(
	stdname char(10) not null primary key,
    addr char(4) not null
);

-- 문제2) 테이블 생성, 테이블 명 clubtbl
create table clubtbl(
	clubname char(10) not null primary key,
    roomno char(4)
);

-- 문제3) 테이블 생성, 테이블명 stdclubtbl
create table stdclubtbl(
	num int auto_increment not null primary key,
    stdname char(10) not null,
    clubname char(10) not null,
    foreign key (stdname) references stdtbl(stdname),
	foreign key (clubname) references clubtbl(clubname)
);


-- 문제4) 데이터 추가
insert into stdtbl values('김범수', '서울');
insert into stdtbl values('조용필', '경기');
insert into stdtbl values('은지원', '경북');
insert into stdtbl values('바비킴', '서울');

insert into clubtbl values ('수영', '101호');
insert into clubtbl values ('바둑', '102호');
insert into clubtbl values ('축구', '103호');
insert into clubtbl values ('봉사', '104호');

insert into stdclubtbl(stdname,clubname) values ('김범수', '바둑');
insert into stdclubtbl(stdname,clubname) values ('김범수', '축구');
insert into stdclubtbl(stdname,clubname) values ('조용필', '축구');
insert into stdclubtbl(stdname,clubname) values ('은지원', '축구');
insert into stdclubtbl(stdname,clubname) values ('은지원', '봉사');
insert into stdclubtbl(stdname,clubname) values ('바비킴', '봉사');
select * from stdclubtbl;

select stdtbl.stdname, stdtbl.addr, stdclubtbl.clubname, clubtbl.roomno
	from stdtbl
		inner join stdclubtbl
			on stdtbl.stdname = stdclubtbl.stdname
				inner join clubtbl
					on clubtbl.clubname = stdclubtbl.clubname
						order by stdname;

select u.userid, u.name, b.prodname, u.addr, concat(u.mobile1, u.mobile2) as '연락처'
	from usertbl u
		left join buytbl b
			on u.userid = b.userid
				order by u.userid;
                
create table uv(
	num int
);
create table vz(
	num int
);
insert into uv values(7);
insert into uv values(7);
insert into uv values(7);
insert into uv values(7);

insert into uv values(8);
insert into uv values(8);
insert into uv values(8);
insert into uv values(8);
insert into uv values(8);

insert into vz values(3);
insert into vz values(3);
insert into vz values(4);
insert into vz values(4);
insert into vz values(4);

select count(*) as count from uv
	cross join vz;

select name, concat(mobile1, mobile2) as '전화번호' from usertbl
	where name not in (select name from usertbl where mobile1 is null);
    
drop procedure if exists ifProc;
drop table if exists buytbl;