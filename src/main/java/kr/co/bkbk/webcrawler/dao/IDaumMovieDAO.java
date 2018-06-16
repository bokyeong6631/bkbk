package kr.co.bkbk.webcrawler.dao;

import java.util.List;

import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.webcrawler.dto.DaumMovieDTO;

public interface IDaumMovieDAO {
	
	public void insertData(DaumMovieDTO dmDTO);
	public List<DaumMovieDTO> selectList(BoardSearchDTO search);
	public int selectCount(BoardSearchDTO search);

}
