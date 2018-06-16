package kr.co.bkbk.message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bkbk.message.dao.IReceiveMessageDAO;
import kr.co.bkbk.message.dto.ReceiveMessageDTO;
import kr.co.bkbk.message.service.IReceiveMessageService;

@Service
public class ReceiveMessageServiceImpl implements IReceiveMessageService {
	
	@Autowired private IReceiveMessageDAO receiveMessageDAOImpl = null;

	@Override
	public void write(ReceiveMessageDTO receiveDTO) {
		receiveMessageDAOImpl.insertData(receiveDTO);
	}

	@Override
	public List<ReceiveMessageDTO> list(Integer receiveId) {
		return receiveMessageDAOImpl.selectList(receiveId);
	}

	@Override
	public ReceiveMessageDTO view(Integer rMessageId) {
		return receiveMessageDAOImpl.selectOne(rMessageId);
	}

}
