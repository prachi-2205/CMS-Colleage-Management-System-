<%@page import="com.project.utils.BaseMethods"%>
<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
	<div
		class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
		<a class="navbar-brand brand-logo" href="index"> <img
			src="<%=request.getContextPath()%>/adminResources/images/logo.jpg"
			alt="logo" /></a><a class="navbar-brand brand-logo-mini"
			href="index.html"><img
			src="<%=request.getContextPath()%>/adminResources/images/logo2.svg"
			alt="logo" /> </a>
	</div>

	<div
		class="navbar-menu-wrapper d-flex align-items-center justify-content-end justify-content-lg-start">
		<button class="navbar-toggler navbar-toggler align-self-center"
			type="button" data-toggle="minimize">
			<span class="mdi mdi-menu"></span>
		</button>

		<ul class="navbar-nav navbar-nav-right">

			<li class="nav-item nav-profile dropdown"><a
				class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
				id="profileDropdown"> <img
					src="<%=request.getContextPath()%>/adminResources/images/face5.jpg"
					alt="profile" /> <span class="nav-profile-name"><%=BaseMethods.getUsername()%></span>
			</a>
				<div class="dropdown-menu dropdown-menu-right navbar-dropdown"
					aria-labelledby="profileDropdown">
					<a href="/logout" class="dropdown-item"> <i
						class="mdi mdi-logout text-primary"></i> Logout
					</a>
				</div></li>

		</ul>
	</div>
</nav>