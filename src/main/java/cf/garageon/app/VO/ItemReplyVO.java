package cf.garageon.app.VO;

import java.sql.Timestamp;

public class ItemReplyVO {
	private int item_Number;
	private int item_rNumber;
	private String item_Detail;
	private String item_reply_Writer;
	private Timestamp item_reply_Date;
	public int getItem_Number() {
		return item_Number;
	}
	public void setItem_Number(int item_Number) {
		this.item_Number = item_Number;
	}
	public int getItem_rNumber() {
		return item_rNumber;
	}
	public void setItem_rNumber(int item_rNumber) {
		this.item_rNumber = item_rNumber;
	}
	public String getItem_Detail() {
		return item_Detail;
	}
	public void setItem_Detail(String item_Detail) {
		this.item_Detail = item_Detail;
	}
	public String getItem_reply_Writer() {
		return item_reply_Writer;
	}
	public void setItem_reply_Writer(String item_reply_Writer) {
		this.item_reply_Writer = item_reply_Writer;
	}
	public Timestamp getItem_reply_Date() {
		return item_reply_Date;
	}
	public void setItem_reply_Date(Timestamp item_reply_Date) {
		this.item_reply_Date = item_reply_Date;
	}
	
	
}
