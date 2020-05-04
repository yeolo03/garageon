package cf.garageon.app.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import cf.garageon.app.VO.ReplyVO;

@Repository
public class ReplyDAOImpl  implements ReplyDAO{

	@Inject
	SqlSession sql;

	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("Replymapper.readReply",bno);
	}

	@Override
	public void updateReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.update("Replymapper.updateReply",vo);
	}

	@Override
	public ReplyVO selectReply(int rno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("Replymapper.selectReply",rno);
	}

	@Override
	public void deleteReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.delete("Replymapper.deleteReply",vo);
	}

	@Override
	public void writeReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert("Replymapper.writeReply",vo);
		
	}

	@Override
	public int countReply() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("Replymapper.countReply");
	}
}
