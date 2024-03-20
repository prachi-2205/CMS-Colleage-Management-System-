<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en-us">
<head>
<title>Exam Timetable</title>
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

<body onload="getSemesterByDegree()">


	<jsp:include page="header.jsp"></jsp:include>

	<div class="contact_bg">
		<div class="header_title">
			<h1>Exam</h1>
			<hr class="tital_border">
		</div>
	</div>

	<div class="breadcrumb_bg">
		<div class="container">
			<ul class="breadcrumb breadcrumb-arrow">
				<li><a href="index.html">Home</a></li>
				<li class="active"><span>Timetable-Exam</span></li>
			</ul>
		</div>
	</div>

	<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

	<section></section>



	<section class="p-t-0">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<f:form action="userViewExam" method="get">


						<div class="row">
							<div class="form-group col-4">
							<label for="cname">Exam Type</label>
								<select class="form-control col-10" id="exam" name="exam">
									<option selected="selected">--- Select Exam ---</option>
									<option>Mid Sem</option>
									<option>Gujarat University</option>
								</select>
							</div>

							<div class="form-group col-4">
								<label for="cname">Degree Name</label> <select id="degreeId"
									name="degreeId" class="form-control col-10"
									onchange="getSemesterByDegree()">
									<option disabled="disabled" selected="selected">---
										Select Degree Name ---</option>
									<c:forEach items="${degreeList}" var="i">
										<c:if test="${i.id eq param.degreeId}">
											<option value="${i.id }" selected="selected">${i.degreeName }</option>
										</c:if>
										<c:if test="${i.id ne param.degreeId}">
											<option value="${i.id }">${i.degreeName }</option>
										</c:if>
									</c:forEach>
								</select>
							</div>

							<div class="form-group col-4">
								<label for="cname">Semester Number</label> <select
									id="semesterId" name="semesterId" class="form-control col-10">
									<option disabled="disabled" selected="selected">---
										Select Semester Number ---</option>
								</select>
							</div>


						</div>


						<div class="row mt-3">
							<div class="col-sm-12 text-center">
								<button type="submit" class="btn btn-default profile_btn">
									Search</button>
							</div>
						</div>

					</f:form>


					<!-- <section>
						<div class="container">
							<table class="table">
								<thead>
									<tr>
										<th>Exam</th>
										<th>Degree</th>
										<th>Semester</th>
										<th>Action</th>
									</tr>
								</thead>

								<tbody>
									<tr>
										<td>Gujarat University</td>
										<td>M.SC(CA & IT)</td>
										<td>6</td>
										<td><i class="fa fa-download"></i></td>
									</tr>
								</tbody>
							</table>
						</div>
					</section> -->

					<section>
						<div class="container">
							<table class="table">
								<thead>
									<tr>
										<th>No.</th>
										<th>Exam Type</th>
										<th>Degree</th>
										<th>Semester</th>
										<th>Action</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${examList}" var="i" varStatus="j">
										<tr>
											<td>${j.count }</td>
											<td>${i.exam}</td>
											<td>${i.degree.degreeName}</td>
											<td>${i.semester.semesterNo}</td>
											<td><a
												href="<%=request.getContextPath()%>/documents/exam/${i.fileName}"
												download> <i class="fa fa-download"></i></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</section>

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
	<script src="<%=request.getContextPath()%>/adminResources/js/validation/addResult.js"></script>
</body>
</html>