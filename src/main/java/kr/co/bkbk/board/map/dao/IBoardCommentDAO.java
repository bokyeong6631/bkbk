package kr.co.bkbk.board.map.dao;

import java.util.List;

import kr.co.bkbk.board.map.dto.BoardCommentDTO;
import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardSearchDTO;

public interface IBoardCommentDAO {
	public void insertData(BoardCommentDTO boardCommentDTO);
	public void deleteData(Integer commentId);
	public List<BoardCommentDTO> selectList(Integer docId);
	public void deleteByDocId(Integer docId);
	public List<BoardDocDTO> selectListAndUserId(BoardSearchDTO search);
	public int selectCountByuserId(BoardSearchDTO search);
}
