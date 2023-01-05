function adminCheck(){
		if(document.frm.workId.value==""){
		   	alert("아이디를 입력하세요.");
		  	return false;
		}else if(document.frm.workPwd.value==""){
		  	alert("비밀번호를 입력하세요.");
		   	return false;
		}else{
			return true;
		}  
		
}		

function go_wrt(){
	document.frm.action = "camp.do?command=adminNoticeWriteForm";
	document.frm.submit();
}

function go_detail( nseq ){
	var url = "camp.do?command=adminNoticeDetail&nseq=" + nseq;
	document.frm.action = url; 
	document.frm.submit();
}


function go_mod(nseq){
	var url = "camp.do?command=adminNoticeUpdateForm&nseq=" + nseq;
	location.href=url;
	// document.frm.action = url;
	// document.frm.submit();
}
function go_dod(nseq){
	var url = "camp.do?command=adminNoticeDelete&nseq=" + nseq ;
	location.href=url;
	// document.frm.action = url;
	// document.frm.submit();
}



function go_mod_save(){
	var url = "camp.do?command=adminNoticeUpdate";
	document.frm.action = url; 
	document.frm.submit();
}

function go_mov(){
	location.href = "camp.do?command=adminNoticeList";
}


function go_wrt(){
	document.frm.action = "camp.do?command=adminNoticeWriteForm";
	document.frm.submit();
}

function go_save(){
var url = "camp.do?command=adminNoticeWrite";
	document.frm.action = url; 
	document.frm.submit();
}
		