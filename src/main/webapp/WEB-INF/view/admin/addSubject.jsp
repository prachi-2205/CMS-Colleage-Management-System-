<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin | ${type}Subject</title>
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
					<div class="row grid-margin">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-header"
									style="background: linear-gradient(90deg, #633e77, transparent);">
									<h5 class="text-white m-0">${type}Subject</h5>
								</div>
								<div class="card-body">


									<%@taglib prefix="f"
										uri="http://www.springframework.org/tags/form"%>
									<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

									<f:form class="cmxform" id="subjectForm" method="post"
										action="saveSubject" modelAttribute="SubjectVO"
										onsubmit="return addSubject()">

										<fieldset>

											<div class="form-group">
												<label for="cname">Degree Name<span
													style="color: red;">*</span></label>
												<f:select path="degree.id" class="form-control"
													id="degreeId" onchange="getSemesterByDegree()">
													<option value="default" disabled="disabled"
														selected="selected">--- Select Degree Name ---</option>
													<c:forEach items="${degreelist}" var="i">
														<c:if test="${subjectVO.degree.id ne  i.id}">
															<f:option value="${i.id}">${i.degreeName}</f:option>
														</c:if>
													</c:forEach>
												</f:select>
											</div>

											<div class="form-group">
												<label for="cname">Semester Number<span
													style="color: red;">*</span></label>
												<f:select path="semester.id" class="form-control"
													id="semesterId">
													<!-- <option value="default1" selected>--- Select
														Semester Number ---</option> -->
													<option disabled="disabled" selected="selected">---
														Select Semester Number ---</option>

												</f:select>

											</div>

											<div class="row">
												<div class="form-group col-4">
													<label for="curl">Subject Name<span
														style="color: red;">*</span></label>
													<f:input path="subjectName" name="subjectName"
														id="subjectName" class="form-control" type="text" />
												</div>

												<div class="form-group col-3">
													<label for="curl">Subject Code<span
														style="color: red;">*</span></label>
													<f:input path="subjectCode" name="subjectCode"
														id="subjectCode" class="form-control" type="text" />
												</div>

												<div class="form-group col-3">
													<label for="curl">Subject Credit<span
														style="color: red;">*</span></label>
													<f:input path="subjectCredit" name="subjectCredit"
														id="subjectCredit" class="form-control" type="text" />
												</div>

												<div class="form-group col-2">
													<a class="btn btn-primary mt-4" onclick="addSub()"> <i
														class="mdi mdi-plus text-white"></i>
													</a>
												</div>

											</div>

											<div class="row" id="errorMessage"
												style="margin-bottom: 10px;"></div>


											<div class="table-responsive" id="tebDiv"
												style="display: none">
												<table class="table">

													<thead>
														<tr>
															<th>No.</th>
															<th>Subject Name</th>
															<th>Subject Code</th>
															<th>Subject Credit</th>
														</tr>
													</thead>

													<tbody id="subjectTable"></tbody>

												</table>
											</div>


											<f:hidden path="id" />

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

	<script
		src="<%=request.getContextPath()%>/adminResources/js/custom/addSubject.js"></script>
	<!-- End custom js for this page-->
	<!-- validation -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.toast.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/toaster.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/validation/addSubject.js"></script>

</body>

</html>

