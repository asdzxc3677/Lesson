<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-22
  Time: 오후 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
    <h2>로그인</h2>
    <form action="/member/login" method="post">
        <input type="text" name="memberId" placeholder="아이디">
        <input type="text" name="memberPassword" placeholder="비밀번호">
        <input type="submit" value="로그인">
    </form>
<style>
    body{

    }
</style>
</body>
</html>
