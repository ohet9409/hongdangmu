package score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;
@Service
public class ScoreServiceImpl implements ScoreService{
	@Autowired
	private ScoreDAO scoreDAO;
	@Override
	public int scoreInput(ScoreDTO dto) {
		// TODO Auto-generated method stub
		return scoreDAO.scoreInput(dto);
	}

	@Override
	public int scoreDel(String studNo) {
		// TODO Auto-generated method stub
		return scoreDAO.scoreDel(studNo);
	}

	@Override
	public int scoreUpdate(ScoreDTO dto) {
		// TODO Auto-generated method stub
		return scoreDAO.scoreUpdate(dto);
	}

	@Override
	public ScoreDTO scoreView(String studNo) {
		// TODO Auto-generated method stub
		return scoreDAO.scoreView(studNo);
	}

	@Override
	public List<ScoreDTO> scoreList(int startNum, int endNum) {
		// TODO Auto-generated method stub
		return scoreDAO.scoreList(startNum, endNum);
	}

	@Override
	public int scoreCount() {
		// TODO Auto-generated method stub
		return scoreDAO.scoreCount();
	}

}
