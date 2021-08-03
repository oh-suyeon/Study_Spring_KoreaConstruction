<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사업 자재 정보 수정</title>
</head>
<body>
	<h2>사업 자재 정보 수정</h2>
	<form method="post" action="/siteMat/update">
		<p>
			자재 코드 : <input type="text" name="matNmCd" value="${siteMat.matNmCd}" readonly="readonly"/>
		</p>
		<p>
			사업장 번호 : <input type="text" name="siteNum" value="${siteMat.siteNum}" readonly="readonly"/>
		</p>
		<p>
			자재 명 : <input type="text" name="matNm" value="${siteMat.matNm}" />
		</p>
		<p>
			구입 일 : <input type="date" name="purDt" value="${siteMat.purDt}"/>
		</p>
		<p>
			수량 : <input type="number" name="cnt" value="${siteMat.cnt}" />
		</p>
		<p>
			구입 금액 : <input type="number" name="purPri" value="${siteMat.purPri}" />
		</p>
		<input type="hidden" name="matNmCd" value="${siteMat.matNmCd}">
		<input type="submit" value="수정" />
	</form>
</body>
</html>