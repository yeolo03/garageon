package cf.garageon.app.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import cf.garageon.app.VO.QnaReplyVO;

@Repository
public class QnaReplyDAOImpl implements QnaReplyDAO{

	@Inject
	private SqlSession sqlSession;
//댓글 목록
	@Override
	public List<QnaReplyVO> readQnaReply(int qna_Numebr) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ReplyQnamapper.qna_reply",qna_Numebr);
	}
//댓글 작성
	@Override
	public void writeQnaReply(QnaReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("ReplyQnamapper.qna_reply_write",vo);
		
	}
//댓글 삭제
	@Override
	public void deleteQnaReply(QnaReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("ReplyQnamapper.qna_reply_delete",vo);
	}

	//댓글 선택
	@Override
	public QnaReplyVO selectQnaReply(int qna_rNumber) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ReplyQnamapper.qna_reply_select",qna_rNumber);
	}
//댓글 수정
	@Override
	public void updateQnaReply(QnaReplyVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update("ReplyQnamapper.qna_reply_update",vo);
	}
}
