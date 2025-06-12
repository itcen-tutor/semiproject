package org.example.semiproject.board.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.semiproject.board.dto.ListBoardDTO;

import java.util.List;

@Mapper
public interface BoardRepository {

    @Select("select bno, title, userid, regdate, thumbs, views from boards order by bno desc")
    List<ListBoardDTO> selectBoard();

}
