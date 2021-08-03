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
			직급 : <input type="text" name="pos" />
		</p>
		<p>
			부서 명 : <input type="text" name="deptNm" />
		</p>
		<input type="submit" value="등록" />
	</form>
</body>
</html>