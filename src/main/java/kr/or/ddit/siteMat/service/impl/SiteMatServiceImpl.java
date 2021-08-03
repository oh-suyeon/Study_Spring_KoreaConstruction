package kr.or.ddit.siteMat.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.siteMat.dao.SiteMatDao;
import kr.or.ddit.siteMat.service.SiteMatService;
import kr.or.ddit.siteMat.vo.SiteMatVO;

@Service
public class SiteMatServiceImpl implements SiteMatService{

	@Autowired
	SiteMatDao siteMatDao;
	
	@Override
	public int create(Map<String, Object> map) {
		return siteMatDao.create(map);
	}

	// 선생님 따라하기
	@Override
	public SiteMatVO insert(SiteMatVO siteMatVo) {
		int affectedRowCount = siteMatDao.insert(siteMatVo);
		if(affectedRowCount > 0) {
			return siteMatVo;
		}
		return null;
	}
	
	// 선생님 따라하기
	@Override
	public Map<String, Object> selectDetail(SiteMatVO siteMatVo) {
		return siteMatDao.selectDetail(siteMatVo);
	}

	@Override
	public Map<String, Object> selectDetail_(int matNmCd) {
		return siteMatDao.selectDetail_(matNmCd);
	}
	
	@Override
	public List<Map<String, Object>> selectList(Map<String, Object> map) {
		return siteMatDao.selectList(map);
	}
	
	@Override
	public int count(Map<String, Object> map) {
		return siteMatDao.count(map);
	}
	
	@Override
	public List<Map<String, Object>> selectListPage(Map<String, Object> map) {
		return siteMatDao.selectListPage(map);
	}
	
	@Override
	public int update(Map<String, Object> map) {
		return siteMatDao.update(map);
	}

	@Override
	public int delete(Map<String, Object> map) {
		return siteMatDao.delete(map);
	}
}
