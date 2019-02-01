<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DaliaCaspriac
  Date: 1/31/2019
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online shop</title>
    <link href="<c:url value="/resources/css/productsTableStyle.css" />" rel="stylesheet">
</head>
<body>
<table>
    <tr>
        <th>Product</th>
        <th>Description</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.description}"/></td>
            <td><c:out value="${product.price} £"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
