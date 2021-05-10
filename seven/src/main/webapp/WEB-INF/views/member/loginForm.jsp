<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - Weekly Coding Challenge #1 -  Double slider Sign in/up Form - Desktop Only</title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
  <link rel="stylesheet" href='<c:url value="/resources/css/style.css" />'>

</head>
<body>
<!-- partial:index.partial.html -->
<div class="container" id="container">
	<div class="scrollBox">
	<div class="scrollCon">
	<div class="form-container sign-up-container">
		<form action='<c:url value="/member/insertPro" />' method="post">
			<h3 class="h1-ca">Create Account</h3>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-instagram"></i></a>
			</div>
			<span>or use your email for registration</span>
			<input type="text" placeholder="id" name="member_id"/>
			<input type="password" placeholder="Password" name="member_pass"/>
			<input type="text" placeholder="Name" name="member_name"/>
			<input type="email" placeholder="Email" name="member_email"/>
			<input type="text" placeholder="address" name="member_address"/>
			<input type="text" placeholder="phone" name="member_phone"/>
			<input type="text" placeholder="birth" name="member_birth"/>
			
			<button type="submit">Sign Up</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action='<c:url value="/member/loginPro" />' method="post">
			<h1 class="h1-sgn-in">Sign in</h1>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-instagram"></i></a>
			</div>
			<span>or use your account</span>
			<input type="text" placeholder="ID" name="member_id"/>
			<input type="password" placeholder="Password" name="member_pass" />
			<a href="#">Forgot your password?</a>
			<input type="submit" value="Sign In">
<!-- 			<button In</button>
		< -->/form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Welcome Back!</h1>
				<p>To keep connected with us please login with your personal info</p>
				<button class="ghost" id="signIn">Sign In</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Hello, Friend!</h1>
				<p>Enter your personal details and start journey with us</p>
				<button class="ghost" id="signUp">Sign Up</button>
			</div>
		</div>
	</div>
</div>

<!-- partial -->
  <script src='<c:url value="/resources/js/script.js" />'></script>

</body>
</html>
