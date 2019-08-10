
var usingStorage = function(){
//	location.href = ""
    alert("일시적으로 서비스가 중단되었습니다.");
}
var moveToInfo = function(){
//	location.href = ""
	alert("일시적으로 서비스가 중단되었습니다.");
}
var moveToMessage = function(){
//	location.href = ""
	alert("일시적으로 서비스가 중단되었습니다.");
}
var moveToTransaction = function(){
//	location.href = ""
	alert("일시적으로 서비스가 중단되었습니다.");
}
var moveToRequest = function () {
    location.href = "/mypage/requestlist/1";
}
var moveToLatest = function(){
//	location.href = ""
	alert("일시적으로 서비스가 중단되었습니다.");
}
var moveToFavorite = function(){
//	location.href = ""
	alert("일시적으로 서비스가 중단되었습니다.");
}
function getContextPath(){
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	return contextPath;
}