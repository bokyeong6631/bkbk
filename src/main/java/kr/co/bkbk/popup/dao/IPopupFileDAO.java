package kr.co.bkbk.popup.dao;

import java.util.List;

import kr.co.bkbk.popup.dto.PopupFileDTO;

public interface IPopupFileDAO {
	
	public void insertData(PopupFileDTO popupFileDTO);
	public PopupFileDTO selectOne(int popupId);
	public List<PopupFileDTO> selectList();
	

}
