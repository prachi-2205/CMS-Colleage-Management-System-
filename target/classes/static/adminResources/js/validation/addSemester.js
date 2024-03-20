function addSemester() {
	if ($('#degree').val().trim() === 'default') {
		$('#degree').focus()
		showErrorToast('Please Select Degree Name')
		return false;
	}else if ($('#semesterNo').val().trim() === '') {
		$('#semesterNo').focus()
		showErrorToast('Please Enter Semester Number')		
		return false;
	}else if ($('#semesterTime').val().trim() === '') {
		$('#semesterTime').focus()
		showErrorToast('Please Enter Semester Time')		
		return false;
	}
	else {
		return true;
	}

	
}