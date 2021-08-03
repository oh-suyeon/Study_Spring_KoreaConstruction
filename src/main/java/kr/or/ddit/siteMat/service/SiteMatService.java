package kr.or.ddit.siteMat.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.siteMat.vo.SiteMatVO;

public interface SiteMatService {

	public int create(Map<String, Object> map);

	public SiteMatVO insert(SiteMatVO siteMatVo);
	
	public Map<String, Object> selectDetail(SiteMatVO siteMatVo);

	public Map<String, Object> selectDetail_(int matNmCd);
	
	public List<Map<String, Object>> selectList(Map<String, Object> map);

	public int count(Map<String, Object> map);

	public List<Map<String, Object>> selectListPage(Map<String, Object> map);
	
	public int update(Map<String, Object> map);

	public int delete(Map<String, Object> map);
}
