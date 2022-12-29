function searchCamp(){
	let key = document.getElementById("key").value;
	console.log(key)
    if(key==""){
        alert("검색어를 입력해주세요.")
        return;
    }else{
        location.href="camp.do?command=searchResult&key="+key
    }
}