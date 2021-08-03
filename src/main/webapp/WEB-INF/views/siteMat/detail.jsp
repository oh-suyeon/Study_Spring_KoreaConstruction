<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>사업 자재 상세 정보</title>
</head>
<body>
	<h2>사업 자재 상세 정보</h2>
	<p>
		사업장 번호 : ${siteMat.siteNum}
	</p>
	<p>
		자재명 : ${siteMat.matNm}
	</p>
	<p>
		수량 : ${siteMat.cnt}
	</p>
	<p>
		구입 일 : ${siteMat.purDt}
	</p>
	<p>
		구입 금액 : 
		<fmt:formatNumber type="currency">${siteMat.purPri}</fmt:formatNumber>
	</p>
	<form method="post" action="/siteMat/delete">
		<input type="hidden" name="siteNum" value="${siteMat.siteNum}">
		<input type="hidden" name="matNmCd" value="${siteMat.matNmCd}">
		<input type="submit" value="삭제" />
		
		<button type="button" onclick="location.href='/siteMat/update/${siteMat.siteNum}/${siteMat.matNmCd}'">수정</button>
		<button type="button" onclick="location.href='/siteMat/list'">목록으로</button>
	</form>
</body>
</html>