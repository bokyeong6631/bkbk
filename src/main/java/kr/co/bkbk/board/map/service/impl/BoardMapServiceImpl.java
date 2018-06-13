package kr.co.bkbk.board.map.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bkbk.board.map.dao.IBoardMapDAO;
import kr.co.bkbk.board.map.dto.BoardMapDTO;
import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.board.map.service.IBoardMapService;

@Service
public class BoardMapServiceImpl implements IBoardMapService {
	
	@Autowired private IBoardMapDAO boardMapDAO = null;

	@Override
	public List<BoardMapDTO> list() {
		return boardMapDAO.seletList();
	}

	@Override
	public BoardMapDTO view(Integer mapId) {
		// TODO Auto-generated method stub
		return boardMapDAO.selectOne(mapId);
	}



	

}
