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
<style>
.error {
	color: red
}
</style>
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
								<img
									src="<%=request.getContextPath()%>/adminResources/images/logo2.svg"
									alt="logo"> <font color="indigo"><b> ---
										Bright Future --- </b></font>
							</div>
							<h4 class="text-center m-3">Change Password</h4>
							<!--  <h6 class="font-weight-light">Happy to see you again!</h6> -->

							<%@taglib prefix="f"
								uri="http://www.springframework.org/tags/form"%>
							<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

							<f:form class="pt-3" id="ContactForm" method="post"
								onsubmit="return changePassword()" action="savechangepassword">


								<div class="form-group">
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-lock-outline text-primary"></i>
											</span>
										</div>

										<input type="password" placeholder="Enter Old Password"
											id="oldpassword" class="form-control" name="oldpassword">
										<c:if test="${check eq 'wrong'}">
											<span style="color: red;" id="oldPasswordError">your
												old password is not match</span>
										</c:if>

									</div>
								</div>

								<div class="form-group">
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-lock-outline text-primary"></i>
											</span>
										</div>

										<input type="password" placeholder="Enter New Password"
											id="newpassword" class="form-control" name="newpassword">
										<span style="color: red;" id="newPasswordError"></span>


									</div>
								</div>


								<div class="form-group">
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-lock-outline text-primary"></i>
											</span>
										</div>


										<input type="password" placeholder="Confrim Your Passsword"
											id="confirmpassword" class="form-control"
											name="confirmpassword"> <span style="color: red;"
											id="confirmPasswordError"></span>

									</div>
								</div>
								<div class="my-3">
									<input type="submit" value="Update"
										class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">
								</div>
								</form>
							</f:form>
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
	<!-- 	<script type="text/javascript">
		function checkchange() {

			alert("i m in");
			var getspan2 = document.getElementById("setnewp");
			var getspan3 = document.getElementById("setconp");
			/* var checkemp1 = document.getElementById("exampleInputPassword"); */
			var newPassword = document.getElementById("setnewpass");
			var confirmPassword = document.getElementById("conpass");

			if (newPassword.value === "" || confirmPassword.value === "") {
				alert("i m in first if");
				return false;

			} else {
				alert("i m in else false")
				getspan2.innerHTML = "both password must be same!!!!!";
				getspan3.innerHTML = "both password must be same!!!!!";
				return false;
			}
		}
	</script> -->

	<!-- <script type="text/javascript">
		$(document).ready(function() {

			$('#changePassword').validate({ // initialize the plugin
				rules : {
					getoldpassword : {
						required : true,
					},
					newpassword : {
						required : true,
						minlength : 8
					},
					confirmpassword : {
						required : true,
						equalTo : "#newpass"
					}
				},
				errorElement : 'span'
			});

		});
	</script> -->


	<script type="text/javascript">
		function changePassword() {
			var oldpassword = document.getElementById("oldpassword");
			var newpassword = document.getElementById("newpassword");
			var confirmpassword = document.getElementById("confirmpassword");

			var oldPasswordError = document.getElementById("oldPasswordError");
			var newPasswordError = document.getElementById("newPasswordError");
			var confirmPasswordError = document
					.getElementById("confirmPasswordError");

			if (oldpassword.value === "") {
				oldPasswordError.innerHTML = "Please Enter Old Password";
				return false;
			} else {
				oldPasswordError.innerHTML = "";
			}

			if (newpassword.value === "") {
				newPasswordError.innerHTML = "Please Enter New Password";
				return false;
			} else {
				newPasswordError.innerHTML = "";
			}

			if (confirmpassword.value === "") {
				confirmPasswordError.innerHTML = "Please Enter Confirm Password";
				return false;
			} else if (newpassword.value !== confirmpassword.value) {
				confirmPasswordError.innerHTML = "Please Enter valid Confirm Password";
				return false;
			} else {
				confirmPasswordError.style.display = "none";
			}

		}
	</script>
</body>

</html>
