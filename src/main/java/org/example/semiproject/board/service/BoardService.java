package org.example.semiproject.board.service;

import org.example.semiproject.board.domain.Board;
import org.example.semiproject.board.dto.ListBoardDTO;
import java.util.List;

public interface BoardService {

    List<ListBoardDTO> readBoard(int cpg);
    Board readOneBoard(int bno);

}