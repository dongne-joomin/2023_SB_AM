<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="MYPGAE" />
<%@ include file="../common/head.jsp"%>

<section class="mt-8 text-xl">
	<div class="container mx-auto px-3 pb-5 border-bottom-line">
		<div class="table-box-type-1 overflow-x-auto w-full">
			<table class="table table-zebra w-full">
				<colgroup>
					<col width="200" />
				</colgroup>
				<tbody>
					<tr class="active ">
						<th>가입일</th>
						<td>${rq.loginedMember.regDate }</td>
					</tr>
					<tr>
						<th>로그인아이디</th>
						<td>${rq.loginedMember.loginId }</td>
					</tr>
					<tr class="active">
						<th>닉네임</th>
						<td>${rq.loginedMember.nickname }</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${rq.loginedMember.cellphoneNum }</td>
					</tr>
					<tr class="active">
						<th>이메일</th>
						<td>${rq.loginedMember.email }</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="btns mt-2 flex justify-between">
			<button class="btn-text-link btn btn-active" type="button"
				onclick="history.back();">뒤로가기</button>
			<a class="btn-text-link btn btn-active "
				href="checkPassword">수정</a>
		</div>
	</div>
</section>

<%@ include file="../common/foot.jsp"%>