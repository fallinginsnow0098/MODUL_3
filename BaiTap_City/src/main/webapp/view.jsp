<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/27/2022
  Time: 1:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>This is view</title>
</head>
<body>
<h1>List city</h1>
<button>
    <a href="/cities?action=createGet">Create new city</a>
</button>

<c:if test="${requestScope['cities'].isEmpty()}">
    <h2 style="color: red">List is empty now!</h2>
</c:if>
<c:if test="${requestScope['cities'].isEmpty() == false}">
    <table>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Popular</td>
            <td>Area</td>
            <td>GDP</td>
            <td>Country</td>
            <td colspan="2">Action</td>
        </tr>
        <c:forEach items="${cities}" var="city">
            <tr>
                <td>${city.getId()}</td>
                <td><a href="/cities?action=display-detail&id=${city.getId()}" id="name">${city.getName()}</a></td>
                <td <c:if test="${city.getPopular() > 1000000}"> style="color: red" </c:if>>${city.getPopular()}</td>
                <td>${city.getArea()}</td>
                <td <c:if test="${city.getGdp() < 10000}"> style="color: red" </c:if>>${city.getGdp()}</td>
                <td>${city.getCountry()}</td>
                <td><button><a href="/cities?action=editGet%id=${city.getId()}">Edit</a></button></td>
                <td><button><a href="/cities?action=delete&id=${city.getId()}">Delete</a></button></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
