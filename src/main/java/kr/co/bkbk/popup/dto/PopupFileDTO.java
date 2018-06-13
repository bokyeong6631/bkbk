package kr.co.bkbk.popup.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PopupFileDTO {
	
	private int fileSize = 0;
	
	private Integer popupFileId = null;
	private Integer popupId = null;
	
	private String orgFileName = null;
	private String newFileName = null;
	private String fileType = null;
	private String filePath = null;
	private String fileExt = null;
	
	private Date regDt;
	
}
