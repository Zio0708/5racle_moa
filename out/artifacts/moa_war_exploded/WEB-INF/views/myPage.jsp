<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
<link rel="stylesheet" href="/resources/css/myPage.css">
<script src="/resources/js/jquery-3.4.1.min.js"></script>
<script src="/resources/js/myPage.js"></script>

</head>
 <body>
 <%@ include file="navbar.jsp" %>
    <div class="container">
      <div class="header">
      </div>
      <div class="content">
        <div class="mypage_menubar">
          <div class="menubar_title">
            <h1>마이 페이지</h1>
          </div>
          <div class="menubar_subtitle">
            <h3>MY PAGE</h3>
          </div>
          <div class="menubar_list">
            <ul>
              <li onclick="moveToInfo();">개인정보</li>
              <li onclick="moveToMessage();">메세지함</li>
              <li onclick="moveToTransaction();">거래내역</li>
              <li onclick="moveToRequest();">보관해주세요 신청 목록</li>
              <li onclick="moveToLatest();">최근 본 보관소</li>
              <li onclick="moveToFavorite();">즐겨찾는 보관소</li>
            </ul>
          </div>
        </div>
        <div class="main">
          <div class="main_wrapper">
            <div class="main_title">
              <h3>마이 페이지</h3>
            </div>
            <div class="main_context">
              <div class="left_context">
                <div class="profile_image">
                  <img src="/resources/image/profile.jpg"><!-- <img src="sessionScope.profile"> -->
                </div>
              </div>
              <div class="middle_context">
                <div class="userinfo">
                  <div class="username">
                    <h3>김모아</h3>
                  </div>
                  <div class="useremail">
                    <h4>moa@google.com</h4>
                  </div>
                </div>
                <div class="update">
                  <button type="button" id="update_btn" name="update_btn" onclick="updateInfo()">수정하기</button>
                </div>

                <div class="request_entrust_list" onclick="storeRequestList();">
                  <h3>보관 요청 목록 ></h3>
                  <h3 id="request_entrust_list_cnt">0개</h3>
                </div>
              </div>
              <div class="right_context">
                <div class="not_read_message" onclick="notReadMessage();">
                  <h3>안읽은 쪽지 ></h3>
                  <h3 id="not_read_message_cnt">0개</h3>
                </div>
                <div class="using_storage" onclick="usingStorage();">
                  <h3>이용중인 보관소 ></h3>
                  <h3 id="using_storage_cnt">0개</h3>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

	 <%@ include file="footer.jsp" %>

    </div>
  </body>
</html>