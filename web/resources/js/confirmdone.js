
$(document).ready(function() {
	$.confirmDone(1);
	
	  $("#table_title1").on('click',function(){
	      location.href="/hostpage/confirmyet";
	  });
	  $("#table_title2").on('click',function(){
	    location.href="/hostpage/confirmdone";
	  });

	  $("#request_btn").on('click',function(){
		  location.href="/hostpage/confirmyet";
	});
	$("#my_storage_btn").on('click',function(){
	    location.href="/hostpage/mystorage";
	});
	
	
	
});
function getContextPath(){
	   var hostIndex = location.href.indexOf(location.host) + location.host.length;
	   var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	   return contextPath;
	}

function cancle_btn(){
	if(confirm("정말로 삭제하시겠습니까?")){
		var aNum = event.target.className;
		$.ajax({
			url:getContextPath() + "/moa/confirmyetdel",
			type:"POST",
			dataType:"text",
			data:{
				articleNum:aNum,
				state:'delete'
			},
			success:function(data){
				alert("삭제가 완료되었습니다.");
			},
			error:function(error){
				alert("삭제를 실패하였습니다.");
			}
		});
		//$('.main_content>table>tbody>tr:nth-child('+event.target.className+')').remove('tr');
	}
	else{
		alert("승인이 취소되었습니다.");
		return false;
	}
};
$.confirmDone = function(curPage){
	$.ajax({
		url:"/hostpage/confirmdone/list",
		type:"get",
		contentType:"application/json",
		dataType:"json",
		data:{
			curPage:curPage
		},
		success:function(result){
			//test console -- 추후 삭제
			console.log(result.list);
			console.log(result.list[0].articleNum);
			console.log(result.pagination);

			//리스트
			$('.main_content>table>tbody>tr').remove('tr');
			for(let i = result.pagination.curListCnt-1; i >= 0; i--){
				if(i == result.pagination.curListCnt-1){//제목
					let tr = $('<tr/>').appendTo('.main_content>table>tbody');
					$('<td/>', { text : '프로필', id : 'title_profile' }).appendTo(tr);
					$('<td/>', { text : '닉네임', id : 'title_nick' }).appendTo(tr);
					$('<td/>', { text : '보관기간', id : 'title_period' }).appendTo(tr);
					$('<td/>', { text : '물품정보', id : 'title_info' }).appendTo(tr);
					$('<td/>', { text : '가격', id : 'title_price' }).appendTo(tr);
					$('<td/>', { text : '승인여부', id : 'title_approve' }).appendTo(tr);
					$('<td/>', { text : '비고', id : 'title_delete',class : '.delete_list_btn',onclick:'cancle_btn' }).appendTo(tr);
				}
				var products = result.list[i].products;
				if(products.length > 20){
					products = products.substring(0,20);
					products = products.concat('...');
				}
				let tr = $('<tr/>').appendTo('.main_content>table>tbody');
				let td1 = $('<td/>').appendTo(tr);
				$('<img/>',{src :"/resources/image/navbar/"
						+result.list[i].profileImg ,alt:"이미지 경로 오류"}).appendTo(td1);
				$('<td/>',{text:result.list[i].nick}).appendTo(tr);
				$('<td/>',{text:result.list[i].startDate +" ~ "+result.list[i].endDate}).appendTo(tr);
				$('<td/>',{text: products,class:'table_click',id:result.list[i].articleNum}).appendTo(tr);
				$('<td/>',{text:result.list[i].price}).appendTo(tr);
				$('<td/>',{text:result.list[i].state}).appendTo(tr);
				let td7 = $('<td/>').appendTo(tr);

				$('<button/>',{text:"삭제 ", class:result.list[i].article, onclick:'cancle_btn()'}).appendTo(td7);
			}

			//페이징처리
			$('.main_paging>span').remove('span');
			$('.main_paging>i').remove('i');
			if(curPage == 1){
				$('<i/>',{class:"fas fa-angle-left",text:"\u00A0\u00A0"}).appendTo('.main_paging');
			}
			else{
				$('<i/>',{class:"fas fa-angle-left",text:"\u00A0\u00A0", style:"cursor:pointer;"}).click(function(e){
					$.confirmDone(curPage-1);
				}).appendTo('.main_paging');
			}

			for(let i = result.pagination.startPage; i <= result.pagination.endPage; i++ ){
				if(i == curPage){
					$('<span/>',{text : i+"\u00A0\u00A0",style:'font-weight:bold;cursor:pointer;'}).click(function(e){
						$.confirmDone(i);
					}).appendTo('.main_paging');
				}
				else{
					$('<span/>',{text : i+"\u00A0\u00A0",}).click(function(e){
						$.confirmDone(i);
					}).appendTo('.main_paging');
				}

			}
			if(result.pagination.pageCnt == curPage){
				$('<i/>',{class:"fas fa-angle-right"}).appendTo('.main_paging');
			}
			else{
				$('<i/>',{class:"fas fa-angle-right", style:"cursor:pointer;"}).click(function(e){
					$.confirmDone(curPage+1);
				}).appendTo('.main_paging');
			}


		},
		error:function(error){
			alert("목록 불러오기 실패");
		}
	});
};

$(document).on('click','.table_click',function(){
	var id = event.target.id;

	$.ajax({
		type:"post",
		url: getContextPath() + "/moa/mypage/requestinfo",
		data:{requestId:id},
		dataType:"JSON",
		success : function(data){

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
//					str +=    '<div class="rs_size">'
//					str +=      '<div class="rs_size_title">'
//					str +=        '<h4>크기</h4>'
//					str +=      '</div>'
//					str +=      '<div class="rs_size_contents">'
//					str +=        '<h4 class="rs_box">박스기준 : 8개</h4>'
//					str +=        '<h4 class="rs_bicycle">자전거 이상 : 0개</h4>'
//					str +=        '<h4 class="rs_bed">싱글 침대 이상 : 0개</h4>'
//					str +=      '</div>'
//					str +=    '</div>'
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
//					str +='<div class="rs_button">'
//					str +=  '<div class="rs_confirm_button">'
//					str +=    '<button type="button" name="confirm_btn" id="confirm_btn">승인</button>'
//					str +=  '</div>'
//					str +=  '<div class="rs_refuse_button">'
//					str +=    '<button type="button" name="refuse_btn" id="refuse_btn">거절</button>'
//					str +=  '</div>'
//					str +='</div>'
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

//					$('.rs_confirm_button').click(function(){
//						var result = confirm('정말로 승인하시겠습니까?');
//						if(result == true){
//							alert("승인되었습니다.");
//							$('.popup').remove();
//						}
//					});
//					$('.rs_refuse_button').click(function(){
//						var result = confirm('정말로 삭제하시겠습니까?');
//						if(result == true){
//							alert("삭제되었습니다.")
//						}
//
//					});

		},
		error:function(error){
			alert("승인이 실패하였습니다.");
		}
	});

});
