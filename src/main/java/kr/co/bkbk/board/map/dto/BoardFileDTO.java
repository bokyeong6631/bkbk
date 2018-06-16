package kr.co.bkbk.board.map.dto;

import java.util.Date;


import lombok.Data;
@Data
public class BoardFileDTO {
	private Integer docId = null;
	private Integer fileSno = null;
	private long fileSize = 0;
	
	private String orgFileName = null;
	private String newFileName = null;
	private String FileType = null;
	private String FilePath= null;
	private String FileExt = null;
	
	private Date regDt;
}
