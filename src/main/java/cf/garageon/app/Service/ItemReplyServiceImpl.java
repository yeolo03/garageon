package cf.garageon.app.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cf.garageon.app.DAO.ItemReplyDAO;
import cf.garageon.app.VO.ItemReplyVO;

@Service
public class ItemReplyServiceImpl implements ItemReplyService{

	@Inject
	ItemReplyDAO dao;

	@Override
	public List<ItemReplyVO> item_list(int item_Number) throws Exception {
		// TODO Auto-generated method stub
		return dao.item_list(item_Number);
	}

	@Override
	public void item_reply_write(ItemReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.item_reply_write(vo);
		
	}

	@Override
	public void item_reply_delete(ItemReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.item_reply_delete(vo);
	}

	@Override
	public ItemReplyVO item_reply_select(int item_rNumber) throws Exception {
		// TODO Auto-generated method stub
		return dao.item_reply_select(item_rNumber);
	}

	@Override
	public void item_reply_modify(ItemReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.item_reply_modify(vo);
	}
}
