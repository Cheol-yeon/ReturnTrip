package com.returntrip.test;

import java.util.List;

import com.returntrip.dao.JourneyDao;
import com.returntrip.dao.JourneyJdbcDao;
import com.returntrip.data.TourChungnamData;
import com.returntrip.data.TourData;
import com.returntrip.entity.Journey;

public class UrlTest {
	public static void main(String[] args) {

		/*
		 * TourData td = new TourChungnamData(); List<Journey> list =
		 * td.getTourData(329);
		 * 
		 * System.out.println(list.size()); for (int i = 0; i < list.size(); i++) {
		 * Journey journey = list.get(i); JourneyDao jdao = new
		 * JourneyJdbcDao("oracle.jdbc.driver.OracleDriver",
		 * "jdbc:oracle:thin:@db202109241747_medium?TNS_ADMIN=C:\\Users\\User\\Desktop\\Wallet_DB202109241747",
		 * "admin", "Password1234"); jdao.initializeJourney(journey); }
		 */

		JourneyDao jdao = new JourneyJdbcDao("oracle.jdbc.driver.OracleDriver",
				"jdbc:oracle:thin:@db202109241747_medium?TNS_ADMIN=C:\\Users\\User\\Desktop\\Wallet_DB202109241747",
				"admin", "Password1234");
		TourData td = new TourChungnamData();
		List<Journey> list = td.getTourData(329);
		for (int i = 0; i < list.size(); i++) {
			Journey journey = list.get(i);
			jdao.initializeJourney(journey);
		}

//		 TourData td = new TourDaeguData();
//		 List<Journey> list = td.getTourData(10);
//		 
//		 System.out.println(list.get(0).getJourneyName());
	}
}
