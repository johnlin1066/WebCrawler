package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Dto.Exrate;
import com.example.service.ExrateService;

@RestController
public class ExrateController {
	
	@Autowired
	ExrateService exrateService;
	
	@GetMapping("/")
	public ModelAndView home(String s) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/exrate")
	public ModelAndView exrate(String currency) {
		String url = "https://www.esunbank.com.tw/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency="+currency;
		Exrate exrate = exrateService.crawlerExrate(url);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("currencyType", currency.split("/")[0]);
		mv.addObject("timeList", exrate.getTimeList());
		mv.addObject("buyList", exrate.getBuyList());
		mv.addObject("sellList", exrate.getSellList());
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/exrateREST")
	public Exrate exrateREST(String currency) {
		String url = "https://www.esunbank.com.tw/bank/personal/deposit/rate/forex/exchange-rate-chart?Currency="+currency;
		return exrateService.crawlerExrate(url);
	}

}
