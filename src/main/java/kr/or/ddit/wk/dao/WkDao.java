package kr.or.ddit.wk.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WkDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int create(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("wk.create", map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return this.sqlSessionTemplate.selectOne("wk.selectDetail", map);
	}
	
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return this.sqlSessionTemplate.selectList("wk.selectList", map);
	}
	
	public int count(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne("wk.count", map);
	}
	
	public List<Map<String, Object>> selectListPage(Map<String, Object> map){
		return sqlSessionTemplate.selectList("wk.selectListPage", map);
	}
	
	public int update(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("wk.update", map);
	}

	public int delete(Map<String, Object> map) {
		return this.sqlSessionTemplate.delete("wk.delete", map);
	}
}
