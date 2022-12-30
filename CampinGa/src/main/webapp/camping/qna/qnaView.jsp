<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>

<article>
   <h2> QnA </h2>
   
   <form name="formm" method="post" action="camp.do">
   <input type="hidden" name="command" value="insertQna" >
    <table id="qnaView">
      <c:forEach items="${qnalist}" var="qnaVO">
         <tr><th>번호</th><td width="500" align="left" style="text-align:left;">${qnaVO.qseq}번</td></tr>
         <tr><th>아이디 · 등록일</th><td align="left" style="text-align:left;">${qnaVO.mid} · 
            <fmt:formatDate value="${qnaVO.indate}" type="date"/></td></tr>
         <tr><th>내용</th><td align="left" style="text-align:left;">${qnaVO.content}</td></tr>
         <tr><th>답변 여부</th><td><c:choose>
                  <c:when test="${qnaVO.repyn==y}">${qnaVO.reply}</c:when>
                  <c:otherwise>답변대기중</c:otherwise>
            </c:choose></td></tr><tr><td colspan="2">
         <input type="submit" value="수정하기" 
         onclick="#">
         <input type="button" value="삭제하기" 
         onclick="location.href='camp.do?command=deleteQna&qseq=${qnaVO.qseq}'">
            </td></tr>
         </c:forEach>
      </table>
     <div class="clear"></div>
      <fieldset> 
         <legend>Board Info</legend>  
          <label>Title</label><input type="text" name="subject"  size="60" ><br>
         <label>Content</label><textarea rows="8" cols="65" name="content"></textarea>
      </fieldset>
      <div id="buttons" style="float:right;">
      <input type="submit" value="등록하기" class="submit">
      <input type="button" value="취소하기" class="cancel"
      onclick="#">
   </div>
      <div  class="clear"></div><br>
   </form>
</article>

<%@ include file="../../footer.jsp" %>