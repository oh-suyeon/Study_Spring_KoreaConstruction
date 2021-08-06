<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="">
	<input type="text" id="empKeyword" name="keyword" value="${keyword}" />
	<button type="button" onclick="empSearch();">검색</button>
</form>

<button type="button" onclick="empCreate();">사원 등록</button>

<table>
	<colgroup>
		<col style="width: 120px;">
		<col style="width: auto;">
		<col style="width: 80px;">
	</colgroup>
	<thead>
		<tr>
			<th>사원 번호</th>
			<th>사원 명</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody id="empListTb">
		<c:forEach var="emp" items="${empList}">
			<tr class="trEmp">
				<td>${emp.empNum}</td>
				<td onclick="empInput(${emp.empNum});" style="cursor: pointer;">
					${emp.empNm}
				</td>
				<td>
					<img class="icon" src="/resources/images/delete.png" alt="deleteIcon"
						 onclick="empDelete(${emp.empNum});"/>
				</td>
			</tr>
		</c:forEach>
		<!-- Pagination -->
		<tr>
			<td colspan="3">
				${pagingEmpStr}
			</td>
		</tr>
	</tbody>
</table>


