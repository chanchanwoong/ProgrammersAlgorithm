-- 코드를 입력하세요
select animal_id, a.name
    from animal_outs a
        left join animal_ins b
        using(animal_id)
    where b.animal_id is null
    order by animal_id
        ;