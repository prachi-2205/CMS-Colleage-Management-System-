<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin | view Academic Time-Table</title>
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
							<h5 class="text-white m-0">View Academic Time-Table</h5>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
										<table id="order-listing" class="table">
											<thead>
												<tr>
													<th>No.</th>
													<th>Degree Name</th>
													<th>Semester</th>
													<th>Academic Start Date</th>
													<th>Academic End Date</th>
													<th>TimeTable File</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${academicList}" var="i" varStatus="j">
													<tr>
														<td>${j.count }</td>
														<td>${i.degree.degreeName}</td>
														<td>${i.semester.semesterNo}</td>
														<td>${i.academicStartDate}</td>
														<td>${i.academicEndDate}</td>
														<td><a
															href="<%=request.getContextPath()%>/documents/academic/${i.fileName}"
															target="_blank">View </a> /

														<a
															href="<%=request.getContextPath()%>/documents/academic/${i.fileName}"
															download>download </a>
														</td>

														<td>
														<a href="editAcademic?id=${i.id}"> <i
																class="mdi mdi-pencil"
																style="font-size: 20px;"></i>
														</a>
														<a href="deleteAcademic?id=${i.id}"> <i
																class="mdi mdi-delete"
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
