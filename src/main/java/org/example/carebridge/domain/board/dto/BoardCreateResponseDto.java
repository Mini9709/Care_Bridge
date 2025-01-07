package org.example.carebridge.domain.board.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardCreateResponseDto {
    private String title;
    private String content;
    private String tag;
    private Long views;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public BoardCreateResponseDto(String title, String content, String tag, Long views, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.views = views;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
