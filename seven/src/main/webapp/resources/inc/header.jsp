<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <header class="header bg-white">
        <div class="container px-0 px-lg-3">
          <nav class="navbar navbar-expand-lg navbar-light py-3 px-lg-0"><a class="navbar-brand" href='<c:url value="/" />'><span class="font-weight-bold text-uppercase text-dark">Boutique</span></a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                  <!-- Link--><a class="nav-link" href='<c:url value="/" />'>Home</a>
                </li>
                <li class="nav-item">
                  <!-- Link--><a class="nav-link" href='<c:url value="/product/shop" />'>Shop</a>
                </li>
                <li class="nav-item"><a class="nav-link" href='<c:url value="/product/wish" />'> <i class="far fa-heart mr-1">Wish</i><small class="text-gray">(0)</small></a></li>             
                <li class="nav-item"><a class="nav-link" href='<c:url value="/product/cart" />'> <i class="fas fa-dolly-flatbed mr-1 text-gray"></i>Cart<small class="text-gray">(2)</small></a></li>
              </ul>
              
<c:choose>
	<c:when test="${empty sessionScope.id}">					<!-- 세션값이 없으면 -->
	</c:when>
	<c:otherwise>												<!-- 세션값이 없지 않으면 = 있으면 -->
		<c:if test="${!(sessionScope.id eq 'admin')}">			<!-- 그 세션값이 admin과 일치하지 않으면 -->
		</c:if>	
	</c:otherwise>
</c:choose>
              
              <c:choose>
              <!-- 로그인하지 않았을 때 ↓ -->
              <c:when test="${empty sessionScope.id}">
              <ul class="navbar-nav ml-auto">              
                <li class="nav-item"><a class="nav-link" href='<c:url value="/member/login" />'> <i class="fas fa-user-alt mr-1 text-gray"></i>Login | Join</a></li>
              </ul>
             </c:when>
              <!-- 로그인하지 않았을 때 ↑ -->
              
              <!-- 로그인했을 때 ↓ -->
              <c:otherwise>
              	<c:if test=${!empty sessionScope.id}>
             		${sessionScope.id} 님
              		<ul class="navbar-nav ml-auto">              
                		<li class="nav-item"><a class="nav-link" href='<c:url value="/member/logout" />'> <i class="fas fa-user-alt mr-1 text-gray"></i>Logout</a></li>
             		</ul>
              	</c:if>
              
              	<!-- 로그인 한 아이디가 'admin'일 때 ↓ -->
              	<c:if test="${sesssionScope.id eq 'admin'}">
              	</c:if>
              	<!-- 로그인 한 아이디가 'admin'일 때 ↑ -->
              	
             </c:otherwise>
              <!-- 로그인했을 때 ↑ -->
             </c:choose>
            </div>
          </nav>
        </div>
      </header>