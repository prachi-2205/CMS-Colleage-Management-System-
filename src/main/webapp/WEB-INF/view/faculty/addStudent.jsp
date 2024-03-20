<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Faculty | ${type} Student</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.addons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/jquery.toast.min.css">
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
		<!-- partial:../../partials/_navbar.html -->

		<jsp:include page="header.jsp"></jsp:include>


		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:../../partials/_sidebar.html -->

			<jsp:include page="menu.jsp"></jsp:include>

			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-header"
									style="background: linear-gradient(90deg, #633e77, transparent);">
									<h5 class="text-white m-0">${type}Student</h5>
								</div>
								<div class="card-body">

									<%@taglib prefix="f"
										uri="http://www.springframework.org/tags/form"%>
									<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
									<f:form class="cmxform" id="studentForm" method="post"
										enctype="multipart/form-data" action="saveStudent"
										modelAttribute="StudentVO"
										onsubmit="return addStudentFaculty()">

										<fieldset>

											<div class="row">

												<div class="form-group col-12">
													<label for="cname">Degree Name<span
														style="color: red;">*</span></label>
													<f:select path="degree.id" class="form-control"
														id="degreeId" name="degreeId" value="${degree.id}"
														onchange="getSemesterByDegree()">

														<option value="default" selected="selected"
															disabled="disabled">--- Select Degree Name ---</option>
														<c:forEach items="${degreelist}" var="i">

															<c:if test="${studentVO.degree.id ne  i.id}">
																<f:option value="${i.id}">${i.degreeName}</f:option>
															</c:if>

														</c:forEach>

													</f:select>

												</div>



												<div class="form-group col-12">
													<label for="cname">Semester Number<span
														style="color: red;">*</span></label>
													<f:select path="semester.id" class="form-control"
														id="semesterId" name="semesterId" value="${semester.id}">

														<option value="default1">--- Select Semester
															Number ---</option>

													</f:select>

												</div>

												<div class="form-group col-12">
													<label>Upload Student List<span style="color: red;">*</span></label>
													<input type="file" name="file" class="file-upload-default">
													<div class="input-group col-xs-12">
														<input type="text" id="fileName" name="file"
															class="form-control file-upload-info" disabled
															placeholder="Upload Pdf
															"> <span
															class="input-group-append">
															<button class="file-upload-browse btn btn-primary"
																type="button">Upload</button>
														</span>
													</div>
												</div>

											</div>
											<f:hidden path="id" />
											<f:hidden path="loginVO.id" />
											<input class="btn btn-primary" type="submit" value="${type}">
										</fieldset>
									</f:form>
								</div>
							</div>
						</div>
					</div>

					<%@taglib prefix="z" uri="http://java.sun.com/jsp/jstl/functions"%>

					<c:if test="${z:length(studentList) gt 0}">
						<div class="row">
							<div class="col-lg-12">
								<div class="card">
									<div class="card-body">
										<h5>Following students are not registered as mentioned
											reason.</h5>

										<c:forEach items="${studentList}" var="i">
											<li>${i}</li>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</c:if>
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
		src="<%=request.getContextPath()%>/adminResources/js/validation/addStudent.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/file-upload.js"></script>

</body>

</html>

