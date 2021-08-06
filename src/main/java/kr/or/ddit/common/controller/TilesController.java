package kr.or.ddit.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesController {
	
	@RequestMapping(value = "/tiles/body1")
	public String tiles1() {
		System.out.println(">>>>> in");
		return "test1/body1";
	}
	
}
