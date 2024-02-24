-- 코드를 입력하세요
select cart_id
    from (select cart_id from cart_products where name = 'milk') a
        inner join (select cart_id from cart_products where name = 'yogurt') b
        using(cart_id)
    order by cart_id;