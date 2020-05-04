package cf.garageon.app.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import cf.garageon.app.VO.Criteria;
import cf.garageon.app.VO.NoticeBoardVO;
import cf.garageon.app.VO.SearchCriteria;

@Repository
public class NoticeImpl implements NoticeDAO{

	@Inject SqlSession sqlSession;

	@Override
	public List<NoticeBoardVO> notice_list(SearchCriteria scri) throws Exception{
		// TODO Auto-generated method stub
		return sqlSession.selectList("Noticemapper.listNotice",scri);
	}

	@Override
	public void notice_write(NoticeBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("Noticemapper.writeNotice",vo);
	}

	@Override
	public NoticeBoardVO notice_read(int notice_Number) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Noticemapper.readNotice",notice_Number);
	}

	@Override
	public void notice_modify(NoticeBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("Noticemapper.modifyNotice",vo);
	}

	@Override
	public void notice_delete(int notice_Number) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("Noticemapper.deleteNotice",notice_Number);
	}

	@Override
	public void uphit(int notice_Number) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("Noticemapper.uphit",notice_Number);
	}

	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Noticemapper.listCount");
	}
}
