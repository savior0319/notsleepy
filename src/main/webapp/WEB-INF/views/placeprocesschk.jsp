<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
    window.onload = () => {
        alert("[테스트용]저장완료\n" + "값 : " + '${insertDate}');
        window.location.href = "/";
    }
</script>