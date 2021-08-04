<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>근로 정보 등록</title>
<script src="/resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		$("#getEmpNums").click(function(event) { 
			$.ajax({
				url: '/wk/getEmpNums'
				,dataType: 'json'
				,type: 'get'
				,success: function(data) {
					$(data).each(function(idx, item) {
						$("#empNum").append("<option>"+ item.empNum +"</option>");
					});
				}
				,error: function(result) {
					console.log(result);
				}
			});
		});
		$("#getSiteNums").click(function(event) { 
			$.ajax({
				url: '/wk/getSiteNums'
				,dataType: 'json'
				,type: 'get'
				,success: function(data) {
					$(data).each(function(idx, item) {
						$("#siteNum").append("<option>"+ item.siteNum +"</option>");
					});
				}
				,error: function(result) {
					console.log(result);
				}
			});
		});
	});
	
</script>
</head>
<body>
	<h2>근로 정보 등록</h2>
	<form method="post" action="/wk/create">
		<p>
			사원 번호 : 
			<button type="button" id="getEmpNums">검색</button>
			<select name="empNum" id="empNum">
				<option>===선택===</option>
			</select>
		</p>
		<p>
			사업장 번호 : 
			<button type="button" id="getSiteNums">검색</button>
			<select name="siteNum" id="siteNum">
				<option>===선택===</option>
			</select>
		</p>
		<p>
			시작 일 : <input type="date" name="inDt" />
		</p>
		<p>
			종료 일 : <input type="date" name="outDt" />
		</p>
		<input type="submit" value="등록" />
	</form>
</body>
</html>