# select flavor, sum(a.total_order+ b.total_order )
#     from first_half a
#         inner join july b
#         using(flavor)
#     group by flavor
#     order by sum(a.total_order+ b.total_order )desc
    
select flavor
    from first_half a
        inner join july b
        using(flavor)
    group by flavor
    order by sum(a.total_order + b.total_order) desc
    limit 3
;