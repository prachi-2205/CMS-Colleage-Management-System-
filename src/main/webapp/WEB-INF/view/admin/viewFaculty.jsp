<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin | View Faculty</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/images/logo2.svg" />
</head>

<body>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->



		<jsp:include page="header.jsp"></jsp:include>



		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->


			<jsp:include page="menu.jsp"></jsp:include>


			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="card">
						<div class="card-header"
							style="background: linear-gradient(90deg, #633e77, transparent);">
							<h5 class="text-white m-0">View Faculty</h5>
						</div>
						<div class="card-body">
							<h4 class="card-title">Faculty table</h4>
							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
									<%@taglib prefix="c"
										uri="http://java.sun.com/jstl/core_rt"%>
									
										<table id="order-listing" class="table">
											<thead>
												<tr>
													<th>No</th>
													<th>First Name</th>
													<th>Last Name</th>
													<th>E-mail</th>
													<th>Phone no.</th>
													<th>Gender</th>
													<th>Status</th>
													<th>Degree</th>
													<th>Designation</th>
													<th>Address</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach items="${facultyList}" var="i" varStatus="j">
												<tr>
													<td>${j.count}</td>
													<td>${i.firstName}</td>
													<td>${i.lastName}</td>
													<td>${i.loginVO.username}</td>
													<td>${i.phoneNumber}</td>
													<td>${i.gender}</td>
													<td>${i.status1}</td>
													<td>${i.degree}</td>
													<td>${i.designation}</td>
													<td>${i.address}</td>
													<td><a href="editFaculty?id=${i.id}"> <i class="mdi mdi-pencil"
															style="font-size: 20px;"></i>
													</a> <a href="deleteFaculty?id=${i.id}&loginId=${i.loginVO.id}"> <i class="mdi mdi-delete"
															style="font-size: 20px; margin-left: 15px; color: #f54747;"></i>
													</a></td>
												</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->
				<jsp:include page="footer.jsp"></jsp:include>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.base.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.addons.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/template.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="<%=request.getContextPath()%>/adminResources/js/data-table.js"></script>
	<!-- End custom js for this page-->
</body>

</html>
