function loadTab(tabNumber) {
	if (tabNumber == 1) {
		window.location.replace("/GatewayJUG/findEmployees-OrderBy.do");
	}
	if (tabNumber == 2) {
		window.location.replace("/GatewayJUG/findEmployees-Like.do");
	}
	if (tabNumber == 3) {
		window.location.replace("/GatewayJUG/findEmployees-Between.do");
	}
	if (tabNumber == 4) {
		window.location.replace("/GatewayJUG/findEmployees-LessThan.do");
	}
	if (tabNumber == 5) {
		window.location.replace("/GatewayJUG/findEmployees-GreaterThan.do");
	}
	if (tabNumber == 6) {
		window.location.replace("/GatewayJUG/findEmployees-In.do");
	}
	if (tabNumber == 7) {
		window.location.replace("/GatewayJUG/findEmployees-JoinFetch.do");
	}
	
}

function areYouSure(url){
	if (!confirm("Are you sure you want to delete employee?")) {
		return;
	} else {
		location.href = url;
	}
}

function toUpperCase(inputBox) {
	if (inputBox != null && inputBox.value != "") {
		inputBox.value = inputBox.value.toUpperCase().replace(/^\s+|\s+$/g, "");
	}
}

/**
 * DO NOT Submit page if Enter Key pressed
 */
function stopEnterKeyPress(evt) {
	var evt = (evt) ? evt : ((event) ? event : null);

	// if ((evt.keyCode == 13) && (node.type=="text")) {
	if ((evt.keyCode == 13)) {
		return false;
	}
}

/**
 * Nothing will happen if user click on Browser Back Button, page will remain in
 * its current state
 */
function noBack(){
	window.history.forward();
}


function toggleExceptionRow(plus, minus) {
	changeTRToggle(document.getElementById("exceptionTable").rows[0].id);
	changeImage('toggleImage1', plus, minus);
}

function changeTRToggle(id) {
	var tr = document.getElementById("exceptionTR");

	if (tr == null) {
		return false;
	}
	var bExpand = tr.style.display == '';
	tr.style.display = (bExpand ? 'none' : '');
}

function changeImage(id, sMinus, sPlus) {
	var img = document.getElementById(id);
	if (img != null) {
		var bExpand = img.src.indexOf(sPlus) >= 0;
		if (!bExpand) {
			img.src = sPlus;
		} else {
			img.src = sMinus;
		}
	}
}

function showDesignArchitecture(){
	window.open("/GatewayJUG/desingArchitecture.do", 'windowname1'); 
}
