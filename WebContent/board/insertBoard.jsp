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
<title>장소 등록 하기</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="field">
		<h2 class="title is-1 is-spaced">장소 등록</h2>
		<p>${msg }</p>
		<form action="${path1 }/InsertBoardPro.do" method="post" enctype="multipart/form-data">
			<table class="table is-fullwidth">
				<tbody>
					<tr>
						<th>
							<label for="cate1">장소 분류</label><br>
							<span id="bnumtxt"></span>
						</th>
						<td>
							대분류 : 
							<select id="cate1" name="cate1" class="form-control">
								<option value="">선택안함</option>
								<c:forEach items="${cateList }" var="cate1">
								<option value="${cate1.ct }">${cate1.categroup }</option>
								</c:forEach>	
							</select>
							소분류 : 
							<select id="cate" name="cate" class="form-control">
								<option value="">선택안함</option>
							</select><br>
							<input type="hidden" id="bnum" name="bnum" value="">
							<input type="hidden" id="bnumck" name="bnumck" value="no">
							<input type="button" value="장소 코드 발급" class="button is-light" onclick="boardCodeGenerator()">
						</td>
					</tr>
					<tr>
						<th><label for="btitle">장소명</label></th>
						<td>
							<input class="input" type="text" name="btitle" id="btitle" title="40자 내로 작성" placeholder="40자 내로 작성" class="form-control" required>
						</td>
					</tr>
					<tr>
						<th><label for="bcontent">장소 소개</label></th>
						<td>
							<input class="input" type="text" name="bcontent" id="bcontent" title="100자 내로 작성" placeholder="100자 내로 작성" class="form-control">
						</td>
					</tr>
					<tr>
						<th><label for="pic1">상품 이미지 첨부</label></th>
						<td>
							이미지 1 : <p id="picAttac1"></p><input type="file" accept="image/*" name="pic1" id="pic1" class="form-control file"><br>
							이미지 2 : <p id="picAttac2"></p><input type="file" accept="image/*" name="pic2" id="pic2" class="form-control file"><br>
							이미지 3 : <p id="picAttac3"></p><input type="file" accept="image/*" name="pic3" id="pic3" class="form-control file"><br>
							이미지 4 : <p id="picAttac4"></p><input type="file" accept="image/*" name="pic4" id="pic4" class="form-control file"><br>
							이미지 5 : <p id="picAttac5"></p><input type="file" accept="image/*" name="pic5" id="pic5" class="form-control file">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="제품 등록" class="button is-light">
							<a href="${path1 }/AdminBoardList.do" class="button is-light">글 목록</a>				
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<script>
		$(document).ready(function(){
			$("#bcontent").click(function(){
				if($(this).text()=="500자 이내"){
					$(this).text("");
				}
			});
			$(".file").change(function(){
				var tar = $(this).index();
				if($(this).val()!=""){
					$(this).prev("p").html("<strong>이미지 첨부 성공</strong>");
				}
			});
			$("#cate1").change(function(){
				if($("#cate1").val()==""){
					alert("대분류 카테고리를 선택하시기 바랍니다.");
					$("#cate1").focus();
					return;
				}
				var params = { cate1:$("#cate1").val() }
				$.ajax({
					url:"${path1 }/CategoryLoading.do",
					type:"post",
					dataType:"json",
					encType:'UTF-8',
					data:params,
					success:function(result){
						console.log(result);
						var cateList = result.cateList;
						var msg = result.msg;
						$("#cate").empty();
						$("#cate").append("<option value=''>선택안함</option>");
						for(var c in cateList){
							$("#cate").append("<option value='"+cateList[c]["cate"]+"'>"+cateList[c]["catename"]+"</option>");
						}
					}
				});				
			});
			
		});
		function boardCodeGenerator(){
			if($("#cate1").val()=="" || $("#cate").val()==""){
				alert("대분류/소분류 카테고리를 선택하시기 바랍니다.");
				$("#cate1").focus();
				return;
			}
			var params = { cate:$("#cate").val() }
			$.ajax({
				url:"${path1 }/BoardCodeGenerator.do",
				type:"post",
				dataType:"json",
				data:params,
				encType:"UTF-8",
				success:function(result){
					console.log(result);
					var msg = result.msg;
					var boaBnum = result.bnum;
					$("#bnumck").val("yes");
					$("#bnum").val(boaBnum);
					$("#bnumtxt").html("("+boaBnum+")");
					$("#msg").html("<strong>상품 코드가 발급되었습니다.</strong>");
					$("#btitle").focus();
				}
			});
		}
		function boardCheck(f){
			if(f.bnumck.value!="yes"){
				alert("상품코드를 생성하지 않으셨습니다.");
				return false;
			}
		}
	</script>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>