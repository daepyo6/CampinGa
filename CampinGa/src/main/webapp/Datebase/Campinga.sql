
/* Drop Tables */

DROP TABLE notice CASCADE CONSTRAINTS;
DROP TABLE admin CASCADE CONSTRAINTS;
DROP TABLE favorites CASCADE CONSTRAINTS;
DROP TABLE reservation CASCADE CONSTRAINTS;
DROP TABLE camping CASCADE CONSTRAINTS;
DROP TABLE camp_qna CASCADE CONSTRAINTS;
DROP TABLE review CASCADE CONSTRAINTS;
DROP TABLE businessman CASCADE CONSTRAINTS;
DROP TABLE member CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE admin
(
	aid varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	PRIMARY KEY (aid)
);


CREATE TABLE businessman
(
	bseq number(5) NOT NULL,
	bid varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	phone varchar2(20) NOT NULL,
	email varchar2(30) NOT NULL,
	cname varchar2(30) NOT NULL,
	caddress1 varchar2(20) NOT NULL,
	caddress2 varchar2(20) NOT NULL,
	caddress3 varchar2(100) NOT NULL,
	PRIMARY KEY (bseq)
);


CREATE TABLE camping
(
	cseq number(5) NOT NULL,
	bseq number(5) NOT NULL,
	cname varchar2(20) NOT NULL,
	facilities varchar2(200),
	image varchar2(20),
	content varchar2(1000),
	category varchar2(20),
	c_class varchar2(100) NOT NULL,
	res_sta varchar2(2) DEFAULT 'n',
	price number(10) DEFAULT 0,
	min_people number(2) DEFAULT 0,
	max_people number(2) DEFAULT 0,
	c_indate date DEFAULT sysdate,
	PRIMARY KEY (cseq)
);


CREATE TABLE camp_qna
(
	qseq number(5) NOT NULL,
	mseq number(5) NOT NULL,
	bseq number(5) NOT NULL,
	content varchar2(1000) NOT NULL,
	indate date DEFAULT sysdate,
	reply varchar2(1000) NOT NULL,
	repyn varchar2(2) DEFAULT 'n',
	PRIMARY KEY (qseq)
);


CREATE TABLE favorites
(
	fseq number(5) NOT NULL,
	mseq number(5) NOT NULL,
	cseq number(5) NOT NULL,
	PRIMARY KEY (fseq)
);


CREATE TABLE member
(
	mseq number(5) NOT NULL,
	mid varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	mphone varchar2(20) NOT NULL,
	email varchar2(30) NOT NULL,
	PRIMARY KEY (mseq)
);


CREATE TABLE notice
(
	nseq number(5) NOT NULL,
	aid varchar2(20) NOT NULL,
	subject varchar2(20) NOT NULL,
	content varchar2(1000) NOT NULL,
	indate date DEFAULT sysdate,
	PRIMARY KEY (nseq)
);


CREATE TABLE reservation
(
	reseq number(5) NOT NULL,
	cseq number(5) NOT NULL,
	mseq number(5) NOT NULL,
	res_date date DEFAULT sysdate,
	price number(10) DEFAULT 0,
	people number(2) DEFAULT 0,
	chk_in date NOT NULL,
	chk_out date NOT NULL,
	PRIMARY KEY (reseq)
);


CREATE TABLE review
(
	rseq number(5) NOT NULL,
	mseq number(5) NOT NULL,
	bseq number(5) NOT NULL,
	content varchar2(1000) NOT NULL,
	indate date DEFAULT sysdate,
	PRIMARY KEY (rseq)
);



/* Create Foreign Keys */

ALTER TABLE notice
	ADD FOREIGN KEY (aid)
	REFERENCES admin (aid)
;


ALTER TABLE camping
	ADD FOREIGN KEY (bseq)
	REFERENCES businessman (bseq)
;


ALTER TABLE camp_qna
	ADD FOREIGN KEY (bseq)
	REFERENCES businessman (bseq)
;


ALTER TABLE review
	ADD FOREIGN KEY (bseq)
	REFERENCES businessman (bseq)
;


ALTER TABLE favorites
	ADD FOREIGN KEY (cseq)
	REFERENCES camping (cseq)
;


ALTER TABLE reservation
	ADD FOREIGN KEY (cseq)
	REFERENCES camping (cseq)
;


ALTER TABLE camp_qna
	ADD FOREIGN KEY (mseq)
	REFERENCES member (mseq)
;


ALTER TABLE favorites
	ADD FOREIGN KEY (mseq)
	REFERENCES member (mseq)
;


ALTER TABLE reservation
	ADD FOREIGN KEY (mseq)
	REFERENCES member (mseq)
;


ALTER TABLE review
	ADD FOREIGN KEY (mseq)
	REFERENCES member (mseq)
;





-- 멤버가 로그인 한상태
-- 그 멤버가 즐겨찾기한 캠핑장이름과 전화번호

select 































