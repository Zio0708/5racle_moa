var num = 0;

$(document).ready(function () {
    $("input:radio[name=pet_radio]").click(function () {
        if ($("input[name=pet_radio]:checked").val() == "1") {
            $("#pet_text").attr("disabled", false);
        } else {
            $("#pet_text").attr("disabled", true);
        }
    });
});

function prevForm() {
    var elem = document.getElementById("percent");
    switch (num) {
        case 0:
            return;
        case 1:
            $("#content1").hide();
            $("#content0").show();
            $("#left_side").hide();
            elem.style.width = 0 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;0%");
            num--;
            return;
        case 2:
            $("#content2").hide();
            $("#content1").show();
            elem.style.width = 10 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;10%");
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
    let i;
    switch (num) {
        case 0:
            if($("#storage_address option:selected").val() == 0) {
                alert("보관 장소를 선택해주세요.");
                return;
            }
            $("#content0").hide();
            $("#content1").show();
            $("#left_side").show();
            elem.style.width = 10 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;10%");
            num++;
            return;
        case 1:
            if (!isValid("trade_type_answer"))
                return;
            if (!isValid("pet_radio"))
                return;
            if (!isValid('cctv_answer'))
                return;
            $("#content1").hide();
            $("#content2").show();
            elem.style.width = 20 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;20%");
            num++;
            return;
        case 2:
            let productName = document.getElementsByName("product_name");
            if (productName[0].value == null || productName[0].value.trim() == "") {
                alert("물건명을 최소 하나 이상 입력해주세요.");
                productName[0].value = "";
                productName[0].focus();
                return;
            }
            for (i = productName.length - 1; i > 0; i--) {
                if (productName[i].value == null || productName[i].value.trim() == "")
                    productName[i].closest("tr").remove();
            }
            $("#content2").hide();
            $("#content3").show();
            elem.style.width = 40 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;40%");
            num++;
            return;
        case 3:
            if (!isValid("time_answer"))
                return;
            if (!isPriceValid())
                return;
            $("#content3").hide();
            $("#content4").show();
            elem.style.width = 60 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;60%");
            num++;
            return;
        case 4:
            if (!isPhotoValid())
                return;
            $("#content4").hide();
            $("#content5").show();
            elem.style.width = 80 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;80%");
            num++;
            return;
        case 5:
            if ($('#post_title').val() == null || $('#post_title').val().trim() == "") {
                $('#post_title').val("");
                $('#post_title').focus();
                alert("제목을 입력해주세요.");
                return;
            }
            if ($('#post_contents').val() == null || $('#post_contents').val().trim() == "") {
                $('#post_contents').val("");
                $('#post_contents').focus();
                alert("내용을 입력해주세요.");
                return;
            }
            $("#right_side").hide();
            $("#content5").hide();
            $("#content6").show();
            elem.style.width = 100 + '%';
            $("#percent").html("&nbsp;&nbsp;&nbsp;100%");
            num++;
            return;
        case 6:
            $("#content6").hide();
            $("#content7").show();
            num++;
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
    if ($("#submit_check").prop("checked")) {
        var form = $('#regForm')[0];
        let data = new FormData(form);

        $.ajax({
            type: "POST",
            enctype: "multipart/form-data",
            url: "/storeboard/keepregister",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            success: function () {
                $("#left_side").hide();
                $("#content6").hide();
                $("#content7").show();
            },
            error: function () {
                console.log("에러 발생");
            }
        });
    } else {
        alert("체크박스를 체크하세요");
    }
}

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
        let reader = new FileReader();
        reader.onload = function (e) {
            $('#etc_1').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}

function readURL4(input) {
    if (input.files && input.files[0]) {
        let reader = new FileReader();
        reader.onload = function (e) {
            $('#etc_2').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}

function readURL5(input) {
    if (input.files && input.files[0]) {
        let reader = new FileReader();
        reader.onload = function (e) {
            $('#etc_3').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}

function isValid(input) {
    let i;
    let checkValid = document.getElementsByName(input);
    for (i = 0; i < checkValid.length; i++) {
        if (checkValid[i].checked == true)
            break;
    }
    if (i == checkValid.length) {
        switch (input) {
            case "trade_type_answer":
                alert("선호 거래 방식을 선택해주세요.");
                return false;
            case "pet_radio":
                alert("반려 동물 정보를 입력해주세요.");
                return false;
            case "cctv_answer":
                alert("CCTV 여부를 선택해주세요.");
                return false;
            case "time_answer":
                alert("보관 기간을 선택해주세요.");
                return false;
            default:
                alert("아무것도 해당되지 않음.");
        }
    }
    if ($("input[name=pet_radio]:checked").val() == "1") {
        if ($('#pet_text').val() == null || $('#pet_text').val().trim() == "") {
            alert("반려 동물의 종류를 입력해주세요.");
            $('#pet_text').val('');
            $('#pet_text').focus();
            return false;
        }
    }
    return true;
}

$(document).ready(function () {
    $("input:text[numberOnly]").on("focus", function () {
        // $(".i_price").on("focus", function () {
        var x = $(this).val();
        x = removeCommas(x);
        $(this).val(x);
    }).on("focusout", function () {
        var x = $(this).val();
        if (x && x.length > 0) {
            if (!$.isNumeric(x)) {
                x = x.replace(/[^0-9]/g, "");
            }
            x = addCommas(x);
            $(this).val(x);
        }
    }).on("keyup", function () {
        $(this).val($(this).val().replace(/[^0-9]/g, ""));
    });
})

function addCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function removeCommas(x) {
    if (!x || x.length == 0) return "";
    else return x.split(",").join("");
}

function isPriceValid() {
    let i;
    let checkValid = document.getElementsByName("price");
    for (i = 0; i < checkValid.length; i++) {
        if (checkValid[i].value == null || checkValid[i].value.trim() == "") {
            alert("보관 가격을 입력해주세요.");
            checkValid[i].focus();
            return false;
        }
    }
    return true;
}

function isPhotoValid() {
    if (($('#photo_main1').val() == "" || $('#photo_main2').val() == "")) {
        alert("공간 사진을 최소 2장 이상 추가해야 합니다.");
        return false;
    }
    return true;
}
