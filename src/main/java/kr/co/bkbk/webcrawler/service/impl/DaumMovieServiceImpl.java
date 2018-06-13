package kr.co.bkbk.webcrawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.webcrawler.dao.IDaumMovieDAO;
import kr.co.bkbk.webcrawler.dto.DaumMovieDTO;
import kr.co.bkbk.webcrawler.service.IDaumMovieService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class DaumMovieServiceImpl implements IDaumMovieService {
	
	@Autowired private IDaumMovieDAO daumMovieDAOImpl = null;
	private DaumMovieDTO daumMovieDTO;

	@Override
	public void write(DaumMovieDTO dmDTO) {
		daumMovieDAOImpl.insertData(dmDTO);
	}

	@Override
	public List<DaumMovieDTO> list(BoardSearchDTO search) {
		int total = daumMovieDAOImpl.selectCount(search);
		search.setTotal(total);
		search.setRows(5);
		
		log.debug("서비스임플 토탈====>"+total);
		return daumMovieDAOImpl.selectList(search);
	}


}
