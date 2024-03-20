function searchResult(){
	
	if($('#exam').val() != '' && $('#degreeId').val() != null && $('#degreeId').val() != '' && $('#semesterId').val() != ''){
		
		var degree = $('#degreeId').val()
		var semesterId = $('#semesterId').val()
	
		var xhttp = new XMLHttpRequest();

		$('#tableHeaderId').html();
		$('#tableBoduId').html();
		$('#errorMessage').html('')
		
		xhttp.onreadystatechange = function() {
			
			if (xhttp.readyState == 4) {
				var jsn = JSON.parse(xhttp.responseText);
				
				if(jsn && jsn.length > 0){
				
					var header = "";
					header = header + '<tr>';
					header = header + '<td>No</td>';
					header = header + '<td>Subject Code</td>';
					header = header + '<td>Subject</td>';
					header = header + '<td>Total Marks</td>';
					header = header + '<td>Obtanied Marks</td>';
					header = header + '<td>Status</td>';
					header = header + '</tr>';
					
					$('#tableHeaderId').html(header);
					
					var row = "";
					
					for(var index in jsn){
						
						var obtainedMarks = jsn[index].obtainedMarks;
						var outOfMarks = jsn[index].outOfMarks;
						
						var passingMarks = ( parseInt(outOfMarks) * 35 ) / 100 ;
						console.log(passingMarks);
						
						var result = "<span style='color:green'>Pass</span>";
						var message = "<span style='color:green'>Congratulations...!!! for passing the exam.</span>";
						
						
						if(obtainedMarks < passingMarks){
							result = "<span style='color:red'>Failed</span>";
						}
						
						row = row + '<tr>';
						row = row + '<td>'+(parseInt(index) + 1)+'</td>';
						row = row + '<td>'+jsn[index].resultVO.subject.subjectCode+'</td>';
						row = row + '<td>'+jsn[index].resultVO.subject.subjectName+'</td>';
						row = row + '<td>'+outOfMarks+'</td>';
						row = row + '<td>'+obtainedMarks+'</td>';
						row = row + '<td>'+result+'</td>';
						row = row + '</tr>';
					}

					
					var flag = jsn.filter(data =>   data.obtainedMarks < ( parseInt(data.outOfMarks) * 35 ) / 100 );
					
					if(flag && flag.length > 0){
						message = "<span style='color:red'>You have not cleared this exam</span>";
					}
					
					$('#errorMessage').html(message);
					$('#tableBoduId').html(row);
				}else{
					$('#errorMessage').html('<h2>Your result is still not prepared</h2>')
				}
				
			}
		}

		xhttp.open("GET",
				"getStudentResult?degreeId=" + degree + "&semesterId="
						+ semesterId + "&examTypeId=" + $('#exam').val(), true);
		xhttp.send();
		
	}else{
	
	}
}


function getSemesterByDegree() {

	if (!$('#degreeId').val()) {
		return false;
	}

	var degree = document.getElementById("degreeId");
	var semesterId = document.getElementById("semesterId");

	if (degree.value === 'default') {
		return false
	}

	resultId = 0;

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

			for (var index = 0; index < jsn.length; index++) {

				const sem = jsn[index];
				const opn = document.createElement("option");
				opn.value = sem.id;
				opn.text = sem.semesterNo;

				semesterId.options.add(opn);
			}
			if ($('#id').val() && $('#id').val() > 0) {
				getSemesterOfExam($('#id').val());
			}

		}
	}

	xhttp.open("GET", "getSemesterByDegree?degreeId=" + degree.value, true);
	xhttp.send();
}