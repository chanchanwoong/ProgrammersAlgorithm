-- 코드를 입력하세요
SELECT concat('/home/grep/src/', b.board_id, '/', b.file_id, b.file_name, b.file_ext) as 'FILE_PATH'
    from used_goods_board a
        inner join used_goods_file b
        on a.board_id = b.board_id
    where a.views = (select max(views) from used_goods_board)
    order by b.file_id desc
;