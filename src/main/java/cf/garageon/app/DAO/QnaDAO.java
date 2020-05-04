package cf.garageon.app.DAO;

import java.util.List;

import cf.garageon.app.VO.QnABoardVO;

public interface QnaDAO {
	
   public List<QnABoardVO> readQna() throws Exception;
	
	//QnA 작성
	public void writeQna(QnABoardVO vo) throws Exception;
	//QnA 작성 후 마이페이지에서 보여주는 곳
	public QnABoardVO read_qna(int qna_Number) throws Exception;
	
    public void modify(QnABoardVO vo) throws Exception;
	
	public void delete_qna(int qna_Number) throws Exception;
}
