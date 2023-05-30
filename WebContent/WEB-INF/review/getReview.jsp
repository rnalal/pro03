<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
request.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");
%>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html">
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>리뷰 상세보기</title>
<style>

</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="field" style="text-align:center;">
		<h2 class="title is-1 is-spaced"><strong>리뷰 상세보기</strong></h2>
		<table class="table is-fullwidth">
			<tbody>
				<tr>
					<th>리뷰 번호</th>
					<td>${rev.rnum }</td>
				</tr>
				<tr>
					<th>사진</th>
					<td colspan="2">
						<div class="pi">
							<img src='${path1 }/image/${rev.file1 }' alt="${rev.rtitle }" />
						</div>
					</td>
				</tr>	
				<tr>
					<th>제목</th>
					<td>${rev.rtitle }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${rev.rcontent }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${rev.rauthor }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>
						<fmt:parseDate value="${rev.rdate }" var="rdate" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate value="${rdate }" pattern="yyyy년 MM월 dd일" />
					</td>
				</tr>
				<c:if test="${!empty rev.file1 }">
				<tr>
					<th>첨부 파일</th>
					<td>
						<c:set var="lh" value="${fn:length(rev.file1) }" />
						<c:set var="download" value="${fn:substring(rev.file1,5,lh) }" />
						<a href="${path1 }/${filepath1 }/${file1 }" download>${download }</a>
					</td>
				</tr>
				</c:if>
			</tbody>
		</table>
		<div class="btn-group">
			<a href="${path1 }/ReviewList.do" class="button is-light">글 목록</a>
			<a href="${path1 }/InsertReview.do" class="button is-light">글 등록</a>
			<a href="${path1 }/UpdateReview.do?rnum=${rev.rnum }" class="button is-light">글 수정</a>
			<a href="${path1 }/DelReview.do?rnum=${rev.rnum }" class="button is-light">글 삭제</a>
		</div>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>