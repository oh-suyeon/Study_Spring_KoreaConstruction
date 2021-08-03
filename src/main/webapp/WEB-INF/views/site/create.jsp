<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/js/jquery-3.6.0.js"></script>
<script src="/resources/ckeditor/ckeditor.js"></script>
<title>사업장 등록</title>
<script type="text/javascript">
</script>
</head>
<body>
	<h2>사업장 등록</h2>
	<form method="post" action="/site/create">
		<p>
			사업장 명 : <input type="text" name="siteNm" />
		</p>
		<p>
			주소 : <input type="text" name="addr" />
		</p>
		<p>
			전화 번호 : <input type="text" name="phnNum" />
		</p>
		<p>
			공사 금액 : <input type="number" name="contAmt" />
		</p>
		<p>
			투입 인원 : <input type="number" name="inPeo" />
		</p>
		<p>
			시공 일자 : <input type="date" name="stDt" />
		</p>
		<p>
			예상 완공일 : <input type="date" name="exComDt" />
		</p>
		<p>
			완공일 : <input type="date" name="comDt" />
		</p>
		<div style="width: 50%;">
			비고 :<textarea name="etc" id="etc" rows="10" cols="50"></textarea> 
		</div>
		<input type="submit" value="등록" />
	</form>

	<script type="text/javascript">
		CKEDITOR.replace("etc");
	</script>

</body>
</html>