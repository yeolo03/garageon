package cf.garageon.app.Service;

import java.util.List;

import cf.garageon.app.VO.Criteria;
import cf.garageon.app.VO.NoticeBoardVO;
import cf.garageon.app.VO.SearchCriteria;

public interface NoticeService {

	public List<NoticeBoardVO> notice_list(SearchCriteria scri) throws Exception;
	//공지사항 글 작성
	public void notice_write(NoticeBoardVO vo) throws Exception;
	//공지사항 세부 목록
	public NoticeBoardVO notice_read(int notice_Number) throws Exception;
	//공지사항 수정
	public void notice_modify(NoticeBoardVO vo) throws Exception;
	//공지사항 삭제
	public void notice_delete(int notice_Number) throws Exception;
	//공지사항 조회수
	public void uphit(int notice_Number) throws Exception;
	
	public int listCount() throws Exception;
}
