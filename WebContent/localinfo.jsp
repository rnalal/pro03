<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${pageContext.request.contextPath }" /> 
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>가평소개</title>
<style>
.text1 { text-align: center; padding-top:20px;}
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container is-fluid" style="padding-top:50px;">
	<div class="notification is-light">
	<h2 style="text-align:center; font-size:30px; padding-top:20px;"><strong>가평소개</strong></h2>
	<img src="./img/main/mainbg01.jpg" alt="" style="padding-top:50px;">
		<div class="text1">
		<h2 style="font-size:20px;"><strong>가평군은 경기도 동북 산간지역에 놓여 있으며,</strong></h2>
		<h3 style="font-size:20px;"><strong>홍천강이 북한강과 합류하여 서남방향으로 흐르는 고장입니다.</strong></h3><br>
		<p> 북쪽으로는 백두대간의 최고봉인 화악산이 진산(鎭山)이 되어 촛대봉, 매봉, 국망봉, 강씨봉, 명지산, 수덕산, 계관산을 거느리며, <br>
			 해발 700∼800m의 크고 작은 봉우리들을 끼고 웅장한 맥을 이루고 있다. <br>
			이러한 산들의 계곡을 따라 흐르며 이어지는 가평천과 조종천의 수많은 지류들은 모두 북한강으로 유입되어 흐른다. <br>
			남쪽으로는 중미산, 화야산, 장락산이 산맥을 이루어 용문산으로 이어지고, 서쪽으로는 주금산, 축령산 등이 끝없는 산맥을 이어 나간다. <br>
			지역의 경계를 보면 동쪽으로는 강원도 춘천시와 홍천군이 맞닿아 있고, 서쪽으로는 남양주시, 남쪽으로는 양평군과, 북쪽으로는 포천시, 화천군과 경계를 이루고 있으며, <br>
			 한반도의 가장 중앙에 위치하고 있는 서울과 춘천과의 철도, 도로 교통의 요지로서 산과 강이 어우러진 수도권 최고의 휴식처이다. <br>
			강을 안고 산으로 둘러싸인 가평군은 이미 구석기시대 이전부터 사람이 살았던 것으로 추측되는 자취를 도처에서 찾아볼 수 있다.</p>
		</div>	
		<hr>
	<h2 style="text-align:center; font-size:30px; padding-top:20px;"><strong>상징물</strong></h2><br>
	<table class="table is-fullwidth">
		<thead>
			<tr>
				<th><img src="./img/1-1/s1.jpg"></th>	
				<th><img src="./img/1-1/s2.jpg"></th>
				<th><img src="./img/1-1/s3.jpg"></th>
				<th><img src="./img/1-1/s4.jpg"></th>	
				<th><img src="./img/1-1/s5.jpg"></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td style="text-align:center;">심볼마크</td>
				<td style="text-align:center;">캐릭터</td>
				<td style="text-align:center;">가평군조 꿩</td>
				<td style="text-align:center;">가평군목 잣나무</td>
				<td style="text-align:center;">가평군목 개나리</td>
			</tr>
		</tbody>
	</table>
	<hr>
	<h2 style="text-align:center; font-size:30px; padding-top:20px;"><strong>지도</strong></h2><br>
	<div id="map" style="width:100%;height:350px;"></div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=be6fe61dae3fba660d727225252c1b7f"></script>
		<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new kakao.maps.LatLng(37.8252434270564, 127.51315994506515), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };
		
		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		</script>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>