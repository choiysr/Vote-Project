<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>welcome</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<c:url value="/Resource/css/sb-admin-2.min.css"/>" rel="stylesheet">

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
               <div class="col-lg-6 d-lg-flex"
               style='background-image:url("https://cdn1.vectorstock.com/i/1000x1000/52/70/push-the-red-button-nuclear-vector-14545270.jpg"); background-size: 700px; background-position: center;' ><!-- class="col-lg-6 d-none d-lg-block bg-vote-image" --> 
          <!--      <img  class="col-lg-5 d-none d-lg-inline" src="https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fspecials-images.forbesimg.com%2Fdam%2Fimageserve%2F1063184564%2F960x0.jpg%3Ffit%3Dscale"/> -->
               </div> 
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">${param.target}이/가 지원했습니다.</h1>
                    <h6 class="h7 text-gray-900 mb-4">만장일치 시 팀원이 됩니다.</h6>
                  </div>
                  
                  <form class="user" action="/vote/vote.sr" method="POST">
                    <div class="form-group">
                      <input type="hidden" name="t_id" value="${param.t_id}">
                      <input type="hidden" name="target" value="${param.target}" > <p style="text-align: center; font-size: 30px;">찬성: 
                      <input style="font-size: 30px; width: 25px; height: 25px" type="radio" name="vote"  value="Y"></p>
                       <p style="text-align: center; font-size: 30px">반대: 
                       <input style="font-size: 30px; width: 25px; height: 25px" type="radio" name="vote"  value="N"></p>
                    </div>
                   <button class="btn btn-primary btn-user btn-block">투표</button>
                  </form>
                  <hr>
                  
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
