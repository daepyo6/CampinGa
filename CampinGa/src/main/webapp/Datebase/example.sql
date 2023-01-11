-- ����� ������ ���� --
drop sequence businessman_seq;
create sequence businessman_seq start with 1;

insert into member(mid, pwd, name, mphone, email)
values('qndrl12', '1234', '����ǥ', '010-8010-4755', 'qndrl12@naver.com');

select * from member;
select * from qna_;

-- ����� �Է� --
insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3, facilities, image, content, category) 
values(businessman_seq.nextval, 'dp', '1234', '�̴�ǥ', '010-1111-1111', 'abc@abc.com' , 
'�ؿ��� ������', '��⵵','���ֽ�', '��ϸ� �ؿ����� 78', '�ٺ�ť��, ������', 'camp01.jpg',
'�پ��� �������� ��ſ� �ϻ�Ż�� ���ִ� ���İ� ������ �ü� ģ���� ���� ������ ���񽺰� ���۵Ǵ� ����� ķ�����Դϴ�.', 'camping');

insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3, facilities, image, content, category) 
values(businessman_seq.nextval, 'bn', '1234', '�躸��', '010-2222-1111', 'abc@abc.com' , 
'���� ��Ÿ�콺', '���ϵ�','���ֽ�', '������ �սŽ���ȱ� 5', '�ٺ�ť��, ������', 'camp02.jpg',
'�ȳ��ϼ��� ���� ��Ÿ�콺�Դϴ�.', 'campnic');

insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3, facilities, image, content, category) 
values(businessman_seq.nextval, 'bw', '1234', '�躸��', '010-3333-1111', 'abc@abc.com' , 
'��õ �������', '��⵵','��õ��', '�峲�� ����330���� 137-28', '�ٺ�ť��, ������', 'camp01.jpg',
'�ȳ��ϼ��� ��õ ��������Դϴ�.', 'auto');

insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3, facilities, image, content, category) 
values(businessman_seq.nextval, 'bc', '1234', '�躸��', '010-4444-1111', 'abc@abc.com' , 
'ȫõ �ؼ�ķ����', '������','ȫõ��', '���̸� ���� 91', '�ٺ�ť��, ������', 'camp02.jpg',
'�ȳ��ϼ��� ȫõ �ؼ�ķ�����Դϴ�.', 'caravane');

insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3, facilities, image, content, category) 
values(businessman_seq.nextval, 'ba', '1234', '�躸��', '010-5555-1111', 'abc@abc.com' , 
'�¾� ������ ķ�γ��', '��û����','�¾ȱ�', '�̿��� ���������� 103-10', '�ٺ�ť��, ������', 'camp01.jpg',
'�ȳ��ϼ��� �¾� ������ ķ�γ���Դϴ�', 'camping');

select * from businessman;
select * from camping;
delete from businessman where bseq=1;

select count(*) from camping where cname='�ؿ��� ������';


drop sequence camping_seq;
create sequence camping_seq start with 1;

insert  into camping(cseq, bseq, cname, c_image, c_content, c_class, res_sta, price, min_people, max_people)
values (camping_seq.nextval, 1,'�ؿ��� ������', 'camp02.jpg','�ؿ��� AA���Դϴ�.','�ؿ��� AA', 'n', 200000, 4, 10);

insert  into camping(cseq, bseq, cname, c_image, c_content, c_class, res_sta, price, min_people, max_people)
values (camping_seq.nextval, 1,'�ؿ��� ������', 'camp02.jpg','�ؿ��� BB���Դϴ�.','�ؿ��� BB', 'n', 150000, 4, 8);

insert  into camping(cseq, bseq, cname, c_image, c_content, c_class, res_sta, price, min_people, max_people)
values (camping_seq.nextval, 1,'�ؿ��� ������', 'camp02.jpg','�ؿ��� CC���Դϴ�.','�ؿ��� CC', 'n', 250000, 6, 12);




insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 2,'���� ��Ÿ�콺','�ٺ�ť��, ������, ��������',
'camp01.jpg','�پ��� �������� ��ſ� �ϻ�Ż�� ���ִ� ���İ� ������ �ü� ģ���� ���� ������ ���񽺰� ���۵Ǵ� ����� ķ�����Դϴ�.',
'camping','��Ÿ�콺 A', 'n', 200000, 4, 10);
insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 3,'��õ �������','�ٺ�ť��, ������, ��������',
'camp01.jpg','�پ��� �������� ��ſ� �ϻ�Ż�� ���ִ� ���İ� ������ �ü� ģ���� ���� ������ ���񽺰� ���۵Ǵ� ����� ķ�����Դϴ�.',
'auto','������� A', 'n', 200000, 4, 10);
insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 4,'ȫõ �ؼ�ķ����','�ٺ�ť��, ������, ��������',
'camp01.jpg','�پ��� �������� ��ſ� �ϻ�Ż�� ���ִ� ���İ� ������ �ü� ģ���� ���� ������ ���񽺰� ���۵Ǵ� ����� ķ�����Դϴ�.',
'caravane','�ؼ�ķ���� A', 'n', 200000, 4, 10);
insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 5,'�¾� ������ ķ�γ��','�ٺ�ť��, ������, ��������',
'camp01.jpg','�پ��� �������� ��ſ� �ϻ�Ż�� ���ִ� ���İ� ������ �ü� ģ���� ���� ������ ���񽺰� ���۵Ǵ� ����� ķ�����Դϴ�.',
'campnic','ķ�γ�� A', 'n', 200000, 4, 10);



-- ������ �Է� -- 
insert into admin(aid, pwd)
values('scott', '1234');


-- ���ã�� ������ ���� --
drop sequence favorites_seq;
create sequence favorites_seq start with 1;


insert into favorites(fseq, mid, bseq)
values(favorites_seq.nextval, 'qndrl12', 1);
insert into favorites(fseq, mid, bseq)
values(favorites_seq.nextval, 'qndrl12', 2);
insert into favorites(fseq, mid, bseq)
values(favorites_seq.nextval, 'dp', 3);
insert into favorites(fseq, mid, bseq)
values(favorites_seq.nextval, 'whsia', 3);
insert into favorites(fseq, mid, bseq)
values(favorites_seq.nextval, 'dp', 4);


select * from favorites; 

-- ���� ������ ���� --
drop sequence review_seq;
create sequence review_seq start with 1;

insert into review(rseq, bseq, mid, content)
values(review_seq.nextval, 1, 'qndrl12', '���� ���ƿ�');
insert into review(rseq, bseq, mid, content)
values(review_seq.nextval, 1, 'qndrl12', 'ķ������ ���� ���ƿ�');

-- �������� ������ ���� --
drop sequence notice_seq;
create sequence notice_seq start with 1;


-- �������� �Է� --
insert into notice(nseq, aid, subject, content)
values( notice_seq.nextval, 'scott', 'CampinGa ����', '�ȳ��ϼ���. ����ķ�� �������Դϴ�.
����/���� ķ�θ� �ٴϴ� ���� ���� ������ ���� �����ϰ� ã�⵵ ����� Ȩ�������� 
������ ������ �����ϰԵ� �������� ������Ʈ�Դϴ�.
���� ���� ��Ź�帳�ϴ�. ���� ������������� ���װ� ���� ���̰� �ִ� �����Դϴ�. 
���� �����ϵ��� �ϰڽ��ϴ�.�����մϴ�.');




create sequence camping_seq start with 1;
-- ķ���� ���� �Է�
insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 1,'�ؿ��� ������','�ٺ�ť��, ������',
'camp02.jpg','�پ��� �������� ��ſ� �ϻ�Ż�� ���ִ� ���İ� ������ �ü� ģ���� ���� ������ ���񽺰� ���۵Ǵ� ����� ķ�����Դϴ�.',
'camping','�ؿ��� A', 'n', 100000, 4, 10);
insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 1,'�ؿ��� ������','�ٺ�ť��, ������',
'camp02.jpg','�پ��� �������� ��ſ� �ϻ�Ż�� ���ִ� ���İ� ������ �ü� ģ���� ���� ������ ���񽺰� ���۵Ǵ� ����� ķ�����Դϴ�.',
'camping','�ؿ��� B', 'n', 100000, 4, 10);

insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 1,'�ؿ��� ������','�ٺ�ť��, ������',
'camp02.jpg','�پ��� �������� ��ſ� �ϻ�Ż�� ���ִ� ���İ� ������ �ü� ģ���� ���� ������ ���񽺰� ���۵Ǵ� ����� ķ�����Դϴ�.',
'camping','�ؿ��� C', 'n', 100000, 4, 10);

insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 1,'�ؿ��� ������','�ٺ�ť��, ������',
'camp02.jpg','�پ��� �������� ��ſ� �ϻ�Ż�� ���ִ� ���İ� ������ �ü� ģ���� ���� ������ ���񽺰� ���۵Ǵ� ����� ķ�����Դϴ�.',
'camping','�ؿ��� D', 'n', 100000, 4, 10);

insert  into camping(cseq, bseq, cname, facilities, image, content, category, c_class, res_sta, price, 
				min_people, max_people  )
values (camping_seq.nextval, 4,'ȫõ �ؼ�ķ����','�ٺ�ť��, ������',
'w-1.jpg','�پ��� �������� ��ſ� �ϻ�Ż�� ���ִ� ���İ� ������ �ü� ģ���� ���� ������ ���񽺰� ���۵Ǵ� ����� ķ�����Դϴ�.',
'camping','�Ľþ� A', 'n', 200000, 4, 10);


select * from camping;

drop sequence qna_seq;
create sequence qna_seq start with 1;

insert into camp_qna(qseq, mid, bseq, content , repyn)
values (qna_seq.nextval, 'qndrl12', 1,'�ٺ�ť�� �ֳ���?','n');
insert into camp_qna(qseq, mid, bseq, content , reply, repyn)
values (qna_seq.nextval, 'qndrl12', 1,'�������ճ���?','�ƴϿ� �����ϴ�','n');
  
select * from camp_qna;  
select * from review;

insert into member(mid, pwd, name,mphone,email)values
('aaa','aaa','�躸��','1111-2222-3333','aaaa@naver.com');
insert into member(mid, pwd, name,mphone,email)values
('bbb','bbb','��츮','1111-2222-3333','aaaa@naver.com');
insert into member(mid, pwd, name,mphone,email)values
('ccc','ccc','�̺�ȯ','1111-2222-3333','aaaa@naver.com');
insert into member(mid, pwd, name, mphone, email)values
('dp','1111','�̴�ǥ','010-2222-3333','aaaa@naver.com');
insert into member(mid, pwd, name,mphone,email)values
('eee','eee','������','1111-2222-3333','aaaa@naver.com');


select * from reservation; 

select * from camping_view where rowid IN (select max(rowid) from camping_view group by cname);

select count(*) as cnt from camping_view where rowid IN (select max(rowid) from camping_view group by cname);

drop sequence notice_seq;
create sequence notice_seq start with 1; 

