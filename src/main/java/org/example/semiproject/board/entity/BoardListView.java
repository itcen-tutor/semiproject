package org.example.semiproject.board.entity;

import java.time.LocalDateTime;

public interface BoardListView {
    Long getBno();
    String getTitle();
    String getUserid();
    LocalDateTime getRegdate();
    String getThumbs(); // ← 추가만 하면 자동으로 쿼리 변경
    String getViews(); // ← 추가만 하면 자동으로 쿼리 변경
}
