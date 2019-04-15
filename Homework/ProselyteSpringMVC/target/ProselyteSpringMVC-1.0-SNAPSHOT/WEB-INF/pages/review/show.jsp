<%@ taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kotle
  Date: 11.04.2019
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${review.title}" /></title>
</head>
<body>
    <h3><c:out value="${review.title}" /></h3>
    <h4><c:out value="${review.text}" /></h4>
</body>
</html>
