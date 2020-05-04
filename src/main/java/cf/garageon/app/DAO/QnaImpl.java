package cf.garageon.app.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import cf.garageon.app.VO.QnABoardVO;

@Repository
public class QnaImpl implements QnaDAO{
	@Inject
	SqlSession sqlSession;
	
	

	@Override
	public void writeQna(QnABoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("Qnamapper.insertQna",vo);
	}



	@Override
	public List<QnABoardVO> readQna() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Qnamapper.readQna");
	}



	@Override
	public QnABoardVO read_qna(int qna_Number) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Qnamapper.qna_read",qna_Number);
	}



	@Override
	public void modify(QnABoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("Qnamapper.qna_update",vo);
	}



	@Override
	public void delete_qna(int qna_Number) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("Qnamapper.qna_delete",qna_Number);
	}

}
