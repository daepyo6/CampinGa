<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript" src="camping/campingList.js"></script>
<style>

</style>
<article>
   <!-- 캠핑장 세부설명 -->
   <%@ include file="../camping/detail.jsp"%>
   
   <!-- 캠핑장 객실 정보 -->
   <div id="roomBox">
  	 <h2>캠핑장 예약</h2>
     <div></div>
     <div></div>
   </div>
   
   <!-- Q&A -->
   <div class="listBox" id="qnabox">
      <h2>Q & A</h2>
      <table class="view">
         <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>등록일</th>
            <th>내용</th>
            <th>답변여부</th>
            <th>수정/삭제</th>
         </tr>
         <c:forEach items="${qnalist}" var="qnaVO">
            <tr class="listOne">
               <td>${qnaVO.qseq}</td>
               <td>${qnaVO.mid}</td>
               <td><fmt:formatDate value="${qnaVO.indate}" type="date" /></td>
               <td>&nbsp;&nbsp;&nbsp;${qnaVO.content}</td>
               <td><c:choose>
                     <c:when test="${qnaVO.repyn==y}">${qnaVO.reply}</c:when>
                     <c:otherwise>답변대기중</c:otherwise>
                  </c:choose></td>
               <td><c:if test="${qnaVO.mid == loginUser.mid}">
                     <input type="submit" value="수정"
                        onclick="location.href='camp.do?command=campDetail&qseq=${qnaVO.qseq}&bseq=${bseq}'">
                     <input type="button" value="삭제"
                        onclick="location.href='camp.do?command=deleteQna&qseq=${qnaVO.qseq}&bseq=${bseq}'">
                  </c:if></td>
            </tr>
            <c:if test="${qnaVO.qseq==updateQseq}">
               <tr>
                  <td colspan="6">
                     <form name="frm" method="post">
                        <input type="hidden" name="qseq" value="${qnaVO.qseq}">
                        <input type="hidden" name="bseq" value="${bseq}"> 
                        <input type="hidden" name="mid" value="${qnaVO.mid}">
                        <textarea rows="8" cols="65" name="content">${qnaVO.content}</textarea>
                        <input type="submit" value="확인" onclick="QnaCheck();">
                     </form>
                  </td>
               </tr>
            </c:if>
         </c:forEach>
      </table>

      <form name="frm" method="post" action="camp.do">
         <input type="hidden" name="command" value="insertQna">
         <input type="hidden" name="bseq" value="${bseq}"> 
         <div class="writeBox">
            <textarea rows="8" cols="65" name="content"></textarea>
            <div class="btns">
               <input class="submit" type="submit" value="QnA쓰기" >
            </div>
         </div>
      </form>
      <br><br> <br>
<div class="paging">
	<c:if test="${paging1.prev}">
		<a href="camp.do?command=campDetail&bseq=${bseq}&page1=${paging1.beginPage-1}#qnabox">◀</a>				
	</c:if>
	<c:forEach begin="${paging1.beginPage}" end="${paging1.endPage}" var="index">
		<c:choose>
			<c:when test="${index==paging1.page}">
				<span style="color: red;">${index}&nbsp;</span>
			</c:when>
			<c:otherwise>
				<a href="camp.do?command=campDetail&bseq=${bseq}&page1=${index}#qnabox">${index}&nbsp;</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${paging1.next}">
		<a href="camp.do?command=campDetail&bseq=${bseq}&page1=${paging1.endPage+1}#qnabox">▶</a>				
	</c:if>		
</div>
   </div>

	<div class="bar2"></div>

   <!-- 리뷰 -->
   <div class="listBox" id="reviewbox">
      <h2>Review</h2>
      <table class="view">
         <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>등록일</th>
            <th>내용</th>
            <th>수정/삭제</th>
         </tr>
         <c:forEach items="${reviewList}" var="ReviewVO">
            <tr class="listOne">
               <td>${ReviewVO.rseq}</td>
               <td>${ReviewVO.mid}</td>
               <td><fmt:formatDate value="${ReviewVO.indate}" /></td>
               <td>&nbsp;&nbsp;&nbsp;${ReviewVO.content}</td>
               <td><c:if test="${ReviewVO.mid==loginUser.mid}">
                     <input type="button" value="수정" class="submit"
                        onclick="location.href='camp.do?command=campDetail&rseq=${ReviewVO.rseq}&bseq=${bseq}'">
                     <input type="button" value="삭제" class="submit"
                        onclick="location.href='camp.do?command=deleteReview&rseq=${ReviewVO.rseq}&bseq=${bseq}'">
                  </c:if>
            </tr>

            <c:if test="${ReviewVO.rseq==updateRseq}">
               <tr>
                  <td colspan="5">
                     <form name="frm" method="post">
                        <input type="hidden" name="rseq" value="${ReviewVO.rseq}">
                        <input type="hidden" name="bseq" value="${bseq}"> 
                        <input type="hidden" name="mid" value="${ReviewVO.mid}">
                        <textarea rows="8" cols="65" name="content">${ReviewVO.content}</textarea>
                        <input type="submit" value="확인" onclick="reviewCheck();">
                     </form>
                  </td>
               </tr>
            </c:if>
         </c:forEach>
      </table>
      <form name="form" method="post" action="camp.do">
         <input type="hidden" name="command" value="insertReview">
         <input type="hidden" name="bseq" value="${bseq}"> 
         <div class="writeBox">         
            <textarea rows="8" cols="65" name="content"></textarea>
            <div class="btns">
               <input type="submit" class="submit" value="리뷰쓰기"> 
            </div>
         </div>
      </form>
      <br><br><br>
	<div class="paging">
		<c:if test="${paging2.prev}">
			<a href="camp.do?command=campDetail&bseq=${bseq}&page2=${paging2.beginPage-1}#reviewbox">◀</a>				
		</c:if>
		<c:forEach begin="${paging2.beginPage}" end="${paging2.endPage}" var="index">
			<c:choose>
				<c:when test="${index==paging2.page}">
					<span style="color: red;">${index}&nbsp;</span>
				</c:when>
				<c:otherwise>
					<a href="camp.do?command=campDetail&bseq=${bseq}&page2=${index}#reviewbox">${index}&nbsp;</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${paging2.next}">
			<a href="camp.do?command=campDetail&bseq=${bseq}&page2=${paging2.endPage+1}#reviewbox">▶</a>				
		</c:if>		
	</div>
   </div> 
</article>
<%@ include file="../footer.jsp"%>