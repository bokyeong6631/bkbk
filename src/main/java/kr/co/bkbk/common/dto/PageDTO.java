package kr.co.bkbk.common.dto;

import lombok.Data;

@Data
public class PageDTO {

	private String path = "/";
	protected int page = 1;
	protected int rows = 10;
	protected int total = 0;
	protected int navi = 10;
	protected int totalPageSize = 0;
	

	public void setTotal(int total) {
		this.total = total;
		totalPageSize = (int)Math.ceil( (double)total / getRows() );
	}

	

}

