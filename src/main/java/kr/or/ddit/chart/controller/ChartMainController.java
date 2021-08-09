package kr.or.ddit.chart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart/*")
public class ChartMainController {
	
	@RequestMapping("/chartMain")
	public String chartMain() {
		return "chart/chartMain";
	}
	
}
