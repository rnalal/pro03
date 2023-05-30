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
<title>회원  목록</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="field">
		<h2 class="title is-1 is-spaced">회원 목록</h2>
		<table class="table is-fullwidth">
			<thead>
				<tr><th>연번</th><th>회원 아이디</th><th>회원명</th><th>가입일</th><th>개별 작업</th></tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>
						<input type="hidden" name="id" id="id" value="${wid }">
						<a href="${path1 }/MemberDetail.do?id=${user.id }" title="${user.hpw }">${user.id }</a>
					</td>
					<td><span title="${user.addr }">${user.name }</span></td>
					<td>
						<fmt:parseDate value="${user.udate }" var="udate" pattern="yyyy-MM-dd HH:mm:ss" />
						<span title="전화번호 : ${user.tel }, 이메일 : ${user.email }"><fmt:formatDate value="${udate }" pattern="yyyy년 MM월 dd일" /></span>
					</td>
					<td>
						<a href="${path1 }/AdminDeleteUser.do?id=${user.id }" class="button is-light">회원 삭제</a>
						<a href="${path1 }/AdminUpdateUser.do?id=${user.id }" class="button is-light">회원 정보 수정</a>
						<a href="${path1 }/AdminResetUser.do?id=${user.id }" class="button is-light" title="회원 전화번호 뒤 네자리로 초기화됩니다.">비밀번호 초기화</a>
					</td>
				</tr>
				</c:forEach>
				<c:if test="${empty userList }">
				<tr>
					<td colspan="4">가입된 회원이 존재하지 않습니다.</td>
				</tr>
				</c:if>	
			</tbody>
		</table>
		<c:if test="${!empty sid }">
		<div class="btn-group">
			<a href="${path1 }/InsertUser.do" class="button is-light">회원 직권 등록</a>
		</div>
		</c:if>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>