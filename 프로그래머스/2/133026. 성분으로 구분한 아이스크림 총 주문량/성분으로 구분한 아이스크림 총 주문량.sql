-- 코드를 입력하세요
select ingredient_type, sum(total_order) as 'total_order'
    from first_half a
        inner join icecream_info b
        on a.flavor = b.flavor
    group by ingredient_type
    order by total_order
;