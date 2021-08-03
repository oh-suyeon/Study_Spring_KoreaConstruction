<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사원 상세 정보</title>
</head>
<body>
	<h2>사원 상세 정보</h2>
	<p>
		사원 번호 : ${empDetail.empNum}
	</p>
	<p>
		사원 명 : ${empDetail.empNm}
	</p>
	<p>
		우편 번호 : ${empDetail.zipCode}
	</p>
	<p>
		주소 : ${empDetail.addr1}
	</p>
	<p>
		상세 주소 : ${empDetail.addr2}
	</p>
	<p>
		전화 번호 : ${empDetail.phnNum}
	</p>
	<p>
		직급 : ${empDetail.pos}
	</p>
	<p>
		부서 명 : ${empDetail.deptNm}
	</p>
	<form method="post" action="/emp/delete">
		<input type="hidden" name="empNum" value="${empDetail.empNum}">
		<input type="submit" value="삭제" />
		
		<button type="button" onclick="location.href='/emp/update/${empDetail.empNum}'">수정</button>
		<button type="button" onclick="location.href='/emp/list'">목록으로</button>
	</form>
</body>
</html>