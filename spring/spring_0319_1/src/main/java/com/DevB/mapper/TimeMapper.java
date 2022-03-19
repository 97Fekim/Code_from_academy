package com.DevB.mapper;

import org.apache.ibatis.annotations.Select;

// Mybatis를 이용해 현재 시간을 가져오는 인터페이스 입니다.
public interface TimeMapper {
	@Select("select sysdate from dual")
	String getTime();
	
	String getTime2();
}
