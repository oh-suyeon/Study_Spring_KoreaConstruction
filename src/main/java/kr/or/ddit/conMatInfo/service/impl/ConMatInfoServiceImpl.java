package kr.or.ddit.conMatInfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.conMatInfo.dao.ConMatInfoDao;
import kr.or.ddit.conMatInfo.service.ConMatInfoService;
import kr.or.ddit.conMatInfo.vo.ConMatInfoVO;

@Service
public class ConMatInfoServiceImpl implements ConMatInfoService{

	@Autowired
	ConMatInfoDao conMatInfoDao;
	
	@Override
	public List<ConMatInfoVO> selectList(Map<String, Object> map){
		return conMatInfoDao.selectList(map);
	}
	
}
