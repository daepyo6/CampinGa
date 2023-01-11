function adminCheck() {
	if (document.frm.adminId.value == "") {
		alert("아이디를 입력하세요.");
		return false;
	} else if (document.frm.adminPwd.value == "") {
		alert("비밀번호를 입력하세요.");
		return false;
	} else {
		return true;
	}

}

// admin member

function go_search(com) {
	var url = "camp.do?command=" + com + "&page=1";
	document.frm.action = url;
	document.frm.submit();
}




function go_total(com) {
	document.frm.key.value = "";
	document.frm.action = "camp.do?command=" + com + "&page=1";
	document.frm.submit();
}




function go_members_delete() {
	var count = 0;
	if (document.frm.mid.length == undefined) {
		if (document.frm.mid.checked == true) count++;
	} else {
		for (var i = 0; i < document.frm.mid.length; i++) {
			if (document.frm.mid[i].checked == true) {
				count++;
			}
		}
	}
	if (count == 0) {
		alert("삭제할 회원을 선택하세요");
	}
	else {
		document.frm.action = "camp.do?command=adminMemberDelete";
		document.frm.submit();
	}
}



// admin review

function go_review_delete() {
	var count = 0;
	if (document.frm.rseq.length == undefined) {
		if (document.frm.rseq.checked == true) count++;
	} else {
		for (var i = 0; i < document.frm.rseq.length; i++) {
			if (document.frm.rseq[i].checked == true) {
				count++;
			}
		}
	}
	if (count == 0) {
		alert("삭제할 리뷰를 선택하세요");
	}
	else {
		document.frm.action = "camp.do?command=adminReviewDelete";
		document.frm.submit();
	}
}



//------------------------------------------------------------------------------

function go_wrt() {
	document.frm.action = "camp.do?command=adminNoticeWriteForm";
	document.frm.submit();
}

function go_detail(nseq) {
	var url = "camp.do?command=adminNoticeDetail&nseq=" + nseq;
	document.frm.action = url;
	document.frm.submit();
}


function go_mod(nseq) {
	var url = "camp.do?command=adminNoticeUpdateForm&nseq=" + nseq;
	location.href = url;
	// document.frm.action = url;
	// document.frm.submit();
}

function go_dod(nseq) {
	var url = "camp.do?command=adminNoticeDelete&nseq=" + nseq;
	location.href = url;
	// document.frm.action = url;
	// document.frm.submit();
}



function go_mod_save() {
	var url = "camp.do?command=adminNoticeUpdate";
	document.frm.action = url;
	document.frm.submit();
}

function go_mov() {
	location.href = "camp.do?command=adminNoticeList";
}


function go_wrt() {
	document.frm.action = "camp.do?command=adminNoticeWriteForm";
	document.frm.submit();
}

function go_save() {
	var url = "camp.do?command=adminNoticeWrite";
	document.frm.action = url;
	document.frm.submit();
}


function go_delete() {
	var count = 0;
	if (document.frm.bseq.length == undefined) {
		if (document.frm.bseq.checked == true) count++;
	} else {
		for (var i = 0; i < document.frm.bseq.length; i++) {
			if (document.frm.bseq[i].checked == true) {
				count++;
			}
		}
	}
	if (count == 0) {
		alert("삭제할 항목을 선택하세요");
	} else {
		document.frm.action = "camp.do?command=adminCampingDelete";
		document.frm.submit();
	}
}







