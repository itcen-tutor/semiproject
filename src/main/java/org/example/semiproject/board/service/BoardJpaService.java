package org.example.semiproject.board.service;

import java.util.List;

import org.example.semiproject.board.entity.Board;
import org.example.semiproject.board.entity.BoardListView;
import org.springframework.data.domain.Page;

public interface BoardJpaService {

    Page<BoardListView> getBoardList(int cpg);
    List<BoardListView> getBoardList();
    Board getBoardOne(int bno);

}
