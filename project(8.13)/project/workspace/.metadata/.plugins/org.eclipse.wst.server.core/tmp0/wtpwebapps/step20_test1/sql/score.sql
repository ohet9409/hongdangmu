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
-- ������ ����
INSERT INTO score VALUES ('0001','ȫ�浿',100,100,100,300,100,SYSDATE);

-- ������ �˻�
SELECT * FROM score ORDER BY studNo asc;
SELECT * FROM score WHERE studNo ='0001';

-- ������ ����
DELETE score where studNo = '0001';

-- ����
UPDATE score SET name = '��浿', kor=100, eng=100,mat=100,tot=100,avg=100
where studNo ='0001';

-- DB ����
commit;
DROP TABLE score purge;

-- �ֱ� 10�� ���
select studNo, name, kor, eng, mat, tot, avg
from (select rownum rn,tt.*from(select * from score order by studNo asc)tt) where rn>=1 and rn<=10;
-- �� �ۼ�
select count(*) as count from score;