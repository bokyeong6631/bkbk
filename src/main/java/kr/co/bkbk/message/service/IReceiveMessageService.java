package kr.co.bkbk.message.service;

import java.util.List;

import kr.co.bkbk.message.dto.ReceiveMessageDTO;

public interface IReceiveMessageService {
	
	public void write(ReceiveMessageDTO receiveDTO);
	public List<ReceiveMessageDTO> list(Integer receiveId);
	public ReceiveMessageDTO view(Integer rMessageId);


}
