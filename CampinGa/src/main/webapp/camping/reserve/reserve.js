$.datepicker.setDefaults({
	dateFormat: 'yy-mm-dd',
	prevText: '이전 달',
	nextText: '다음 달',
	monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	showMonthAfterYear: true,
	showOtherMonths: true,
	yearSuffix: '년',
	minDate: "0D"
});

function go_reserve() {
	var input = confirm('예약하시겠습니까?');

	if (parseInt(document.reserve.people.value) > parseInt(document.reserve.max_people.value)) {
		alert('예약가능한 최대 인원 수 보다 많습니다.');
		document.reserve.people.focus();
		input = false;
	}

	if (input) {
		document.reserve.action = "camp.do?command=reserveInsert";
		document.reserve.submit();

	}
}