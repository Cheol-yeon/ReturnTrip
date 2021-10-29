package com.returntrip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.returntrip.entity.Image;
import com.returntrip.entity.Journey;

public class ImgJdbcDao implements ImgDao {

	private String driver;
	private String url;
	private String username;
	private String password;
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public ImgJdbcDao(String driver, String url, String username, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	
		System.out.println("ImgJdbcDao 생성자 실행됨");
	}
	
	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, username, password);
		
		System.out.println("ImgJdbcDao 연결 성공");
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
		
		System.out.println("ImgJdbcDao 연결 끊기");
	}
	
	@Override
	public List<Image> getImgDatas(String parameter) {
		Image image = null;
		System.out.println("getImageData");
		List<Image> imageList = new ArrayList<Image>();
		
		String searchPlace = "%" + parameter + "%"; 
		
		String sql = "select image_link "
				+ "from image where journey_no "
				+ "in (select journey_no from journey where journey_name like ?)"
				+ " order by journey_no";
		
		try {
			connect();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, searchPlace);
			rs = stmt.executeQuery();
			System.out.println("sql실행");

			while (rs.next()) {
				image = new Image();
				
				imageList.add(image);
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
		
		return imageList;
	}

}
