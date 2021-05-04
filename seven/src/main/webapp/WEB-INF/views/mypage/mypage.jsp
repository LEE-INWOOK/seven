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
<link rel="stylesheet"
	href='<c:url value="/resources/css/style.default.css" />'
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet"
	href='<c:url value="/resources/css/custom.css" />'>
<!-- Favicon-->
<link rel="shortcut icon"
	href='<c:url value="/resources/img/favicon.png" />'>
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>

	<!-- Header start-->
	<c:import url="/resources/inc/header.jsp" />
	<!-- Header end -->


	<div class="container py-5">
		<h1 class="page-header"> 회원명 <small>님의 페이지</small></h1>

<!-- 비동기 방식으로 각 페이지 연결 하여 구현  -->
		<div class="row">
			<div class="col-lg-3">
				<div class="card mb-4" id="headings">
				
				<!-- 사이드 메뉴바 -->
					<c:import url="/resources/inc/mypageSideNav.jsp" />
					
				</div>
			</div>

			<div class="col-lg-9">
				<!--본문 내용 -->
				<div class="card-header"> Hello (회원명) </div>
				<div class="card-body">
					
					
					<!-- 구매 내역관련 페이지 입니다.  -->

					<!--  -->
					
					<table>
						<!-- 반복 -->
						<tbody>
							<tr>
							<td><!-- 제품 사진 --> <img alt="제품 사진" src="../img/category-1.jpg" width="100" height="100" >  </td>
								<td width="600"> 
									<b> <!-- 구매 내역 상태 (배송상태) --> 주문완료 </b> <br>
									<!-- 제품명 --> 제품명
									<!-- 주문 금액 --> $250
								</td>
								<td> 
									<input type="button" value="주문 취소"> <br>
									<input type="button" value="주문 확인"> <br>
									<input type="button" value="주문 리뷰">			
								 </td>
							</tr>	
						</tbody>
						<!-- 반복 -->
					
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