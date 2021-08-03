package kr.or.ddit.emp.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.emp.vo.EmpVO;

@Repository
public class EmpDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int create(Map<String, Object> map) {
		return sqlSessionTemplate.insert("emp.create", map);
	}
	
	// 선생님 따라 하기 
	public int insert(EmpVO empVo) {
		return sqlSessionTemplate.insert("emp.insert", empVo);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return sqlSessionTemplate.selectOne("emp.selectDetail", map);
	}
	
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return sqlSessionTemplate.selectList("emp.selectList", map);
	}
	
	public int count(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne("emp.count", map);
	}
	
	public List<Map<String, Object>> selectListPage(Map<String, Object> map){
		return sqlSessionTemplate.selectList("emp.selectListPage", map);
	}
	
	public int update(Map<String, Object> map) {
		return sqlSessionTemplate.update("emp.update", map);
	}
	
	public int delete(Map<String, Object> map) {
		return sqlSessionTemplate.delete("emp.delete", map);
	}
	
}
