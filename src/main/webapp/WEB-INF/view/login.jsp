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
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div
				class="content-wrapper d-flex align-items-stretch auth auth-img-bg">
				<div class="row flex-grow">
					<div
						class="col-lg-6 d-flex align-items-center justify-content-center">
						<div class="auth-form-transparent text-left p-3">
							<div class="brand-logo">
								<img src="adminResources/images/logo2.svg" alt="logo"> <font
									color="indigo"><b> --- Bright Future --- </b></font>
							</div>
							<h4 class="text-center m-3">Login</h4>

							<form class="pt-3" method="post" action="j_spring_security_check">
								<div class="form-group">
									<label for="exampleInputEmail">Username</label>
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-account-outline text-primary"></i>
											</span>
										</div>
										<input type="email" name="username"
											class="form-control form-control-lg border-left-0"
											id="exampleInputEmail" placeholder="Username">
									</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword">Password</label>
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-lock-outline text-primary"></i>
											</span>
										</div>
										<input type="password" name="password"
											class="form-control form-control-lg border-left-0"
											id="exampleInputPassword" placeholder="Password">
									</div>
									<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
									<c:if test="${set eq 'con'}">
										<span style="color: darkviolet;" id="Emailerror"><h4>YOUR
												PASSWORD CHANGE SUCCESSFULLY...</h4> </span>
									</c:if>
								</div>
								<!-- <div class="my-2 d-flex justify-content-between align-items-center">
                  <div class="form-check">
                    <label class="form-check-label text-muted">
                      <input type="checkbox" class="form-check-input">
                      Keep me signed in
                    </label>
                  </div>
                  <a href="#" class="auth-link text-black">Forgot password?</a>
                </div> -->
								<div class="my-3">
									<input type="submit" value="LOGIN"
										class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">
								</div>
								<a href="forgetpw" title="" class="forget_pass"><font
									color="purple">Forget Password ?</font></a>

							</form>
						</div>
					</div>
					<div class="col-lg-6 login-half-bg d-flex flex-row">
						<p
							class="text-white font-weight-medium text-center flex-grow align-self-end">Copyright
							&copy; 2022 Bright Future College. All rights reserved</p>
					</div>
				</div>
			</div>
			<!-- content-wrapper ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
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
