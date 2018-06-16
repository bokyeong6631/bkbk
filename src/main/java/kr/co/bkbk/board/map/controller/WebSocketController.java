package kr.co.bkbk.board.map.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.board.map.service.IBoardDocService;
import kr.co.bkbk.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class WebSocketController {
	
	@Autowired private IBoardDocService boardDocServiceImpl = null;
	
	@RequestMapping(value="/websocket.java6",method=RequestMethod.GET)
	public void webSocket(@ModelAttribute("search") BoardSearchDTO search
						  ,HttpSession session
						  ,Model model) {
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		model.addAttribute("userDTO", userDTO);
		search.setUserId(userDTO.getUserId());
		log.debug("userDTO=======================>"+userDTO);
		
	}
}
