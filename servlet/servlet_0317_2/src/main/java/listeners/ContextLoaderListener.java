package listeners;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.commons.dbcp.BasicDataSource; //ÀÓÆ÷Æ® 
import dao.MemberDAO;
@WebListener
public class ContextLoaderListener implements ServletContextListener {
	BasicDataSource ds; //DataSource =>Connection Pool°ú À¯»ç 
	  @Override
	  public void contextInitialized(ServletContextEvent event) {
	    try {
	      ServletContext sc = event.getServletContext();
	      ds = new BasicDataSource();
	      ds.setDriverClassName(sc.getInitParameter("driver"));
	      ds.setUrl(sc.getInitParameter("url"));
	      ds.setUsername(sc.getInitParameter("username"));
	      ds.setPassword(sc.getInitParameter("password"));
	      MemberDAO memberDao = new MemberDAO();
	      memberDao.setDataSource(ds);
	      sc.setAttribute("memberDao", memberDao);
	    } catch(Throwable e) {
	      e.printStackTrace();
	    }
	  }
	  @Override
	  public void contextDestroyed(ServletContextEvent event) {
	    try { if (ds != null) ds.close(); } catch (SQLException e) {}
	  }
}
//ÅÂ¼º °æÃ¶ ½Â¿ì »ó¿í Á¤Çö ¹Î±â Á¤±¹ ÇÏ¶ó ¿¬Áø ÇöÀç ½ÂÃ¶ È¿ÁØ 
//¹ÎÇõ