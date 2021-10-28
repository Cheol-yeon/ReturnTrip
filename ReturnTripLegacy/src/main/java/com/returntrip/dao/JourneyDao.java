package com.returntrip.dao;

import java.util.List;

import com.returntrip.entity.Journey;

public interface JourneyDao {
	
	Journey getJourneyData(String roadBaseAddr);
	
	List<Journey> getJourneyDatas(String place);
	
	int initializeJourney(Journey journey);
		
	int updateJourney(Journey journey);
	
	int deleteJourney(String roadBaseAddr);

}
