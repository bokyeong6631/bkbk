package kr.co.bkbk.popup.dao;

import java.util.List;

import kr.co.bkbk.popup.dto.PopupDTO;

public interface IPopupDAO {
	
	public void insertData(PopupDTO popupDTO);
	public List<PopupDTO> selectList();
	public PopupDTO selectOne(int popupId);
	public void deleteData(int popupId);

}
