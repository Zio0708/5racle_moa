var num = 1;

$(document).ready(function() {
	$("#content2").hide();
	$("#content3").hide();
	$("#content4").hide();
	$("#content5").hide();
	$("#content6").hide();
	$("#content7").hide();

	$("#end_datepicker").on("change", function() {
		var t1 = $('#start_datepicker').val().split("-");
		var t2 = $('#end_datepicker').val().split("-");
		var t1date = new Date(t1[0], t1[1], t1[2]);
		var t2date = new Date(t2[0], t2[1], t2[2]);
		var diff = t2date - t1date;
		var currDay = 24 * 60 * 60 * 1000;
		var day = parseInt(diff / currDay) + 1;

	})
});

function prevForm() {
	var elem = document.getElementById("percent");

	switch (num) {
	case 1:
		return;
	case 2:
		$("#content2").hide();
		$("#content1").show();
		$("#left_side").hide();
		elem.style.width = 0 + '%';
		$("#percent").html("0%");
		num--;
		return;
	case 3:
		$("#content2").show();
		$("#content3").hide();
		elem.style.width = 20 + '%';
		$("#percent").html("20%");
		num--;
		return;
	case 4:
		$("#content3").show();
		$("#content4").hide();
		elem.style.width = 40 + '%';
		$("#percent").html("40%");
		num--;
		return;
	case 5:
		$("#content4").show();
		$("#content5").hide();
		elem.style.width = 60 + '%';
		$("#percent").html("60%");
		num--;
		return;
	case 6:
		$("#content5").show();
		$("#content6").hide();
		$("#right_side").show();
		elem.style.width = 80 + '%';
		$("#percent").html("80%");
		num--;
		return;
	case 7:
		$("#content6").show();
		$("#content7").hide();
		num--;
		return;
	}
}

function nextForm() {

	var elem = document.getElementById("percent");

	switch (num) {
	case 1:
		$("#content1").hide();
		$("#content2").show();
		$("#left_side").show();
		elem.style.width = 20 + '%';
		$("#percent").html("20%");
		num++;
		return;
	case 2:
		$("#content2").hide();
		$("#content3").show();
		elem.style.width = 40 + '%';
		$("#percent").html("40%");
		num++;
		return;
	case 3:
		$("#content3").hide();
		$("#content4").show();
		elem.style.width = 60 + '%';
		$("#percent").html("60%");
		num++;
		return;
	case 4:
		$("#content4").hide();
		$("#content5").show();
		elem.style.width = 80 + '%';
		$("#percent").html("80%");
		num++;
		return;
	case 5:
		$("#content5").hide();
		$("#content6").show();
		$("#right_side").hide();
		elem.style.width = 100 + '%';
		$("#percent").html("100%");
		num++;
		return;
	case 6:
		$("#content6").hide();
		$("#content7").show();
		num++;
		return;
	case 7:
		$("#left_side").hide();
		$("#right_side").hide();
		return;
	}
}

function exit() {
	if (confirm("작성한 내용은 저장되지 않습니다. 정말로 나가시겠습니까?")) {
		location.href ="/main";
	}
}

function getContextPath() {
	let hostIndex = location.href.indexOf(location.host) + location.host.length;
	let contextPath = location.href.substring(hostIndex, location.href.indexOf(
			'/', hostIndex + 1));
	return contextPath;
}

function submitForm() {
	if ($("#submit_btn").prop("checked")) {
		let form = $('#regForm')[0];
		let data = new FormData(form);

		$.ajax({
			type : "POST",
			enctype : "multipart/form-data",
			url : location.pathname,
			data : data,
			processData : false,
			contentType : false,
			cache : false,
			success : function(data) {
				$("#content6").hide();
				$("#content7").show();
				$("#left_side").hide();
				$("#right_side").hide();
			},
			error : function(error) {
				console.log("에러 발생");
			}
		});
	} else {
		alert("체크박스를 체크하세요");
	}
}
