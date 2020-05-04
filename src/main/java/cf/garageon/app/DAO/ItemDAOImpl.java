package cf.garageon.app.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import cf.garageon.app.VO.ItemVO;
import cf.garageon.app.VO.SearchCriteria;

@Repository
public class ItemDAOImpl implements ItemDAO{

	@Inject 
	SqlSession sqlSession;
	
	@Override
	public List<ItemVO> item_list(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Itemmapper.Item_list",scri);
	}

	@Override
	public void item_write(ItemVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("Itemmapper.Item_write",vo);
	}

	@Override
	public ItemVO item_read(int item_Number) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Itemmapper.Item_read",item_Number);
	}

	@Override
	public void item_modify(ItemVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("Itemmapper.Item_update",vo);
	}

	@Override
	public void item_delete(int item_Number) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("Itemmapper.Item_delete",item_Number);
	}

	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Itemmapper.listCount");
	}

}
