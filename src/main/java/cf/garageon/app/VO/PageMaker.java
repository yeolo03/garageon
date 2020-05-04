package cf.garageon.app.VO;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private int totalCount;//총 게시글 수
	private int startPage;//페이지 시작
	private int endPage;//페이지 끝
	private boolean prev;//맨 앞의 페이지 번호가 1이 아니라면 화면상에 링크를 통해서 이전 페이지를 조회 할 수 있어야한다.(이전글이 있는지 없는지)
	private boolean next;//맨 뒤의 페이지 이후에 더 많은 데이터가 존재하는 경우 이동이 가능하도록 링크를 제공합니다.(다음글이 있는지 없는지)
	private int dispalyPageNumber=10;
	private Criteria cri;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calData();
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDispalyPageNumber() {
		return dispalyPageNumber;
	}
	public void setDispalyPageNumber(int dispalyPageNumber) {
		this.dispalyPageNumber = dispalyPageNumber;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	private void calData() {
		endPage=(int)Math.ceil(cri.getPage()/(double)dispalyPageNumber)*dispalyPageNumber;//페이지 21면 (21/10)*10=마지막페이지는 30
		startPage=(endPage-dispalyPageNumber)+1;//30-10+21 =21이 맨 처음 나오게 됨 21 22 23... 30
		
		int tempEndPage =(int)Math.ceil((totalCount/(double)cri.getPerPageNum()));
		
		if (endPage > tempEndPage) {//마지막페이지가 전체페이지보다 큰경우 처리
			endPage = tempEndPage;
		}
		prev = startPage == 1 ? false : true;//이전버튼 생성 여부=시작페이지번호==1:true:false 이전버튼은 시작페이지 번호가 1이 아니면 생기게 하는 버튼 
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;//다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 갯수 < 총 게시글의 수 ? true: false

		
	}
	public String makeQuery(int page) {
		UriComponents uriComponents =
		UriComponentsBuilder.newInstance()
						    .queryParam("page", page)
							.queryParam("perPageNum", cri.getPerPageNum())
							.build();
		   
		return uriComponents.toUriString();
	}
	public String makeSearch(int page)
	{
	  
	 UriComponents uriComponents =
	            UriComponentsBuilder.newInstance()
	            .queryParam("page", page)
	            .queryParam("perPageNum", cri.getPerPageNum())
	            .queryParam("searchType", ((SearchCriteria)cri).getSearchType())
	            .queryParam("keyword", encoding(((SearchCriteria)cri).getKeyword()))
	            .build(); 
	    return uriComponents.toUriString();  
	}

	

	private String encoding(String keyword) {
		if(keyword == null || keyword.trim().length() == 0) { 
			return "";
		}
		 
		try {
			return URLEncoder.encode(keyword, "UTF-8");
		} catch(UnsupportedEncodingException e) { 
			return ""; 
		}

	}

}
