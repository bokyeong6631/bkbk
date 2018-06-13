package kr.co.bkbk.popup.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.bkbk.common.dao.BaseDaoSupport;
import kr.co.bkbk.popup.dao.IPopupFileDAO;
import kr.co.bkbk.popup.dto.PopupFileDTO;

@Repository
public class PopupFileDAOImpl extends BaseDaoSupport implements IPopupFileDAO {

	@Override
	public void insertData(PopupFileDTO popupFileDTO) {
		this.getSqlSession().insert("popupFile.insertData", popupFileDTO);
	}

	@Override
	public PopupFileDTO selectOne(int popupId) {
		return this.getSqlSession().selectOne("popupFile.selectOne", popupId);
	}

	@Override
	public List<PopupFileDTO> selectList() {
		return this.getSqlSession().selectList("popupFile.selectList");
	}

}
