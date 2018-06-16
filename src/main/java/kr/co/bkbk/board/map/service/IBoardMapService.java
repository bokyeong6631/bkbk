package kr.co.bkbk.board.map.service;

import java.util.List;

import kr.co.bkbk.board.map.dto.BoardMapDTO;
import kr.co.bkbk.board.map.dto.BoardSearchDTO;

public interface IBoardMapService {
	
	public List<BoardMapDTO> list();
	public BoardMapDTO view(Integer mapId);
	
}
