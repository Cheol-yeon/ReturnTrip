package com.returntrip.service;

import java.util.List;

import com.returntrip.entity.Journey;

public interface JourneyService {
	
	List<Journey> getJourneyDatas(String place);
	
	Journey getJourneyData(String place);
	
	List<String> getSearchDatas(String category);
	
	int insertJourney(Journey journey);
	
	int updateJourney(Journey journey);
	
	int deleteJourney(String roadBaseAddr);
	
	
}
