<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop | My page</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<!-- Bootstrap CSS-->
<link rel="stylesheet"
	href='<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />'>
<!-- Lightbox-->
<link rel="stylesheet"
	href='<c:url value="/resources/vendor/lightbox2/css/lightbox.min.css" />'>
<!-- Range slider-->
<link rel="stylesheet"
	href='<c:url value="/resources/vendor/nouislider/nouislider.min.css" />'>
<!-- Bootstrap select-->
<link rel="stylesheet"
	href='<c:url value="/resources/vendor/bootstrap-select/css/bootstrap-select.min.css" />'>
<!-- Owl Carousel-->
<link rel="stylesheet"
	href='<c:url value="/resources/vendor/owl.carousel2/assets/owl.carousel.min.css" />'>
<link rel="stylesheet"
	href='<c:url value="/resources/vendor/owl.carousel2/assets/owl.theme.default.css" />'>
<!-- Google fonts-->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Libre+Franklin:wght@300;400;700&amp;display=swap">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Martel+Sans:wght@300;400;800&amp;display=swap">
<!-- theme stylesheet-->
<link rel="stylesheet" href='<c:url value="/resources/css/style.default.css" />' id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href='<c:url value="/resources/css/custom.css" />'>
<!-- Favicon-->
<link rel="shortcut icon"
	href='<c:url value="/resources/img/favicon.png" />'>
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->

<script src='<c:url value="/resources/script/jquery-3.6.0.js" />'></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		 $('.heart').click(function() {
			 alert("클릭! 하트");
			 var getProductNum=$(this).attr('value');
			
			  $.ajax('<c:url value="/wish/add" />', {
			alert(getProductNum);
				 // 추가 제거
				// 디비 wish 테이블의 상품 명을 검색하여 있으면 출력 
				// -1 (login 안되어있음) 0 (삭제 처리됨) 1 (등록 처리됨)
				 
				data:{product_num:$(this).attr('value')},
				success:function(result){
					alert(result);
					if (result == -1){
						if (confirm("로그인이 필요한 서비스 입니다 로그인 하시겠습니까?") == true){//확인
							// 비밀번호 일치 여부를 확인 하여 일치하면 삭제, 일치하지 않으면 다시 돌아오기 
							location.href='<c:url value="/member/login" />';
						 }else{//취소
						     return false;
						 }
						
					}else if(result == 1 ){ // 조회 결과 존재 할때 
						$(this).attr('src','<c:url value="/resources/img/heart.png" />'); // 빨간 하트 
						
					} else{ // 데이터가 없을 때 
						$(this).attr('src','<c:url value="/resources/img/heart_empty.png" />'); // 비어있는 하트 (기본값 default)
						
					} 
					
				}
				 
			 });

		 });
	});

</script>


</head>
<body>

	<!-- Header start-->
	<c:import url="/resources/inc/header.jsp" />
	<!-- Header end -->


	<div class="container py-5">
		<h2 class="page-header"> HELLO! ${mb.member_name } </h2>

<!-- 비동기 방식으로 각 페이지 연결 하여 구현  -->
		<div class="row">
			<div class="col-lg-2">
				<!-- 사이드 메뉴바 -->
				<c:import url="/resources/inc/mypageSideNav.jsp" />
			</div>

			<div class="col-lg-10">
				<!--본문 내용 -->
				<div class="card-header"> MY WISH </div>
				<div class="card-body">
					
					
					<!-- wish List 관련 페이지 입니다.  -->
										 
					<table class="table table-hover">
						<tbody>
					
						<!-- 반복 -->
							<c:choose>
								<c:when test="${empty proList }"> <!-- if -->
									<tr>
										<td colspan="3"> Add to wishList </td> <!-- wishList가 비어있을 경우 -->
										
									</tr>
								</c:when>
								<c:otherwise> <!-- else list에 내용이 존재 하는 경우  -->
									<c:forEach var="proList" items="${proList }">
									<tr>
										<td width="160"><!-- 제품 사진 --> <img alt="제품 사진" src='<c:url value="/resources/upload/${proList.product_image}" />'width="150" height="150" >  </td>
										<td> <h4> <small> <!-- 제품명 --> ${proList.product_title } </small> 
<%-- 											<input type="hidden" id="${proList.product_num }" value="${proList.product_num }"> --%>
										 </h4> </td>
										<td align="right">
											<input class="btn btn-sm btn-link " type="button" value="ADD CART" onclick="location.href='<c:url value="" />'">
											<input class="heart" value="test" type="button">
<%-- 											<img width="20px" alt="addToWish" src='<c:url value="/resources/img/heart_empty.png" />' class="heart">	 --%>
<%-- 											<img width="20px" alt="addToWish" src='<c:url value="/resources/img/heart_empty.png" />' class="heart" > --%>
<!-- 											<div class="heart" > </div> -->
											<input type="image" alt="addToWish" src='<c:url value="/resources/img/heart.png" />'  width="20px" class="heart" value="${proList.product_num }" >
										 </td>
									</tr>
									</c:forEach>		
								</c:otherwise>
							</c:choose>
						<!-- 반복 -->
						</tbody>
					</table>
					
					

				</div>
			</div>
		</div>
	</div>


	<!-- Footer start -->
	<c:import url="/resources/inc/footer.jsp" />
	<!-- Footer end -->
</body>
</html>