package kr.or.ddit.wk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.wk.dao.WkDao;
import kr.or.ddit.wk.service.WkService;
import kr.or.ddit.wk.vo.WkVO;

@Service
public class WkServiceImpl implements WkService{
	
	@Autowired
	WkDao wkDao;
	
	@Override
	public WkVO create(WkVO wkVo) {
		int affectedRowCount = wkDao.create(wkVo);
		if(affectedRowCount > 0) {
			return wkVo;
		}
		return null;
	}
	
	@Override
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return wkDao.selectDetail(map);
	}
	
	@Override
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return wkDao.selectList(map);
	}
	
	@Override
	public int count(Map<String, Object> map) {
		return wkDao.count(map);
	}
	
	@Override
	public List<Map<String, Object>> selectListPage(Map<String, Object> map) {
		return wkDao.selectListPage(map);
	}
	
	@Override
	public int update(Map<String, Object> map) {
		return wkDao.update(map);
	}

	@Override
	public int delete(Map<String, Object> map) {
		return wkDao.delete(map);
	}
}
