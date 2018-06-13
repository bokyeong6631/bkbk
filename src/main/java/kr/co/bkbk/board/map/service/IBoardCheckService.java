package kr.co.bkbk.board.map.service;

import java.util.List;

import kr.co.bkbk.board.map.dto.BoardCheckDTO;

public interface IBoardCheckService {
	public void write(BoardCheckDTO boardCheckDTO);
	public void remove(BoardCheckDTO boardCheckDTO);
	public List<BoardCheckDTO> list(Integer userId);
}
