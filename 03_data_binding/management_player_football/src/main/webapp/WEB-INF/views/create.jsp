<%--
  Created by IntelliJ IDEA.
  User: tranthingoclan
  Date: 02/02/2023
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="player" action="/create" method="post">
   <h1>Thêm mới cầu thủ bóng đá</h1>  <br>
    Id
    <form:input path="id"></form:input> <br>

    Name
    <form:input path="name"></form:input> <br>

    Birthday
    <form:input path="dayOfBirth"></form:input> <br>

    Position
    <form:select path="position">
        <form:option value="Tiền đạo">Tiền đạo</form:option>
        <form:option value="Hậu vệ">Hậu vệ</form:option>
    </form:select><br>

    Experience
    <form:input path="experience"></form:input> <br>

    <form:button>Save</form:button>
</form:form>
</body>
</html>
