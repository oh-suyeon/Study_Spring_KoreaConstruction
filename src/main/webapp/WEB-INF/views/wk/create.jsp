<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>근로 정보 등록</title>
<link href="/resources/style/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/resources/js/jquery-ui-1.12.1.custom/jquery-ui.css">
<script src="/resources/js/jquery-3.6.0.js"></script>
<script src="/resources/js/jquery-ui-1.12.1.custom/jquery-ui.js"></script>

<script type="text/javascript">
	
	$(function() {

		// empInput 선생님 따라하기 (파라미터를 이렇게 가져올 수 있다.)
		$(".trEmp").on("click", function(e) {
			var varEmpNum = $(this).find("td:eq(0)").text();
			var data = {"empNum" : varEmpNum}
		});
		
		$("#wkStartDt").datepicker({
				dateFormat: 'yy-mm-dd' 
				,changeMonth: true
				,changeYear: true
				,dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일']
				,dayNamesMin: ['월','화','수','목','금','토','일']
				,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		}); // end daypicker
		
	}); // end $(function(){});
	
	
	function empInput(empNum) {
		$.ajax({
			type: "GET" // post로 던졌다면 @RequestBody로 받아야 함.
			,data: {"empNum" : empNum}
			,url: "/wk/getEmpDetail"
			,dataType: "json"
			,success: function (data) {
				console.log(data);
				$("#empNum").val(data.empNum);
				$("#empNm").val(data.empNm);
				$("#addr").val("[" + data.zipCode + "] " + data.addr1 + " " + data.addr2);
				$("#phnNum").val(data.phnNum);
				$("#pos").val(data.pos);
				$("#deptNm").val(data.deptNm);
				$("#f_empNum").val(data.empNum);
				$("#m_empNm").val(data.empNm);
			}
			,error: function (xhr) {
				console.log(xhr);
			}
		});
	} // end empInput()

	function siteNumInput(siteNum) {
		$("#f_siteNum").val(siteNum);
		console.log($("#f_siteNum").val());
	} // end siteNumInput()
 
	function siteNmInput(siteNm) {
		$("#m_siteNm").val(siteNm);
	} // end siteNmInput()
	
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
							+ " 	<td onclick='empInput("+item.empNum+");' style='cursor: pointer;' class='hov'>"
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
	} // end empSearch()

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
							+ " 	<td onclick='siteInput("+item.siteNum+");' style='cursor: pointer;' class='hov'>"
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
	} // end siteSearch()
	
	function empCreate() {
		window.open("/emp/create?atPopup=true","owin","width=700,height=700");
	} // end empCreate()
	
	function siteCreate() {
		window.open("/site/create?atPopup=true","owin","width=700,height=900");
	} // end siteCreate()
	
	function formSubmit() {
		var frm = $("#frm");
		
		if($("#f_empNum").val()==""){
			alert("사원을 입력하세요.");
			return;
		}
		if($("#f_siteNum").val()==""){
			alert("사업장을 입력하세요.");
			return;
		}
		if($("#wkStartDt").val()==""){
			alert("근무 시작일을 입력하세요.");
			return;
		}
		frm.submit();
	} // end formSubmit()
	
	function empDelete(empNum) {
		if(!confirm("삭제하시겠습니까?")){
			return;
		}
		var param = {"empNum" : empNum};
		$.ajax({
			type: "post"
			,url: "/wk/deleteEmp"
			,data: JSON.stringify(param)
			,contentType: "application/json"
			,cache: false
			,success: function(data) {
				console.log("data : " + data);
				if(data == 0){
					alert("이미 근무 정보에 등록한 사원은 삭제할 수 없습니다.");
				}else if(data == -1){
					alert("시스템 상에 문제가 생겨 삭제하지 못했습니다.");
				}else{
					alert("삭제가 완료되었습니다.");
				}
				location.reload();
			}
			,error: function(xhr) {
				console.log(xhr);
			}
		});
	} // end empDelete()

	function siteDelete(siteNum) {
		if(!confirm("삭제하시겠습니까?")){
			return;
		}
		var param = {"siteNum" : siteNum};
		$.ajax({
			type: "post"
			,url: "/wk/deleteSite"
			,data: JSON.stringify(param)
			,contentType: "application/json"
			,cache: false
			,success: function(data) {
				console.log("data : " + data);
				if(data == 0){
					alert("이미 근무 정보에 등록한 사업장은 삭제할 수 없습니다.");
				}else if(data == -1){
					alert("시스템 상에 문제가 생겨 삭제하지 못했습니다.");
				}else{
					alert("삭제가 완료되었습니다.");
				}
				location.reload();
			}
			,error: function(xhr) {
				console.log(xhr);
			}
		});
	} // end siteDelete()
	
	function sitePaging(currentPage) {
		var param = {'currentPageSite': currentPage}
		console.log("sitePaging : " + currentPage);	
	} // end sitePaging()
	
</script>
</head>
<body>
	<h2>근로 정보 등록</h2>
	<div id="box">
	
		<div id="top">
			<h3>사원 정보 상세</h3>
			<table>
				<tbody>
					<tr>
						<th>사원 번호</th>
						<td>
							<input type="text" id="empNum" readonly/>
						</td>
						<th>사원 명</th>
						<td>
							<input type="text" id="empNm" readonly/>
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<input type="text" id="addr" readonly/>
						</td>
						<th>전화번호</th>
						<td>
							<input type="text" id="phnNum" readonly/>
						</td>
					</tr>
					<tr>
						<th>직급</th>
						<td>
							<input type="text" id="pos" readonly/>
						</td>
						<th>부서명</th>
						<td>
							<input type="text" id="deptNm" readonly/>
						</td>
					</tr>
				</tbody>
			</table>
			
		</div>
		
		<hr />
		
		<div id="left" class="container">
			<h3>사원 정보</h3>
			<jsp:include page="/WEB-INF/views/wk/empList.jsp" />
		</div>
		
		<div id="right" class="container">
			<h3>사업장 정보</h3>
			<jsp:include page="/WEB-INF/views/wk/siteList.jsp" />
		</div>
		
		<hr style="clear: both;" />
		
		<div id="bottom">
			<h3>근무 정보 매핑</h3>
			
			<form action="/wk/create" method="post" id="frm">
				사원 : 		<input type="text"  id="m_empNm" 	style="width:100px;" readonly />&nbsp;&nbsp;|&nbsp; 
				사업장 : 		<input type="text" 	id="m_siteNm" 	style="width:100px;" readonly />&nbsp;&nbsp;|&nbsp; 
				근무 시작일 : 	<input type="text"	id="wkStartDt" 	style="width:100px;" name="wkStartDt"/>
				
				<input type="hidden" id="f_empNum" 	name="empNum" />
				<input type="hidden" id="f_siteNum" name="siteNum" />
				
				<button type="button" onclick="formSubmit();">등록</button>
			</form>
		</div>
		
	</div>
	
</body>
</html>