package com.DevB.persistance;

import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Iterator;

import org.junit.Test;

import lombok.extern.log4j.Log4j;
import oracle.net.nt.ConnectDescription;

@Log4j
public class JDBCTests {

	// oracle db 연동 테스트입니다.
	// 약식으로 진행한 코드지만, 원칙대로라면 try catch finally로 묶어줘야 합니다.
	@Test
	public void testConnection() throws Exception {
		Class clz = Class.forName("oracle.jdbc.driver.OracleDriver");
		log.info(clz);
		
		/* Connection pool을 사용할때 얼마나 효율적인지 테스트 */
		// 1) 순수 JDBC를 20번 연결하는데 걸린 시간 = 1.5초
		long start = System.currentTimeMillis();
		for(int i=0; i<20; ++i) {
			// Actual Test code
			Connection con = 
					DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:XE",
							"Fekim","1234");
			log.info(con);
			con.close();	// bad code.
		}
		long end = System.currentTimeMillis();
		log.info("------------");
		log.info(end - start);
		
		
		
	}
}
