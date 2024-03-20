<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin | ${type}Form</title>
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
									<h5 class="text-white m-0">${type}Form</h5>
								</div>

								<div class="card-body">
									<%@taglib prefix="f"
										uri="http://www.springframework.org/tags/form"%>

									<f:form class="cmxform" id="formForm" method="post"
										action="saveForm" modelAttribute="FormVO"
										enctype="multipart/form-data" onsubmit="return addForm()">
										<fieldset>
											<div class="row">

												<div class="col-md-12">
													<div class="form-group">
														<label for="year">Form Name<span
															style="color: red;">*</span></label>
														<f:input path="formName" id="formName"
															class="form-control" name="formName" type="text" />
													</div>

													<div class="form-group">
														<label for="year">Notes<span style="color: red;">*</span></label>
														<f:input path="notes" id="notes" class="form-control"
															name="notes" type="text" />
													</div>
												</div>

												<div class="form-group col-12">
													<label>Upload Form<span style="color: red;">*</span></label>
													<input type="file" name="file" class="file-upload-default">
													<div class="input-group col-xs-12">
														<input type="text" id="fileName"
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

											<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
											<%@taglib prefix="f1"
												uri="http://java.sun.com/jsp/jstl/functions"%>
											<c:if test="${f1:length(FormVO.fileName) ne ''}">

												<div class="form-group col-12">
													<a
														href="<%=request.getContextPath()%>/documents/form/${FormVO.fileName}"
														target="_blank"> <img
														src="<%=request.getContextPath()%>/adminResources/images/pdf.jfif"
														alt="${FormVO.fileName}" height="50px" width="50px">
													</a>
												</div>
												<div class="form-group col-12">${FormVO.fileName}</div>
											</c:if>

											<input class="btn btn-primary" type="submit"
												value="${button}">
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
		src="<%=request.getContextPath()%>/adminResources/js/validation/addForm.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/file-upload.js"></script>
	<!-- End custom js for this page-->
</body>

</html>

