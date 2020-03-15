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

<title>Join</title>

<!-- Custom fonts for this template-->
<link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
   type="text/css">
<link
   href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
   rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value="/Resource/css/sb-admin-2.min.css"/>"
   rel="stylesheet">

 <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>


<body id="page-top">

   <!-- Page Wrapper -->
   <div id="wrapper">


      <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">

         <!-- Main Content -->
         <div id="content">

            <!-- Topbar -->
            <nav
               class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
               <p style="margin-top: 15px; margin-right: 50px; ">${member.name}님 환영합니다!!!!</p>
               <a class="btn btn-google" href="/member/logout.sr">로그아웃</a>
               <button class="btn btn-google" onclick="location.href='/vote/build.sr'" style="display:${member.admin != 'Y'? 'none':'block'}" ;>팀 생성</button>
            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

               <!-- Page Heading -->
               <h1 class="h3 mb-1 text-gray-800">팀 지원 및 현황</h1>
               <p class="mb-4">낙장불입</p>

               <!-- Content Row -->
               <div class="row">

                  <%-- <c:forEach  items="${teamlist}" var="team"  >
         <form action="" method="post">
            <p>-----------------${cnt}팀---------------------------</p>
            <h2>팀명: ${team.name}</h2>
            <h2>팀장: ${team.leader}</h2>
            <h2>현재팀원 수: ${team.length}</h2>
            <h2>지원 가능 여부: <button onclick="location.href="#">${team.applyCheck}</button>    </h2>
            <input   type="submit" value="확인">
         </form> 
      </c:forEach>--%>

                  <%-- <!-- Border Left Utilities -->
                  <c:forEach items="${list}" var="team">
                     <form action="/vote/apply.sr" method="POST">
                        <div class="col-lg-6">
                           <div class="card mb-4 py-3 border-left-warning">
                              <h2>팀명: ${team.name}</h2>
                              <c:forEach items="${team.members}" var="mem">
                                 <c:if test="${mem.auth != 'N'}">
                                    <h2>${mem.auth == 'L' ? '팀장' : (mem.auth == 'S' ? '부팀장' : '') }
                                       : ${mem.name}</h2>
                                 </c:if>
                              </c:forEach>
                              <h2>지원 가능 여부: ${team.state=='P' ? '지원가능' : '모집마감'}</h2>
                              <input class="btn btn-success" type="submit" value="지원">
                           </div>
                        </div>
                     </form>
                  </c:forEach> --%>

                  <div class="col-lg-12">
                     <c:forEach items="${list}" var="team">
                        <div class="card mb-4 py-3 border-left-warning">
                           <div class="card-body">
                              <form action="/vote/apply.sr" method="POST" name="checkfrm"  onsubmit="return check();">
                                 <h4>팀명: ${team.name}</h4>
                                 <c:forEach items="${team.members}" var="mem">
                                    <c:if test="${mem.auth != 'N'}">
                                       <h6>${mem.auth == 'L' ? '팀장' : (mem.auth == 'S' ? '부팀장' : '') }
                                          : ${mem.name}</h6>
                                    </c:if>
                                 </c:forEach>
                                    <h6 id="state">지원 가능 여부: ${team.state=='P' ? '지원가능' : '지원불가'}</h6>
                                 <input type="hidden" name="t_id" value="${team.t_id}" >
                                 <input class="btn btn-success" 
                                 ${team.state=='P' ? '' : "disabled = 'disabled'"}
                                 type="submit" value="${team.state=='P' ? '지원' : '현재는 지원이 불가능 합니다.'}">
                              </form>
                           </div>
                        </div>
                     </c:forEach>
                  </div>


                  <!-- <div class="card mb-4 py-3 border-left-warning">
                        <div class="card-body">
                        
                        </div>
                     </div> -->
                  <!-- /.container-fluid -->
               </div>
               <!-- End of Main Content -->

               <!-- Footer -->
               <footer class="sticky-footer bg-white">
                  <div class="container my-auto">
                     <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2019</span>
                     </div>
                  </div>
               </footer>
               <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

         </div>
         <!-- End of Page Wrapper -->

         <!-- Scroll to Top Button-->
         <a class="scroll-to-top rounded" href="#page-top"> <i
            class="fas fa-angle-up"></i>
         </a>

         <!-- Logout Modal-->
         <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
            aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
               <div class="modal-content">
                  <div class="modal-header">
                     <h5 class="modal-title" id="exampleModalLabel">Ready to
                        Leave?</h5>
                     <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                        <span aria-hidden="true">×</span>
                     </button>
                  </div>
                  <div class="modal-body">Select "Logout" below if you are
                     ready to end your current session.</div>
                  <div class="modal-footer">
                     <button class="btn btn-secondary" type="button"
                        data-dismiss="modal">Cancel</button>
                     <a class="btn btn-primary" href="login.html">Logout</a>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   <script type="text/javascript">

   
      function check() {
      if (confirm("정말 지원하시겠습니까?") == true){    //확인
          document.checkfrm.submit();
      return true;
      }else{   //취소
          return false;
      }
   }
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