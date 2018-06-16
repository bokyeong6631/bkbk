package kr.co.bkbk.popup.service;

import java.util.List;

import kr.co.bkbk.popup.dto.PopupFileDTO;

public interface IPopupFileService {
	
	public void write(PopupFileDTO popupFileDTO);
	public PopupFileDTO view(int popupId);
	public List<PopupFileDTO> list();
	

}
