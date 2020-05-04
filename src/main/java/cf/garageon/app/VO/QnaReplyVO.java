package cf.garageon.app.VO;

import java.sql.Timestamp;

public class QnaReplyVO {
	private int qna_Number; 
	private int qna_rNumber;
	private String qna_Name;  
	private String qna_Detail;  
	private Timestamp qna_reply_Date;
	public int getQna_Number() {
		return qna_Number;
	}
	public void setQna_Number(int qna_Number) {
		this.qna_Number = qna_Number;
	}
	public int getQna_rNumber() {
		return qna_rNumber;
	}
	public void setQna_rNumber(int qna_rNumber) {
		this.qna_rNumber = qna_rNumber;
	}
	public String getQna_Name() {
		return qna_Name;
	}
	public void setQna_Name(String qna_Name) {
		this.qna_Name = qna_Name;
	}
	public String getQna_Detail() {
		return qna_Detail;
	}
	public void setQna_Detail(String qna_Detail) {
		this.qna_Detail = qna_Detail;
	}
	public Timestamp getQna_reply_Date() {
		return qna_reply_Date;
	}
	public void setQna_reply_Date(Timestamp qna_reply_Date) {
		this.qna_reply_Date = qna_reply_Date;
	}
	
	
	
}
