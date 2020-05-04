package cf.garageon.app.DAO;

import java.util.List;

import cf.garageon.app.VO.BoardVO;
import cf.garageon.app.VO.ItemVO;
import cf.garageon.app.VO.QnABoardVO;
import cf.garageon.app.VO.SearchCriteria;

public interface ItemDAO {
	
	//상품 구매 리스트
	public List<ItemVO> item_list(SearchCriteria scri) throws Exception;

	//상품등록
	public void item_write(ItemVO vo) throws Exception;
	//상세페이지
	public ItemVO item_read(int item_Number) throws Exception;
	
    public void item_modify(ItemVO vo) throws Exception;
	
	public void item_delete(int item_Number) throws Exception;
	
	public int listCount() throws Exception;
}
