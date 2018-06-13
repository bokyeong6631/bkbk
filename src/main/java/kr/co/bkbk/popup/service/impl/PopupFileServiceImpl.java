package kr.co.bkbk.popup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bkbk.popup.dao.IPopupFileDAO;
import kr.co.bkbk.popup.dto.PopupFileDTO;
import kr.co.bkbk.popup.service.IPopupFileService;

@Service
public class PopupFileServiceImpl implements IPopupFileService {
	
	@Autowired private IPopupFileDAO popupFileDAOImpl = null;

	@Override
	public void write(PopupFileDTO popupFileDTO) {
		popupFileDAOImpl.insertData(popupFileDTO);
	}

	@Override
	public PopupFileDTO view(int popupId) {
		
		return popupFileDAOImpl.selectOne(popupId);
	}

	@Override
	public List<PopupFileDTO> list() {
		return popupFileDAOImpl.selectList();
	}
	
	
	
	

}
