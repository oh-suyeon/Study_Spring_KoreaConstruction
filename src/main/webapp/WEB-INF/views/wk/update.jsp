<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>근로 정보 수정</title>
</head>
<body>
	<h2>근로 정보 수정</h2>
	<form method="post" action="/wk/update">
		<p>
			근무 번호 : <input type="text" name="wkNum" value="${wk.wkNum}" readonly="readonly"/>
		</p>
		<p>
			사원 번호 : <input type="text" name="empNum" value="${wk.empNum}" readonly="readonly"/>
		</p>
		<p>
			사업장 번호 : <input type="text" name="siteNum" value="${wk.siteNum}" readonly="readonly"/>
		</p>
		<p>
			시작 일 : <input type="date" name="inDt" value="${wk.inDt}"/>
		</p>
		<p>
			종료 일 : <input type="date" name="outDt" value="${wk.outDt}"/>
		</p>
		<input type="hidden" name="wkNum" value="${wk.wkNum}">
		<input type="submit" value="수정" />
	</form>
</body>
</html>