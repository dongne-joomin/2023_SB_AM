<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="APITest2" />
<%@ include file="../common/head.jsp"%>
<div class="container mx-auto">
	<div id="map" style="width: 500px; height: 400px;"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1d20b05e8a28395eb3551beab5c223dd"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		// 지도 레벨을 표시합니다
		displayLevel();

		// 지도 레벨은 지도의 확대 수준을 의미합니다
		// 지도 레벨은 1부터 14레벨이 있으며 숫자가 작을수록 지도 확대 수준이 높습니다
		function zoomIn() {
			// 현재 지도의 레벨을 얻어옵니다
			var level = map.getLevel();

			// 지도를 1레벨 내립니다 (지도가 확대됩니다)
			map.setLevel(level - 1);

			// 지도 레벨을 표시합니다
			displayLevel();
		}

		function zoomOut() {
			// 현재 지도의 레벨을 얻어옵니다
			var level = map.getLevel();

			// 지도를 1레벨 올립니다 (지도가 축소됩니다)
			map.setLevel(level + 1);

			// 지도 레벨을 표시합니다
			displayLevel();
		}

		function displayLevel() {
			var levelEl = document.getElementById('maplevel');
			levelEl.innerHTML = '현재 지도 레벨은 ' + map.getLevel() + ' 레벨 입니다.';
		}
	</script>
</div>
