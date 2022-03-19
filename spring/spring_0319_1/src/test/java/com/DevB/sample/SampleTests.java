package com.DevB.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

/* 의존관계 주입을 테스트하는 클래스입니다.
 * setter주입, field 주입, 생성자주입(lombok)
 * */
/* junit으로 테스트를 하려면 아래의 @Runwith, @ContextConfiguration 은 반드시 붙여주자.*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	
	/* 레스토랑 테스트 */
	@Autowired
	private Restaurant restaurant;
	@Test
	public void test1() {
		System.out.println("Restaurant test");
		log.info("Restaurant test");
		log.info(restaurant);
		
		System.out.println("Chef in Restaurant test");
		log.info("Chef in Restaurant test");
		log.info(restaurant.getChef());
	}
	
	/* 호텔 테스트 */
	@Autowired
	private SampleHotel sampleHotel;
	@Test
	public void testHotel() {
		System.out.println("Hotel test");
		log.info("Hotel test");
		log.info(sampleHotel);
		assertNotNull(sampleHotel);
		
		System.out.println("Chef in Hotel");
		log.info("Chef in Hotel");
		log.info(sampleHotel.getChef());
		assertNotNull(sampleHotel.getChef());
		
	}
	
}
