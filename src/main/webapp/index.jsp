<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>메인페이지</title>
	<jsp:include page="/Layouts/resource.jsp"></jsp:include>
</head>

<style>
	#mainImage {
		margin-top: 80px;
		opacity: 0.7;
		width: 100%;
	}
</style>

<body>
	<jsp:include page="/Layouts/nav.jsp"></jsp:include>
	<div class="ui main text container">
		<img id="mainImage" src="/Image/mainImage1.jpg">
	</div>
	<jsp:include page="/Layouts/footer.jsp"></jsp:include>
</body>

<script type="text/javascript">

</script>

</html>