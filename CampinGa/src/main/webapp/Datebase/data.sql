drop sequence businessman_seq;
create sequence businessman_seq start with 1;

insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3, facilities, image, content, category) 
values(businessman_seq.nextval, 'dp', '1234', '�̴�ǥ', '010-1111-1111', 'abc@abc.com' , 
'�ؿ��� ������', '��⵵','���ֽ�', '��ϸ� �ؿ����� 78', '�ٺ�ť��, ������', 'camp01.jpg',
'�پ��� �������� ��ſ� �ϻ�Ż�� ���ִ� ���İ� ������ �ü� ģ���� ���� ������ ���񽺰� ���۵Ǵ� ����� ķ�����Դϴ�.', 'camping');

insert into businessman(bseq, bid, pwd, name, phone, email, cname, caddress1, caddress2, caddress3, facilities, image, content, category) 
values(businessman_seq.nextval, 'qwer', '1234', '�̿���', '010-1111-1111', 
'abc@abc.com' , '�Ѱ����� ����ķ����', '�����','������', '�Ѱ������� 28', 
'�ٺ�ť��, ����������', 'camp01.jpg',
'����ķ������ ����� ������ �����Ѱ������� �ڸ��ߴ�. �����Ϸ� ����뱳 �ϴ��� ���� �����Ѱ����� �������� ���� �����Ѵ�. �ڵ����� �̿��ϴ� ķ�۴� ������������ �̿��ؾ� �Ѵ�. ', 
'camping');

Insert into BUSINESSMAN(BSEQ,BID,PWD,NAME,PHONE,EMAIL,CNAME,CADDRESS1,CADDRESS2,CADDRESS3,FACILITIES,IMAGE,CONTENT,CATEGORY) 
values (businessman_seq.nextval,'aaa','1234','�̿���','010-6666-1111','abc@abc.com',
'ȭ�罣�븮ķ����','��û�ϵ�','���걺','ûõ�� ȭ��� 834-9',null,null,null,null);

Insert into BUSINESSMAN(BSEQ,BID,PWD,NAME,PHONE,EMAIL,CNAME,CADDRESS1,CADDRESS2,CADDRESS3,FACILITIES,IMAGE,CONTENT,CATEGORY) 
values (businessman_seq.nextval,'bbb','1234','�̿���','010-6666-1111','abc@abc.com',
'��ȱ۷κ�','���ϵ�','���ֽ�','������ �������� 1124-50',null,null,null,null);

Insert into BUSINESSMAN(BSEQ,BID,PWD,NAME,PHONE,EMAIL,CNAME,CADDRESS1,CADDRESS2,CADDRESS3,FACILITIES,IMAGE,CONTENT,CATEGORY) 
values (businessman_seq.nextval,'ccc','1234','�̿���','010-6666-1111','abc@abc.com',
'����������ũ ����ķ����','������','Ⱦ����','�г��� �ο��� 194 �ο���',null,null,null,null);

Insert into BUSINESSMAN(BSEQ,BID,PWD,NAME,PHONE,EMAIL,CNAME,CADDRESS1,CADDRESS2,CADDRESS3,FACILITIES,IMAGE,CONTENT,CATEGORY) 
values (businessman_seq.nextval,'ddd','1234','�̿���','010-6666-1111','abc@abc.com',
'���ķ����','������','������','���������� ������ 158',null,null,null,null);

Insert into BUSINESSMAN(BSEQ,BID,PWD,NAME,PHONE,EMAIL,CNAME,CADDRESS1,CADDRESS2,CADDRESS3,FACILITIES,IMAGE,CONTENT,CATEGORY) 
values (businessman_seq.nextval,'eee','1234','�̿���','010-6666-1111','abc@abc.com',
'����ƶ�����ķ��','����ϵ�','�ξȱ�','������ ���°����� 38',null,null,null,null);

Insert into BUSINESSMAN(BSEQ,BID,PWD,NAME,PHONE,EMAIL,CNAME,CADDRESS1,CADDRESS2,CADDRESS3,FACILITIES,IMAGE,CONTENT,CATEGORY) 
values (businessman_seq.nextval,'fff','1234','�̿���','010-6666-1111','abc@abc.com',
'ź���� ���� ķ����','��⵵','�Ȼ��','�ܿ��� ���Ȳ�ݷ� 17-2',null,null,null,null);

Insert into BUSINESSMAN(BSEQ,BID,PWD,NAME,PHONE,EMAIL,CNAME,CADDRESS1,CADDRESS2,CADDRESS3,FACILITIES,IMAGE,CONTENT,CATEGORY) 
values (businessman_seq.nextval,'ggg','1234','�̿�ĥ','010-6666-1111','abc@abc.com',
'ī���2696','��⵵','�����ֽ�','ȭ���� ���ϸ� 8-2',null,null,null,null);

Insert into BUSINESSMAN(BSEQ,BID,PWD,NAME,PHONE,EMAIL,CNAME,CADDRESS1,CADDRESS2,CADDRESS3,FACILITIES,IMAGE,CONTENT,CATEGORY) 
values (businessman_seq.nextval,'hhh','1234','�̿���','010-6666-1111','abc@abc.com',
'������� ��â�� ķ����','��⵵','�����ֽ�','���з� 344-0',null,null,null,null);

Insert into BUSINESSMAN(BSEQ,BID,PWD,NAME,PHONE,EMAIL,CNAME,CADDRESS1,CADDRESS2,CADDRESS3,FACILITIES,IMAGE,CONTENT,CATEGORY) 
values (businessman_seq.nextval,'iii','1234','�̿���','010-6666-1111','abc@abc.com',
'��Ϻ�ϱ۷���','��⵵','��õ��','���̸� �ݰ��� 2625-37',null,null,null,null);

Insert into BUSINESSMAN(BSEQ,BID,PWD,NAME,PHONE,EMAIL,CNAME,CADDRESS1,CADDRESS2,CADDRESS3,FACILITIES,IMAGE,CONTENT,CATEGORY) 
values (businessman_seq.nextval,'jjj','1234','�̿���','010-6666-1111','abc@abc.com',
'������ ķ����','��⵵','��õ��','������ ������606���� 110',null,null,null,null);