<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-08-03
  Time: 오후 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.example.springmvc.vo.*" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="articlesList" value="${articlesMap.articlesList}"/>
<c:set var="totArticles" value="${articlesMap.totArticles}"/>
<c:set var="section" value="${articlesMap.section}"/>
<c:set var="pageNum" value="${articlesMap.pageNum}"/>
<c:set var="storeBoardVO" value="${storeBoard.storeBoardVO}"/>
<c:set var="hostReputationVO" value="${storeBoard.hostReputationVO}"/>
<% request.setCharacterEncoding("utf-8");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" ></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
    <link rel="stylesheet" href="/resources/css/more_information.css">
    <link rel="stylesheet"  href="/resources/css/lightslider.css"/>
    <link rel="stylesheet" href="/resources/css/gallery.css">
    <script src="https://use.fontawesome.com/d1341f9b7a.js"></script>
    <script src="/resources/js/more_information.js"></script>
    <script src="/resources/js/lightslider.js"></script>
    <script>
        $(document).ready(function() {
            $(".img_btn").on("click",function(){
                $(".gallary_div").css('display','block');
                $(".gallary_wrap").css('visibility','visible');
            });
            $(".gallary_div").click(function(){
                $(".gallary_wrap").css('visibility','hidden');
                setTimeout(function(){$(".gallary_div").css('display','none');},220);
            })
            $('#image-gallery').lightSlider({
                gallery:true,
                item:1,
                thumbItem:5,
                autoWidth:true,
                slideMargin: 0,
                keyPress:true,
                speed:500,
                auto:false,
                loop:true
            });
        });
    </script>
    <title>Insert title here</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class='gallary_div'></div>

<div class="gallary_wrap">
    <div class="demo">
        <div class="item">
            <div class="clearfix">
                <ul id="image-gallery" class="gallery list-unstyled">
                    <li data-thumb="/resources/image/host_board/1/thumb/host_board_thumb_1_1.PNG">
                        <img src="/resources/image/host_board/1/host_board_1_1.PNG" />
                    </li>
                    <li data-thumb="/resources/image/host_board/1/thumb/host_board_thumb_1_2.PNG">
                        <img src="/resources/image/host_board/1/host_board_1_2.PNG" />
                    </li>
                    <li data-thumb="/resources/image/host_board/1/thumb/host_board_thumb_1_3.PNG">
                        <img src="/resources/image/host_board/1/host_board_1_3.PNG" />
                    </li>


                </ul>
            </div>
        </div>
    </div>
