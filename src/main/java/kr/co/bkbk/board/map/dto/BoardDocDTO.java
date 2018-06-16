package kr.co.bkbk.board.map.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class BoardDocDTO {
	private Integer docId = 0;
	private Integer userId = 0;
	private Integer mapId = 0;
	private Integer cntRead = 0;//조회수
	private Integer cntFile = 0;//첨부파일 수
	private Integer cntComment = 0;//댓글 수
	
	private String mapName;//user.java6에 맵네임 불러오기
	private String userName = null;
	private String title = null;
	
	private Integer viewerId = null; //조회
	private String likeYn = null;//좋아요여부
	private String likeId = null;//좋아요아이디
	private Integer cntLikeY = 0; //좋아요 개수
	private Integer cntLikeN = 0; //싫어요 개수
	
	private String lockPw = null;//비밀글 비밀번호
	private String lockYn;//비밀글 설정
	private String boardContents;
	
	private Date regDt;
	
	private List<BoardLikeDTO> likeList = null;
	private List<MultipartFile> files = null; //첨부파일 변수이름은 write에서 첨부파일 input attr name과 같아야한다.
	private List<BoardFileDTO> fileList = null;
	private List<BoardCommentDTO> commentList = null;
	
}
