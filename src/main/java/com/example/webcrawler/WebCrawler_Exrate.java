package com.example.webcrawler;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WebCrawler_Exrate extends WebCrawlerProcess{

	public WebCrawler_Exrate(String url, int delayTime) {
		super(url, delayTime);
	}

	@Override
	void adjustPage(WebDriver webDriver) {
		JavascriptExecutor js;
	    
	    if (webDriver instanceof JavascriptExecutor) {
	        js = (JavascriptExecutor)webDriver;
	    } else {
	        throw new IllegalStateException("This driver cannot run JavaScript.");
	    }
	    
	    js.executeScript("$(\".pageNumber a:eq(0)\").click()");
	}
	@Override
	Elements parseHtml(Document document) {
		if(document == null){
	        System.out.println("document is null, unable to continue! ");
	        return null;
	    }
	    
	    Element content = document.getElementById("inteTable");
	    Elements elements = content.select("td");
	    
		return elements;
	}
}
