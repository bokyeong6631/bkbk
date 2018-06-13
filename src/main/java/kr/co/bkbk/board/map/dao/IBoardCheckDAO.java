package kr.co.bkbk.board.map.dao;

import java.util.List;

import kr.co.bkbk.board.map.dto.BoardCheckDTO;

public interface IBoardCheckDAO {
	
	public void insertData(BoardCheckDTO boardCheckDTO);
	public void deleteData(BoardCheckDTO boardCheckDTO);
	public List<BoardCheckDTO> selectList(Integer userId);
}
