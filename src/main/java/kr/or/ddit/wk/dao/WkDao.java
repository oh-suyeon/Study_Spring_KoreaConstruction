package kr.or.ddit.wk.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.wk.vo.WkVO;

@Repository
public class WkDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int create(WkVO wkVo) {
		return this.sqlSessionTemplate.insert("wk.insert", wkVo);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return this.sqlSessionTemplate.selectOne("wk.selectDetail", map);
	}
	
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return this.sqlSessionTemplate.selectList("wk.selectList", map);
	}
	
	public int count(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("wk.count", map);
	}
	
	public List<Map<String, Object>> selectListPage(Map<String, Object> map){
		return this.sqlSessionTemplate.selectList("wk.selectListPage", map);
	}
	
	public int update(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("wk.update", map);
	}

	public int delete(Map<String, Object> map) {
		return this.sqlSessionTemplate.delete("wk.delete", map);
	}
}
