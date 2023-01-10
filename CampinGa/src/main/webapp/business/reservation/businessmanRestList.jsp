<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<%@ include file="/business/sub_menu.jsp"%>
<article>
<!-- "예약 조회" 현재 예약조회, 지난 예약조회-->
   <form method="post" name="reservateInfo">
      <h1>예약 조회</h1>
      <table class="memberInfoList">
         <tr>
            <th>예약일자</th>
            <th>예약장소</th>
            <th>인원</th>
            <th>체크인</th>
            <th>체크아웃</th>
            <th>금액</th>
         </tr>
         <!-- 가짜데이터 이후 c:forEach 사용하여 테이블 조회할 것.-->
         
         <c:forEach items="${reList}" var="resVO">
            <tr>
               <td><fmt:formatDate value="${resVO.res_date}" type="both" 
                     dateStyle="short" timeStyle="short"/></td>
               <td>${resVO.cname}&nbsp;${resVO.c_class}</td>
               <td>${resVO.people}명</td>
               <td><fmt:formatDate value="${resVO.chk_in}" type="date"/></td>
               <td><fmt:formatDate value="${resVO.chk_out}" type="date"/></td>
               <td>${resVO.price}</td>
            </tr>
         </c:forEach>
      </table>
      <div class="clear"></div>
   </form>
</article>
<%@ include file="../../footer.jsp"%>