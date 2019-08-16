package board.controller;

import java.util.List;

import board.bean.BoardDTO;

public interface BoardService {
	int boardWrite(BoardDTO boardDTO);
	List<BoardDTO> boardList(int startNum, int endNum);
	BoardDTO boardView(int seq);
	int getTotalA();
	int updateHit(int seq);
	int boardDelete(int seq);
	int boardModify(BoardDTO boardDTO);
}
