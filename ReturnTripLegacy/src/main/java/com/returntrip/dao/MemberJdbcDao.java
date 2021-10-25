package com.returntrip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.returntrip.entity.Member;

public class MemberJdbcDao implements MemberDao{

	private String driver;
	private String url;
	private String username;
	private String password;
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	
	public MemberJdbcDao(String driver, String url, String username, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, username, password);
		
		System.out.println("JDBCDao 연결 성공");
	}
	
	private void disconnect() throws SQLException {
		if (rs != null && !rs.isClosed()) {
			rs.close();
			rs = null;
		}
		if (stmt != null && !stmt.isClosed()) {
			stmt.close();
			stmt = null;
		}
		if (conn != null && !conn.isClosed()) {
			conn.close();
			conn = null;
		}
		
		System.out.println("JDBCDao 연결 끊기");
	}

	@Override
	public Member getMemberData(String id) {
		Member member = null;
		
		System.out.println("MEMBERJDBC ID = " + id);
		String sql = "SELECT ID, PWD, NAME, EMAIL FROM MEMBER WHERE ID = ?";
		try {
			connect();

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);

			rs = stmt.executeQuery();

			member = new Member();
			while (rs.next()) {
				System.out.println("if문 진입");
				
				member.setId(rs.getString("ID"));
				member.setPwd(rs.getString("PWD"));
				member.setName(rs.getString("NAME"));
				member.setEmail(rs.getString("EMAIL"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				disconnect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return member;
		
		
	}

	@Override
	public List<Member> getMemberDatas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(Member member) {
		String sql = "INSERT INTO MEMBER VALUES(id_seq.nextval,?,?,?,?)";
		
		int result = 0;
		try {
			connect();
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPwd());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getEmail());
			
			result = stmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				disconnect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
