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
<title>답변 글 수정하기</title>
<style>
.container-fluid { width:1280px; }
#fileSel1:checked ~ #file1 { display:none; }
#fileSel2:checked ~ #file1 { display:block; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="field">
		<h2 class="title is-1 is-spaced">답변 글 수정</h2>
		<p>${msg }</p>
		<form action="${path1 }/UpdateReplyPro.do" method="post" enctype="multipart/form-data">
			<table class="table is-fullwidth">
				<tbody>
					<tr>
						<th><label for="qtitle">답변 제목</label></th>
						<td>
							<input class="input" type="hidden" name="qauthor" id="qauthor" value="${sid }">
							<input class="input" type="hidden" name="qnum" id="qnum" value="${qna.qnum }">
							<input class="input" type="text" name="qtitle" id="qtitle" value="${qna.qtitle }" maxlength="98" title="100자 내로 작성" placeholder="100자 내로 작성" class="form-control" required autofocus>
						</td>
					</tr>
					<tr>
						<th><label for="qcontent">답변 글 내용</label></th>
						<td>
							<textarea rows="10" cols="100" name="qcontent" id="qcontent" maxlength="990" title="1000자 내로 작성" class="textarea">${qna.qcontent }</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="답변 수정" class="button is-light">
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