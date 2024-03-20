<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Faculty | ${type} Result</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/jquery.toast.min.css">
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
		<!-- partial:../../partials/_navbar.html -->

		<jsp:include page="header.jsp"></jsp:include>


		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:../../partials/_sidebar.html -->

			<jsp:include page="menu.jsp"></jsp:include>

			<!-- partial -->
			<div class="main-panel">
				<f:form class="cmxform" id="ResultForm" method="post"
					action="saveResult" modelAttribute="ResultVO"
					enctype="multipart/form-data" onsubmit="return addResult()">
					<div class="content-wrapper">
						<div class="row">
							<div class="col-lg-12">
								<div class="card mb-3">
									<div class="card-header"
										style="background: linear-gradient(90deg, #633e77, transparent);">
										<h5 class="text-white m-0">${type}Result</h5>
									</div>
									<div class="card-body">


										<fieldset>

											<div class="row">

												<div class="form-group col-6">
													<label for="cname">Exam<span style="color: red;">*</span></label>
													<f:select class="form-control" id="exam" path="exam"
														name="exam">
														<option disabled="disabled" selected="selected">---
															Select Exam Type ---</option>
														<f:option value="Mid Sem">Mid Sem</f:option>
														<f:option value="Gujarat University">Gujarat University</f:option>
													</f:select>
												</div>

												<div class="form-group col-6">
													<label for="cname">Out of Marks<span
														style="color: red;">*</span>&nbsp&nbsp&nbsp&nbsp&nbsp(Min
														= 1 ,Max = 100)
													</label> <input type="number" class="form-control" min="1"
														max="100" id="totalMarks" name="totalMarks">
												</div>


												<div class="form-group col-4">
													<label for="cname">Degree Name<span
														style="color: red;">*</span></label>
													<f:select path="degree.id" class="form-control"
														id="degreeId" onchange="getSemesterByDegree()">
														<option disabled="disabled" selected="selected">---
															Select Degree Name ---</option>
														<c:forEach items="${degreelist}" var="i">
															<c:if test="${resultVO.degree.id ne  i.id}">
																<f:option value="${i.id}">${i.degreeName}</f:option>
															</c:if>
														</c:forEach>
													</f:select>

												</div>


												<div class="form-group col-4">
													<label for="cname">Semester Number<span
														style="color: red;">*</span></label>
													<f:select path="semester.id" class="form-control"
														id="semesterId"
														onchange="getSubjectBySemester(); getStudentByDegreeAndSemester();">
														<option disabled="disabled" selected="selected">---
															Select Semester Number ---</option>
													</f:select>
												</div>

												<div class="form-group col-4">
													<label for="cname">Subject Name<span
														style="color: red;">*</span></label>
													<f:select path="subject.id" class="form-control"
														id="subjectId">
														<option disabled="disabled" selected="selected">---
															Select Subject Name ---</option>
													</f:select>
												</div>

												<f:hidden path="id" />
											</div>
										</fieldset>

									</div>
								</div>

							</div>
						</div>


						<div class="card">
							<div class="card-header"
								style="background: linear-gradient(90deg, #633e77, transparent);">
								<h5 class="text-white m-0">Add Student Result</h5>
							</div>

							<div class="card-body">
								<div class="row">
									<div class="col-12">
										<div class="table-responsive">
											<table id="order-listing" class="table">
												<thead>
													<tr>
														<th>No.</th>
														<th>Student Name</th>
														<th>Out of Marks</th>
														<th>Obtained Marks</th>
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
									<input class="btn btn-primary" type="submit" value="${button}">
								</div>
							</div>

						</div>
					</div>



					<jsp:include page="footer.jsp"></jsp:include>

				</f:form>
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
		src="<%=request.getContextPath()%>/adminResources/js/form-validation.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/bt-maxLength.js"></script>
	<!-- End custom js for this page-->
	<!-- validation -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.toast.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/toaster.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/validation/addResult.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/file-upload.js"></script>
</body>

</html>