<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사업장 상세 정보</title>
</head>
<body>
	<h2>사업장 상세 정보</h2>
	<p>	
		사업장 번호 : ${siteDetail.siteNum}
	</p>
	<p>	
		사업장 명 : ${siteDetail.siteNm}
	</p>
	<p>
		주소 : ${siteDetail.addr}
	</p>
	<p>
		전화 번호 : ${siteDetail.phnNum}
	</p>
	<p>
		공사 금액 : ${siteDetail.contAmt}
	</p>
	<p>
		투입 인원 : ${siteDetail.inPeo}
	</p>
	<p>
		시공 일자 : ${siteDetail.stDt}
	</p>
	<p>
		예상 완공일 : ${siteDetail.exComDt}
	</p>
	<p>
		완공일 : ${siteDetail.comDt}
	</p>
	<p>
		비고 : ${siteDetail.etc}
	</p>
	<form method="post" action="/site/delete">
		<input type="hidden" name="siteNum" value="${siteDetail.siteNum}">
		<input type="submit" value="삭제" />
		
		<button type="button" onclick="location.href='/site/update/${siteDetail.siteNum}'">수정</button>
		<button type="button" onclick="location.href='/site/list'">목록으로</button>
	</form>
</body>
</html>