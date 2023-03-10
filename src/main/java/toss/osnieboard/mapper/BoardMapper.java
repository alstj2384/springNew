package toss.osnieboard.mapper;


import org.springframework.stereotype.Repository;
import toss.osnieboard.domain.Board;

import java.util.List;


@Repository
public interface BoardMapper {

    int boardCount(); // 곧 생성할 BoardMapper.xml 첫번째 sql 문의 id 와 같음.

    List<Board> getList();

    Board getBoard(Long boardId);

    void uploadBoard(Board board);

    Object updateBoard(Board board);

    void deleteBoard(Long boardId);

}