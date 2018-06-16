package kr.co.bkbk.message.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.bkbk.message.dto.BoardMessageDTO;
import kr.co.bkbk.message.dto.ReceiveMessageDTO;
import kr.co.bkbk.message.service.IBoardMessageService;
import kr.co.bkbk.message.service.IReceiveMessageService;
import kr.co.bkbk.user.dto.UserDTO;
import kr.co.bkbk.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/message")
public class BoardMSController {
	
	@Autowired private IUserService userServiceImpl = null;
	@Autowired private IBoardMessageService boardMessageServiceImpl = null;
	@Autowired private IReceiveMessageService receiveMessageServiceImpl = null;
	
	//받은 메세지함
	@RequestMapping(value="/receivelist.java6",method=RequestMethod.GET)
	public void receivelist(HttpSession session, Model model, ReceiveMessageDTO receiveDTO) {
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		List<ReceiveMessageDTO> list = receiveMessageServiceImpl.list(receiveDTO.getReceiveId());
		model.addAttribute("list", list);
		model.addAttribute("userDTO", userDTO);
	}
	
	//보낸 메세지함
	@RequestMapping(value="/sendlist.java6",method=RequestMethod.GET)
	public void sendlist(HttpSession session, Model model) {
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		List<BoardMessageDTO> list = boardMessageServiceImpl.list(userDTO.getUserId());
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value="/write.java6",method=RequestMethod.GET)
	public void goWrite() {
		
	}
	
	@RequestMapping(value="/write.java6",method=RequestMethod.POST)
	public void doWrite(HttpSession session, BoardMessageDTO boardMessageDTO, ReceiveMessageDTO receiveDTO) {
		UserDTO userDTO = (UserDTO)session.getAttribute("_user");
		boardMessageDTO.setUserId(userDTO.getUserId());
		boardMessageServiceImpl.write(boardMessageDTO);
		receiveDTO.setReceiveId(boardMessageDTO.getReceiveId());
		receiveMessageServiceImpl.write(receiveDTO);
		
	}
	
	@RequestMapping(value="/address.java6",method=RequestMethod.GET)
	public void addressList(Model model) {
		List<UserDTO> userList = userServiceImpl.listAll();
		model.addAttribute("userList", userList);
	}

}
