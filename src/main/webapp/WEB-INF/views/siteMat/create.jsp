<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사업장 등록</title>

<link rel="stylesheet" href="/resources/js/jquery-ui-1.12.1.custom/jquery-ui.css">
<script src="/resources/js/jquery-3.6.0.js"></script>
<script src="/resources/js/jquery-ui-1.12.1.custom/jquery-ui.js"></script>

<script type="text/javascript">
	$(function() {

		$("#siteNumList").on("click", function() {
			window.open("/siteMat/selectSite", "owin"
						,"width=700px,height=700px,scrollbars=yes");
		});

		$("#purDt").datepicker({
			dateFormat: 'yy-mm-dd' 
			,changeMonth: true
			,changeYear: true
			,dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일']
			,dayNamesMin: ['월','화','수','목','금','토','일']
			,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		});
		
	});
</script>
</head>
<body>
	<h2>사업 자재 등록</h2>
	<form method="post" action="/siteMat/create">
		<p>
			사업장 번호 : 
			<input type="text" name="siteNum" id="siteNum"/>
			<button type="button" id="siteNumList">검색</button>
		</p>
		<p>
			자재 명 : 
			<select name="matNmCd">
				<c:forEach var="conMatInfo" items="${conMatInfoList}">
					<option value="${conMatInfo.matNmCd}">${conMatInfo.itemNm}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			수량 : 
<!-- 			<input type="number" name="cnt" min="1" max="100"/> -->
			<select name="cnt">
				<c:forEach var="i" begin="1" end="100">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			구입 일자 : <input type="text" name="purDt" id="purDt"/>
		</p>
		<p>
			구입 금액 : <input type="number" name="purPri" />
		</p>
		<input type="submit" value="등록" />
	</form>
</body>
</html>