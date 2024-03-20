var allowedExtensions = /(\.pdf)$/i;
var isStudentDetails = false;
var isLockedByAdmin = false;
var isFacultyLockedMarks = false;
var resultId = 0;
var marksList = []
var resultList = []
var subjectList = []
var lockedByFacultyForAdminPanel = false;
var flag = true;

function seachResultAdmin() {

	var examTypeId = $("#examTypeId").val();
	var degreeNameId = $("#degreeId").val();
	var semesterNameId = $("#semesterId").val();

	if (examTypeId && degreeNameId && semesterNameId) {

		var xhttp = new XMLHttpRequest();

		$('#tableBoduId').html();
		
		xhttp.onreadystatechange = function() {
			lockedByFacultyForAdminPanel = false
			if (xhttp.readyState == 4) {

				var tabledata = '';
				
				getResultTableHeader();
				
				setTimeout(()=>{
					var jsn = JSON.parse(xhttp.responseText);

					if (jsn !== null) {
						
						const studentIds = Object.keys(jsn);

						if (studentIds && studentIds.length > 0) {

							for (var index = 0; index < studentIds.length; index++) {
								const result = jsn[studentIds[index]];
								
								tabledata = tabledata + '<tr>';
								tabledata = tabledata + '<td>'+(index+1)+'</td>'
								
								const name = result[0].studentVO.firstName + ' '
								+ result[0].studentVO.middleName + ' ' + result[0].studentVO.lastName;
								
								isFacultyLockedMarks = result[0].resultVO.lockedByFaculty;
								isLockedByAdmin = result[0].resultVO.lockedByAdmin;
								
								tabledata = tabledata + '<td>'+name+'</td>'

								for(var ri in  result){
									if(!result[ri].resultVO.lockedByFaculty){
										lockedByFacultyForAdminPanel = true	
									}
									 
								}
								
								for(var subIndex in subjectList){
									
									const ans = result.find(result =>  result.resultVO.subject.id === subjectList[subIndex].id);
									
									if(ans){
										if(ans.resultVO.lockedByFaculty){
											tabledata = tabledata + '<td>'+ans.obtainedMarks+'<span style="margin-left:10px;"><i class="mdi mdi-lock" title="Locked by faculty"></span></td>';
										}else{
											tabledata = tabledata + '<td>'+ans.obtainedMarks+'<span class="ml-10"><i class="mdi mdi-lock-open" title="Not locked by faculty"></span></td>';
										}
										
									}else{
										tabledata = tabledata + '<td> Not uploaded by faculty </td>'
									}
									
								}
								
								tabledata = tabledata + '</tr>';
								
								// console.log(result[0].resultVO.subject.id);
							}

						}

					}
					$('#tableBoduId').html(tabledata);
				},500)
			}
		}

		xhttp.open("GET",
				"getFacultyResult?degreeId=" + degreeNameId + "&semesterId="
						+ semesterNameId + "&examTypeId=" + examTypeId, true);
		xhttp.send();

	} else {
		showErrorToast('Please choose all fields to get result data');
	}
}

function addResult() {
	if ($('#exam').val() === null) {
		$('#exam').focus()
		showErrorToast('Please Select Exam Type')
		return false;
	} else if ($('#totalMarks').val() === null || $('#totalMarks').val() === '') {
		$('#totalMarks').focus()
		showErrorToast('Please enter out of marks')
		return false;
	} else if (!(0 > $('#totalMarks').val() < 100)) {
		$('#totalMarks').focus()
		showErrorToast('Out of marks should between 0 to 100')
		return false;
	} else if ($('#degreeId').val() === null) {
		$('#degreeId').focus()
		showErrorToast('Please Select Degree Name')
		return false;
	} else if ($('#semesterId').val() === null) {
		$('#semesterId').focus()
		showErrorToast('Please Select Semester Number')
		return false;
	} else if ($('#id').val() && $('#id').val() <= 0
			&& !allowedExtensions.exec($('#fileName').val().trim())) {
		$('#fileName').focus()
		showErrorToast('Please Choose Proper Pdf File Format')
		return false;
	} else {
		return true;
	}

}

