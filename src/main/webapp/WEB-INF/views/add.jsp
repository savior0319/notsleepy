<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html><html><head> <meta charset="UTF-8"> <title>참여자추가</title> <jsp:include page="/Layouts/resource.jsp"></jsp:include> <link rel="stylesheet" type="text/css" href="Layouts/mapstyle.css"></head><style>form{width: 180px; margin: 0 auto;}</style><body> <jsp:include page="/Layouts/nav.jsp"></jsp:include> <div class="ui main text container" style="margin-top: 80px;"> <div class="ui centered align header"> <div class="ui message box">참여자추가</div></div><form class="ui form" action="/addprocess.slp" method="POST"> <legend><label>이름</label><input type="text" placeholder="이름" id="userName" name="userName" required maxlength="12"><br><br><label>나이</label><select name="userAge" id="userAge" class="ui fluid dropdown" required> <option value="20">20</option> <option value="21">21</option> <option value="22">22</option> <option value="23">23</option> <option value="24">24</option> <option value="25" selected>25</option> <option value="26">26</option> <option value="27">27</option> <option value="28">28</option> <option value="29">29</option> <option value="30">30</option> <option value="31">31</option> <option value="32">32</option> <option value="33">33</option> <option value="34">34</option> <option value="35">35</option> <option value="36">36</option> <option value="37">37</option> <option value="38">38</option> <option value="39">39</option> </select> <div><br><label>성별</label> <div class="field"> <div class="ui radio checkbox"><input type="radio" name="userGender" id="userGenderM" required value="M"><label>남</label></div></div><div class="field"> <div class="ui radio checkbox"><input type="radio" name="userGender" id="userGenderF" required value="F"><label>여</label></div></div></div><br><label>지역</label><select name="userAddr" id="userAddr" class="ui fluid dropdown" required> <c:forEach items="${requestScope.city}" var="c"> <option value="${c.cityFirstSection} ${c.citySecondSection}"> ${c.cityFirstSection} ${c.citySecondSection}</option> </c:forEach> </select><br><label>비밀번호</label><input type="password" name="password" id="password" required maxlength="10"> <div class="ui column centered grid" style="margin-top : 20px;"><button class="ui orange button" onclick="return savebtn();">추가</button></div></legend> </form> </div><jsp:include page="/Layouts/footer.jsp"></jsp:include></body><script>function savebtn(){if ($("#userName").val()==""){alert('이름을 입력하세요'); return false;}if ($("#password").val()==""){alert('비밀번호를 입력하세요'); return false;}}/* combobox */ $('.ui.dropdown').dropdown();</script></html>