<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<title>구글 차트(Oracle DBMS)</title>
<script type="text/javascript">
	google.load("visualization", "1", {"packages":["corechart"]});
	
	google.setOnLoadCallback(drawChart);

	function drawChart() {
		var jsonData = $.ajax({
			url:"/chart/chart02_money"
			,dataType:"json"
			,async:false // 비동기. (새로고침 x)
		}).responseText;
		
		console.log(jsonData);
		
		var data = new google.visualization.DataTable(jsonData);
		
		var chart = new google.visualization.LineChart(document.getElementById("chart_div"));

		chart.draw(data, {title: "상품 별 판매금액 합계"
						  ,curveType: "function" // LineChart일때 선을 곡선으로 만들어줌
						  ,pointSize: 10 // LineChart일때 점 만들어줌
						  ,width: 1000
						  ,height: 600});
	}
</script>
</head>
<body>
	<div id="chart_div"></div>
</body>
</html>