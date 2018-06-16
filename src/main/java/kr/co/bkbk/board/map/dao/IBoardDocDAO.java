package kr.co.bkbk.board.map.dao;

import java.util.List;

import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardMapDTO;
import kr.co.bkbk.board.map.dto.BoardSearchDTO;

public interface IBoardDocDAO {
	public void insertData(BoardDocDTO boardDocDTO);
	public void updateDoc(BoardDocDTO boardDocDTO);
	public void deleteData(Integer docId);
	
	public BoardDocDTO selectOne(BoardDocDTO boardDocDTO);
	
	public void updateCntRead(Integer docId);
	
	public List<BoardDocDTO> selectListAndUserId(BoardSearchDTO search);
	
	public int selectCount(BoardSearchDTO boardSearchDTO);
	public List<BoardDocDTO> selectList(BoardSearchDTO boardSearchDTO);
	
	public int selectCountByuserId(BoardSearchDTO boardSearchDTO);
	public List<BoardDocDTO> selectListByuserId(BoardSearchDTO boardSearchDTO);
	
	public List<BoardDocDTO> selectListAll();
	public List<BoardDocDTO> selectListByLikeId(Integer viewerId);
	public BoardDocDTO selectImageBydocId(Integer docId);
}
