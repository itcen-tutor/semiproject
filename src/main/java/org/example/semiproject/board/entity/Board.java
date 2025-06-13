package org.example.semiproject.board.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "boards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bno")
    private Long bno;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "userid", nullable = false, length = 50)
    private String userid;

    @CreatedDate
    @Column(name = "regdate", nullable = false, updatable = false)
    private LocalDateTime regdate;

    @Column(name = "thumbs", columnDefinition = "integer default 0")
    private Integer thumbs = 0;

    @Column(name = "views", columnDefinition = "integer default 0")
    private Integer views = 0;

    @Lob
    @Column(name = "contents", columnDefinition = "TEXT")
    private String contents;

}

