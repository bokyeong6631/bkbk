package kr.co.bkbk.popup.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.bkbk.popup.dto.PopupDTO;

public interface IPopupService {
	public void write(PopupDTO popupDTO, HttpSession session);
	public List<PopupDTO> list();
	public PopupDTO view(int popupId);
	public void remove(int popupId);
	
}
