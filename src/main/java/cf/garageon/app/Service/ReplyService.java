package cf.garageon.app.Service;

import java.util.List;

import cf.garageon.app.VO.ReplyVO;

public interface ReplyService {

	
	public List<ReplyVO> readReply(int bno) throws Exception;
	
    public void updateReply(ReplyVO vo) throws Exception;
	
	public ReplyVO selectReply(int rno) throws Exception;
	
	public void deleteReply(ReplyVO vo) throws Exception;
	
	public void writeReply(ReplyVO vo) throws Exception;
	
	public int countReply() throws Exception;
}
