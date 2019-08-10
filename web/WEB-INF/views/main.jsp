<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
<title>welcome to MOA</title>
</head>
<body>
	<%@ include file="navbar.jsp" %>
	<div class="wrapper">
  	<div class="container">
          <div class="slidershow middle">
            <div class="slide_text">
             	 <!-- 이러다 지구도 담겠어! -->
            </div>
           <!--  <div class="left_btn">
              <button id ="left_btn" type="button" name="button"  onclick="location.href=''"><i class="fas fa-cubes"></i> | 보관소 찾기</button>
            </div>
            <div class="right_btn">
              <button id ="right_btn" type="button" name="button" onclick="location.href='confirmyet.jsp'"><i class="fas fa-hand-holding"></i> | 호스트 페이지</button>
            </div> -->
            <div class="left_paging"> 
              <i class="fas fa-angle-left"></i>
            </div>
            <div class="right_paging">
              <i class="fas fa-angle-right"></i>
            </div>
            <div class="slides">
                <input type="radio" name="r" id="r1" disable>
                <input type="radio" name="r" id="r2" disable >
                <input type="radio" name="r" id="r3" disable>
              <div class="slide s1">
                  <img src="${pageContext.request.contextPath }/image/main/slide1.jpg" alt="">
              </div>
              <div class="slide">
                  <img src="${pageContext.request.contextPath }/image/main/slide2.jpg" alt="">
              </div>
              <div class="slide">
                  <img src="${pageContext.request.contextPath }/image/main/slide3.jpg" alt="">
              </div>
            </div>

            <div class="navigation">
              <label id ="l1" class="bar" ></label>
              <label id ="l2" class="bar" ></label>
              <label id ="l3" class="bar" ></label>
            </div>
          </div>
        </div>
        </div>
        <%@ include file="footer.jsp" %>
      
</body>
</html>