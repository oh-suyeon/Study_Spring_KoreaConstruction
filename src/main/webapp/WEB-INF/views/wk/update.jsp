<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>근로 정보 수정</title>
<link rel="stylesheet" href="/resources/js/jquery-ui-1.12.1.custom/jquery-ui.css">
<script src="/resources/js/jquery-3.6.0.js"></script>
<script src="/resources/js/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		
		$("#wkStartDt").datepicker({
				dateFormat: 'yy-mm-dd' 
				,changeMonth: true
				,changeYear: true
				,dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일']
				,dayNamesMin: ['월','화','수','목','금','토','일']
				,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		}); // end daypicker
	
	}); // end $(function(){});
</script>
</head>
<body>
	<h2>근로 정보 수정</h2>
	<form method="post" action="/wk/update">
		<p>
			사업장 번호 : <input type="text" name="siteNum" value="${wk.siteNum}" readonly/>
		</p>
		<p>
			사업장 명 : <input type="text" value="${siteDetail.siteNm}" readonly/>
		</p>
		<p>
			사원 번호 : <input type="text" name="empNum" value="${wk.empNum}" readonly/>
		</p>
		<p>
			사원 명 : <input type="text" value="${empDetail.empNm}" readonly/>
		</p>
		<p>
			근무 시작 일 : <input type="text" id="wkStartDt" name="wkStartDt" value="${wk.wkStartDt}"/>
		</p>
		<input type="hidden" name="wkNum" value="${wk.wkNum}" />
		<input type="submit" value="수정" />
	</form>
</body>
</html>