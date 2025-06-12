package org.example.semiproject.board.service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.example.semiproject.board.dto.ListBoardDTO;
import org.example.semiproject.board.entity.Board;
import org.example.semiproject.board.repository.BoardJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardJpaServiceImpl implements BoardJpaService {

    private final BoardJpaRepository boardRepository;

    // 전체 게시글 목록 조회
    public Page<ListBoardDTO> getBoardList(int cpg) {
        Pageable pageable = PageRequest.of(cpg - 1, 25);
        Page<Board> boardPage = boardRepository.findAllByOrderByBnoDesc(pageable);

        return boardPage.map(ListBoardDTO::new);
    }

    @Override
    public List<ListBoardDTO> getBoardList() {
        // 페이징 없는 전체 게시글 조회 (최신순)
        List<Board> boards = boardRepository.findAllByOrderByBnoDesc();
        return boards.stream().map(ListBoardDTO::new).toList();
    }

}
