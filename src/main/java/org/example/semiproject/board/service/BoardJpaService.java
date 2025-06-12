package org.example.semiproject.board.service;

import java.util.List;

import org.example.semiproject.board.dto.ListBoardDTO;
import org.springframework.data.domain.Page;

public interface BoardJpaService {

    Page<ListBoardDTO> getBoardList(int cpg);
    List<ListBoardDTO> getBoardList();

}