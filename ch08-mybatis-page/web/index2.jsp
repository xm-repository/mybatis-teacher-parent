<%--
  User: cj
  Date: 2019/10/12
  Time: 09:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>salary</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${pageInfo.list}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.username}</td>
            <td>${emp.salary}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<a href="/index?page=1&pageSize=${pageInfo.pageSize}">首页</a>
<a href="/index?page=${pageInfo.prePage}&pageSize=${pageInfo.pageSize}">上一页</a>
<a href="/index?page=${pageInfo.nextPage}&pageSize=${pageInfo.pageSize}">下一页</a>
<a href="/index?page=${pageInfo.pages}&pageSize=${pageInfo.pageSize}">尾页</a>

<ul>
    <c:forEach items="${pageInfo.navigatepageNums}" var="num">
        <li><a href="/index?page=${num}&pageSize=${pageInfo.pageSize}">${num}</a></li>
    </c:forEach>
</ul>
</body>
</html>
