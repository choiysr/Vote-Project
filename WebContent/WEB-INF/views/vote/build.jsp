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

<title>Build</title>

<!-- Custom fonts for this template-->
<link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
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

      <div class="card o-hidden border-0 shadow-lg my-5">
         <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
               <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
               <div class="col-lg-7">
                  <div class="p-5">
                     <div class="text-center">
                        <h1 class="h4 text-gray-900 mb-4">팀 생성</h1>
                     </div>

                     <div class="form-group row">
                        <div class="col-sm-3 " style="text-align: center;">
                           <select name="teams" class="btn  dropdown-toggle"
                              style="margin-top: 5px; border: 1px solid silver;">
                              <c:forEach begin="1" end="11" var="num">
                                 <option value="${num}">${num}</option>
                              </c:forEach>
                           </select>
                        </div>
                        <button id="btn" class="btn btn-success" style="margin-top: 5px">확인</button>
                     </div>

                     <hr>

                     <div>
                        <form action="/vote/build.sr" method="POST">
                        <div id="list">
                        
                        <!-- 반복문으로 내부 값 채워줄것임 -->
                        
                        </div>
                        </form>   
                     </div>

                     <script type="text/javascript">
                        window.onload = function() {
                           var teams = document
                                 .getElementsByName("teams")
                           var btn = document.getElementById("btn")
                           var list = document.getElementById("list")
                           btn.onclick = function() {
                              var num = teams[0].selectedOptions[0].value
                              list.innerHTML = ""
                              
                              var tmpText = ""
                              tmpText += '<div class="input-group row z1">'
                              tmpText += '<div class="col-sm-4 mb-3 mb-sm-0 ">'
                              tmpText += '<input type="text" class="form-control form-control-user" placeholder="팀명" name="name">'
                              tmpText += '</div>'
                              tmpText += '<div class="col-sm-4 ">'
                              tmpText += '<input type="text" class="form-control form-control-user" placeholder="팀장" name="leader">'
                              tmpText += '</div>'
                              tmpText += '<div class="col-sm-4 z1">'
                              tmpText += '<select class="form-control form-control-user" name="max" ><option value="2">2명</option><option value="3">3명</option><option value="4">4명</option><option value="5">5명</option><option value="6">6명</option></select>'
                              tmpText += '</div>'
                              tmpText += '</div><hr>'
                              for (var i = 0; i < num; i++) {
                                 list.innerHTML += tmpText
                              }
                              list.innerHTML += '<input type="submit" value="생성" class="btn btn-success">'
                           }
                        }
                     </script>
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

</html>