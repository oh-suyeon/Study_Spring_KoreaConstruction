package kr.or.ddit.chart.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.chart.service.GoogleChartService;

@Controller
@RequestMapping("/chart/*")
public class GoogleChartController {
	
	@Autowired
	GoogleChartService googleChartService;
	
	@RequestMapping("/chart01")
	public ModelAndView chart01() {
		return new ModelAndView("chart/chart01");
	}
	
	@RequestMapping("/chart01Multi")
	public String chart01Multi() {
		return "chart/chart01Multi"; 
	}
	
	@RequestMapping("/chart02")
	public String chart02() {
		return "chart/chart02";
	}
	
	@ResponseBody
	@RequestMapping("/chart02_money")
	public JSONObject chart02_money() {
		JSONObject data = this.googleChartService.getChartData();
		return data;
	}
}
