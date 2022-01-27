<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product List</title>
  </head>
  <body>
  <h1>Product List</h1>
  <div>
    <button><a style="text-decoration: none" href="/products?action=sortUp">Sort Price Up</a></button>
    <button><a style="text-decoration: none" href="/products?action=sortDown">Sort Price Down</a></button>
    <button><a href="/products?action=">View Cart</a></button>
  </div>
  <div>
    <c:if test="${requestScope['products'].isEmpty()}">
      <h2 style="color: red">Product List is EMPTY</h2>
    </c:if>
    <c:if test="${requestScope['products'].isEmpty() == false}">
      <table>
        <tr>
          <td>ID</td>
          <td>Name</td>
          <td>Price</td>
          <td>Quantity</td>
          <td>Description</td>
          <td colspan="2">Action</td>
        </tr>
        <c:forEach items="products" var="product">
          <tr>
            <td><a style="text-decoration: none" href="/products?action=view-detail&id=${product.getId()}">${product.getId()}</a></td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getQuantity()}</td>
            <td>${product.getDescription()}</td>
          </tr>
        </c:forEach>
      </table>
    </c:if>
  </div>
  <br>


  </body>
</html>
