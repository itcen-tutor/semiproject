package org.example.semiproject.board.serivce;

import org.example.semiproject.board.domain.dto.ListBoardDTO;

import java.util.List;

public interface BoardService {

    List<ListBoardDTO> readBoard(int cpg);

}
