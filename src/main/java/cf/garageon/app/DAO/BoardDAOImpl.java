package cf.garageon.app.DAO;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import cf.garageon.app.VO.BoardVO;
import cf.garageon.app.VO.Criteria;
import cf.garageon.app.VO.SearchCriteria;




@Repository
public class BoardDAOImpl implements BoardDAO{
	@Inject
	SqlSession sqlSession;

	//후기 게시판 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("Boardmapper.insert", boardVO);
	}
	//후기 게시판 목록
	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Boardmapper.list",scri);
	}
	//후기 게시판 조회
	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Boardmapper.read",bno);
	}
	//후기 게시판 총 게시물 수
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Boardmapper.listCount");
	}
	//후기 게시판 수정
	@Override
	public void modify(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("Boardmapper.modify",boardVO);
		
	}
	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("Boardmapper.delete",bno);
	}
	@Override
	public void upHit(int bno) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("Boardmapper.upHit",bno);
	}
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("Boardmapper.insertFile",map);
	}
	@Override
	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Boardmapper.selectFileList", bno);
	}
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Boardmapper.selectFileInfo", map);
	}
	@Override
	public void updateFile(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("Boardmapper.updateFile",map);
	}
	@Override
	public Map<String, Object> getByteImage() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Image.getByteImage");


	}
	/*
	@Override
	public void saveImage(Map<String, Object> hmap) {
		// TODO Auto-generated method stub
		sqlSession.insert("Image.saveImage",hmap);
	}
	
*/
	

	
	

}
	