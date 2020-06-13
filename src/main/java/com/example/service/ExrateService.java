package com.example.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Dto.Exrate;
import com.example.webcrawler.WebCrawlerProcess;
import com.example.webcrawler.WebCrawler_Exrate;

@Service
public class ExrateService {
	
	public Exrate crawlerExrate(String url) {
		
		WebCrawlerProcess webCrawlerExrate = new WebCrawler_Exrate(url, 3000);
		webCrawlerExrate.crawlerProcess();
		List<String> result = webCrawlerExrate.getResult();
		
		return output(result);
	}
	
	private Exrate output(List<String> result) {
		
		Exrate exrate = new Exrate();
		for(int i = 4; i<(result.size()-4) ; i+=3) {
			exrate.getTimeList().add(result.get(i));
			exrate.getBuyList().add(Double.parseDouble(result.get(i+1)));
			exrate.getSellList().add(Double.parseDouble(result.get(i+2)));
		}
		return exrate;
	}

}
