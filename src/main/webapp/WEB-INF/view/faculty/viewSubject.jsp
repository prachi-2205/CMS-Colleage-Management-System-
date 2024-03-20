<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Faculty | View Subject</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/adminResources/images/logo2.svg" />
</head>

<body onload="getSemesterByDegree()">
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

					<div class="card mb-3">
						<div class="card-header"
							style="background: linear-gradient(90deg, #633e77, transparent);">
							<h5 class="text-white m-0">Find Subject</h5>
						</div>
						<div class="card-body">

							<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

							<form action="viewSubject" method="get">
								<div class="row">
									<select id="degreeId" name="degreeId"
										class="form-control col-4 ml-5" onchange="getSemesterByDegree()">
										<option disabled="disabled" selected="selected">Select
											Degree</option>
										<c:forEach items="${degreeList}" var="i">

											<c:if test="${i.id eq param.degreeId}">
												<option value="${i.id }" selected="selected">${i.degreeName }</option>
											</c:if>
											<c:if test="${i.id ne param.degreeId}">
												<option value="${i.id }">${i.degreeName }</option>
											</c:if>
										</c:forEach>


									</select> <select id="semesterId" name="semesterId"
										class="form-control col-4 ml-5">
										<option disabled="disabled" selected="selected">Select
											Semester</option>
									</select> <button type="submit" class="btn btn-primary col-1 ml-5 pl-3"><i class="mdi mdi-account-search mr-2"></i>Find</button>
								</div>
							</form>

						</div>
					</div>

					<div class="card">
						<div class="card-header"
							style="background: linear-gradient(90deg, #633e77, transparent);">
							<h5 class="text-white m-0">Subject Details</h5>
						</div>

						<div class="card-body">
							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
										<table id="order-listing" class="table">
											<thead>
												<tr>
													<th>N0.</th>
													<th>Subject Name</th>
													<th>Subject Code</th>
													<th>Credit</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${subjectList}" var="i" varStatus="j">
													<tr>
														<td>${j.count}</td>
														<td>${i.subjectName}</td>
														<td>${i.subjectCode}</td>
														<td>${i.subjectCredit}</td>
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
	<script
		src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.base.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.addons.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/template.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/data-table.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/custom/student.js"></script>

	<!-- End custom js for this page-->
</body>

</html>
