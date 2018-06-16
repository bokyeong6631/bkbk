package kr.co.bkbk.board.map.service;

import java.util.List;

import kr.co.bkbk.board.map.dto.BoardLikeDTO;

public interface IBoardLikeService {

	public void write(BoardLikeDTO boardLikeDTO);
	public void remove(Integer likeId);
	public List<BoardLikeDTO> list(Integer docId);
	public void removeDoc(Integer docId);
}
