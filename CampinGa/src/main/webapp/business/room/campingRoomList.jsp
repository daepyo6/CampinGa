<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<%@ include file="/business/sub_menu.jsp"%>

<div id="roomBox_main">
		<div class="detail_title"><span>객실관리</span></div>
		<c:forEach items="${campingList}" var="campVO">
			<div id="roomBox">
				<div class="room_img">
					<img src="images/${campVO.c_image}" class="img" />
				</div>
				<div class="room_info">
					<div class="room_info-title"><span>${campVO.c_class}</span></div>
					<div class="room_info-text">
						<div><span>종류</span></div>
						<div><span>${campVO.category}</span></div>
					</div>
					<div class="room_info-text">
						<div><span>객실설명</span></div>
						<div><span>${campVO.c_content}</span></div>
					</div>
					<div class="room_info-text">
						<div><span>기준인원 ${campVO.min_people}명/최대인원 ${campVO.max_people}명</span></div>
						<div><span>${campVO.price}원</span></div>
					</div>
					<div class="roomInfo-bar"></div>					
					<span class="bmresbtn" onclick="location.href='camp.do?command=updateCampingRoomForm&cseq=${campVO.cseq}'">수정</span>
					<span class="bmresbtn" onclick="location.href='camp.do?command=deleteCampingRoom&cseq=${campVO.cseq}'">삭제</span>				
				</div>
			</div>
		</c:forEach>
		<div class="resbtn" onclick="location.href='camp.do?command=insertCampingRoomForm'">
			<span>객실 추가</span>
		</div>	
	</div>




<%@ include file="../../footer.jsp"%>