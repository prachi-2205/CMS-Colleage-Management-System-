var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
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

function addFaculty() {
	if ($('#firstName').val().trim() === '') {
		$('#firstName').focus()
		showErrorToast('Please Enter First Name')
		return false;
	} else if ($('#lastName').val().trim() === '') {
		$('#lastName').focus()
		showErrorToast('Please Enter Last Name')		
		return false;
	}else if ($('#email').val().trim() === '') {
		$('#email').focus()
		showErrorToast('Please Enter Email')		
		return false;
	}else if ($('#phoneNumber').val().trim() === '') {
		$('#phoneNumber').focus()
		showErrorToast('Please Enter Phone Number')		
		return false;
	}else if ($('#degree').val().trim() === '') {
		$('#degree').focus()
		showErrorToast('Please Enter Degree')		
		return false;
	}else if ($('#designation').val().trim() === '') {
		$('#designation').focus()
		showErrorToast('Please Enter Designation')		
		return false;
	}else if ($('#address').val().trim() === '') {
		$('#address').focus()
		showErrorToast('Please Enter Address')		
		return false;
	
	}else if ($('#id').val().trim() === '') {

		if (!allowedExtensions.exec($('#fileName').val().trim())) {
			$('#fileName').focus()
			showErrorToast('Please Choose Proper Image File Format')
			return false;
		}
	}

	
	else {
		return true;
	}

	
}