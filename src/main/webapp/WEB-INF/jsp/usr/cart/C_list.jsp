<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="${board.name } 게시판" />
<%@ include file="../common/head.jsp"%>
<section class="mt-8 text-xl">
	<div class="container mx-auto px-3 overflow-x-auto">
		<c:forEach var="product" items="${products }">
			<div>	
				<h2>${product.title}</h2>
				<a href="P_detail?id=${product.id }"><img src="/usr/product/file/${product.id}" width="100"
					height="100" /></a>
				<h2>${product.price}</h2>			
			</div>
		</c:forEach>
	</div>
</section>
<%@ include file="../common/foot.jsp"%>