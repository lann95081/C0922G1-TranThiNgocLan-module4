<%--
  Created by IntelliJ IDEA.
  User: tranthingoclan
  Date: 01/02/2023
  Time: 21:02
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
<p>${mess}</p>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Position</th>
        <th>Detail</th>
        <th>Delete</th>
    </tr>
    <tbody>
    <c:forEach var="player" items="${playerList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${player.name}</td>
            <td>${player.position}</td>
            <td><a href="detail/?id=${player.id}">Detail</a></td>
            <td><a href="delete/?id=${player.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
