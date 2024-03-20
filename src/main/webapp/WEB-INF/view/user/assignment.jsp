<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html lang="en-us">
<head>
<title>Student | Assignment</title>
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

	<div class="event_bg">
		<div class="header_title">
			<h1>
				<font color="black">Assignments</font>
			</h1>
			<hr class="tital_border">
		</div>
	</div>

	<div class="breadcrumb_bg">
		<div class="container">
			<ul class="breadcrumb breadcrumb-arrow">
				<li><a href="index.html">Home</a></li>
				<li class="active"><span>Assignments</span></li>
			</ul>
		</div>
	</div>

	<section>
		<div class="container">

			<div class="row">
				<div class="col-sm-12">
					<div class="page_tital">
						<h2>Assignments</h2>
						<hr class="tital_border m-l-0">
					</div>
				</div>
			</div>

			<div class="row text-center">

				<c:forEach items="${degreeList}" var="k">

					<div class="col-md-4" style="margin-top: 15px;">
						<div class="study_block">
							<div class="icon_block">
								<i class="fa fa-book"></i>
							</div>
							<div class="study_info mt-4">
								<h3>${k.key}</h3>

								<c:forEach items="${k.value}" var="i" varStatus="j">
									<c:if test="${j.count eq 1 }">
										<input type="radio" id="semesterId" value="${i.id}"
											name="${i.degree.degreeName}" checked="checked"
											style="margin-right: 10px;">Semester :  ${i.semesterNo}
									</c:if>
									<c:if test="${j.count ne 1 }">
										<input type="radio" id="semesterId" value="${i.id}"
											name="${i.degree.degreeName}" style="margin-right: 10px;">Semester :  ${i.semesterNo}
									</c:if>
									<br>
								</c:forEach>

								<a class="btn btn-default profile_btn read_more"
									onclick="searchAssignments('${k.key}')"
									href="javascript:void(0)">View Assignment</a>
							</div>
						</div>
					</div>


				</c:forEach>

			</div>
		</div>
	</section>

	<script type="text/javascript">
		function searchAssignments(degreeName) {

			var semester = $("input[name='" + degreeName + "']:checked").val();

			var xhttp = new XMLHttpRequest();

			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4) {

					var jsn = JSON.parse(xhttp.responseText);

					if (jsn) {

						var tableData = '';

						for (var index = 0; index < jsn.length; index++) {
							tableData = tableData + 
							'<tr>' 	+ '<td>' + (index + 1) + '</td>'
									+ '<td>'  + jsn[index].assignmentName + '</td>'
									+ '<td>' + jsn[index].subject.subjectName + '</td>'
									+ '<td> <a href="/documents/assignment/' +jsn[index].fileName+'" download><i class="fa fa-download ml-3"></i></a> </td>'
							 + '</tr>'
						}

						$('#modalTitle').html( 'Assignments of ' +  degreeName);
						$('#tableData').html(tableData);
						$('#myModal').modal('show');

					} else {

					}

				}
			}

			xhttp.open("GET", "getAssignmentsByDegreeAndSem?degreeName="
					+ degreeName + "&semesterId=" + semester, true);
			xhttp.send();

		}
	</script>

	<jsp:include page="footer.jsp"></jsp:include>

	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="modalTitle"></h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<table class="table">
						<thead>
							<tr>
								<th>No</th>
								<th>Assignment</th>
								<th>Subject</th>
								<th>Download</th>
							</tr>
						</thead>
						<tbody id="tableData"></tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>



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