create table users (
    user_code number primary key,             -- 사용자 코드	
    user_name varchar2(20) not null,          -- 사용자 이름
    user_photo varchar2(50),                  -- 프로필 사진
    user_area varchar2(50),                   -- 지역 
    manner number not null,                   -- 평점	
    reply_percent number not null,            -- 응답률
    sales_count number not null,              -- 판매 개수
    purchase_count number not null,           -- 구매 개수
    interest_count number not null,           -- 관심목록 개수	
    join_date date not null                   -- 가입 날짜
);

insert into users values (1, '홍길동', 'asd.jpg', '서울시 서초구' , 5, 90, 5, 2, 3, sysdate);
select * from users where user_code = 1 and user_name = '홍길동';
select user_code from users where user_code = 1;
select * from users where user_code = 1;
select * from users ;
delete users where user_code = 1;
UPDATE users set user_name = '고길동', user_photo ='aa.jpg', 
user_area='경기도',manner=5, reply_percent=90,sales_count=1,
purchase_count=1, interest_count=5 where user_code = 1;
select * from(select rownum rn, tt.* from 
		(select * from users order by name asc) tt) 
		where rn>=0 and rn<=10;
select count(*) as count from users;


create table goods (
    user_code number,                       -- 판매자 코드
    board_seq number primary key,           -- 상품 번호
    category_code varchar2(20) not null,    -- 물품분류
    goods_name varchar2(20) not null,       -- 상품 이름
    goods_price number not null,            --상품 가격
    seller_content varchar2(200),           -- 판매자 멘트
    bargain_tf number not null,             -- 흥정가능 유무
    chat_count number not null,             -- 채팅 개수
    reply_count number not null,            -- 댓글 갯수
    interest_count number not null,         -- 관심 갯수
    hits number not null,                   -- 조회수
    reg_date date not null,                 -- 작성 날짜
    area varchar(100) not null,             -- 판매 지역
    users_pass varchar2(20) not null,       -- 글 비밀번호
    board_subject varchar2(255) not null,   -- 글 제목
    board_content varchar2(4000) not null,  -- 글 내용
    board_file varchar2(50) not null,       -- 첨부파일
    board_re_ref number not null,           -- 관련글번호
    board_re_lev number not null,           -- 답글 레벨
    board_re_seq number not null,           -- 관련글 중 출력순서
    board_readcount number default 0,       -- 조회수
    --constraint  foreign key (user_code) references users (user_code)
    --on delete cascade
);

insert into product values (1, 1, '디지털/전자', '선풍기', 1000, '아주 좋아요', 0, 0, 0, 0, 0, sysdate, '서울시 서초구');

drop table users purge;
drop table product purge;

select * from users;
select *
from product p ,users u
where u.user_code=p.user_code;

create table reply (
    reply_seq number,                      -- 글번호
    user_code number,                      -- 사용자 코드
    user_name varchar2(50) not null,       -- 작성자
    user_area varchar2(100) not null,      -- 지역
    reply_content varchar2(100) not null,  -- 댓글 내용
    reply_date date,                       -- 작성일
    primary key(reply_seq),
    --foreign key (user_code) references users (user_code)
);

select *from users u, reply r
where r.user_code = 1;

-- 테이블 제거
drop table reply purge;

-- 시퀀스 객체 생성
create sequence seq nocycle nocache;
-- 시퀀스 객체 삭제
drop sequence seq;

-- 데이터 저장
insert into reply values (1, 1, '고길동', '서울시 서초동', '물품을 팝니다' , sysdate);

-- 데이터 삭제 
delete reply where seq = 1;

-- 데이터 검색
select * from reply;


commit;
---------------------------------------
-- 테이블 생성
create table board2(
    board_num number,                       -- 글 번호
    board_name varchar2(20) not null,       -- 글 작성자
    board_pass varchar2(20) not null,       -- 글 비밀번호
    board_subject varchar2(255) not null,   -- 글 제목
    board_content varchar2(4000) not null,  -- 글 내용
    board_file varchar2(50) not null,       -- 첨부파일
    board_re_ref number not null,           -- 관련글번호
    board_re_lev number not null,           -- 답글 레벨
    board_re_seq number not null,           -- 관련글 중 출력순서
    board_readcount number default 0,       -- 조회수
    board_date date,                        -- 작성일
    primary key(board_num)                  -- 기본키 설정(글번호)
);
-- 답글 인덱스 뷰
select * from (select rownum rn, tt.*from(select * from board2 order by board_re_ref desc, board_re_seq asc)tt)
where rn>=1 and rn <=10;
-- 답글 저장
-- 1. 기존 답글의 등록순서를 재정리
--  => 원글 re_seq보다 큰 답글 re_seq를 1씩 증가
-- 예)DAO에서
update board2 set board_re_seq = board_re_seq+1
where board_re_ref=10 and board_re_seq>0;
-- 2. 추가된 답글의 re_seq는 원글 re_seq에 1증가한 값을 가진다.
--     또한, 추가된 답글의 re_lev는 원글 re_lev에 증가한 값을 가진다.
-- 예)DAO에서 re_seq = re_seq+1; re_lev = re_lev+1;
insert into BOARD2 values(seq_num.nextval,'홍길동','1234','내일은','웃으리','aa.jpg',re_ref,re_lev,re_seq,0,sysdate);
insert into BOARD2 values(seq_num.nextval,'홍길동','1234','내일은','웃으리','aa.jpg',0,re_lev+1,re_seq+1,0,sysdate);
select board_num, board_subject, board_name, board_date, board_readcount
from (select rownum rn,tt.*from(select * from board2 order by board_num desc)tt) where rn>=1 and rn<=10;

-- 조회수 증가
UPDATE board2 set board_readcount = board_readcount+1 where board_num = 43;
-- 데이터 수정
UPDATE board2 set board_file='aa.jpg',board_name = 'a',board_pass='a',board_subject='a',board_content='a' where board_num = 43;
select count(*) as count from board2;
-- 테이블 삭제
drop table board2 purge;

-- 시퀀스 객체 생성
create sequence seq_num nocycle nocache;

-- 시퀀스 객체 삭제
drop sequence seq_num;

-- 데이터 저장
insert into board2 values (seq_num.nextval, '홍길동','1234','내일은','웃으리',
    'aa.jpg',seq_num.currval,0,0,0,sysdate);
insert into board2 values (seq_num.nextval, '홍길동','1234','내일은','웃으리',
    'aa.jpg',seq_num.currval,0,0,0,sysdate);

-- 데이터 검색
select*from board2;
select*from board2 where board_num = 43;

-- 데이터 총 갯수 구하기
select count(*) from board2;

-- 데이터 삭제
delete board2 where board_num=1;

-- DB 저장
commit;