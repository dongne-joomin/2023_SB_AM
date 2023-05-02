<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Detail" />
<%@ include file="../common/head.jsp"%>

<script>
	const params = {};
	params.id = parseInt('${param.id}');

	function ArticleDetail_increaseHitCount() {
		$.get('doIncreaseHitCount', {
			id : params.id
		}, function(data) {
			console.log(data.data1);
			$('#articleDetail_increaseHitCount').empty().html(data.data1);
		}, 'json')
	}

	$(function() {
		//실전코드
		// 		ArticleDetail_increaseHitCount();

		//테스트코드
		setTimeout(ArticleDetail_increaseHitCount, 2000);
	})
</script>

<section class="mt-8 text-xl">
	<div class="container mx-auto px-3">
		<div class="table-box-type-1 overflow-x-auto w-full">
			<table class="table table-zebra w-full">
				<colgroup>
					<col width="200" />
				</colgroup>
				<tbody>
					<tr class="active">
						<th>번호</th>
						<td>${article.id }</td>
					</tr>
					<tr>
						<th>작성날짜</th>
						<td>${article.regDate }</td>
					</tr>
					<tr class="active">
						<th>수정날짜</th>
						<td>${article.updateDate }</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td><span id="articleDetail_increaseHitCount">${article.hitCount }</span></td>
					</tr>
					<tr class="active">
						<th>작성자</th>
						<td>${article.writerName }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${article.title }</td>
					</tr>
					<tr class="active">
						<th>내용</th>
						<td>${article.body }</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="btns">
			<button class="btn btn-active btn-ghost" type="button"
				onclick="history.back();">뒤로가기</button>
			<c:if test="${article.actorCanChangeData }">
				<a class="btn btn-active btn-ghost" href="modify?id=${article.id }">수정</a>
				<a class="btn btn-active btn-ghost"
					href="doDelete?id=${article.id }"
					onclick="if(confirm('정말 삭제하시겠습니까?') == false) return false;">삭제</a>
			</c:if>
		</div>
	</div>
</section>
<%@ include file="../common/foot.jsp"%>