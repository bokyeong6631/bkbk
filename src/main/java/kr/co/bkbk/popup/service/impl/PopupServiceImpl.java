package kr.co.bkbk.popup.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.co.bkbk.common.file.FileService;
import kr.co.bkbk.common.file.PopupFileService;
import kr.co.bkbk.popup.dao.IPopupDAO;
import kr.co.bkbk.popup.dto.PopupDTO;
import kr.co.bkbk.popup.dto.PopupFileDTO;
import kr.co.bkbk.popup.service.IPopupFileService;
import kr.co.bkbk.popup.service.IPopupService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class PopupServiceImpl implements IPopupService {

	@Autowired private IPopupDAO popupDAOImpl = null;
	@Autowired private FileService fileService= null;
	@Autowired private IPopupFileService popupFileServiceImpl = null;
	
	
	@Override
	@Transactional
	public void write(PopupDTO popupDTO, HttpSession session) {
		popupDAOImpl.insertData(popupDTO);
		PopupFileDTO popupFileDTO = null;
		try {
			for (MultipartFile file : popupDTO.getFiles()) {
				log.debug("name=====>>" + file.getOriginalFilename());
				log.debug("name=====>>" + file.getSize());

				// 2. 첨부파일 물리적인 디스크에 저장
				popupFileDTO = fileService.uploadSingleImg(file, session);
				log.debug("service write의 popupFileDTO=====>>" + popupFileDTO);
				
				// 3. 첨부파일 DB에
				popupFileDTO.setPopupId(popupDTO.getPopupId());
				log.debug("name=====>>" + popupDTO);
				popupFileServiceImpl.write(popupFileDTO);
				log.debug("name=====>>" + popupFileDTO);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<PopupDTO> list() {
		List<PopupDTO> list = popupDAOImpl.selectList();
		List<PopupFileDTO> fileList = new ArrayList<>();
		for(PopupDTO popupDTO : list) {
			// 첨부파일
			fileList = popupFileServiceImpl.list();
			popupDTO.setFileList(fileList);
		}
		log.debug("list=======================================================>"+list);
		return list;
	}

	@Override
	public PopupDTO view(int popupId) {
		
		PopupDTO popupDTO = popupDAOImpl.selectOne(popupId);
		
		//첨부파일리스트
		List<PopupFileDTO> fileList = popupFileServiceImpl.list();
		popupDTO.setFileList(fileList);
		
		return popupDTO;
	}

	@Override
	public void remove(int popupId) {
		popupDAOImpl.deleteData(popupId);
	}
	


}
