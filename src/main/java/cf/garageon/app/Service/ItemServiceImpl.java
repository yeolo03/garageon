package cf.garageon.app.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cf.garageon.app.DAO.ItemDAO;
import cf.garageon.app.VO.ItemVO;
import cf.garageon.app.VO.SearchCriteria;

@Service
public class ItemServiceImpl implements ItemService{

	@Inject 
	ItemDAO dao;
	@Override
	public List<ItemVO> item_list(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return dao.item_list(scri);
	}
	@Override
	public void item_write(ItemVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.item_write(vo);
	}
	@Override
	public ItemVO item_read(int item_Number) throws Exception {
		// TODO Auto-generated method stub
		return dao.item_read(item_Number);
	}
	@Override
	public void item_modify(ItemVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.item_modify(vo);
	}
	@Override
	public void item_delete(int item_Number) throws Exception {
		// TODO Auto-generated method stub
		dao.item_delete(item_Number);
	}
	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.listCount();
	}

}
