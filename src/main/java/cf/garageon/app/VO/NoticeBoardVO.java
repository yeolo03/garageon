package cf.garageon.app.VO;

import java.sql.Timestamp;

public class NoticeBoardVO {
private int notice_Number;
private String notice_Subject;
private String notice_Content;
private Timestamp notice_Date;
private int notice_Readcount;
private String notice_Image;

public String getNotice_Image() {
	return notice_Image;
}
public void setNotice_Image(String notice_Image) {
	this.notice_Image = notice_Image;
}
public int getNotice_Number() {
	return notice_Number;
}
public void setNotice_Number(int notice_Number) {
	this.notice_Number = notice_Number;
}

public String getNotice_Subject() {
	return notice_Subject;
}
public void setNotice_Subject(String notice_Subject) {
	this.notice_Subject = notice_Subject;
}
public String getNotice_Content() {
	return notice_Content;
}
public void setNotice_Content(String notice_Content) {
	this.notice_Content = notice_Content;
}

public Timestamp getNotice_Date() {
	return notice_Date;
}
public void setNotice_Date(Timestamp notice_Date) {
	this.notice_Date = notice_Date;
}
public int getNotice_Readcount() {
	return notice_Readcount;
}
public void setNotice_Readcount(int notice_Readcount) {
	this.notice_Readcount = notice_Readcount;
}


}
