package cf.garageon.app.DAO;

import java.util.List;

import cf.garageon.app.VO.QnaReplyVO;

public interface QnaReplyDAO {

	//마이페이지 내 QNA 댓글 목록
	public List<QnaReplyVO> readQnaReply(int qna_Numebr) throws Exception;
	
	//마이페이지 내 QNA의 글  작성
	public void writeQnaReply(QnaReplyVO vo) throws Exception;
	
	//마이페이지 내 QNA의 글 삭제
	public void deleteQnaReply(QnaReplyVO vo) throws Exception;
	
	//마이페이지 내 QNA의 댓글 선택
	public QnaReplyVO selectQnaReply(int qna_rNumber) throws Exception;
	
	//마이페이지 내 QNA의 글 수정
	public void updateQnaReply(QnaReplyVO vo) throws Exception;
	
}
