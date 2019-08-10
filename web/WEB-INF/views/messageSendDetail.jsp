<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/messageDetail.css">
    <title>메세지 보기</title>
</head>
<body>
    <div class ="title">
        <table>
            <tr>
                <td class="title_left">보낸 사람</td>
                <td class="title_right">${userNick}</td>
            </tr>
            <tr>
                <td class="title_left">받은 사람</td>
                <td class="title_right">
                    <c:choose>
                        <c:when test="${empty receiveNick || receiveNick=''}">
                            <input type="text" placeholder="받는 사람 닉네임">
                        </c:when>
                        <c:otherwise>
                            ${receiveNick}
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>
    <div class="content">
        <textarea class="content_text"></textarea>
    </div>
    <div class="bottom">
        <button>답장</button>
        <button>확인</button>
        <button>삭제</button>
    </div>
</body>
</html>
