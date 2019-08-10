<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="/resources"/>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>보관해주세요 글 작성 페이지</title>

	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/entrust.css"/>
	<link rel="stylesheet" type="text/css" href="/resources/css/keep.css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="/resources/js/entrust.js"></script>
	<script type="text/javascript">
		var table_product_num = 1;
		$(document).on("click", "i[name=add_row_btn]", function () {
			table_product_num++;
			if (table_product_num > 100) {
				alert('더이상 늘릴수 없습니다.');
				table_product_num = 100;
				return;
			}

			var addStaffText = '<tr name="stuff">'
					+ '<td>' + table_product_num + '</td>'
					+ '<td>'
					+ '<select name="category">';
			<c:forEach var="category" items="${map.category}" varStatus="cnt">
			addStaffText += ('<option class="category_list" value="${category}">${category}</option>');
			</c:forEach>
			addStaffText += '</select>' + '</td>';
			addStaffText += '<td><input type="text" class="product_name" name="product_name"></td>';
			addStaffText += '<td><input type="number" class="product_cnt" name="product_cnt" min=0 max=100></td>' + '</tr>';
			var trHtml = $("tr[name=stuff]:last"); //last를 사용하여 trStaff라는 명을 가진 마지막 태그 호출
			trHtml.before(addStaffText); //마지막 trStaff명 뒤에 붙인다
		});
	</script>
</head>

<body>
<%@ include file="navbar.jsp" %>
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
				<button type="button" class="exit_btn" id="exit_btn" name="exit_btn" onClick="location.href='/main'">
					나가기
				</button>
			</div>

			<form id="regForm" class="regForm">
				<div class="content1" id="content1">
					<h2 class="head_1">맡기실 물건의 물품명과 개수를 입력해주세요.</h2>
					<table class='entrust_product_tb'>
						<thead>
						<tr class="table_row">
							<th class="table_head">번호</th>
							<th class="table_head">카테고리</th>
							<th class="table_head">물건명</th>
							<th class="table_head">물건 개수</th>
						</tr>
						</thead>
						<tr name='stuff'>
							<td class="table_data">1</td>
							<td class="table_data">
								<select name="category">
									<c:forEach var="category" items="${forbidden_product_type}" varStatus="cnt">
										<option value="${category}">${category}</option>
									</c:forEach>
								</select>
							</td>
							<td class="table_data"><input type="text" name="product_name"></td>
							<td class="table_data"><input type="number" name="product_cnt" min=0 max=100></td>
						</tr>
						<tr name='stuff'>
							<td colspan="4"><i class="fas fa-plus-circle" name='add_row_btn'></i></td>
						</tr>
					</table>
				</div>

				<div class="content2" id="content2" style="display: none;">
					<div class="content2_header"> 예상 5호 박스 사용 개수를 입력해주세요.
						<i class="far fa-question-circle"><span><img src="${contextPath}/image/5호박스.png"/></span></i>
					</div>
					<div class="product_size_1">
						<input type="number" class="sizeCnt" name="product_size" min=0 max=100>개
					</div>

					<div class="content2_header">박스에 들어가지 않는 물건이라면 이곳에 입력해주세요.</div>
					<div class="product_size_2">
						자전거 이상 크기 <input type="number" class="sizeCnt" name="product_size" min=0
										 max=100>개
					</div>
					<div class="product_size_3">
						싱글 침대 이상 크기 <input type="number" class="sizeCnt" name="product_size" min=0
										   max=100>개
					</div>
				</div>

				<div class="content3" id="content3" style="display: none;">
					<div class="date_class">
						<h2 class="head_3">맡길 기간을 입력해주세요.</h2>
						<input type="date" id="start_datepicker" name="date" placeholder="시작 일자">
						<input type="date" id="end_datepicker" name="date" placeholder="종료 일자">
					</div>
					<h2 class="head_3">흥정을 하고싶다면 직접 가격을 입력해주세요.</h2>
					<div class="price_class">
						<div class="price_e1">
							<input type="radio" class="radio_btn" id="expected_price" value="expected_price"
								   style="display: none;"/>
							<label for="expected_price"> 측정 가격
								<input type="number" class="i_price" name="price"> </label>
						</div>
						<div class="price_e2">
							<input type="radio" class="radio_btn" id="bargain_price" value="bargain_price"
								   style="display: none;"/>
							<label for="bargain_price"> 흥정 가격
								<input type="number" class="i_price" name="price"> </label>
						</div>
					</div>
				</div>

				<div class="content4" id="content4" style="display: none;">
					<h2 class="head_5">원하는 거래방식을 선택해주세요.</h2>
					<div class="deals">
						<div class="deal_1">
							<input type="radio" class="radio_btn" id="direct_deal" name="trade_type_answer"
								   value="직거래"/>
							<label for="direct_deal"> 직거래 </label>
						</div>
						<div class="deal_2">
							<input type="radio" class="radio_btn" id="delivery" name="trade_type_answer"
								   value="택배"/>
							<label for="delivery"> 택배 </label>
						</div>
					</div>
					<h2 class="head_5">추가 전달 내용을 입력해주세요</h2>
					<textarea class="post_contents" name="post_contents" rows="14" cols="60"
							  placeholder="맡길 물건에 대한 간단한 설명을 입력해주세요" maxlength="1000"></textarea>
				</div>

				<div class="content5" id="content5" style="display: none;">
					<h2 class="head_4">보관할 물품의 사진을 첨부해주세요</h2>
					<div class="photo_type">
						<label for="photo_main1">
							<img id="main_1" class="photo_main" src="${contextPath}/image/photo_main.jpg"/> </label>
						<input type="file" id="photo_main1" class="input_p" name="photo" accept=".jpg, .png"
							   onchange="readURL1(this);"/>
						<label for="photo_main2">
							<img id="main_2" class="photo_main" src="${contextPath}/image/photo_main.jpg"/> </label>
						<input type="file" id="photo_main2" class="input_p" name="photo" accept=".jpg, .png"
							   onchange="readURL2(this);"/>
					</div>
					<h4 class="head_4_1">보관 물품을 최소 2장 촬영해주세요</h4>

					<div class="photo_type2">
						<label for="photo_etc1">
							<img id="etc_1" class="photo_etc" src="${contextPath}/image/photo_etc.jpg"/>
						</label>
						<input type="file" id="photo_etc1" class="input_p" name="photo" accept=".jpg, .png"
							   onchange="readURL3(this);"/>
						<label for="photo_etc2">
							<img id="etc_2" class="photo_etc" src="${contextPath}/image/photo_etc.jpg"/>
						</label> <input type="file" id="photo_etc2" class="input_p" name="photo" accept=".jpg, .png"
										onchange="readURL4(this);"/>
						<label for="photo_etc3">
							<img id="etc_3" class="photo_etc" src="${contextPath}/image/photo_etc.jpg"/>
						</label> <input type="file" id="photo_etc3" class="input_p" name="photo" accept=".jpg, .png"
										onchange="readURL5(this);"/>
					</div>
					<h4 class="head_4_1">추가 사진은 3장까지 가능합니다</h4>
				</div>
			</form>

			<div class="content6" id="content6" style="display: none;">
				<h2 class="head_6">아래 내용을 확인하시고 등록하기 버튼을 눌러주세요</h2>
				<h3 class="head_6_1">주의하세요!</h3>
				<textarea class="caution" name="caution" rows="5" cols="60" disabled readonly="0">호스트와 직접 거래를 하시지 마시고 반드시 사이트를 통해 결제를 하시길 바랍니다. 또한 물건 보관 연장이 필요할 경우, 반드시 사이트를 통해 연장을 하시길 바랍니다. 물품 보관 만료 일주일전에 문자를 발송해 드립니다. </textarea>
				<div class="confirm">
					<ul class="content6_ul">
						<li class="content6_li"><input id="submit_check" type="checkbox" class="check_btn"/></li>
						<li class="content6_li">위 내용을 확인했습니다.</li>
					</ul>
				</div>
				<button type="button" class="register_btn" onclick="submitForm()">물품 보관 요청하기</button>
			</div>

			<div class="content7" id="content7" style="display: none;">
				<h2 class="head_7"></h2>
				<h4 class="head_7_1">물건 맡기기 신청을 완료하였습니다.<br> 호스트가 확인하는대로 알림을 드리겠습니다</h4>
				<button class="finished" onClick="finished()">확인</button>
			</div>

			<div id="bar">
				<div id="percent" style="height: 40px; width: 0%">&nbsp;&nbsp;&nbsp;0%</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="footer.jsp" %>
