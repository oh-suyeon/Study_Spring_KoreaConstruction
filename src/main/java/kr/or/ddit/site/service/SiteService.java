package kr.or.ddit.site.service;

import java.util.List;
import java.util.Map;

public interface SiteService {

	public int create(Map<String, Object> map);

	public int insert(Map<String, Object> map);

	public Map<String, Object> selectDetail(int siteNum);

	public List<Map<String, Object>> selectList(Map<String, Object> map);
	
	public int count(Map<String, Object> map);

	public List<Map<String, Object>> selectListPage(Map<String, Object> map);

	public int update(Map<String, Object> map);

	public int delete(Map<String, Object> map);

	
}
