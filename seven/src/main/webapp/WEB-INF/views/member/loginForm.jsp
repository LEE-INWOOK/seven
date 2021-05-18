<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - Weekly Coding Challenge #1 -  Double slider Sign in/up Form - Desktop Only</title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
  <link rel="stylesheet" href='<c:url value="/resources/css/style.css" />'>
  <link rel="stylesheet" href='<c:url value="/resources/css/loginForm.css" />'>
	<script src='<c:url value="/resources/script/jquery-3.6.0.js" />'></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script type="text/javascript">
	 
	
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }

    Kakao.init("a9031795cba5d1391493de5e3f12cd29");//javascript 키값
	Kakao.Auth.createLoginButton({//카카오 로그인 버튼 생성
		container : "#kakao-btn",//해당하는 카카오로그인 버튼을 어느위치에 넣어줄 건지
		success : function(authObj){//성공 시
			/*
			alert(authObj)
			console.log('버튼 생성 및 로그인 성공 시 출력 : '+JSON.stringify(authObj))
			*/
			Kakao.API.request({//로그인 성공 시 사용자에 대한 정보 얻어오겠다
				url:'/v2/user/me',//카카오에 대한 경로이므로 그대로 사용
				success: function(res){//res로 결과값 받아옴
					alert(JSON.stringify(res))
					console.log('아이디 : '+res.id);
					console.log('이메일 : '+res.kaccount_email);
					console.log('닉네임 : '+res.properties['nickname']);
					console.log('토큰 값 : '+authObj.access_token);
				}, fail: function(err){
					alert(JSON.stringify(err))
				}
			})
		}, fail : function(err){//실패 시
			alert(JSON.stringify(err))
		}
	});



    
    
    
    
	

	$(document).ready(function(){
		$('#fr2').submit(function(){
			if($('#id').val()==""){
				alert("아이디 입력하세요");
				$('#id').focus();
				return false;
			}
			
			if($('#pass').val()==""){
				alert("비밀번호 입력하세요");
				$('#pass').focus();
				return false;
			}
			
			if($('#name').val()==""){
				alert("이름 입력하세요");
				$('#name').focus();
				return false;
			}
			
			if($('#email').val()==""){
				alert("이메일 입력하세요");
				$('#email').focus();
				return false;
			}
			
			if($('#sample6_address').val()==""){
				alert("주소 입력하세요");
				$('sample6_address').focus();
				return false;
			}
			
			
			if($('#phone').val()==""){
				alert("전화번호 입력하세요");
				$('#phone').focus();
				return false;
			}
			
		

			
		});
		
 	});
	
	
	
	
	</script>
</head>
<body>
<!-- partial:index.partial.html -->
<div class="container" id="container">
	<div class="scrollBox">
	<div class="scrollCon">
	<div class="form-container sign-up-container">
		<form action='<c:url value="/member/insertPro"/>' method="post" style="display: block;"  id="fr2">
			<h3 class="h1-ca">Create Account</h3>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-instagram"></i></a>
			</div>
<!-- 			<span>or use your email for registration</span> -->
			<input type="text" placeholder="id" name="member_id" id="id"/>
			<input type="password" placeholder="Password" name="member_pass" id="pass"/>
			<input type="text" placeholder="Name" name="member_name" id="name"/>
			<input type="email" placeholder="Email" name="member_email" id="email"/> 
			<input type="text" id="sample6_postcode" placeholder="우편번호" name="member_zipcode" class="post-01">
			<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="post-02">
			<input type="text" id="sample6_address" placeholder="주소" name="member_address"><br>
			<input type="text" id="sample6_detailAddress" placeholder="상세주소" name="member_address2">
			<input type="text" id="sample6_extraAddress" placeholder="참고항목" >
			 
			<input type="text" placeholder="phone" name="member_phone" id="phone"/>
<!-- 			<input type="text" placeholder="birth" name="member_birth"/> -->







			
			<button type="submit" class="sgn-btn">Sign Up</button>
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
			<input type="text" placeholder="ID" name="member_id" id="id"/>
			<input type="password" placeholder="Password" name="member_pass" id="pass"/>
			<a href="#">Forgot your password?</a>
	<button type="submit">Sign In</button>
	<a
	
	
					href="https://kauth.kakao.com/oauth/authorize?client_id=6f69b5e903d7c674d99dd28f3eb28ee5&redirect_uri=http://localhost:8080/root/success&response_type=code"


					>
					<img width="180px" src="resources/img/kakao_login_small.png">
					
	
				</a>


		</form>
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
