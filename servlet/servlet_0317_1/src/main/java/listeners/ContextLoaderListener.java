package listeners;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.MemberDAO;
import util.DBConnectionPool;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

	DBConnectionPool connPool;
	
	// 소멸될 때 호출
    public void contextDestroyed(ServletContextEvent sce)  {
    	connPool.claseAll(); 	// 자원 정리(Connection 닫기)
    }
	
    // 생성될 때 호출되는 메소드
    public void contextInitialized(ServletContextEvent event)  { 
    	System.out.println("contextDestroyed 이벤트 발생");
    	try {
			ServletContext sc = event.getServletContext();
			connPool = new DBConnectionPool(
					sc.getInitParameter("driver"),
					sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password")
					);
				MemberDAO memberDao = new MemberDAO();
				memberDao.setDBConnectionPool(connPool);
				sc.setAttribute("memberDao", memberDao);
		} catch (Exception e) {
			connPool.claseAll();
		}
    }
	
}
