-- 코드를 입력하세요
set @hour = -1;

select (@hour := @hour + 1) 'hour'
    , (select count(hour(datetime)) from animal_outs where hour(datetime) = @hour) 'count'
    from animal_outs
    where @hour < 23;

# select hour(datetime) 'hour', count(*)
#     from animal_outs
#     group by hour
#     order by hour;