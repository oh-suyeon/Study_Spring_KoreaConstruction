<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사업장 정보 수정</title>
</head>
<body>
	<h2>사업장 정보 수정</h2>
	<form method="post" action="/site/update">
		<p>
			사업장 명 : <input type="text" name="siteNm" value="${siteDetail.siteNm}"/>
		</p>
		<p>
			주소 : <input type="text" name="addr" value="${siteDetail.addr}"/>
		</p>
		<p>
			전화 번호 : <input type="text" name="phnNum" value="${siteDetail.phnNum}" />
		</p>
		<p>
			공사 금액 : <input type="number" name="contAmt" value="${siteDetail.contAmt}"/>
		</p>
		<p>
			투입 인원 : <input type="number" name="inPeo" value="${siteDetail.inPeo}"/>
		</p>
		<p>
			시공 일자 : <input type="date" name="stDt" value="${siteDetail.stDt}"/>
		</p>
		<p>
			예상 완공일 : <input type="date" name="exComDt" value="${siteDetail.exComDt}"/>
		</p>
		<p>
			완공일 : <input type="date" name="ComDt" value="${siteDetail.ComDt}"/>
		</p>
		<p>
			비고 : <input type="text" name="etc" value="${siteDetail.etc}"/>
		</p>
		<input type="hidden" name="siteNum" value="${siteDetail.siteNum}">
		<input type="submit" value="수정" />
	</form>
</body>
</html>