-- 코드를 입력하세요
select a.product_id, a.product_name, sum(a.price * b.amount) as 'total_sales'
    from food_product a
        inner join food_order b
        using(product_id)
    where date_format(produce_date, '%Y-%m') = '2022-05'
    group by a.product_id
    order by total_sales desc, a.product_id
;