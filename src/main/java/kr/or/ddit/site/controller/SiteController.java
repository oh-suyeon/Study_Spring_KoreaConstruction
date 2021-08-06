package kr.or.ddit.site.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.common.vo.PagingVO;
import kr.or.ddit.site.service.SiteService;

@RequestMapping("/site")
@Controller
public class SiteController {
	
	@Autowired
	SiteService siteService;
	
	private static final Logger logger = LoggerFactory.getLogger(SiteController.class);
	
	@RequestMapping(value = "/create_", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		logger.info("create");
		mav.setViewName("site/create");
		return mav;
	}
	
	@RequestMapping(value = "/create_", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		int result = siteService.create(map);
		logger.info("result : " + result);
		if(result > 0) {
			mav.setViewName("redirect:/site/detail/" + map.get("siteNum"));
		}else {
			mav.setViewName("redirect:/site/create");
		}
		return mav;
	}
	
	// 선생님 따라 하기 
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String insert(@RequestParam Map<String, Object> map, Model model) {
		if(map.containsKey("atPopup")) {
			model.addAttribute("atPopup", map.get("atPopup"));
		}
		return "site/create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView insertPost(ModelAndView mav, @RequestParam Map<String, Object> map) {
		logger.info("siteVo : " + map.toString());
		int siteNum = this.siteService.insert(map);
		
		if(siteNum>0 && "true".equals(map.get("atPopup"))) {
			mav.setViewName("site/closePopup");
			return mav;
		}
		
		if(siteNum>0) {
			mav.setViewName("redirect:/site/detail/" + siteNum);
		}else{
			mav.setViewName("redirect:/site/create");
		}
		return mav;
	}
	
	
	@RequestMapping(value = "/detail/{siteNum}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("siteNum") int siteNum) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> siteDetail = siteService.selectDetail(siteNum);
		mav.addObject("siteDetail", siteDetail);
		mav.setViewName("site/detail");
		return mav;
	}
	
	@RequestMapping(value = "/list_")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> siteList =  siteService.selectList(map);
		if(map.containsKey("keyword")) {
			mav.addObject("keyword", map.get("keyword"));
		}
		mav.addObject("siteList", siteList);
		mav.setViewName("site/list");
		return mav;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView listPage(PagingVO vo, @RequestParam Map<String, Object> map) {
		
		ModelAndView mav = new ModelAndView();

		int total = siteService.count(map);
		int nowPage = 1;
		int cntPerPage = 5;
		
		if(map.containsKey("nowPage")) {
			nowPage = Integer.valueOf((String)map.get("nowPage"));
		}
		if(map.containsKey("cntPerPage")) {
			cntPerPage = Integer.valueOf((String)map.get("cntPerPage"));
		}
		
		vo = new PagingVO(total, nowPage, cntPerPage);
		
		map.put("start", vo.getStart());
		map.put("end", vo.getEnd());
		
		mav.addObject("paging", vo);
		mav.addObject("siteList", siteService.selectListPage(map));
		if(map.containsKey("keyword")) {
			mav.addObject("keyword", map.get("keyword"));
		}
		mav.setViewName("site/listPaging");
		
		return mav;
	}
	
	@RequestMapping(value = "/update/{siteNum}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("siteNum") int siteNum) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> siteDetail = siteService.selectDetail(siteNum);
		mav.addObject("siteDetail", siteDetail);
		mav.setViewName("site/update");
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		int result = siteService.update(map);
		if(result > 0) {
			mav.setViewName("redirect:/site/detail/" + map.get("siteNum"));
		}else {
			mav = this.update((int)map.get("siteNum"));
		}
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		int result = siteService.delete(map);
		if(result > 0) {
			mav.setViewName("redirect:/site/list");
		}else {
			mav = this.detail((int)map.get("siteNum"));
		}
		return mav;
	}
	
}
