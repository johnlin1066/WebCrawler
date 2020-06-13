package com.example.webcrawler;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class WebCrawlerProcess {

	private String url = null;
	private int delayTime = 0;

	private List<String> result = null;

	public final void crawlerProcess() {

		WebDriver webDriver = initial();
		adjustPage(webDriver);
		Document document = readHtml(webDriver);

		Elements elements = parseHtml(document);
		packageResult(elements);

	}

	public WebCrawlerProcess(String url, int delayTime) {
		this.url = url;
		this.delayTime = delayTime;
	}

	WebDriver initial() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();

		webDriver.get(url);
		try {
			Thread.sleep(delayTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return webDriver;
	}

	abstract void adjustPage(WebDriver webDriver);

	Document readHtml(WebDriver webDriver) {
		Document document = null;

		document = Jsoup.parse(webDriver.getPageSource());
		webDriver.close();
		webDriver.quit();

		return document;
	}

	abstract Elements parseHtml(Document document);

	void packageResult(Elements elements) {
		result = new ArrayList<>();

		elements.forEach(e -> result.add(e.text()));
	}

	public List<String> getResult() {
		return result;
	}
}
