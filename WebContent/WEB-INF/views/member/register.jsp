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

  <title>Join</title>
   
  <!-- Custom fonts for this template-->
  <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
 <link href="<c:url value="/Resource/css/sb-admin-2.min.css"/>" rel="stylesheet">

 
   <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>

<body class="bg-gradient-primary">

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">회원가입</h1>
              </div>
              <form class="user" action="" method="POST">
                <div class="form-group row">
                </div>
                <div class="form-group">
                     <input type="text" name="id" class="form-control form-control-user" id="exampleInputEmail" placeholder="아이디를 입력하세요." required>
                   <button style="margin-top: 14px;" onclick="check()" class="btn btn-success btn-user btn-block">중복확인</button>
                </div>
                <div class="form-group">
                  <input type="text" name="name" class="form-control form-control-user" id="exampleInputEmail" placeholder="이름을 입력하세요" required>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="password" name="pw" class="form-control form-control-user" id="pwd1" placeholder="비밀번호를 입력하세요." required>
                  </div>
                  <div class="col-sm-6">
                    <input type="password" name="check_pw" class="form-control form-control-user" id="pwd2" placeholder="비밀번호를 다시 입력하세요" required>
                  </div>
                </div>
                <button class="btn btn-google btn-user btn-block" onclick="return register()" id="submit">회원가입</button>
                <hr>
                 </form>
                <div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div> 
                <div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
  
  <!--check regist	action 설정..... regist의 경우 check가 true일때만 눌릴수 있게 만들어야됨 -->
  <script type="text/javascript"> 
     $(document).ready(function(){
     $("#alert-success").hide(); 
   $("#alert-danger").hide(); $("input").keyup(function(){
      var pwd1=$("#pwd1").val(); 
      var pwd2=$("#pwd2").val(); 
      if(pwd1 != "" || pwd2 != ""){ 
         if(pwd1 == pwd2){ 
            $("#alert-success").show(); 
            $("#alert-danger").hide(); 
            $("#submit").removeAttr("disabled"); 
         }else{ 
            $("#alert-success").hide(); 
            $("#alert-danger").show(); 
            $("#submit").attr("disabled", "disabled"); 
         } 
        } 
     }); 
   }); 
  </script>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

</body>

</html>