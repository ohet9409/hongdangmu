package goods_board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goods_board.bean.Goods_boardDTO;
import goods_board.dao.Goods_boardDAO;
@Service
public class Goods_boardServiceImpl implements Goods_boardService{
	@Autowired
	private Goods_boardDAO dao;
	public int boardWrite(Goods_boardDTO boardDTO) {
		// TODO Auto-generated method stub
		return dao.boardWrite(boardDTO);
	}

	public int boardDelete(int num) {
		// TODO Auto-generated method stub
		return dao.boardDelete(num);
	}

	public int updateRC(int num) {
		// TODO Auto-generated method stub
		return dao.updateRC(num);
	}

	public int updateIC(int num) {
		// TODO Auto-generated method stub
		return dao.updateIC(num);
	}

	public int boardModify(Goods_boardDTO boardDTO) {
		// TODO Auto-generated method stub
		return dao.boardModify(boardDTO);
	}

	public Goods_boardDTO boardView(int num) {
		// TODO Auto-generated method stub
		return dao.boardView(num);
	}

	public List<Goods_boardDTO> boardList(int startNum, int endNum) {
		// TODO Auto-generated method stub
		return dao.boardList(startNum, endNum);
	}

	public int getTotalA() {
		// TODO Auto-generated method stub
		return dao.getTotalA();
	}

	public List<Goods_boardDTO> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

}
