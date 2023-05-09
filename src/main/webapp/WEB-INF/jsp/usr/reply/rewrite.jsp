<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="REPLY" />
<%@ include file="../common/head.jsp"%>
<section class="mt-8 text-xl">
	<div class="container mx-auto px-3">
		<form action="doLeply" method="POST">
			<div class="table-box-type-1">
				<table>
					<colgroup>
						<col width="200" />
					</colgroup>
					<tbody>
						<tr>
							<th>댓글</th>
							<td><textarea
									class="textarea textarea-info textarea-md w-full" name="body"
									placeholder="내용을 입력해주세요."></textarea></td>
						</tr>
						<tr>
							<td colspan="2"><button>작성</button></td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
		<div class="mt-2 btns">
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