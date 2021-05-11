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
		<h2 class="page-header"> HELLO! ${mb.member_name } </h2>

<!-- 비동기 방식으로 각 페이지 연결 하여 구현  -->
		<div class="row">
			<div class="col-lg-2">
				<!-- 사이드 메뉴바 -->
				<c:import url="/resources/inc/mypageSideNav.jsp" />
			</div>

			<div class="col-lg-10">
				<!--본문 내용 -->
				<div class="card-header"> 주문 내역 </div>
				<div class="card-body">
					<!-- 구매 내역관련 페이지 입니다.  -->
					<table class="table table-hover">
					
<%-- 					<c:forEach > --%>
					
<%-- 					</c:forEach> --%>
						<tbody>
						
						<!-- 반복 -->
							<c:choose>
								<c:when test="${empty orderList }"> <!-- if -->
									<tr>
										<td colspan="3"> Sorry we can't find any history  </td> <!-- orderList가 비어있을 경우 -->
									</tr>
								</c:when>
								<c:otherwise> <!-- else list에 내용이 존재 하는 경우  -->
									<c:forEach var="wishList" items="${orderList }">
										<tr>
											<td width="160"><!-- 제품 사진 --> <img alt="제품 사진" src='<c:url value="resources/img/product-10.jpg"/>' width="150" height="150" >  </td>
											<td> <h4> <small> <!-- 제품명 --> 제품명 </small> </h4> </td>
											<td align="right"> <!-- 주문 금액 --> $(금액) </td>
											<td align="right" width="120"> 
												<b> <!-- 구매 내역 상태 (배송상태) --> 배송중  </b> <br>
												<c:if test=""> <!-- 구매 상태가 주문 완료 일떄  -->
													<input class="btn btn-sm btn-link" type="button" value="취소 요청"> <br>
													<input class="btn btn-sm btn-link" type="button" value="결제 정보">	
												</c:if>
												
												<c:if test=""> <!-- 구매 상태가 배송 중 일떄  -->
													<input class="btn btn-sm btn-link" type="button" value="환불 요청"> <br>
													<input class="btn btn-sm btn-link" type="button" value="배송 위치">	
												</c:if>
												
												<c:if test=""> <!-- 구매 상태가 배송 완료 일떄  -->
													<input class="btn btn-sm btn-link" type="button" value="환불 요청"> <br>
													<input class="btn btn-sm btn-link" type="button" value="주문 리뷰">	
												</c:if>
														
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