insert into notice (nseq,aid,subject,content)values
(notice_seq.nextval,'scott', 'ķ�� �̺�Ʈ',
'[������ ķ���� �����ϴ� ������ ķ�� EVENT] ��ķ�� ��� ķ������ ���̹����� �����ϰ�,1�� �� �̻� N���̷� ���� �� 
�̿�Ϸ��� ������ 1�� ���� �ѱ��������簡 ���̹����� 1�� ���� ������ �帳�ϴ�! �ڼ��� �̺�Ʈ �Ⱓ �� ��������� �Խõ� 
�̹����� ���� Ȯ���� ������~! ���� ���ù��� : 1644-5690 (���̹� ������ ��ð� 09:00~18:00)
�̺�Ʈ ���ù��� : 02-6429-3801 )');
insert into notice (nseq,aid,subject,content)values
(notice_seq.nextval,'scott','��ķ��(�ʺ�ķ��)�� ���� �������ķ�� 5���Ģ �˸��� �̺�Ʈ>',
'�̼�1. ��ķ�� SNS �ȷο� �ϱ�! �̼�2. �Խñ� ��ۿ� ģ�� �±��Ͽ� ������� ķ�� 5�� �⺻��Ģ �θ�~ �θ�~ �˸���!
 �̼�1,2 ��� ������ �ҵ� �� 100�� ���� �ϻ�ȭź�� �溸��� �Ҹ��� ����ũ��!
�̼�2�� ������ �е� �� 200�в� �ռ������� �Ҹ��� ������ �帳�ϴ�!
���� ���� ��Ź�帳�ϴ�.');
insert into notice (nseq,aid,subject,content)values
(notice_seq.nextval,'scott','2022�� ��� �߿��� �������(1��) ������ȹ �ȳ�',
' �������� : 1. ��������ü ���� �� ����*(~21.9.30.), 2. ��������ü �ɻ� �� ��ü�� ��û(~10.7.)
 3. ������� Ȯ��(~10.22.), 4. ������ ����(11��~)     
* �������� ������ ������ �� ������, ����� Ȯ���� ����� ������ ���� ������ �Ұ��� �� �ִ� ��,
�ڼ��� ������ ����ü �������� �����Ͽ� �ֽñ� �ٶ��ϴ�.');

 create sequence reservation_seq start with 1; 
insert into reservation(reseq, cseq, mid, price, people, chk_in, chk_out)
values (reservation_seq.nextval, 1, 'qndrl12', 200000, 5, '2023/2/01','2023/2/03');


select * from RESERVATION where mid='dp';
select * from reservation;
select * from businessman;
select * from camping;

delete from BUSINESSMAN where bseq=8;
delete from BUSINESSMAN where bseq=9;
delete from BUSINESSMAN where bseq=10;


-- �� ����

-- reservation ���� ����ھ��̵�� ķ�����ȣ�� ���������� ķ���������� ��ȸ�ϴ� view�� ����
create or replace view reservate_view
as
select r.reseq, b.bid, c.cname, c.c_class, c.res_sta, r.mid, m.name, r.price, r.people, r.res_date, r.chk_in, r.chk_out
from reservation r, member m, businessman b, camping c
where m.mid = r.mid and r.cseq = c.cseq and b.bseq = c.bseq;

DROP view reservate_view CASCADE CONSTRAINTS;
select * from reservate_view;

select res_date from reservate_view;

select * from reservate_view;

-- favorites ���� ����ھ��̵�� ķ�����ȣ�� ���ã�� �� ķ���������� ��ȸ�ϴ� view ����
create or replace view favorites_view
as
select rownum as rn, f.fseq, f.bseq, m.mid, b.cname, b.phone, f.fav_check  
from favorites f, member m, businessman b
where f.mid = m.mid and f.bseq = b.bseq;

DROP view favorites_view CASCADE CONSTRAINTS;
select * from favorites_view;


-- camping ���� ķ���� �̸����� ���� ��ȸ�ϴ� view
create or replace view camping_view
as
select c.cseq, c.bseq, c.cname, b.caddress1, b.caddress2, b.caddress3, b.facilities,
		b.phone, b.image, c.c_image, b.content, c.c_content, b.category, c.c_class, c.res_sta, c.price,
		c.min_people, c.max_people, c.c_indate
from businessman b, camping c
where b.bseq = c.bseq;

DROP view camping_view CASCADE CONSTRAINTS;
select * from camping_view;

SELECT cseq, cname, caddress1, caddress2, caddress3, phone 
FROM camping_view where rowid in (select max(rowid) from camping_view GROUP BY cname);


select bseq, cname, content from (select * from camping_view order by c_indate desc) where rownum<=4;


-- review ���� ������ ķ�����̸� 
create or replace view review_view
as
select r.rseq, r.mid, r.bseq, r.content, r.indate, b.bname
from review r, businessman b
where b.bseq = r.bseq;




-- paging 

select * from ( 
select * from ( 
select rownum as rn, c.* from ((
select * from camping_view where rowid IN (
select max(rowid) from camping_view group by cname)) c)) where rn>=1) where rn<=10;




select bseq, cname, content, image from businessman where rownum<=4 order by bseq desc;

select bseq, cname, content, image 
from (select * from businessman order by bseq desc) 
where rownum<=4;


select * from ( select * from ( 
select rownum as rn, b.* from ((select * from businessman) b)) where rn>=1) where rn<=5;



select * from(select * from(SELECT * FROM businessman) where caddress1 like '%���%')where caddress2 like '%����%';





