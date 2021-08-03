package kr.or.ddit.wk.service;

import java.util.List;
import java.util.Map;

public interface WkService {

	public int create(Map<String, Object> map);

	public Map<String, Object> selectDetail(Map<String, Object> map);

	public List<Map<String, Object>> selectList(Map<String, Object> map);
	
	public int count(Map<String, Object> map);

	public List<Map<String, Object>> selectListPage(Map<String, Object> map);

	public int update(Map<String, Object> map);

	public int delete(Map<String, Object> map);

}
