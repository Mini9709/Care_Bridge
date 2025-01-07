package org.example.carebridge.domain.board.repository;

import org.example.carebridge.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select distinct b from Board b ORDER BY b.createdAt DESC ")
    List<Board> findAll();

    default Board findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new IllegalArgumentException("해당하는 게시판을 찾을 수 없습니다."));
    }
}