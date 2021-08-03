package kr.or.ddit.conMatInfo.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.conMatInfo.vo.ConMatInfoVO;

public interface ConMatInfoService {

	public List<ConMatInfoVO> selectList(Map<String, Object> map);

}
