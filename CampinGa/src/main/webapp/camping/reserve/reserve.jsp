<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"
   integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA=="
   crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css"
   integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ=="
   crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="camping/reserve/reserve.css" rel="stylesheet">
<script type="text/javascript" src="camping/reserve/reserve.js"></script>
<script>
function call() {
   var beginDate = document.getElementById("beginDate").value;
   var endDate = document.getElementById("endDate").value;
   var bd = beginDate.split('-');
   var ed = endDate.split('-');
   var bd_date = new Date(bd[0], bd[1], bd[2]);
   var ed_date = new Date(ed[0], ed[1], ed[2]);
   var dif = ed_date - bd_date;
   var cDay = 24 * 60 * 60 * 1000;// 시 * 분 * 초 * 밀리세컨

   if (beginDate && endDate) {
      const price = parseInt(dif/cDay) * parseInt('${campVO.price}');
      document.getElementById('price').value  = price
      document.getElementById('totalPrice').innerHTML  = price.toLocaleString('ko-KR');
   }
}
</script>

<div class="bar"></div>
<article>
   <form method="post" name="reserve">
         <input type="hidden" name="command" value="reserveInsert" />
         <input type="hidden" name="name" value="${loginUser.name}">
         <input type="hidden" name="mphone" value="${loginUser.mphone}">
         <input type="hidden" name="email" value="${loginUser.email}">
      <!-- 예약자 정보 (예약자, 전화번호, 이메일) -->
      
      <div id="reserveInfo">
      <div id="reserveInfo1">
         <table>
            <tr>
            <th><예약자 정보></th>
            </tr>
            <tr>
               <th>예약자 이름</th>
               <td>${loginUser.name}</td>
            </tr>
            <tr>
               <th>휴대폰 번호</th>
               <td>${loginUser.mphone}</td>
            </tr>
            <tr>
               <th>이메일</th>
               <td>${loginUser.email}</td>
            </tr>
         </table>
      </div>

      <!-- 캠핑장 정보 (캠핑장이름, 객실정보, 체크인, 체크아웃, 결제금액)-->
      <div id="reserveInfo2">
      <input type="hidden" name="cname" value="${loginUser.name}">
         <input type="hidden" name="c_class" value="${loginUser.mphone}">
         <input type="hidden" name="email" value="${loginUser.email}">
         <input type="hidden" id="price" name="price" value="">
         <table>
            <tr>
               <th>캠핑장 이름</th>
               <td>${campVO.cname}</td>
            </tr>
            <tr>
               <th>객실정보</th>
               <td>${campVO.c_class}</td>
            </tr>
            <tr class="chk">
               <th>체크인</th>
               <td><input id="beginDate" name="checkin" onchange="call()"></td>
            </tr>
            <tr class="chk">
               <th>체크아웃</th>
               <td><input id="endDate" name="checkout" onchange="call()"></td>
            </tr>
            <tr class="chk2">
               <th>인원</th>
               <td><input type="text" name="personnel" size="4">명</td>
            </tr>
            <tr>
               <th>결제금액</th>
               <td><span id="totalPrice">0</span>원</td>
            </tr>
         </table>
           <div id="reservebtn" >
            <input type="button" value="예약하기" onclick="go_reserve();">
            </div>
      </div>
      
      </div>
   </form>
</article>

<%@ include file="../../footer.jsp"%>