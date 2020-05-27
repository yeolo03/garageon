package cf.garageon.app.DAO;

import java.util.List;
import java.util.Map;

import cf.garageon.app.VO.BoardVO;
import cf.garageon.app.VO.Criteria;
import cf.garageon.app.VO.SearchCriteria;




public interface BoardDAO {

	public void write(BoardVO boardVO) throws Exception;
	
	public List<BoardVO> list(SearchCriteria scri) throws Exception;
	
	public BoardVO read(int bno) throws Exception;
	
	public int listCount(SearchCriteria scri) throws Exception;
	
	public void modify(BoardVO boardVO) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public void upHit(int bno) throws Exception;
	
	/*
	//첨부파일 업로드
	public void insertFile(Map<String, Object> map) throws Exception;
	//첨부파일 조회
	public List<Map<String,Object>> selectFileList(int bno) throws Exception;
	//첨부파일 다운로드
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
	
	//첨부파일 수정
	public void updateFile(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> getByteImage();
	
	public void saveImage(Map<String, Object> hmap);

	*/
	
}
