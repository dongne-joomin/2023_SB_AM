<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pageTitle }</title>
<!-- 파비콘 불러오기 -->
<link rel="shortcut icon" href="/resource/images/favicon.ico" />
<!-- 테일윈드 불러오기 -->
<!-- 노말라이즈, 라이브러리 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.7/tailwind.min.css" />
<!-- 데이지 UI -->
<link href="https://cdn.jsdelivr.net/npm/daisyui@2.31.0/dist/full.css" rel="stylesheet" type="text/css" />
<!-- 제이쿼리 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!-- 폰트어썸 불러오기 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<link rel="stylesheet" href="/resource/common.css" />
<script src="/resource/common.js" defer="defer"></script>
</head>
<body>
	<div class="flex justify-end mt-2 mx-auto container text-3xl">
		<ul class="flex">
			<c:if test="${rq.getLoginedMemberId() == 0 }">
				<li class="hover:underline"><a class="h-full px-3 flex items-center text-xs" href="/usr/member/join"><span>회원가입</span></a></li>
				<li class="hover:underline"><a class="h-full px-3 flex items-center text-xs" href="/usr/member/login"><span>로그인</span></a></li>
			</c:if>
			<c:if test="${rq.getLoginedMemberId() != 0  }">
				<c:choose>
					<c:when test="${rq.getLoginedMember().authLevel != 7 }">
						<li class="hover:underline"><a class="h-full px-3 flex items-center text-xs" href="/usr/member/myPage"><span>MYPAGE</span></a></li>
					</c:when>
					<c:otherwise>
						<li class="hover:underline"><a class="h-full px-3 flex items-center text-xs" href="/adm/member/list"><span>회원관리</span></a></li>
					</c:otherwise>
				</c:choose>
				<li class="hover:underline"><a class="h-full px-3 flex items-center text-xs" href="/usr/product/register"><span>상품등록</span></a></li>
				<li class="hover:underline"><a class="h-full px-3 flex items-center text-xs" href="/usr/cart/C_list"><span>내 장바구니</span></a></li>
				<li class="hover:underline"><a class="h-full px-3 flex items-center text-xs" href="/usr/member/doLogout"><span>로그아웃</span></a></li>
			</c:if>
		</ul>
	</div>
	<div class="h-20 flex justify-end container mx-auto text-3xl">
		<a href="/" class="px-3 flex items-center"><span>로고</span></a>
		<div class="flex-grow "></div>
		<ul class="flex">
			<li class="hover:underline"><a class="h-full px-3 flex items-center" href="/"><span>HOME</span></a></li>
			<li class="hover:underline"><a class="h-full px-3 flex items-center" href="/usr/product/P_list?boardId=3"><span>중고부품</span></a></li>
			<li class="hover:underline"><a class="h-full px-3 flex items-center" href="/usr/article/list?boardId=1"><span>NOTICE</span></a></li>
			<li class="hover:underline"><a class="h-full px-3 flex items-center" href="/usr/article/list?boardId=2"><span>FREE</span></a></li>
			<li class="hover:underline"><a class="h-full px-3 flex items-center" href="/usr/home/APITest"><span>API</span></a></li>
			<li class="hover:underline"><a class="h-full px-3 flex items-center" href="/usr/home/APITest2"><span>API2</span></a></li>
		</ul>
	</div>
	<section class="my-3 text-2xl">
		<div class="container mx-auto px-3">
			<h1>${pageTitle }</h1>
		</div>
	</section>