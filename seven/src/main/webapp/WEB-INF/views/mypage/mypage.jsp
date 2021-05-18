<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop | My page</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<!-- Bootstrap CSS-->
<link rel="stylesheet" href='<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />'>
<!-- Lightbox-->
<link rel="stylesheet" href='<c:url value="/resources/vendor/lightbox2/css/lightbox.min.css" />'>
<!-- Range slider-->
<link rel="stylesheet" href='<c:url value="/resources/vendor/nouislider/nouislider.min.css" />'>
<!-- Bootstrap select-->
<link rel="stylesheet" href='<c:url value="/resources/vendor/bootstrap-select/css/bootstrap-select.min.css" />'>
<!-- Owl Carousel-->
<link rel="stylesheet" href='<c:url value="/resources/vendor/owl.carousel2/assets/owl.carousel.min.css" />'>
<link rel="stylesheet" href='<c:url value="/resources/vendor/owl.carousel2/assets/owl.theme.default.css" />'>
<!-- Google fonts-->
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Libre+Franklin:wght@300;400;700&amp;display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Martel+Sans:wght@300;400;800&amp;display=swap">
<!-- theme stylesheet-->
<link rel="stylesheet"href='<c:url value="/resources/css/style.default.css" />' id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href='<c:url value="/resources/css/custom.css" />'>
<!-- Favicon-->
<link rel="shortcut icon" href='<c:url value="/resources/img/favicon.png" />'>
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
        
<!-- jQuery :) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>

<!-- jQuery Modal -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />


<script src='<c:url value="/resources/script/jquery-3.6.0.js" />'></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		// cancel 클릭 
		 $('.cancel').click(function() {
			 
			 alert("cancel");
			 // ajax 연결  후 디비  status cancel로 업데이트 
			 if (confirm("주문 취소 하시겠습니까?") == true){//확인
				location.href='<c:url value="/order/cancel" />';
				// mypage 로 return
			}else{//취소
				return false;
			}
			 
			 
		 }); // $('.cancel').click(function(){}); 
		 
		 
		 
			// contact 클릭 
		 $('.contact').click(function() {
			 alert("contact 연결 필");
			 // 카카오톡으로 연결 하도록 구현 
			 // 단순 알림으로 처리
		 }); // $('.contact').click(function(){}); 
		 

		// payment 클릭 
		 $('.payment').click(function(event) {
			  event.preventDefault();
			  this.blur(); // Manually remove focus from clicked link
			  
			  var name = $("#username").val();
			  var phone = $("#phone").val();
			   
			  var sendData = "name="+name+'&phone='+phone;
			  
			    $.ajax({
			        url:'/orders/payment'
			        , method : 'POST'
			        , data: sendData
			        , success :function(resp){
			        	 
			        	nowdate = new Date(item.date);
		        		  date_str=nowdate.getFullYear()+"."+(nowdate.getMonth()+1)+"."+nowdate.getDate();
						
						$('.payment-table').html
						('<tr> <td> 구매자 </td> <td>' + item.member_id + '</td> </tr>' 
						+ '<tr> <td> 구매자 </td> <td>' + item.member_id + '</td> </tr>'
					
				  	
						);
			        	
			        }
			    })
			    
			  
// 			  $.get(this.href, function(html) {
// 			    $(html).appendTo('body').modal();
// 			  });
			  
		});
		
		 
	}); // $(document).ready(function(){})


		  
</script>






</head>
<body>

	<!-- Header start-->
	<c:import url="/resources/inc/header.jsp" />
	<!-- Header end -->


<!------------- Modal --------------->

<!-- Modal HTML embedded directly into document -->
<div id="payment" class="modal">
  <p>Payment information</p>
  
  <table class="table payment-table">
  	<tr>
  		<td> 구매자 </td>
  		<td> 상품명 </td>
  		<td> 구매일 </td>
  		<td> 결제 수단 </td>
  		<td> 배송지 </td>
  		<td> 결제 금액 </td>
  		<td> 색상 </td>
  		<td> 사이즈 </td>
  	<tr>
  </table>
  
<!--   <a href="#" rel="modal:close">Close</a> -->
</div>

<!------------- Modal --------------->


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
						
							<c:choose>
								<c:when test="${empty orderList }"> <!-- if -->
									<tr>
										<td colspan="3"> <h3> Sorry we couldn't find any history </h3> </td> <!-- orderList가 비어있을 경우 -->
									</tr>
								</c:when>
								<c:otherwise> <!-- else list에 내용이 존재 하는 경우  -->
								
									<tr>
										<th width="60"> Date </th> 
										<th width="150"> image </th> 
										<th> product_title </th> 
										<th align="right" width="100"> 수량 </th> 
										<th align="right" width="120"> status </th> 
									</tr> 
									
								
									<c:forEach var="orderList" items="${orderList }" varStatus="status">
									<!-- 반복 -->
									<fmt:formatDate var="ordersDate" value="${orderList.orders_date}" pattern="MM-dd"/> <!-- 날짜 포맷 -->
										<tr>
											<td width="160" onclick="location.href='<c:url value="/product/detail?product_num=${orderList.product_num}" />'"> ${ordersDate} </td>
												 
											<td>
											<!-- 제품 사진 --> 
											<img alt="제품 사진" src='<c:url value="/resources/upload/${proList[status.index].product_image}" />' width="150" height="150" > 
												
											</td>
												 
											<td> 
												<h4> <small>  ${proList[status.index].product_title} </small> </h4> </td>
											<td align="right" width="100"> <!-- 주문 금액 --> 수량 : ${orderList.orders_count }</td>
											
											<!-- 수정 필 -->
											<td align="right" width="120"> 
												<b> <!-- 구매 내역 상태 (배송상태) --> ${orderList.orders_status }  </b> <br>
												<c:if test = "${!(orderList.orders_status eq 'cancel')}">
													<c:if test = "${orderList.orders_status eq 'processing'}">
														<input class="btn btn-sm btn-link cancel" type="button" value="취소 요청" > <br> 
													</c:if>
													<c:if test = "${orderList.orders_status eq 'in delivery'}">
														<input class="btn btn-sm btn-link contact" type="button" value="문의 하기"> <br> 
													</c:if>
													<c:if test = "${orderList.orders_status eq 'delivered'}">
														<input class="btn btn-sm btn-link cancel" type="button" value="리뷰 쓰기" > <br>  <!-- 리뷰 쓸 수 있도록 정보 넘기기 -->
													</c:if>
												</c:if>
													<a href="#payment" rel="modal:open" class="${orderList.orders_num} payment" >
														<input class="btn btn-sm btn-link payment" type="button" value="결제 정보">	
													</a>

													
											 </td>
										</tr>
										<!-- 반복 -->
									</c:forEach>		
								</c:otherwise>
							</c:choose>
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