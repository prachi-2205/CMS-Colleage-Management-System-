<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en-us">
<head>
<title>Study Point - Creative Multi-Purpose Education Theme</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/userResource/images/fave.png"
	type="image/x-icon" />


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
	content=" Study point is a theme which is well organised and easy to understand. The templates layout are easy to modify or customize for your web pages.  Templates are used various purpose such as website, business, corporate, portfolio, etc. Browse for unique HTML/CSS  Themes. Powerful site template design in a clean and minimalistic style. study point theme templates by Crescent Theme exclusive on themeforest.">
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

	<div class="contact_bg">
		<div class="header_title">
			<h1>contact us</h1>
			<hr class="tital_border">
		</div>
	</div>

	<div class="breadcrumb_bg">
		<div class="container">
			<ul class="breadcrumb breadcrumb-arrow">
				<li><a href="index.html">Home</a></li>
				<li class="active"><span>Contact Us</span></li>
			</ul>
		</div>
	</div>

	<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

	<f:form class="cmxform" id="ContactForm" method="Get"
		action="userContact">


		<section>
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="page_tital">
							<h2>Contact Info</h2>
							<hr class="tital_border m-l-0">
							<div class="row m-t-30">
								<div class="col-sm-12">
									<div class="icon_box">
										<div class="map_icon">
											<i class="fa fa-map-marker "></i>
										</div>
										<div class="map_text">
											<h4>Postal Address Of Bright Future</h4>
											<p>Los angelena,california US.</p>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 col-sm-12">
									<div class="icon_box">
										<div class="map_icon">
											<i class="fa fa-phone"></i>
										</div>
										<div class="map_text">
											<h4>Phone:</h4>
											<p>+8 (800) 659-2684</p>
										</div>
									</div>
								</div>
								<div class="col-md-6 col-sm-12">
									<div class="icon_box">
										<div class="map_icon">

											<i class="fa fa-envelope"></i>
										</div>

										<div class="map_text">
											<h4>Email</h4>
											<p>
											<h6>noreply.cmsproject@gmail.com</h6>
											</p>
										</div>
									</div>
								</div>
							</div>
							<!-- <div class="row">
								<div class="col-md-6 col-sm-12">
									<div class="icon_box">
										<div class="map_icon">
											<i class="fa fa-skype"></i>
										</div>
										<div class="map_text">
											<h4>Skype</h4>
											<p>venesamarry</p>
										</div>
									</div>
								</div>
								<div class="col-md-6 col-sm-12">
									<div class="icon_box">
										<div class="map_icon">
											<i class="fa fa-globe"></i>
										</div>
										<div class="map_text">
											<h4>Web</h4>
											<p>visioninfotech.com</p>
										</div>
									</div>
								</div>
							</div> -->
						</div>
					</div>
					<div class="col-sm-6">
						<h2>Location On Map</h2>
						<hr class="tital_border m-l-0">
						<div class="m-t-30">
							<iframe class="btn-block"
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d26373534.241211608!2d-113.75932335512329!3d36.204849821363645!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x54eab584e432360b%3A0x1c3bb99243deb742!2sUnited+States!5e0!3m2!1sen!2sin!4v1494055865833"
								height="220" style="border: 0" allowfullscreen></iframe>
						</div>
					</div>
				</div>
			</div>
		</section>
		<section class="p-t-0">
			<div class="container">
				<div class="row">
					<%-- <div class="col-md-8 col-sm-12">
						<h2>Feedback</h2>
						<hr class="tital_border m-l-0">
						<div class="contact_form1 w-100 mr-auto ml-auto m-t-30">
							<form method="post" class="w-100">
								<div class="row">
									<div class="col-sm-6 ">
										<input type="text" placeholder="Name" id="name"
											class="form-control" required>
									</div>
									<div class="col-sm-6">
										<input type="email" placeholder="Email" id="email"
											class="form-control" required>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 ">
										<div class="form-group">
											<textarea placeholder="Message" id="comment" rows="5"
												class="form-control form_message" required></textarea>
										</div>
										<button type="submit" class="btn btn-default profile_btn">
											submit now</button>
									</div>
								</div>
							</form>
						</div>
					</div> --%>
					<div class="col-sm-12 col-md-4">
						<div class="contact_us1">
							<h4>Your Contact</h4>
							<hr class="tital_border_tow m-l-0">
							<div class="row">
								<div class="col-xs-3 col-sm-2 col-md-5 col-3">
									<div class="custom_hover_img">
										<img class="img-responsive" alt="contact"
											src="<%=request.getContextPath()%>/userResource/images/pau.jpg">
									</div>
								</div>
								<div class="col-xs-9 col-sm-10 col-md-7 col-9">
									<h5 class="post_text">
										<a href="teacher-profile.html">Pauravi Parmar</a>
									</h5>
									<p>Head of communications</p>
									<span>Phone : <a href="tel:8141494321"> +91 -
											8141494321</a></span> <br /> <span>Email : <a
										href="mailto:pauravi.237@gmail.com">pauravi.237@gmail.com</a></span><br />
									<!-- <span>Skype : <a href="javascript:void(0)">
											edithwilliams</a></span> -->
								</div>
							</div>
							<div class="row m-t-30">
								<div class="col-xs-3 col-sm-2 col-md-5 col-3">
									<div class="custom_hover_img">
										<img class="img-responsive" alt="post1"
											src="<%=request.getContextPath()%>/userResource/images/prachi.jpg">
									</div>
								</div>
								<div class="col-xs-9 col-sm-10 col-md-7 col-9">
									<h5 class="post_text">
										<a href="teacher-profile.html">Prachi Patel </a>
									</h5>
									<p>Head of technology development</p>
									<span>Phone : <a href="tel:9537440763">
											+91 - 9537440763</a></span><br /> <span>Email : <a
										href="mailto:prachippatel1211@gmail.com">prachippatel1211@gmail.com</a></span><br />
									<!-- <span>Skype : <a href="javascript:void(0)">
											venesamarry</a></span> -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</f:form>

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