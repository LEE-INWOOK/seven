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
				<div class="card-header">Content Formatting</div>
				<div class="card-body">
					
							
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