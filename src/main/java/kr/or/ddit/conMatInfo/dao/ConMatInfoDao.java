package kr.or.ddit.conMatInfo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.conMatInfo.vo.ConMatInfoVO;

@Repository
public class ConMatInfoDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<ConMatInfoVO> selectList(Map<String, Object> map){
		return this.sqlSessionTemplate.selectList("conMatInfo.selectList", map);
	}
	
	
}
