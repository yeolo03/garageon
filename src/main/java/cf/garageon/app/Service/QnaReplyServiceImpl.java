package cf.garageon.app.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cf.garageon.app.DAO.QnaReplyDAO;
import cf.garageon.app.VO.QnaReplyVO;

@Service
public class QnaReplyServiceImpl implements QnaReplyService{

	@Inject
	private QnaReplyDAO dao;

	@Override
	public List<QnaReplyVO> readQnaReply(int qna_Numebr) throws Exception {
		// TODO Auto-generated method stub
		return dao.readQnaReply(qna_Numebr);
	}

	@Override
	public void writeQnaReply(QnaReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.writeQnaReply(vo);;
	}

	@Override
	public void deleteQnaReply(QnaReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteQnaReply(vo);
	}

	@Override
	public QnaReplyVO selectQnaReply(int qna_rNumber) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectQnaReply(qna_rNumber);
	}

	@Override
	public void updateQnaReply(QnaReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.updateQnaReply(vo);
	}
}
