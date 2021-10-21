package com.returntrip.webcrawl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.returntrip.entity.WeatherDO;

public class WeatherNaverCrawl implements WeatherCrawl{
	@Override
	public WeatherDO getWeatherData(String location) {
		// TODO Auto-generated method stub
		WeatherDO weatherDO = null;
		Document doc;
		
		String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=" + location +"날씨";
		try {
			
			doc = Jsoup.connect(url).get();
			weatherDO = new WeatherDO();
			
			Elements els = doc.select("div.temperature_text");
			System.out.println(els);

			weatherDO.setTemperature(els.select("strong").text());
			
			String temp = els.select("span.weather before_slash").text();
			weatherDO.setWeather(temp);
			
			Elements els2 = doc.select("ul.today_chart_list");
			
			List<String> list = new ArrayList<String>();
			for(Element el : els2.select("li.item_today level1")) {
				list.add(el.text());
			}
			
			
			weatherDO.setFine_dust(list.get(0));
			weatherDO.setUltra_fine_dust(list.get(1));
			System.out.println(weatherDO.getTemperature());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return weatherDO;

		
	}

}
