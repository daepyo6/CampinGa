-- ����� ������ ���� --
drop sequence businessman_seq;
create sequence businessman_seq start with 1;



-- ����� �Է� --
insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3) 
values(businessman_seq.nextval, 'bn', '1234', '�躸��', '010-1111-1111', 'abc@abc.com' , 
'�ؿ��� ������', '��⵵','���ֽ�', '��ϸ� �ؿ����� 78');
insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3) 
values(businessman_seq.nextval, 'wr', '1234', '��츮', '010-1111-2222', 'abc@abc.com' , 
'���� ��Ÿ�콺', '���ϵ�',' ���ֽ�', '������ �սŽ���ȱ� 5');
insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3) 
values(businessman_seq.nextval, 'bh', '1234', '�̺�ȯ', '010-1111-3333', 'abc@abc.com' , 
'��õ �������', '��⵵','��õ��', '�峲�� ����330���� 137-28');
insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3) 
values(businessman_seq.nextval, 'dp', '1234', '�̴�ǥ', '010-1111-4444', 'abc@abc.com' , 
'ȫõ �ؼ�ķ����', '������','ȫõ��', '���̸� ����� 91');
insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3) 
values(businessman_seq.nextval, 'hw', '1234', '������', '010-1111-5555', 'abc@abc.com' , 
'�¾� ������ ķ�γ��', '��û����','�¾ȱ�', '�̿��� ���������� 103-10');

select * from businessman;



-- ������ �Է� -- 
insert into admin(aid, pwd)
values('scott', '1234');


-- ���ã�� ������ ���� --
drop sequence favorites_seq;
create sequence favorites_seq start with 1;


insert into favorites(fseq, mid, cseq)
values(favorites_seq.nextval, 'dp', 2);

select * from favorites; 

-- ���� ������ ���� --
drop sequence review_seq;
create sequence review_seq start with 1;

insert into review(rseq, bseq, mid, content)
values(review_seq.nextval, 2, 'dp', '���� ���ƿ�');



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
'w-1.jpg','�پ��� �������� ��ſ� �ϻ�Ż�� ���ִ� ���İ� ������ �ü� ģ���� ���� �������� ���񽺰� ���۵Ǵ� ����� ķ�����Դϴ�.',
'ķ����','�ؿ��� A', 'n', 100000, 4, 10);

select * from camping;
s
drop sequence qna_seq;
create sequence qna_seq start with 1;

insert  into camp_qna(qseq, mid, bseq, content , repyn)values
(qna_seq.nextval, 'dp', 1,'�ٺ�ť�� �ֳ���?','n');
insert  into camp_qna(qseq, mid, bseq, content , reply, repyn)values
(qna_seq.nextval, 'dp', 1,'�������ճ���?','�ƴϿ� �����ϴ�','y');
  
select * from camp_qna;  

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


create sequence notice_seq start with 1; 

insert into notice (nseq,aid,subject,content)values
(notice_seq.nextval,'scott', '[��������][EVENT]2022 ������ ķ�� �̺�Ʈ!',
'[������ ķ���� �����ϴ� ������ ķ�� EVENT] ��ķ�� ��� ķ������ ���̹����� �����ϰ�,1�� �� �̻� N���̷� ���� �� 
�̿�Ϸ��� ������ 1�� ������ �ѱ��������簡 ���̹����� 1�� ���� ������ �帳�ϴ�! �ڼ��� �̺�Ʈ �Ⱓ �� ��������� �Խõ� 
�̹����� ���� Ȯ���� ������~! ���� ���ù��� : 1644-5690 (���̹� �������� ��ð� 09:00~18:00)
�̺�Ʈ ���ù��� : 02- 6429-3801 )');
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
insert into reservation(reseq, cseq, mid, price, people, chk_in, chk_out)values
(reservation_seq.nextval, 2, 'dp', 150000, 5, '2023/1/01','2023/1/03');
insert into reservation(reseq,cseq,mid,price,people,chk_in,chk_out)values
(reservation_seq.nextval,camping_seq.nextval,'aaa','200000','4','2023/1/11','2023/1/23');
insert into reservation(reseq,cseq,mid,price,people,chk_in,chk_out)values
(reservation_seq.nextval,camping_seq.nextval,'aaa','250000','8','2023/1/21','2023/2/03');


select * from RESERVATION;