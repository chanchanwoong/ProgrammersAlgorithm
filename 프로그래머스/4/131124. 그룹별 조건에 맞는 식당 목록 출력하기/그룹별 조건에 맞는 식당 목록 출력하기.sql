-- 코드를 입력하세요
# select member_name, review_text, date_format(review_date, '%Y-%m-%d') 
#     from member_profile a
#         inner join rest_review b
#         using(member_id)
#     where member_name = (select member_name from member_profile c
#                                 inner join rest_review d
#                                 using(member_id)
#                                 group by member_id
#                                 order by count(member_id) desc limit 1)
#     order by review_date, review_text
#     ;

select member_name, review_text, date_format(review_date, '%Y-%m-%d')
    from member_profile a
        inner join rest_review b
        using(member_id)
    where member_id = (select member_id
                                from member_profile c
                                    inner join rest_review b
                                    using(member_id)
                                group by member_id
                                order by count(member_id) desc limit 1)
                                order by review_date, review_text
                                
                                
                                
;