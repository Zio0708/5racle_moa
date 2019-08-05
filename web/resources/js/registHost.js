$(document).ready(function(){
  $('input[type=radio][name=storage_type_answer]').on('click', function(){
    var chkValue = $('input[type=radio][name=storage_type_answer]:checked').val();
    if(chkValue == 'home'){
      $('#other_text').attr('disabled', true);
      $('#other_text').val('');
      $('.company_info').hide();

    }
    else if(chkValue == 'store' || chkValue == 'company'){
      $('#other_text').attr('disabled', true);
      $('#other_text').val('');
      $('.company_info').show();
    }
    else{
      $('.company_info').hide();
      $('#other_text').attr('disabled', false);
    }
  });

  $('input[type=radio][name=origin_or_new]').on('click', function(){
    var chkValue = $('input[type=radio][name=origin_or_new]:checked').val();

    if(chkValue == 'origin'){
      $('.search_address_btn').hide();
      $('.address_combo').show();
    }
    else{
      $('.address_combo').hide();
      $('.search_address_btn').show();
    }
  });
});

var execDaumPostcode = function() {
	var width = 500;
	var height = 600;

    new daum.Postcode({
    	width: width,
    	height: height,
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddress").focus();
        }
    }).open({
    	left: (window.screen.width / 2) - (width / 2),
    	top: (window.screen.height / 2) - (height / 2)
    });
    
  
}
var submit = function(){
	let storage_type = $('input[name=storage_type_answer]:checked').val();
	let other_text = $('#other_text').val();
	let origin_or_new = $('input[name=origin_or_new]:checked').val();
	let address_id = $('select[name=address_combo]').val();
	let postcode = $('#postcode').val();
	let address = $('#address').val();
	let detailAddress = $('#detailAddress').val();
	let company_name = $('#company_name').val();
	let company_registration_name = $('#company_registration_name').val();
	let company_representative_name = $('#company_representative_name').val();
	
	$.ajax({
		type:"POST",
		url: getContextPath() + "/moa/submithostform",
		data: {
			storage_type : storage_type,
			other_text : other_text, 
			origin_or_new : origin_or_new,
			address_id : address_id,
			postcode : postcode,
			address : address,
			detailAddress : detailAddress,
			company_name : company_name,
			company_registration_name : company_registration_name,
			company_representative_name : company_representative_name
		},
		dataType: "JSON",
		success : function(data){
			if(data.result == "true"){
				alert("호스트 신청이 성공적으로 완료되었습니다.");
				location.href = getContextPath() + "/moa/main"
			}
			else{
				alert("호스트 신청이 실패하였습니다.")
			}
		},
		error: function(e){
			alert("error!");
		}
	});
	
	
//	$('.form').submit();
//	alert('신청이 완료되었습니다.');
}
function getContextPath(){
	   var hostIndex = location.href.indexOf(location.host) + location.host.length;
	   var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	   return contextPath;
	}
