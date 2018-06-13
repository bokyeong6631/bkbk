package kr.co.bkbk.board.map.dto;

import kr.co.bkbk.common.dto.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BoardSearchDTO extends PageDTO{
	
	private String mapNames;
	private Integer userId;
	private Integer mapId;
	private Integer docId;
	private Integer popupId = null;
	private String searchType;
	private String searchText;
	
	private int avg = 0;
	
	public String getParams() {
        StringBuffer sb = new StringBuffer();
        sb.append("mapId="+this.mapId);
        sb.append("&searchType="+this.searchType);
        sb.append("&searchText="+this.searchText);
        sb.append("&page="+this.page);
        return sb.toString();
  }

	

}
