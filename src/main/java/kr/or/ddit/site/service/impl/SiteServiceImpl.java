package kr.or.ddit.site.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.site.dao.SiteDao;
import kr.or.ddit.site.service.SiteService;

@Service
public class SiteServiceImpl implements SiteService{

	@Autowired
	SiteDao siteDao;
	
	@Override
	public int create(Map<String, Object> map) {
		return siteDao.create(map);
	}
	
	@Override
	public int insert(Map<String, Object> map) {
		return siteDao.insert(map);
	}
	
	@Override
	public Map<String, Object> selectDetail(int siteNum){
		return siteDao.selectDetail(siteNum);
	}
	
	@Override
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return siteDao.selectList(map);
	}
	
	@Override
	public int count(Map<String, Object> map) {
		return siteDao.count(map);
	}
	
	@Override
	public List<Map<String, Object>> selectListPage(Map<String, Object> map) {
		return siteDao.selectListPage(map);
	}
	
	@Override
	public int update(Map<String, Object> map) {
		return siteDao.update(map);
	}
	
	@Override
	public int delete(Map<String, Object> map) {
		return siteDao.delete(map);
	}
}
