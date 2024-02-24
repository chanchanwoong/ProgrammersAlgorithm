-- 코드를 입력하세요
select a.animal_id, a.animal_type, a.name
    from animal_ins a, animal_outs b
    where a.animal_id = b.animal_id and a.sex_upon_intake like '%intact%' and (b.sex_upon_outcome like '%spayed%' or b.sex_upon_outcome like '%neutered%')
    order by a.animal_id
    ;