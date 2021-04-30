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
              <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href='<c:url value="/member/login" />'> <i class="fas fa-user-alt mr-1 text-gray"></i>Join</a></li> 
                <li class="nav-item"><a class="nav-link" href='<c:url value="/member/login" />'> <i class="fas fa-user-alt mr-1 text-gray"></i>Login</a></li>
              </ul>
            </div>
          </nav>
        </div>
      </header>