<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/27/2022
  Time: 1:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>This is create</title>
</head>
<body>
<c:url value="/cities" var="myUrl">
    <c:if test="${city != null}">
        <c:param name="action" value="editPost"/>
    </c:if>
    <c:if test="${city == null}">
        <c:param name="action" value="creatPost"/>
    </c:if>
</c:url>
<form action="${myUrl}" method="post">
    <label>ID :
        <input <c:if test="${city != null}">value="${city.getId()}"</c:if> type="text" name="id">
    </label>
    <label>Name :
        <input <c:if test="${city != null}">value="${city.getName()}"</c:if> type="text" name="name">
    </label>
    <label>Popular :
        <input <c:if test="${city != null}">value="${city.getPopular()}"</c:if> type="text" name="popular">
    </label>
    <label>Area :
        <input <c:if test="${city != null}">value="${city.getArea()}"</c:if> type="text" name="area">
    </label>
    <label>GDP :
        <input <c:if test="${city != null}">value="${city.getGDP()}"</c:if> type="text" name="GDP">
    </label>
    <label>Country :
        <select name="country">
            <c:forEach items="${countries}" var="coun">
                <option value="${coun}">${coun}</option>
            </c:forEach>
        </select>
    </label>
    <input type="submit"
        <c:if test="${city != null}"> value="Edit"</c:if>
           <c:if test="${city == null}">value="Create"</c:if> >
</form>
</body>
</html>