</div>
<div class="wrap" id="wrap">
    <div class="wrap_header">
        <div class="title" id="title">${storeBoardVO.title}</div>
        <button class="delete_btn btn" id="delete_btn">삭제</button>
    </div>
    <div class="wrap_content">
        <div class="host_info" id='host_info'>
            <div class="id_info info_item" id='id_info'><i class="fas fa-user"></i><div class="info_item_text">${hostReputationVO.nick}</div></div>
            <div class='like_info info_item' id='like_info'><i class="far fa-thumbs-up"></i><div class="info_item_text">${hostReputationVO.favoriteCnt}</div></div>
            <div class = 'star_info info_item' id='star_info'><i class="far fa-star"></i><div class="info_item_text">${hostReputationVO.starPointAvg}(${hostReputationVO.totalReviewCnt})</div></div>
            <div class="summary_info" id='summary_info'>
                <table class="summary_info_tb" style="width:160px">
                    <tr>
                        <th>보관지 형태</th>
                        <td>${storeBoardVO.storageType}</td>
                    </tr>
                    <tr>
                        <th>가격</th>
                        <td>${storeBoardVO.detailPrice.month}원/5호박스 (1달)</td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td>${fn:substring(storeBoardVO.baseAddress,0,15)}  </td>
                    </tr>
                    <tr>
                        <th>배송</th>
                        <td>${storeBoardVO.transactionType}</td>
                    </tr>
                    <tr>
                        <th>반려동물</th>
                        <td>
                            <c:choose>
                                <c:when test="${storeBoardVO.pet != '없음' }">있음</c:when>
                                <c:otherwise> 없음</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <th>보안시설</th>
                        <td>
                            <c:choose>
                                <c:when test="${storeBoardVO.securityFacility != null }">있음</c:when>
                                <c:otherwise> 없음</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <th>보관 금지 물품</th>
                        <td>
                            <c:choose>
                                <c:when test="${storeBoardVO.forbiddenProduct != null }">
                                    ${fn:substring(storeBoardVO.forbiddenProduct,0,15)}
                                </c:when>
                                <c:otherwise> 없음</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </table>
            </div>
            <button class='entrust_btn btn' id='entrust_btn' onclick="location.href='/entrust/${storeBoardVO.articleNum}'">보관해주세요</button>
        </div>

        <div class="image_info" id='image_info'>
            <div class="prev_img" id='prev_img'><img class='prev_image' id='prev_image' src="/resources/image/host_board/1/host_board_1_1.PNG"/></div>
            <div class="img_btn" id='img_btn'><img class ='img_icon'src="/resources/image/host_board/1/host_board_1_1.PNG"/></div>
            <div class="like_btn" id="like_btn"><i class="far fa-heart"></i></div>
        </div>
    </div>
    <div class='desc_info'>상세정보</div>
    <div class="wrap_content_footer">
        <div class="more_info" id='more_info'>
            <c:choose>
                <c:when test="${storeBoardVO.storageType == '집'}">
                    <div class="more_info_icon"><i class="fas fa-home"></i>  </div>
                </c:when>
                <c:when test="${storeBoardVO.storageType == '회사'}">
                    <div class="more_info_icon"><i class="fas fa-city"></i>  </div>
                </c:when>
                <c:when test="${storeBoardVO.storageType == '상가'}">
                    <div class="more_info_icon"><i class="fas fa-store"></i>  </div>
                </c:when>
                <c:when test="${storeBoardVO.storageType == '기타'}">
                    <div class="more_info_icon"><i class="fas fa-warehouse"></i>  </div>
                </c:when>
            </c:choose>
            <div class="more_info_desc">${storeBoardVO.storageType}</div>
            <span>보관지 형태<div class='more_info_item'>${storeBoardVO.storageType}</div></span>
        </div>
        <div class="more_info" id='more_info'>
            <div class="more_info_icon"><i class="fas fa-money-bill"></i>  </div>
            <div class="more_info_desc">${storeBoardVO.detailPrice.month}원</div>
            <span>금액<div class='more_info_item'>5호박스 기준으로 측정한 가격입니다.<br>
          <table class='item_price_tb'>
            <tr>
              <th>1일</th>
              <td>${storeBoardVO.detailPrice.day}원</td>
            </tr>
            <tr>
              <th>1주</th>
              <td>${storeBoardVO.detailPrice.week}원</td>
            </tr>
            <tr>
              <th>1개월</th>
              <td>${storeBoardVO.detailPrice.month}원</td>
            </tr>
            <tr>
              <th>6개월</th>
              <td>${storeBoardVO.detailPrice.halfYear}원</td>
            </tr>
            <tr>
              <th>1년</th>
              <td>${storeBoardVO.detailPrice.year}원</td>
            </tr>
          </table>
          </div></span>
        </div>
        <c:if test="${storeBoardVO.pet != '없음' }">
            <div class="more_info" id='more_info'>
                <div class="more_info_icon"><i class="fas fa-dog"></i>  </div>
                <div class="more_info_desc">있음</div>
                <span>반려동물<div class='more_info_item'>${storeBoardVO.pet}</div></span>
            </div>
        </c:if>
        <div class="more_info" id='more_info'>
            <div class="more_info_icon"><i class="fas fa-map-marker-alt"></i>  </div>
            <div class="more_info_desc">${distance}km 이내</div>
            <span>주소<div class='more_info_item'>${storeBoardVO.baseAddress} ${storeBoardVO.detailAddress}</div></span>
        </div>
        <div class="more_info" id='more_info'>
            <c:choose>
                <c:when test="${storeBoardVO.transactionType == '택배'}">
                    <div class="more_info_icon"><i class="fas fa-truck"></i>  </div>
                </c:when>
                <c:when test="${storeBoardVO.transactionType == '직거래'}">
                    <div class="more_info_icon"><i class="fas fa-people-carry"></i>  </div>
                </c:when>
                <c:when test="${storeBoardVO.transactionType == '무관'}">
                    <div class="more_info_icon"><i class="fas fa-shipping-fast"></i>  </div>
                </c:when>
            </c:choose>
            <div class="more_info_desc">${storeBoardVO.transactionType}</div>
            <span>배송 여부<div class='more_info_item'>${storeBoardVO.transactionType}</div></span>
        </div>
        <c:if test="${storeBoardVO.securityFacility != null}">
            <div class="more_info" id='more_info'>
                <div class="more_info_icon"><i class="fas fa-shield-alt"></i>  </div>
                <div class="more_info_desc">보안시설</div>
                <span>보안시설<div class='more_info_item'>${storeBoardVO.securityFacility}</div></span>
            </div>
        </c:if>
        <c:if test="${storeBoardVO.forbiddenProduct != null}">
            <div class="more_info" id='more_info'>
                <div class="more_info_icon"><i class="fas fa-ban"></i>  </div>
                <div class="more_info_desc">금지 물품</div>
                <span>보관 금지 물품 <div class='more_info_item'>${storeBoardVO.forbiddenProduct}</div></span>
            </div>
        </c:if>
    </div>

    <div class="detail_description" id='detail_description'>
        ${storeBoardVO.content}
    </div>
</div>
<script>magnify("prev_image", 3);</script>
</script>
<%@ include file="footer.jsp" %>
</body>
</html>