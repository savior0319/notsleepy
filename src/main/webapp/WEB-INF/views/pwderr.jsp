<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>추가</title>
<jsp:include page="/Layouts/resource.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="Layouts/mapstyle.css">
</head>

<body>
	<jsp:include page="/Layouts/nav.jsp"></jsp:include>
	<div class="ui main text container" style="margin-top: 80px;">
		<div class="ui centered align header">
			<div class="ui message box">비밀번호가 일치하지 않음</div>
		</div>
		<br>
		<div class="ui column centered grid">
			<button class="ui primary button" onclick="back();">뒤로가기</button>
		</div>
	</div>
	<jsp:include page="/Layouts/footer.jsp"></jsp:include>
</body>

<script>
	function back() {
		window.history.go(-1);
	}
</script>

</html>