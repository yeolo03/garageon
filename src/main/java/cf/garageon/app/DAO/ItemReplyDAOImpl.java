package cf.garageon.app.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import cf.garageon.app.VO.ItemReplyVO;
import cf.garageon.app.VO.QnaReplyVO;

@Repository
public class ItemReplyDAOImpl implements ItemReplyDAO{

	@Inject
	SqlSession sqlSession;

	@Override
	public List<ItemReplyVO> item_list(int item_Number) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ItemReplymapper.item_reply",item_Number);
	}

	@Override
	public void item_reply_write(ItemReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("ItemReplymapper.item_reply_write",vo);
	}

	@Override
	public void item_reply_delete(ItemReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("ItemReplymapper.item_reply_delete",vo);
	}

	@Override
	public ItemReplyVO item_reply_select(int item_rNumber) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ItemReplymapper.item_reply_select",item_rNumber);
	}

	@Override
	public void item_reply_modify(ItemReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("ItemReplymapper.item_reply_modify",vo);
	}

	
	
}
