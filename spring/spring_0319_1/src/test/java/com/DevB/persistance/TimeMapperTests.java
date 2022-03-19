package com.DevB.persistance;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.DevB.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

/* MyBatis 연동 후 테스트입니다. */
/* junit으로 테스트를 하려면 아래의 @Runwith, @ContextConfiguration 은 반드시 붙여주자.*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {

	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testTime1() {
		log.info(timeMapper.getTime());
	}
	
	@Test
	public void testTime2() {
		log.info(timeMapper.getTime2());
	}
	
}
