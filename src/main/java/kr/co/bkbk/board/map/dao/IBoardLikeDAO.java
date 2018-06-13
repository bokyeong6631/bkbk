package kr.co.bkbk.board.map.dao;

import java.util.List;

import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardLikeDTO;

public interface IBoardLikeDAO {
	
	public void insertData(BoardLikeDTO boardLikeDTO);
	public void deleteData(Integer likeId);
	public List<BoardLikeDTO> selectList(Integer docId);
	public void deleteDoc(Integer docId);

}
