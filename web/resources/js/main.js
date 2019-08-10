var index = 1; //이미지에 접근하는 인덱스
function slideShow() {
var i;
var b = document.getElementsByClassName("bar"); //slide1
var s1 = document.getElementById("r1");
var s2 = document.getElementById("r2");
var s3 = document.getElementById("r3");
s1.checked = false;
s2.checked = false;
s3.checked = false;

b[0].style.background = "gray";
b[1].style.background = "gray";
b[2].style.background = "gray";

if(index == 1){
  // $("#r1").prop("checked",true);
  s1.checked = true;
  b[0].style.background = "white";
}
else if (index == 2) {
  s2.checked = true;
  b[1].style.background = "white";
}
else if (index == 3) {
  s3.checked = true;
  b[2].style.background = "white";
}
index++;
if(index == 4){
  index = 1;
}
}



$(document).ready(function() {
  slideShow();
  setInterval(function(){
    slideShow();},5000);

    $("#l1").on('click',function(){
      index = 1;
        slideShow();
    });
    $("#l2").on('click',function(){
      index = 2;
        slideShow();
    });
    $("#l3").on('click',function(){
      index = 3;
        slideShow();
    });
    $(".right_paging").on('click',function(){
        slideShow();
    });

    $(".left_paging").on('click',function(){
       if(index == 3){
        index-=2;
        slideShow();
      }
      else if(index == 2){
        index = 3;
        slideShow();
      }
      else if(index == 1){
        index = 2;
        slideShow();
      }


    });
});
