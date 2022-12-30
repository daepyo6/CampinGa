-- 사업자 시퀀스 생성 --
drop sequence businessman_seq;
create sequence businessman_seq start with 1;

select * from member;

-- 사업자 입력 --
insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3) 
values(businessman_seq.nextval, 'bn', '1234', '김보나', '010-1111-1111', 'abc@abc.com' , 
'해여림 빌리지', '경기도','여주시', '산북면 해여림로 78');
insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3) 
values(businessman_seq.nextval, 'wr', '1234', '김우리', '010-1111-2222', 'abc@abc.com' , 
'경주 텐타우스', '경상북도',' 경주시', '강동면 왕신숲골안길 5');
insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3) 
values(businessman_seq.nextval, 'bh', '1234', '이병환', '010-1111-3333', 'abc@abc.com' , 
'연천 써니힐즈', '경기도','연천군', '장남면 장백로330번길 137-28');
insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3) 
values(businessman_seq.nextval, 'dp', '1234', '이대표', '010-1111-4444', 'abc@abc.com' , 
'홍천 해솔캠핑장', '강원도','홍천군', '내촌면 논골길 91');
insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3) 
values(businessman_seq.nextval, 'hw', '1234', '정현우', '010-1111-5555', 'abc@abc.com' , 
'태안 굼벵이 캠핑농원', '충청남도','태안군', '이원면 꾸지나무길 103-10');

select * from businessman;


insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 1,'해여림 빌리지','바베큐장, 주차장',
'camp01.jpg','다양한 컨텐츠로 즐거운 일상탈출 맛있는 음식과 깨끗한 시설 친절한 서비스 고객감동 서비스가 시작되는 여기는 캠핑장입니다.',
'camping','해여림 AA', 'n', 200000, 4, 10);

insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 2,'경주 텐타우스','바베큐장, 주차장, 와이파이',
'camp01.jpg','다양한 컨텐츠로 즐거운 일상탈출 맛있는 음식과 깨끗한 시설 친절한 서비스 고객감동 서비스가 시작되는 여기는 캠핑장입니다.',
'camping','텐타우스 A', 'n', 200000, 4, 10);
insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 3,'연천 써니힐즈','바베큐장, 주차장, 와이파이',
'camp01.jpg','다양한 컨텐츠로 즐거운 일상탈출 맛있는 음식과 깨끗한 시설 친절한 서비스 고객감동 서비스가 시작되는 여기는 캠핑장입니다.',
'auto','써니힐즈 A', 'n', 200000, 4, 10);
insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 4,'홍천 해솔캠핑장','바베큐장, 주차장, 와이파이',
'camp01.jpg','다양한 컨텐츠로 즐거운 일상탈출 맛있는 음식과 깨끗한 시설 친절한 서비스 고객감동 서비스가 시작되는 여기는 캠핑장입니다.',
'caravane','해솔캠핑장 A', 'n', 200000, 4, 10);
insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 4,'태안 굼벵이 캠핑농원','바베큐장, 주차장, 와이파이',
'camp01.jpg','다양한 컨텐츠로 즐거운 일상탈출 맛있는 음식과 깨끗한 시설 친절한 서비스 고객감동 서비스가 시작되는 여기는 캠핑장입니다.',
'campnic','캠핑농원 A', 'n', 200000, 4, 10);



-- 관리자 입력 -- 
insert into admin(aid, pwd)
values('scott', '1234');


-- 즐겨찾기 시퀀스 생성 --
drop sequence favorites_seq;
create sequence favorites_seq start with 1;


insert into favorites(fseq, mid, bseq)
values(favorites_seq.nextval, 'dp', 1);
insert into favorites(fseq, mid, bseq)
values(favorites_seq.nextval, 'dp', 2);
insert into favorites(fseq, mid, bseq)
values(favorites_seq.nextval, 'dp', 3);
insert into favorites(fseq, mid, bseq)
values(favorites_seq.nextval, 'whsia', 3);
insert into favorites(fseq, mid, bseq)
values(favorites_seq.nextval, 'dp', 4);


select * from favorites; 

-- 리뷰 시퀀스 생성 --
drop sequence review_seq;
create sequence review_seq start with 1;

