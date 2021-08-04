<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="">
	<input type="text" id="siteKeyword" name="keyword" value="${keyword}" />
	<button type="button" onclick="siteSearch(${keyword});">검색</button>
</form>

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
		</tr>
	</thead>
	<tbody id="siteListTb">
		<c:forEach var="site" items="${siteList}">
			<tr>
				<td>${site.siteNum}</td>
				<td onclick="siteInput(${site.siteNum});" style="cursor: pointer;">
					${site.siteNm}
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>