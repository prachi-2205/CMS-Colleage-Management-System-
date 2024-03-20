<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin | Index</title>
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

			<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">

					<div class="row mb-2">
						<h3 class="text-muted">
							<font color="DarkBlue">Bright Future</font>
						</h3>
					</div>

					<div class="row">
						<div class="col-lg-4 col-md-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<div
										class="d-flex justify-content-between flex-wrap align-items-center">
										<div
											class="img-sm bg-primary rounded-md d-flex align-items-center justify-content-center text-white">
											<i class="mdi mdi-school icon-md"></i>
										</div>
										<div class="text-right text-md-center text-lg-left ml-lg-4">
											<h1 class="font-weight-bold mb-0">${degreeCount}</h1>
											<p class="mb-0">Courses</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<div
										class="d-flex justify-content-between flex-wrap align-items-center">
										<div
											class="img-sm bg-danger rounded-md d-flex align-items-center justify-content-center text-white">
											<i class="mdi mdi-account-card-details icon-md"></i>
										</div>
										<div class="text-right text-md-center text-lg-left ml-lg-4">
											<h1 class="font-weight-bold mb-0">${facultyCount}</h1>
											<p class="mb-0">Faculties</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<div
										class="d-flex justify-content-between flex-wrap align-items-center">
										<div
											class="img-sm bg-warning rounded-md d-flex align-items-center justify-content-center text-white">
											<i class="mdi mdi-account-multiple icon-md"></i>
										</div>
										<div class="text-right text-md-center text-lg-left ml-lg-4">
											<h1 class="font-weight-bold mb-0">${studentCount}</h1>
											<p class="mb-0">Students</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">

							<div class="card">
								<div id="container"></div>
							</div>

							<c:forEach items="${list}" var="i">
								<c:forEach items="${i}" var="k" varStatus="j">
									<c:if test="${j.count%2 eq 0 }">
										<input type="hidden" name="xvalue" value="${k}">
									</c:if>
									<c:if test="${j.count%2 ne 0}">
										<input type="hidden" name="yvalue" value="${k}">
									</c:if>
								</c:forEach>
							</c:forEach>

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
	<script
		src="<%=request.getContextPath()%>/adminResources/js/highcharts.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/exporting.js"></script>
	<script>
		var xvalue = document.getElementsByName("xvalue");
		var xdata = [];
		var yvalue = document.getElementsByName("yvalue");
		var ydata = [];
		for (var i = 0; i < xvalue.length; i++) {
			xdata.push(xvalue[i].value);
			ydata.push(parseFloat(yvalue[i].value));
		}
		Highcharts.chart({
			chart : {
				renderTo : "container",
				type : 'column'
			},
			title : {
				text : 'Student count per degree'
			},
			xAxis : {
				categories : xdata,
				crosshair : true
			},
			yAxis : {
				min : 0,
				title : {
					text : 'Number of students'
				}
			},
			plotOptions : {
				column : {
					pointPadding : 0.2,
					borderWidth : 0
				}
			},
			series : [ {
				name : 'Degree',
				data : ydata,
				color : '#633e77'

			} ]
		});
	</script>

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

