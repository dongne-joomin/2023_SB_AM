<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="P_detail" />
<%@ include file="../common/head.jsp"%>
<%@ include file="../common/toastUiEditorLib.jsp"%>

<section class="mt-8 text-xl">
	<div class="container mx-auto px-3 pb-5 border-bottom-line">
		<div class="table-box-type-1 overflow-x-auto w-full">
			<table class="table table-zebra w-full">
				<colgroup>
					<col width="200" />
				</colgroup>
				<tbody>
					<tr class="active ">
						<th>번호</th>
						<td>${product.id }</td>
					</tr>
					<tr>
						<th>작성날짜</th>
						<td>${product.regDate }</td>
					</tr>
					<tr class="active">
						<th>수정날짜</th>
						<td>${product.updateDate }</td>
					</tr>
					<tr class="active">
						<th>작성자</th>
						<td>${product.writerName }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${product.title }</td>
					</tr>
					<tr>
						<th>이미지</th>
						<td><img src="/usr/product/file/${product.id}" width="100" height="100" /></td>
					</tr>
					<tr class="active">
						<th>내용</th>
						<td>
							<div class="toast-ui-viewer">
								<script type="text/x-template">${product.report }</script>
							</div>
						</td>	
					</tr>
					<tr>
						<th>가격</th>
						<td>${product.price }</td>
					</tr>
					<tr>
						<th>수량</th>
						<td>${product.count }</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="btns mt-2 flex justify-between ">
			<div class=""><button class="btn-text-link btn btn-active" type="button"
				onclick="history.back();">뒤로가기</button></div>
			<div><a class="btn-text-link btn btn-active"
					href="../cart/doAdd?id=${cart.id }"
					onclick="if(confirm('정말 추가하시겠습니까?') == false) return false;">장바구니 담기</a>
			<a class="btn-text-link btn btn-active" href="">주문하기</a></div>
		</div>
	</div>
</section>

<%@ include file="../common/foot.jsp"%>