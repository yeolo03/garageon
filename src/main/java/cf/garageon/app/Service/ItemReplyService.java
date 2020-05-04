package cf.garageon.app.Service;

import java.util.List;

import cf.garageon.app.VO.ItemReplyVO;

public interface ItemReplyService {
	public List<ItemReplyVO> item_list(int item_Number) throws Exception;
	//상세페이지 내 댓글 작성
	public void item_reply_write(ItemReplyVO vo) throws Exception;
	
	//마이페이지 내 QNA의 글 삭제
			public void item_reply_delete(ItemReplyVO vo) throws Exception;
			
			//마이페이지 내 QNA의 댓글 선택
			public ItemReplyVO item_reply_select(int item_rNumber) throws Exception;
			
			//마이페이지 내 QNA의 글 수정
			public void item_reply_modify(ItemReplyVO vo) throws Exception;
			
}
