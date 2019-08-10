<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="/resource" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script>
    <script src="${pageContext.request.contextPath}/resources/js/myStorage.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/myStorage.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">

<title>MOA</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
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
              <table>
                <tr>
                  <th id="table_title1">나의 보관소</th>
                  <th id="table_space"></th>
                  <th id="table_btn">
                    <button id="add_address_btn"type="button" name="button">
                      주소지 추가+
                    </button>
                    <button id="add_storage_btn"type="button" name="button" onclick="location.href='${contextPath}/moa/keep'">
                      보관소 추가+
                    </button>
                  </th>
                </tr>
              </table>
            </div>
            <div class="main_content">
            <!-- 
            <table >
               <tr>
               	<td class="table_top" colspan="3">
               		<i class="far fa-star"> 4.5</i>
               		<i class="far fa-heart"> 20</i>
               	</td>
               </tr>
               
               <tr>
               	<td class="table_left table_img" rowspan="4">
               		<img  alt="" src="${contextPath}/image/navbar/storage.png">
               	</td>
               	<td class="table_middle table_title">제 목</td>
               	<td class="table_right">제목입니다.</td>
               </tr>
               
               <tr>
               	<td class="table_middle table_title">보관중인 물건 개수</td>
               	<td class="table_right">0개</td>
               </tr>
               
               <tr>
               	<td class="table_middle table_title">보관만료된 물건 개수</td>
               	<td class="table_right">0개</td>
               </tr>
               
               <tr class="table_bottom">
               	<td colspan="2">
               		<button>수정</button>
               		<button>삭제</button>
               	</td>          	
               </tr>
               
              </table>
               -->
              
            </div>
            <div class="main_bottom">
                <div class="main_paging">
                    <span>loading...</span>
                </div>
            </div>

        </div>

      </div>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>