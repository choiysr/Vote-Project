<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>welcome</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
   type="text/css">
<link
   href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
   rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value="/Resource/css/sb-admin-2.min.css"/>"
   rel="stylesheet">

</head>

<body class="bg-gradient-primary">

   <div class="container">

      <!-- Outer Row -->
      <div class="row justify-content-center">

         <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
               <div class="card-body p-0">
                  <!-- Nested Row within Card Body -->
                  <div class="row">
                     <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                     <div class="col-lg-6">
                        <div class="p-5">
                           <div class="text-center">
                              <h1 class="h4 text-gray-900 mb-4">로그인이 필요합니다</h1>
                           </div>
                           <form class="user" method="POST">
                              <div class="form-group">
                                 <input type="text" name="id"
                                    class="form-control form-control-user"
                                    id="exampleInputEmail" aria-describedby="emailHelp"
                                    placeholder="아이디를 입력하세요">
                              </div>
                              <div class="form-group">
                                 <input type="password" name="pw"
                                    class="form-control form-control-user"
                                    id="exampleInputPassword" placeholder="비밀번호를 입력하세요">
                              </div>
                              <button onclick="location.href='/member/login'"
                                 class="btn btn-primary btn-user btn-block">로그인</button>
                              <a href="/member/register.sr"
                                 class="btn btn-google btn-user btn-block"> 회원가입 </a>
                           </form>
                           <hr>
                           <div class="alert alert-danger" id="alert-id" 
                           <c:if test="${msg ne 'iderr'}">style="display: none;"</c:if>>존재하지 않는 아이디입니다</div>
                           
                           <div class="alert alert-danger" id="alert-pw"
                           <c:if test="${msg ne 'pwerr'}">style="display: none;"</c:if>>비밀번호가 일치하지 않습니다</div>

                        </div>
                     </div>
                  </div>
               </div>
            </div>

         </div>

      </div>

   </div>
   
   <!-- Bootstrap core JavaScript-->
   <script src="vendor/jquery/jquery.min.js"></script>
   <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

   <!-- Core plugin JavaScript-->
   <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

   <!-- Custom scripts for all pages-->
   <script src="js/sb-admin-2.min.js"></script>

</body>