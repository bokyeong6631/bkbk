package kr.co.bkbk.webcrawler.dto;

import java.util.Date;

import kr.co.bkbk.common.dto.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DaumMovieDTO extends PageDTO {
	private String rno = null;
	private String mwriter = null;
	private String mtitle = null;
	private String mreviews = null;
	private String mscore = null;
	private String mdate = null;
	
	
	private Date regdate;




}
