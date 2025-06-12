package org.example.semiproject.board.dto;

import java.time.LocalDateTime;

import org.example.semiproject.board.entity.Board;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListBoardDTO {
    private Long bno;
    private String title;
    private String userid;
    private LocalDateTime regdate;
    private Integer thumbs;
    private Integer views;
    
    // 생성자 (Entity -> DTO 변환용)
    public ListBoardDTO(Board board) {
        this.bno = board.getBno();
        this.title = board.getTitle();
        this.userid = board.getUserid();
        this.regdate = board.getRegdate();
        this.thumbs = board.getThumbs();
        this.views = board.getViews();
    }
}

