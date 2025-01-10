package org.example.carebridge.domain.board.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.example.carebridge.domain.user.entity.User;
import org.example.carebridge.global.entity.BaseEntity;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Entity
@Table(name = "board")
@DynamicInsert
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String tag;
    @Column(nullable = false, columnDefinition = "BIGINT default 0")
    private Long views;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Board() {}

    @Builder
    public Board(String title, String content, String tag, Long views, User user) {
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.views = views;
        this.user = user;
    }

    public void updateBoard(String title, String content, String tag) {
        this.title = title;
        this.content = content;
        this.tag = tag;
    }
}
