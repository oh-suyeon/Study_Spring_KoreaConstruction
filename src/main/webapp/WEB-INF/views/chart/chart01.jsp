<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<script src="/resources/js/jquery-3.6.0.js"></script>
<!-- 구글 차트 호출을 위한 js 파일 라이브러리(CDN 방식) -->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>

<title>구글 차트 보이기(JSON)</title>

<script type="text/javascript">
	
	<!--위의 google 라이브러리를 통해 가져오는 객체 google을 메모리에 올리기-->
	google.load("visualization", "1", {"packages":["corechart"]});
	
	// 콜백 : 다 올렸나고 물어보고 작업하는 것. 로딩이 다 끝나야 함. 로딩 중에 하는게 아님. 
	// 로딩이 완료되면 drawChart라는 함수 호출.
	google.setOnLoadCallback(drawChart);

	// .responseText : json을 로컬에서 텍스트로 읽어들임. F12의 console에서 확인 가능
	function drawChart() {
		var jsonData =	$.ajax({
							url:"/json/sampleData.json"
							,dataType:"json"
							,async:false // 비동기. (새로고침 x)
						}).responseText;
		
		//받아온 json 데이터를 google 객체를 통해 데이터 테이블로 생성함
		var data = new google.visualization.DataTable(jsonData);
		
		// 차트 객체 생성
// 		var chart = new google.visualization.PieChart(document.getElementById("chart_div"));
// 		var chart = new google.visualization.ColumnChart(document.getElementById("chart_div"));
		var chart = new google.visualization.LineChart(document.getElementById("chart_div"));
		
		// 차트 객체.draw(데이터 테이블, 옵션)
		chart.draw(data, {title: "차트 예제01"
						  ,curveType: "function" // LineChart일때 선을 곡선으로 만들어줌
						  ,pointSize: 5 // LineChart일때 점 만들어줌
						  ,width: 600
						  ,height: 450});
	}
</script>
</head>
<body>
	<div id="chart_div"></div>
</body>
</html>