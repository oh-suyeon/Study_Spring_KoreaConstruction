package kr.or.ddit.siteMat.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.siteMat.vo.SiteMatVO;

@Repository
public class SiteMatDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int create(Map<String, Object> map) {
		return sqlSessionTemplate.insert("siteMat.create",map);
	}
	
	// 선생님 따라하기 
	public int insert(SiteMatVO siteMatVo) {
		return sqlSessionTemplate.insert("siteMat.insert",siteMatVo);
	}
	
	// 선생님 따라하기
	public Map<String, Object> selectDetail(SiteMatVO siteMatVo){
		return sqlSessionTemplate.selectOne("siteMat.selectDetail", siteMatVo);
	}
	
	public Map<String, Object> selectDetail_(int matNmCd){
		return sqlSessionTemplate.selectOne("siteMat.selectDetail_", matNmCd);
	}
	
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return sqlSessionTemplate.selectList("siteMat.selectList", map);
	}
	
	public int count(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne("siteMat.count", map);
	}
	
	public List<Map<String, Object>> selectListPage(Map<String, Object> map){
		return sqlSessionTemplate.selectList("siteMat.selectListPage", map);
	}
	
	public int update(Map<String, Object> map) {
		return sqlSessionTemplate.update("siteMat.update", map);
	}
	
	public int delete(Map<String, Object> map) {
		return sqlSessionTemplate.delete("siteMat.delete", map);
	}
	
}
