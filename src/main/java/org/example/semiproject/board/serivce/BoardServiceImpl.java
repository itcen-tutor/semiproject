package org.example.semiproject.board.serivce;

import lombok.RequiredArgsConstructor;
import org.example.semiproject.board.domain.dto.ListBoardDTO;
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

