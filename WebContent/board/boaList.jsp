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
.media-content {text-align:center;}
.card {clear:both; width:300px; }
.content { text-align:center; } 
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container" style="width:1280px; padding-top:30px; margin-top:30px; border-top:3px solid #333;  min-height:500px;">

		<h2 class="title is-2 is-spaced">장소 - ${cateMap.catename }</h2>
		<c:if test="${sid.equals('admin') }">			
			<div class="tabs is-centered">
			  <ul>
			    <li class="is-active">
			      <a href="${path1 }/AdminCateBoardList.do?cate=01"><span>관광명소</span></a>
			    </li>
			    <li>
			      <a href="${path1 }/AdminCateBoardList.do?cate=02"><span>숙박</span></a>
			    </li>
			    <li>
			      <a href="${path1 }/AdminCateBoardList.do?cate=03"><span>맛집</span></a>
			    </li>
			  </ul>
			</div>
		</c:if>
		<fmt:setLocale value="ko_kr" />			
		      	<ul class="card">
					<c:forEach var="boa" items="${boaList }" varStatus="status">
							<li class="card-image">
								<figure class="">
									<img src='${path1 }/board/${boa.pic1 }' alt="${boa.btitle }"/>
								</figure>
							</li><br>	
							<li class="media-content">
								<a href="${path1 }/GetBoardDetail.do?bnum=${boa.bnum}" class="title is-5"><strong>${boa.btitle }</strong></a>
							</li>
							<li class="content">			
								<p><br>${boa.bcontent }</p>
							</li>
							<li class="btn-group" style="display:block; width:300px; margin: auto 0;">
								<c:if test="${sid.equals('admin') }">
									  <footer class="card-footer">
									    <a href="${path1 }/UpdateBoard.do?bnum=${boa.bnum }" class="card-footer-item">수정</a>
									    <a href="${path1 }/DeleteBoard.do?bnum=${boa.bnum }" class="card-footer-item">삭제</a>
									  </footer>
								</c:if>
							</li>	
					</c:forEach>
				</ul>						
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
<%@ include file="../../footer.jsp" %>
</body>
</html>