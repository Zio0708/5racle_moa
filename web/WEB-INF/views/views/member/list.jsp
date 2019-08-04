<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-07-31
  Time: 오후 6:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <caption>멤버 목록</caption>
    <th>
    <td>아이디</td>
    <td>비밀번호</td>
    <td>이름</td>
    <td>가입날짜</td>
    </th>
    <c:forEach var="member" items="${members}" varStatus="mc">
        <tr>
            <td>${mc.count}</td>
            <td>${member.id}</td>
            <td>${member.name}</td>
            <td>${member.pwd}</td>
            <td>${member.reg_date}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
