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

<style>
	form {
		width: 180px;
		margin: 0 auto;
	}
</style>

<body>
	<jsp:include page="/Layouts/nav.jsp"></jsp:include>
	<div class="ui main text container" style="margin-top: 80px;">
		<div class="ui centered align header">
			<div class="ui message box">추가</div>
		</div>

		<form class="ui form" action="/addprocess.slp" method="get">
			<legend>
				<label>이름</label>
				<input type="text" placeholder="이름" id="userName" name="userName" required>
				<label>나이</label>
				<select name="userAge" id="userAge">
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25" selected>25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
					<option value="32">32</option>
					<option value="33">33</option>
					<option value="34">34</option>
					<option value="35">35</option>
					<option value="36">36</option>
					<option value="37">37</option>
					<option value="38">38</option>
					<option value="39">39</option>
				</select>
			</legend>
			<label>지역</label>
			<select name="city" id="city" required>
				<c:forEach items="${requestScope.city}" var="c">
					<option value="${c.citySecondSection}">${c.cityFirstSection} ${c.citySecondSection}</option>
				</c:forEach>
			</select>
			<div class="ui column centered grid" style="margin-top : 20px;">
				<button class="ui orange button" onclick="return savebtn();">저장</button>
			</div>
		</form>

	</div>
	<jsp:include page="/Layouts/footer.jsp"></jsp:include>
</body>

<script>
	function savebtn() {
		if ($("#userName").val() != '') {
			alert('준비중');
			return false;
		} 
	}
</script>

</html>