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
<title>장소 목록</title>
<style>
.container { width:1280px; }
.media-content {text-align:center;}
.card { width:300px; }
.content { text-align:center; } 
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="field">
		<h2 class="title is-2 is-spaced">상품 - ${cateMap.catename }</h2>
		<hr>
		<c:if test="${sid.equals('admin') }">
			<div class="btn-group">
				<a href="${path1 }/AdminCateBoardList.do?cate=01" role="button" class="button is-light">관광명소 </a>
				<a href="${path1 }/AdminCateBoardList.do?cate=02" role="button" class="button is-light">숙박 </a>
				<a href="${path1 }/AdminCateBoardList.do?cate=03" role="button" class="button is-light">맛집</a>
			</div>
			<hr>
		</c:if>
		<fmt:setLocale value="ko_kr" />
		<div class="card">
			<c:forEach var="boa" items="${boaList }" varStatus="status">
					<div class="card-image">
						<figure class="">
							<img src='${path1 }/board/${boa.pic1 }' alt="${boa.btitle }"/>
						</figure>
					</div><br>	
					<div class="media-content">
						<a href="${path1 }/GetBoardDetail.do?bnum=${boa.bnum}" class="title is-5"><strong>${boa.btitle }</strong></a>
					</div>
					<div class="content">			
						<p><br>${boa.bcontent }</p>
					</div>	
					<div class="btn-group" style="display:block; width:300px; margin: auto 0;">
						<c:if test="${sid.equals('admin') }">
							<a href="${path1 }/UpdateBoard.do?bnum=${boa.bnum }" class="button is-small" role="button">장소 수정</a>
							<a href="${path1 }/DeleteBoard.do?bnum=${boa.bnum }" class="button is-small" role="button">장소 삭제</a>
						</c:if>
					</div>
			</c:forEach>
		</div>
		<c:if test="${empty boaList }">
		<div class="container">
			<h3>해당 상품이 존재하지 않습니다.</h3>
		</div>
		</c:if>	
		<c:if test="${sid.equals('admin') }">
			<div class="btn-group" style="padding-top:30px;">
				<a href="${path1 }/InsertBoard.do" class="button is-light">장소 등록</a>
			</div>
		</c:if>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>