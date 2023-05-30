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
<title>질문 하기</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="field">
		<h2 class="title is-1 is-spaced">질문 글 쓰기</h2>
		<p>${msg }</p>
		<form action="${path1 }/AddQnaPro.do" method="post">
			<table class="table is-fullwidth">
				<tbody>
					<tr>
						<th><label for="qtitle">질문 제목</label></th>
						<td>
							<input type="hidden" name="lev" id="lev" value="1">
							<input type="hidden" name="qauthor" id="qauthor" value="${sid }">
							<input class="input" type="text" name="qtitle" id="qtitle" maxlength="98" title="100자 내로 작성" placeholder="100자 내로 작성" class="form-control" required autofocus>
						</td>
					</tr>
					<tr>
						<th><label for="qcontent">질문 내용</label></th>
						<td>
							<textarea class="textarea" rows="10" cols="100" name="qcontent" id="qcontent" maxlength="990" title="1000자 내로 작성"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="글쓰기" class="button is-light">
							<a href="${path1 }/QnaList.do" class="button is-light">글 목록</a>				
						</td>
					</tr>
				</tbody>
			</table>
		</form>		
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>