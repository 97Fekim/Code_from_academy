package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Member;
import vo.Scores;


@SuppressWarnings("serial")
@WebServlet("/score/list")
public class ScoreListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		response.setContentType("text/html ;charset=UTF-8");
		ServletContext sc = this.getServletContext();
		Class.forName(sc.getInitParameter("driver"));
		conn = DriverManager.getConnection(
				sc.getInitParameter("url"),
				sc.getInitParameter("username"),
				sc.getInitParameter("password")
				);
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select tel, addr, name, kor, eng, math, grade from scores");
		
		List<Scores> scores = new ArrayList<>();
		
		while(rs.next()) {
			scores.add(new Scores()
					.setAddress(rs.getString("addr"))
					.setTel(rs.getInt("tel"))
					.setName(rs.getString("name"))
					.setKor(rs.getInt("kor"))
					.setMath(rs.getInt("math"))
					.setEng(rs.getInt("eng"))
					.setGrade(rs.getString("grade"))
					);
		}
		
		request.setAttribute("scores", scores);
		RequestDispatcher rd = request.getRequestDispatcher("/member/ScoreList.jsp");
		rd.include(request, response);
		
		} catch (Exception e) {
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
			
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {

			}

			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {

			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
