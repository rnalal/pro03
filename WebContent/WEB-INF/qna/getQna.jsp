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
<title>질문 및 답변 상세보기</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="field">
		<h2 class="title is-1 is-spaced">글 상세보기</h2>
		<table class="table is-fullwidth">
			<tbody>
				<tr>
					<th>글 번호</th>
					<td>${qna.qnum }</td>
				</tr>
				<tr>
					<th>질문 제목</th>
					<td>${qna.qtitle }</td>
				</tr>
				<tr>
					<th>질문 내용</th>
					<td>${qna.qcontent }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${qna.qauthor }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>
						<fmt:parseDate value="${qna.qdate }" var="qdate" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate value="${qdate }" pattern="yyyy년 MM월 dd일" />
					</td>
				</tr>
			</tbody>
		</table>
		<hr>
		<h3 class="title is-3 is-spaced">답글 보기</h3>
		<table class="table is-fullwidth">
			<thead>
				<tr><th>연번</th><th>답변 제목</th><th>작성자</th><th>작성일</th></tr>
			</thead>
			<tbody>
				<c:forEach var="qna" items="${qnaList }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>
						<a href="${path1 }/GetQna.do?qnum=${qna.qnum }">${qna.qtitle }</a>
					</td>
					<td>${qna.qauthor }</td>
					<td>
						<fmt:parseDate value="${qna.qdate }" var="qdate" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate value="${qdate }" pattern="yyyy년 MM월 dd일" />
					</td>
				</tr>
				</c:forEach>
				<c:if test="${empty qnaList }">
				<tr>
					<td colspan="4">답변 목록이 존재하지 않습니다.</td>
				</tr>
				</c:if>	
			</tbody>
		</table>
		<div class="btn-group">
			<a href="${path1 }/QnaList.do" class="button is-light">글 목록</a>
			<c:if test="${sid.equals('admin') }">
			<a href="${path1 }/AddReply.do?parno=${qna.qnum }" class="button is-light">답변하기</a>
			</c:if>
			<c:if test="${qna.qauthor.equals(sid) || sid.equals('admin') }">
			<a href="${path1 }/DelQna.do?qnum=${qna.qnum }" class="button is-light">질문 삭제</a>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>