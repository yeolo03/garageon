package cf.garageon.app.VO;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String review_Email;
	private String review_Password;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private Timestamp regdate;
	private int readCount;
	private String review_Image;
	
public BoardVO() {
		
	}
	public BoardVO(int bno,String title,String content,String writer, String review_Email,String review_Password,Timestamp regdate,int readCount,String review_Image) {
		
		this.bno=bno;
		this.title=title;
		this.content=content;
		this.writer=writer;
		this.review_Email=review_Email;
		this.review_Password=review_Password;
		this.regdate=regdate;
		this.readCount=readCount;
		this.review_Image=review_Image;
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getReview_Email() {
		return review_Email;
	}
	public void setReview_Email(String review_Email) {
		this.review_Email = review_Email;
	}
	public String getReview_Password() {
		return review_Password;
	}
	public void setReview_Password(String review_Password) {
		this.review_Password = review_Password;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getReview_Image() {
		return review_Image;
	}
	public void setReview_Image(String review_Image) {
		this.review_Image = review_Image;
	}
	
	
}
