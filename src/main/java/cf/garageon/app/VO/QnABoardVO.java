package cf.garageon.app.VO;

import java.sql.Timestamp;

public class QnABoardVO {
	
	private int qna_Number;
	private String qna_Writer;
	private String qna_Subject; 
	private String qna_Content;
	private Timestamp qna_Date;
	public int getQna_Number() {
		return qna_Number;
	}
	public void setQna_Number(int qna_Number) {
		this.qna_Number = qna_Number;
	}
	public String getQna_Writer() {
		return qna_Writer;
	}
	public void setQna_Writer(String qna_Writer) {
		this.qna_Writer = qna_Writer;
	}
	public String getQna_Subject() {
		return qna_Subject;
	}
	public void setQna_Subject(String qna_Subject) {
		this.qna_Subject = qna_Subject;
	}
	public String getQna_Content() {
		return qna_Content;
	}
	public void setQna_Content(String qna_Content) {
		this.qna_Content = qna_Content;
	}
	public Timestamp getQna_Date() {
		return qna_Date;
	}
	public void setQna_Date(Timestamp qna_Date) {
		this.qna_Date = qna_Date;
	}
	
	
}
