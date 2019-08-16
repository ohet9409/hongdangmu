package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boarddao;
	@Override
	public int boardWrite(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return boarddao.boardWrite(boardDTO);
	}

	@Override
	public List<BoardDTO> boardList(int startNum, int endNum) {
		// TODO Auto-generated method stub
		return boarddao.boardList(startNum, endNum);
	}

	@Override
	public BoardDTO boardView(int seq) {
		// TODO Auto-generated method stub
		return boarddao.boardView(seq);
	}

	@Override
	public int getTotalA() {
		// TODO Auto-generated method stub
		return boarddao.getTotalA();
	}

	@Override
	public int updateHit(int seq) {
		// TODO Auto-generated method stub
		return boarddao.updateHit(seq);
	}

	@Override
	public int boardDelete(int seq) {
		// TODO Auto-generated method stub
		return boarddao.boardDelete(seq);
	}

	@Override
	public int boardModify(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return boarddao.boardModify(boardDTO);
	}

}
