package kr.co.bkbk.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.bkbk.board.map.dto.BoardDocDTO;
import kr.co.bkbk.board.map.dto.BoardFileDTO;
import kr.co.bkbk.board.map.service.IBoardDocService;
import kr.co.bkbk.board.map.service.IBoardFileService;
import kr.co.bkbk.common.file.FileService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/file")
public class FileController {
	
	@Autowired private IBoardDocService boardDocServiceImpl = null;
	@Autowired private IBoardFileService boardFileServiceImpl = null;
	@Autowired private FileService fileService = null;
	
	
	@RequestMapping(value="/downloadFile.java6",method=RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, HttpSession session,BoardFileDTO boardFileDTO) {
		
		BoardFileDTO fileDTO = boardFileServiceImpl.view(boardFileDTO);
		fileService.downloadFile(response, session, fileDTO);
	}
	//파일만 삭제
	@ResponseBody
	@RequestMapping(value="/remove.java6", method=RequestMethod.POST)
	public void remove(BoardFileDTO boardFileDTO) {
		boardFileServiceImpl.removeOnlyFile(boardFileDTO);
	}
	
	@RequestMapping(value="/image.java6",method=RequestMethod.GET)
	public void viewImage(Model model, BoardDocDTO boardDocDTO) {
		boardDocDTO = boardDocServiceImpl.viewImageBydocId(boardDocDTO.getDocId());
		log.debug("이걸 또 안봤네 ==================>"+boardDocDTO);
		model.addAttribute("view",boardDocDTO);
		//첨부파일 조회
		List<BoardFileDTO> list = boardDocDTO.getFileList();
		model.addAttribute("list", list);
		log.debug("view의 리스트를 보아봅시다===============>"+list);
	}
	
}
