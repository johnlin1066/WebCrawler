package com.example.Dto;

import java.util.ArrayList;
import java.util.List;

public class Exrate {
	
	List<String> timeList = new ArrayList<String>();
	List<Double> buyList = new ArrayList<Double>();
	List<Double> sellList = new ArrayList<Double>();
	
	public List<String> getTimeList() {
		return timeList;
	}
	public void setTimeList(List<String> timeList) {
		this.timeList = timeList;
	}
	public List<Double> getBuyList() {
		return buyList;
	}
	public void setBuyList(List<Double> buyList) {
		this.buyList = buyList;
	}
	public List<Double> getSellList() {
		return sellList;
	}
	public void setSellList(List<Double> sellList) {
		this.sellList = sellList;
	}
}
