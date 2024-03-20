<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BoardsterUI Admin</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/images/favicon.png" />
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
						<div class="card-body">
							<h4 class="card-title">Data table</h4>
							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
										<table id="order-listing" class="table">
											<thead>
												<tr>
													<th>Order #</th>
													<th>Purchased On</th>
													<th>Customer</th>
													<th>Ship to</th>
													<th>Base Price</th>
													<th>Purchased Price</th>
													<th>Status</th>
													<th>Actions</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>2012/08/03</td>
													<td>Edinburgh</td>
													<td>New York</td>
													<td>$1500</td>
													<td>$3200</td>
													<td><label class="badge badge-info">On hold</label></td>
													<td>
														<button class="btn btn-outline-primary">View</button>
													</td>
												</tr>
												<tr>
													<td>2</td>
													<td>2015/04/01</td>
													<td>Doe</td>
													<td>Brazil</td>
													<td>$4500</td>
													<td>$7500</td>
													<td><label class="badge badge-danger">Pending</label>
													</td>
													<td>
														<button class="btn btn-outline-primary">View</button>
													</td>
												</tr>
												<tr>
													<td>3</td>
													<td>2010/11/21</td>
													<td>Sam</td>
													<td>Tokyo</td>
													<td>$2100</td>
													<td>$6300</td>
													<td><label class="badge badge-success">Closed</label>
													</td>
													<td>
														<button class="btn btn-outline-primary">View</button>
													</td>
												</tr>
												<tr>
													<td>4</td>
													<td>2016/01/12</td>
													<td>Sam</td>
													<td>Tokyo</td>
													<td>$2100</td>
													<td>$6300</td>
													<td><label class="badge badge-success">Closed</label>
													</td>
													<td>
														<button class="btn btn-outline-primary">View</button>
													</td>
												</tr>
												<tr>
													<td>5</td>
													<td>2017/12/28</td>
													<td>Sam</td>
													<td>Tokyo</td>
													<td>$2100</td>
													<td>$6300</td>
													<td><label class="badge badge-success">Closed</label>
													</td>
													<td>
														<button class="btn btn-outline-primary">View</button>
													</td>
												</tr>
												<tr>
													<td>6</td>
													<td>2000/10/30</td>
													<td>Sam</td>
													<td>Tokyo</td>
													<td>$2100</td>
													<td>$6300</td>
													<td><label class="badge badge-info">On-hold</label></td>
													<td>
														<button class="btn btn-outline-primary">View</button>
													</td>
												</tr>
												<tr>
													<td>7</td>
													<td>2011/03/11</td>
													<td>Cris</td>
													<td>Tokyo</td>
													<td>$2100</td>
													<td>$6300</td>
													<td><label class="badge badge-success">Closed</label>
													</td>
													<td>
														<button class="btn btn-outline-primary">View</button>
													</td>
												</tr>
												<tr>
													<td>8</td>
													<td>2015/06/25</td>
													<td>Tim</td>
													<td>Italy</td>
													<td>$6300</td>
													<td>$2100</td>
													<td><label class="badge badge-info">On-hold</label></td>
													<td>
														<button class="btn btn-outline-primary">View</button>
													</td>
												</tr>
												<tr>
													<td>9</td>
													<td>2016/11/12</td>
													<td>John</td>
													<td>Tokyo</td>
													<td>$2100</td>
													<td>$6300</td>
													<td><label class="badge badge-success">Closed</label>
													</td>
													<td>
														<button class="btn btn-outline-primary">View</button>
													</td>
												</tr>
												<tr>
													<td>10</td>
													<td>2003/12/26</td>
													<td>Tom</td>
													<td>Germany</td>
													<td>$1100</td>
													<td>$2300</td>
													<td><label class="badge badge-danger">Pending</label>
													</td>
													<td>
														<button class="btn btn-outline-primary">View</button>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->
				<footer class="footer">
					<div
						class="d-sm-flex justify-content-center justify-content-sm-between">
						<span
							class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright
							© 2018 <a href="https://www.urbanui.com/" target="_blank">Urbanui</a>.
							All rights reserved.
						</span> <span
							class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted
							& made with <i class="mdi mdi-heart text-danger"></i>
						</span>
					</div>
				</footer>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.base.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.addons.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/template.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="<%=request.getContextPath()%>/adminResources/js/data-table.js"></script>
	<!-- End custom js for this page-->
</body>

</html>
