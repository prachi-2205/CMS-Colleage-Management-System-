var allowedExtensions = /(\.pdf)$/i;

function addAcademic() {
	if ($('#degreeId').val() === null) {
		$('#degreeId').focus()
		showErrorToast('Please Select Degree Name')
		return false;
	} else if ($('#semesterId').val() === null) {
		$('#semesterId').focus()
		showErrorToast('Please Select Semester Number')
		return false;
	} else if ($('#academicStartDate').val().trim() === '') {
		$('#academicStartDate').focus()
		showErrorToast('Please Enter Academic Start Date')
		return false;
	} else if ($('#academicEndDate').val().trim() === '') {
		$('#academicEndDate').focus()
		showErrorToast('Please Enter Academic End Date')
		return false;
	} else if ($('#id').val()  && $('#id').val() <= 0 &&  !allowedExtensions.exec($('#fileName').val().trim())) {
		$('#fileName').focus()
		showErrorToast('Please Choose Proper Pdf File Format')
		return false;
	} else {
		return true;
	}

}

function getSemesterOfAcademic(academicId) {

	var registrationId = $('#registrationId').val();
	
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4) {

			var jsn = JSON.parse(xhttp.responseText);	
			
			console.log(jsn.id);
			
			$('#semesterId').val(jsn.id);
			
		}
	}

	xhttp.open("GET", "getSemesterOfAcademic?academicId=" + academicId, true);
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
		
			if($('#id').val() && $('#id').val() > 0){
				getSemesterOfAcademic($('#id').val());
			}
		}
	}

	xhttp.open("GET", "getSemesterByDegree?degreeId=" + degree.value, true);
	xhttp.send();
}