<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="">
	<input type="text" id="empKeyword" name="keyword" value="${keyword}" />
	<button type="button" onclick="empSearch();">검색</button>
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
			<th>사원 번호</th>
			<th>사원 명</th>
		</tr>
	</thead>
	<tbody id="empListTb">
		<c:forEach var="emp" items="${empList}">
			<tr>
				<td>${emp.empNum}</td>
				<td onclick="empInput(${emp.empNum});" style="cursor: pointer;">
					${emp.empNm}
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>