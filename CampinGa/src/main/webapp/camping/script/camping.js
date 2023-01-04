// camping JavaScript 


function reviewCheck(){
    document.frm.action="camp.do?command=updateReview";
    document.frm.submit();
}

function QnaCheck(){
    document.frm.action="camp.do?command=updateQna";
    document.frm.submit();
}