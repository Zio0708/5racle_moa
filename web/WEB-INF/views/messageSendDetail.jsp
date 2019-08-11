<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
    <script src="/resources/js/messageSendDetail.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/messageDetail.css">
    <title>메세지 보기</title>
</head>
<body>
    <div class ="title">
        <table>
            <tr>
                <td class="title_left">보낸 사람</td>
                <td id="senderId" class="title_right">${userNick}</td>
            </tr>
            <tr>
                <td class="title_left">받는 사람</td>
                <td class="title_right">
                    <c:choose>
                        <c:when test="${receiverNick==null || receiveNick=='' || empty receiverNick}">
                            <input id="receiverId" type="text" name="receiveNick" value="" placeholder="받는 사람 닉네임">
                        </c:when>
                        <c:otherwise>
                            <input id="receiverId" type="text" name="receiveNick" value="${receiverNick}" placeholder="받는 사람 닉네임">
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>
    <div class="content">
        <textarea  id="content" name="content" value="" class="content_text"></textarea>
    </div>
    <div class="bottom">
        <button class="submit_btn">전송</button>
        <button class="cancel_btn">취소</button>
    </div>
</body>
</html>
