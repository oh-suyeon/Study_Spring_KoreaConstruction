<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사업 자재 목록</title>
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
	
	<h2>사업 자재 목록</h2>
	
	<form action="">
		<input type="text" name="keyword" value="${keyword}" placeholder="기존  통합 검색 방식"/>
		<input type="submit" value="검색" />
	</form>
	
	<form action="/siteMat/list" method="post">
		<select name="caseWhere">
			<option value="all" 	<c:if test="${caseWhere == 'all'}"	 >selected</c:if> >전체	</option>
			<option value="siteNm" 	<c:if test="${caseWhere == 'siteNm'}">selected</c:if> >사업장 명</option>
			<option value="itemNm" 	<c:if test="${caseWhere == 'itemNm'}">selected</c:if> >자재 명	</option>
		</select>
		<input type="text" name="keyword" value="${keyword}"/>
		<input type="submit" value="검색" />
	</form>
	
	<button type="button" onclick="location.href='/siteMat/list'">전체 목록</button>
	<button type="button" onclick="location.href='/siteMat/create'">등록</button>
	
	<table>
		<colgroup>
			<col style="width: 120px;">
			<col style="width: auto;">
			<col style="width: 200px;">
			<col style="width: 120px;">
		</colgroup>
		<thead>
			<tr>
				<th>사업 자재 코드</th>
				<th>자재 명</th>
				<th>사업장</th>
				<th>구입 일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="siteMat" items="${siteMatList}">
				<tr>
					<td>${siteMat.matNmCd}</td>
					<td>
						<a href="/siteMat/detail/${siteMat.siteNum}/${siteMat.matNmCd}">
							${siteMat.itemNm}
						</a>
					</td>
					<td>${siteMat.siteNm}</td>
					<td>${siteMat.purDt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="/siteMat/list?nowPage=${paging.startPage-1}&cntPerPage=${paging.cntPerPage}&keyword=${keyword}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="/siteMat/list?nowPage=${p }&cntPerPage=${paging.cntPerPage}&keyword=${keyword}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="/siteMat/list?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&keyword=${keyword}">&gt;</a>
		</c:if>
	</div>
</body>
</html>