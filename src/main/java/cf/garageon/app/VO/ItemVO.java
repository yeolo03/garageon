package cf.garageon.app.VO;

import java.sql.Timestamp;

public class ItemVO {
	int item_Number;
	String item_Name;
	String item_Writer;
	String item_Price;
	String item_Detail;
	String sales_Contact;
	String sales_Kakaoid;
	String deal_location;
	Timestamp item_Date;
	String item_Sort;
	String item_Thumbimage;
	String item_Image;
	
	
	public String getItem_Thumbimage() {
		return item_Thumbimage;
	}
	public void setItem_Thumbimage(String item_Thumbimage) {
		this.item_Thumbimage = item_Thumbimage;
	}
	public String getItem_Image() {
		return item_Image;
	}
	public void setItem_Image(String item_Image) {
		this.item_Image = item_Image;
	}
	public String getItem_Sort() {
		return item_Sort;
	}
	public void setItem_Sort(String item_Sort) {
		this.item_Sort = item_Sort;
	}
	public int getItem_Number() {
		return item_Number;
	}
	public void setItem_Number(int item_Number) {
		this.item_Number = item_Number;
	}
	public String getItem_Name() {
		return item_Name;
	}
	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}
	public String getItem_Writer() {
		return item_Writer;
	}
	public void setItem_Writer(String item_Writer) {
		this.item_Writer = item_Writer;
	}
	public String getItem_Price() {
		return item_Price;
	}
	public void setItem_Price(String item_Price) {
		this.item_Price = item_Price;
	}
	public String getItem_Detail() {
		return item_Detail;
	}
	public void setItem_Detail(String item_Detail) {
		this.item_Detail = item_Detail;
	}
	public String getSales_Contact() {
		return sales_Contact;
	}
	public void setSales_Contact(String sales_Contact) {
		this.sales_Contact = sales_Contact;
	}
	public String getSales_Kakaoid() {
		return sales_Kakaoid;
	}
	public void setSales_Kakaoid(String sales_Kakaoid) {
		this.sales_Kakaoid = sales_Kakaoid;
	}
	public String getDeal_location() {
		return deal_location;
	}
	public void setDeal_location(String deal_location) {
		this.deal_location = deal_location;
	}
	public Timestamp getItem_Date() {
		return item_Date;
	}
	public void setItem_Date(Timestamp item_Date) {
		this.item_Date = item_Date;
	}
	
	
}