insert into review(rseq, bseq, mid, content)
values(review_seq.nextval, 2, 'dp', '아주 좋아요');



-- 공지사항 시퀀스 생성 --
drop sequence notice_seq;
create sequence notice_seq start with 1;


-- 공지사항 입력 --
insert into notice(nseq, aid, subject, content)
values( notice_seq.nextval, 'scott', 'CampinGa 오픈', '안녕하세요. 오지캠핑 관리자입니다.
오지/노지 캠핑만 다니다 보니 관련 정보가 많이 부족하고 찾기도 힘들어 홈페이지를 
구축해 보고자 시작하게된 개인적인 프로젝트입니다.
많은 관심 부탁드립니다. 아직 모바일웹버전은 버그가 많이 보이고 있는 상태입니다. 
빠른 세팅하도록 하겠습니다.감사합니다.');




create sequence camping_seq start with 1;
-- 캠핑장 정보 입력
insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 1,'해여림 빌리지','바베큐장, 주차장',
'camp02.jpg','다양한 컨텐츠로 즐거운 일상탈출 맛있는 음식과 깨끗한 시설 친절한 서비스 고객감동 서비스가 시작되는 여기는 캠핑장입니다.',
'camping','해여림 A', 'n', 100000, 4, 10);
insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 1,'해여림 빌리지','바베큐장, 주차장',
'camp02.jpg','다양한 컨텐츠로 즐거운 일상탈출 맛있는 음식과 깨끗한 시설 친절한 서비스 고객감동 서비스가 시작되는 여기는 캠핑장입니다.',
'camping','해여림 B', 'n', 100000, 4, 10);

insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 1,'해여림 빌리지','바베큐장, 주차장',
'camp02.jpg','다양한 컨텐츠로 즐거운 일상탈출 맛있는 음식과 깨끗한 시설 친절한 서비스 고객감동 서비스가 시작되는 여기는 캠핑장입니다.',
'camping','해여림 C', 'n', 100000, 4, 10);

insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 1,'해여림 빌리지','바베큐장, 주차장',
'camp02.jpg','다양한 컨텐츠로 즐거운 일상탈출 맛있는 음식과 깨끗한 시설 친절한 서비스 고객감동 서비스가 시작되는 여기는 캠핑장입니다.',
'camping','해여림 D', 'n', 100000, 4, 10);

insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 4,'홍천 해솔캠핑장','바베큐장, 주차장',
'w-1.jpg','다양한 컨텐츠로 즐거운 일상탈출 맛있는 음식과 깨끗한 시설 친절한 서비스 고객감동 서비스가 시작되는 여기는 캠핑장입니다.',
'camping','후시아 A', 'n', 200000, 4, 10);


select * from camping;
s
drop sequence qna_seq;
create sequence qna_seq start with 1;

insert  into camp_qna(qseq, mid, bseq, content , repyn)values
(qna_seq.nextval, 'dp', 1,'바베큐장 있나요?','n');
insert  into camp_qna(qseq, mid, bseq, content , reply, repyn)values
(qna_seq.nextval, 'dp', 1,'수영장잇나요?','아니요 없습니다','y');
  
select * from camp_qna;  

insert into member(mid, pwd, name,mphone,email)values
('aaa','aaa','김보나','1111-2222-3333','aaaa@naver.com');
insert into member(mid, pwd, name,mphone,email)values
('bbb','bbb','김우리','1111-2222-3333','aaaa@naver.com');
insert into member(mid, pwd, name,mphone,email)values
('ccc','ccc','이병환','1111-2222-3333','aaaa@naver.com');
insert into member(mid, pwd, name, mphone, email)values
('dp','1111','이대표','010-2222-3333','aaaa@naver.com');
insert into member(mid, pwd, name,mphone,email)values
('eee','eee','정현우','1111-2222-3333','aaaa@naver.com');


create sequence notice_seq start with 1; 

