package kr.co.bkbk.board.map.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bkbk.board.map.dao.IBoardCheckDAO;
import kr.co.bkbk.board.map.dto.BoardCheckDTO;
import kr.co.bkbk.board.map.service.IBoardCheckService;

@Service
public class BoardCheckServiceImpl implements IBoardCheckService {
	
	@Autowired private IBoardCheckDAO boardCheckDAOImpl = null;
	
	@Override
	public void write(BoardCheckDTO boardCheckDTO) {
		boardCheckDAOImpl.insertData(boardCheckDTO);
	}

	@Override
	public void remove(BoardCheckDTO boardCheckDTO) {
		boardCheckDAOImpl.deleteData(boardCheckDTO);
	}

	@Override
	public List<BoardCheckDTO> list(Integer userId) {
		return boardCheckDAOImpl.selectList(userId);
	}

}
