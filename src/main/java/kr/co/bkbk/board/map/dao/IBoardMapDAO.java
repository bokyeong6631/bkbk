package kr.co.bkbk.board.map.dao;

import java.util.List;

import kr.co.bkbk.board.map.dto.BoardMapDTO;

public interface IBoardMapDAO {
	
	public List<BoardMapDTO> seletList();
	public BoardMapDTO selectOne(Integer mapId);
}
