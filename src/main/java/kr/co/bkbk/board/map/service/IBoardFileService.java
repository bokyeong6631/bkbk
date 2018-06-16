package kr.co.bkbk.board.map.service;

import java.util.List;

import kr.co.bkbk.board.map.dto.BoardFileDTO;

public interface IBoardFileService {
	public void write(BoardFileDTO boardFileDTO);
	public List<BoardFileDTO> list(Integer docId);
	public void remove(Integer docId);
	
	public BoardFileDTO view(BoardFileDTO boardFileDTO);
	public Integer viewByCntDocId(Integer docId);
	public void removeOnlyFile(BoardFileDTO boardFileDTO);
}
