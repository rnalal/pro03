<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
/* .content has-text-centered { text-align:center; } */
</style>
<footer class="footer" style="min-height:100px; border-top:3px solid #333; margin-top:30px; padding-top:30px;">
  <div class="content has-text-centered">
	<select name="favo" id="favo" class="favo right" onchange="favo(this)" style="float:right;">
		<option value="">패밀리 사이트</option>
		<option value="https://www.gp.go.kr/portal/index.do">가평군청</option>
		<option value="https://knto.or.kr/index#">한국관광공사</option>
		<option value="https://gto.or.kr/main.php">경기관광공사</option>
	</select>
	<script>
	function favo(s){
	var hs = s.value;
	if(hs!=""){
	window.open(hs, "팝업");
		}
	}    
	</script>
    <p style="font-weight:bold;"><img src="./img/logo/logo_footer.gif" alt="가평" style="padding-right:50px;">copyright2010 gapyeong county. all rights reserved.</p>
  </div>
</footer>