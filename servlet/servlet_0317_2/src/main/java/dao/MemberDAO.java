package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.sql.DataSource;

import vo.Member;

public class MemberDAO { //Database Access Object 
	DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds=ds;
	}
	public List<Member> selectList() throws Exception{
		Connection conn =null;
		Statement stmt =null;
		ResultSet rs= null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs =stmt.executeQuery("select MNO, MNAME, EMAIL,CRE_DATE FROM MEMBERS ORDER BY MNO ASC" );
			
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
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(stmt!=null) stmt.close(); } catch(Exception e){}
			try {if(conn!=null)  conn.close();} catch(Exception e) {}
		}
	}
	public Member exist(String email ,String password) throws Exception{
		System.out.println("로그인 post ");
		Connection conn =null;
		PreparedStatement stmt= null;
		ResultSet rs=null;		
		try {
			conn = ds.getConnection();
			System.out.println("3) memberDao connection : " +conn);
			stmt = conn.prepareStatement("select mname,email from members where email=? and pwd=?" );
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs=stmt.executeQuery();
			System.out.println("4) memberDao connection : " +rs);
			if(rs.next()) {
				return new Member()
						.setName(rs.getString("mname"))
						.setEmail(rs.getString("email"));
			}
			else {
				return null;
			}
		} catch (Exception e) {
			throw new ServletException();
		}finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			if(conn!=null) conn.close();
		}
	}
	
	public int insert (Member member) throws Exception {

		Connection conn =null;
		PreparedStatement stmt = null;// prepare 준비 (?) 
		try {
			conn= ds.getConnection();
			System.out.println(" 추가 post connection 객체 "+ conn);
			stmt = conn.prepareStatement("insert into members (email, pwd, mname, cre_date,mod_date)" +
					 "  values(?,?,?,now(),now())"); // ?는 준비한 후  나중에 채운다(prepare) 
			stmt.setString(1, member.getEmail()); //1번 물음표를 채워다오 
			stmt.setString(2, member.getPassword()); //2번 물음표를 채워다오 
			stmt.setString(3, member.getName()); //3번 물음표를 채워다오 
			return stmt.executeUpdate();// 수정(추가/삭제) 된 갯수 반환
		}
		catch(Exception e) {
			throw new ServletException(e);

		} finally {
			try {if(stmt!=null) stmt.close();} catch(Exception e) {} 
			try {if(conn!=null) conn.close();} catch(Exception e) {} 
		}
	}
	public int update(Member member) throws Exception{
		Connection conn=null;
		PreparedStatement stmt =null;
		try {
			conn= ds.getConnection();
			System.out.println(" 추가 post connection 객체 "+ conn);
			stmt = conn.prepareStatement(
					"update members set  email=? , mname=?, mod_DATE =NOW() where mno=?"); 
			stmt.setString(1, member.getEmail());
			stmt.setString(2, member.getName());
			stmt.setInt(3, member.getNo());
			return stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt!= null) stmt.close();} catch(Exception e) {}
			try { if(conn!= null) conn.close();} catch(Exception e) {}
		}
	}
	public int delete (int no) throws Exception{
		Connection conn=null;
		Statement stmt =null;
		try {
			conn= ds.getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate(
					"delete from members where mno=" +no);
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt!= null) stmt.close();} catch(Exception e) {}
			try { if(conn!= null) conn.close();} catch(Exception e) {}
		}
	}
	public Member selectOne(int no ) throws Exception{
		Connection conn=null;
		Statement stmt =null;
		ResultSet rs =null;
		try {
			conn= ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select mno ,email,mname,cre_date from members where mno=" +no);
			if(rs.next()) {
				return new Member()
						.setNo(rs.getInt("mno"))
						.setEmail(rs.getString("email"))
						.setName(rs.getString("mname"))
						.setCreatedDate(rs.getDate("cre_date"));
			} else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다");
			}
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt!= null) stmt.close();} catch(Exception e) {}
			try { if(conn!= null) conn.close();} catch(Exception e) {}
		}
	}

}
