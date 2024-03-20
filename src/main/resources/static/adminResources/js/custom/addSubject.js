var i = 0;
function addSub() {

	var errorMessage = document.getElementById("errorMessage");
	var subName = document.getElementById("subjectName");
	var subCode = document.getElementById("subjectCode");
	var subCredit = document.getElementById("subjectCredit");

	errorMessage.innerHTML = '';

	if (subName && subName.value !== '' && subCode && subCode.value !== ''
			&& subCredit && subCredit.value !== '') {

		i++;

		var subTable = document.getElementById("subjectTable");

		var tebDiv = document.getElementById("tebDiv");
		tebDiv.style.display = "";

		var r = subTable.insertRow(-1);
		var c1 = r.insertCell(0);
		var c2 = r.insertCell(1);
		var c3 = r.insertCell(2);
		var c4 = r.insertCell(3);

		c1.innerHTML = i;
		c2.innerHTML = '<input type="hidden" name="subName" value="'+ subName.value + '">' + subName.value;
		c3.innerHTML = '<input type="hidden" name="subCode" value='
				+ subCode.value + '>' + subCode.value;
		c4.innerHTML = '<input type="hidden" name="subCredit" value="'+ subCredit.value + '">' + subCredit.value;

	} else {

		errorMessage.innerHTML = '<span style="color:red;">Subject name, Code and credit should not empty</span>';

	}
}

function getSemesterOfSubject(subjectId){

	var registrationId = $('#registrationId').val();
	
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4) {

			var jsn = JSON.parse(xhttp.responseText);	
			
			console.log(jsn.id);
			
			$('#semesterId').val(jsn.id);
			
		}
	}

	xhttp.open("GET", "getSemesterOfSubject?subjectId=" + subjectId, true);
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
				getSemesterOfSubject($('#id').val());
			}
		}
	}

	xhttp.open("GET", "getSemesterByDegree?degreeId=" + degree.value, true);
	xhttp.send();
}