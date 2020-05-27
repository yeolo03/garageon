package cf.garageon.app.Service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cf.garageon.app.DAO.BoardDAO;
import cf.garageon.app.util.FileUtils;
import cf.garageon.app.VO.BoardVO;
import cf.garageon.app.VO.Criteria;
import cf.garageon.app.VO.SearchCriteria;



@Service
public class BoardServiceImpl implements BoardService{

	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	@Inject 
	private  BoardDAO dao;
	
	// 게시글 작성
		@Override
		public void write(BoardVO boardVO,MultipartHttpServletRequest mul) throws Exception {
			dao.write(boardVO);
			/*
			List<Map<String,Object>> list= fileUtils.parseInsertFileInfo(boardVO, mul);
			int size=list.size();
			for(int i=0;i<size;i++) {
				dao.insertFile(list.get(i));
			
			}*/
			
		}

	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(scri);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.upHit(bno);
		return dao.read(bno);
	}

	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCount(scri);
	}
	/*
	@Override
	public void modify(BoardVO boardVO, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception {
		// TODO Auto-generated method stub
		dao.modify(boardVO);
		
		List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(boardVO, files, fileNames, mpRequest);
		Map<String, Object> tempMap = null;
		int size = list.size();
		for(int i = 0; i<size; i++) {
			tempMap = list.get(i);
			if(tempMap.get("IS_NEW").equals("Y")) {
				dao.insertFile(tempMap);
			}else {
				dao.updateFile(tempMap);	
			}
		}
	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}

	@Override
	public void upHit(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.upHit(bno);
	}
     //파일 조회
	@Override
	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFileList(bno);
	}

	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFileInfo(map);
	}

	@Override
	public Map<String, Object> getByteImage() {
		// TODO Auto-generated method stub
		return dao.getByteImage();
	}
*/

	@Override
	public void modify(BoardVO boardVO, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upHit(int bno) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
  

}
