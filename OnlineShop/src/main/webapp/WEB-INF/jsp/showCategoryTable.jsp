<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DaliaCaspriac
  Date: 2/5/2019
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online shop</title>
    <link href="<c:url value="/resources/css/categoryTableStyle.css" />" rel="stylesheet">
</head>
<body>
<table>
    <th colspan="2">
        <h3>Categories</h3>
    </th>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td><a href="/categories"><c:out value="${category.name}"/></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