insert into notice (nseq,aid,subject,content)values
(notice_seq.nextval,'scott', '[조기종료][EVENT]2022 만만한 캠핑 이벤트!',
'[안전한 캠핑을 응원하는 만만한 캠핑 EVENT] 고캠핑 등록 캠핑장을 네이버에서 예약하고,1만 원 이상 N페이로 결제 후 
이용완료한 선착순 1만 명에게 한국관광공사가 네이버페이 1만 원을 적립해 드립니다! 자세한 이벤트 기간 및 참여방법은 게시된 
이미지를 통해 확인해 보세요~! 예약 관련문의 : 1644-5690 (네이버 고객센터 운영시간 09:00~18:00)
이벤트 관련문의 : 02- 6429-3801 )');
insert into notice (nseq,aid,subject,content)values
(notice_seq.nextval,'scott','초캠러(초보캠퍼)를 위한 동계안전캠핑 5대수칙 알리기 이벤트>',
'미션1. 고캠핑 SNS 팔로우 하기! 미션2. 게시글 댓글에 친구 태그하여 동계안전 캠핑 5대 기본수칙 널리~ 널리~ 알리기!
 미션1,2 모두 참여한 불들 중 100분 에게 일산화탄소 경보기와 불멍이 마스크를!
미션2만 참여한 분들 중 200분께 손세정제와 불멍이 인형을 드립니다!
많은 참여 부탁드립니다.');
insert into notice (nseq,aid,subject,content)values
(notice_seq.nextval,'scott','2022년 등록 야영장 지원사업(1차) 추진계획 안내',
' 추진일정 : 1. 기초지자체 공고 및 접수*(~21.9.30.), 2. 광역지자체 심사 후 문체부 요청(~10.7.)
 3. 지원대상 확정(~10.22.), 4. 보조금 교부(11월~)     
* 지역별로 일정이 상이할 수 있으며, 지방비 확보가 어려운 지역은 공모에 참가가 불가할 수 있는 바,
자세한 사항은 지자체 관광과에 문의하여 주시기 바랍니다.');

 create sequence reservation_seq start with 1; 
insert into reservation(reseq, cseq, mid, price, people, chk_in, chk_out)values
(reservation_seq.nextval, 2, 'dp', 150000, 5, '2023/1/01','2023/1/03');
insert into reservation(reseq,cseq,mid,price,people,chk_in,chk_out)values
(reservation_seq.nextval,camping_seq.nextval,'aaa','200000','4','2023/1/11','2023/1/23');
insert into reservation(reseq,cseq,mid,price,people,chk_in,chk_out)values
(reservation_seq.nextval,camping_seq.nextval,'aaa','250000','8','2023/1/21','2023/2/03');


select * from RESERVATION;





-- 뷰 생성

-- reservation 안의 사용자아이디와 캠핑장번호로 예약정보와 캠핑장정보를 조회하는 view를 생성
create or replace view reservate_view
as
select r.reseq, c.cname, c.c_class, c.res_sta, r.mid, r.price, r.people, r.res_date, r.chk_in, r.chk_out
from reservation r, member m, businessman b, camping c
where m.mid = r.mid and r.cseq = c.cseq and b.bseq = c.bseq;

DROP view reservate_view CASCADE CONSTRAINTS;
select * from reservate_view;

select res_date from reservate_view;


-- favorites 안의 사용자아이디와 캠핑장번호로 즐겨찾기 된 캠핑장정보를 조회하는 view 생성
create or replace view favorites_view
as
select rownum as rn, f.fseq, m.mid, b.cname, b.phone, f.fav_check  
from favorites f, member m, businessman b
where f.mid = m.mid and f.bseq = b.bseq;

DROP view favorites_view CASCADE CONSTRAINTS;
select * from favorites_view;


-- camping 안의 캠핑장 이름으로 정보 조회하는 view
create or replace view camping_view
as
select c.cseq, c.bseq, c.cname, b.caddress1, b.caddress2, b.caddress3, c.facilities,
		b.phone, c.image, c.content, c.category, c.c_class, c.res_sta, c.price,
		c.min_people, c.max_people, c.c_indate
from businessman b, camping c
where b.bseq = c.bseq;

select * from camping_view;

SELECT cseq, cname, caddress1, caddress2, caddress3, phone 
FROM camping_view where ROWID IN (SELECT MAX(ROWID) FROM camping_view GROUP BY cname);


