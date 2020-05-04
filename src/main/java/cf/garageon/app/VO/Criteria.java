package cf.garageon.app.VO;

public class Criteria {
	private int page;//게시글
	private int perPageNum;//한 페이지에 몇개 게시글수를 보여줄지
	private int rowStart;
	private int rowEnd;
	
	public Criteria() {
		
		this.page=1;
		this.perPageNum=10;//한페이지내에 몇개의 게시글을 보여줄지 
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		
		if(page<=0) {//게시글이 아예없다면
			
			this.page = 1;//처음 페이징의 페이지는 1이다
			return;
			}
			this.page=page;
		
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0 || perPageNum>100) {
			this.perPageNum=10;
			return;
			}
		this.perPageNum = perPageNum;
	}
	public int getRowStart() {
		rowStart = ((page - 1) * perPageNum) + 1;
		return rowStart;
	}
	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}
	public int getRowEnd() {
		rowEnd = rowStart + perPageNum - 1;
		return rowEnd;
	}
	public void setRowEnd(int rowEnd) {
		this.rowEnd = rowEnd;
	}
	public int getPageStart() {//페이지 2번의 처음 (2-1)*10=11번 글이 처음 나오게 작성 *특정페이지의 게시글 시작번호,게시글 시작행 번호
		return (this.page - 1) * perPageNum;
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
				+ "]";
	}

	
}
