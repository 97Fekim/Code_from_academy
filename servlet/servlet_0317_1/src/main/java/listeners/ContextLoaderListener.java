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
	
	// �Ҹ�� �� ȣ��
    public void contextDestroyed(ServletContextEvent sce)  {
    	connPool.claseAll(); 	// �ڿ� ����(Connection �ݱ�)
    }
	
    // ������ �� ȣ��Ǵ� �޼ҵ�
    public void contextInitialized(ServletContextEvent event)  { 
    	System.out.println("contextDestroyed �̺�Ʈ �߻�");
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
