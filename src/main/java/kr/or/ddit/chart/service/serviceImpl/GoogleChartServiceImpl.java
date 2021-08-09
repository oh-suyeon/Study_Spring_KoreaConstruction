package kr.or.ddit.chart.service.serviceImpl;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.chart.dao.GoogleChartDao;
import kr.or.ddit.chart.service.GoogleChartService;

@Service
public class GoogleChartServiceImpl implements GoogleChartService{
	
	private static Logger logger = LoggerFactory.getLogger(GoogleChartServiceImpl.class);
	
	@Autowired
	GoogleChartDao googleChartDao;
	
	
	@Override
	public JSONObject getChartData() {
		List<Map<String, Object>> list = this.googleChartDao.cartMoney();
		 
		//0. 리턴할 json 객체. list -> json
		JSONObject data = new JSONObject(); // {} 껍데기 생성
		
		//1. cols 배열에 넣기
		//json 컬럼 객체 
		JSONObject col1 = new JSONObject(); // 상품명
		JSONObject col2 = new JSONObject(); // 판매금액
		col1.put("label", "상품명"); col1.put("type",  "string");
		col2.put("label", "판매가격"); col2.put("type",  "number");
		
		//타이틀 행에 컬럼 추가
		//json 배열 객체
		JSONArray title = new JSONArray(); 
		title.add(col1);
		title.add(col2);
		
		//json 객체에 타이틀행 추가
		data.put("cols", title);
		
		//2. rows 배열에 넣기
		JSONArray body = new JSONArray();
		for(Map<String, Object> map : list) {
			JSONObject prodName = new JSONObject(); // 상품명
			prodName.put("v", map.get("prodName")); // DB 데이터 넣기
			JSONObject money = new JSONObject(); // 판매금액
			money.put("v", map.get("money")); // DB 데이터 넣기
			
			JSONArray row = new JSONArray(); 
			row.add(prodName);
			row.add(money);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			
			body.add(cell); //json 객체에 바디행 추가
		} // body 처리 끝
		data.put("rows", body);
		
		return data;
	}
	
}
