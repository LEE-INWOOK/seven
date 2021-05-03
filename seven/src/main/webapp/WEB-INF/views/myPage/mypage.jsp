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
					<div class="card-header">메뉴 들어갈 곳</div>
					<div class="card-body">
						<nav aria-label="...">
							<ul class="">
								<li class="page-item"><a onclick="#"> MY INFO </a></li> <!-- 회원 정보 수정 페이지 / 비밀번호 입력 후 일치하면 정보 조회 및 수정 가능 -->
								<li class="page-item"><a href="#"> WISH LIST </a></li> <!-- 삭제, 장바구니 추가 등 기능 구현  -->
								<li class="page-item"><a href="#"> HISTORY </a></li> <!-- 주문 내역, 배송상태, 주문 상태확인  -->
							</ul>
						</nav>
					</div>
					
				</div>
			</div>

			<div class="col-lg-9">
				<!--본문 내용 -->
				<div class="card-header">Content Formatting</div>
				<div class="card-body">
					
					<!-- 위시리스트 페이지 입니다.  -->
					
					<table>
						<!-- 반복 -->
						<tbody>
							<tr>
							<td><!-- 제품 사진 --> <img alt="제품 사진" src="../img/category-1.jpg" width="100" height="100" >  </td>
								<td width="300"> 
									<!-- 제품명 --> 제품명
								</td>
								<td> 
									<input type="button" value="장바구니에 담기"> <br>
									<input type="button" value="바로 주문">			
								 </td>
							</tr>	
						</tbody>
						<!-- 반복 -->
					
					</table>
					
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
					
					<!-- 회원 정보 수정 관련 페이지입니다 -->
					<form action="#" method="post" id="join">
		
						<label> ID </label> <input type="text" name="id" readonly="readonly"> <br>
						<label> PASSWORD </label> <input type="password" name="pass"><br>
						<label> NAME </label> <input type="text" name="name" > <br>
						<label> EMAIL</label> <input type="text" name="email" > <br>
						<label> Address</label> 
						<input type="text" id="sample6_postcode" placeholder="우편번호"  name="zipcode"> 
						<input type="button" value="우편번호 찾기" class="button small"><br>
		                    <input type="text" id="sample6_address" placeholder="주소" name="address" >
		                    <input type="text" id="sample6_detailAddress" placeholder="상세주소" name="address2" ><br>
						<label> PHONE </label> <input type="text" name="phone" > <br>
						<label> MOBILE </label> <input type="text" name="mobile"> <br>
						
						<ul class="actions fit small">
							<li><input type="submit" class="button fit small" value="회원정보 수정"></li>
							<li><input type="button" class="button fit small" value="회원탈퇴"></li>
							<li><input type="reset" class="button fit small" value="취소"></li>
						</ul>
					</form>
					

				</div>
			</div>
		</div>
	</div>


	<!-- Footer start -->
	<c:import url="/resources/inc/footer.jsp" />
	<!-- Footer end -->
</body>
</html>