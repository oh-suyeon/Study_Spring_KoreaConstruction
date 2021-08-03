<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사업장 등록</title>
<script src="/resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		$("#getSiteNums").click(function(event) { 
			$.ajax({
				url: '/siteMat/getSiteNumList'
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
	<h2>사업 자재 등록</h2>
	<form method="post" action="/siteMat/create">
		<p>
			사업장 번호 : 
			<button type="button" id="getSiteNums">검색</button>
			<select name="siteNum" id="siteNum">
				<option>===선택===</option>
			</select>
		</p>
		<p>
			자재 명 : <input type="text" name="matNm" />
		</p>
		<p>
			구입 일 : <input type="date" name="purDt" />
		</p>
		<p>
			수량 : <input type="number" name="cnt" />
		</p>
		<p>
			구입 금액 : <input type="number" name="purPri" />
		</p>
		<input type="submit" value="등록" />
	</form>
</body>
</html>