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
<title>질문 및 답변 목록</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="field">
		<h2 class="title is-1 is-spaced">질문 및 답변</h2>
		<table class="table is-fullwidth">
			<thead>
				<tr><th>연번</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
			</thead>
			<tbody>
				<c:set var="cnt" value="0" />
				<c:forEach var="qna" items="${qnaList }" varStatus="status">
				<tr>
					<c:if test="${qna.lev==1 }">
					<c:set var="cnt" value="${cnt=cnt+1 }" />
					<td>${cnt }</td>
					<td>
						<a href="${path1 }/GetQna.do?qnum=${qna.qnum }">${qna.qtitle }</a>
					</td>
					</c:if>
					<c:if test="${qna.lev==2 }">
					<td colspan="2">
						<a href="${path1 }/GetReply.do?qnum=${qna.qnum }" style="padding-left:160px">${qna.qtitle }</a>
					</td>
					</c:if>
					<td>${qna.qauthor }</td>
					<td>
						<fmt:parseDate value="${qna.qdate }" var="qdate" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate value="${qdate }" pattern="yyyy년 MM월 dd일" />
					</td>
				</tr>
				</c:forEach>
				<c:if test="${empty qnaList }">
				<tr>
					<td colspan="4">질문 및 답변이 존재하지 않습니다.</td>
				</tr>
				</c:if>	
			</tbody>
		</table>
		<c:if test="${!empty sid }">
		<div class="btn-group">
			<a href="${path1 }/AddQna.do" class="button is-light">질문하기</a>
		</div>
		</c:if>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>