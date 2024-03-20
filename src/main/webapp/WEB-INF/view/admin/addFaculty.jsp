<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin | ${type}Faculty</title>
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
									<h5 class="text-white m-0">${type}Faculty</h5>
								</div>

								<div class="card-body">
									<%@taglib prefix="f"
										uri="http://www.springframework.org/tags/form"%>

									<f:form class="cmxform" id="facultyForm" method="post"
										action="saveFaculty" modelAttribute="FacultyVO"
										enctype="multipart/form-data" onsubmit="return addFaculty()">
										<fieldset>
											<div class="row">
												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">First Name<span
															style="color: red;">*</span></label>
														<div class="col-sm-9">
															<f:input path="firstName" id="firstName"
																class="form-control" name="firstName" type="text" />
														</div>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Last Name<span
															style="color: red;">*</span></label>
														<div class="col-sm-9">
															<f:input path="lastName" id="lastName"
																class="form-control" name="lastName" type="text" />
														</div>
													</div>
												</div>

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
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Phone No<span
															style="color: red;">*</span></label>
														<div class="col-sm-9">
															<f:input path="phoneNumber" id="phoneNumber"
																class="form-control" name="phoneNumber" type="text" />
														</div>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Gender<span
															style="color: red;">*</span></label>
														<div class="col-sm-4">
															<div class="form-check">
																<label class="form-check-label">Male <f:radiobutton
																		path="gender" id="gender" class="form-control"
																		name="gender" value="Male" checked="Male" /> <i
																	class="input-helper"></i>
																</label>
															</div>
														</div>
														<div class="col-sm-5">
															<div class="form-check">
																<label class="form-check-label"> Female <f:radiobutton
																		path="gender" id="gender" class="form-control"
																		name="gender" value="Female" /><i
																	class="input-helper"></i></label>
															</div>
														</div>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Status<span
															style="color: red;">*</span></label>
														<div class="col-sm-4">
															<div class="form-check">
																<label class="form-check-label"> Tenure <f:radiobutton
																		path="status1" id="status1" class="form-control"
																		name="status1" value="Tenure" checked="Tenure" /> <i
																	class="input-helper"></i>
																</label>
															</div>
														</div>
														<div class="col-sm-5">
															<div class="form-check">
																<label class="form-check-label"> Permanent <f:radiobutton
																		path="status1" id="status1" class="form-control"
																		name="status1" value="Permanent" /> <!-- <input type="radio"
																	class="form-check-input" name="membershipRadio"
																	id="membershipRadios4" value="option2">
																	Permanent --> <i class="input-helper"></i>
																</label>
															</div>
														</div>

													</div>
												</div>


												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Degree<span
															style="color: red;">*</span></label>
														<div class="col-sm-9">
															<f:input path="degree" id="degree" class="form-control"
																name="degree" type="text" />
														</div>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Designation<span
															style="color: red;">*</span></label>
														<div class="col-sm-9">
															<f:input path="designation" id="designation"
																class="form-control" name="designation" type="text" />
														</div>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Address</label>
														<div class="col-sm-9">
															<f:textarea path="address" class="form-control"
																id="address" name="address" rows="4"></f:textarea>
														</div>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group row">
														<label class="col-sm-3 col-form-label">Notes</label>
														<div class="col-sm-9">
															<textarea class="form-control" rows="4"></textarea>
														</div>
													</div>
												</div>

												<div class="form-group col-12">
													<label>Upload Your Photo<span style="color: red;">*</span></label>
													<input type="file" name="file" class="file-upload-default">
													<div class="input-group col-xs-12">
														<input type="text" id="fileName"
															class="form-control file-upload-info" disabled
															placeholder="Upload photo"> <span
															class="input-group-append">
															<button class="file-upload-browse btn btn-primary"
																type="button">Upload</button>
														</span>
													</div>
												</div>

												<f:hidden path="id" />
												<f:hidden id="registrationId" path="id" />
												<f:hidden id="loginId" path="loginVO.id" />

												<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
												<%@taglib prefix="f1"
													uri="http://java.sun.com/jsp/jstl/functions"%>
												<c:if test="${f1:length(FacultyVO.fileName) ne ''}">

													<div class="form-group col-12">
														<a
															href="<%=request.getContextPath()%>/documents/faculty/${FacultyVO.fileName}"
															target="_blank"> <img
															src="<%=request.getContextPath()%>/documents/faculty/${FacultyVO.fileName}"
															alt="${FacultyVO.fileName}" height="50px" width="50px">
														</a>
													</div>
													<div class="form-group col-12">${FacultyVO.fileName}</div>
												</c:if>

												<div class="form-group col-12">
													<input class="btn btn-primary" type="submit"
														value="${button}">
												</div>



											</div>





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

	<!-- validation -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.toast.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/toaster.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/validation/addFaculty.js"></script>
	<!-- End custom js for this page-->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/file-upload.js"></script>
</body>

</html>

