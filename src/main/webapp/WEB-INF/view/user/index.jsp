<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en-us">
<head>
<title>Index</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/userResource/images/fave.png"
	type="image/x-icon" />

	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
<meta http-equiv="content-language" content="en-us">
<meta http-equiv="content-type" content="text/HTML" charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="robots" content="noindex, follow" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description"
	content=" Study point is a theme which is well organised and easy to understand. The templates layout are easy to modify or customize for your web pages. Templates are used various purpose such as website, business, corporate, portfolio, etc. Browse for unique HTML/CSS  Themes. Powerful site template design in a clean and minimalistic style. study point theme templates by Crescent Theme exclusive on themeforest.">
<meta property="og:description"
	content="Best education html Theme for educational, training center, education center, university, college, kindergarten, courses hub and academy." />
<meta name="keywords"
	content="education theme, education, best education, html, html templates, css templates, css, website templates, blogger template, studypoint, study-point, study, study point, school, teaching, Responsive, Landing, Bootstrap, Bootstrap 4,Template, school layout, school template ">
<meta property="og:title"
	content="Study Point - Creative Multi-Purpose Education Theme" />
<meta name="author" content="Crescent-Theme">
<meta name="copyright" content="copyright 2019 Crescent Theme">

<link
	href="<%=request.getContextPath()%>/userResource/css/bootstrap.min.css"
	rel="stylesheet" />

<link
	href="<%=request.getContextPath()%>/userResource/css/font-awesome.css"
	rel="stylesheet" />

<link
	href="<%=request.getContextPath()%>/userResource/css/custom-font.css"
	rel="stylesheet" />

<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap"
	rel="stylesheet">

<link
	href="<%=request.getContextPath()%>/userResource/css/owl.carousel.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/userResource/css/owl.theme.css"
	rel="stylesheet" />

<link
	href="<%=request.getContextPath()%>/userResource/css/navigation.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/userResource/css/preloader.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/userResource/css/style.css"
	rel="stylesheet" />

<link
	href="<%=request.getContextPath()%>/userResource/css/responsive.css"
	rel="stylesheet" />
</head>

<body data-spy="scroll" data-target=".navbar" data-offset="50"
	class="home">

	<jsp:include page="header.jsp"></jsp:include>

	<section class="banner text-center p-0">
		<div class="container-fulid">
			<div id="banner-slider" class="owl-carousel owl-theme">
				<div class="banner-slide d-flex align-items-center"
					style="background-image: url(<%=request.getContextPath()%>/userResource/images/banner-1.png)">
					<div class="banner-text w-100">
						<h1>Bright Future</h1>
					</div>
				</div>
				<div class="banner-slide d-flex align-items-center"
					style="background-image: url(<%=request.getContextPath()%>/userResource/images/banner-2.png)">
					<div class="banner-text w-100">
						<h1>Open the World of Opportunies!</h1>
					</div>
				</div>
				<div class="banner-slide d-flex align-items-center"
					style="background-image: url(<%=request.getContextPath()%>/userResource/images/banner-3.png)">
					<div class="banner-text w-100">
						<h1>Open the World of Opportunies!</h1>
					</div>
				</div>
				<div class="banner-slide d-flex align-items-center"
					style="background-image: url(<%=request.getContextPath()%>/userResource/images/banner-4.png)">
					<div class="banner-text w-100">
						<h1>Open the World of Opportunies!</h1>
					</div>
				</div>
			</div>
		</div>
	</section>


	<section>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6">
					<div class="page_tital text-center">
						<h2>Welcome to University</h2>
						<hr class="tital_border">
						<p>Our Courses</p>
					</div>
				</div>
			</div>
			<div class="row mt-4 text-center">
				<c:forEach items="${degreeList}" var="i">

					<div class="col-md-4">
						<div class="study_block">
							<div class="icon_block">
								<i class="fa fa-graduation-cap"></i>
							</div>
							<div class="study_info mt-4">
								<h3>${i.degreeName}</h3>
								<p>${i.designation}</p>
								<p>Duration : ${i.duration} Year</p>
								<a href="viewCourseDetails?id=${i.id}"
									class="btn btn-default profile_btn read_more">Read More</a>
							</div>
						</div>
					</div>
				</c:forEach>


			</div>
		</div>
	</section>


	<section class="register_bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12">
					<div class="register_now">
						<h2>
							COACHING & TRAINING BY <br />PROFESSIONAL
						</h2>
						<div class="right_icon">
							<i class="fa fa-hand-o-right"></i> Assignment
						</div>
						<div class="right_icon">
							<i class="fa fa-hand-o-right"></i> Timetable
						</div>
						<div class="right_icon">
							<i class="fa fa-hand-o-right"></i> Teacher
						</div>
						<div class="right_icon">
							<i class="fa fa-hand-o-right"></i> Result
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>
	
		<section class="register_bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="counter_text">
						<i class="fa fa-users"></i>
						<h1 class="counter-count">${studentCount}</h1>
						<h4>STUDENTS</h4>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="counter_text">
						<i class="fa fa-book"></i>
						<h1 class="counter-count">${facultyCount}</h1>
						<h4>CERTIFIED TEACHERS</h4>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="counter_text">
						<i class="fa fa-trophy"></i>
						<h1 class="counter-count">${degreeCount}</h1>
						<h4>DEGREES</h4>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="counter_text">
						<i class="fa fa-university"></i>
						<h1 class="counter-count">155</h1>
						<h4>student enrolled</h4>
					</div>
				</div>
			</div>
		</div>
	</section>











	<jsp:include page="footer.jsp"></jsp:include>
	<a class="btn btn-lg  scrollup"><i class="fa fa-arrow-up"></i></a>

	<script
		src="<%=request.getContextPath()%>/userResource/js/jquery.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/userResource/js/bootstrap.min.js"></script>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/userResource/js/jquery.countdown.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/userResource/js/owl.carousel.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/userResource/js/jquery.magnific-popup.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/userResource/js/mobilemenu.js"></script>
	<script src="<%=request.getContextPath()%>/userResource/js/custom.js"></script>
</body>
</html>
