/**
 * 
 */
function input() {
	if (document.scoreFrm.studNo.value == "") {
		alert("학번을 입력하세요");
		document.scoreFrm.studNo.focus();
	} else if (document.scoreFrm.name.value == "") {
		alert("이름을 입력하세요");
		document.scoreFrm.name.focus();
	} else {
		document.scoreFrm.submit();
	}
}