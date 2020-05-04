package cf.garageon.app.DAO;

import java.util.List;

import cf.garageon.app.VO.ReplyVO;
import cf.garageon.app.VO.SearchCriteria;

public interface ReplyDAO {

	public List<ReplyVO> readReply(int bno) throws Exception;
	
	public void updateReply(ReplyVO vo) throws Exception;
	
	public ReplyVO selectReply(int rno) throws Exception;
	
	public int countReply() throws Exception;
	
	public void deleteReply(ReplyVO vo) throws Exception;
	
	public void writeReply(ReplyVO vo) throws Exception;
}
