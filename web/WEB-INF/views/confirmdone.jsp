<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/js/confirmdone.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/requestStoreList.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/confirmdone.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/requestStoreInfo.css">
<title>MOA</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="popup_wrapper"></div>
  <div class="container">
      <div class="content">
        <div class="hostpage_menubar">
          <div class="menubar_title">
            <h1>호스트 페이지</h1>
          </div>
          <div class="menubar_subtitle">
            <h3>HOST PAGE</h3>
          </div>
          <div class="menubar_list">
            <ul>
              <li id="request_btn">요청목록</li>
              <li id="my_storage_btn">나의 보관소</li>
            </ul>
          </div>
        </div>

        <div class="main">
            <div class="main_title">
              <table >
                <tr>
                  <th id="table_title1">승인대기</th>
                  <th id="table_title2">승인완료</th>
                  <th id="table_space"></th>
                </tr>
              </table>
            </div>

            <div class="main_content">

              <table id="listTable">
                <tr>
                  
                </tr>

              </table>
            </div>

            <div class="main_paging">
                <img src="/resources/image/giphy.gif">
                <span></span>
            </div>

        </div>

      </div>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>