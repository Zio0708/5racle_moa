<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
<link rel="stylesheet" href="/resources/css/requestStoreList.css">
<link rel="stylesheet" href="/resources/css/requestStoreInfo.css">
<script src="/resources/js/jquery-3.4.1.min.js"></script>
<script src="/resources/js/requestList.js"></script>
</head>

<body>
<%@ include file="navbar.jsp" %>
	<div class="popup_wrapper"></div>
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
              <h3>보관해주세요 신청 목록</h3>
            </div>
            <div class="main_content">

             <table id="listTable">
               <tr>
                 <th id="title_profile">프로필</th>
                 <th id="title_nick">호스트 닉네임</th>
                 <th id="title_period">보관기간</th>
                 <th id="title_info">물품정보</th>
                 <th id="title_price">가격</th>
                 <th id="title_address">주소</th>
               </tr>
                 <c:choose>
                     <c:when test="${fn:length(requestList) != 0}">
                         <c:forEach var="requestListVO" items="${requestList}" begin="0" varStatus="loopCount">
                             <tr class="rows" id="${requestListVO.requestId}">
                                 <td><img src="/resources/image/${requestListVO.profileName}" alt=""></td>
                                 <td>${requestListVO.hostNick}</td>
                                 <td>${requestListVO.startDate} ~ ${requestListVO.endDate}</td>
                                 <td>
                                         ${productList[loopCount.index]}
                                 </td>
                                 <c:choose>
                                     <c:when test="${requestListVO.measuredPrice >= requestListVO.bargainPrice}">
                                         <td> <fmt:formatNumber value="${requestListVO.bargainPrice}" pattern="#,###" /></td>
                                     </c:when>
                                     <c:otherwise>
                                         <td> <fmt:formatNumber value="${requestListVO.measuredPrice}" pattern="#,###" /></td>
                                     </c:otherwise>
                                 </c:choose>
                                 <td>${requestListVO.baseAddress}<br/> ${requestListVO.detailAddress}</td>
                             </tr>
                         </c:forEach>
                     </c:when>
                     <c:otherwise>
                         <tr>
                            <td colspan="6">
                                <div align="center">신청 목록이 존재 하지 않습니다.</div>
                            </td>
                         </tr>
                     </c:otherwise>
                 </c:choose>

             </table>
           </div>

           <div class="main_paging">
               <img id="load" src="/resources/image/load.gif" />
               <c:choose>
                   <c:when test="${fn:length(requestList) != 0}">
                       <c:choose>
                           <c:when test="${curPage > 1}">
                               <a href="/mypage/requestlist/${curPage - 1}"><i class="fas fa-angle-left"></i></a>
                           </c:when>
                           <c:otherwise>
                               <i class="fas fa-angle-left"></i>
                           </c:otherwise>
                       </c:choose>

                       <c:forEach var="page" begin="1" end="${totPageCnt}" step="1">
                           <c:choose>
                               <c:when test="${curPage ne page}">
                                   <a class="not_cur_page" href="/mypage/requestlist/${page}">${page}</a>
                               </c:when>
                               <c:otherwise>
                                   <a class="cur_page">${page}</a>
                               </c:otherwise>
                           </c:choose>
                       </c:forEach>
                       <c:choose>
                           <c:when test="${curPage < totPageCnt}">
                               <a href="/mypage/requestlist/${curPage+1}"><i class="fas fa-angle-right"></i></a>
                           </c:when>
                           <c:otherwise>
                               <i class="fas fa-angle-right"></i>
                           </c:otherwise>
                       </c:choose>
                   </c:when>
               </c:choose>

           </div>
            </div>
          </div>
        </div>
      </div>
      <%@ include file="footer.jsp" %>
    </div>
</body>
</html>