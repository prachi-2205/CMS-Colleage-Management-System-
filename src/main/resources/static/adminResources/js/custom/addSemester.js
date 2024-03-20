var i = 0;
function addSem() {

	var errorMessage = document.getElementById("errorMessage");
	var semNum = document.getElementById("semesterNo");
	var semTime = document.getElementById("semesterTime");

	errorMessage.innerHTML = '';

	if (semNum && semNum.value !== '' && semTime && semTime.value !== '') {

		i++;

		var semTable = document.getElementById("semTable");

		var tebDiv = document.getElementById("tebDiv");
		tebDiv.style.display = "";

		var r = semTable.insertRow(-1);
		var c1 = r.insertCell(0);
		var c2 = r.insertCell(1);
		var c3 = r.insertCell(2);

		c1.innerHTML = i;
		c2.innerHTML = '<input type="hidden" name="semNo" value='
				+ semNum.value + '>' + semNum.value;
		c3.innerHTML = '<input type="hidden" name="semTime" value='
				+ semTime.value + '>' + semTime.value;

	} else {

		errorMessage.innerHTML = '<span style="color:red;">Semester no and time should not empty</span>';

	}

}