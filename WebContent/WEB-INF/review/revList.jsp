<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<%
request.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");
%>
<!DOCTYPE html">
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>리뷰</title>
<style>

</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; text-align:center;">
	<div class="field">
		<h2 class="title is-1 is-spaced"><strong>리뷰</strong></h2>
		<table class="table is-fullwidth" style="text-align:center;">
			<thead>
				<tr><th style="text-align:center;">연번</th><th style="text-align:center;">제목</th><th style="text-align:center;">작성자</th><th style="text-align:center;">작성일</th></tr>
			</thead>
			<tbody>
				<c:forEach var="rev" items="${revList }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td><a href="${path1 }/Review.do?rnum=${rev.rnum }">${rev.rtitle }</a></td>
					<td>${rev.rauthor }</td>
					<td>
						<fmt:parseDate value="${rev.rdate }" var="rdate" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate value="${rdate }" pattern="yyyy년 MM월 dd일" />
					</td>
				</tr>
				</c:forEach>
				<c:if test="${empty revList }">
				<tr>
					<td colspan="4">해당 리뷰는 존재하지 않습니다.</td>
				</tr>
				</c:if>	
			</tbody>
		</table>
			<c:if test="${!empty sid }">
			<div class="navbar-item">
		        <div class="buttons">
					<a href="${path1 }/InsertReview.do" class="button is-light">리뷰 등록</a>
				</div>
			</div>
			</c:if>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>