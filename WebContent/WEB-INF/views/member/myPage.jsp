<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>

<style>

.table_left {

background-color: lightgray;

width: 100px;
text-align: center;

}

</style>

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

         <div class="col-xl-10 col-lg-12 col-md-9" style="text-align: center">

            <div class="card o-hidden border-0 shadow-lg my-5" style="width: 80%; display: inline-block;s ">
               <div class="card-body p-0" >
               <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h5 style="text-align: left;" class="m-0 font-weight-bold text-primary">Team Information</h5>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <tr>
                      <th class ="table_left"><b>팀명</b></th>
                      <th>${team.name}</th>
                    </tr>
                    <c:forEach var="mem" items="${team.members}">
                      <c:if test="${mem.auth=='L'}">
                     <tr>
                      <th class ="table_left"><b>팀장</b></th>
                      <th>${mem.name}</th>
                    </tr>
                      </c:if>
                      <c:if test="${mem.auth=='S'}">
                     <tr>
                      <th class ="table_left"><b>부팀장</b></th>
                      <th>${mem.name}</th>
                    </tr>
                      </c:if>
                    <c:if test="${mem.auth=='X'}">
                     <tr>
                      <th class ="table_left"><b>팀원</b></th>
                      <th>${mem.name}</th>
                    </tr>
                    </c:if>
                  </c:forEach>
                     <tr>
                      <th class ="table_left" ><b>지원자</b></th>
                      <th id="applierPlace">${team.applier}</th> 
                    </tr>   
                </table>
              </div>
            </div>
          </div>
   <button onclick="location.href='/member/logout.sr'" class="btn btn-success btn-user btn-block">로그아웃</button>
   <button onclick="location.href='/member/탈퇴하기.sr'" class="btn btn-google btn-user btn-block" style="margin-top: 0px">탈퇴하기</button>
   <form action="/vote/vote.sr" method="GET">
         <input type="hidden" name="t_id" value="${team.t_id}" >
         <input type="hidden" name="target" value="${team.applier}" >
         
         <button id="goVote" ${vote == 'R' ? '' : "disabled = 'disabled'"} class="btn btn-success btn-user btn-block">투표하러가기</button>
   </form>
        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

               </div>
            </div>

         </div>

      </div>

   </div>
   
   <script type="text/javascript">
    $(document).ready(function(){
/*        $("#goVote").hide();  */
       var applierPlace=$("#applierPlace");
       var bt = document.getElementById('goVote');
       if(applierPlace[0].innerText=="") {
          bt.innerText="현재 지원자가 없습니다";
          $("#goVote").attr("disabled", "disabled"); 
/*           $("#goVote").show();  */
       }
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