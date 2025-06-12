package org.example.semiproject.board.service;

import lombok.RequiredArgsConstructor;
import org.example.semiproject.board.dto.ListBoardDTO;
import org.example.semiproject.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardMapper;

    @Override
    public List<ListBoardDTO> readBoard() {
        return boardMapper.selectBoard();
    }

}
