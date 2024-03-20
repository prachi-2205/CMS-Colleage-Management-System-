function verifyEmail(){

	var loginId = $('#loginId').val();
	var registrationId = $('#registrationId').val();
	
	if(loginId > 0 && registrationId > 0 ){
		
	}else{

		var email = $('#email').val().trim();
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {

			if (xhttp.readyState == 4) {
				var jsn = JSON.parse(xhttp.responseText);

				if(jsn){
					$('#emailError').html( '<b>' + email +'</b>' + ' email is already exist....!!')
					$('#email').val('');
				}else{
					$('#emailError').html('')
				}
			}
		}
		xhttp.open("GET", "verifyEmail?email=" + email, true);
		xhttp.send();
	}
}

function verifyErNo(){

	var loginId = $('#loginId').val();
	var registrationId = $('#registrationId').val();
	
	if(loginId > 0 && registrationId > 0 ){
		
	}else{

		var enrollmentNo = $('#enrollmentNo').val().trim();
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {

			if (xhttp.readyState == 4) {
				var jsn = JSON.parse(xhttp.responseText);

				if(jsn){
					$('#enrollmentNoError').html( '<b>' + enrollmentNo +'</b>' + ' Enrollment number is already exist....!!')
					$('#enrollmentNo').val('');
				}else{
					$('#enrollmentNoError').html('')
				}
			}
		}
		xhttp.open("GET", "verifyErNo?erNo=" + enrollmentNo, true);
		xhttp.send();
	}
}

function addStudentFaculty(){
	 if ($('#degreeId').val() === null) {
			$('#degreeId').focus()
			showErrorToast('Please Select Degree Name')
			return false;
		} else if ($('#semesterId').val() === null) {
			$('#semesterId').focus()
			showErrorToast('Please Select Semester Number')
			return false;
		}else {
			return true;
		}
}

function addStudent() {

	if ($('#firstName').val().trim() === '') {
		$('#firstName').focus()
		showErrorToast('Please Enter First Name')
		return false;
	} else if ($('#middleName').val().trim() === '') {
		$('#middleName').focus()
		showErrorToast('Please Enter Middle Name')
		return false;
	} else if ($('#lastName').val().trim() === '') {
		$('#lastName').focus()
		showErrorToast('Please Enter Last Name')
		return false;
	} else if ($('#degreeId').val() === null) {
		$('#degreeId').focus()
		showErrorToast('Please Select Degree Name')
		return false;
	} else if ($('#semesterId').val() === null) {
		$('#semesterId').focus()
		showErrorToast('Please Select Semester Number')
		return false;
	}else if ($('#enrollmentNo').val().trim() === '') {
		$('#enrollmentNo').focus()
		showErrorToast('Please Enter EnrollmentNo')
		return false;
	} else if ($('#phoneNo').val().trim() === '') {
		$('#phoneNo').focus()
		showErrorToast('Please Enter Phone Number')
		return false;
	}  else if ($('#email').val().trim() === '') {
		$('#email').focus()
		showErrorToast('Please Enter Email')
		return false;
	} else if ($('#address').val().trim() === '') {
		$('#address').focus()
		showErrorToast('Please Enter Address')
		return false;

	} else {
		return true;
	}

}

function getSemesterOfStudent(studentId){

	var registrationId = $('#registrationId').val();
	
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4) {

			var jsn = JSON.parse(xhttp.responseText);	
			
			console.log(jsn.id);
			
			$('#semesterId').val(jsn.id);
			
		}
	}

	xhttp.open("GET", "getSemesterOfStudent?studentId=" + studentId, true);
	xhttp.send();
}


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
			 opnion.setAttribute('disabled', true); opnion.text = '--- Select Semester Number ---'; 
			 semesterId.options.add(opnion);
			 
			
			for(var index = 0 ; index < jsn.length ; index ++ ){
								
				const sem = jsn[index];	
				const opn = document.createElement("option");
				opn.value  = sem.id;
				opn.text  = sem.semesterNo;
				
				semesterId.options.add(opn);
			}
		
			if($('#registrationId').val() && $('#registrationId').val() > 0){
				getSemesterOfStudent($('#registrationId').val());
			}
		}
	}

	xhttp.open("GET", "getSemesterByDegree?degreeId=" + degree.value, true);
	xhttp.send();
}