function getSemesterOfExam(examId) {

	var registrationId = $('#registrationId').val();

	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4) {

			var jsn = JSON.parse(xhttp.responseText);

			console.log(jsn.id);

			$('#semesterId').val(jsn.id);

		}
	}

	xhttp.open("GET", "getSemesterOfExam?examId=" + examId, true);
	xhttp.send();
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

function getResultTableHeader() {

	if (!$('#semesterId').val()) {
		return false;
	}

	var semesterId = document.getElementById("semesterId");

	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4) {

			var jsn = JSON.parse(xhttp.responseText);

			$('#tableHeaderId').html();

			var tableHeader = '<tr>';
			tableHeader = tableHeader + '<th>No</th>'
			tableHeader = tableHeader + '<th>Student Name</th>'
			for (var index = 0; index < jsn.length; index++) {
				tableHeader = tableHeader + "<th>" + jsn[index].subjectName
						+ "</th>"
			}

			tableHeader = tableHeader + '</tr>'

			$('#tableHeaderId').html(tableHeader);
			
			subjectList = jsn;
		}
	}

	xhttp.open("GET", "getSubjectBySemester?semesterId=" + semesterId.value,
			true);
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

			const opnion = document.createElement("option");
			opnion.setAttribute('selected', true);
			opnion.setAttribute('disabled', true);
			opnion.text = '--- Select Subject Name---';
			subjectId.options.add(opnion);

			for (var index = 0; index < jsn.length; index++) {

				const subject = jsn[index];
				const opn = document.createElement("option");
				opn.value = subject.id;
				opn.text = subject.subjectName;

				subjectId.options.add(opn);
			}

			if (id) {
				$('#subjectId').val(id);
			}

		}
	}

	xhttp.open("GET", "getSubjectBySemester?semesterId=" + semesterId.value,
			true);
	xhttp.send();
}

function getStudentByDegreeAndSemester() {

	var degreeId = document.getElementById("degreeId");
	var semesterId = document.getElementById("semesterId");

	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4) {

			var jsn = JSON.parse(xhttp.responseText);

			if (jsn && jsn.length > 0) {

				var tableData = '';

				for (var index = 0; index < jsn.length; index++) {

					const name = jsn[index].firstName + ' '
							+ jsn[index].middleName + ' ' + jsn[index].lastName;

					tableData = tableData + '<tr>';
					tableData = tableData + '<td>' + (index + 1) + '</td>';
					tableData = tableData + '<td>' + name + '</td>';
					tableData = tableData + '<td>' + $('#totalMarks').val()
							+ '</td>';
					tableData = tableData
							+ '<td><input type="number" min="0" max="100" name="resultDetailsList['
							+ index + '].obtainedMarks">';
					tableData = tableData
							+ '<input type="hidden" name="resultDetailsList['
							+ index + '].studentVO.id" value="' + jsn[index].id
							+ '">';
					tableData = tableData
							+ '<input type="hidden" name="resultDetailsList['
							+ index + '].outOfMarks" value="'
							+ $('#totalMarks').val() + '"></td>';
					tableData = tableData + '</tr>';
				}

				$('#studentDetails').html(tableData);
			} else {
				$('#studentDetails').html('');
				showErrorToast('No student found for selected semester')
			}

		}

	}

	xhttp.open("GET", "getStudentByDegreeAndSemester?degreeId="
			+ degreeId.value + "&semesterId=" + semesterId.value, true);
	xhttp.send();

}

