<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin | ${type}Student</title>
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
										action="saveStudent" modelAttribute="StudentVO"
										onsubmit="return addStudent()">

										<fieldset>


											<div class="row">
												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">First Name<span
															style="color: red;">*</span></label>
														<div class="col-sm-9">
															<f:input path="firstName" id="firstName" name="firstName"
																type="text" class="form-control" />
														</div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Middle Name<span
															style="color: red;">*</span></label>
														<div class="col-sm-9">
															<f:input path="middleName" id="middleName"
																name="middleName" type="text" class="form-control" />
														</div>
													</div>
												</div>
											</div>



											<div class="row">
												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Last Name<span
															style="color: red;">*</span></label>
														<div class="col-sm-9">
															<f:input path="lastName" id="lastName" name="lastName"
																type="text" class="form-control" />
														</div>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Gender<span
															style="color: red;">*</span></label>
														<div class="col-sm-4">
															<div class="form-check">
																<label class="form-check-label">Male<f:radiobutton
																		path="gender" id="gender" class="form-control"
																		name="gender" value="Male" checked="Male" /> <i
																	class="input-helper"></i></label>
															</div>
														</div>
														<div class="col-sm-5">
															<div class="form-check">
																<label class="form-check-label">Female <f:radiobutton
																		path="gender" id="gender" class="form-control"
																		name="gender" value="Female" /> <i
																	class="input-helper"></i></label>
															</div>
														</div>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Degree<span
															style="color: red;">*</span></label>
														<div class="col-sm-9">
															<f:select path="degree.id" class="form-control"
																id="degreeId" value="${degree.id}"
																onchange="getSemesterByDegree()">
																<option disabled="disabled" selected="selected">---
																	Select Degree Name ---</option>

																<!-- <option value="default" selected="selected"
																	disabled="disabled">--- Select Degree Name ---</option> -->
																<c:forEach items="${degreelist}" var="i">

																	<c:if test="${studentVO.degree.id ne  i.id}">
																		<f:option value="${i.id}">${i.degreeName}</f:option>
																	</c:if>

																</c:forEach>

															</f:select>

														</div>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Semester
															Number<span style="color: red;">*</span>
														</label>
														<div class="col-sm-9">
															<f:select path="semester.id" class="form-control"
																id="semesterId">

																<option disabled="disabled" selected="selected">---
																	Select Semester Number ---</option>

																<!-- <option value="default1">--- Select Semester
																	Number ---</option> -->

															</f:select>

														</div>
													</div>
												</div>

											</div>

											<div class="row">
												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Enrollment
															Number<span style="color: red;">*</span>
														</label>
														<div class="col-sm-9">
															<f:input path="enrollmentNo" id="enrollmentNo"
																onblur="verifyErNo()" name="enrollmentNo" type="text"
																class="form-control" />
															<span id="enrollmentNoError"
																style="margin-top: 10px; color: red;"></span>
														</div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Phone
															Number<span style="color: red;">*</span>
														</label>
														<div class="col-sm-9">
															<f:input path="phoneNo" id="phoneNo" name="phoneNo"
																type="text" class="form-control" />
														</div>
													</div>
												</div>
											</div>

											<div class="row">

												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Email</label>
														<div class="col-sm-9">
															<f:input path="loginVO.username" id="email" name="email"
																type="text" class="form-control" onblur="verifyEmail()" />
															<span id="emailError"
																style="margin-top: 10px; color: red;"></span>
														</div>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group">
														<div class="form-group row">
															<label class="col-sm-3">Address</label>
															<div class="col-sm-9">
																<f:textarea path="address" class="form-control"
																	id="address" name="address" rows="2"></f:textarea>
															</div>
														</div>
													</div>
												</div>

												<!-- <div class="col-md-6">
													<div class="form-group">
														<div class="form-group row">
															<label class="col-sm-3">Note</label>
															<div class="col-sm-9">
																<textarea class="form-control" rows="4"></textarea>
															</div>
														</div>
													</div>
												</div> -->
											</div>

											<f:hidden id="registrationId" path="id" />
											<f:hidden id="loginId" path="loginVO.id" />

											<input class="btn btn-primary" type="submit" value="${button}">
										</fieldset>
									</f:form>
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

</body>

</html>

