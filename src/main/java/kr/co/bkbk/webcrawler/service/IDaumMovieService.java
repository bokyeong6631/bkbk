package kr.co.bkbk.webcrawler.service;

import java.util.List;

import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.webcrawler.dto.DaumMovieDTO;

public interface IDaumMovieService {
	
	public void write(DaumMovieDTO dmDTO);
	public List<DaumMovieDTO> list(BoardSearchDTO search);
}
