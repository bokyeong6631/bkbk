package kr.co.bkbk.message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bkbk.message.dao.IBoardMessageDAO;
import kr.co.bkbk.message.dto.BoardMessageDTO;
import kr.co.bkbk.message.service.IBoardMessageService;

@Service
public class BoardMessageServiceImpl implements IBoardMessageService {
	
	@Autowired private IBoardMessageDAO boardMessageDAOImpl = null;

	@Override
	public void write(BoardMessageDTO boardMessageDTO) {
		boardMessageDAOImpl.insertData(boardMessageDTO);
	}

	@Override
	public List<BoardMessageDTO> list(Integer userId) {
		return boardMessageDAOImpl.selectList(userId);
	}

	@Override
	public void remove(Integer sMessageId) {
		boardMessageDAOImpl.deleteData(sMessageId);
	}

}
