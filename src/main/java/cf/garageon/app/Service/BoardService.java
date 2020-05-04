package cf.garageon.app.Service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import cf.garageon.app.VO.BoardVO;
import cf.garageon.app.VO.Criteria;
import cf.garageon.app.VO.SearchCriteria;

public interface BoardService {

	// 게시글 작성
		public void write(BoardVO boardVO,MultipartHttpServletRequest mul) throws Exception;
		
		public List<BoardVO> list(SearchCriteria scri) throws Exception;
		
		public BoardVO read(int bno) throws Exception;
		
		public int listCount(SearchCriteria scri) throws Exception;
		
		public void modify(BoardVO boardVO, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception;
		
		public void delete(int bno) throws Exception;
		
		public void upHit(int bno) throws Exception;
		
		//첨부파일 조회
		public List<Map<String,Object>> selectFileList(int bno) throws Exception;
		
		public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
		
		/*
		public Map<String, Object> getByteImage();

*/
		

}
