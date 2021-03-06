package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBConnectionPool;
import vo.Member;

public class MemberDAO {	// DAO : Database Access Object
	DBConnectionPool connPool;

	public void setDBConnectionPool(DBConnectionPool connPool) {
		this.connPool = connPool;
	}
	
	public List<Member> selectList() throws Exception{
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				conn = connPool.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select MNO, MNAME, EMAIL,CRE_DATE FROM MEMBERS ORDER BY MNO ASC");
				
				List<Member> members = new ArrayList<>();
				while(rs.next()) {
					members.add(new Member()
							.setNo(rs.getInt("mno"))
							.setName(rs.getString("mname"))
							.setEmail(rs.getString("email"))
							.setCreatedDate(rs.getDate("cre_date")));
				}
				
				return members;
				
			} catch (Exception e) {
				throw e;
				
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
	
	public Member exist(String email, String password) throws Exception{
		System.out.println("로그인 성공");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement("select mname, email from members where email=? and pwd=?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new Member()
						.setEmail(rs.getString("mname"))
						.setName(rs.getString("email"));
			} else {
				return null;
			}
			
		} catch (Exception e) {
			throw new ServletException();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			if(conn != null) connPool.returnConnection(conn);
		} 
	}
	
	public int insert(Member member) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
					"insert into members (email, pwd, mname, cre_date, mod_date)" + " values(?,?,?,now(),now())"); // ?는 준비한 후 나중에 채운다(prepare)
			
			stmt.setString(1, member.getEmail()); // 1번 물음표를 채운다
			stmt.setString(2, member.getPassword()); // 2번 물음표를 채운다
			stmt.setString(3, member.getName()); // 3번 물음표를 채운다
			return stmt.executeUpdate(); // 최종 적용(update) 한다.

		} catch (Exception e) {
			throw new ServletException(e);

		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				connPool.returnConnection(conn);
			} catch (Exception e) {
			}
		}
		
	}
	
	public int update(Member member) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			
			conn = connPool.getConnection();
			System.out.println(" 추가 post connection 객체 " + conn);

			stmt = conn.prepareStatement("update members set email=?, mname=?, mod_date=now() where mno=?");

			stmt.setString(1, member.getEmail());
			stmt.setString(2, member.getName());
			stmt.setInt(3, member.getNo());
			stmt.executeUpdate();
			return stmt.executeUpdate();
			
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
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
	
	public int delete (int no) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate(
					"delete from members where mno=" + no
					);
		} catch (Exception e) {
			throw e;
		} finally {
			try {if(stmt != null) stmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
		}
		
	}
	
	public Member selectOne(int no) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = connPool.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select mno, email, mname, cre_date from members where mno=" + no);
			if(rs.next()) {
				return new Member()
						.setNo(rs.getInt("mno"))
						.setEmail(rs.getString("email"))
						.setName(rs.getString("mname"))
						.setCreatedDate(rs.getDate("cre_date"));
			} else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {if(stmt != null) stmt.close();} catch(Exception e) {}
			try {if(conn != null) conn.close();} catch(Exception e) {}
		}
	}	
}
