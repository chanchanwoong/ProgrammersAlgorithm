-- 코드를 입력하세요
select a.author_id, author_name, category, sum(a.price * c.sales) as 'total_sales'
    from book a, author b, book_sales c
    where a.author_id = b.author_id and a.book_id = c.book_id
        and date_format(sales_date,'%Y-%m') = '2022-01'
    group by b.author_name, a.category
    order by a.author_id, a.category desc
;