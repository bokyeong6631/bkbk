package kr.co.bkbk.board.map.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.bkbk.board.map.dto.BoardCheckDTO;
import kr.co.bkbk.board.map.service.IBoardCheckService;
import kr.co.bkbk.common.dto.ResponseDTO;
import kr.co.bkbk.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/attendance")
public class checkController {
	
	@Autowired private IBoardCheckService boardCheckServiceImpl = null;
	
	@RequestMapping(value="/check.java6",method=RequestMethod.GET)
	public void attendanceCheck(BoardCheckDTO boardCheckDTO
								,HttpSession session
								,Model model) {
		
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		boardCheckDTO.setUserId(userDTO.getUserId());
		
		List<BoardCheckDTO> list= boardCheckServiceImpl.list(userDTO.getUserId());
		model.addAttribute("list", list);
		log.debug("boardCheckDTO===============>"+boardCheckDTO);
	}
	
	@RequestMapping(value="/write.java6",method=RequestMethod.POST)
	public ResponseDTO write(HttpSession session,BoardCheckDTO boardCheckDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			UserDTO userDTO = (UserDTO) session.getAttribute("_user");
			boardCheckDTO.setUserId(userDTO.getUserId());
			boardCheckServiceImpl.write(boardCheckDTO);
			log.debug("boardCheckDTO===============>"+boardCheckDTO);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return responseDTO;
	}

}
