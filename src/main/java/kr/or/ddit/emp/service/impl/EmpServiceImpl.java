package kr.or.ddit.emp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.emp.dao.EmpDao;
import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.vo.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	EmpDao empDao;
	
	@Override
	public int create(Map<String, Object> map) {
		return empDao.create(map);
	}
	
	// 선생님 따라하기
	@Override
	public int insert(EmpVO empVo) {
		int affectedRowCount = empDao.insert(empVo);
		if(affectedRowCount > 0) {
			return empVo.getEmpNum(); //insert 성공 시 해당 데이터의 기본 값을 반환
		}
		return 0;
		
	}
	
	@Override
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return empDao.selectDetail(map);
	}
	
	@Override
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return empDao.selectList(map);
	}
	
	@Override
	public int count(Map<String, Object> map) {
		return empDao.count(map);
	}
	
	@Override
	public List<Map<String, Object>> selectListPage(Map<String, Object> map) {
		return empDao.selectListPage(map);
	}

	@Override
	public List<Map<String, Object>> selectListPage2(Map<String, Object> map) {
		return empDao.selectListPage2(map);
	}

	@Override
	public int update(Map<String, Object> map){
		return empDao.update(map);
	}

	@Override
	public int delete(Map<String, Object> map){
		return empDao.delete(map);
	}
}
