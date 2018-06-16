package kr.co.bkbk.board.map.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardMapDTO;
import kr.co.bkbk.board.map.dto.BoardSearchDTO;

public interface IBoardDocService {
	public void write(BoardDocDTO boardDocDTO,HttpSession session);
	public List<BoardDocDTO> list(BoardSearchDTO boardSearchDTO);
	public void editDoc(BoardDocDTO boardDocDTO,HttpSession session);
	public void remove(Integer docId);
	public BoardDocDTO view(BoardDocDTO boardDocDTO);
	public void editCntRead(Integer docId);
	
//	public List<BoardDocDTO> listAndUserId(Integer userId);
	
	public List<BoardDocDTO> viewListByuserId(BoardSearchDTO search);
	
	public List<BoardDocDTO> viewListAll();
	public List<BoardDocDTO> listByLikeId(Integer viewerId);
	public BoardDocDTO viewImageBydocId(Integer docId);
}
