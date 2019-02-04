<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DaliaCaspriac
  Date: 2/4/2019
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online shop</title>
    <link href="<c:url value="/resources/css/productDetailsStyle.css" />" rel="stylesheet">

</head>
<body>
<div>
    <h1>${product.name}</h1>
    <h3>General rating: ${product.rating}</h3>
</div>

<table>
    <th colspan="2">Details</th>
    <tr>
        <td>Description</td>
        <td>${product.description}</td>
    </tr>
    <tr>
        <td>Price</td>
        <td>${product.price}£</td>
    </tr>
    <tr>
        <td>Resolution</td>
        <td>${product.dimension}</td>
    </tr>
    <tr>
        <td>Color</td>
        <td>${product.color}</td>
    </tr>
    <tr>
        <td>Quantity</td>
        <td>${product.quantity}</td>
    </tr>

</table>

<table name="t">
    <th colspan="2">Reviews</th>
    <c:forEach items="${product.productReviews}" var="productReview">
        <tr>
            <td>${productReview.comment}</td>
        </tr>
        <tr>
            <td>${productReview.starts}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
