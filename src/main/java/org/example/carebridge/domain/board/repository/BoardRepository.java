package org.example.carebridge.domain.board.repository;

import org.example.carebridge.domain.board.entity.Board;
import org.example.carebridge.global.exception.ExceptionType;
import org.example.carebridge.global.exception.ForbiddenException;
import org.example.carebridge.global.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select distinct b from Board b ORDER BY b.createdAt DESC ")
    List<Board> findAll();

    default Board findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(ExceptionType.BOARD_NOT_FOUND));
    }

    default Board findByIdOrElseThrowAndCheckUserId(Long boardId, Long userId) {
        Board board = findById(boardId).orElseThrow(() -> new NotFoundException(ExceptionType.BOARD_NOT_FOUND));

        if(!board.getUser().getId().equals(userId)){
            throw new ForbiddenException(ExceptionType.FORBIDDEN_ACTION);
        }

        return board;
    }
}
