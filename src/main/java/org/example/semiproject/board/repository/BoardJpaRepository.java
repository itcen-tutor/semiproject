package org.example.semiproject.board.repository;

import java.util.List;

import org.example.semiproject.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardJpaRepository extends PagingAndSortingRepository<Board, Integer> {
    
    // 전체 게시글 목록 조회 (페이징)
    Page<Board> findAllByOrderByBnoDesc(Pageable pageable);

    // 페이징 없는 전체 게시글 조회 (최신순)
    List<Board> findAllByOrderByBnoDesc();

}

