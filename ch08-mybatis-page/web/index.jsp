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
        <c:forEach items="${emps}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.username}</td>
                <td>${emp.salary}</td>
            </tr>
        </c:forEach>

    </tbody>
</table>

<%--<a href="/index?page=1&pageSize=2">首页</a>
<a href="/index?page=${prev}&pageSize=2">上一页</a>
<a href="/index?page=${next}&pageSize=2">下一页</a>
<a href="/index?page=${last}&pageSize=2">尾页</a>--%>


<a href="/index?page=${pagination.first}&pageSize=2">首页</a>
<a href="/index?page=${pagination.prev}&pageSize=2">上一页</a>
<a href="/index?page=${pagination.next}&pageSize=2">下一页</a>
<a href="/index?page=${pagination.last}&pageSize=2">尾页</a>
</body>
</html>
