function busiJoinCheck(){
	if(document.joinForm.name.value==""){
        alert('캠핑장 사업자님 이름를 입력해주세요');
        document.joinForm.name.focus();
    } else if(document.joinForm.id.value==""){
        alert('아이디를 입력해주세요');
        document.joinForm.id.focus();
    } else if(document.joinForm.reid.value != document.joinForm.id.value){
        alert('아이디 중복확인을 하지 않았습니다.');
        document.joinForm.id.focus();
    }else if(document.joinForm.cname.value==""){
        alert('캠핑장 이름를 입력해주세요');
        document.joinForm.cname.focus();
    }else if(document.joinForm.pwd.value==""){
        alert('비밀번호를 입력해주세요.');
        document.joinForm.pwd.focus();
    }else if(document.joinForm.pwd.value != document.joinForm.pwd_check.value){
        alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
        document.joinForm.pwd.focus();
    }else if(document.joinForm.phone.value==""){
        alert('전화번호를 입력해주세요');
        document.joinForm.phone.focus();
	}else if(document.joinForm.email.value==""){
        alert('이메일을 입력해주세요');
        document.joinForm.email.focus();
    }else if(document.joinForm.caddress1.value=="0"){
        alert('도/시를 선택해주세요');
        document.joinForm.caddress1.focus();
    }else if(document.joinForm.caddress2.value=="0"){
        alert('시/군을 선택해주세요');
        document.joinForm.email.focus();
    }else if(document.joinForm.caddress3.value==""){
        alert('상세주소까지 입력해주세요');
        document.joinForm.caddress3.focus();
    }else {
        document.joinForm.action = "camp.do";
        document.joinForm.submit();
    }
}