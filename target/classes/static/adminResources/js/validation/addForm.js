var allowedExtensions = /(\.pdf)$/i;

function addForm() {
	if ($('#formName').val().trim() ==='') {
		$('#formName').focus()
		showErrorToast('Please Enter Form Name')
		return false;
		
	} else if ($('#notes').val().trim() ==='') {
		$('#notes').focus()
		showErrorToast('Please Enter valid Notes')
		return false;
		
	} else if ($('#id').val()  && $('#id').val() <= 0 && !allowedExtensions.exec($('#fileName').val().trim())) {
		$('#fileName').focus()
		showErrorToast('Please Choose Proper Pdf File Format')
		return false;
		
	} else {
		return true;
	}
}