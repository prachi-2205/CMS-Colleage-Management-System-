<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin | View Subject</title>
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
									<h5 class="text-white m-0">View Subject</h5>
								</div>
						<div class="card-body">
							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
										<%@taglib prefix="c"
										uri="http://java.sun.com/jstl/core_rt"%>
									
										<table id="order-listing" class="table">
											<thead>
												<tr>
													<th>No.</th>
													<th>Degree</th>
													<th>Semester Number</th>
													<th>Subject Name</th>
													<th>Subject Code</th>
													<th>Subject Credit</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach items="${subjectList}" var="i" varStatus="j">
											
												<tr>
													<td>${j.count}</td>
													<td>${i.degree.degreeName}</td>
													<td>${i.semester.semesterNo}</td>
													<td>${i.subjectName}</td>
													<td>${i.subjectCode}</td>
													<td>${i.subjectCredit}</td>
													
													
													<td><a href="editSubject?id=${i.id}"> <i class="mdi mdi-pencil"
															style="font-size: 20px;"></i>
													</a> <a href="deleteSubject?id=${i.id}"> <i class="mdi mdi-delete"
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
