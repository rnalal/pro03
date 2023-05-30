<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<%
	String sid = "";
	if(session!=null) sid = (String) session.getAttribute("sid");
%>
<style>
.navbar { padding-top:20px; }
.navbar-link { padding-left:80px; }
.logo { width:150px; height:56px; }
</style>
<header id="hd" class="container">
	<div class="container is-fluid">
		<nav class="navbar" role="navigation" aria-label="main navigation">
		  <div class="navbar-brand">
		    <a class="logo" href="${path1 }/">
		      <img src="./img/logo/logo.gif" width="126" height="56">
		    </a>
		    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		    </a>
		  </div>
		  <div id="navbarBasicExample" class="navbar-menu">
		    <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link">지역정보</a>
		        <div class="navbar-dropdown">
		          <a href="${path1 }/localinfo.jsp" class="navbar-item">가평소개</a>
		          <a href="${path1 }/news.jsp" class="navbar-item">가평여행소식</a>
		          <a href="${path1 }/photo.jsp" class="navbar-item">가평관광사진</a>
		        </div>
		      </div>
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link">관광명소</a>
		        <div class="navbar-dropdown">
		          <a href="${path1 }/GetBoardList.do?cate=0101" class="navbar-item">관광지</a>
		          <a href="${path1 }/GetBoardList.do?cate=0102" class="navbar-item">문화유적</a>
		        </div>
		      </div>
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link">숙박</a>
		        <div class="navbar-dropdown">
		          <a href="${path1 }/GetBoardList.do?cate=0201" class="navbar-item">관광호텔</a>
		          <a href="${path1 }/GetBoardList.do?cate=0202" class="navbar-item">일반숙박시설</a>
		          <a href="${path1 }/GetBoardList.do?cate=0203" class="navbar-item">야영장</a>
		        </div>
		      </div>
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link">맛집</a>
		        <div class="navbar-dropdown">
		          <a href="${path1 }/GetBoardList.do?cate=0301" class="navbar-item">100대 맛집</a>
		          <a href="${path1 }/GetBoardList.do?cate=0302" class="navbar-item">일반음식점</a>
		        </div>
		      </div>
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link">여행길잡이</a>
		        <div class="navbar-dropdown">
		          <a href="${path1 }/QnaList.do" class="navbar-item">Q&A</a>
		          <a href="${path1 }/ReviewList.do" class="navbar-item">리뷰</a>
		          <a href="${path1 }/NoticeList.do" class="navbar-item">공지사항</a>
		        </div>
		      </div>
		    </div>
		    <div class="navbar-end">
		      <div class="navbar-item">
		        <div class="buttons">
		        	<c:if test="${empty sid }">
		        		<a href="${path }/UserLogin.do" class="button is-light">로그인</a>
		          		<a href="${path }/UserTerms.do" class="button is-primary">회원가입</a>
		          	</c:if>
		          	<c:if test="${!empty sid }">
						<a href="${path }/MyPage.do" class="button is-primary">마이페이지</a>
						<a href="${path }/UserLogout.do" class="button is-light">로그아웃</a>
					</c:if>
		        </div>
		      </div>
		    </div>
		</nav>
		<c:if test="${sid=='admin' }">
			<div class="navbar-item">
		        <div class="buttons">
					<a href="${path1 }/MemberList.do" class="button is-primary">회원 관리</a>
				</div>
			</div>
		</c:if>
	</div>
</header>