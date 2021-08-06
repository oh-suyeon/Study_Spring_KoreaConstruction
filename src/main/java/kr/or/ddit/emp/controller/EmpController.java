package kr.or.ddit.emp.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import kr.or.ddit.emp.service.EmpService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp")
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	EmpService empService;
	
	@RequestMapping(value = "/create_", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		logger.info("create");
		mav.setViewName("emp/create");
		return mav;
	}

	@RequestMapping(value = "/create_", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		log.info(map.toString());
		int result = empService.create(map);
		logger.info("result : " + result);
		if(result > 0) {
			mav.setViewName("redirect:/emp/detail/" + map.get("empNum"));
		}else {
			mav.setViewName("redirect:/emp/create");
		}
		return mav;
	}
	
	// 선생님 따라하기 ] 미리 선택지 넣어 놓기
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView insert(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		List<String> posList = new ArrayList<>(); // DB에서 끌어오는 게 정석
		posList.add("사장"); posList.add("부장"); posList.add("과장"); posList.add("대리"); posList.add("사원");
		
		List<String> deptNmList = new ArrayList<>();
		deptNmList.add("인사부"); deptNmList.add("개발부"); deptNmList.add("회계부");
		
		mav.addObject("posList", posList);
		mav.addObject("deptNmList", deptNmList);
		
		if(map.containsKey("atPopup")) {
			mav.addObject("atPopup", map.get("atPopup"));
			mav.setViewName("emp/popup/create");
			return mav;
		}
		
		mav.setViewName("emp/create");
		return mav;
	}
	
	// 선생님 따라하기 ] VO 파라미터로 해보기
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String insertPost(@RequestParam Map<String, Object> map, Model model) {
		int affectedRowCount = this.empService.create(map);
		logger.info("create pop map >> " + map);
		if(affectedRowCount > 0 && "true".equals(map.get("atPopup"))) {
			return "emp/popup/closePopup";
		}
		
		if(affectedRowCount > 0) {
			return "redirect:/emp/detail/" + map.get("empNum");
		}else {
			return "redirect:/emp/create";
		}
	}
	
	@RequestMapping(value = "/detail/{empNum}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("empNum") String empNum) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> param = new HashMap<>();
		param.put("empNum",empNum);
		Map<String, Object> empDetail = empService.selectDetail(param);
		mav.addObject("empDetail", empDetail);
		mav.setViewName("emp/detail");
		return mav;
	}
	
	@RequestMapping(value = "/list_")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> empList =  empService.selectList(map);
		if(map.containsKey("keyword")) {
			mav.addObject("keyword", map.get("keyword"));
		}
		mav.addObject("empList", empList);
		mav.setViewName("emp/list");
		return mav;
	}

	@RequestMapping(value = "/list")
	public ModelAndView listPage(PagingVO vo, @RequestParam Map<String, Object> map) {
		
		ModelAndView mav = new ModelAndView();

		int total = empService.count(map);
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
		mav.addObject("empList", empService.selectListPage(map));
		if(map.containsKey("keyword")) {
			mav.addObject("keyword", map.get("keyword"));
		}
		mav.setViewName("emp/listPaging");
		
		return mav;
	}
	
	@RequestMapping(value = "/update/{empNum}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("empNum") String empNum) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> param = new HashMap<>();
		param.put("empNum",empNum);
		Map<String, Object> empDetail = empService.selectDetail(param);
		mav.addObject("empDetail", empDetail);
		mav.setViewName("emp/update");
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		int result = empService.update(map);
		if(result > 0) {
			mav.setViewName("redirect:/emp/detail/" + map.get("empNum"));
		}else {
			mav = this.update((String)map.get("empNum"));
		}
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		int result = empService.delete(map);
		if(result > 0) {
			mav.setViewName("redirect:/emp/list");
		}else {
			mav = this.detail((String)map.get("empNum"));
		}
		return mav;
	}
}
