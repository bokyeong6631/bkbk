package kr.co.bkbk.popup.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PopupDTO {
	
	private int userId = 0;
	private int mapId = 0;
	
	private Integer popupId = null;
	
	private String title= null;
	private String useYn= null;
	private String userName = null;
	
	private List<PopupFileDTO> fileList = null;
	private List<MultipartFile> files = null;
	
	private Date regDt;
	
	

}
