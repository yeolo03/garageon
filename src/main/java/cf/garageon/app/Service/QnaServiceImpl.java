package cf.garageon.app.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cf.garageon.app.DAO.QnaDAO;
import cf.garageon.app.VO.QnABoardVO;

@Service
public class QnaServiceImpl implements QnaService {

	@Inject 
	private QnaDAO dao;

	

	@Override
	public void writeQna(QnABoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.writeQna(vo);
		
	}

	@Override
	public List<QnABoardVO> readQna() throws Exception {
		// TODO Auto-generated method stub
		return dao.readQna();
	}

	@Override
	public QnABoardVO read_qna(int qna_Number) throws Exception {
		// TODO Auto-generated method stub
		return dao.read_qna(qna_Number);
	}

	@Override
	public void modify(QnABoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.modify(vo);
	}

	@Override
	public void delete_qna(int qna_Number) throws Exception {
		// TODO Auto-generated method stub
		dao.delete_qna(qna_Number);
	}

	
}
