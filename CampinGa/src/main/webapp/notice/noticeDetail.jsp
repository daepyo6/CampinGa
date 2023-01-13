<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div class="bar"></div>
<br><br>
<article >
   <div  id="noticeview" >
   <h1>공지사항</h1> 
   <table>

      <tr><th align="center" >제목</th><td colspan="5">${noticeVO.subject}</td></tr>
         <tr><th>상세설명</th><td colspan="5"><pre>${noticeVO.content}</pre></td></tr>

   </table>
   <div class="buttons">
   <input class="btn"  type="button" value="목록" onClick="location.href='camp.do?command=noticeList'">
   </div>
</div>
</article> <br><br><br><br>
<%@ include file="../footer.jsp"%>