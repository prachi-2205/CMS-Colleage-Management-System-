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
		
			if($('#registrationId').val() && $('#registrationId').val() > 0){
				getSemesterOfStudent($('#registrationId').val());
			}
		}
	}

	xhttp.open("GET", "getSemesterByDegree?degreeId=" + degree.value, true);
	xhttp.send();
}