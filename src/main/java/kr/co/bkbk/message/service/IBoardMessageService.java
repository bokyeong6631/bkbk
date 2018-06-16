package kr.co.bkbk.message.service;

import java.util.List;

import kr.co.bkbk.message.dto.BoardMessageDTO;

public interface IBoardMessageService {
	
	public void write(BoardMessageDTO boardMessageDTO);
	public List<BoardMessageDTO> list(Integer userId);
	public void remove(Integer sMessageId);

}
