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
		<form action="/placeprocess.slp" method="POST" class="ui form">
			<h3>장소</h3>
			${place.location}
			<input type="hidden" name="location" value="${place.location}">
			<hr>
			<h3>주소</h3>
			${place.address}
			<input type="hidden" name="address" value="${place.address}">
			<hr>
			<h3>시간</h3>
			${rdate} ${hour}시 ${minute}분
			<input type="hidden" name="rdate" value="${rdate}">
			<input type="hidden" name="hour" value="${hour}">
			<input type="hidden" name="minute" value="${minute}">
			<hr>
			<h3>참여자</h3>
			<table class="ui large table">
				<tbody>
					<c:forEach items="${requestScope.user}" var="u">
						<tr>
							<td>${u.userName}</td>
							<td>${u.userGender}</td>
							<td>${u.userAddr}</td>
							<td>${u.userAge}</td>
							<input type="hidden" name="userInfo"
								value='${u.userName}/${u.userGender}/${u.userAddr}/${u.userAge}'>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div class="ui column centered grid" style="margin-bottom: 50px; padding-bottom: 80px;">
				<button type="submit" class="ui primary button">완료</button>
				<button type="button" class="ui orange button" onclick="back();">뒤로가기</button>
			</div>
		</form>
	</div>
	<jsp:include page="/Layouts/footer.jsp"></jsp:include>
</body>

<script>
	function back() {
		window.history.go(-1);
	}
</script>

</html>