<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<script src="/resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>

<title>구글 멀티 차트(JSON)</title>

<script type="text/javascript">

	google.load("visualization", "1", {"packages":["corechart"]});
	
	google.setOnLoadCallback(drawChart);
	google.setOnLoadCallback(drawChart2);

	function drawChart() {
		var jsonData = $.ajax({
			url:"/json/sampleData.json"
			,dataType:"json"
			,async:false 
		}).responseText;
		
		console.log(jsonData);
		
		var data = new google.visualization.DataTable(jsonData);
		var chart = new google.visualization.ColumnChart(document.getElementById("chart_div"));
		chart.draw(data, {title: "차트 예제01"
						  ,width: 600
						  ,height: 450});
	}
	
	function drawChart2() {
		var jsonData = $.ajax({
			url:"/json/sampleData2.json"
			,dataType:"json"
			,async:false
		}).responseText;
		
		console.log(jsonData);
		
		var data = new google.visualization.DataTable(jsonData);
		var chart = new google.visualization.LineChart(document.getElementById("chart_div2"));
		chart.draw(data, {title: "차트 예제02"
						  ,curveType: "function" 
						  ,width: 600
						  ,height: 450});
	}
</script>
</head>
<body>
	<div id="chart_div"></div>
	<div id="chart_div2"></div>
</body>
</html>