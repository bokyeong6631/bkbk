package kr.co.bkbk.popup.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.bkbk.common.file.FileService;
import kr.co.bkbk.common.file.PopupFileService;
import kr.co.bkbk.popup.dto.PopupFileDTO;
import kr.co.bkbk.popup.service.IPopupFileService;

@Controller
@RequestMapping("/board/popup")
public class PopupFileController {
	
	@Autowired private IPopupFileService popupFileServiceImpl = null;
	@Autowired private PopupFileService popupfileService = null;
	
	@RequestMapping(value="/downloadfile.java6",method=RequestMethod.GET)
	public void downloadFile(HttpServletResponse response
							,HttpSession session
							,PopupFileDTO popupFileDTO) {
		
		PopupFileDTO fileDTO = popupFileServiceImpl.view(popupFileDTO.getPopupId());
		popupfileService.downloadFile(response, session, fileDTO);
		
	}
	

}
