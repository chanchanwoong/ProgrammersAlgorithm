-- 코드를 입력하세요
select book_id, author_name, date_format(published_date, '%Y-%m-%d')
    from book a
        inner join author b
        using(author_id)
    where category = '경제'
    order by published_date