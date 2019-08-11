var num = 1;

$(document).ready(function () {
    $("#content2").hide();
    $("#content3").hide();
    $("#content4").hide();
    $("#content5").hide();
    $("#content6").hide();
    $("#content7").hide();

    $("#end_datepicker").on("change", function () {
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
            $("#percent").html("&nbsp;&nbsp;&nbsp;0%");
            num--;
            return;
        case 3:
            $("#content2").show();
            $("#content3").hide();
            elem.style.width = 20 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;20%");
            num--;
            return;
        case 4:
            $("#content3").show();
            $("#content4").hide();
            elem.style.width = 40 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;40%");
            num--;
            return;
        case 5:
            $("#content4").show();
            $("#content5").hide();
            elem.style.width = 60 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;60%");
            num--;
            return;
        case 6:
            $("#content5").show();
            $("#content6").hide();
            $("#right_side").show();
            elem.style.width = 80 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;80%");
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
            let productName = document.getElementsByName("product_name");
            let productCnt = document.getElementsByName("product_cnt");
            if (productName[0].value == null || productName[0].value.trim() == "") {
                alert("물건명을 최소 하나 이상 입력해주세요.");
                productName[0].value = "";
                productName[0].focus();
                return;
            }
            if (productCnt[0].value == 0) {
                alert("물건 개수는 최소 1개 이상이어야 합니다.");
                return;
            }
            for (i = productName.length - 1; i > 0; i--) {
                if (productName[i].value == null || productName[i].value.trim() == "" || productCnt[i].value == 0)
                    productName[i].closest("tr").remove();
            }
            $("#content1").hide();
            $("#content2").show();
            $("#left_side").show();
            elem.style.width = 20 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;20%");
            num++;
            return;
        case 2:
            let size = document.getElementsByClassName("sizeCnt");
            for (i = 0; i < size.length; i++) {
                if (size[i].value != 0)
                    break;
            }
            if (i == size.length) {
                alert("크기를 하나 이상 입력해주세요.");
                return;
            }
            $("#content2").hide();
            $("#content3").show();
            elem.style.width = 40 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;40%");
            num++;
            return;
        case 3:
            let startDate = document.getElementById("start_datepicker");
            let endDate = document.getElementById("end_datepicker");
            if (startDate.value == "" || endDate.value == "") {
                alert("맡길 기간을 입력해주세요");
                return;
            }
            $("#content3").hide();
            $("#content4").show();
            elem.style.width = 60 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;60%");
            num++;
            return;
        case 4:
            let checkValid = document.getElementsByName("trade_type_answer");
            for (i = 0; i < checkValid.length; i++) {
                if (checkValid[i].checked == true)
                    break;
            }
            if (i == checkValid.length) {
                alert("원하는 거래 방식을 선택해주세요.");
                return;
            }
            if ($('#post_contents').val() == null || $('#post_contents').val().trim() == "") {
                $('#post_contents').focus();
                alert("내용을 입력해주세요.");
                return;
            }
            $("#content4").hide();
            $("#content5").show();
            elem.style.width = 80 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;80%");
            num++;
            return;
        case 5:
            if (($('#photo_main1').val() == "" || $('#photo_main2').val() == "")) {
                alert("보관할 물품 사진을 최소 2장 이상 추가해야 합니다.");
                return;
            }
            $("#content5").hide();
            $("#content6").show();
            $("#right_side").hide();
            elem.style.width = 100 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;100%");
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
        $('#regForm')[0].reset();
        location.href = "/moa/main";
    }
}

function finished() {
    $('#regForm')[0].reset();
    location.href = "/moa/main";
}

function submitForm() {
    if ($("#submit_btn").prop("checked")) {
        var form = $('#regForm')[0];
        let data = new FormData(form);

        $.ajax({
            type: "POST",
            enctype: "multipart/form-data",
            url: location.pathname,
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            success: function () {
                $("#content6").hide();
                $("#content7").show();
                $("#left_side").hide();
                $("#right_side").hide();
            },
            error: function () {
                console.log("에러 발생");
            }
        });
    } else {
        alert("체크박스를 체크하세요");
    }
}