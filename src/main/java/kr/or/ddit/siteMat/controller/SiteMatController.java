package kr.or.ddit.siteMat.controller;

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
import kr.or.ddit.conMatInfo.service.ConMatInfoService;
import kr.or.ddit.conMatInfo.vo.ConMatInfoVO;
import kr.or.ddit.site.service.SiteService;
import kr.or.ddit.siteMat.service.SiteMatService;
import kr.or.ddit.siteMat.vo.SiteMatVO;


@Controller
@RequestMapping("/siteMat")
public class SiteMatController {

	@Autowired
	SiteService siteService;
	
	@Autowired
	SiteMatService siteMatService;
	
	@Autowired
	ConMatInfoService conMatInfoService;
	
	private static final Logger logger = LoggerFactory.getLogger(SiteMatController.class);
	
	// 선생님 따라하기
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		List<ConMatInfoVO> conMatInfoList = conMatInfoService.selectList(new HashMap<>());
		model.addAttribute("conMatInfoList", conMatInfoList);
		return "siteMat/create";
	}

	@RequestMapping(value = "/create_", method = RequestMethod.POST)
	public String createPost(@RequestParam Map<String, Object> map) {
		logger.info(">>>>createPost");
		logger.info(map.toString());
		
		int result = siteMatService.create(map);
		if(result > 0) {
			return "redirect:/siteMat/detail/"+map.get("matNmCd"); 
		}
		return "redirect:/siteMat/create";
	}
	
	// 선생님 따라하기
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String insertPost(@ModelAttribute SiteMatVO siteMatVo) {
		logger.info(">>>>insertPost - siteMatVo: " + siteMatVo);
		
		SiteMatVO result = siteMatService.insert(siteMatVo);
		if(result != null) {
			return "redirect:/siteMat/detail/" + result.getSiteNum() + "/" + result.getMatNmCd(); 
		}
		return "redirect:/siteMat/create";
	}
	
	// 선생님 따라하기 
	@RequestMapping(value = "/detail/{siteNum}/{matNmCd}", method = RequestMethod.GET)
	public String detail(@PathVariable("matNmCd") String matNmCd, @PathVariable("siteNum") int siteNum, Model model) {
		SiteMatVO siteMatVo = new SiteMatVO();
		siteMatVo.setSiteNum(siteNum);
		siteMatVo.setMatNmCd(matNmCd);
		
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", matNmCd);
		List<ConMatInfoVO> itemNmList = conMatInfoService.selectList(map);
		String itemNm = itemNmList.get(0).getItemNm();
		
		Map<String, Object> result = siteMatService.selectDetail(siteMatVo);
		result.put("matNm", itemNm);
		model.addAttribute("siteMat", result);
		return "siteMat/detail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getSiteNumList", method = RequestMethod.GET)
	public List<Map<String, Object>> getSiteNumList(){
		List<Map<String, Object>> list = siteService.selectList(new HashMap<>());
		logger.info(list.toString());
		return list;
	}
	
	// 선생님 따라하기(사업장 번호, 사업장 명, 주소)
	@RequestMapping(value = "/selectSite", method = RequestMethod.GET)
	public String selectSite(Model model) {
		List<Map<String, Object>> list = siteService.selectList(new HashMap<>());
		model.addAttribute("list", list);
		logger.info(">>>>>>>>>>>>> list : " + list.toString());
		return "siteMat/selectSite";
	}
	
	@RequestMapping(value = "/detail_/{matNmCd}", method = RequestMethod.GET)
	public String detail_(@PathVariable("matNmCd") int matNmCd, Model model) {
		Map<String, Object> siteMat = siteMatService.selectDetail_(matNmCd);
		model.addAttribute("siteMat", siteMat);
		return "siteMat/detail";
	}
	
	@RequestMapping(value = "/list_")
	public String selectList(@RequestParam Map<String, Object> map, Model model) {
		List<Map<String, Object>> siteMatList = siteMatService.selectList(map);
		if(map.containsKey("keyword")) {
			model.addAttribute("keyword", map.get("keyword"));
		}
		model.addAttribute("siteMatList", siteMatList);
		return "siteMat/list";
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView listPage(PagingVO vo, @RequestParam Map<String, Object> map) {
		
		ModelAndView mav = new ModelAndView();

		int total = siteMatService.count(map);
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
		mav.addObject("siteMatList", siteMatService.selectListPage(map));
		
		if(map.containsKey("keyword")) {
			mav.addObject("keyword", map.get("keyword"));
		}
		mav.setViewName("siteMat/listPaging");
		
		return mav;
	}
	
	@RequestMapping(value = "/update/{siteNum}/{matNmCd}", method = RequestMethod.GET)
	public String update(@PathVariable("siteNum") int siteNum, @PathVariable("matNmCd") String matNmCd, Model model) {
		SiteMatVO siteMatVo = new SiteMatVO();
		siteMatVo.setSiteNum(siteNum);
		siteMatVo.setMatNmCd(matNmCd);

		List<ConMatInfoVO> conMatInfoList = conMatInfoService.selectList(new HashMap<>());
		model.addAttribute("conMatInfoList", conMatInfoList);

		Map<String, Object> siteMat = siteMatService.selectDetail(siteMatVo);
		model.addAttribute("siteMat", siteMat);
		return "siteMat/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestParam Map<String, Object> map, Model model) {
		int result = siteMatService.update(map);
		if(result > 0) {
			return "redirect:/siteMat/detail/" + map.get("siteNum") + "/"+map.get("matNmCd");
		}
		return "redirect:/siteMat/update/" + map.get("siteNum") + "/"+map.get("matNmCd");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String detail(@RequestParam Map<String, Object> map, Model model) {
		int result = siteMatService.delete(map);
		if(result > 0) {
			return "redirect:/siteMat/list/";
		}
		return "redirect:/siteMat/detail/" + map.get("siteNum") + "/"+map.get("matNmCd");
	}
}
