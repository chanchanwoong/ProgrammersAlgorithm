-- 코드를 입력하세요
select product_code, sum(price * sales_amount) as 'sales'
    from product a
        join offline_sale b
        using(product_id)
    group by a.product_id
    order by sales desc, product_code