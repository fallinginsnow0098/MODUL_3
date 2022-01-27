
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View City-Detail</title>
</head>
<body>
<h1>City</h1>
<p>ID: ${city.getId()}</p>
<p>Name: ${city.getName()}</p>
<p>Popular: ${city.getPopular()}</p>
<p>Area: ${city.getArea()}</p>
<p>GDP: ${city.getGdp()}</p>
<p>Country: ${city.getCountry()}</p>


</body>
</html>