</body>


<script>
	$(function () {
		$("#start_datepicker").datepicker({
			dateFormat: 'yy-mm-dd',
			prevText: '이전 달',
			nextText: '다음 달',
			minDate: 0,
			monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			dayNames: ['일', '월', '화', '수', '목', '금', '토'],
			dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
			dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
			showMonthAfterYear: true,
			changeMonth: true,
			changeYear: true,
			yearSuffix: '년',
			onClose: function (selectedDate) {
				$("#end_datepicker").datepicker("option", "minDate", selectedDate);
			}
		});
		$("#end_datepicker").datepicker({
			dateFormat: 'yy-mm-dd',
			prevText: '이전 달',
			nextText: '다음 달',
			monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			dayNames: ['일', '월', '화', '수', '목', '금', '토'],
			dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
			dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
			showMonthAfterYear: true,
			changeMonth: true,
			changeYear: true,
			yearSuffix: '년',
			onClose: function (selectedDate) {
				$("#start_datepicker").datepicker("option", "maxDate", selectedDate);
			}
		});
	});

	function readURL1(input) {
		if (input.files && input.files[0]) {
			let reader = new FileReader();
			reader.onload = function (e) {
				$('#main_1').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	function readURL2(input) {
		if (input.files && input.files[0]) {
			let reader = new FileReader();
			reader.onload = function (e) {
				$('#main_2').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	function readURL3(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function (e) {
				$('#etc_1').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	function readURL4(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function (e) {
				$('#etc_2').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	function readURL5(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function (e) {
				$('#etc_3').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
</html>