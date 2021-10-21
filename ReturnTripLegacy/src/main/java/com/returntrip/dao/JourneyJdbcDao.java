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
	public Journey getJourneyData(String place) {
		// TODO Auto-generated method stub		
		Journey journey = null;
		
		String sql = "SELECT * FROM JOURNEY WHERE journey_name = " + place;
		
		try {
			connect();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, place);
			rs = stmt.executeQuery();

			if (rs.next()) {
				journey = new Journey();
				journey.setJourneyName(rs.getString("JOURNEY_NAME"));
				journey.setCityName(rs.getString("Cityname"));
				journey.setRoad_base_addr(rs.getString("Road_Base_addr"));
				journey.setNomination(rs.getString("NOMINATION"));
				journey.setLattitude(rs.getString("LATITUDE"));
				journey.setLongitude(rs.getString("LONGITUDE"));
				journey.setPhone(rs.getString("PHONE"));
				journey.setContent(rs.getString("J_content"));
				journey.setHomepage(rs.getString("Homepage"));
				journey.setCategory((new Gson()).fromJson(rs.getString("LOC_CATEGORY"), String[].class));
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
	public List<Journey> getJourneyDatas(String category) {
		// TODO Auto-generated method stub
		Journey journey = null;
		List<Journey> list = null;
		String sql = "SELECT * FROM JOURNEY WHERE LOC_category = ?"; //index : category 설정
		
		try {
			connect();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, category);
			rs = stmt.executeQuery();
			
			if (rs.isBeforeFirst()) {
				list = new ArrayList<Journey>();
				while(rs.next()) {
					journey = new Journey();
					journey.setJourneyName(rs.getString("JOURNEY_NAME"));
					journey.setCityName(rs.getString("Cityname"));
					journey.setRoad_base_addr(rs.getString("Road_Base_addr"));
					journey.setNomination(rs.getString("NOMINATION"));
					journey.setLattitude(rs.getString("LATITUDE"));
					journey.setLongitude(rs.getString("LONGITUDE"));
					journey.setContent(rs.getString("J_CONTENT"));
					journey.setHomepage(rs.getString("Homepage"));
					journey.setCategory((new Gson()).fromJson(rs.getString("LOC_CATEGORY"), String[].class));
					list.add(journey);
				}
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
		return list;
	}

	@Override
	public List<String> getCategory(String category) {
		// TODO Auto-generated method stub
		List<String> list = null;
		String sql = "SELECT Categoty FROM JOURNEY where categoty LIKE ? group by Categoty"; //index : category 설정
		
		try {
			connect();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" +category + "%");
			rs = stmt.executeQuery();
			
			if (rs.isBeforeFirst()) {
				list = new ArrayList<String>();
				while(rs.next()) {
					list.add(rs.getString("categoty"));
				}
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
		return list;
	}
}
