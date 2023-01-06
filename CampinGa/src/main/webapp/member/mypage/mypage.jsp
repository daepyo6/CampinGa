<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>



<article id="mypage">
   <!-- 회원 간단한 정보 + 정보수정 버튼-->
   <form method="post" name="memberInfo">
      <h1>회원정보</h1>
      <table class="memberInfoList">
         <tr>
            <td>이름</td>
            <td>${loginUser.name}</td>
         </tr>
         <tr>
            <td>이메일</td>
            <td>${loginUser.email}</td>
         </tr>
         <tr>
            <td>전화번호</td>
            <td>${loginUser.mphone}</td>
         </tr>
         <tr>
			<td>
				<input type="button" value="정보수정"
						onclick="location.href='camp.do?command=editForm'">
			</td>
			<td>
				<input type="button" value="회원탈퇴"
						onclick="location.href='camp.do?command=deleteMember'">
			</td>
		</tr>
      </table>
   </form>


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
            <th>예약취소</th>
         </tr>
         <!-- 가짜데이터 이후 c:forEach 사용하여 테이블 조회할 것.-->
         <c:forEach items="${reList}" var="resVO">
            <tr>
               <td><fmt:formatDate value="${resVO.res_date}" type="both" 
                     dateStyle="short" timeStyle="short"/></td>
               <td><a href="#">${resVO.cname}&nbsp;${resVO.c_class}</a></td>
               <td>${resVO.people}명</td>
               <td><fmt:formatDate value="${resVO.chk_in}" type="date"/></td>
               <td><fmt:formatDate value="${resVO.chk_out}" type="date"/></td>
               <td>${resVO.price}</td>
               <td><input type="button" value="취소" onclick="reservate_cancel();"></td>
            </tr>
         </c:forEach>
      </table>
      <div class="clear"></div>
   </form>

   <!-- "내 즐겨찾기" 현재 회원이 즐겨찾기한 캠핑장의 내역을 출력 -->
   <form method="post" name="favorites">
      <h1>즐겨찾기</h1>
      <table class="memberInfoList">
         <tr>
            <th>번호</th>
            <th>캠핑장이름</th>
            <th>캠핑장 전화번호</th>
            <th>즐겨찾기 해제</th>
         </tr>
         <!-- 가짜데이터 이후 c:forEach 사용하여 테이블 조회할 것.-->
         <c:forEach items="${favorList}" var="favorVO">
            <tr>
               <td>${favorVO.fseq}</td>
               <td><a href="#">${favorVO.cname}</a></td>
               <td>${favorVO.phone}</td>
               <td><input type="button" value="취소"
                    	 onclick="delete_favorites( '${favorVO.fseq}' );">
               </td>

            </tr>
         </c:forEach>
      </table>
      <div class="clear"></div>
   </form>
</article>
<%@ include file="../../footer.jsp"%>