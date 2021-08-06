<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="">
	<input type="text" id="siteKeyword" name="keyword" value="${keyword}"/>
	<button type="button" onclick="siteSearch(${keyword});">검색</button>
</form>

<button type="button" onclick="siteCreate();">사업장 등록</button>

<table>
	<colgroup>
		<col style="width: 120px;">
		<col style="width: auto;">
		<col style="width: auto;">
		<col style="width: 80px;">
	</colgroup>
	<thead>
		<tr>
			<th>사업장 번호</th>
			<th>사업장 명</th>
			<th>전화 번호</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody id="siteListTb">
		<c:forEach var="site" items="${siteList}">
			<tr class="trSite">
				<td>${site.siteNum}</td>
				<td onclick="siteNumInput(${site.siteNum}); siteNmInput('${site.siteNm}');" style="cursor: pointer;">
					${site.siteNm}
				</td>
				<td>${site.phnNum}</td>
				<td>
					<img class="icon" src="/resources/images/delete.png" alt="deleteIcon" 
						 onclick="siteDelete(${site.siteNum});"/>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">
				<!-- Pagination -->
				<span>
					<c:if test="${pagingSite.startPage > pagingSite.size}">
						<a href="/wk/create?currentPageSite=${pagingSite.startPage - 3}">[&lt; 이전]</a>
					</c:if>
					
					<c:forEach var="sitePage" begin="${pagingSite.startPage}" end="${pagingSite.endPage}">
						<a href="/wk/create?currentPageSite=${sitePage}">[${sitePage}]</a>
					</c:forEach>
					
					<c:if test="${pagingSite.endPage < pagingSite.totalPages}">
						<a href="/wk/create?currentPageSite=${pagingSite.startPage + 3}">[다음 &gt;]</a>
					</c:if>
				</span>
			</td>
		</tr>
	</tbody>
</table>



