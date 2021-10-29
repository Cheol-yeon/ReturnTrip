package com.returntrip.entity;

import java.util.Arrays;

public class Journey {
	private int journeyno;
	private String journeyName;
	private String cityName;
	private String road_base_addr;
	private String nomination;
	private String lattitude;
	private String longitude;
	private String phone;
	private String content;
	private String homepage;
	private String category;
	private WeatherDO weatherDO;
	private String img1;
	private String img2;
//	private String[] hashtag;
//	private String[] img;

	public Journey() {

	}

	public Journey(int journeyno, String journeyName, String cityName, String road_base_addr, String nomination,
			String lattitude, String longitude, String phone, String content, String homepage, String category,
			WeatherDO weatherDO, String img1, String img2) {
		super();
		this.journeyno = journeyno;
		this.journeyName = journeyName;
		this.cityName = cityName;
		this.road_base_addr = road_base_addr;
		this.nomination = nomination;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.phone = phone;
		this.content = content;
		this.homepage = homepage;
		this.category = category;
		this.weatherDO = weatherDO;
		this.img1 = img1;
		this.img2 = img2;
	}



	public String getJourneyName() {
		return journeyName;
	}

	public void setJourneyName(String journeyName) {
		this.journeyName = journeyName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getRoad_base_addr() {
		return road_base_addr;
	}

	public void setRoad_base_addr(String road_base_addr) {
		this.road_base_addr = road_base_addr;
	}

	public String getNomination() {
		return nomination;
	}

	public void setNomination(String nomination) {
		this.nomination = nomination;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public WeatherDO getWeatherDO() {
		return weatherDO;
	}

	public void setWeatherDO(WeatherDO weatherDO) {
		this.weatherDO = weatherDO;
	}

	public int getJourneyno() {
		return journeyno;
	}

	public void setJourneyno(int journeyno) {
		this.journeyno = journeyno;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}


}
