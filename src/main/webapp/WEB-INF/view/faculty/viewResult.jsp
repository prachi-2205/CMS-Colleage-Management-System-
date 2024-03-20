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
<title>Faculty | View Result</title>
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


					<div class="row">
						<div class="col-lg-12">
							<div class="card mb-3">
								<div class="card-header"
									style="background: linear-gradient(90deg, #633e77, transparent);">
									<h5 class="text-white m-0">View Result</h5>
								</div>
								<div class="card-body">
									<fieldset>
										<div class="row">
											<div class="form-group col-2">
												<label for="cname">Exam<span style="color: red;">*</span></label>
												<select class="form-control" id="examTypeId" name="exam">
													<option disabled="disabled" selected="selected">---
														Select Exam Type ---</option>
													<option value="Mid Sem">Mid Sem</option>
													<option value="Gujarat University">Gujarat
														University</option>
												</select>
											</div>
											<div class="form-group col-3">
												<label for="cname">Degree Name<span
													style="color: red;">*</span></label> <select class="form-control"
													id="degreeId" onchange="getSemesterByDegree()">
													<option disabled="disabled" selected="selected">---
														Select Degree Name ---</option>
													<c:forEach items="${degreelist}" var="i">
														<option value="${i.id}">${i.degreeName}</option>
													</c:forEach>
												</select>

											</div>


											<div class="form-group col-3">
												<label for="cname">Semester Number<span
													style="color: red;">*</span></label> <select class="form-control"
													id="semesterId" onchange="getSubjectBySemester();">
													<option disabled="disabled" selected="selected">---
														Select Semester Number ---</option>
												</select>
											</div>

											<div class="form-group col-3">
												<label for="cname">Subject Name<span
													style="color: red;">*</span></label> <select class="form-control"
													id="subjectId">
													<option disabled="disabled" selected="selected">---
														Select Subject Name ---</option>
												</select>
											</div>
											<!-- <div class="form-group col-1">
												<input class="btn btn-primary" type="submit" value="search"
													onclick="seachResult()" style="margin-top: 16px;">
											</div>  -->

											<div class="form-group col-1">
												<button type="submit" value="search"
													class="btn btn-primary"
													onclick="seachResult()" style="margin-top: 16px;">
													<i class="mdi mdi-account-search mr-2"></i>
												</button>
											</div>
										</div>

									</fieldset>
								</div>
							</div>
						</div>
					</div>
					<div class="card">
						<div class="card-header"
							style="background: linear-gradient(90deg, #633e77, transparent);">
							<h5 class="text-white m-0">Student Result</h5>
						</div>

						<div class="card-body">
							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
										<table id="order-listinga" class="table">
											<thead>
												<tr>
													<th>No.</th>
													<th>Student Name</th>
													<th>Out of Marks</th>
													<th>Obtained Marks</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody id="studentDetails">

											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>

						<div class="card-footer">
							<div class="form-group col-12">
								<input class="btn btn-primary" type="button" value="Lock marks"
									onclick="lockMarks()">
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


		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" id="modalTitle"></h4>
					</div>
					<div class="modal-body"></div>
					<div class="modal-footer">
						<input type="button" class="btn btn-secondary"
							data-dismiss="modal" value="Close"> <input type="button"
							class="btn btn-primary" value="Save">
					</div>
				</div>

			</div>
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
			src="<%=request.getContextPath()%>/adminResources/js/toaster.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/data-table.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/validation/addResult.js"></script>
		<!-- End custom js for this page-->
</body>

</html>
