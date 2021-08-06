package kr.or.ddit.emp.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.emp.vo.EmpVO;

public interface EmpService {

	public int create(Map<String, Object> map);

	public int insert(EmpVO empVo);

	public Map<String, Object> selectDetail(Map<String, Object> map);

	public List<Map<String, Object>> selectList(Map<String, Object> map);

	public int count(Map<String, Object> map);

	public List<Map<String, Object>> selectListPage(Map<String, Object> map);

	public List<Map<String, Object>> selectListPage2(Map<String, Object> map);

	public int update(Map<String, Object> map);

	public int delete(Map<String, Object> map);



}
