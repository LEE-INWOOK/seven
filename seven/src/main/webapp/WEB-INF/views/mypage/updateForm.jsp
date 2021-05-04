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
<script src='<c:url value="/resources/script/jquery-3.6.0.js" />'></script>
 <script type="text/javascript">
	function checkDelete() {
		// 비밀번호 일치여부 확인 
		
		if (confirm("정말 삭제하시겠습니까?") == true){//확인
			alert("삭제창으로 이동");
			location.href='<c:url value="/mypage/deletePro" />';
		 }else{//취소
		     return false;
		 }
		
		
	}
</script>

        
</head>
<body>

	<!-- Header start-->
	<c:import url="/resources/inc/header.jsp" />
	<!-- Header end -->


	<div class="container py-5">
		<h1 class="page-header">HELLO ${mb.member_name } </h1>

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
				<div class="card-header"> UPDATE YOUR INFORMATION </div>
				<div class="card-body">
					
							
					<!-- 회원 정보 수정 관련 페이지입니다 -->
					<!-- css 수정! / -->
					<form action='<c:url value="/mypage/updatePro" />' method="post" id="join">
		
						<label> ID </label> <input type="text" name="member_id" readonly="readonly" value='${mb.member_id }'> <br>
						<label> PASSWORD </label> <input type="password" name="member_pass"><br>
						<label> PASSWORD CHECK </label> <input type="password" name="pass2"><br>
						<label> NAME </label> <input type="text" name="member_name" value='${mb.member_name }' > <br>
						<label> EMAIL</label> <input type="text" name="member_email" value='${mb.member_email }'> <br>
						<label> Address</label> 
						<input type="text" id="sample6_postcode" placeholder="우편번호"  name="member_zipcode" value='${mb.member_zipcode }'> 
						<input type="button" value="우편번호 찾기" class="button small"><br>
		                    <input type="text" id="sample6_address" placeholder="주소" name="member_address" value='${mb.member_address }'>
		                    <input type="text" id="sample6_detailAddress" placeholder="상세주소" name="member_address2" value='${mb.member_address2 }'><br>
						<label> PHONE </label> <input type="text" name="member_phone" value='${mb.member_phone }'> <br>
						
						
							<input type="submit" value="회원정보 수정">
							<input type="button" value="회원탈퇴" onclick="checkDelete()">
							<input type="reset" value="취소">
						
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