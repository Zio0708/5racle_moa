<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-08-02
  Time: 오후 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:message code="join.id" var="jid" />
<spring:message code="join.name" var="jname" />
<spring:message code="join.password" var="jpassword" />
<spring:message code="join.register" var="jregister" />
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form class="user" action="/member/join" method="post" modelAttribute="memberForm">
    <form:input path="id"  name ="id" placeholder='${jid}'/><form:errors path="id"/><br/>
    <form:password path="pwd" name = "pwd" placeholder="${jpassword}"/><form:errors path="pwd"/><br/>
    <form:input path="name" name="name"  placeholder="${jname}"/><br/>
    <form:button type="submit">${jregister}</form:button>
</form:form>
</body>
</html>
