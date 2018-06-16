
package kr.co.bkbk.popup.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.bkbk.board.map.dto.BoardSearchDTO;
import kr.co.bkbk.popup.dto.PopupDTO;
import kr.co.bkbk.popup.dto.PopupFileDTO;
import kr.co.bkbk.popup.service.IPopupFileService;
import kr.co.bkbk.popup.service.IPopupService;
import kr.co.bkbk.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/popup")
public class PopupController {
	
	@Autowired private IPopupService popupServiceImpl= null;
	@Autowired private IPopupFileService popupFileServiceImpl = null;
	
	
	@RequestMapping(value="/list.java6", method=RequestMethod.GET)
	public void popupList(int mapId,Model model
			,@ModelAttribute("search") BoardSearchDTO search
			,HttpSession session
			,PopupDTO popupDTO) {
		
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		model.addAttribute("userDTO", userDTO);
		
		model.addAttribute("mapId",search.getMapId());
		
		List<PopupDTO> list = popupServiceImpl.list();
		model.addAttribute("list", list);
		log.debug("list==========>"+list);
		
		
		//첨부파일
		List<PopupFileDTO> fileList = popupDTO.getFileList();
		model.addAttribute("fileList",fileList);
		
		log.debug("fileList ============>"+fileList);
		
	}
	
	@RequestMapping(value="/write.java6",method=RequestMethod.GET)
	public void gowrite(PopupDTO popupDTO
			,@ModelAttribute("search") BoardSearchDTO search) {
		
	}
	
	@RequestMapping(value="/write.java6",method=RequestMethod.POST)
	public String dowrite(PopupDTO popupDTO
						,Model model
						,HttpSession session
						,@ModelAttribute("search") BoardSearchDTO search) {
		UserDTO userDTO = (UserDTO) session.getAttribute("_user");
		popupDTO.setUserId(userDTO.getUserId());
		
		popupServiceImpl.write(popupDTO, session);
		log.debug("popupDTO==================>"+popupDTO);
		return "redirect:./list.java6?mapId="+search.getMapId();
		
	}
	@RequestMapping(value="/view.java6",method=RequestMethod.GET)
	public void view(PopupDTO popupDTO
					,int popupId
					,Model model
					,@ModelAttribute("search")BoardSearchDTO search) {
		popupDTO = popupServiceImpl.view(popupId);
		model.addAttribute("view", popupDTO);
		
		//첨부파일
		List<PopupFileDTO> fileList = popupDTO.getFileList();
		model.addAttribute("fileList",fileList);
		log.debug("fileList========>"+fileList);
		
	}
	@RequestMapping(value="/remove.java6",method=RequestMethod.GET)
	public void remove(@ModelAttribute("popupId") int popupId) {
		popupServiceImpl.remove(popupId);
	}
	
	//로그인창에 보여주는 팝업
	@RequestMapping(value="/openPopup.java6",method=RequestMethod.GET)
	public void openPopup(Model model,PopupDTO popupDTO) {
		
		List<PopupDTO> list = popupServiceImpl.list();
		model.addAttribute("list", list);
		log.debug("openPopup===================================================>"+popupDTO);
		
	}

}
