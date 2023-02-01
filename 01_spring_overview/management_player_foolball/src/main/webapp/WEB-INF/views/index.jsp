<%--
  Created by IntelliJ IDEA.
  User: tranthingoclan
  Date: 01/02/2023
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Management Player</title>
</head>
<body>
<h1>Management Player</h1>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Day of birth</th>
        <th>Experience</th>
        <th>Position</th>
        <th>Photo</th>
    </tr>
    <tbody>
    <c:forEach var="player" items="${playerList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${player.name}</td>
            <td>${player.dayOfBirth}</td>
            <td>${player.experience}</td>
            <td>${player.position}</td>
            <td><img src="${player.photos}"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
