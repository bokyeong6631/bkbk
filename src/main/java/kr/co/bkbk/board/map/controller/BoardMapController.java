package kr.co.bkbk.board.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.bkbk.board.map.dto.BoardMapDTO;
import kr.co.bkbk.board.map.service.IBoardMapService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/map/")
public class BoardMapController {
	
	@Autowired private IBoardMapService boardMapService = null;
	
	@ResponseBody
	@RequestMapping(value="/list.java6", method=RequestMethod.GET)
	public List<BoardMapDTO> list() {
		return boardMapService.list();
	}

}
