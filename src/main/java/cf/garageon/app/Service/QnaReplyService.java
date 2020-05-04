package cf.garageon.app.Service;

import java.util.List;

import cf.garageon.app.VO.QnaReplyVO;

public interface QnaReplyService {

	//qna댓글 목록
	public List<QnaReplyVO> readQnaReply(int qna_Numebr) throws Exception;
	
	//qna댓글 쓰기
	public void writeQnaReply(QnaReplyVO vo) throws Exception;
	
	//마이페이지 내 QNA의 글 삭제
	public void deleteQnaReply(QnaReplyVO vo) throws Exception;
		
	//
	public QnaReplyVO selectQnaReply(int qna_rNumber) throws Exception;
	
	public void updateQnaReply(QnaReplyVO vo) throws Exception;
}
