-- 코드를 입력하세요
select category, sum(b.sales) as 'total_sales'
    from book a
        inner join book_sales b
        using(book_id)
    where date_format(b.sales_date, '%Y-%m') = '2022-01'
    group by category
    order by category
        ;