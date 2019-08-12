function popupOpen(num, readState){
    console.log("num:"+num+",readState:"+readState);
    if(readState == 0){
        $.ajax({
            url:"/mypage/message/read/"+num,
            type:"get",
            contentType:"application/json",
            dataType:"json",
            success:function(result){
                console.log(result);
                location.reload();
            },
            error:function(error){
                console.log('error to read');
            }
        });
    }
    var popUrl = "/mypage/message/receive/detail/"+num;	//팝업창에 출력될 페이지 URL
    var popupX = (window.screen.width / 2) - (500 / 2);
// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

    var popupY= (window.screen.height / 2) - (482 / 2);

// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
    var popOption = "width=500, height=482, resizable=no, " +
        "scrollbars=yes, status=no, " +
        "left="+popupX+",top="+popupY+";";    //팝업창 옵션(optoin)
    window.open(popUrl,"",popOption);


}
function sendPopup(){
    var popUrl = "/mypage/message/submit";	//팝업창에 출력될 페이지 URL
    var popupX = (window.screen.width / 2) - (500 / 2);
// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

    var popupY= (window.screen.height / 2) - (482 / 2);

// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
    var popOption = "width=500, height=482, resizable=no, " +
        "scrollbars=yes, status=no, " +
        "left="+popupX+",top="+popupY+";";    //팝업창 옵션(optoin)
    window.open(popUrl,"",popOption);

}
$(".title_select").click(function selectAll() {
    // $(".selectAll").
});
