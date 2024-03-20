function addDegree() {
	if ($('#degreeName').val().trim() === '') {
		$('#degreeName').focus()
		showErrorToast('Please Enter Degree Name')
		return false;
	} else if ($('#designation').val().trim() === '') {
		$('#designation').focus()
		showErrorToast('Please Enter Degree Designation')		
		return false;
	}else if ($('#duration').val().trim() === '') {
		$('#duration').focus()
		showErrorToast('Please Enter Degree Duration')		
		return false;
	}
	else {
		return true;
	}

	
}