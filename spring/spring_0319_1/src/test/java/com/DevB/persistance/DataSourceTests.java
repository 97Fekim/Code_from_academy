package com.DevB.persistance;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

/* hikarycp datasource 연결을 테스트하는 코드입니다. */
/* junit으로 테스트를 하려면 아래의 @Runwith, @ContextConfiguration 은 반드시 붙여주자.*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void testConnection() {

		
		/* Connection pool을 사용할때 얼마나 효율적인지 테스트 */
		// 1) 순수 JDBC를 20번 연결하는데 걸린 시간 = 1.5초
		// 2) Connection pool을 사용하여 20번 연결하는데 걸린 시간 = 0.043초
		// ★ 약 35배가 빠르다 ★
		long start = System.currentTimeMillis();
		for(int i=0; i<20; ++i) {
			// Actual Test code
			try(Connection con = ds.getConnection()) {
				log.info(con);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage());
			}
		}
		long end = System.currentTimeMillis();
		log.info("------------");
		log.info(end - start);
	}
	
	

	// sqlSessionConnectin을 테스트하는 메서드입니다.
	@Test
	public void testConnection2() {
		try(SqlSession session = sessionFactory.openSession()) {
			Connection con = session.getConnection();
			log.info(session);
			log.info(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
