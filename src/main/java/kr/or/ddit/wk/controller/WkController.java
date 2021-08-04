package kr.or.ddit.wk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.common.vo.PagingVO;
import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.site.service.SiteService;
import kr.or.ddit.wk.service.WkService;
import kr.or.ddit.wk.vo.WkVO;

@Controller
@RequestMapping("/wk")
public class WkController {

	private static final Logger logger = LoggerFactory.getLogger(WkController.class);
	
	@Autowired
	WkService wkService;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	SiteService siteService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		logger.info(">>> wk/create");
		List<Map<String, Object>> empList = empService.selectList(new HashMap<String, Object>());
		List<Map<String, Object>> siteList = siteService.selectList(new HashMap<String, Object>());
		
		model.addAttribute("empList", empList);
		model.addAttribute("siteList", siteList);
		
		return "wk/create";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getEmpDetail")
	public Map<String, Object> getEmpDetail(@RequestParam Map<String, Object> map){
		Map<String, Object> empDetail = empService.selectDetail(map);
		return empDetail;
	}

	@ResponseBody
	@RequestMapping(value = "/getEmpList")
	public List<Map<String, Object>> getEmpNums(@RequestParam Map<String, Object> map){
		List<Map<String, Object>> empNumsList = empService.selectList(map);
		return empNumsList;
	}

	@ResponseBody
	@RequestMapping(value = "/getSiteList")
	public List<Map<String, Object>> getSiteNums(@RequestParam Map<String, Object> map){
		List<Map<String, Object>> siteNumsList = siteService.selectList(map);
		return siteNumsList;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createPost(@ModelAttribute WkVO wkVo) {
		WkVO result = wkService.create(wkVo);
		if(result != null) {
			return "redirect:/wk/detail/" + wkVo.getSiteNum() + "/" + wkVo.getEmpNum();
		}
		return "redirect:/wk/create";
	}
	
	@RequestMapping(value = "/detail/{siteNum}/{empNum}", method = RequestMethod.GET)
	public String detail(@PathVariable("siteNum") int siteNum, @PathVariable("empNum") int empNum, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("siteNum", siteNum);
		map.put("empNum", empNum);
		Map<String, Object> wk = wkService.selectDetail(map);
		Map<String, Object> siteDetail = siteService.selectDetail(siteNum);
		Map<String, Object> empDetail = empService.selectDetail(map);
		model.addAttribute("wk", wk);
		model.addAttribute("siteDetail", siteDetail);
		model.addAttribute("empDetail", empDetail);
		logger.info("wk : " + wk.toString());
		return "wk/detail";
	}
	
	@RequestMapping(value = "/list_")
	public String list(@RequestParam Map<String, Object> map, Model model) {
		List<Map<String, Object>> wkList =  wkService.selectList(map);
		model.addAttribute("wkList", wkList);
		return "wk/list";
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView listPage(PagingVO vo, @RequestParam Map<String, Object> map) {
		
		ModelAndView mav = new ModelAndView();

		int total = wkService.count(map);
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
		mav.addObject("wkList", wkService.selectListPage(map));
		if(map.containsKey("keyword")) {
			mav.addObject("keyword", map.get("keyword"));
		}
		mav.setViewName("wk/listPaging");
		
		return mav;
	}
	
	@RequestMapping(value = "/update/{wkNum}", method = RequestMethod.GET)
	public String update(@PathVariable("wkNum") String wkNum, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("wkNum", wkNum);
		Map<String, Object> wk = wkService.selectDetail(map);
		model.addAttribute("wk", wk);
		return "wk/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePost(@RequestParam Map<String, Object> map) {
		int result = wkService.update(map);
		if(result > 0) {
			return "redirect:/wk/detail/" + map.get("wkNum");
		}
		return "redirect:/wk/update/" + map.get("wkNum");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam Map<String, Object> map) {
		int result = wkService.delete(map);
		if(result > 0) {
			return "redirect:/wk/list";
		}
		return "redirect:/wk/detail/" + map.get("wkNum");
	}
	
	
}
