
$(document).ready(function() {
	 var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(33.450701, 126.570667),
		level: 3
	}
	if (navigator.geolocation) {
	    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	         lat = position.coords.latitude; // 위도
	         lon = position.coords.longitude; // 경도
	        
	        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
	        // 마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition, message);
	            
	});
	}else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
		var lat = 33.450701;
        var lon = 126.570667;
	    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
	        message = 'geolocation을 사용할수 없어요..'
	        
	    displayMarker(locPosition, message);
	}
	function displayMarker(locPosition, message) {
		
	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({  
	        map: map, 
	        position: locPosition
	    });   
	    var iwContent = message, // 인포윈도우에 표시할 내용
	        iwRemoveable = true;
	    // 인포윈도우를 생성합니다
	    var infowindow = new kakao.maps.InfoWindow({
	        content : iwContent,
	        removable : iwRemoveable
	    });
	    // 인포윈도우를 마커위에 표시합니다 
	    infowindow.open(map, marker);  
	    // 지도 중심좌표를 접속위치로 변경합니다
	    map.setCenter(locPosition);          
	}    
	search(37.484224, 126.955759);
	//요주의!!!!!!!
	
	    
	map = new kakao.maps.Map(container, options);
	var mapTypeControl = new kakao.maps.MapTypeControl();
	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
	var zoomControl = new kakao.maps.ZoomControl();
	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT); 
	$('.room_select').click(function(){alert("이동한다");});
	$('.search_btn').click(function() 
	{
		let address=$(".search_input").val();
		$.ajax
		({
		    url: "https://dapi.kakao.com/v2/local/search/keyword.json?query="+address,
		    headers: { 'Authorization': 'KakaoAK ea031870cc4a7a31182ea665a1eb62fc'},
		    type: 'GET'
		}).done(function(data)
			{
				if(data.documents.length == 0)
				{
				alert("검색된 정보가 없습니다");
				}
				else
				{
			    var lan=data.documents[0].y;
			    var log=data.documents[0].x;
			    /*var container = document.getElementById('map');
				var options = {
					center: new kakao.maps.LatLng(lan, log),
					level: 3
				};
				var map = new kakao.maps.Map(container, options);*/
			    
				var coords = new kakao.maps.LatLng(lan, log);
				var marker = new kakao.maps.Marker
				({
	            map: map,
	            position: coords
	       		 });
				}
				map.setCenter(coords);
				search(lan,log);
				
			});	
	});
	function search(lan,log){
		 $('#selection_content_id1').empty();
		 $('#selection_content_id2').empty();
		 //요주의!!!!
		 $.ajax("Search",{
		type:"POST",
		data :
		{
			category:($("#category").val()),
			distance:($("#distance").val()),
			filter:($("#filter").val()),
			storageType:($("#storageType").val()),
			transactionType : ($("#transactionType").val()),
			storagePeriodType:($("#storagePeriodType").val()),
			securityFacility:($("#securityFacility").val()),
			petFlag:($("#petFlag").val()),
	        lan:lan,
	        log:log
	}}).then(function(data,status){
		if(status=="success"){
			var positions = new Array();
			 if(data.documents.length>4){
				console.log(data.documents);
				console.log(data.documents[0].articleNum);
				console.log(data.documents[0].distanceResult);
			} 
			 else{
				console.log(data.documents[0].articleNum);
			 }
			 for(let i=0;i<data.documents.length;i++){
				let div = $('<div />', {id:"article"+data.documents[i].articleNum,class : 'room_select'}).appendTo($('#selection_content_id1'));
				$('<img/>',{src:"${pageContext.request}/image/hostSearch/"+data.documents[i].pictureName}).appendTo(div);
				$('<span/>',{id:'title',text:"보관지 : "+data.documents[i].storageType+"        "}).appendTo(div);
				$('<i/>',{class:'fas fa-star',style:'font-size:15px;'}).appendTo(div);
				$('<span/>',{text:" : "+data.documents[i].starPointAvg+" 개"}).appendTo(div);
				$('<br>').appendTo(div);
				$('<i/>',{class:'fas fa-coins',style:'color:#423257;'}).appendTo(div);
				$('<span/>',{id:'title',text:" "+data.documents[i].detailPrice+"원"}).appendTo(div);
				$('</div>').appendTo(div);
				$('<div>',{id:'word'}).appendTo(div);
				$('<span/>',{text:data.documents[i].distanceResult+"km 이내 "}).appendTo(div);
				$('<br>').appendTo(div);
				$('<i/>',{class:'fas fa-thumbs-up',style:'color: #423257;'}).appendTo(div);
				$('<span/>',{text:" "+data.documents[i].totReviewCnt+" 개 "}).appendTo(div);
				
				$('<i/>',{class:'far fa-calendar-alt',style:'color: #423257;'}).appendTo(div);
				$('<span/>',{text:" "+data.documents[i].storagePeriodTypeId}).appendTo(div);
				$('<br>').appendTo(div);
				$('<i/>',{class:'fas fa-user',style:'color: #423257;'}).appendTo(div);
				$('<span/>',{text:" "+data.documents[i].nickName}).appendTo(div);
				positions[i] ={ title:'카카오',latlng: new kakao.maps.LatLng(data.documents[i].latitude,data.documents[i].longitude) }
			}
			var positions2 = [
			    {
			        title:'카카오',latlng: new kakao.maps.LatLng(33.450705, 126.570677)
			    },
			    {
			        title: '생태연못',latlng: new kakao.maps.LatLng(33.450936, 126.569477)
			    },
			    {
			        title: '텃밭', latlng: new kakao.maps.LatLng(33.450879, 126.569940)
			    },
			    {
			        title: '렉토피아',latlng: new kakao.maps.LatLng(37.484772 , 126.955537)
			    }
			];
			// 마커 이미지의 이미지 주소입니다
			var imageSrc = "http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
			for (var i = 0; i < positions.length; i ++) {
			    // 마커 이미지의 이미지 크기 입니다
			    var imageSize = new kakao.maps.Size(24, 35);  
			    // 마커 이미지를 생성합니다    
			    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
			    // 마커를 생성합니다
			    var marker = new kakao.maps.Marker({
			        map: map, // 마커를 표시할 지도
			        position: positions[i].latlng, // 마커를 표시할 위치
			        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
			        image : markerImage // 마커 이미지 
			    });
			}
			 
			 
			 
			 
		}
	});
	}
	
});
window.onload = function(){
	
	  crear_select();
	}

	var li = new Array();
	function crear_select(){
	var div_cont_select = document.querySelectorAll("[data-mate-select='active']");
	var select_ = '';
	for (var e = 0; e < div_cont_select.length; e++) {
	div_cont_select[e].setAttribute('data-indx-select',e);
	div_cont_select[e].setAttribute('data-selec-open','false');
	var ul_cont = document.querySelectorAll("[data-indx-select='"+e+"'] > .cont_list_select_mate > ul");
	 select_ = document.querySelectorAll("[data-indx-select='"+e+"'] >select")[0];
	
	 
	var select_optiones = select_.options;
	document.querySelectorAll("[data-indx-select='"+e+"']  > .selecionado_opcion ")[0].setAttribute('data-n-select',e);
	document.querySelectorAll("[data-indx-select='"+e+"']  > .icon_select_mate ")[0].setAttribute('data-n-select',e);
	for (var i = 0; i < select_optiones.length; i++) {
	li[i] = document.createElement('li');
	if (select_optiones[i].selected == true || select_.value == select_optiones[i].innerHTML ) {
	li[i].className = 'active';
	document.querySelector("[data-indx-select='"+e+"']  > .selecionado_opcion ").innerHTML = select_optiones[i].innerHTML;
	};
	li[i].setAttribute('data-index',i);
	li[i].setAttribute('data-selec-index',e);
	// funcion click al selecionar 
	li[i].addEventListener( 'click', function(){  _select_option(this.getAttribute('data-index'),this.getAttribute('data-selec-index')); });
	li[i].innerHTML = select_optiones[i].innerHTML;
	ul_cont[0].appendChild(li[i]);

	    }; // Fin For select_optiones
	  }; // fin for divs_cont_select
	} // Fin Function 


	//검색조건
	var cont_slc = 0;
	function open_select(idx){
	var idx1 =  idx.getAttribute('data-n-select');
	  var ul_cont_li = document.querySelectorAll("[data-indx-select='"+idx1+"'] .cont_select_int > li");
	var hg = 0;
	var slect_open = document.querySelectorAll("[data-indx-select='"+idx1+"']")[0].getAttribute('data-selec-open');
	var slect_element_open = document.querySelectorAll("[data-indx-select='"+idx1+"'] select")[0];
	 if (false) { 
	  if (window.document.createEvent) { // All
	  var evt = window.document.createEvent("MouseEvents");
	  evt.initMouseEvent("mousedown", false, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
		slect_element_open.dispatchEvent(evt);
	}
	else if (slect_element_open.fireEvent) { // IE
	  slect_element_open.fireEvent("onmousedown");
	}else {
	  slect_element_open.click();
	}
	}
	else{

	  
	  for (var i = 0; i < ul_cont_li.length; i++) {
	hg += ul_cont_li[i].offsetHeight;
	}; 
	 if (slect_open == 'false') {  
	 document.querySelectorAll("[data-indx-select='"+idx1+"']")[0].setAttribute('data-selec-open','true');
	 document.querySelectorAll("[data-indx-select='"+idx1+"'] > .cont_list_select_mate > ul")[0].style.height = hg+"px";
	 document.querySelectorAll("[data-indx-select='"+idx1+"'] > .icon_select_mate")[0].style.transform = 'rotate(180deg)';
	}else{
	 document.querySelectorAll("[data-indx-select='"+idx1+"']")[0].setAttribute('data-selec-open','false');
	 document.querySelectorAll("[data-indx-select='"+idx1+"'] > .icon_select_mate")[0].style.transform = 'rotate(0deg)';
	 document.querySelectorAll("[data-indx-select='"+idx1+"'] > .cont_list_select_mate > ul")[0].style.height = "0px";
	 }
	}

	} // fin function open_select

	function salir_select(indx){
	var select_ = document.querySelectorAll("[data-indx-select='"+indx+"'] > select")[0];
	 document.querySelectorAll("[data-indx-select='"+indx+"'] > .cont_list_select_mate > ul")[0].style.height = "0px";
	document.querySelector("[data-indx-select='"+indx+"'] > .icon_select_mate").style.transform = 'rotate(0deg)';
	 document.querySelectorAll("[data-indx-select='"+indx+"']")[0].setAttribute('data-selec-open','false');
	}


	function _select_option(indx,selc){
	/*  if (isMobileDevice()) { 
	selc = selc -1;
	} */
	    var select_ = document.querySelectorAll("[data-indx-select='"+selc+"'] > select")[0];

	  var li_s = document.querySelectorAll("[data-indx-select='"+selc+"'] .cont_select_int > li");
	  var p_act = document.querySelectorAll("[data-indx-select='"+selc+"'] > .selecionado_opcion")[0].innerHTML = li_s[indx].innerHTML;
	var select_optiones = document.querySelectorAll("[data-indx-select='"+selc+"'] > select > option");
	for (var i = 0; i < li_s.length; i++) {
	if (li_s[i].className == 'active') {
	li_s[i].className = '';
	};
	li_s[indx].className = 'active';

	};
	select_optiones[indx].selected = true;
	  select_.selectedIndex = indx;
	  select_.onchange();
	  salir_select(selc); 
	}

	$(document).on("click",".guideBox > p",function(){
	      if($(this).next().css("display")=="none"){
	        $(this).next().show();
	        $(this).children("span").text("[닫기]");
	      }else{
	        $(this).next().hide();
	        $(this).children("span").text("[열기]");
	      }
	});