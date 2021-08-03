<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/js/jquery-3.6.0.js"></script>
<title>사업장 검색</title>
<style type="text/css">
	table, tr, th, td {
		border: 1px silver solid;
	}
	table, th, td {
		border-collapse: collapse;
	}
	table {
		width: 100%;
		text-align: center;
	}
	form, button {
		margin-bottom: 10px;
	}
</style>
<script type="text/javascript">
	function fn_parentIn(p_siteNum) {
		//부모창은 'opener'
		opener.document.getElementById("siteNum").value = p_siteNum;
		self.close();
	}
</script>
</head>
<body>
	<h2>사업장 검색</h2>
	<table>
		<tr>
			<th>사업장 번호</th>
			<th>사업장 명</th>
			<th>주소</th>
		</tr>
	<c:forEach var="site" items="${list}">
		<tr>
			<td><a href="javascript:fn_parentIn(${site.siteNum})">${site.siteNum}</a></td>
			<td>${site.siteNm}</td>
			<td>${site.addr}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>