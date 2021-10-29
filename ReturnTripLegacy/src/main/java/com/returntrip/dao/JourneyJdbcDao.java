package com.returntrip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.returntrip.entity.Journey;

public class JourneyJdbcDao implements JourneyDao {

	
	private String driver;
	private String url;
	private String username;
	private String password;
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public JourneyJdbcDao(String driver, String url, String username, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	
		System.out.println("JDBCDao 생성자 실행됨");
	}
	
	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, username, password);
		
		System.out.println("JourneyJDBCDao 연결 성공");
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
	public Journey getJourneyData(String journeyno) {
		// TODO Auto-generated method stub		
		Journey journey = null;
		System.out.println("getJourneyData");
		
		int journey_no = Integer.parseInt(journeyno);
		
		String sql = "SELECT JOURNEY_NO, JOURNEY_NAME, CITYNAME, ROAD_BASE_ADDR, NOMINATION, LATITUDE, LONGITUDE,"
				+ "PHONE, J_CONTENT, LOC_CATEGORY, img1, img2 FROM JOURNEY WHERE JOURNEY_NO = ?";
		
		try {
			connect();
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, journey_no);
			rs = stmt.executeQuery();
			System.out.println("sql실행");

			while (rs.next()) {
				System.out.println("journey if문 진입");
				journey = new Journey();
				journey.setJourneyno(rs.getInt("JOURNEY_NO"));
				journey.setJourneyName(rs.getString("JOURNEY_NAME"));
				journey.setCityName(rs.getString("Cityname"));
				journey.setRoad_base_addr(rs.getString("Road_Base_addr"));
				journey.setNomination(rs.getString("NOMINATION"));
				journey.setLattitude(rs.getString("LATITUDE"));
				journey.setLongitude(rs.getString("LONGITUDE"));
				journey.setPhone(rs.getString("PHONE"));
				journey.setContent(rs.getString("J_content"));
				journey.setCategory(rs.getString("LOC_CATEGORY"));
				journey.setImg1(rs.getString("img1"));
				journey.setImg2(rs.getString("img2"));
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
		
		return journey;
	}

	@Override
	public int initializeJourney(Journey journey) {
		// TODO Auto-generated method stub		
		
		String sql = "INSERT INTO JOURNEY VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		int result = 0;
		try {
			connect();
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, journey.getJourneyName());
			stmt.setString(2, journey.getCityName());
			stmt.setString(3, journey.getRoad_base_addr());
			stmt.setString(4, journey.getNomination());
			stmt.setString(5, journey.getLattitude());
			stmt.setString(6, journey.getLongitude());
			stmt.setString(7, journey.getPhone());
			stmt.setString(8, journey.getContent());
			stmt.setString(9, journey.getHomepage());
			stmt.setString(10, (new Gson()).toJson(journey.getCategory(),String[].class));
			
			
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
	public int updateJourney(Journey journey) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int deleteJourney(String roadBaseAddr) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	private String convertToCSV(int[] ids) {
		StringBuilder csv = new StringBuilder();

		for (int i=0; i<ids.length-1; i++) {
			csv.append(ids[i]).append(", ");
		}
		csv.append(ids[ids.length-1]);
		
		return csv.toString();
	}

	@Override
	public List<Journey> getJourneyDatas(String place) {
		// TODO Auto-generated method stub
		Journey journey = null;
		System.out.println("getJourneyData");
		List<Journey> journeyList = new ArrayList<Journey>();
		
		String searchPlace = "%" + place + "%"; 
		
		String sql = "SELECT JOURNEY_NO, JOURNEY_NAME, CITYNAME, ROAD_BASE_ADDR, NOMINATION, LATITUDE, LONGITUDE,"
				+ "PHONE, J_CONTENT, LOC_CATEGORY, img1, img2 FROM JOURNEY WHERE CITYNAME LIKE ?";
		
		try {
			connect();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, searchPlace);
			rs = stmt.executeQuery();
			System.out.println("sql실행");

			while (rs.next()) {
				journey = new Journey();
				journey.setJourneyno(rs.getInt("JOURNEY_NO"));
				journey.setJourneyName(rs.getString("JOURNEY_NAME"));
				journey.setCityName(rs.getString("Cityname"));
				journey.setRoad_base_addr(rs.getString("Road_Base_addr"));
				journey.setNomination(rs.getString("NOMINATION"));
				journey.setLattitude(rs.getString("LATITUDE"));
				journey.setLongitude(rs.getString("LONGITUDE"));
				journey.setPhone(rs.getString("PHONE"));
				journey.setContent(rs.getString("J_content"));
				journey.setCategory(rs.getString("LOC_CATEGORY"));
				journey.setImg1(rs.getString("img1"));
				journey.setImg2(rs.getString("img2"));
				
				journeyList.add(journey);
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
		
		return journeyList;
	}

}
