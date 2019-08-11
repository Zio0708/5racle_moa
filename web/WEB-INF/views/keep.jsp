<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	request.setCharacterEncoding("UTF-8");
	/*String[] transaction_type = { "직거래", "택배", "무관" };
	request.setAttribute("transaction_type", transaction_type);
	String[] period_type = { "단기 물품(1일~1달)", "장기 물품(1달~1년)", "무관" };
	request.setAttribute("period_type", period_type);
	String[] forbiddenCategory = { "의류", "도서", "패션잡화", "패브릭(커텐/이불)", "소형가전", "취미/운동용품", "유아용품/장난감", "음반/DVD", "캠핑용품", "기타" };
	request.setAttribute("forbidden_product_type", forbiddenCategory);
	String[] detail_price = { "1일 가격", "1주일 가격", "1달 가격", "6개월 가격", "1년 가격" };
	request.setAttribute("detail_price", detail_price);*/
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>보관해드립니다 글 등록하기</title>

<link rel="stylesheet" type="text/css" href="/resources/css/keep.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/content.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
<script src="/resources/js/jquery-3.4.1.min.js"></script>
<script src="/resources/js/keep.js"></script>
<script>
var table_product_num=1;
$(document).on("click","i[name=add_row_btn]",function() {
      table_product_num++;
      if(table_product_num>100) {
	      alert('더이상 늘릴수 없습니다.');
	      table_product_num=100;
	      return;
      }
      
      var addStaffText = '<tr name="stuff">' +'<td class="table_data">' + table_product_num + '</td>' +'<td class="table_data">' + '<select name="category">';
      <c:forEach var="category" items="${forbidden_product_type}" varStatus="cnt">
      addStaffText += ('<option value="${category}">${category}</option>');
      </c:forEach>
	  addStaffText += '</select>' + '</td>';

	  addStaffText += '<td class="table_data"><input type="text" name="product_name"></td>' + '</tr>';
      var trHtml = $( "tr[name=stuff]:last" ); //last를 사용하여 trStaff라는 명을 가진 마지막 태그 호출
      trHtml.before(addStaffText); //마지막 trStaff명 뒤에 붙인다
});
</script>

