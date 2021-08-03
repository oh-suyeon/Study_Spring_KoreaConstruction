<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사원 정보 수정</title>
</head>
<body>
	<h2>사원 정보 수정</h2>
	<form method="post" action="/emp/update">
		<p>
			사원 명 : <input type="text" name="empNm" value="${empDetail.empNm}"/>
		</p>
		<p>
			우편 번호 : <input type="text" name="zipCode" value="${empDetail.zipCode}"/>
		</p>
		<p>
			주소 : <input type="text" name="addr1" value="${empDetail.addr1}"/>
		</p>
		<p>
			상세 주소 : <input type="text" name="addr2" value="${empDetail.addr2}"/>
		</p>
		<p>
			전화 번호 : <input type="text" name="phnNum" value="${empDetail.phnNum}"/>
		</p>
		<p>
			직급 : <input type="text" name="pos" value="${empDetail.pos}"/>
		</p>
		<p>
			부서 명 : <input type="text" name="deptNm" value="${empDetail.deptNm}"/>
		</p>
		<input type="hidden" name="empNum" value="${empDetail.empNum}">
		<input type="submit" value="수정" />
	</form>
</body>
</html>