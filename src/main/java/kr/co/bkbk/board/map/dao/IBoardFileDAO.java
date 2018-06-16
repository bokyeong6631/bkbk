package kr.co.bkbk.board.map.dao;

import java.util.List;

import kr.co.bkbk.board.map.dto.BoardFileDTO;

public interface IBoardFileDAO {
	public void insertData(BoardFileDTO boardFileDTO);
	public List<BoardFileDTO> selectList(Integer docId);
	public void deleteData(Integer docId);
	
	public BoardFileDTO selectOne(BoardFileDTO boardFileDTO);
	public Integer selectByCntDocId(Integer docId);
	public void deleteOnlyFile(BoardFileDTO boardFileDTO);
}
