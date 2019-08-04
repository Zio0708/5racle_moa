<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="/resources/js/navbar.js"></script>
    <link rel="stylesheet" href="/resources/css/navbar.css">
    <div class="navbar">
      <div class="logo_img">
      </div>
      <div class="navbar_left ">
        <a href="${pageContext.request.contextPath}/moa/search" id="take_charge_btn">보관소 찾기</a>
        <a href="javascript:void(0)">|</a>
        <a href="${pageContext.request.contextPath}/moa/hostpage/confirmyet" id="leave_btn">호스트 페이지</a>
      </div>
      <div class="menu navber_right">
        <a href="javascript:void(0)" id="loginout_btn">로그아웃</a>
        <a href="javascript:void(0)">|</a>
        <a href="${pageContext.request.contextPath}/moa/mypage" id="signup_mypage_btn">마이페이지</a>
        <a class="fas fa-align-justify hide" id="sidebar_btn"></a>
      </div>
    </div>
    <div class="doc">
    <div class="sidebar">
      <div class="sidehide">
        <i class="fa fa-times" aria-hidden="true"></i>
      </div>
      <div class="author">
        <li>
          <a href="myPage.jsp">
            <div class="author_profile">
              <img src="/resources/image/navbar/profile.png" alt="">
            </div>
            <div class="author_name">
                           김모아<br/>
              <span>moa@lectopia.com</span>
            </div>
          </a>
        </li>
      </div>

      <div class="main_menu">
        <ul>
       	 <li><a href="${pageContext.request.contextPath}/moa/registhost">호스트 신청하기</a></li>
          <li><a href="${pageContext.request.contextPath}/moa/main">홈으로</a></li>
          <li><a href="${pageContext.request.contextPath}/moa/search">보관소 찾기</a></li>
          <li><a href="${pageContext.request.contextPath}/moa/mypage">마이페이지</a></li>
          <li><a href="">즐겨찾기</a></li>
          <li><a href="">최근 본 장소</a></li>
        </ul>
      </div>
      <div class="sub_menu">
        <ul>
          <li><a href="${pageContext.request.contextPath}/moa/hostpage/confirmyet">호스트 페이지</a></li>
          <li><a href="">서비스 가이드</a></li>
          <li><a href="">공지사항</a></li>
          <li><a href="">고객센터</a></li>
        </ul>
      </div>
    </div>
    </div>
