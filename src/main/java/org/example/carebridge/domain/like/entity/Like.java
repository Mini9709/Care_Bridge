package org.example.carebridge.domain.like.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.carebridge.domain.board.entity.Board;
import org.example.carebridge.domain.user.entity.User;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "likes") // MySQL 예약어를 피하기 위해 테이블 이름 변경
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
