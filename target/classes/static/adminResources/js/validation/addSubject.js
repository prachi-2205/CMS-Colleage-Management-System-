function addSubject() {
	if ($('#degreeId').val() === null) {
		$('#degreeId').focus()
		showErrorToast('Please Select Degree Name')
		return false;
	} else if ($('#semesterId').val() === null) {
		$('#semesterId').focus()
		showErrorToast('Please Select Semester Number')
		return false;
	} else if ($('#subjectName').val().trim() === '') {
		$('#subjectName').focus()
		showErrorToast('Please Enter Subject Name')
		return false;
	} else if ($('#subjectCode').val().trim() === '') {
		$('#subjectCode').focus()
		showErrorToast('Please Enter Subject Code')
		return false;
	} else if ($('#subjectCredit').val().trim() === '') {
		$('#subjectCredit').focus()
		showErrorToast('Please Enter Subject Credit')
		return false;
	} else {
		return true;
	}

}