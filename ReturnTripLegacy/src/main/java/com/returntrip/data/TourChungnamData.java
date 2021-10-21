package com.returntrip.data;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.returntrip.entity.Journey;

public class TourChungnamData implements TourData {

   @Override
   public List<Journey> getTourData(int numOfRows) {
      StringBuilder urlBuilder = new StringBuilder("https://tour.chungnam.go.kr/_prog/openapi/?func=tour&start=1&end=329"); /*URL*/
       
      Journey journey = null;
      List<Journey> list = new ArrayList<Journey>();
      try {
           URL url = new URL(urlBuilder.toString());
           
           HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           conn.setRequestMethod("GET");
           conn.setRequestProperty("Content-type", "application/json");           
           String surl = conn.getHeaderField("Location");
           
           Document doc = Jsoup.connect(surl).get();
           Elements els = doc.select("item");
           
           for(int i = 1 ; i < 329; i++) {
              journey = new Journey();
              journey.setJourneyName(els.select("nm").get(i).text()); //관광지 이름
            /*
             * for(int j = 0; j < 5; j ++) { String temp = els.select("attr0" +
             * Integer.toString(j+1)).get(i).text(); if(temp.length() > 0) {
             * if(temp.substring(0,temp.lastIndexOf("|")).equals("주차안내") ||
             * temp.substring(0,temp.lastIndexOf("|")).equals("주차시설")) {
             * journey.setParking(temp.substring(temp.lastIndexOf("|")+1,temp.length()));
             * continue; } else if(temp.substring(0,temp.lastIndexOf("|")).equals("이용시간")) {
             * journey.setTerm(temp.substring(temp.lastIndexOf("|")+1,temp.length()));
             * continue; } else if(temp.substring(0,temp.lastIndexOf("|")).equals("이용요금")) {
             * journey.setFee(temp.substring(temp.lastIndexOf("|")+1,temp.length()));
             * continue; } } }
             */
              
              journey.setNomination(els.select("local_nm").get(i).text()); //시 이름
              journey.setRoad_base_addr(els.select("addr").get(i).text()); //주소
              journey.setPhone(els.select("tel").get(i).text()); //전화번호
              journey.setContent(els.select("desc").get(i).text()); //관광지설명
              journey.setHomepage(els.select("h_url").get(i).text()); //관광지홈페이지
           
     
              list.add(journey);
           }
          
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } /*Service Key*/
             return list;
   }

}