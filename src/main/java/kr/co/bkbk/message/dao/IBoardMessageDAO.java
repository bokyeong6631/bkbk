package kr.co.bkbk.message.dao;

import java.util.List;

import kr.co.bkbk.message.dto.BoardMessageDTO;

public interface IBoardMessageDAO {
	
	public void insertData(BoardMessageDTO boardMessageDTO);
	public List<BoardMessageDTO> selectList(Integer userId);
	public void deleteData(Integer sMessageId);

}
