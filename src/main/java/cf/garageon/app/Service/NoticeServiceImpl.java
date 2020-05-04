package cf.garageon.app.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cf.garageon.app.DAO.NoticeDAO;
import cf.garageon.app.VO.Criteria;
import cf.garageon.app.VO.NoticeBoardVO;
import cf.garageon.app.VO.SearchCriteria;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Inject
	NoticeDAO dao;

	@Override
	public List<NoticeBoardVO> notice_list(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return dao.notice_list(scri);
	}

	@Override
	public void notice_write(NoticeBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.notice_write(vo);
	}

	@Override
	public NoticeBoardVO notice_read(int notice_Number) throws Exception {
		// TODO Auto-generated method stub
		dao.uphit(notice_Number);
		return dao.notice_read(notice_Number);
	}

	@Override
	public void notice_modify(NoticeBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.notice_modify(vo);
	}

	@Override
	public void notice_delete(int notice_Number) throws Exception {
		// TODO Auto-generated method stub
		dao.notice_delete(notice_Number);
	}

	@Override
	public void uphit(int notice_Number) throws Exception {
		// TODO Auto-generated method stub
		dao.uphit(notice_Number);
	}

	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.listCount();
	}
}
