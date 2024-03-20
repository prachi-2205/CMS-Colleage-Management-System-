<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html lang="en-us">
<head>
<title>Student | View Assignment</title>
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

	<div class="header_bg">
		<div class="header_title">
			<h1>${degreeVO.degreeName}</h1>
			<hr class="tital_border">
		</div>
	</div>

	<div class="breadcrumb_bg">
		<div class="container">
			<ul class="breadcrumb breadcrumb-arrow">
				<li><a href="index">Home</a></li>
				<li class="active"><span>Course &nbsp : </span></li>
				<li class="active"><span>${degreeVO.degreeName}</span></li>
			</ul>
		</div>
	</div>

	<section>

		<p>
		<h2>
			<center>${degreeVO.degreeName}'sAllSemAssignment</center>
		</h2>
		</p>

		<div class="container">
			<div class="row text-center">

				<c:forEach items="${semesterList}" var="i">

					<div class="col-md-4">
						<div class="study_block">
							<div class="icon_block">
								<i class="fa fa-pencil"></i>
							</div>
							<div class="study_info mt-4">
								<h4>Sem : ${i.semesterNo } (${i.semesterTime} Months)</h4>

								<p>
									<c:forEach items="${subjectList}" var="k">
										<c:if test="${i.id eq k.semester.id }">
											<li>${k.subjectName}<i class="fa fa-download"></i> <%-- <a
												href="<%=request.getContextPath()%>/documents/assignment/${i.fileName}"
												download> <i class="fa fa-download"></i></a> --%></li>
										</c:if>
									</c:forEach>
								</p>

							</div>
						</div>
					</div>
				</c:forEach>
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