function seachResult() {

	var examTypeId = $("#examTypeId").val();
	var degreeNameId = $("#degreeId").val();
	var semesterNameId = $("#semesterId").val();
	var subjectNameId = $("#subjectId").val();

	if (examTypeId && degreeNameId && semesterNameId && subjectNameId) {

		var xhttp = new XMLHttpRequest();

		marksList = [];
		resultList = [];

		xhttp.onreadystatechange = function() {

			if (xhttp.readyState == 4) {

				var jsn = JSON.parse(xhttp.responseText);

				if (jsn && jsn.length > 0) {
					var tableData = '';

					for (var index = 0; index < jsn.length; index++) {

						var data = jsn[index];

						resultId = data.resultVO.id;

						const name = jsn[index].studentVO.firstName + ' '
								+ jsn[index].studentVO.middleName + ' '
								+ jsn[index].studentVO.lastName;

						tableData = tableData + '<tr>';
						tableData = tableData + '<td>' + (index + 1) + '</td>';
						tableData = tableData + '<td>' + name + '</td>';
						tableData = tableData + '<td>' + jsn[index].outOfMarks
								+ '</td>';
						tableData = tableData + '<td id="obtainedMarks' + index
								+ '">' + jsn[index].obtainedMarks + '</td>';

						resultList.push(jsn[index].id);
						marksList.push(jsn[index].obtainedMarks);

						if (!jsn[index].resultVO.lockedByFaculty) {
							tableData = tableData
									+ '<td id="modifiyMarks'
									+ index
									+ '"><i class="mdi mdi-pencil" onclick="modifiyMarks('
									+ index + ')" /></td>';
						} else {
							tableData = tableData + '<td id="modifiyMarks'
									+ index + '">Locked</td>';
						}
						tableData = tableData + '</tr>';

					}
					isStudentDetails = true
					$('#studentDetails').html(tableData);
				} else {
					resultList = [];
					marksList = [];
					resultId = 0;
					isStudentDetails = false
					$('#studentDetails').html('');
				}

			}
		}

		xhttp.open("GET", "getFacultyResult?degreeId=" + degreeNameId
				+ "&semesterId=" + semesterNameId + "&subjectId="
				+ subjectNameId + "&examTypeId=" + examTypeId, true);
		xhttp.send();

	} else {
		showErrorToast('Please choose all fields to get result data');
	}
}

function modifiyMarks(index) {

	const id = "obtainedMarks" + index;
	const oldValue = $('#' + id).html();

	$('#' + id).html(
			'<input type="number" min="0" max="100" name="resultDetailsList['
					+ index + '].obtainedMarks" id="obtainedMarksValue' + index
					+ '" value="' + oldValue + '">')
	$('#modifiyMarks' + index)
			.html(
					'<i class="mdi mdi-close" style="color:red;" title="close" onclick="cancelEdit('
							+ index
							+ ')" /><i class="mdi mdi-check" style="color:green;margin-left:10px;" onclick="saveEdit('
							+ index + ')" title="save" />')

}

function saveEdit(index) {

	const id = "obtainedMarksValue" + index;
	const id1 = "obtainedMarks" + index;

	const oldvalue = $('#' + id).val();
	$('#' + id1).html(oldvalue);

	$('#modifiyMarks' + index).html(
			'<i class="mdi mdi-pencil" onclick="modifiyMarks(' + index
					+ ')" />')

	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4) {

		}
	}

	xhttp.open("GET", "updateStudentMark?marks=" + oldvalue + "&resultId="
			+ resultList[index], true);
	xhttp.send();

}

function cancelEdit(index) {

	const id = "obtainedMarksValue" + index;
	const id1 = "obtainedMarks" + index;

	const oldvalue = $('#' + id).val();
	$('#' + id1).html(marksList[index]);

	$('#modifiyMarks' + index).html(
			'<i class="mdi mdi-pencil" onclick="modifiyMarks(' + index
					+ ')" />')
}

function lockMarks(id) {
	if (isStudentDetails) {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {

			if (xhttp.readyState == 4) {
				seachResult();
			}
		}
		xhttp.open("GET", "lockResult?resultId=" + resultId, true);
		xhttp.send();
	} else {
		showErrorToast('No result found to lock');
	}

}

function adminLockMarks(){
	if($('#tableBoduId').html().trim() === ''){
		showErrorToast('Please Select Student ..... !!!');
		return false;
	}
	if (isFacultyLockedMarks) {
			var exam = 	  $('#examTypeId').val();
			var degree =  $('#degreeId').val();
			var semester = $('#semesterId').val();
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4) {
					seachResultAdmin();
					flag = false;
				}
			}
			xhttp.open("GET", "lockResult?exam=" + exam + '&degree='+degree + '&semester='+semester, true);
			xhttp.send();
	} else {
		showErrorToast('Faculty still not locked marks.....!!!');
	}
}
