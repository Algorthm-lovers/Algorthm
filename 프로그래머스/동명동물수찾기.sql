-- 코드를 입력하세요
SELECT NAME, count(NAME) FROM ANIMAL_INS
where NAME is not null
group by NAME
Having count(NAME) > 1
order by NAME asc
