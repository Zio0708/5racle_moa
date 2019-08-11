$(document).ready(function () {
    $(".cancel_btn").click(function close(){
        window.close();
    });
    $(".submit_btn").click(function () {
       if(confirm("정말로 전송하시겠습니까?")){
           if($("#receiverId").val()=="" || $("#content").val()==""){
               alert("받는 사람 혹은 내용을 입력해주세요.");
               return;
           }
           var messageData={};
           messageData["receiverNick"] = $("#receiverId").val();
           messageData["senderNick"] = $("#senderId").text();
           messageData["content"] = $("#content").val();
           $.ajax({
               url:"/mypage/message/sendmessage",
               type:"POST",
               contentType:"application/json",
               dataType:"json",
               data :JSON.stringify(messageData),
               success:function(result){
                   if(result == true){
                       alert("전송되었습니다.");
                       window.close();
                   }
                   else{
                       alert("전송에 실패하였습니다.\n받는 사람 닉네임을 다시 한번 확인해주세요.");
                   }


               },
               error:function(error){
                   alert("전송에 실패하였습니다.");
               }
           });
       }
       else{
           alert("전송이 취소되었습니다.")
       }
    });
});
