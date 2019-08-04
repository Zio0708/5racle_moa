$(document).ready(function() {
  $(".sidehide").on('click',function(){
    $('.doc').toggleClass("show")
    $('.doc').toggleClass("blur")
  });
  $(".hide").on('click',function(){
    $('.doc').toggleClass("show")
    $('.doc').toggleClass("blur")
  });
  $(".logo_img").on('click',function(){
	  location.href=getContextPath() + "/moa/main";
	  });

  
  function getContextPath(){
	   var hostIndex = location.href.indexOf(location.host) + location.host.length;
	   var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	   return contextPath;
	}
  
  
 // $.loginInfo();
});
/*
$.loginInfo = function(){
	$.get('/TestLogin.do', function(data, status, jqXHR){
		console.log(data);
		if(status == 'success'){
			var datas = JSON.parse(data);
            $('.author_name', { text : datas.userId });// id
            $('.author_name span', { text : datas.email });// email
		}else {
	          alert('서버와의 통신에 실패하였습니다.');
		 }
	});
};*/