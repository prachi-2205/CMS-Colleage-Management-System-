var allowedExtensions = /(\.pdf)$/i;
function uploadAssignment() {
	if ($('#degreeId').val() === null) {
		$('#degreeId').focus()
		showErrorToast('Please Select Degree Name')
		return false;
	} else if ($('#semesterId').val() === null) {
		$('#semesterId').focus()
		showErrorToast('Please Select Semester Number')
		return false;
	} else if ($('#subjectId').val() === null) {
		$('#subjectId').focus()
		showErrorToast('Please Select Subject Name')
		return false;
	} else if ($('#id').val()  && $('#id').val() <= 0 &&  !allowedExtensions.exec($('#fileName').val().trim())) {
		$('#fileName').focus()
		showErrorToast('Please Choose Proper Pdf File Format')
		return false;
	} else {
		return true;
	}
}

function getSemesterOfAssignment(assignmentId){

	
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4) {

			var jsn = JSON.parse(xhttp.responseText);	
			
			const semester = jsn.semester;
			const subject = jsn.subject;
			
			$('#semesterId').val(semester.id);
		
			getSubjectBySemester(subject.id)
		}
	}

	xhttp.open("GET", "getSemesterOfAssignment?assignmentId=" + assignmentId, true);
	xhttp.send();
}



/*
 * function getSemesterByDegree() {
 * 
 * if (!$('#degreeId').val()) { return false; } var degree =
 * document.getElementById("degreeId"); var semesterId =
 * document.getElementById("semesterId"); var xhttp = new XMLHttpRequest();
 * xhttp.onreadystatechange = function() { if (xhttp.readyState == 4) { var jsn =
 * JSON.parse(xhttp.responseText); semesterId.innerHTML = ''; const opnion =
 * document.createElement("option"); opnion.setAttribute('selected', true);
 * opnion.setAttribute('disabled', true); opnion.text = '--- Select Semester
 * Number ---'; semesterId.options.add(opnion); for (var index = 0; index <
 * jsn.length; index++) { const sem = jsn[index]; const opn =
 * document.createElement("option"); opn.value = sem.id; opn.text =
 * sem.semesterNo; semesterId.options.add(opn); } if($('#id').val() &&
 * $('#id').val() > 0){ getSemesterOfAssignment($('#id').val() ); } } }
 * xhttp.open("GET", "getSemesterByDegree?degreeId=" + degree.value, true);
 * xhttp.send(); }
 */
function getSemesterByDegree() {
	
	if(!$('#degreeId').val()){
		return false;
	}
	
	var degree = document.getElementById("degreeId");
	var semesterId = document.getElementById("semesterId");
	
	if(degree.value === 'default'){
		return false
	}
	
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4) {

			var jsn = JSON.parse(xhttp.responseText);
			
			semesterId.innerHTML = '';
			
			const opnion = document.createElement("option");
			opnion.setAttribute('selected', true);
			opnion.setAttribute('disabled', true);
			opnion.text = '--- Select Semester Number ---'; 
			semesterId.options.add(opnion);
			
			for(var index = 0 ; index < jsn.length ; index ++ ){
				const sem = jsn[index];	
				const opn = document.createElement("option");
				opn.value  = sem.id;
				opn.text  = sem.semesterNo;
				semesterId.options.add(opn);
			}
		
			if($('#id').val() && $('#id').val() > 0){
				getSemesterOfAssignment($('#id').val());
			}
		}
	}

	xhttp.open("GET", "getSemesterByDegree?degreeId=" + degree.value, true);
	xhttp.send();
}

function getSubjectBySemester(id) {

	if (!$('#semesterId').val()) {
		return false;
	}
	
	var semesterId = document.getElementById("semesterId");
	var subjectId = document.getElementById("subjectId");

	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4) {

			var jsn = JSON.parse(xhttp.responseText);

			subjectId.innerHTML = '';

			const
			opnion = document.createElement("option");
			opnion.setAttribute('selected', true);
			opnion.setAttribute('disabled', true);
			opnion.text = '--- Select Subject Name---';
			subjectId.options.add(opnion);

			for (var index = 0; index < jsn.length; index++) {

				const
				subject = jsn[index];
				const
				opn = document.createElement("option");
				opn.value = subject.id;
				opn.text = subject.subjectName;

				subjectId.options.add(opn);
			}


			if(id){
				$('#subjectId').val(id);
			}

		}
	}

	xhttp.open("GET", "getSubjectBySemester?semesterId=" + semesterId.value,true);
	xhttp.send();
}
