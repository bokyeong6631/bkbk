package kr.co.bkbk.board.map.service;

import java.util.List;

import kr.co.bkbk.board.map.dto.BoardCommentDTO;
import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardSearchDTO;

public interface IBoardCommentService {
	public void write(BoardCommentDTO boardCommentDTO);
	public void remove(Integer commentId);
	
	public List<BoardCommentDTO> list(Integer docId);
	public void removeByDocId(Integer docId);
	
	public List<BoardDocDTO> ViewListAndUserId(BoardSearchDTO search);
	
}
