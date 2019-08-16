create table users (
    user_code number primary key,             -- ����� �ڵ�	
    user_name varchar2(20) not null,          -- ����� �̸�
    user_photo varchar2(50),                  -- ������ ����
    user_area varchar2(50),                   -- ���� 
    manner number not null,                   -- ����	
    reply_percent number not null,            -- �����
    sales_count number not null,              -- �Ǹ� ����
    purchase_count number not null,           -- ���� ����
    interest_count number not null,           -- ���ɸ�� ����	
    join_date date not null                   -- ���� ��¥
);

insert into users values (1, 'ȫ�浿', 'asd.jpg', '����� ���ʱ�' , 5, 90, 5, 2, 3, sysdate);
select * from users where user_code = 1 and user_name = 'ȫ�浿';
select user_code from users where user_code = 1;
select * from users where user_code = 1;
select * from users ;
delete users where user_code = 1;
UPDATE users set user_name = '��浿', user_photo ='aa.jpg', 
user_area='��⵵',manner=5, reply_percent=90,sales_count=1,
purchase_count=1, interest_count=5 where user_code = 1;
select * from(select rownum rn, tt.* from 
		(select * from users order by name asc) tt) 
		where rn>=0 and rn<=10;
select count(*) as count from users;


create table goods (
    user_code number,                       -- �Ǹ��� �ڵ�
    board_seq number primary key,           -- ��ǰ ��ȣ
    category_code varchar2(20) not null,    -- ��ǰ�з�
    goods_name varchar2(20) not null,       -- ��ǰ �̸�
    goods_price number not null,            --��ǰ ����
    seller_content varchar2(200),           -- �Ǹ��� ��Ʈ
    bargain_tf number not null,             -- �������� ����
    chat_count number not null,             -- ä�� ����
    reply_count number not null,            -- ��� ����
    interest_count number not null,         -- ���� ����
    hits number not null,                   -- ��ȸ��
    reg_date date not null,                 -- �ۼ� ��¥
    area varchar(100) not null,             -- �Ǹ� ����
    users_pass varchar2(20) not null,       -- �� ��й�ȣ
    board_subject varchar2(255) not null,   -- �� ����
    board_content varchar2(4000) not null,  -- �� ����
    board_file varchar2(50) not null,       -- ÷������
    board_re_ref number not null,           -- ���ñ۹�ȣ
    board_re_lev number not null,           -- ��� ����
    board_re_seq number not null,           -- ���ñ� �� ��¼���
    board_readcount number default 0,       -- ��ȸ��
    --constraint  foreign key (user_code) references users (user_code)
    --on delete cascade
);

insert into product values (1, 1, '������/����', '��ǳ��', 1000, '���� ���ƿ�', 0, 0, 0, 0, 0, sysdate, '����� ���ʱ�');

drop table users purge;
drop table product purge;

select * from users;
select *
from product p ,users u
where u.user_code=p.user_code;

create table reply (
    reply_seq number,                      -- �۹�ȣ
    user_code number,                      -- ����� �ڵ�
    user_name varchar2(50) not null,       -- �ۼ���
    user_area varchar2(100) not null,      -- ����
    reply_content varchar2(100) not null,  -- ��� ����
    reply_date date,                       -- �ۼ���
    primary key(reply_seq),
    --foreign key (user_code) references users (user_code)
);

select *from users u, reply r
where r.user_code = 1;

-- ���̺� ����
drop table reply purge;

-- ������ ��ü ����
create sequence seq nocycle nocache;
-- ������ ��ü ����
drop sequence seq;

-- ������ ����
insert into reply values (1, 1, '��浿', '����� ���ʵ�', '��ǰ�� �˴ϴ�' , sysdate);

-- ������ ���� 
delete reply where seq = 1;

-- ������ �˻�
select * from reply;


commit;
---------------------------------------
-- ���̺� ����
create table board2(
    board_num number,                       -- �� ��ȣ
    board_name varchar2(20) not null,       -- �� �ۼ���
    board_pass varchar2(20) not null,       -- �� ��й�ȣ
    board_subject varchar2(255) not null,   -- �� ����
    board_content varchar2(4000) not null,  -- �� ����
    board_file varchar2(50) not null,       -- ÷������
    board_re_ref number not null,           -- ���ñ۹�ȣ
    board_re_lev number not null,           -- ��� ����
    board_re_seq number not null,           -- ���ñ� �� ��¼���
    board_readcount number default 0,       -- ��ȸ��
    board_date date,                        -- �ۼ���
    primary key(board_num)                  -- �⺻Ű ����(�۹�ȣ)
);
-- ��� �ε��� ��
select * from (select rownum rn, tt.*from(select * from board2 order by board_re_ref desc, board_re_seq asc)tt)
where rn>=1 and rn <=10;
-- ��� ����
-- 1. ���� ����� ��ϼ����� ������
--  => ���� re_seq���� ū ��� re_seq�� 1�� ����
-- ��)DAO����
update board2 set board_re_seq = board_re_seq+1
where board_re_ref=10 and board_re_seq>0;
-- 2. �߰��� ����� re_seq�� ���� re_seq�� 1������ ���� ������.
--     ����, �߰��� ����� re_lev�� ���� re_lev�� ������ ���� ������.
-- ��)DAO���� re_seq = re_seq+1; re_lev = re_lev+1;
insert into BOARD2 values(seq_num.nextval,'ȫ�浿','1234','������','������','aa.jpg',re_ref,re_lev,re_seq,0,sysdate);
insert into BOARD2 values(seq_num.nextval,'ȫ�浿','1234','������','������','aa.jpg',0,re_lev+1,re_seq+1,0,sysdate);
select board_num, board_subject, board_name, board_date, board_readcount
from (select rownum rn,tt.*from(select * from board2 order by board_num desc)tt) where rn>=1 and rn<=10;

-- ��ȸ�� ����
UPDATE board2 set board_readcount = board_readcount+1 where board_num = 43;
-- ������ ����
UPDATE board2 set board_file='aa.jpg',board_name = 'a',board_pass='a',board_subject='a',board_content='a' where board_num = 43;
select count(*) as count from board2;
-- ���̺� ����
drop table board2 purge;

-- ������ ��ü ����
create sequence seq_num nocycle nocache;

-- ������ ��ü ����
drop sequence seq_num;

-- ������ ����
insert into board2 values (seq_num.nextval, 'ȫ�浿','1234','������','������',
    'aa.jpg',seq_num.currval,0,0,0,sysdate);
insert into board2 values (seq_num.nextval, 'ȫ�浿','1234','������','������',
    'aa.jpg',seq_num.currval,0,0,0,sysdate);

-- ������ �˻�
select*from board2;
select*from board2 where board_num = 43;

-- ������ �� ���� ���ϱ�
select count(*) from board2;

-- ������ ����
delete board2 where board_num=1;

-- DB ����
commit;