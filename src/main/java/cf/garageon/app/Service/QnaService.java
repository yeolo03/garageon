package cf.garageon.app.Service;

import java.util.List;

import cf.garageon.app.VO.QnABoardVO;

public interface QnaService {

	public List<QnABoardVO> readQna() throws Exception;
	
	//QnA 작성
		public void writeQna(QnABoardVO vo) throws Exception;
		
		public QnABoardVO read_qna(int qna_Number) throws Exception;
		
		public void modify(QnABoardVO vo) throws Exception;
		
		public void delete_qna(int qna_Number) throws Exception;
}
