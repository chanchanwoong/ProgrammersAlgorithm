-- 코드를 입력하세요
# SELECT year(sales_date) as 'year', month(sales_date) as 'month', gender, count(distinct user_id) as 'users'
#     from user_info a
#         inner join online_sale b
#         using(user_id)
#     group by year, month, gender
#     having gender is not null
# ;

select year(sales_date), month(sales_date), gender, count(distinct user_id)
    from user_info a
        inner join online_sale b
        using(user_id)
    where gender is not null
    group by year(sales_date), month(sales_date), gender
    order by year(sales_date), month(sales_date), gender
    ;