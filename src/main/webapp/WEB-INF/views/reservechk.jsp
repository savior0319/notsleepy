<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html><html><head><meta charset="UTF-8"><title>장소확인</title><jsp:include page="/Layouts/resource.jsp"></jsp:include></head><style type="text/css">body{background-color: #DADADA;}body>.grid{height: 100%;}.image{margin-top: -100px;}.column{max-width: 450px;}</style><body><div class="ui middle aligned center aligned grid"><div class="column"><h2 class="ui blue image header"><img src="/Image/lock.png" class="image"><div class="content">비밀번호를 입력하세요</div></h2><form action="/reserve.slp" class="ui large form" method="POST"><div class="ui stacked segment"><div class="field"><div class="ui left icon input"><i class="lock icon"></i><input type="password" name="pwd" id="pwd" placeholder="비밀번호 입력" required="required"></div></div><button class="ui fluid large inverted blue submit button" onclick="return login();">로그인</button><button style="margin-top: 15px;" type="button" class="ui fluid large inverted orange submit button" onclick="back();">뒤로가기</button></div></form><div class="ui message"><p>Copyright 2019 by notsleepy. All rights reserved.</p></div></div></div></body><script>function back(){window.history.go(-1);}function login(){if ($("#pwd").val()==""){alert('비밀번호를 입력하세요.');return false;}else{return true;}}</script></html>