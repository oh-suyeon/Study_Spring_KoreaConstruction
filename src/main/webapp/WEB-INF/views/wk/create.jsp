<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>근로 정보 등록</title>
<script src="/resources/js/jquery-3.6.0.js"></script>
<link href="/resources/style/default.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	
	function empInput(empNum) {
		$.ajax({
			type: "GET"
			,data: {"empNum" : empNum}
			,url: "/wk/getEmpDetail"
			,dataType: "json"
			,success: function (data) {
				$("#empNm").val(data.empNm);
				$("#addr").val(data.zipCode + " " + data.addr1 + " " + data.addr2);
				$("#phnNum").val(data.phnNum);
				$("#pos").val(data.pos);
				$("#deptNm").val(data.deptNm);
				$("#f_empNum").val(data.empNum)
				console.log($("#f_empNum").val());
			}
			,error: function (xhr) {
				console.log(xhr);
			}
		});
	}

	function siteInput(siteNum) {
		$("#f_siteNum").val(siteNum)
		console.log($("#f_siteNum").val());
	}
	
	function empSearch() {
		var keyword = $("#empKeyword").val()
		$.ajax({
			type: "GET"
			,data: {"keyword" : keyword}
			,url: "/wk/getEmpList"
			,dataType: "json"
			,success: function (data) {
				var htmlStr = "";
				$.each(data, function(idx, item) {
					htmlStr += "<tr>"
							+ " 	<td>"+ item.empNum +"</td>"
							+ " 	<td onclick='empInput("+item.empNum+");' style='cursor: pointer;'>"
							+ 			item.empNm 
							+ "		</td>"
							+ " </tr>";
				});
				$("#empListTb").html(htmlStr);
			}
			,error: function (xhr) {
				console.log(xhr);
			}
		});
	}

	function siteSearch() {
		var keyword = $("#siteKeyword").val()
		$.ajax({
			type: "GET"
			,data: {"keyword" : keyword}
			,url: "/wk/getSiteList"
			,dataType: "json"
			,success: function (data) {
				var htmlStr = "";
				$.each(data, function(idx, item) {
					htmlStr += "<tr>"
							+ " 	<td>"+ item.siteNum +"</td>"
							+ " 	<td onclick='siteInput("+item.siteNum+");' style='cursor: pointer;'>"
							+ 			item.siteNm 
							+ "		</td>"
							+ " </tr>";
				});
				$("#siteListTb").html(htmlStr);
			}
			,error: function (xhr) {
				console.log(xhr);
			}
		});
	}

</script>
</head>
<body>
	<h2>근로 정보 등록</h2>
	
	<div id="box">
	
		<div id="top">
			<h3>사원 정보 상세</h3>
			<p>
				사원 명 : <input type="text" id="empNm" value="${empDetail.empNm}" readonly/>
			</p>
			<p>
				주소 : <input type="text" id="addr" value="${empDetail.zipCode} ${empDetail.addr1} ${empDetail.addr2}" readonly/>
			</p>
			<p>
				전화 번호 : <input type="text" id="phnNum" value="${empDetail.phnNum}" readonly/>
			</p>
			<p>
				직급 : <input type="text" id="pos" value="${empDetail.pos}" readonly/>
			</p>
			<p>
				부서 명 : <input type="text" id="deptNm" value="${empDetail.deptNm}" readonly/>
			</p>
		</div>
		
		<div id="left">
			<h3>사원 정보</h3>
			<jsp:include page="/WEB-INF/views/wk/empList.jsp" />
		</div>
		
		<div id="right">
			<h3>사업장 정보</h3>
			<jsp:include page="/WEB-INF/views/wk/siteList.jsp" />
		</div>
		
		<div id="foot">
			<form action="/wk/create" method="post">
				<input type="text" id="f_empNum" name="empNum" />
				<input type="text" id="f_siteNum" name="siteNum" />
				<button type="submit">등록</button>
			</form>
		</div>
		
	</div>
	
</body>
</html>