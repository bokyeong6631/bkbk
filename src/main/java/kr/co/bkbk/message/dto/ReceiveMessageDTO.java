package kr.co.bkbk.message.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReceiveMessageDTO {
	
	private Integer rMessageId = null;
	private Integer receiveId = null;
	
	private String title = null;
	private String contents= null;
	private String readYn = null;
	private String sapmYn = null;
	private String spamMemo = null;
	
	private Date regDt;
	

}
