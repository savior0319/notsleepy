<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>장소확인</title>
<jsp:include page="/Layouts/resource.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="Layouts/mapstyle.css">
</head>

<body>
	<jsp:include page="/Layouts/nav.jsp"></jsp:include>
	<div class="ui main text container" style="margin-top: 80px;">
		<div class="ui centered align header">
			<div class="ui message box">장소확인</div>
		</div>
		<hr>
		장소
		<h3>${place.location}</h3>
		<hr>
		주소
		<h3>${place.address}</h3>
		<hr>
		<br>
		<div class="ui column centered grid">
			<button class="ui primary button" onclick="confirm();">확인</button>
		</div>
	</div>
	<jsp:include page="/Layouts/footer.jsp"></jsp:include>
</body>

<script>
	function confirm() {
		alert('준비중');
	}
</script>

</html>