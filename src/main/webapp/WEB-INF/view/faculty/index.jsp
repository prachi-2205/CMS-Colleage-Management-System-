<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Faculty | Index</title>
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
					<div class="card">
						<div class="card-header">
							<div class="row">
								<div class="col-6">
									<h3 class="text-muted">About Faculty Protal</h3>
									<p class="text-justify text-muted">Performance evaluation
										of faculty members in higher education is a serious challenge
										for management. Several qualitative and quantitative factors
										are considered leading to targeted professional growth of an
										organization to evaluate the performance, such as acquiring
										research grants, research profile, student evaluation,
										publications, academic responsibilities etc. However, to
										quantify such information is a difficult task. We use faculty
										portal to overcome this hurdle. The performance based
										evaluation system is made available to all faculty member to
										upload there academic activities done throughout the academic
										year.</p>

									<!-- <p class="text-justify text-muted">When I first got into
										the online advertising business, I was looking for the magical
										combination that would put my website into the top search
										engine rankings When I first got into the online advertising
										business, I was looking for the magical combination that would
										put my website into the top search engine rankings When I
										first got into the online advertising business, I was looking
										for the magical combination that would put my website into the
										top search engine rankings</p> -->
								</div>





								<div class="col-6">
									<img
										src="<%=request.getContextPath()%>/adminResources/images/faculty.jpg"
										alt="" class="rounded mw-100">
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.html -->

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
	<!-- Plugin js for this page-->
	<!-- End plugin js for this page-->
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
		src="<%=request.getContextPath()%>/adminResources/js/dashboard.js"></script>
	<!-- End custom js for this page-->
</body>

</html>

