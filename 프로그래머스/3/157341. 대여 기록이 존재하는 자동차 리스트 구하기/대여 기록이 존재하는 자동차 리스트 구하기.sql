-- 코드를 입력하세요
SELECT distinct(a.car_id)
    from CAR_RENTAL_COMPANY_CAR a
        inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY b
        on a.car_id = b.car_id
    where a.car_type = '세단'
        and date_format(b.start_date, '%m') = 10
    order by a.car_id desc
    ;