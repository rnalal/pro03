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
<title>장소 상세 보기</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="field">
		<h3 class="title is-3 is-spaced">장소 > <a href="${path1 }/BoardList.do?cate=${boa.cate}">${cateMap.catename }</a> > ${boa.btitle }</h3>
		<br><hr><br>
		<fmt:setLocale value="ko_kr" />
		<table class="table is-fullwidth">
			<tbody>
				<tr>
					<td colspan="2">
						<img src='${path1 }/board/${boa.pic1 }' alt="${boa.btitle }"/>
						<img src='${path1 }/board/${boa.pic2 }' alt="${boa.btitle }"/>
						<img src='${path1 }/board/${boa.pic3 }' alt="${boa.btitle }"/>
						<img src='${path1 }/board/${boa.pic4 }' alt="${boa.btitle }"/>
						<img src='${path1 }/board/${boa.pic5 }' alt="${boa.btitle }"/>
					</td>
					<br>
					<br>
				</tr>
				<tr>
					<th>장소명</th>
					<td>${boa.btitle }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${boa.bcontent }</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="btn-group">
							<c:if test="${empty sid }">
				        		<a href="${path1 }/GetBoardList.do?cate=${boa.cate}" class="button is-light" role="button">목록</a>
				          	</c:if>
				          	<c:if test="${!empty sid }">
								<a href="${path1 }/GetBoardList.do?cate=${boa.cate}" class="button is-light" role="button">목록</a>
							</c:if>	
							<c:if test="${sid.equals('admin') }">
								<a href="${path1 }/UpdateBoard.do?bnum=${boa.bnum }" class="button is-light" role="button">수정</a>
								<a href="${path1 }/DeleteBoard.do?bnum=${boa.bnum }" class="button is-light" role="button">삭제</a>
								<a href="${path1 }/GetBoardList.do?cate=${boa.cate}" class="button is-light" role="button">목록</a>
							</c:if>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<table class="table is-fullwidth">
			<tbody>
				<c:forEach var="rev" items="${rList }">
				<tr>
					<td>작성자 : ${rev.id }</td>
					<td>제목 : ${rev.rtitle }</td>
					<td>내용 : ${rev.rcontent }</td>
					<td>
						<c:if test="${rev.id==sid }">
							<a href="${path1 }/UpdateReview.do?rnum=${rev.rnum }" class="button is-light">이용후기 수정</a>
						</c:if>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${sid.equals('admin') }">
		<div class="btn-group">
			<a href="${path1 }/InsertBoard.do" class="btn btn-danger">장소 등록</a>
		</div>
		</c:if>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>