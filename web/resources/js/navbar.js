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
	  location.href="/main";
	  });

  
  function getContextPath(){
	   var hostIndex = location.href.indexOf(location.host) + location.host.length;
	   var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	   return contextPath;
	}
  

});
