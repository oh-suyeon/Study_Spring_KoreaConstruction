package kr.or.ddit.site.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SiteDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int create(Map<String, Object> map) {
		return sqlSessionTemplate.insert("site.create", map);
	}
	
	// 선생님 따라 하기
	public int insert(Map<String, Object> map) {
		int affectedRowCount = this.sqlSessionTemplate.insert("site.insert", map);
		if(affectedRowCount > 0) {
			return Integer.parseInt((String.valueOf(map.get("siteNum"))));
		}
		return 0;
	}
	
	public Map<String, Object> selectDetail(int siteNum){
		return sqlSessionTemplate.selectOne("site.selectDetail",siteNum);
	}
	
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return sqlSessionTemplate.selectList("site.selectList", map);
	}
	
	public int count(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne("site.count", map);
	}
	
	public List<Map<String, Object>> selectListPage(Map<String, Object> map){
		return sqlSessionTemplate.selectList("site.selectListPage", map);
	}

	public List<Map<String, Object>> selectListPage2(Map<String, Object> map){
		return sqlSessionTemplate.selectList("site.selectListPage2", map);
	}
	
	public int update(Map<String, Object> map) {
		return sqlSessionTemplate.update("site.update", map);
	}
	
	public int delete(Map<String, Object> map) {
		return sqlSessionTemplate.delete("site.delete", map);
	}
	
}
