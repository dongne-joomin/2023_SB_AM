<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="상품등록" />
<%@ include file="../common/head.jsp"%>
<%@ include file="../common/toastUiEditorLib.jsp"%>
<section class="mt-8 text-xl">
	<div class="container mx-auto px-3">
		<form action="doRegister" method="POST" enctype="multipart/form-data">
			<div class="table-box-type-1">
				<table>
					<colgroup>
						<col width="200" />
					</colgroup>
					<tbody>
						<tr>
							<th>게시판</th>
							<td><label> <input type="radio" name="boardId"
									value="3" checked /> &nbsp;중고
							</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
									type="radio" name="boardId" value="4" /> &nbsp;신품
							</label></td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input class="input input-bordered input-info w-full"
								type="text" name="title" placeholder="제목을 입력해주세요." /></td>
						</tr>
						<tr>
							<th>가격</th>
							<td><input class="input input-bordered input-info w-full"
								type="text" name="price" placeholder="가격을 입력해주세요." /></td>
						</tr>
						<tr>
							<th>정보</th>
							<td><input class="input input-bordered input-info w-full"
								type="text" name="report" placeholder="상품정보를 입력해주세요." /></td>
						</tr>
						<tr>
							<th>수량</th>
							<td><input class="input input-bordered input-info w-full"
								type="text" name="count" placeholder="수량정보를 입력해주세요." /></td>
						</tr>
						
						<tr>
							<th>이미지</th>
							<td>
								<div>		
									<input type="file" name="file" />
								</div>
						</tr>
						<tr>
							<td colspan="2"><button>작성</button></td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
		<div class="btns">
			<button class="btn btn-active btn-ghost" type="button"
				onclick="history.back();">뒤로가기</button>
		</div>
	</div>
</section>

<%@ include file="../common/foot.jsp"%>