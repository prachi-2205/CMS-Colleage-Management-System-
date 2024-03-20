<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet" href="adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="adminResources/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="adminResources/images/logo2.svg" />
</head>

<body>
	<section>
		<div class="container page-body-wrapper">
			<div class="content-wrapper auth auth-img-bg">
				<div class="row justify-content-center align-items-center">
					<div class="col-lg-7">
						<div class="auth-form-transparent text-left p-3">
							<div class="alert alert-success" role="alert">CORRECRT OTP</div>

							<form class="pt-3" method="post" action="ChangePassword">
								<div class="form-group">
									<label for="exampleInputEmail">New Password</label>
									<div class="input-group">
										<div class="input-group-prepend bg-transparent ">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-account-outline text-primary"></i>
											</span>
										</div>
										<input required="required" type="text" name="newpassword"
											class="form-control form-control-lg border-left-0"
											id="exampleInputEmail" placeholder="Enter New Password Here">
									</div>
								</div>

								<div class="my-3">
									<input type="submit" value="Verify"
										class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="adminResources/js/vendor.bundle.base.js"></script>
	<script src="adminResources/js/vendor.bundle.addons.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script src="adminResources/js/off-canvas.js"></script>
	<script src="adminResources/js/hoverable-collapse.js"></script>
	<script src="adminResources/js/template.js"></script>
	<script src="adminResources/js/settings.js"></script>
	<script src="adminResources/js/todolist.js"></script>
	<!-- endinject -->
</body>

</html>
