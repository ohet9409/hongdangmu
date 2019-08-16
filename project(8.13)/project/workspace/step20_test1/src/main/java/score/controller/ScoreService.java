package score.controller;

import java.util.List;

import score.bean.ScoreDTO;
// 사용안해도 관계없음
public interface ScoreService {
	public int scoreInput(ScoreDTO dto);
	public int scoreDel(String studNo);
	public int scoreUpdate(ScoreDTO dto);
	public ScoreDTO scoreView(String studNo);
	public List<ScoreDTO> scoreList(int startNum, int endNum);
	public int scoreCount();
}
