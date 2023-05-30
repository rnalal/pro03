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
<title>공지사항 글 수정하기</title>
<style>

</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="field" style="text-align:center;">
		<h2 class="title is-1 is-spaced"><strong>글 수정</strong></h2>
		<p>${msg }</p>
		<form action="${path1 }/UpdateNoticePro.do" method="post" enctype="multipart/form-data">
			<table class="table is-fullwidth">
				<tbody>
					<tr>
						<th><label for="ntitle">제목</label></th>
						<td>
							<input class="input" type="hidden" name="nauthor" id="nauthor" value="${sid }">
							<input class="input" type="hidden" name="nnum" id="nnum" value="${noti.nnum }">
							<input class="input" type="text" name="ntitle" id="ntitle" value="${noti.ntitle }" maxlength="98" title="100자 내로 작성" placeholder="100자 내로 작성" class="form-control" required autofocus>
						</td>
					</tr>
					<tr>
						<th><label for="ncontent">글 내용</label></th>
						<td>
							<textarea class="textarea" rows="10" cols="100" name="ncontent" id="ncontent" maxlength="990" title="1000자 내로 작성">${noti.ncontent }</textarea>
						</td>
					</tr>
					<tr>
						<th><label class="file-label" for="file1">첨부 파일</label></th>
						<td>
							<span>
								<c:set var="lh" value="${fn:length(noti.file1) }" />
								<c:set var="download" value="${fn:substring(noti.file1,5,lh) }" />
								${download }
							</span><br>
							<input class="checkbox" type="radio" name="fileSel" id="fileSel1" onclick="fileCall()" checked>교체 안함<br> 
							<input class="checkbox" type="radio" name="fileSel" id="fileSel2" onclick="fileCall()" >교체<br>
							<input class="file-label" type="file" name="file1" id="file1" class="">
							<input class="file-label" type="hidden" name="file1" id="file2" value="${download }">
							<script>
							function fileCall(){
								var fileSel1 = document.getElementById("fileSel1");
								var fileSel2 = document.getElementById("fileSel2");
								var file1 = document.getElementById("file1");
								var file2 = document.getElementById("file2");
								if(fileSel1.checked){
									file1.style.display = "none";
									file1.setAttribute("disabled");
									file2.removeAttribute("disabled");
								} else {
									file1.style.display = "block";
									file1.removeAttribute("disabled");
									file2.setAttribute("disabled");
								}
							}
							</script>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="글 수정" class="button is-light">
							<a href="${path1 }/NoticeList.do" class="button is-light">글 목록</a>				
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