<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사업장 목록</title>
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
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/nav.jsp" />
	
	<h2>사업장 목록</h2>
	
	<form action="">
		<input type="text" name="keyword" value="${keyword}" />
		<input type="submit" value="검색" />
	</form>
	
	<button type="button" onclick="location.href='/site/list'">전체 목록</button>
	<button type="button" onclick="location.href='/site/create'">등록</button>
	
	<table>
		<colgroup>
			<col style="width: 120px;">
			<col style="width: auto;">
			<col style="width: auto;">
			<col style="width: auto;">
		</colgroup>
		<thead>
			<tr>
				<th>사업장 번호</th>
				<th>사업장 명</th>
				<th>주소</th>
				<th>전화 번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="site" items="${siteList}">
				<tr>
					<td>${site.siteNum}</td>
					<td>
						<a href="/site/detail/${site.siteNum}">
							${site.siteNm}
						</a>
					</td>
					<td>${site.addr}</td>
					<td>${site.phnNum}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>