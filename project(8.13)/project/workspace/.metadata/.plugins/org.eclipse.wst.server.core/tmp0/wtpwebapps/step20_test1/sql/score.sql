CREATE TABLE score(
    studNo varchar(20) primary key,
    name VARCHAR2(30) not null,
    kor number,
    eng number,
    mat number,
    tot number,
    avg number(4,1),
    logtime date
);
-- 데이터 저장
INSERT INTO score VALUES ('0001','홍길동',100,100,100,300,100,SYSDATE);

-- 데이터 검색
SELECT * FROM score ORDER BY studNo asc;
SELECT * FROM score WHERE studNo ='0001';

-- 데이터 삭제
DELETE score where studNo = '0001';

-- 수정
UPDATE score SET name = '고길동', kor=100, eng=100,mat=100,tot=100,avg=100
where studNo ='0001';

-- DB 저장
commit;
DROP TABLE score purge;

-- 최근 10개 출력
select studNo, name, kor, eng, mat, tot, avg
from (select rownum rn,tt.*from(select * from score order by studNo asc)tt) where rn>=1 and rn<=10;
-- 총 글수
select count(*) as count from score;