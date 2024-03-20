<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Faculty | ${type} Assignment</title>
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

<body onload="getSemesterByDegree(${AssignmentVO.semester.id})">
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
									<h5 class="text-white m-0">${type}Assignment</h5>
								</div>
								<div class="card-body">
									<%@taglib prefix="f"
										uri="http://www.springframework.org/tags/form"%>
									<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

									<f:form class="cmxform" id="AssignmentForm" method="post"
										action="saveAssignment" modelAttribute="AssignmentVO"
										enctype="multipart/form-data"
										onsubmit="return uploadAssignment()">


										<fieldset>

											<div class="row">
												<div class="form-group col-6">
													<label for="cname">Degree Name<span
														style="color: red;">*</span></label>
													<f:select path="degree.id" class="form-control"
														id="degreeId" onchange="getSemesterByDegree()">
														<option disabled="disabled" selected="selected">---
															Select Degree Name ---</option>
														<c:forEach items="${degreelist}" var="i">
															<f:option value="${i.id}">${i.degreeName}</f:option>
														</c:forEach>
													</f:select>
												</div>


												<div class="form-group col-6">
													<label for="cname">Semester Number<span
														style="color: red;">*</span></label>
													<f:select path="semester.id" class="form-control"
														id="semesterId" onchange="getSubjectBySemester()">
														<option disabled="disabled" selected="selected">---
															Select Semester Number ---</option>
													</f:select>
												</div>

												<div class="form-group col-12">
													<label for="cname">Subject Name<span
														style="color: red;">*</span></label>
													<f:select path="subject.id" class="form-control"
														id="subjectId">
														<option disabled="disabled" selected="selected">---
															Select Subject Name ---</option>
													</f:select>
												</div>


												<div class="form-group col-12">
													<label for="cname"> Name<span style="color: red;">*</span></label>
													<f:input path="assignmentName" class="form-control"
														id="assignmentName" />
												</div>

												<div class="form-group col-12">
													<label>Upload Assignment<span style="color: red;">*</span></label>
													<input type="file" name="file" class="file-upload-default">
													<div class="input-group col-xs-12">
														<input type="text" id="fileName"
															class="form-control file-upload-info" disabled
															placeholder="Upload Pdf"> <span
															class="input-group-append">
															<button class="file-upload-browse btn btn-primary"
																type="button">Upload</button>
														</span>
													</div>
												</div>

												<f:hidden path="id" />

												<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
												<%@taglib prefix="f1"
													uri="http://java.sun.com/jsp/jstl/functions"%>

												<c:if test="${f1:length(AssignmentVO.fileName) ne ''}">

													<div class="form-group col-12">
														<a
															href="<%=request.getContextPath()%>/documents/assignment/${AssignmentVO.fileName}"
															target="_blank"> <img
															src="<%=request.getContextPath()%>/adminResources/images/pdf.jfif"
															alt="${AssignmentVO.fileName}" height="50px" width="50px">
														</a>
													</div>
													<div class="form-group col-12">${AssignmentVO.fileName}</div>
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
	<!-- End custom js for this page-->
	<!-- validation -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.toast.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/toaster.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/validation/uploadAssignment.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/file-upload.js"></script>

</body>

</html>

