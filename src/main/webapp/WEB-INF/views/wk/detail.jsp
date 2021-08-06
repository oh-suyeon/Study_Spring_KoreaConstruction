<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>근무 상세 정보</title>
</head>
<body>
	<h2>근무 상세 정보</h2>
	<p>
		근무 번호 : ${wk.wkNum}
	</p>
	<p>
		사업장 번호 : ${wk.siteNum}
	</p>
	<p>
		사업장 명 : ${siteDetail.siteNm}
	</p>
	<p>
		사원 번호 : ${wk.empNum}
	</p>
	<p>
		사원 명 : ${empDetail.empNm}
	</p>
	<p>
		근무 시작 일 : ${wk.wkStartDt}
	</p>
	<form method="post" action="/wk/delete">
		<input type="hidden" name="wkNum" value="${wk.wkNum}">
		<input type="submit" value="삭제" />
		
		<button type="button" onclick="location.href='/wk/update/${wk.wkNum}'">수정</button>
		<button type="button" onclick="location.href='/wk/list'">목록으로</button>
	</form>
</body>
</html>