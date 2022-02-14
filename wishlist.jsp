<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 찜하기 버튼을 누를경우 이벤트 발생  -->
	<scripttype-"text/javascript">
	$(document).ready(function(){
		$('#prdct_like_dis').click(function(event){
			event.preventDefault();
			//비로그인한 상태시 찜하기 버튼을 누르면
				if("${mbr.mbr_id}"==""){
					if(confirm("로그인 한 회원만 이용가능합니다. 로그인 하시겠습니까?")){
					//승낙하면 로그인 페이지로 이동
					location.href="Mypage.jsp";
				}else{
					//거부하면 해당 페이지 새로고침
				 location.reload();
			 	}
				//로그인 상태시 찜하기 버튼을 누르면
				}else{
					const mbr_id = "${mbr.mbr_id}";
					const prdct_id = "${prdct.prdct_id}";
					const board_id = "${prdct.board_id}";
					
					console.log("mbr_id:" + mbr_id);
					console.log("mbr_id type:" + (typeof mbr_id));
					console.log("prdct_id:" + prdct_id);
					console.log("prdct_id type:" + (typeof prdct id));
					console.log("board_id:" + board_id);
					console.log("board_id:" + (typeof board id));
					
					const form={
							mbr_id:mbr_id,
							prdct_id:prdct_id
							board_id:board_id
					};
					
					$.ajax({
						type:"POST",
						url:"${}",
						cache:false,
						contentType:'application/json;charset=utf-8',
						data: JSON.stringify(form),
						success:function(result){
							console.log(result);
							if(result =="SUCCESS"){
								console.log("찜 성공")
								if(confirm("해당상품을 찜하셨습니다. 목록페이지로 이동하시겠습니까?")){
									//승낙하면 마이페이지의 찜하기 리스트로 이동
									location.href='${}'
								}else{
									//거부하면 해당 페이지 새로고침하여 찜한거 반영되게하기(HTTP의 속성 때문...??)
								 location.reload();
								}
							}
						},
						error:function(e){
							console.log(e);
							alert("찜할 수 없습니다.");
							location.reload(); //실패시 새로고침하기							
						}
					})
				}
		});
	});
	</script>
	<!-- 찜 취소 버튼을 누를경우 이벤트 발생  -->
	<script type="text/javascript">
	$(document).ready(function(){
		$('#prdct_like_ena').click(function(event){
			event.preventDefault();
			//FormData 객체 생성
		 	const formData = new FormData();
			//정보를 가져와 FormData에 append한다.
			const prdct_like_number = $('#prd_like_num').text();
			
			console.log("prdct_like_number:"+prdct_like_number);
			console.log("prdct_like_number:"(typeof prdct_like_number));
			
			formData.append("prdct_like_number",prdct_like_number);
			
		$.ajax({
			type:'DELETE',
			url:$(this).attr("href"),
			cache:false,
			processData:false,
			contentType:false,
			data:formData,
			success:function(result){
				console.log(result);
				if(result=="SUCCESS"){
					console.log("찜 취소 성공!")
					alert('해당 상품을 찜 취소하셨습니다.');
					location.href="${}";
				}
			},
			error:funtion(e){
				console.log(e);
				alert("찜 취소 할 수 없습니다.");
				location.reload();//실패시 새로고침하기
			}
		});
		});
	</script>
	<!-- 상품 찜 기능 --> 
	<div class="icon" style="float: left; padding-left: 20px; padding-top: 10px;"> 
	<!-- 찜하기 했을 경우 해당 정보 가져오기 --> 
	<span id="prd_like_num" style="display: none;">	${prdLikeVal.prdct_like_number}</span> 
	<%-- 찜하기 기능은 고객(MEMBER 권한)만 이용할 수 있게 설정 --%> 
	<sec:authorize access="isAnonymous()">
	 <%-- 로그인 상태가 아니므로 자동으로 로그인 comfirm창이 뜨게 설정 --%>
	  <i id="prdct_like_dis" class="fa fa-heart-o fa-2x" onclick="location.href=''">찜하기</i> </sec:authorize>
	   <sec:authorize access="hasAuthority('ADMIN')"> <i class="fa fa-heart-o fa-2x">찜불가</i> </sec:authorize>
	   <sec:authorize access="hasAuthority('SELLER')"> <i class="fa fa-heart-o fa-2x">찜불가</i> </sec:authorize>
	   <sec:authorize access="hasAuthority('MEMBER')">
	   <c:choose>
	   <%-- prdct_like 테이블을 가져와 비교후 예전에 찜하기를 했었다면 찜취소로 활성화가 된다 --%> 
	   <c:when test="${(prdLikeVal.prdct_id eq prdct.prdct_id) and (prdLikeVal.mbr_id eq mbr.mbr_id)}">
	   <i id="prdct_like_ena" class="fa fa-heart fa-2x" onclick="location.href='$'">찜취소</i>
	   </c:when>
	    <%-- prdct_like 테이블을 가져와 비교후 예전에 찜하기를 안했다면(혹은 찜취소를 했었다면) 찜하기로 활성화가 된다 --%>
	     <c:otherwise> 
	    <i id="prdct_like_dis" class="fa fa-heart-o fa-2x" onclick="location.href='${pageContext.request.contextPath}/prdct/{prdct_id}'">찜하기</i>
	    </c:otherwise>
	     </c:choose>
	      </sec:authorize>
	       </div>

	
</body>
</html>