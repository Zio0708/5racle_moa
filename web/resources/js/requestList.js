
$(document).ready(function(){
	function clickList(tr){
		alert(tr);
	}
	
	$('.rows').click(function(){
		var tr = $(this);
		var id = tr.attr('id');
		
		$.ajax({
			type:"GET",
			url: "/mypage/requestlist/" + id,
			dataType:"JSON",
			success : function(data){
				console.log(data);
	
				var str = '';
				str += '<div class="popup">';
				str +=   '<div class="rs_background"></div>'
				str +=	 	    '<div class="rs_container">'
				str +=  '<div class="rs_wrapper">'
				str +=    '<div class="rs_header">'
				str +=     '<h1>요청 상세정보</h1>'
				str +=   '</div>'
				str +=   '<div class="rs_body">'
				str +=     '<div class="rs_context">'
				str +=       '<div class="rs_context_title">'
				str +=         '<h2>전달 내용</h2>'
				str +=       '</div>'
				str +=       '<div class="rs_context_contents">'
				str +=        '<h4>' + data.content + '</h4>'
				str +=      '</div>'
				str +=   '</div>'
				str +=   '<div class="rs_storage_products">'
				str +=     '<div class="rs_storage_products_title">'
				str +=       '<h2>보관 물품</h2>'
				str +=      '</div>'
				str +=     '<div class="rs_storage_products_contents">'
				str +=      '<table>'
				str +=         '<tr>'
				str +=           '<th>NO.</td>'
				str +=        '<th>카테고리</td>'
				str +=        '<th>물건명</td>'
				str +=        '<th>물건개수</td>'
				str +=      '</tr>'	
					
				for(var i = 0 ; i < data.productName.length; i++){
					str +=      '<tr>'
					str += '<td>' + (i + 1) + '</td>'
					str += '<td>' + data.productCategory[i] + '</td>'
					str += '<td>' + data.productName[i] + '</td>'
					str += '<td>' + data.productCnt[i] + '</td>'
					str +=      '</tr>'
				}
		
				str +=    '</table>'
				str +=  '</div>'
				str +='</div>'
				str +='<div class="rs_other">'
				str +=  '<div class="rs_other_title">'
				str +=    '<h2>기타 정보</h2>'
				str +=  '</div>'
				str +=  '<div class="rs_other_content">'
//				str +=    '<div class="rs_size">'
//				str +=      '<div class="rs_size_title">'
//				str +=        '<h4>크기</h4>'
//				str +=      '</div>'
//				str +=      '<div class="rs_size_contents">'
//				str +=        '<h4 class="rs_box">박스기준 : 8개</h4>'
//				str +=        '<h4 class="rs_bicycle">자전거 이상 : 0개</h4>'
//				str +=        '<h4 class="rs_bed">싱글 침대 이상 : 0개</h4>'
//				str +=      '</div>'
//				str +=    '</div>'
				str +=    '<div class="rs_price">'
				str +=      '<div class="rs_price_title">'
				str +=        '<h4>가격</h4>'
				str +=      '</div>'
				str +=      '<div class="rs_price_contents">'
				str +=        '<h4 class="rs_measured">측정가격 : ' + data.measuredPrice + '원</h4>'
				str +=        '<h4 class="rs_bargain">흥정가격 : ' + data.bargainPrice +  '원</h4>'
				str +=      '</div>'
				str +=    '</div>'
				str +=    '<div class="rs_storage_date">'
				str +=      '<div class="rs_storage_date_title">'
				str +=        '<h4>보관기간</h4>'
				str +=      '</div>'
				str +=      '<div class="rs_storage_date_contents">'
				str +=        '<h4 class="rs_start_date">' + data.startDate + '</h4>'
				str +=        '<h4 class="rs_end_date">' + data.endDate + '</h4>'
				str +=      '</div>'
				str +=    '</div>'
				str +=    '<div class="rs_transaction_type">'
				str +=      '<div class="rs_transaction_type_title">'
				str +=        '<h4>거래방식</h4>'
				str +=      '</div>'
				str +=      '<div class="rs_transaction_type_contents">'
				str +=        '<h4>' + data.transactionType +'</h4>'
				str +=      '</div>'
				str +=    '</div>'
				str +=    '<div class="rs_application_date">'
				str +=      '<div class="rs_application_date_title">'
				str +=        '<h4>요청일자</h4>'
				str +=      '</div>'
				str +=      '<div class="rs_application_date_contents">'
				str +=        '<h4>' + data.applicationDate + '</h4>'
				str +=      '</div>'
				str +=    '</div>'
				str +=  '</div>'
				str +='</div>'
//				str +='<div class="rs_button">'
//				str +=  '<div class="rs_confirm_button">'
//				str +=    '<button type="button" name="confirm_btn" id="confirm_btn">승인</button>'
//				str +=  '</div>'
//				str +=  '<div class="rs_refuse_button">'
//				str +=    '<button type="button" name="refuse_btn" id="refuse_btn">거절</button>'
//				str +=  '</div>'
//				str +='</div>'
				str +='</div>'
				str +='</div>'
				str +='<div class="rs_exit_btn">'
				str +='<i class="fas fa-times fos"></i>'
				str += '</div>';
				str += '</div>';
				str += '</div>';
				
				$('.popup_wrapper').append(str);
				console.log('ok');
				$('.fas').click(function(){
					$('.popup').remove();
				});
			
			},
			error:function(error){
				console.log(error);
				alert("승인이 실패하였습니다.");
			}
		});
	});
	$('#listTable td').click(function(){

//		$('.rs_confirm_button').click(function(){
//			var result = confirm('정말로 승인하시겠습니까?');
//			if(result == true){
//				alert("승인되었습니다.");
//				$('.popup').remove();
//			}
//		});
//		$('.rs_refuse_button').click(function(){
//			var result = confirm('정말로 삭제하시겠습니까?');
//			if(result == true){
//				alert("삭제되었습니다.")
//			}
//				
//		});
		
	});
	
	
})


var moveToInfo = function(){
//	location.href = ""
	alert("일시적으로 서비스가 중단되었습니다.");
}
var moveToMessage = function(){
//	location.href = ""
	alert("일시적으로 서비스가 중단되었습니다.");
}
var moveToTransaction = function(){
//	location.href = ""
	alert("일시적으로 서비스가 중단되었습니다.");
}
var moveToRequest = function(){
	location.href = "/mypage/requestlist";

}
var moveToLatest = function(){
//	location.href = ""
	alert("일시적으로 서비스가 중단되었습니다.");
}
var moveToFavorite = function(){
//	location.href = ""
	alert("일시적으로 서비스가 중단되었습니다.");
}
function getContextPath(){
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	return contextPath;
}