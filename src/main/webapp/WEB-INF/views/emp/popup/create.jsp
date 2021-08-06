<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사원 등록</title>
</head>
<body>
	<h2>사원 등록</h2>
	<form method="post" action="/emp/create">
		<p>
			사원 명 : <input type="text" name="empNm" />
		</p>
		<p>
			우편 번호 : <input type="text" name="zipCode" />
		</p>
		<p>
			주소 : <input type="text" name="addr1" />
		</p>
		<p>
			상세 주소 : <input type="text" name="addr2" />
		</p>
		<p>
			전화 번호 : <input type="text" name="phnNum" />
		</p>
		<p>
			직급 : 
			<select name="pos" >
				<c:forEach var="pos" items="${posList}">
					<!-- 사원이 먼저 보여지도록 하기 -->
					<c:if test="${pos=='사원'}">
						<c:set var="sel" value="selected" />
					</c:if>
					<c:if test="${pos!='사원'}">
						<c:set var="sel" value="" />
					</c:if>
					<option value="${pos}" ${sel}>${pos}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			부서 명 : 
			<select name="deptNm" >
				<c:forEach var="deptNm" items="${deptNmList}">
					<option value="${deptNm}">${deptNm}</option>
				</c:forEach>
			</select>
		</p>
		<input type="hidden" name="atPopup" value="${atPopup}">
		<input type="submit" value="등록" />
		<input type="button" value="닫기" onclick="javascript:self.close();"/>
	</form>
</body>
</html>