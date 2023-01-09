<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<article>
   <div  id="noticeview" >
   <h1>공지사항 상세 </h1> 
   <table>
 
      <tr><th align="center" >제목</th><td colspan="5">${noticeVO.subject}</td></tr>
         <tr><th>상세설명</th><td colspan="5"><pre>${noticeVO.content}</pre></td></tr>
         
   </table>
   <div class="buttons">
    <input class="btn"  type="button" value="수정" onClick="go_mod('${noticeVO.nseq}')">
	<input class="btn"  type="button" value="삭제" onClick="go_dod('${noticeVO.nseq}')">
	<input class="btn"  type="button" value="목록" onClick="go_mov()">
   </div>
</div>
</article> <br><br><br><br>

<%@ include file="/admin/footer.jsp"%>