</head>
<body>
<%--<%@ include file="navbar.jsp" %>--%>

	<div class="wrap">
		<div id="left_side" class="left_side" style="display: none;">
			<i class="fas fa-angle-left fa-5x" onclick="prevForm()"></i>
		</div>
		<div id="right_side" class="right_side">
			<i class="fas fa-angle-right fa-5x" onclick="nextForm()"></i>
		</div>

		<div class="main">
			<div class="main_board">
				<div id="exit_button">
					<button type="button" class="exit_btn" id="exit_btn" name="exit_btn" onClick="exit()">나가기</button>
				</div>
				
				<form id="regForm" class="regForm" name="regForm">
					<div class="content1" id="content1">
						<h2 class="head_1">선호 거래 방식을 선택해주세요</h2>
						<div class="deliver_type">
							<c:forEach var="transaction" items="${transaction_type}" varStatus="cnt" >
								<div class="deliver">
									<input type="radio" class="radio_btn" name="trade_type_answer" value="${transaction}"/>${transaction}
								</div>
							</c:forEach>
						</div>

						<h2 class="head_1">반려 동물 여부를 선택해주세요</h2>
						<div class="pet_type">
							<div class="pet">
								<input type="radio" id="pet_true" class="radio_btn, c_btn" name="radio" value="1" /> 유
								<input type="text" id="pet_text" class="pet_text" name="pet_text" placeholder="종류를 입력하세요" disabled />
								<input type="radio" id="pet_false" class="radio_btn, c_btn" name="radio" value="0" /> 무
							</div>
						</div>

						<h2 class="head_1">CCTV 여부를 선택해주세요</h2>
						<div class="cctv_type">
							<div class="cctv">
								<input type="radio" class="radio_btn, c_btn" name="cctv_answer" value="CCTV" /> 유
								<input type="radio" class="cctv_r radio_btn, c_btn" name="cctv_answer" value="없음"/> 무
							</div>
						</div>
					</div>

					<div class="content2" id="content2" style="display:none">
						<h2 class="head_1">맡을 수 없는 물건을 입력해주세요</h2>
						<table class='entrust_product_tb'>
							<thead>
								<tr class="table_row">
									<th class="table_head">번호</th>
									<th class="table_head">카테고리</th>
									<th class="table_head">물건명</th>
								</tr>
							</thead>
							<tr name='stuff'>
								<td class="table_data">1</td>
								<td class="table_data">
									<select name="category">
										<c:forEach var="category" items="${forbidden_product_type}" varStatus="cnt" >
											<option value="${category}">${category}</option>
										</c:forEach>
									</select>
								</td>
								<td class="table_data"><input type="text" name="product_name"></td>
							</tr>
							<tr id="stuff" name='stuff'>
								<td colspan="4"><i class="fas fa-plus-circle" name='add_row_btn'></i></td>
							</tr>
						</table>
					</div>

					<div class="content3" id="content3" style="display: none;">
						<h2 class="head_3">보관 기간을 입력해주세요</h2>
						<div class="time_type">
							<c:forEach var="period" items="${period_type}" varStatus="cnt" >
								<div class="time">
									<input type="radio" class="radio_btn" name="time_answer" value="${period}"/>${period}
								</div>
							</c:forEach>
						</div>

						<h2 class="head_3">보관 가격(5호 박스 기준)을 입력해주세요</h2>
						<div class="price_type">
							<c:forEach var="price" items="${detail_price}" varStatus="cnt" >
								<div class="prices">
									<ul>
										<li class="price">${price}</li>
										<li><input type="text" class="i_price" name="price" placeholder="금액 입력" /> 원</li>
									</ul>
								</div>
							</c:forEach>
						</div>
					</div>

					<div class="content4" id="content4" style="display: none;">
						<h2 class="head_4">보관 장소의 사진을 첨부해주세요</h2>
						<div class="photo_type">
							<label for="photo_main1"> <img id="main_1" class="photo_main" src="/resources/image/photo_main.jpg" /> </label> 
							<input type="file" id="photo_main1" class="input_p" name = "photo" accept=".jpg, .png" onchange="readURL1(this);" />
							<label for="photo_main2"> <img id="main_2" class="photo_main" src="/resources/image/photo_main.jpg" /> </label>
							<input type="file" id="photo_main2" class="input_p" name = "photo" accept=".jpg, .png" onchange="readURL2(this);" />
						</div>
						<h4 class="head_4_1">공간 사진을 최소 2장 촬영해주세요</h4>

						<div class="photo_type2">
							<label for="photo_etc1"><img id="etc_1" class="photo_etc" src="/resources/image/photo_etc.jpg" /></label>
							<input type="file" id="photo_etc1" class="input_p" name = "photo" accept=".jpg, .png" onchange="readURL3(this);" />
							<label for="photo_etc2"><img id="etc_2" class="photo_etc" src="/resources/image/photo_etc.jpg" /></label>
							<input type="file" id="photo_etc2" class="input_p" name = "photo" accept=".jpg, .png" onchange="readURL4(this);" />
							<label for="photo_etc3"><img id="etc_3" class="photo_etc" src="/resources/image/photo_etc.jpg" /></label>
							<input type="file" id="photo_etc3" class="input_p" name = "photo" accept=".jpg, .png" onchange="readURL5(this);" />
						</div>
						<h4 class="head_4_1">추가 사진은 3장까지 가능합니다</h4>
					</div>

					<div class="content5" id="content5" style="display: none;">
						<h2 class="head_5">제목을 입력해주세요</h2>
						<div>
							<input type="text" class="post_title" name="post_title" placeholder="제목을 20자리 이내로 작성하세요" maxlength="20">
						</div>
						<h2 class="head_5">상세 설명을 입력해주세요</h2>
						<textarea class="post_contents" name="post_contents" rows="14" cols="60" placeholder="맡길 물건에 대한 간단한 설명을 입력해주세요" maxlength="1000"></textarea>
					</div>
				<!-- </form> -->
				
				<div class="content6" id="content6" style="display: none;">
					<h2 class="head_6">아래 내용을 확인하시고 등록하기 버튼을 눌러주세요</h2>
					<h3 class="head_6_1">주의하세요!</h3>
					<textarea class="caution" name="caution" rows="5" cols="60" disabled readonly="0">반드시 사이트를 통해 결제를 해야 하며 물건이 훼손될 경우, 호스트에게 책임이 있습니다. 사용자가 시간을 준수하지 않은 경우, 금전적인 책임은 사용자에게 있으며 호스트는 물건에 대한 책임을 지지 않습니다. 물건 보관 만료 일주일 전에 알림 문자가 발송됩니다.</textarea>
					<div class="confirm">
						<ul class="content6_ul">
							<li class="content6_li"><input id="submit_check" type="checkbox" class="check_btn" /></li>
							<li class="content6_li">위 내용을 확인했습니다.</li>
						</ul>
					</div>
					<button type="button" class="register_btn" onclick="submitForm()">맡아주기 글 등록하기</button>
				</div>
				</form>
				<div class="content7" id="content7" style="display: none;">
					<h2 class="head_7"></h2>
					<h4 class="head_7_1">'보관해드립니다' 글 등록이 완료되었습니다</h4>
					<button class="finished" onclick="finished()">확인</button>
				</div>
				<div id="bar">
					<div id="percent" style="height: 40px; width: 0%">&nbsp;&nbsp;&nbsp;0%</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>
