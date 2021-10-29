package com.returntrip.entity;

public class Image {
	private int jourimgNo;
	private String jourUrl;
	
	public Image() {}

	public Image(int jourimgNo, String jourUrl) {
		this.jourimgNo = jourimgNo;
		this.jourUrl = jourUrl;
	}

	public int getJourimgNo() {
		return jourimgNo;
	}

	public void setJourimgNo(int jourimgNo) {
		this.jourimgNo = jourimgNo;
	}

	public String getJourUrl() {
		return jourUrl;
	}

	public void setJourUrl(String jourUrl) {
		this.jourUrl = jourUrl;
	}
	
}
