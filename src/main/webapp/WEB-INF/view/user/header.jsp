<%@page import="com.project.utils.BaseMethods"%>
<div id="loader-wrapper">
	<div id="loader"></div>
	<div class="loader-section section-left"></div>
	<div class="loader-section section-right"></div>
</div>

<header id="header" class="header_1 header_2">
	<div class="toolbar d-none d-lg-block">
		<div class="container"></div>
	</div>
	<div class="study_nav">
		<div class="container">
			<nav class="navbar navbar-expand-md navbar-light bg-faded mb-0 ">
				<a class="navbar-brand" href="index" style="margin-left: -90px;"><img
					src="<%=request.getContextPath()%>/userResource/images/logo1.png"
					alt="Main Logo"></a>
				<div class="collapse navbar-collapse main-menu"
					id="navbarSupportedContent">
					<ul class="navbar-nav nav lavalamp ml-auto menu main_menu">
						<li class="nav-item single_nav menu-item"><a href="index"
							class="nav-link">Home</a></li>

						<li class="nav-item single_nav"><a href="viewCourses"
							class="nav-link dropdown_icon">Courses</a></li>


						<li class="nav-item single_nav"><a href="teacher"
							class="nav-link dropdown_icon">Teachers</a></li>

						<li class="nav-item single_nav"><a href="assignment"
							class="nav-link">Assignment</a></li>

						<li class="nav-item single_nav"><a href="javascript:void(0)"
							class="nav-link">Timetable</a>
							<ul class="navbar-nav nav mx-auto">
								<li class="nav-item"><a href="academic" class="nav-link">Academic</a></li>
								<li class="nav-item"><a href="exam" class="nav-link">Exam</a></li>
							</ul></li>

						<li class="nav-item single_nav"><a href="result"
							class="nav-link">Result</a></li>

						<li class="nav-item single_nav"><a href="form"
							class="nav-link">Form</a></li>

						<li class="nav-item single_nav"><a href="/logout"
							class="nav-link">Logout</a></li>
							
						<li class="nav-item single_nav"><a href="password"
							class="nav-link">Change-Password</a></li>

						
						<p><h4> &emsp;&emsp;&emsp;&emsp;&emsp; Welcome,</h4></p>
						<p><B><h4><font color="red">&ensp;<%=BaseMethods.getUsername()%>..!!</font></h4></B></p>
						

					</ul>
				</div>
			</nav>

		</div>
	</div>
</header>
